package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.config.AutoOnlineStatusParser;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.mobileqq.onlinestatus.config.WeatherUrl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime.Status;

public class OnlineAutoStatusBean
{
  public AutoStatusElement a = new AutoStatusElement(new ArrayList(), new OnlineStatusItem(), new ArrayList(), "", new OnlineStatusItem());
  
  public static OnlineAutoStatusBean a(String paramString)
  {
    OnlineAutoStatusBean localOnlineAutoStatusBean = new OnlineAutoStatusBean();
    try
    {
      localOnlineAutoStatusBean.a = AutoOnlineStatusParser.a(paramString);
      paramString = new StringBuilder();
      paramString.append("confBean = ");
      paramString.append(localOnlineAutoStatusBean.toString());
      QLog.d("OnlineAutoStatusConfProcessor", 1, paramString.toString());
      return localOnlineAutoStatusBean;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnlineAutoStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return localOnlineAutoStatusBean;
  }
  
  public OnlineStatusItem a(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!OnlineStatusUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItem is smartItem inValid : onlineStatusIDValue=", Long.valueOf(paramLong) });
      }
      return null;
    }
    if ((this.a.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus) && (paramLong == this.a.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem.jdField_a_of_type_Long))
    {
      if (OnlineStatusUtil.b(this.a.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItem smartStatusOnEarth Valid: onlineStatusIDValue=", Long.valueOf(paramLong) });
        }
        return this.a.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem;
      }
      return null;
    }
    Iterator localIterator = this.a.a(true).iterator();
    while (localIterator.hasNext())
    {
      AutoStatusItem localAutoStatusItem = (AutoStatusItem)localIterator.next();
      if ((paramStatus == localAutoStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status) && (paramLong == localAutoStatusItem.jdField_a_of_type_Long))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItem item is hide:", Boolean.valueOf(localAutoStatusItem.b), " onlineStatusIDValue= ", Long.valueOf(paramLong) });
        }
        if (localAutoStatusItem.b) {
          return this.a.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem;
        }
        return localAutoStatusItem;
      }
    }
    return null;
  }
  
  public WeatherUrl a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.a.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      WeatherUrl localWeatherUrl = (WeatherUrl)localIterator.next();
      if (paramString.equals(localWeatherUrl.jdField_a_of_type_JavaLangString)) {
        return localWeatherUrl;
      }
    }
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = this.a.a(true).isEmpty();
    OnlineStatusItem localOnlineStatusItem = this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem;
    int j = 0;
    boolean bool1;
    if ((localOnlineStatusItem != null) && (this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem.jdField_a_of_type_Long == 0L)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool3 = this.a.jdField_b_of_type_JavaUtilList.isEmpty();
    boolean bool4 = TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusBean", 2, new Object[] { "configExists: invoked. ", " weatherJumpEmpty: ", Boolean.valueOf(bool4), " weatherEmpty: ", Boolean.valueOf(bool3), " smartEntranceEmpty: ", Boolean.valueOf(bool1), " statusEmpty: ", Boolean.valueOf(bool2) });
    }
    int i = j;
    if (bool2)
    {
      i = j;
      if (bool1)
      {
        i = j;
        if (bool3)
        {
          i = j;
          if (bool4) {
            i = 1;
          }
        }
      }
    }
    return i ^ 0x1;
  }
  
  public OnlineStatusItem b(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!OnlineStatusUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItemWithHide is smartItem inValid : onlineStatusIDValue=", Long.valueOf(paramLong) });
      }
      return null;
    }
    if ((this.a.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus) && (paramLong == this.a.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem.jdField_a_of_type_Long))
    {
      if (OnlineStatusUtil.b(this.a.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItemWithHide smartStatusOnEarth Valid: onlineStatusIDValue=", Long.valueOf(paramLong) });
        }
        return this.a.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem;
      }
      return null;
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AutoStatusItem localAutoStatusItem = (AutoStatusItem)localIterator.next();
      if ((paramStatus == localAutoStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status) && (paramLong == localAutoStatusItem.jdField_a_of_type_Long)) {
        return localAutoStatusItem;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OnlineAutoStatusBean
 * JD-Core Version:    0.7.0.1
 */