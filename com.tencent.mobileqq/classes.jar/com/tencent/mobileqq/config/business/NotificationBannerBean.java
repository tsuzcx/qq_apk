package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class NotificationBannerBean
{
  private static final NotificationBannerBean jdField_a_of_type_ComTencentMobileqqConfigBusinessNotificationBannerBean = new NotificationBannerBean();
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String b = "";
  
  public static NotificationBannerBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (paramArrayOfQConfItem == null) {
      return jdField_a_of_type_ComTencentMobileqqConfigBusinessNotificationBannerBean;
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
          JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
          if (localJSONObject.optInt("visible", 0) == 1)
          {
            bool = true;
            localNotificationBannerBean.jdField_a_of_type_Boolean = bool;
            localNotificationBannerBean.jdField_a_of_type_JavaLangString = localJSONObject.optString("guideText", "");
            localNotificationBannerBean.b = localJSONObject.optString("guideHighlightText", "");
            localNotificationBannerBean.jdField_a_of_type_Long = localJSONObject.optLong("showIntervalMs", 0L);
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
        return jdField_a_of_type_ComTencentMobileqqConfigBusinessNotificationBannerBean;
      }
      boolean bool = false;
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.NotificationBannerBean
 * JD-Core Version:    0.7.0.1
 */