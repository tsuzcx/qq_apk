package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class CikeConfigData
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  private boolean h = false;
  
  public static CikeConfigData a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramString = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramString, "cike_guide_content", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        if (paramInt == 0) {
          paramString = paramString.optJSONObject("publish_menu_alert_config");
        } else if (paramInt == 1) {
          paramString = paramString.optJSONObject("sendmsg_alert_config");
        } else {
          paramString = paramString.optJSONObject("authenticated_user_alert_config");
        }
        return a(paramContext, paramString);
      }
      QLog.e("CikeConfigData", 1, "parseManageConfig, get config failed");
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("parseManageConfig, exception: ");
      paramString.append(paramContext.getMessage());
      QLog.e("CikeConfigData", 1, paramString.toString());
    }
    return null;
  }
  
  public static CikeConfigData a(Context paramContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      CikeConfigData localCikeConfigData = new CikeConfigData();
      localCikeConfigData.a = paramJSONObject.optString("iconurl");
      localCikeConfigData.b = paramJSONObject.optString("title_text");
      if (a(paramContext))
      {
        localCikeConfigData.h = true;
        localCikeConfigData.c = paramJSONObject.optString("download_installapp_text");
        localCikeConfigData.d = paramJSONObject.optString("jump_app_scheme");
      }
      else
      {
        localCikeConfigData.h = false;
        localCikeConfigData.c = paramJSONObject.optString("download_text");
        localCikeConfigData.d = paramJSONObject.optString("download_url_android");
      }
      localCikeConfigData.e = paramJSONObject.optString("moreurl");
      return localCikeConfigData;
    }
    QLog.e("CikeConfigData", 1, "parseJson, config is null");
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    return PackageUtil.a(paramContext, "com.tencent.litenow");
  }
  
  public void a(long paramLong)
  {
    if ((this.h) && (paramLong != 0L) && (!TextUtils.isEmpty(this.d)))
    {
      if (this.d.contains("?"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.d);
        localStringBuilder.append("&uid=");
        localStringBuilder.append(paramLong);
        this.d = localStringBuilder.toString();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append("?uid=");
      localStringBuilder.append(paramLong);
      this.d = localStringBuilder.toString();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("imageUrl:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" titleTxt:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" btnTxt:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" btnUrl:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" moreUrl:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" d1:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" toUin: ");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.CikeConfigData
 * JD-Core Version:    0.7.0.1
 */