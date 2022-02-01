package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

public class YtFSM
{
  private static final String TAG = YtFSM.class.getSimpleName();
  private static YtFSM instance;
  private boolean checkUpdateTimerFlag = true;
  private YtFSM.YtFSMUpdateData currentData = new YtFSM.YtFSMUpdateData(this, null);
  private YtFSMBaseState currentState;
  private YtFSM.YtFSMUpdateStrategy currentStrategy = YtFSM.YtFSMUpdateStrategy.CacheStrategy;
  private YtSDKKitFramework.YtSDKKitFrameworkWorkMode currentWorkMode = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
  private YtSDKKitFramework.IYtSDKKitFrameworkEventListener eventListener;
  private long feedTimeMs = 0L;
  private String firstStateName;
  private boolean isStarted = false;
  private boolean needEventHandler = false;
  private YtSDKKitFramework.YtSDKPlatformContext sdkPlatformContex;
  private Lock startStopLock = new ReentrantLock();
  private Lock stateLock = new ReentrantLock();
  private HashMap<String, YtFSMBaseState> stateMap = new HashMap();
  private Thread updateEventHandler;
  private ConcurrentLinkedQueue<YtFSM.YtFSMUpdateData> updateQueue = new ConcurrentLinkedQueue();
  
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
  
  public void cleanUpQueue()
  {
    this.updateQueue.clear();
  }
  
  public YtSDKKitFramework.YtSDKPlatformContext getContext()
  {
    if (this.sdkPlatformContex == null) {
      this.sdkPlatformContex = new YtSDKKitFramework.YtSDKPlatformContext();
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
        YtLogger.d(TAG, "handleevent " + paramYtFrameworkFireEventType + " for all states");
        Iterator localIterator = this.stateMap.values().iterator();
        while (localIterator.hasNext()) {
          ((YtFSMBaseState)localIterator.next()).handleEvent(paramYtFrameworkFireEventType, paramObject);
        }
      }
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
    YtSDKStats.getInstance().registerStateName(paramYtFSMBaseState.getStateSimpleName());
    this.stateMap.put(paramYtFSMBaseState.getStateName(), paramYtFSMBaseState);
    return 0;
  }
  
