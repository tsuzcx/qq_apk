package com.tencent.mobileqq.tritonaudio.webaudio;

import android.text.TextUtils;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import com.tencent.mobileqq.tritonaudio.TritonAudioThreadPool;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class WebAudioManager
{
  public static int SCRIPT_PROCESSOR_AUDIO_NODE_TYPE = 5;
  public static final String TAG = "WebAudioManager";
  private ArrayList<Integer> audioBufferList = new ArrayList();
  private HashMap<Integer, AudioContext> audioContextHashMap = new HashMap();
  private HashMap<Integer, ArrayList<Integer>> decodeBufferIdArrayMap = new HashMap();
  private HashMap<Integer, WebAudioManager.DecodeAsPlayStatus> decodeBufferIdStatusMap = new HashMap();
  private boolean hasLoadedSo = false;
  private LogDelegate logDelegate;
  public AtomicInteger sId = new AtomicInteger();
  private boolean scriptNodeHasStarted = false;
  private HashMap<Integer, Integer> scriptProcessNodeSizeMap = new HashMap();
  
  public WebAudioManager(LogDelegate paramLogDelegate)
  {
    this.logDelegate = paramLogDelegate;
  }
  
  private void startTimer(Argument paramArgument, int paramInt1, int paramInt2)
  {
    paramArgument = new WebAudioManager.3(this, paramInt1, paramInt2, paramArgument);
    TritonAudioThreadPool.getAudioThreadPool().execute(paramArgument);
  }
  
  public void closeAudioContext()
  {
    if (!this.audioContextHashMap.isEmpty())
    {
      AudioNativeManager.closeAudioContext();
      this.audioContextHashMap.clear();
      this.decodeBufferIdArrayMap.clear();
      this.decodeBufferIdStatusMap.clear();
    }
  }
  
  public void closeAudioContext(int paramInt)
  {
    AudioContext localAudioContext = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt));
    if (localAudioContext != null) {
      localAudioContext.stopAllChannels();
    }
    this.audioContextHashMap.remove(Integer.valueOf(paramInt));
  }
  
  public int copyToChannel(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return AudioNativeManager.copyToChannel(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public JSONObject createAudioContext()
  {
    int i = this.sId.incrementAndGet();
    Object localObject = new AudioContext();
    this.audioContextHashMap.put(Integer.valueOf(i), localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("audioId", i);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      LogDelegate localLogDelegate = this.logDelegate;
      if (localLogDelegate != null) {
        localLogDelegate.printLog(LogDelegate.Level.ERROR, "WebAudioManager", "createAudioContext error:", localThrowable);
      }
    }
    return localObject;
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
    catch (Throwable localThrowable)
    {
      LogDelegate localLogDelegate = this.logDelegate;
      if (localLogDelegate != null) {
        localLogDelegate.printLog(LogDelegate.Level.ERROR, "WebAudioManager", "createBuffer error:", localThrowable);
      }
    }
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
    catch (Throwable localThrowable)
    {
      LogDelegate localLogDelegate = this.logDelegate;
      if (localLogDelegate != null) {
        localLogDelegate.printLog(LogDelegate.Level.ERROR, "WebAudioManager", "createBufferSource error:", localThrowable);
      }
    }
    return localObject;
  }
  
  public void createScriptProcessor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 *= paramInt4;
    AudioNativeManager.createScriptProcessorNode(paramInt2, paramInt3, paramInt4);
    this.scriptProcessNodeSizeMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void decodeAudioDataAndReturnBufferIdAsync(int paramInt, byte[] paramArrayOfByte, Argument paramArgument)
  {
    TritonAudioThreadPool.getAudioThreadPool().execute(new WebAudioManager.5(this, paramInt, paramArgument, paramArrayOfByte));
  }
  
  public boolean deleteFile(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.delete();
    }
    return true;
  }
  
  public double getAudioContextCurrentTime(int paramInt)
  {
    if (this.audioContextHashMap.get(Integer.valueOf(paramInt)) != null)
    {
      double d = ((AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt))).getCurrentTime();
      Double.isNaN(d);
      return d / 1000.0D;
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
  
  public boolean loadWebAudioSo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.hasLoadedSo) {
      return true;
    }
    try
    {
      System.load(paramString);
      this.hasLoadedSo = true;
      return true;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      LogDelegate localLogDelegate = this.logDelegate;
      if (localLogDelegate != null) {
        localLogDelegate.printLog(LogDelegate.Level.ERROR, "WebAudioManager", "UnsatisfiedLinkError:", paramString);
      }
    }
    return false;
  }
  
  public void resumeAudioContext()
  {
    if (!this.audioContextHashMap.isEmpty()) {
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
  
  public JSONObject setDecodingQueueBuffer(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.decodeBufferIdStatusMap != null) && (this.decodeBufferIdStatusMap.containsKey(Integer.valueOf(paramInt2))))
      {
        Object localObject1 = (WebAudioManager.DecodeAsPlayStatus)this.decodeBufferIdStatusMap.get(Integer.valueOf(paramInt2));
        if ((localObject1 != null) && (this.decodeBufferIdArrayMap != null) && (this.decodeBufferIdArrayMap.containsKey(Integer.valueOf(paramInt2))))
        {
          Object localObject3 = (ArrayList)this.decodeBufferIdArrayMap.get(Integer.valueOf(paramInt2));
          if ((localObject3 != null) && (!((ArrayList)localObject3).isEmpty()))
          {
            paramInt2 = WebAudioManager.DecodeAsPlayStatus.access$300((WebAudioManager.DecodeAsPlayStatus)localObject1);
            if ((paramInt2 != 1) && (paramInt2 != 2))
            {
              if (paramInt2 == 3) {
                localObject1 = ((ArrayList)localObject3).iterator();
              }
            }
            else {
              while (((Iterator)localObject1).hasNext())
              {
                AudioNativeManager.setQueueBuffer(paramInt1, ((Integer)((Iterator)localObject1).next()).intValue());
                continue;
                localObject3 = ((ArrayList)localObject3).iterator();
                while (((Iterator)localObject3).hasNext()) {
                  AudioNativeManager.setQueueBuffer(paramInt1, ((Integer)((Iterator)localObject3).next()).intValue());
                }
                WebAudioManager.DecodeAsPlayStatus.access$302((WebAudioManager.DecodeAsPlayStatus)localObject1, 2);
                WebAudioManager.DecodeAsPlayStatus.access$400((WebAudioManager.DecodeAsPlayStatus)localObject1).add(Integer.valueOf(paramInt1));
              }
            }
          }
        }
      }
      return new JSONObject();
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
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
  
  public JSONObject sourceStart(Argument paramArgument, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AudioContext localAudioContext = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt1));
    if (localAudioContext == null) {
      return null;
    }
    long l2 = localAudioContext.getCurrentTime();
    long l1 = paramInt3 * 1000;
    long l3 = l1 - l2;
    if (l3 > 0L)
    {
      TritonAudioThreadPool.getAudioThreadPool().schedule(new WebAudioManager.1(this, paramInt2, paramInt4, paramArgument, paramInt1), l3, TimeUnit.MILLISECONDS);
    }
    else
    {
      AudioNativeManager.play(paramInt2, paramInt4);
      startTimer(paramArgument, paramInt2, paramInt1);
    }
    if (l3 <= 0L) {
      l1 = l2;
    }
    if (paramInt5 > 0) {
      TritonAudioThreadPool.getAudioThreadPool().schedule(new WebAudioManager.2(this, paramInt2), l1 - l2 + paramInt5 * 1000, TimeUnit.MILLISECONDS);
    }
    return new JSONObject();
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
      TritonAudioThreadPool.getAudioThreadPool().schedule(new WebAudioManager.4(this, paramInt2), l, TimeUnit.MILLISECONDS);
    } else {
      AudioNativeManager.stopSource(paramInt2);
    }
    return new JSONObject();
  }
  
  public void startAudioProcess(Argument paramArgument, int paramInt)
  {
    paramArgument = new WebAudioManager.6(this, paramArgument, ((Integer)this.scriptProcessNodeSizeMap.get(Integer.valueOf(paramInt))).intValue() * 2 * 60 / 44100);
    TritonAudioThreadPool.getAudioThreadPool().execute(paramArgument);
  }
  
  public void suspendAudioContext()
  {
    if (!this.audioContextHashMap.isEmpty()) {
      AudioNativeManager.suspendAudioContext();
    }
  }
  
  /* Error */
  public boolean writeFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: new 200	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 203	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 5
    //   15: aload_2
    //   16: invokevirtual 206	java/io/File:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_2
    //   23: invokevirtual 360	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 206	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_2
    //   33: invokevirtual 360	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 363	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_2
    //   41: invokevirtual 366	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 368	java/io/FileOutputStream
    //   48: dup
    //   49: aload_2
    //   50: iload_3
    //   51: invokespecial 371	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_2
    //   55: aload_2
    //   56: aload_1
    //   57: iconst_0
    //   58: iload 4
    //   60: invokevirtual 375	java/io/FileOutputStream:write	([BII)V
    //   63: aload_2
    //   64: invokevirtual 378	java/io/FileOutputStream:flush	()V
    //   67: aload_2
    //   68: invokevirtual 381	java/io/FileOutputStream:close	()V
    //   71: iconst_1
    //   72: ireturn
    //   73: astore_1
    //   74: goto +10 -> 84
    //   77: goto +17 -> 94
    //   80: astore_1
    //   81: aload 5
    //   83: astore_2
    //   84: aload_2
    //   85: ifnull +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 381	java/io/FileOutputStream:close	()V
    //   92: aload_1
    //   93: athrow
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 381	java/io/FileOutputStream:close	()V
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_1
    //   105: aload 6
    //   107: astore_2
    //   108: goto -14 -> 94
    //   111: astore_1
    //   112: goto -35 -> 77
    //   115: astore_1
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_2
    //   119: goto -27 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	WebAudioManager
    //   0	122	1	paramArrayOfByte	byte[]
    //   0	122	2	paramString	String
    //   0	122	3	paramBoolean	boolean
    //   0	122	4	paramInt	int
    //   13	69	5	localObject1	Object
    //   10	96	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   55	67	73	finally
    //   15	40	80	finally
    //   40	45	80	finally
    //   45	55	80	finally
    //   15	40	104	java/io/IOException
    //   40	45	104	java/io/IOException
    //   45	55	104	java/io/IOException
    //   55	67	111	java/io/IOException
    //   67	71	115	java/io/IOException
    //   98	102	115	java/io/IOException
    //   88	92	118	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager
 * JD-Core Version:    0.7.0.1
 */