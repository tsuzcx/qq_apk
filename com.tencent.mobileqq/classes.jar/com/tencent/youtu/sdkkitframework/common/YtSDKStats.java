package com.tencent.youtu.sdkkitframework.common;

import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class YtSDKStats
  extends YtFSMBaseState
{
  private static YtSDKStats ytSDKStats = null;
  private String currentAction;
  private long currentEnterTimeStampMS;
  private String currentState;
  private String preInfo;
  private String preUpdateState;
  private HashMap<String, Object> stateNameMap = new HashMap();
  
  public static void clearInstance()
  {
    try
    {
      if (ytSDKStats != null) {
        ytSDKStats = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static YtSDKStats getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	com/tencent/youtu/sdkkitframework/common/YtSDKStats:ytSDKStats	Lcom/tencent/youtu/sdkkitframework/common/YtSDKStats;
    //   6: ifnonnull +22 -> 28
    //   9: new 2	com/tencent/youtu/sdkkitframework/common/YtSDKStats
    //   12: dup
    //   13: invokespecial 33	com/tencent/youtu/sdkkitframework/common/YtSDKStats:<init>	()V
    //   16: putstatic 20	com/tencent/youtu/sdkkitframework/common/YtSDKStats:ytSDKStats	Lcom/tencent/youtu/sdkkitframework/common/YtSDKStats;
    //   19: getstatic 20	com/tencent/youtu/sdkkitframework/common/YtSDKStats:ytSDKStats	Lcom/tencent/youtu/sdkkitframework/common/YtSDKStats;
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: getstatic 20	com/tencent/youtu/sdkkitframework/common/YtSDKStats:ytSDKStats	Lcom/tencent/youtu/sdkkitframework/common/YtSDKStats;
    //   31: astore_0
    //   32: goto -9 -> 23
    //   35: astore_0
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	10	0	localYtSDKStats	YtSDKStats
    //   35	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	23	35	finally
    //   28	32	35	finally
  }
  
  public static String getNowTimeStamp()
  {
    return String.valueOf(System.currentTimeMillis());
  }
  
  private void makeReport(String paramString1, String paramString2, HashMap<String, Object> paramHashMap, String paramString3, String paramString4)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("state_id", paramString1);
    localHashMap2.put("state_action", paramString2);
    if (paramHashMap != null) {
      localHashMap2.put("state_error", paramHashMap);
    }
    if (paramString3 != null) {
      localHashMap2.put("state_cost", paramString3);
    }
    if (paramString4 != null) {
      localHashMap2.put("state_info", paramString4);
    }
    localHashMap1.put("state_stats", localHashMap2);
    sendStateEvent(localHashMap1);
  }
  
  private void sendStateEvent(HashMap<String, Object> paramHashMap)
  {
    if (paramHashMap != null) {
      YtFSM.getInstance().sendFSMEvent(paramHashMap);
    }
  }
  
  public void enterFirst() {}
  
  public void enterState(String paramString)
  {
    Object localObject = this.stateNameMap.get(paramString);
    if (localObject == null) {
      return;
    }
    this.currentAction = "enter";
    int i = ((Integer)localObject).intValue();
    if (i == 0)
    {
      exitState();
      if (this.currentAction != null)
      {
        this.currentEnterTimeStampMS = System.currentTimeMillis();
        this.currentState = paramString;
        makeReport(this.currentState, this.currentAction, null, null, null);
      }
    }
    this.stateNameMap.put(paramString, Integer.valueOf(i + 1));
  }
  
  public void exitState()
  {
    if (this.currentState != null)
    {
      String str = Long.toString(System.currentTimeMillis() - this.currentEnterTimeStampMS);
      makeReport(this.currentState, "exit", null, str, null);
    }
  }
  
  public void registerStateName(String paramString)
  {
    this.stateNameMap.put(paramString, Integer.valueOf(0));
  }
  
  public void reportError(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("error_code", Integer.valueOf(paramInt));
    localHashMap.put("error_msg", paramString);
    makeReport(this.currentState, this.currentAction, localHashMap, null, null);
  }
  
  public void reportInfo(String paramString)
  {
    if ((this.preInfo == null) || (!this.preInfo.equals(paramString))) {
      this.preInfo = paramString;
    }
    makeReport(this.currentState, this.currentAction, null, null, paramString);
  }
  
  public void reset()
  {
    Iterator localIterator = this.stateNameMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.stateNameMap.put(str, Integer.valueOf(0));
    }
    this.currentState = null;
    this.preUpdateState = null;
    this.preInfo = null;
  }
  
  public void updateState(String paramString)
  {
    this.currentAction = "update";
    if ((this.preUpdateState == null) || (!this.preUpdateState.equals(this.currentState)))
    {
      this.preUpdateState = this.currentState;
      makeReport(this.currentState, this.currentAction, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtSDKStats
 * JD-Core Version:    0.7.0.1
 */