  public void reset()
  {
    YtLogger.i(TAG, "FSM reset work mode " + this.currentWorkMode);
    try
    {
      this.stateLock.lock();
      if (this.isStarted != true) {
        break label173;
      }
      Iterator localIterator = this.stateMap.values().iterator();
      while (localIterator.hasNext()) {
        ((YtFSMBaseState)localIterator.next()).reset();
      }
      if (!this.stateMap.containsKey(this.firstStateName)) {
        break label183;
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
      this.updateQueue.clear();
      this.checkUpdateTimerFlag = true;
      label173:
      this.stateLock.unlock();
      return;
      label183:
      YtLogger.e(TAG, "reset failed: " + this.firstStateName + " state is not found");
    }
  }
  
  public void sendFSMEvent(HashMap<String, Object> paramHashMap)
  {
    if (this.eventListener != null)
    {
      if (paramHashMap.containsKey("process_action")) {
        YtLogger.d(TAG, "send framework event result: " + paramHashMap.get("process_action") + " errorcode:" + paramHashMap.get("error_code"));
      }
      this.eventListener.onFrameworkEvent(paramHashMap);
      return;
    }
    YtLogger.e(TAG, "Event listener not init");
  }
  
  public void sendNetworkRequest(String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    if (this.eventListener != null)
    {
      sendFSMEvent(new YtFSM.2(this, paramString1));
      this.eventListener.onNetworkRequestEvent(paramString2, paramString3, paramHashMap, paramIYtSDKKitNetResponseParser);
      return;
    }
    YtLogger.e(TAG, "Event listener not init");
  }
  
  public void setContext(YtSDKKitFramework.YtSDKPlatformContext paramYtSDKPlatformContext)
  {
    this.sdkPlatformContex = paramYtSDKPlatformContext;
  }
  
  public void setEventListener(YtSDKKitFramework.IYtSDKKitFrameworkEventListener paramIYtSDKKitFrameworkEventListener)
  {
    this.eventListener = paramIYtSDKKitFrameworkEventListener;
  }
  
  /* Error */
  public void start(String paramString, YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: getstatic 48	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   3: new 161	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 304
    //   13: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_2
    //   17: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 243	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 93	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   30: invokeinterface 159 1 0
    //   35: aload_0
    //   36: getfield 61	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   39: ifne +139 -> 178
    //   42: aload_0
    //   43: aload_1
    //   44: putfield 247	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   47: aload_0
    //   48: aload_2
    //   49: putfield 59	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentWorkMode	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 61	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   57: aload_0
    //   58: iconst_1
    //   59: putfield 63	com/tencent/youtu/sdkkitframework/framework/YtFSM:needEventHandler	Z
    //   62: aload_0
    //   63: iconst_1
    //   64: putfield 74	com/tencent/youtu/sdkkitframework/framework/YtFSM:checkUpdateTimerFlag	Z
    //   67: aload_0
    //   68: getfield 79	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   71: aload_0
    //   72: getfield 247	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   75: invokevirtual 144	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   78: ifeq +110 -> 188
    //   81: getstatic 48	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   84: new 161	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 306
    //   94: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 182	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 79	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   112: aload_0
    //   113: getfield 247	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   116: invokevirtual 148	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   119: checkcast 150	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState
    //   122: putfield 118	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentState	Lcom/tencent/youtu/sdkkitframework/framework/YtFSMBaseState;
    //   125: aload_0
    //   126: getfield 118	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentState	Lcom/tencent/youtu/sdkkitframework/framework/YtFSMBaseState;
    //   129: invokevirtual 252	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState:enter	()V
    //   132: aload_0
    //   133: getfield 98	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   136: invokevirtual 131	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   139: aload_0
    //   140: new 308	java/lang/Thread
    //   143: dup
    //   144: new 310	com/tencent/youtu/sdkkitframework/framework/YtFSM$1
    //   147: dup
    //   148: aload_0
    //   149: iload_3
    //   150: lload 4
    //   152: invokespecial 313	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:<init>	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;IJ)V
    //   155: invokespecial 316	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   158: putfield 318	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   161: aload_0
    //   162: getfield 318	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   165: ldc_w 320
    //   168: invokevirtual 323	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   171: aload_0
    //   172: getfield 318	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   175: invokevirtual 325	java/lang/Thread:start	()V
    //   178: aload_0
    //   179: getfield 93	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   182: invokeinterface 207 1 0
    //   187: return
    //   188: getstatic 48	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   191: new 161	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 327
    //   201: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_1
    //   205: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc_w 329
    //   211: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 259	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: goto -88 -> 132
    //   223: astore_1
    //   224: getstatic 48	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   227: aload_1
    //   228: invokevirtual 332	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   231: invokestatic 259	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload_0
    //   235: getfield 93	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   238: invokeinterface 207 1 0
    //   243: return
    //   244: astore_1
    //   245: aload_0
    //   246: getfield 93	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   249: invokeinterface 207 1 0
    //   254: aload_1
    //   255: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	YtFSM
    //   0	256	1	paramString	String
    //   0	256	2	paramYtSDKKitFrameworkWorkMode	YtSDKKitFramework.YtSDKKitFrameworkWorkMode
    //   0	256	3	paramInt	int
    //   0	256	4	paramLong	long
    // Exception table:
    //   from	to	target	type
    //   26	132	223	java/lang/Exception
    //   132	178	223	java/lang/Exception
    //   188	220	223	java/lang/Exception
    //   26	132	244	finally
    //   132	178	244	finally
    //   188	220	244	finally
    //   224	234	244	finally
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: getstatic 48	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   3: new 161	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 337
    //   13: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 59	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentWorkMode	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
    //   20: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 243	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 93	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   33: invokeinterface 159 1 0
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 63	com/tencent/youtu/sdkkitframework/framework/YtFSM:needEventHandler	Z
    //   43: aload_0
    //   44: getfield 318	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   47: ifnull +20 -> 67
    //   50: aload_0
    //   51: getfield 318	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   54: invokevirtual 340	java/lang/Thread:isAlive	()Z
    //   57: ifeq +10 -> 67
    //   60: aload_0
    //   61: getfield 318	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   64: invokevirtual 343	java/lang/Thread:join	()V
    //   67: aload_0
    //   68: getfield 61	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   71: iconst_1
    //   72: if_icmpne +80 -> 152
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 61	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   80: aload_0
    //   81: getfield 79	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   84: invokevirtual 186	java/util/HashMap:values	()Ljava/util/Collection;
    //   87: invokeinterface 192 1 0
    //   92: astore_1
    //   93: aload_1
    //   94: invokeinterface 198 1 0
    //   99: ifeq +39 -> 138
    //   102: aload_1
    //   103: invokeinterface 202 1 0
    //   108: checkcast 150	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState
    //   111: invokevirtual 346	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState:unload	()V
    //   114: goto -21 -> 93
    //   117: astore_1
    //   118: getstatic 48	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   121: aload_1
    //   122: invokevirtual 347	java/lang/InterruptedException:getLocalizedMessage	()Ljava/lang/String;
    //   125: invokestatic 259	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: getfield 93	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   132: invokeinterface 207 1 0
    //   137: return
    //   138: aload_0
    //   139: getfield 79	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   142: invokevirtual 348	java/util/HashMap:clear	()V
    //   145: aload_0
    //   146: getfield 98	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   149: invokevirtual 131	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   152: aload_0
    //   153: getfield 93	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   156: invokeinterface 207 1 0
    //   161: return
    //   162: astore_1
    //   163: aload_0
    //   164: getfield 93	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   167: invokeinterface 207 1 0
    //   172: aload_1
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	YtFSM
    //   92	11	1	localIterator	Iterator
    //   117	5	1	localInterruptedException	java.lang.InterruptedException
    //   162	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	67	117	java/lang/InterruptedException
    //   67	93	117	java/lang/InterruptedException
    //   93	114	117	java/lang/InterruptedException
    //   138	152	117	java/lang/InterruptedException
    //   29	67	162	finally
    //   67	93	162	finally
    //   93	114	162	finally
    //   118	128	162	finally
    //   138	152	162	finally
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
        this.currentState.update(this.currentData.imageData, this.currentData.imageWidth, this.currentData.imageHeight, this.currentData.imageType, this.currentData.timeStamp);
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
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (this.isStarted)
    {
      YtFSM.YtFSMUpdateData localYtFSMUpdateData = new YtFSM.YtFSMUpdateData(this, null);
      localYtFSMUpdateData.imageData = paramArrayOfByte;
      localYtFSMUpdateData.imageWidth = paramInt1;
      localYtFSMUpdateData.imageHeight = paramInt2;
      localYtFSMUpdateData.imageType = paramInt3;
      localYtFSMUpdateData.timeStamp = paramLong;
      if (this.updateQueue.size() >= 10)
      {
        this.updateQueue.poll();
        YtLogger.w(TAG, "drop frame");
      }
      this.updateQueue.add(localYtFSMUpdateData);
      this.feedTimeMs = System.currentTimeMillis();
    }
  }
  
  public void updateCacheStrategy(YtFSM.YtFSMUpdateStrategy paramYtFSMUpdateStrategy)
  {
    this.currentStrategy = paramYtFSMUpdateStrategy;
  }
  
  public void updateSDKSetting(JSONObject paramJSONObject)
  {
    Iterator localIterator = this.stateMap.values().iterator();
    while (localIterator.hasNext()) {
      ((YtFSMBaseState)localIterator.next()).updateSDKSetting(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtFSM
 * JD-Core Version:    0.7.0.1
 */