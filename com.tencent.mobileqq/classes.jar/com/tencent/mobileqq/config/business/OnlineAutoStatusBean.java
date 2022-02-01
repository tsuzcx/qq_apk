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
      QLog.d("OnlineAutoStatusConfProcessor", 1, "confBean = " + localOnlineAutoStatusBean.toString());
      return localOnlineAutoStatusBean;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("OnlineAutoStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
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
      paramStatus = null;
    }
    AutoStatusItem localAutoStatusItem;
    do
    {
      return paramStatus;
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
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localAutoStatusItem = (AutoStatusItem)localIterator.next();
      } while ((paramStatus != localAutoStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status) || (paramLong != localAutoStatusItem.jdField_a_of_type_Long));
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "getAutoStatusItem item is hide:", Boolean.valueOf(localAutoStatusItem.b), " onlineStatusIDValue= ", Long.valueOf(paramLong) });
      }
      paramStatus = localAutoStatusItem;
    } while (!localAutoStatusItem.b);
    return this.a.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem;
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
    boolean bool1;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem != null) && (this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem.jdField_a_of_type_Long == 0L))
    {
      bool1 = true;
      boolean bool3 = this.a.jdField_b_of_type_JavaUtilList.isEmpty();
      boolean bool4 = TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusBean", 2, new Object[] { "configExists: invoked. ", " weatherJumpEmpty: ", Boolean.valueOf(bool4), " weatherEmpty: ", Boolean.valueOf(bool3), " smartEntranceEmpty: ", Boolean.valueOf(bool1), " statusEmpty: ", Boolean.valueOf(bool2) });
      }
      if ((!bool2) || (!bool1) || (!bool3) || (!bool4)) {
        break label173;
      }
    }
    label173:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label178;
      }
      return true;
      bool1 = false;
      break;
    }
    label178:
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OnlineAutoStatusBean
 * JD-Core Version:    0.7.0.1
 */