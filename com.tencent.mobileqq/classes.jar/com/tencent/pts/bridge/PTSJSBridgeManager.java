package com.tencent.pts.bridge;

import android.app.Activity;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;

public class PTSJSBridgeManager
{
  private static PTSJSBridgeManager sInstance;
  public final String TAG = "PTSJSBridgeManager";
  private HashMap<Activity, PTSJSBridge> mJSBridgeMap = new HashMap();
  
  public static PTSJSBridgeManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new PTSJSBridgeManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void destroyJSBridge(Activity paramActivity)
  {
    PTSJSBridge localPTSJSBridge = (PTSJSBridge)this.mJSBridgeMap.get(paramActivity);
    if (localPTSJSBridge != null)
    {
      PTSLog.i("PTSJSBridgeManager", "[destroyJSBridge], destroyJSEnvironment.");
      localPTSJSBridge.destroyJSEnvironment();
      this.mJSBridgeMap.remove(paramActivity);
    }
  }
  
  public PTSJSBridge getJSBridge(Activity paramActivity)
  {
    PTSJSBridge localPTSJSBridge2 = (PTSJSBridge)this.mJSBridgeMap.get(paramActivity);
    PTSJSBridge localPTSJSBridge1 = localPTSJSBridge2;
    if (localPTSJSBridge2 == null)
    {
      localPTSJSBridge1 = new PTSJSBridge(paramActivity);
      this.mJSBridgeMap.put(paramActivity, localPTSJSBridge1);
    }
    return localPTSJSBridge1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.bridge.PTSJSBridgeManager
 * JD-Core Version:    0.7.0.1
 */