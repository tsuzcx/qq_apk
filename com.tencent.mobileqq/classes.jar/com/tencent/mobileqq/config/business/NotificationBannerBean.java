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
    Object localObject;
    if (paramArrayOfQConfItem == null) {
      localObject = jdField_a_of_type_ComTencentMobileqqConfigBusinessNotificationBannerBean;
    }
    for (;;)
    {
      return localObject;
      try
      {
        NotificationBannerBean localNotificationBannerBean = new NotificationBannerBean();
        int j = paramArrayOfQConfItem.length;
        int i = 0;
        localObject = localNotificationBannerBean;
        if (i >= j) {
          continue;
        }
        localObject = new JSONObject(paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).optInt("visible", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localNotificationBannerBean.jdField_a_of_type_Boolean = bool;
          localNotificationBannerBean.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("guideText", "");
          localNotificationBannerBean.b = ((JSONObject)localObject).optString("guideHighlightText", "");
          localNotificationBannerBean.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("showIntervalMs", 0L);
          i += 1;
          break;
        }
        return jdField_a_of_type_ComTencentMobileqqConfigBusinessNotificationBannerBean;
      }
      catch (Exception paramArrayOfQConfItem)
      {
        QLog.e("NotificationBannerBean", 1, "parse: failed. ", paramArrayOfQConfItem);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.NotificationBannerBean
 * JD-Core Version:    0.7.0.1
 */