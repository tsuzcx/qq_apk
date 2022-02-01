package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class YtFSM
{
  private static final String TAG = YtFSM.class.getSimpleName();
  private static YtFSM instance;
  private YtFSM.YtFSMUpdateData currentData = new YtFSM.YtFSMUpdateData(this, null);
  private YtFSMBaseState currentState;
  private YtSDKKitFramework.YtSDKKitFrameworkWorkMode currentWorkMode;
  private YtSDKKitFramework.IYtSDKKitFrameworkEventListener eventListener;
  private String firstStateName;
  private boolean isStarted = false;
  private YtSDKKitFramework.YtSDKPlatformContex sdkPlatformContex;
  private Lock stateLock = new ReentrantLock();
  private HashMap<String, YtFSMBaseState> stateMap = new HashMap();
  
  public static void clearInstance()
  {
    try
    {
      if (instance != null) {
        instance = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static YtFSM getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new YtFSM();
      }
      YtFSM localYtFSM = instance;
      return localYtFSM;
    }
    finally {}
  }
  
  public YtSDKKitFramework.YtSDKPlatformContex getContext()
  {
    if (this.sdkPlatformContex == null) {
      this.sdkPlatformContex = new YtSDKKitFramework.YtSDKPlatformContex();
    }
    return this.sdkPlatformContex;
  }
  
  public YtFSMBaseState getStateByName(String paramString)
  {
    if (this.stateMap.containsKey(paramString)) {
      return (YtFSMBaseState)this.stateMap.get(paramString);
    }
    return null;
  }
  
  public YtSDKKitFramework.YtSDKKitFrameworkWorkMode getWorkMode()
  {
    return this.currentWorkMode;
  }
  
  public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject)
  {
    try
    {
      this.stateLock.lock();
      if (this.isStarted)
      {
        YtLogger.d(TAG, "handleevent set current state:" + this.firstStateName);
        this.currentState.handleEvent(paramYtFrameworkFireEventType, paramObject);
      }
      return;
    }
    finally
    {
      this.stateLock.unlock();
    }
  }
  
  public void handlePauseEvent()
  {
    Iterator localIterator = this.stateMap.values().iterator();
    while (localIterator.hasNext()) {
      ((YtFSMBaseState)localIterator.next()).onPause();
    }
  }
  
  public void handleResumeEvent()
  {
    Iterator localIterator = this.stateMap.values().iterator();
    while (localIterator.hasNext()) {
      ((YtFSMBaseState)localIterator.next()).onResume();
    }
  }
  
  public int registerState(YtFSMBaseState paramYtFSMBaseState)
  {
    this.stateMap.put(paramYtFSMBaseState.getStateName(), paramYtFSMBaseState);
    return 0;
  }
  
  public void reset()
  {
    try
    {
      this.stateLock.lock();
      if (this.isStarted != true) {
        break label133;
      }
      Iterator localIterator = this.stateMap.values().iterator();
      while (localIterator.hasNext()) {
        ((YtFSMBaseState)localIterator.next()).reset();
      }
      if (!this.stateMap.containsKey(this.firstStateName)) {
        break label143;
      }
    }
    finally
    {
      this.stateLock.unlock();
    }
    YtLogger.d(TAG, "reset set current state:" + this.firstStateName);
    this.currentState = ((YtFSMBaseState)this.stateMap.get(this.firstStateName));
    this.currentState.enter();
    for (;;)
    {
      label133:
      this.stateLock.unlock();
      return;
      label143:
      YtLogger.e(TAG, "reset failed: " + this.firstStateName + " state is not found");
    }
  }
  
  public void sendFSMEvent(HashMap<String, Object> paramHashMap)
  {
    if (this.eventListener != null)
    {
      this.eventListener.onFrameworkEvent(paramHashMap);
      return;
    }
    YtLogger.e(TAG, "Event listener not init");
  }
  
  public void sendNetworkRequset(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    if (this.eventListener != null)
    {
      sendFSMEvent(new YtFSM.1(this));
      this.eventListener.onNetworkRequestEvent(paramString1, paramString2, paramHashMap, paramIYtSDKKitNetResponseParser);
      return;
    }
    YtLogger.e(TAG, "Event listener not init");
  }
  
  public void setContext(YtSDKKitFramework.YtSDKPlatformContex paramYtSDKPlatformContex)
  {
    this.sdkPlatformContex = paramYtSDKPlatformContex;
  }
  
  public void setEventListener(YtSDKKitFramework.IYtSDKKitFrameworkEventListener paramIYtSDKKitFrameworkEventListener)
  {
    this.eventListener = paramIYtSDKKitFrameworkEventListener;
  }
  
  /* Error */
  public void start(String paramString, YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode)
  {
    // Byte code:
    //   0: getstatic 36	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   3: new 97	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   10: ldc 209
    //   12: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_2
    //   16: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 115	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   25: aload_0
    //   26: getfield 59	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateLock	Ljava/util/concurrent/locks/Lock;
    //   29: invokeinterface 95 1 0
    //   34: aload_0
    //   35: getfield 42	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   38: ifne +82 -> 120
    //   41: aload_0
    //   42: aload_1
    //   43: putfield 106	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   46: aload_0
    //   47: aload_2
    //   48: putfield 88	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentWorkMode	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
    //   51: aload_0
    //   52: iconst_1
    //   53: putfield 42	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   56: aload_0
    //   57: getfield 47	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   60: aload_0
    //   61: getfield 106	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   64: invokevirtual 78	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   67: ifeq +63 -> 130
    //   70: getstatic 36	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   73: new 97	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   80: ldc 214
    //   82: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 115	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 47	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   100: aload_0
    //   101: getfield 106	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   104: invokevirtual 82	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast 84	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState
    //   110: putfield 117	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentState	Lcom/tencent/youtu/sdkkitframework/framework/YtFSMBaseState;
    //   113: aload_0
    //   114: getfield 117	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentState	Lcom/tencent/youtu/sdkkitframework/framework/YtFSMBaseState;
    //   117: invokevirtual 167	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState:enter	()V
    //   120: aload_0
    //   121: getfield 59	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateLock	Ljava/util/concurrent/locks/Lock;
    //   124: invokeinterface 122 1 0
    //   129: return
    //   130: getstatic 36	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   133: new 97	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   140: ldc 216
    //   142: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 218
    //   151: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 175	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: goto -40 -> 120
    //   163: astore_1
    //   164: aload_0
    //   165: getfield 59	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateLock	Ljava/util/concurrent/locks/Lock;
    //   168: invokeinterface 122 1 0
    //   173: aload_1
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	YtFSM
    //   0	175	1	paramString	String
    //   0	175	2	paramYtSDKKitFrameworkWorkMode	YtSDKKitFramework.YtSDKKitFrameworkWorkMode
    // Exception table:
    //   from	to	target	type
    //   25	120	163	finally
    //   130	160	163	finally
  }
  
  public void stop()
  {
    try
    {
      this.stateLock.lock();
      if (this.isStarted == true)
      {
        this.isStarted = false;
        Iterator localIterator = this.stateMap.values().iterator();
        while (localIterator.hasNext()) {
          ((YtFSMBaseState)localIterator.next()).unload();
        }
        this.stateMap.clear();
      }
    }
    finally
    {
      this.stateLock.unlock();
    }
    this.stateLock.unlock();
  }
  
  public int transitNextRound(String paramString)
  {
    if (this.stateMap.containsKey(paramString))
    {
      this.currentState.exit();
      YtLogger.d(TAG, "transitnextround set current state:" + paramString);
      this.currentState = ((YtFSMBaseState)this.stateMap.get(paramString));
      this.currentState.enter();
      return 0;
    }
    YtLogger.e(TAG, "transitnextround faild:" + paramString + " state is not found");
    return -1;
  }
  
  public int transitNow(String paramString)
  {
    if (this.stateMap.containsKey(paramString))
    {
      this.currentState.exit();
      YtLogger.d(TAG, "transitnow set current state:" + paramString);
      this.currentState = ((YtFSMBaseState)this.stateMap.get(paramString));
      this.currentState.enter();
      if (this.currentData != null)
      {
        this.currentState.update(this.currentData.imageData, this.currentData.imageWidth, this.currentData.imageHeight, this.currentData.imageType);
        return 0;
      }
    }
    else
    {
      YtLogger.e(TAG, "transitnow failed:" + paramString + " state is not found");
      return -1;
    }
    return 0;
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      YtLogger.d(TAG, "update isstarted:" + this.isStarted);
      this.stateLock.lock();
      if (this.isStarted)
      {
        this.currentData.imageData = paramArrayOfByte;
        this.currentData.imageWidth = paramInt1;
        this.currentData.imageHeight = paramInt2;
        this.currentData.imageType = paramInt3;
        if (this.currentState != null) {
          this.currentState.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
        }
      }
      return;
    }
    finally
    {
      this.stateLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtFSM
 * JD-Core Version:    0.7.0.1
 */