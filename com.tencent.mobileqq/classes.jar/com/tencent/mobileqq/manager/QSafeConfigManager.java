package com.tencent.mobileqq.manager;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class QSafeConfigManager
{
  private static volatile QSafeConfigManager jdField_a_of_type_ComTencentMobileqqManagerQSafeConfigManager;
  private QSafeManagerBean jdField_a_of_type_ComTencentMobileqqManagerQSafeManagerBean = (QSafeManagerBean)QConfigManager.a().a(732);
  
  public static QSafeConfigManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqManagerQSafeConfigManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqManagerQSafeConfigManager == null) {
          jdField_a_of_type_ComTencentMobileqqManagerQSafeConfigManager = new QSafeConfigManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqManagerQSafeConfigManager;
  }
  
  public QSafeManagerBean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqManagerQSafeManagerBean;
  }
  
  public void a(QSafeManagerBean paramQSafeManagerBean)
  {
    if (paramQSafeManagerBean == null)
    {
      QLog.e("QSafeConfigManager", 1, "setConfig, config is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqManagerQSafeManagerBean = paramQSafeManagerBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.manager.QSafeConfigManager
 * JD-Core Version:    0.7.0.1
 */