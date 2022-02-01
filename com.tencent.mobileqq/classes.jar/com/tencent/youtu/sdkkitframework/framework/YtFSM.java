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
  private YtFSM.YtFSMUpdateData currentData = new YtFSM.YtFSMUpdateData(this, null);
  private YtFSMBaseState currentState;
  private YtSDKKitFramework.YtSDKKitFrameworkWorkMode currentWorkMode;
  private YtSDKKitFramework.IYtSDKKitFrameworkEventListener eventListener;
  private String firstStateName;
  private boolean isStarted = false;
  private boolean needEventHandler = false;
  private YtSDKKitFramework.YtSDKPlatformContext sdkPlatformContex;
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
        break label168;
      }
      Iterator localIterator = this.stateMap.values().iterator();
      while (localIterator.hasNext()) {
        ((YtFSMBaseState)localIterator.next()).reset();
      }
      if (!this.stateMap.containsKey(this.firstStateName)) {
        break label178;
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
      label168:
      this.stateLock.unlock();
      return;
      label178:
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
  public void start(String paramString, YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, int paramInt)
  {
    // Byte code:
    //   0: getstatic 42	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   3: new 126	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 272
    //   13: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_2
    //   17: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 208	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 67	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateLock	Ljava/util/concurrent/locks/Lock;
    //   30: invokeinterface 124 1 0
    //   35: aload_0
    //   36: getfield 48	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   39: ifne +132 -> 171
    //   42: aload_0
    //   43: aload_1
    //   44: putfield 212	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   47: aload_0
    //   48: aload_2
    //   49: putfield 117	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentWorkMode	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 48	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   57: aload_0
    //   58: iconst_1
    //   59: putfield 50	com/tencent/youtu/sdkkitframework/framework/YtFSM:needEventHandler	Z
    //   62: aload_0
    //   63: getfield 55	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   66: aload_0
    //   67: getfield 212	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   70: invokevirtual 107	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   73: ifeq +108 -> 181
    //   76: getstatic 42	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   79: new 126	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 274
    //   89: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_1
    //   93: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 147	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 55	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   107: aload_0
    //   108: getfield 212	com/tencent/youtu/sdkkitframework/framework/YtFSM:firstStateName	Ljava/lang/String;
    //   111: invokevirtual 111	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: checkcast 113	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState
    //   117: putfield 87	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentState	Lcom/tencent/youtu/sdkkitframework/framework/YtFSMBaseState;
    //   120: aload_0
    //   121: getfield 87	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentState	Lcom/tencent/youtu/sdkkitframework/framework/YtFSMBaseState;
    //   124: invokevirtual 217	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState:enter	()V
    //   127: aload_0
    //   128: getfield 72	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   131: invokevirtual 220	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   134: aload_0
    //   135: new 276	java/lang/Thread
    //   138: dup
    //   139: new 278	com/tencent/youtu/sdkkitframework/framework/YtFSM$1
    //   142: dup
    //   143: aload_0
    //   144: iload_3
    //   145: invokespecial 281	com/tencent/youtu/sdkkitframework/framework/YtFSM$1:<init>	(Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;I)V
    //   148: invokespecial 284	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   151: putfield 286	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   154: aload_0
    //   155: getfield 286	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   158: ldc_w 288
    //   161: invokevirtual 291	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   164: aload_0
    //   165: getfield 286	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   168: invokevirtual 293	java/lang/Thread:start	()V
    //   171: aload_0
    //   172: getfield 67	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateLock	Ljava/util/concurrent/locks/Lock;
    //   175: invokeinterface 172 1 0
    //   180: return
    //   181: getstatic 42	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   184: new 126	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   191: ldc_w 295
    //   194: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_1
    //   198: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc_w 297
    //   204: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 227	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: goto -86 -> 127
    //   216: astore_1
    //   217: getstatic 42	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   220: aload_1
    //   221: invokevirtual 300	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   224: invokestatic 227	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload_0
    //   228: getfield 67	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateLock	Ljava/util/concurrent/locks/Lock;
    //   231: invokeinterface 172 1 0
    //   236: return
    //   237: astore_1
    //   238: aload_0
    //   239: getfield 67	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateLock	Ljava/util/concurrent/locks/Lock;
    //   242: invokeinterface 172 1 0
    //   247: aload_1
    //   248: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	YtFSM
    //   0	249	1	paramString	String
    //   0	249	2	paramYtSDKKitFrameworkWorkMode	YtSDKKitFramework.YtSDKKitFrameworkWorkMode
    //   0	249	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   26	127	216	java/lang/Exception
    //   127	171	216	java/lang/Exception
    //   181	213	216	java/lang/Exception
    //   26	127	237	finally
    //   127	171	237	finally
    //   181	213	237	finally
    //   217	227	237	finally
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: getstatic 42	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   3: new 126	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 305
    //   13: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 117	com/tencent/youtu/sdkkitframework/framework/YtFSM:currentWorkMode	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
    //   20: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 208	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 67	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateLock	Ljava/util/concurrent/locks/Lock;
    //   33: invokeinterface 124 1 0
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 50	com/tencent/youtu/sdkkitframework/framework/YtFSM:needEventHandler	Z
    //   43: aload_0
    //   44: getfield 48	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   47: iconst_1
    //   48: if_icmpne +80 -> 128
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 48	com/tencent/youtu/sdkkitframework/framework/YtFSM:isStarted	Z
    //   56: aload_0
    //   57: getfield 55	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   60: invokevirtual 151	java/util/HashMap:values	()Ljava/util/Collection;
    //   63: invokeinterface 157 1 0
    //   68: astore_1
    //   69: aload_1
    //   70: invokeinterface 163 1 0
    //   75: ifeq +39 -> 114
    //   78: aload_1
    //   79: invokeinterface 167 1 0
    //   84: checkcast 113	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState
    //   87: invokevirtual 308	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState:unload	()V
    //   90: goto -21 -> 69
    //   93: astore_1
    //   94: getstatic 42	com/tencent/youtu/sdkkitframework/framework/YtFSM:TAG	Ljava/lang/String;
    //   97: aload_1
    //   98: invokevirtual 309	java/lang/InterruptedException:getLocalizedMessage	()Ljava/lang/String;
    //   101: invokestatic 227	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: getfield 67	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateLock	Ljava/util/concurrent/locks/Lock;
    //   108: invokeinterface 172 1 0
    //   113: return
    //   114: aload_0
    //   115: getfield 55	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateMap	Ljava/util/HashMap;
    //   118: invokevirtual 310	java/util/HashMap:clear	()V
    //   121: aload_0
    //   122: getfield 72	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   125: invokevirtual 220	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   128: aload_0
    //   129: getfield 286	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   132: ifnull +20 -> 152
    //   135: aload_0
    //   136: getfield 286	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   139: invokevirtual 313	java/lang/Thread:isAlive	()Z
    //   142: ifeq +10 -> 152
    //   145: aload_0
    //   146: getfield 286	com/tencent/youtu/sdkkitframework/framework/YtFSM:updateEventHandler	Ljava/lang/Thread;
    //   149: invokevirtual 316	java/lang/Thread:join	()V
    //   152: aload_0
    //   153: getfield 67	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateLock	Ljava/util/concurrent/locks/Lock;
    //   156: invokeinterface 172 1 0
    //   161: return
    //   162: astore_1
    //   163: aload_0
    //   164: getfield 67	com/tencent/youtu/sdkkitframework/framework/YtFSM:stateLock	Ljava/util/concurrent/locks/Lock;
    //   167: invokeinterface 172 1 0
    //   172: aload_1
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	YtFSM
    //   68	11	1	localIterator	Iterator
    //   93	5	1	localInterruptedException	java.lang.InterruptedException
    //   162	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	69	93	java/lang/InterruptedException
    //   69	90	93	java/lang/InterruptedException
    //   114	128	93	java/lang/InterruptedException
    //   128	152	93	java/lang/InterruptedException
    //   29	69	162	finally
    //   69	90	162	finally
    //   94	104	162	finally
    //   114	128	162	finally
    //   128	152	162	finally
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
    }
  }
  
  public void updateSDKSetting(JSONObject paramJSONObject)
  {
    Iterator localIterator = this.stateMap.values().iterator();
    while (localIterator.hasNext()) {
      ((YtFSMBaseState)localIterator.next()).updateSDKSetting(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtFSM
 * JD-Core Version:    0.7.0.1
 */