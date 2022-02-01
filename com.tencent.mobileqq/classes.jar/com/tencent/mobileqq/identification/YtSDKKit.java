package com.tencent.mobileqq.identification;

import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import org.json.JSONException;
import org.json.JSONObject;

public class YtSDKKit
{
  private static final String a = "YtSDKKit";
  private static YtSDKKit b;
  private JSONObject c;
  private JSONObject d;
  
  public static YtSDKKit a()
  {
    try
    {
      if (b == null) {
        b = new YtSDKKit();
      }
      YtSDKKit localYtSDKKit = b;
      return localYtSDKKit;
    }
    finally {}
  }
  
  private YtSDKKitFramework.YtSDKKitFrameworkWorkMode b(int paramInt)
  {
    YtSDKKitFramework.YtSDKKitFrameworkWorkMode localYtSDKKitFrameworkWorkMode = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return localYtSDKKitFrameworkWorkMode;
              }
              return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE;
            }
            return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_REFLECT_TYPE;
          }
          return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTION_TYPE;
        }
        return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_SILENT_TYPE;
      }
      return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_OCR_TYPE;
    }
    return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
  }
  
  public int a(String paramString1, String paramString2)
  {
    try
    {
      this.c = new JSONObject(paramString1).getJSONObject("sdk_settings");
      this.d = new JSONObject(paramString2).getJSONObject("ui_basic_config");
      return 0;
    }
    catch (JSONException paramString1)
    {
      paramString2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initWithConfig error ");
      localStringBuilder.append(paramString1.getMessage());
      QLog.e(paramString2, 1, localStringBuilder.toString());
    }
    return -1;
  }
  
  public JSONObject a(int paramInt)
  {
    return YtSDKKitConfigHelper.getSDKConfig(b(paramInt), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.YtSDKKit
 * JD-Core Version:    0.7.0.1
 */