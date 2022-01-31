package com.tencent.mobileqq.triton.bridge.plugins;

import android.content.Context;
import com.tencent.mobileqq.triton.audio.AudioHandleThread;
import com.tencent.mobileqq.triton.audio.TTAudioPlayerManager;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.utils.ApiUtil;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class AudioPlugin
  extends TTInnerJSAbsPlugin
{
  private static final String AUDIO_OPERATE_PAUSE = "pause";
  private static final String AUDIO_OPERATE_PLAY = "play";
  private static final String AUDIO_OPERATE_SEEK = "seek";
  private static final String AUDIO_OPERATE_STOP = "stop";
  private static final String AUDIO_PROPERTY_AUTOPLAY = "autoplay";
  private static final String AUDIO_PROPERTY_BUFFERED = "buffered";
  private static final String AUDIO_PROPERTY_CURRENTTIME = "currentTime";
  private static final String AUDIO_PROPERTY_DURATIOIN = "duration";
  private static final String AUDIO_PROPERTY_LOOP = "loop";
  private static final String AUDIO_PROPERTY_PAUSED = "paused";
  private static final String AUDIO_PROPERTY_SRC = "src";
  private static final String AUDIO_PROPERTY_STARTTIME = "startTime";
  private static final String AUDIO_PROPERTY_VOLUME = "volume";
  private static final String AUDIO_STATE_CANPLAY = "canplay";
  private static final String AUDIO_STATE_ENDED = "ended";
  private static final String AUDIO_STATE_ERROR = "error";
  private static final String AUDIO_STATE_PAUSE = "pause";
  private static final String AUDIO_STATE_PLAY = "play";
  private static final String AUDIO_STATE_SEEKED = "seeked";
  private static final String AUDIO_STATE_SEEKING = "seeking";
  private static final String AUDIO_STATE_STOP = "stop";
  private static final String AUDIO_STATE_TIMEUPDATE = "timeUpdate";
  private static final String AUDIO_STATE_WAITING = "waiting";
  private static final String TAG = "[audio] AudioPlugin";
  private static boolean mMixWithOther = true;
  private boolean isActivityPaused;
  private TTAudioPlayerManager mAudioPlayerManager;
  public AtomicInteger sId = new AtomicInteger();
  
  public AudioPlugin(TTEngine paramTTEngine)
  {
    super(paramTTEngine);
    getEventMap().addAll(Arrays.asList(new String[] { "createAudioInstance", "setAudioState", "getAudioState", "operateAudio", "destroyAudioInstance", "setInnerAudioOptionQGame", "getAvailableAudioSources" }));
    this.isActivityPaused = false;
    this.mAudioPlayerManager = new TTAudioPlayerManager(paramTTEngine);
  }
  
  private String createAudioInstance(ITTJSRuntime paramITTJSRuntime)
  {
    int i = this.sId.incrementAndGet();
    paramITTJSRuntime = new AudioPlugin.GameAudioStateChangeListener(this, i, paramITTJSRuntime);
    this.mAudioPlayerManager.createAudioContext(i, paramITTJSRuntime);
    paramITTJSRuntime = new JSONObject();
    try
    {
      paramITTJSRuntime.put("audioId", i);
      return ApiUtil.wrapCallbackOk("createAudioInstance", paramITTJSRuntime).toString();
    }
    catch (Throwable paramITTJSRuntime)
    {
      TTLog.e("[audio] AudioPlugin", "createAudioInstance exception:", paramITTJSRuntime);
    }
    return ApiUtil.wrapCallbackFail("createAudioInstance", null).toString();
  }
  
  private String destroyAudioInstance(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("audioId", -1);
      AudioHandleThread.getInstance().post(new AudioPlugin.4(this, i));
      paramString = ApiUtil.wrapCallbackOk("destroyAudioInstance", null).toString();
      return paramString;
    }
    catch (Throwable paramString)
    {
      TTLog.e("[audio] AudioPlugin", "destroyAudioInstance exception:", paramString);
    }
    return ApiUtil.wrapCallbackFail("destroyAudioInstance", null).toString();
  }
  
  private String getAudioState(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("audioId", -1);
      if (i == -1) {
        return ApiUtil.wrapCallbackFail("getAudioState", null, "param error").toString();
      }
      paramString = new JSONObject();
      paramString.put("duration", this.mAudioPlayerManager.getDuration(i));
      paramString.put("currentTime", this.mAudioPlayerManager.getCurPosition(i));
      paramString.put("buffered", this.mAudioPlayerManager.getBuffered(i));
      paramString.put("paused", this.mAudioPlayerManager.getPaused(i));
      paramString.put("startTime", this.mAudioPlayerManager.getStartTime(i));
      paramString.put("autoplay", this.mAudioPlayerManager.getAutoplay(i));
      paramString.put("loop", this.mAudioPlayerManager.getLoop(i));
      paramString = ApiUtil.wrapCallbackOk("getAudioState", paramString).toString();
      return paramString;
    }
    catch (Throwable paramString)
    {
      TTLog.e("[audio] AudioPlugin", "API_GET_AUDIO_STATE exception:", paramString);
    }
    return ApiUtil.wrapCallbackFail("getAudioState", null).toString();
  }
  
  private void getAvailableAudioSources(int paramInt, ITTJSRuntime paramITTJSRuntime)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioSources", Arrays.toString(new String[] { "auto" }));
      callbackJsEventOK(paramITTJSRuntime, "getAvailableAudioSources", localJSONObject, paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TTLog.e("[audio] AudioPlugin", "API_GET_AVAILABLE_AUDIO_SOURCES exception:", localThrowable);
      callbackJsEventFail(paramITTJSRuntime, "getAvailableAudioSources", null, paramInt);
    }
  }
  
  private String operateAudio(String paramString)
  {
    AudioHandleThread.getInstance().post(new AudioPlugin.5(this, paramString));
    return ApiUtil.wrapCallbackOk("operateAudio", null).toString();
  }
  
  private String setAudioState(String paramString)
  {
    AudioHandleThread.getInstance().post(new AudioPlugin.6(this, paramString));
    return ApiUtil.wrapCallbackOk("setAudioState", null).toString();
  }
  
  private void setInnerAudioOption(String paramString, int paramInt, ITTJSRuntime paramITTJSRuntime)
  {
    try
    {
      paramString = new JSONObject(paramString);
      boolean bool1 = paramString.optBoolean("mixWithOther", true);
      boolean bool2 = paramString.optBoolean("obeyMuteSwitch", true);
      this.mAudioPlayerManager.setMixWithOther(bool1);
      this.mAudioPlayerManager.setMusicSwitch(bool2);
      callbackJsEventOK(paramITTJSRuntime, "setInnerAudioOptionQGame", null, paramInt);
      return;
    }
    catch (Throwable paramString)
    {
      TTLog.e("[audio] AudioPlugin", "API_SET_INNER_AUDIO_OPTION exception:", paramString);
      callbackJsEventFail(paramITTJSRuntime, "setInnerAudioOptionQGame", null, paramInt);
    }
  }
  
  public TTAudioPlayerManager getAudioPlayerManager()
  {
    return this.mAudioPlayerManager;
  }
  
  public String handleScriptRequest(String paramString1, String paramString2, int paramInt, ITTJSRuntime paramITTJSRuntime)
  {
    String str = "{}";
    if ("createAudioInstance".equals(paramString1)) {
      paramString2 = createAudioInstance(paramITTJSRuntime);
    }
    do
    {
      return paramString2;
      if ("destroyAudioInstance".equals(paramString1)) {
        return destroyAudioInstance(paramString2);
      }
      if ("operateAudio".equals(paramString1)) {
        return operateAudio(paramString2);
      }
      if ("setAudioState".equals(paramString1)) {
        return setAudioState(paramString2);
      }
      if ("getAudioState".equals(paramString1)) {
        return getAudioState(paramString2);
      }
      if ("setInnerAudioOptionQGame".equals(paramString1))
      {
        setInnerAudioOption(paramString2, paramInt, paramITTJSRuntime);
        return "{}";
      }
      paramString2 = str;
    } while (!"getAvailableAudioSources".equals(paramString1));
    getAvailableAudioSources(paramInt, paramITTJSRuntime);
    return "{}";
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.mAudioPlayerManager.init(paramContext);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AudioHandleThread.getInstance().post(new AudioPlugin.3(this));
  }
  
  public void onPause()
  {
    super.onPause();
    AudioHandleThread.getInstance().post(new AudioPlugin.1(this));
    this.isActivityPaused = true;
  }
  
  public void onResume()
  {
    super.onResume();
    AudioHandleThread.getInstance().post(new AudioPlugin.2(this));
    this.isActivityPaused = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.plugins.AudioPlugin
 * JD-Core Version:    0.7.0.1
 */