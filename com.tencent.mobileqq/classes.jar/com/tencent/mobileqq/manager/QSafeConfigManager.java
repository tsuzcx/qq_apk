package com.tencent.mobileqq.manager;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class QSafeConfigManager
{
  private static volatile QSafeConfigManager a;
  private QSafeManagerBean b = (QSafeManagerBean)QConfigManager.b().b(732);
  
  public static QSafeConfigManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QSafeConfigManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(QSafeManagerBean paramQSafeManagerBean)
  {
    if (paramQSafeManagerBean == null)
    {
      QLog.e("QSafeConfigManager", 1, "setConfig, config is null");
      return;
    }
    this.b = paramQSafeManagerBean;
  }
  
  public QSafeManagerBean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.manager.QSafeConfigManager
 * JD-Core Version:    0.7.0.1
 */