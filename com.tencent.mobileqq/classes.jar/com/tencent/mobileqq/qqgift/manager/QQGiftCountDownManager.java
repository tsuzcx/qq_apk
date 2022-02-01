package com.tencent.mobileqq.qqgift.manager;

import com.tencent.mobileqq.qqgift.countdown.CountDownController;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData.FreeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QQGiftCountDownManager
{
  private static QQGiftCountDownManager a;
  private final Map<String, CountDownController> b = new ConcurrentHashMap();
  
  public static QQGiftCountDownManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QQGiftCountDownManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static boolean a(GiftServiceData paramGiftServiceData)
  {
    return (paramGiftServiceData != null) && (paramGiftServiceData.j == 1) && (paramGiftServiceData.l != null) && (paramGiftServiceData.l.a > 0L);
  }
  
  public CountDownController a(String paramString)
  {
    return (CountDownController)this.b.get(paramString);
  }
  
  public void b(String paramString)
  {
    Object localObject = new CountDownController(paramString);
    ((CountDownController)localObject).a();
    this.b.put(paramString, localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[enterRoom] key:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",mCountDownControlMapSize:");
      ((StringBuilder)localObject).append(this.b.size());
      QLog.i("QQGiftCountDownManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c(String paramString)
  {
    Object localObject = (CountDownController)this.b.remove(paramString);
    if (localObject != null) {
      ((CountDownController)localObject).b();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[exitRoom] key:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",mCountDownControlMapSize:");
      ((StringBuilder)localObject).append(this.b.size());
      QLog.i("QQGiftCountDownManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.manager.QQGiftCountDownManager
 * JD-Core Version:    0.7.0.1
 */