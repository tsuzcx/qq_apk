package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class YtSDKKitConfigHelper
{
  private static final HashMap<YtSDKKitFramework.YtSDKKitFrameworkWorkMode, String> SDK_SETTINGS = new YtSDKKitConfigHelper.1();
  private static final String TAG = "YtSDKKitConfigHelper";
  private static final HashMap<YtSDKKitFramework.YtSDKKitFrameworkWorkMode, String> UI_SETTINGS = new YtSDKKitConfigHelper.2();
  
  public static String getConfigStringBy(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString);
    }
    catch (JSONException paramJSONObject)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Parse json object failed ");
      localStringBuilder.append(paramJSONObject.getLocalizedMessage());
      YtLogger.e((String)localObject, localStringBuilder.toString());
      paramJSONObject = null;
    }
    if ((paramBoolean) && ((paramJSONObject == null) || (paramJSONObject.equals(""))))
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Parse json object failed ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("参数解析失败, 不存在或者不能为空");
      YtLogger.e((String)localObject, localStringBuilder.toString());
      YtSDKStats.getInstance().reportError(3145729, "msg_param_error");
      localObject = new HashMap();
      ((HashMap)localObject).put("process_action", "failed");
      ((HashMap)localObject).put("error_code", Integer.valueOf(3145729));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("参数解析失败, 不存在或者不能为空");
      ((HashMap)localObject).put("message", CommonUtils.makeMessageJson(3145729, "msg_param_error", localStringBuilder.toString()));
      YtFSM.getInstance().sendFSMEvent((HashMap)localObject);
    }
    return paramJSONObject;
  }
  
  public static ArrayList<String> getPipleStateNames(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode)
  {
    switch (YtSDKKitConfigHelper.10.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[paramYtSDKKitFrameworkWorkMode.ordinal()])
    {
    default: 
      return null;
    case 8: 
      return new YtSDKKitConfigHelper.9();
    case 7: 
      return new YtSDKKitConfigHelper.8();
    case 6: 
      return new YtSDKKitConfigHelper.7();
    case 5: 
      return new YtSDKKitConfigHelper.6();
    case 4: 
      return new YtSDKKitConfigHelper.5();
    case 2: 
    case 3: 
      return new YtSDKKitConfigHelper.4();
    }
    return new YtSDKKitConfigHelper.3();
  }
  
  public static JSONObject getSDKConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, JSONObject paramJSONObject)
  {
    try
    {
      paramYtSDKKitFrameworkWorkMode = paramJSONObject.getJSONObject((String)SDK_SETTINGS.get(paramYtSDKKitFrameworkWorkMode));
      return paramYtSDKKitFrameworkWorkMode;
    }
    catch (JSONException paramYtSDKKitFrameworkWorkMode)
    {
      YtLogger.e(TAG, paramYtSDKKitFrameworkWorkMode.getMessage());
    }
    return null;
  }
  
  public static JSONObject getUIConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, JSONObject paramJSONObject)
  {
    try
    {
      paramYtSDKKitFrameworkWorkMode = paramJSONObject.getJSONObject((String)UI_SETTINGS.get(paramYtSDKKitFrameworkWorkMode));
      return paramYtSDKKitFrameworkWorkMode;
    }
    catch (JSONException paramYtSDKKitFrameworkWorkMode)
    {
      YtLogger.e(TAG, paramYtSDKKitFrameworkWorkMode.getMessage());
    }
    return null;
  }
  
  public static void setSDKConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    try
    {
      paramJSONObject1.put((String)SDK_SETTINGS.get(paramYtSDKKitFrameworkWorkMode), paramJSONObject2);
      return;
    }
    catch (JSONException paramYtSDKKitFrameworkWorkMode)
    {
      YtLogger.e(TAG, paramYtSDKKitFrameworkWorkMode.getMessage());
    }
  }
  
  public static void setUIConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    try
    {
      paramJSONObject1.put((String)UI_SETTINGS.get(paramYtSDKKitFrameworkWorkMode), paramJSONObject2);
      return;
    }
    catch (JSONException paramYtSDKKitFrameworkWorkMode)
    {
      YtLogger.e(TAG, paramYtSDKKitFrameworkWorkMode.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper
 * JD-Core Version:    0.7.0.1
 */