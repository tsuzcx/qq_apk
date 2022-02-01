package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class NotificationBannerBean
{
  private static final NotificationBannerBean e = new NotificationBannerBean();
  private boolean a = false;
  private String b = "";
  private String c = "";
  private long d = 0L;
  
  public static NotificationBannerBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (paramArrayOfQConfItem == null) {
      return e;
    }
    for (;;)
    {
      try
      {
        NotificationBannerBean localNotificationBannerBean = new NotificationBannerBean();
        int j = paramArrayOfQConfItem.length;
        int i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[i].b);
          if (localJSONObject.optInt("visible", 0) == 1)
          {
            bool = true;
            localNotificationBannerBean.a = bool;
            localNotificationBannerBean.b = localJSONObject.optString("guideText", "");
            localNotificationBannerBean.c = localJSONObject.optString("guideHighlightText", "");
            localNotificationBannerBean.d = localJSONObject.optLong("showIntervalMs", 0L);
            i += 1;
          }
        }
        else
        {
          return localNotificationBannerBean;
        }
      }
      catch (Exception paramArrayOfQConfItem)
      {
        QLog.e("NotificationBannerBean", 1, "parse: failed. ", paramArrayOfQConfItem);
        return e;
      }
      boolean bool = false;
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
  
  public long d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.NotificationBannerBean
 * JD-Core Version:    0.7.0.1
 */