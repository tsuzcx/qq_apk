package com.tencent.mobileqq.pushnotice;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class PushNoticeUtil
{
  public static String a = "";
  
  public static int a()
  {
    int i = 1;
    if (a()) {
      i = 3;
    }
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "HPush_Huawei Push pushType : " + i);
    }
    return i;
  }
  
  private static String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return null;
      switch (paramInt2)
      {
      default: 
        switch (paramInt2)
        {
        }
        break;
      }
    }
    return "0X8009E09";
    return "0X8009E06";
    return "0X8009E07";
    return "0X8009E08";
    return "0X8009E0A";
    return "0X8009E0B";
  }
  
  public static void a()
  {
    if (a())
    {
      if (!TextUtils.isEmpty(a)) {
        break label26;
      }
      ThreadManager.executeOnSubThread(new PushNoticeUtil.1());
    }
    label26:
    do
    {
      return;
      b();
    } while (!QLog.isColorLevel());
    QLog.d("HPush", 2, "HPush_Huawei Push Token-By not HmsInstanceId : ");
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    if (!TextUtils.isEmpty(str)) {
      ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(Context paramContext)
  {
    if (a()) {
      ((NotificationManager)paramContext.getSystemService("notification")).cancelAll();
    }
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER))
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 21) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void b()
  {
    if (!TextUtils.isEmpty(a))
    {
      ((OnlineStatusHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.ONLINE_STATUS_HANDLER)).a(a);
      if (QLog.isColorLevel()) {
        QLog.d("HPush", 2, "HPush_Huawei Push Token-By sendTokenToServer : ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.PushNoticeUtil
 * JD-Core Version:    0.7.0.1
 */