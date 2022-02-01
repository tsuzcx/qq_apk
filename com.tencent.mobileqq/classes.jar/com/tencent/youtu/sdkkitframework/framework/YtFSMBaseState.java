package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class YtFSMBaseState
{
  private static final String TAG = "YtFSMBaseState";
  protected boolean isFirstEnter = true;
  protected HashMap<String, Object> stateData;
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
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.stateName);
    localStringBuilder.append(" enter");
    YtLogger.d(str, localStringBuilder.toString());
  }
  
  public abstract void enterFirst();
  
  public void exit()
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.stateName);
    localStringBuilder.append(" exit");
    YtLogger.d(str, localStringBuilder.toString());
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
    }
    catch (Exception paramJSONObject)
    {
      paramString = paramString.split("\\.");
      this.stateSimpleName = paramString[(paramString.length - 1)];
      paramJSONObject.printStackTrace();
    }
    paramString = TAG;
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("load ");
    paramJSONObject.append(this.stateSimpleName);
    YtLogger.i(paramString, paramJSONObject.toString());
    this.stateData = new HashMap();
    YtSDKStats.getInstance().registerStateName(this.stateSimpleName);
  }
  
  public void moveToNextState()
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.stateName);
    localStringBuilder.append(" move to next");
    YtLogger.d(str, localStringBuilder.toString());
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void reset()
  {
    this.isFirstEnter = true;
    this.stateData.clear();
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.stateName);
    localStringBuilder.append(" reset");
    YtLogger.i(str, localStringBuilder.toString());
  }
  
  public void unload()
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unload ");
    localStringBuilder.append(this.stateSimpleName);
    YtLogger.i(str, localStringBuilder.toString());
    this.stateData.clear();
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    YtSDKStats.getInstance().updateState(this.stateName);
    paramArrayOfByte = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.stateName);
    localStringBuilder.append(" update image : ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" type ");
    localStringBuilder.append(paramInt3);
    YtLogger.d(paramArrayOfByte, localStringBuilder.toString());
  }
  
  public void updateSDKSetting(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
 * JD-Core Version:    0.7.0.1
 */