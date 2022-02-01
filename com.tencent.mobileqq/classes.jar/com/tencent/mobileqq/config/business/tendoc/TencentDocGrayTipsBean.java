package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IAudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocGrayTipsBean
{
  private boolean a = false;
  private String b = "";
  private String c = "";
  private int d = 0;
  private String e = "";
  
  public static TencentDocGrayTipsBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      TencentDocGrayTipsBean localTencentDocGrayTipsBean = new TencentDocGrayTipsBean();
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].b);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleTencentDocGrayTipsConfig call after ");
          localStringBuilder.append(paramArrayOfQConfItem.toString());
          QLog.d("TencentDocGrayTipsBean", 2, localStringBuilder.toString());
        }
        a(localTencentDocGrayTipsBean, paramArrayOfQConfItem);
        return localTencentDocGrayTipsBean;
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
        return localTencentDocGrayTipsBean;
      }
    }
    return null;
  }
  
  public static void a(TencentDocGrayTipsBean paramTencentDocGrayTipsBean, JSONObject paramJSONObject)
  {
    if (paramTencentDocGrayTipsBean != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      if ((((IAudioHelper)QRoute.api(IAudioHelper.class)).isDev()) && (((IAudioHelper)QRoute.api(IAudioHelper.class)).getDebugValue(10) == 1)) {
        ((IAudioHelper)QRoute.api(IAudioHelper.class)).writeTestLog(HardCodeUtil.a(2131912146));
      }
    }
    try
    {
      paramJSONObject.put("tencentDocAIOGrayTipsEnable", true);
      paramJSONObject.put("plainContent", HardCodeUtil.a(2131912139));
      paramJSONObject.put("hightLightContent", HardCodeUtil.a(2131912142));
      paramJSONObject.put("showTimes", 3);
      paramJSONObject.put("linkUrl", "https://docs.qq.com/desktop");
    }
    catch (Exception localException)
    {
      label114:
      break label114;
    }
    if (paramJSONObject.has("tencentDocAIOGrayTipsEnable")) {
      paramTencentDocGrayTipsBean.a = paramJSONObject.optBoolean("tencentDocAIOGrayTipsEnable");
    }
    if (paramJSONObject.has("plainContent")) {
      paramTencentDocGrayTipsBean.b = paramJSONObject.optString("plainContent");
    }
    if (paramJSONObject.has("hightLightContent")) {
      paramTencentDocGrayTipsBean.c = paramJSONObject.optString("hightLightContent");
    }
    if (paramJSONObject.has("showTimes")) {
      paramTencentDocGrayTipsBean.d = paramJSONObject.optInt("showTimes");
    }
    if (paramJSONObject.has("linkUrl")) {
      paramTencentDocGrayTipsBean.e = paramJSONObject.optString("linkUrl");
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocGrayTipsBean
 * JD-Core Version:    0.7.0.1
 */