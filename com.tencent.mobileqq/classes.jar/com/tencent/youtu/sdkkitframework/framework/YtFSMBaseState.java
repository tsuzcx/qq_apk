package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class YtFSMBaseState
{
  private static final String TAG = YtFSMBaseState.class.getSimpleName();
  protected boolean isFirstEnter = true;
  public HashMap<String, Object> stateData;
  protected String stateName;
  protected String stateSimpleName;
  
  public void enter()
  {
    YtSDKStats.getInstance().enterState(this.stateSimpleName);
    if (this.isFirstEnter)
    {
      this.isFirstEnter = false;
      enterFirst();
    }
    YtLogger.d(TAG, this.stateName + " enter");
  }
  
  public abstract void enterFirst();
  
  public void exit()
  {
    YtLogger.d(TAG, this.stateName + " exit");
  }
  
  public Object getStateDataBy(String paramString)
  {
    return this.stateData.get(paramString);
  }
  
  public String getStateName()
  {
    return this.stateName;
  }
  
  public String getStateSimpleName()
  {
    return this.stateSimpleName;
  }
  
  public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject) {}
  
  public void handleStateAction(String paramString, Object paramObject) {}
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    this.stateName = paramString;
    try
    {
      this.stateSimpleName = Class.forName(paramString).getSimpleName();
      YtLogger.i(TAG, "load " + this.stateSimpleName);
      this.stateData = new HashMap();
      YtSDKStats.getInstance().registerStateName(this.stateSimpleName);
      return;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        paramString = paramString.split("\\.");
        this.stateSimpleName = paramString[(paramString.length - 1)];
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public void moveToNextState()
  {
    YtLogger.d(TAG, this.stateName + " move to next");
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void reset()
  {
    this.isFirstEnter = true;
    this.stateData.clear();
    YtLogger.i(TAG, this.stateName + " reset");
  }
  
  public void unload()
  {
    YtLogger.i(TAG, "unload " + this.stateSimpleName);
    this.stateData.clear();
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    YtSDKStats.getInstance().updateState(this.stateName);
    YtLogger.d(TAG, this.stateName + " update image : " + paramInt1 + "x" + paramInt2 + " type " + paramInt3);
  }
  
  public void updateSDKSetting(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
 * JD-Core Version:    0.7.0.1
 */