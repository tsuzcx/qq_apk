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
  private static final String TAG = YtSDKKitConfigHelper.class.getSimpleName();
  private static final HashMap<YtSDKKitFramework.YtSDKKitFrameworkWorkMode, String> UI_SETTINGS = new YtSDKKitConfigHelper.2();
  
  public static String getConfigStringBy(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = null;
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString);
      if ((paramJSONObject == null) || ((paramBoolean) && (paramJSONObject.equals(""))))
      {
        YtLogger.e(TAG, "Parse json object failed " + paramString + "参数解析失败, 不存在或者不能为空");
        YtSDKStats.getInstance().reportError(3145729, "msg_param_error");
        localHashMap = new HashMap();
        localHashMap.put("process_action", "failed");
        localHashMap.put("error_code", Integer.valueOf(3145729));
        localHashMap.put("message", CommonUtils.makeMessageJson(3145729, "msg_param_error", paramString + "参数解析失败, 不存在或者不能为空"));
        YtFSM.getInstance().sendFSMEvent(localHashMap);
      }
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        YtLogger.e(TAG, "Parse json object failed " + paramJSONObject.getLocalizedMessage());
        paramJSONObject = localHashMap;
      }
    }
  }
  
  public static ArrayList<String> getPipleStateNames(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode)
  {
    switch (YtSDKKitConfigHelper.9.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[paramYtSDKKitFrameworkWorkMode.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return new YtSDKKitConfigHelper.3();
    case 2: 
    case 3: 
      return new YtSDKKitConfigHelper.4();
    case 4: 
      return new YtSDKKitConfigHelper.5();
    case 5: 
      return new YtSDKKitConfigHelper.6();
    case 6: 
      return new YtSDKKitConfigHelper.7();
    }
    return new YtSDKKitConfigHelper.8();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper
 * JD-Core Version:    0.7.0.1
 */