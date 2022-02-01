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
  private static final String TAG = "YtFSM";
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
        Object localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleevent ");
        localStringBuilder.append(paramYtFrameworkFireEventType);
        localStringBuilder.append(" for all states");
        YtLogger.d((String)localObject, localStringBuilder.toString());
        localObject = this.stateMap.values().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((YtFSMBaseState)((Iterator)localObject).next()).handleEvent(paramYtFrameworkFireEventType, paramObject);
        }
      }
      this.stateLock.unlock();
      return;
    }
    finally
    {
      this.stateLock.unlock();
    }
    for (;;)
    {
      throw paramYtFrameworkFireEventType;
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
    Object localObject1 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FSM reset work mode ");
    localStringBuilder.append(this.currentWorkMode);
    YtLogger.i((String)localObject1, localStringBuilder.toString());
    try
    {
      this.stateLock.lock();
      if (this.isStarted == true)
      {
        localObject1 = this.stateMap.values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((YtFSMBaseState)((Iterator)localObject1).next()).reset();
        }
        if (this.stateMap.containsKey(this.firstStateName))
        {
          localObject1 = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("reset set current state:");
          localStringBuilder.append(this.firstStateName);
          YtLogger.d((String)localObject1, localStringBuilder.toString());
          this.currentState = ((YtFSMBaseState)this.stateMap.get(this.firstStateName));
          this.currentState.enter();
        }
        else
        {
          localObject1 = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("reset failed: ");
          localStringBuilder.append(this.firstStateName);
          localStringBuilder.append(" state is not found");
          YtLogger.e((String)localObject1, localStringBuilder.toString());
        }
        this.updateQueue.clear();
        this.checkUpdateTimerFlag = true;
      }
      this.stateLock.unlock();
      return;
    }
    finally
    {
      this.stateLock.unlock();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void sendFSMEvent(HashMap<String, Object> paramHashMap)
  {
    if (this.eventListener != null)
    {
      if (paramHashMap.containsKey("process_action"))
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("send framework event result: ");
        localStringBuilder.append(paramHashMap.get("process_action"));
        localStringBuilder.append(" errorcode:");
        localStringBuilder.append(paramHashMap.get("error_code"));
        YtLogger.d(str, localStringBuilder.toString());
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
    //   0: getstatic 107	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   3: astore 6
    //   5: new 158	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   12: astore 7
    //   14: aload 7
    //   16: ldc_w 301
    //   19: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 7
    //   25: aload_2
    //   26: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 6
    //   32: aload 7
    //   34: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 240	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 87	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   44: invokeinterface 156 1 0
    //   49: aload_0
    //   50: getfield 55	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   53: ifne +201 -> 254
    //   56: aload_0
    //   57: aload_1
    //   58: putfield 244	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   61: aload_0
    //   62: aload_2
    //   63: putfield 53	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentWorkMode	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 55	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   71: aload_0
    //   72: iconst_1
    //   73: putfield 57	com/tencent/youtu/sdkkitframework/framework/YtFSM:needEventHandler	Z
    //   76: aload_0
    //   77: iconst_1
    //   78: putfield 68	com/tencent/youtu/sdkkitframework/framework/YtFSM:checkUpdateTimerFlag	Z
    //   81: aload_0
    //   82: getfield 73	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   85: aload_0
    //   86: getfield 244	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   89: invokevirtual 141	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   92: ifeq +69 -> 161
    //   95: getstatic 107	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   98: astore_2
    //   99: new 158	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   106: astore 6
    //   108: aload 6
    //   110: ldc_w 303
    //   113: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 6
    //   119: aload_1
    //   120: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_2
    //   125: aload 6
    //   127: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 179	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   133: aload_0
    //   134: aload_0
    //   135: getfield 73	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   138: aload_0
    //   139: getfield 244	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   142: invokevirtual 145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   145: checkcast 147	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState
    //   148: putfield 115	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentState	Lcom/tencent/youtu/sdkkitframework/framework/YtFSMBaseState;
    //   151: aload_0
    //   152: getfield 115	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentState	Lcom/tencent/youtu/sdkkitframework/framework/YtFSMBaseState;
    //   155: invokevirtual 249	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState:enter	()V
    //   158: goto +50 -> 208
    //   161: getstatic 107	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   164: astore_2
    //   165: new 158	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   172: astore 6
    //   174: aload 6
    //   176: ldc_w 305
    //   179: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 6
    //   185: aload_1
    //   186: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 6
    //   192: ldc_w 307
    //   195: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_2
    //   200: aload 6
    //   202: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 256	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload_0
    //   209: getfield 92	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   212: invokevirtual 128	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   215: aload_0
    //   216: new 309	java/lang/Thread
    //   219: dup
    //   220: new 311	com/tencent/youtu/sdkkitframework/framework/YtFSM$1
    //   223: dup
    //   224: aload_0
    //   225: iload_3
    //   226: lload 4
    //   228: invokespecial 314	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:<init>	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;IJ)V
    //   231: invokespecial 317	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   234: putfield 319	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   237: aload_0
    //   238: getfield 319	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   241: ldc_w 321
    //   244: invokevirtual 324	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   247: aload_0
    //   248: getfield 319	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   251: invokevirtual 326	java/lang/Thread:start	()V
    //   254: aload_0
    //   255: getfield 87	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   258: invokeinterface 204 1 0
    //   263: return
    //   264: astore_1
    //   265: goto +17 -> 282
    //   268: astore_1
    //   269: getstatic 107	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   272: aload_1
    //   273: invokevirtual 329	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   276: invokestatic 256	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: goto -25 -> 254
    //   282: aload_0
    //   283: getfield 87	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   286: invokeinterface 204 1 0
    //   291: goto +5 -> 296
    //   294: aload_1
    //   295: athrow
    //   296: goto -2 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	YtFSM
    //   0	299	1	paramString	String
    //   0	299	2	paramYtSDKKitFrameworkWorkMode	YtSDKKitFramework.YtSDKKitFrameworkWorkMode
    //   0	299	3	paramInt	int
    //   0	299	4	paramLong	long
    //   3	198	6	localObject	Object
    //   12	21	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   40	158	264	finally
    //   161	208	264	finally
    //   208	254	264	finally
    //   269	279	264	finally
    //   40	158	268	java/lang/Exception
    //   161	208	268	java/lang/Exception
    //   208	254	268	java/lang/Exception
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: getstatic 107	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   3: astore_1
    //   4: new 158	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   11: astore_2
    //   12: aload_2
    //   13: ldc_w 334
    //   16: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_2
    //   21: aload_0
    //   22: getfield 53	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentWorkMode	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
    //   25: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_1
    //   30: aload_2
    //   31: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 240	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield 87	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   41: invokeinterface 156 1 0
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 57	com/tencent/youtu/sdkkitframework/framework/YtFSM:needEventHandler	Z
    //   51: aload_0
    //   52: getfield 319	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   55: ifnull +20 -> 75
    //   58: aload_0
    //   59: getfield 319	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   62: invokevirtual 337	java/lang/Thread:isAlive	()Z
    //   65: ifeq +10 -> 75
    //   68: aload_0
    //   69: getfield 319	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   72: invokevirtual 340	java/lang/Thread:join	()V
    //   75: aload_0
    //   76: getfield 55	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   79: iconst_1
    //   80: if_icmpne +77 -> 157
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 55	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   88: aload_0
    //   89: getfield 73	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   92: invokevirtual 183	java/util/HashMap:values	()Ljava/util/Collection;
    //   95: invokeinterface 189 1 0
    //   100: astore_1
    //   101: aload_1
    //   102: invokeinterface 195 1 0
    //   107: ifeq +18 -> 125
    //   110: aload_1
    //   111: invokeinterface 199 1 0
    //   116: checkcast 147	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState
    //   119: invokevirtual 343	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState:unload	()V
    //   122: goto -21 -> 101
    //   125: aload_0
    //   126: getfield 73	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   129: invokevirtual 344	java/util/HashMap:clear	()V
    //   132: aload_0
    //   133: getfield 92	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   136: invokevirtual 128	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   139: goto +18 -> 157
    //   142: astore_1
    //   143: goto +24 -> 167
    //   146: astore_1
    //   147: getstatic 107	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   150: aload_1
    //   151: invokevirtual 345	java/lang/InterruptedException:getLocalizedMessage	()Ljava/lang/String;
    //   154: invokestatic 256	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield 87	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   161: invokeinterface 204 1 0
    //   166: return
    //   167: aload_0
    //   168: getfield 87	com/tencent/youtu/sdkkitframework/framework/YtFSM:startStopLock	Ljava/util/concurrent/locks/Lock;
    //   171: invokeinterface 204 1 0
    //   176: goto +5 -> 181
    //   179: aload_1
    //   180: athrow
    //   181: goto -2 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	YtFSM
    //   3	108	1	localObject1	Object
    //   142	1	1	localObject2	Object
    //   146	34	1	localInterruptedException	java.lang.InterruptedException
    //   11	20	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   37	75	142	finally
    //   75	101	142	finally
    //   101	122	142	finally
    //   125	139	142	finally
    //   147	157	142	finally
    //   37	75	146	java/lang/InterruptedException
    //   75	101	146	java/lang/InterruptedException
    //   101	122	146	java/lang/InterruptedException
    //   125	139	146	java/lang/InterruptedException
  }
  
  public int transitNextRound(String paramString)
  {
    if (this.stateMap.containsKey(paramString))
    {
      this.currentState.exit();
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("transitnextround set current state:");
      localStringBuilder.append(paramString);
      YtLogger.d(str, localStringBuilder.toString());
      this.currentState = ((YtFSMBaseState)this.stateMap.get(paramString));
      this.currentState.enter();
      return 0;
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transitnextround faild:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" state is not found");
    YtLogger.e(str, localStringBuilder.toString());
    return -1;
  }
  
  public int transitNow(String paramString)
  {
    if (this.stateMap.containsKey(paramString))
    {
      this.currentState.exit();
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("transitnow set current state:");
      localStringBuilder.append(paramString);
      YtLogger.d(str, localStringBuilder.toString());
      this.currentState = ((YtFSMBaseState)this.stateMap.get(paramString));
      this.currentState.enter();
      paramString = this.currentData;
      if (paramString != null) {
        this.currentState.update(paramString.imageData, this.currentData.imageWidth, this.currentData.imageHeight, this.currentData.imageType, this.currentData.timeStamp);
      }
      return 0;
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transitnow failed:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" state is not found");
    YtLogger.e(str, localStringBuilder.toString());
    return -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtFSM
 * JD-Core Version:    0.7.0.1
 */