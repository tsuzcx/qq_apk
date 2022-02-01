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
      while (this.logDelegate == null) {}
      this.logDelegate.printLog(LogDelegate.Level.ERROR, "WebAudioManager", "createAudioContext error:", localThrowable);
    }
    return localObject;
  }
  
  public JSONObject createBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject;
    if ((AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt1)) == null) {
      localObject = null;
    }
    JSONObject localJSONObject;
    do
    {
      return localObject;
      paramInt1 = AudioNativeManager.createBuffer(paramInt2, paramInt3 * paramInt2 * 2, paramInt4);
      this.audioBufferList.add(Integer.valueOf(paramInt1));
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("bufferId", paramInt1);
        return localJSONObject;
      }
      catch (Throwable localThrowable)
      {
        localObject = localJSONObject;
      }
    } while (this.logDelegate == null);
    this.logDelegate.printLog(LogDelegate.Level.ERROR, "WebAudioManager", "createBuffer error:", localThrowable);
    return localJSONObject;
  }
  
  public JSONObject createBufferSource(int paramInt)
  {
    Object localObject = (AudioContext)this.audioContextHashMap.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      localObject = null;
    }
    JSONObject localJSONObject;
    do
    {
      return localObject;
      paramInt = ((AudioContext)localObject).createBufferSource();
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("channelId", paramInt);
        return localJSONObject;
      }
      catch (Throwable localThrowable)
      {
        localObject = localJSONObject;
      }
    } while (this.logDelegate == null);
    this.logDelegate.printLog(LogDelegate.Level.ERROR, "WebAudioManager", "createBufferSource error:", localThrowable);
    return localJSONObject;
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
    boolean bool = true;
    paramString = new File(paramString);
    if (paramString.exists()) {
      bool = paramString.delete();
    }
    return bool;
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
  
  public boolean loadWebAudioSo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if (this.hasLoadedSo) {
        return true;
      }
      try
      {
        System.load(paramString);
        this.hasLoadedSo = true;
        return true;
      }
      catch (UnsatisfiedLinkError paramString) {}
    } while (this.logDelegate == null);
    this.logDelegate.printLog(LogDelegate.Level.ERROR, "WebAudioManager", "UnsatisfiedLinkError:", paramString);
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
    for (;;)
    {
      Object localObject2;
      try
      {
        if ((this.decodeBufferIdStatusMap != null) && (this.decodeBufferIdStatusMap.containsKey(Integer.valueOf(paramInt2))))
        {
          localObject1 = (WebAudioManager.DecodeAsPlayStatus)this.decodeBufferIdStatusMap.get(Integer.valueOf(paramInt2));
          if ((localObject1 != null) && (this.decodeBufferIdArrayMap != null) && (this.decodeBufferIdArrayMap.containsKey(Integer.valueOf(paramInt2))))
          {
            localObject2 = (ArrayList)this.decodeBufferIdArrayMap.get(Integer.valueOf(paramInt2));
            if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {}
          }
        }
        switch (WebAudioManager.DecodeAsPlayStatus.access$300((WebAudioManager.DecodeAsPlayStatus)localObject1))
        {
        case 3: 
          return new JSONObject();
        }
      }
      finally {}
      Object localObject1 = ((ArrayList)localObject2).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        AudioNativeManager.setQueueBuffer(paramInt1, ((Integer)((Iterator)localObject1).next()).intValue());
      }
      else
      {
        continue;
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          AudioNativeManager.setQueueBuffer(paramInt1, ((Integer)((Iterator)localObject2).next()).intValue());
        }
        WebAudioManager.DecodeAsPlayStatus.access$302(localDecodeAsPlayStatus, 2);
        WebAudioManager.DecodeAsPlayStatus.access$400(localDecodeAsPlayStatus).add(Integer.valueOf(paramInt1));
      }
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
    long l1 = paramInt3 * 1000 - l2;
    if (l1 > 0L)
    {
      TritonAudioThreadPool.getAudioThreadPool().schedule(new WebAudioManager.1(this, paramInt2, paramInt4, paramArgument, paramInt1), l1, TimeUnit.MILLISECONDS);
      if (l1 <= 0L) {
        break label152;
      }
    }
    label152:
    for (l1 = paramInt3 * 1000;; l1 = l2)
    {
      if (paramInt5 > 0) {
        TritonAudioThreadPool.getAudioThreadPool().schedule(new WebAudioManager.2(this, paramInt2), l1 - l2 + paramInt5 * 1000, TimeUnit.MILLISECONDS);
      }
      return new JSONObject();
      AudioNativeManager.play(paramInt2, paramInt4);
      startTimer(paramArgument, paramInt2, paramInt1);
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
      TritonAudioThreadPool.getAudioThreadPool().schedule(new WebAudioManager.4(this, paramInt2), l, TimeUnit.MILLISECONDS);
    }
    for (;;)
    {
      return new JSONObject();
      AudioNativeManager.stopSource(paramInt2);
    }
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
    //   0: iconst_0
    //   1: istore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 202	java/io/File
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 205	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 208	java/io/File:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_2
    //   23: invokevirtual 356	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 208	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_2
    //   33: invokevirtual 356	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 359	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_2
    //   41: invokevirtual 362	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 364	java/io/FileOutputStream
    //   48: dup
    //   49: aload_2
    //   50: iload_3
    //   51: invokespecial 367	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_2
    //   55: aload_2
    //   56: aload_1
    //   57: iconst_0
    //   58: iload 4
    //   60: invokevirtual 371	java/io/FileOutputStream:write	([BII)V
    //   63: aload_2
    //   64: invokevirtual 374	java/io/FileOutputStream:flush	()V
    //   67: aload_2
    //   68: ifnull +7 -> 75
    //   71: aload_2
    //   72: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   75: iconst_1
    //   76: istore_3
    //   77: iload_3
    //   78: ireturn
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_1
    //   82: iload 5
    //   84: istore_3
    //   85: aload_1
    //   86: ifnull -9 -> 77
    //   89: aload_1
    //   90: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_1
    //   96: iconst_0
    //   97: ireturn
    //   98: astore_1
    //   99: aload 6
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull +7 -> 110
    //   106: aload_2
    //   107: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   110: aload_1
    //   111: athrow
    //   112: astore_1
    //   113: iconst_0
    //   114: ireturn
    //   115: astore_2
    //   116: goto -6 -> 110
    //   119: astore_1
    //   120: goto -18 -> 102
    //   123: astore_1
    //   124: aload_2
    //   125: astore_1
    //   126: goto -44 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	WebAudioManager
    //   0	129	1	paramArrayOfByte	byte[]
    //   0	129	2	paramString	String
    //   0	129	3	paramBoolean	boolean
    //   0	129	4	paramInt	int
    //   1	82	5	bool	boolean
    //   4	96	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	40	79	java/io/IOException
    //   40	45	79	java/io/IOException
    //   45	55	79	java/io/IOException
    //   89	93	95	java/io/IOException
    //   15	40	98	finally
    //   40	45	98	finally
    //   45	55	98	finally
    //   71	75	112	java/io/IOException
    //   106	110	115	java/io/IOException
    //   55	67	119	finally
    //   55	67	123	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager
 * JD-Core Version:    0.7.0.1
 */