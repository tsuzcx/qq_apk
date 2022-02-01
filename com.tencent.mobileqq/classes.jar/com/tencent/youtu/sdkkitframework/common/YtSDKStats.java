package com.tencent.youtu.sdkkitframework.common;

import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class YtSDKStats
  extends YtFSMBaseState
{
  private static YtSDKStats ytSDKStats;
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
  
  public static YtSDKStats getInstance()
  {
    try
    {
      if (ytSDKStats == null)
      {
        ytSDKStats = new YtSDKStats();
        localYtSDKStats = ytSDKStats;
        return localYtSDKStats;
      }
      YtSDKStats localYtSDKStats = ytSDKStats;
      return localYtSDKStats;
    }
    finally {}
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
    String str = this.preInfo;
    if ((str == null) || (!str.equals(paramString))) {
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
    paramString = this.preUpdateState;
    if ((paramString == null) || (!paramString.equals(this.currentState)))
    {
      paramString = this.currentState;
      this.preUpdateState = paramString;
      makeReport(paramString, this.currentAction, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtSDKStats
 * JD-Core Version:    0.7.0.1
 */