package com.tencent.mobileqq.minigame.jsapi.webaudio;

import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.triton.audio.AudioHandleThread;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class WebAudioManager
{
  public static int SCRIPT_PROCESSOR_AUDIO_NODE_TYPE = 5;
  private static WebAudioManager mInstance;
  private ArrayList<Integer> audioBufferList = new ArrayList();
  private AudioContext audioContext;
  private HashMap<Integer, AudioContext> audioContextHashMap = new HashMap();
  public AtomicInteger sId = new AtomicInteger();
  private boolean scriptNodeHasStarted;
  private HashMap<Integer, Integer> scriptProcessNodeSizeMap = new HashMap();
  
  public static WebAudioManager getInstance()
  {
    if (mInstance == null) {
      mInstance = new WebAudioManager();
    }
    return mInstance;
  }
  
  private void startTimer(JsRuntime paramJsRuntime, int paramInt1, int paramInt2)
  {
    paramJsRuntime = new WebAudioManager.3(this, paramInt1, paramInt2, paramJsRuntime);
    AudioHandleThread.getInstance().post(paramJsRuntime);
  }
  
  public void closeAudioContext(int paramInt)
  {
    AudioContext localAudioContext = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt));
    if (localAudioContext != null) {
      localAudioContext.stopAllChannels();
    }
    this.audioContextHashMap.remove(Integer.valueOf(paramInt));
  }
  
  public void closeAudioContext(ITTEngine paramITTEngine)
  {
    if ((paramITTEngine != null) && (paramITTEngine.getOptionalSoLoadStatus("webAudio")) && (!this.audioContextHashMap.isEmpty()))
    {
      AudioNativeManager.closeAudioContext();
      this.audioContextHashMap.clear();
    }
  }
  
  public int copyToChannel(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return AudioNativeManager.copyToChannel(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public JSONObject createAudioContext(String paramString)
  {
    int i = this.sId.incrementAndGet();
    this.audioContext = new AudioContext();
    this.audioContextHashMap.put(Integer.valueOf(i), this.audioContext);
    paramString = new JSONObject();
    try
    {
      paramString.put("audioId", i);
      return paramString;
    }
    catch (Throwable localThrowable) {}
    return paramString;
  }
  
  public JSONObject createBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt1)) == null) {
      return null;
    }
    paramInt1 = AudioNativeManager.createBuffer(paramInt2, paramInt3 * paramInt2 * 2, paramInt4);
    this.audioBufferList.add(Integer.valueOf(paramInt1));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bufferId", paramInt1);
      return localJSONObject;
    }
    catch (Throwable localThrowable) {}
    return localJSONObject;
  }
  
  public JSONObject createBufferSource(int paramInt)
  {
    Object localObject = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      return null;
    }
    paramInt = ((AudioContext)localObject).createBufferSource();
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("channelId", paramInt);
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return localObject;
  }
  
  public void createScriptProcessor(JsRuntime paramJsRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 *= paramInt4;
    AudioNativeManager.createScriptProcessorNode(paramInt2, paramInt3, paramInt4);
    this.scriptProcessNodeSizeMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  @RequiresApi(api=16)
  public void decodeAudioDataAndReturnBufferIdAsync(int paramInt, byte[] paramArrayOfByte, JsRuntime paramJsRuntime)
  {
    AudioHandleThread.getInstance().post(new WebAudioManager.5(this, paramArrayOfByte, paramInt, paramJsRuntime));
  }
  
  public double getAudioContextCurrentTime(int paramInt)
  {
    if (this.audioContextHashMap.get(Integer.valueOf(paramInt)) != null) {
      return ((AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt))).getCurrentTime() / 1000.0D;
    }
    return -1.0D;
  }
  
  public byte[] getBufferChannelData(int paramInt1, int paramInt2)
  {
    return AudioNativeManager.getBufferChannelData(paramInt1, paramInt2);
  }
  
  public float getCurrentGain(int paramInt1, int paramInt2)
  {
    AudioContext localAudioContext = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt1));
    if (localAudioContext == null) {
      return -1.0F;
    }
    return localAudioContext.getCurrentGain(paramInt2);
  }
  
  public void resumeAudioContext(ITTEngine paramITTEngine)
  {
    if ((paramITTEngine != null) && (paramITTEngine.getOptionalSoLoadStatus("webAudio")) && (!this.audioContextHashMap.isEmpty())) {
      AudioNativeManager.resumeAudioContext();
    }
  }
  
  public void setBufferSourceLoop(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AudioContext localAudioContext = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt1));
    if (localAudioContext == null) {
      return;
    }
    localAudioContext.setBufferSourceLoop(paramInt2, paramBoolean);
  }
  
  public void setCurrentGain(int paramInt1, int paramInt2, double paramDouble)
  {
    AudioContext localAudioContext = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt1));
    if (localAudioContext == null) {
      return;
    }
    localAudioContext.setCurrentGain(paramInt2, paramDouble);
  }
  
  public void setQueueBuffer(int paramInt1, int paramInt2)
  {
    AudioNativeManager.setQueueBuffer(paramInt1, paramInt2);
    if (!this.scriptNodeHasStarted) {
      AudioNativeManager.play(-2, 0.0F);
    }
    this.scriptNodeHasStarted = true;
  }
  
  public JSONObject setSourceBuffer(int paramInt1, int paramInt2)
  {
    AudioNativeManager.bindBufferToSource(paramInt2, paramInt1);
    return new JSONObject();
  }
  
  public JSONObject sourceStart(JsRuntime paramJsRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AudioContext localAudioContext = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt1));
    if (localAudioContext == null) {
      return null;
    }
    long l2 = localAudioContext.getCurrentTime();
    long l1 = paramInt3 * 1000 - l2;
    if (l1 > 0L)
    {
      AudioHandleThread.getInstance().postDelayed(new WebAudioManager.1(this, paramInt2, paramInt4, paramJsRuntime, paramInt1), l1);
      if (l1 <= 0L) {
        break label144;
      }
    }
    label144:
    for (l1 = paramInt3 * 1000;; l1 = l2)
    {
      if (paramInt5 > 0) {
        AudioHandleThread.getInstance().postDelayed(new WebAudioManager.2(this, paramInt2), l1 - l2 + paramInt5 * 1000);
      }
      return new JSONObject();
      AudioNativeManager.play(paramInt2, paramInt4);
      startTimer(paramJsRuntime, paramInt2, paramInt1);
      break;
    }
  }
  
  public JSONObject sourceStop(int paramInt1, int paramInt2, int paramInt3)
  {
    AudioContext localAudioContext = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt1));
    if (localAudioContext == null) {
      return null;
    }
    long l = localAudioContext.getCurrentTime();
    l = paramInt3 * 1000 - l;
    if (l > 0L) {
      AudioHandleThread.getInstance().postDelayed(new WebAudioManager.4(this, paramInt2), l);
    }
    for (;;)
    {
      return new JSONObject();
      AudioNativeManager.stopSource(paramInt2);
    }
  }
  
  public void startAudioProcess(JsRuntime paramJsRuntime, int paramInt)
  {
    paramJsRuntime = new WebAudioManager.6(this, paramJsRuntime, ((Integer)this.scriptProcessNodeSizeMap.get(Integer.valueOf(paramInt))).intValue() * 2 * 60 / 44100);
    AudioHandleThread.getInstance().post(paramJsRuntime);
  }
  
  public void suspendAudioContext(ITTEngine paramITTEngine)
  {
    if ((paramITTEngine != null) && (paramITTEngine.getOptionalSoLoadStatus("webAudio")) && (!this.audioContextHashMap.isEmpty())) {
      AudioNativeManager.suspendAudioContext();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.webaudio.WebAudioManager
 * JD-Core Version:    0.7.0.1
 */