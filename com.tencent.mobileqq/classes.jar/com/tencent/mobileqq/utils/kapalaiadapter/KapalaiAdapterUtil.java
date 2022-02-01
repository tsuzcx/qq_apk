package com.tencent.mobileqq.utils.kapalaiadapter;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera.Parameters;
import android.os.Build.VERSION;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.NotifyLightUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;

public class KapalaiAdapterUtil
{
  public int a;
  private DualSimManager a;
  
  private KapalaiAdapterUtil()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager = DualSimManager.a();
  }
  
  public static KapalaiAdapterUtil a()
  {
    return KapalaiAdapterUtil.KAUHolder.a;
  }
  
  public int a()
  {
    return 1;
  }
  
  @TargetApi(16)
  public Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean2)
  {
    if (paramIntent.getIntExtra("uintype", -1) == 1008)
    {
      if (!AppConstants.REMINDER_UIN.equals(paramIntent.getStringExtra("uin")))
      {
        i = 2130841838;
        break label131;
      }
    }
    else
    {
      if ((paramIntent.getIntExtra("uintype", -1) == 1010) && (String.valueOf(AppConstants.DATE_UIN).equals(paramIntent.getStringExtra("uin"))))
      {
        i = 2130845602;
        break label131;
      }
      if (((paramIntent.getIntExtra("uintype", -1) == 1001) || (paramIntent.getIntExtra("uintype", -1) == 10002)) && (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(paramIntent.getStringExtra("uin"))))
      {
        i = 2130840422;
        break label131;
      }
    }
    int i = 2130841471;
    label131:
    if (paramIntent.getBooleanExtra("qav_notify_flag", false)) {
      i = 2130842201;
    }
    paramIntent.putExtra("param_notifyid", i);
    paramIntent = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 134217728);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("buildNotification by getActivity(kapalai). contentIntent=");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.i("MobileQQService", 2, ((StringBuilder)localObject).toString());
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      paramBitmap = new Notification(i, paramString1, System.currentTimeMillis());
      paramBitmap.contentIntent = paramIntent;
      if (paramBoolean2)
      {
        paramBitmap.flags |= 0x20;
        paramBitmap.flags |= 0x2;
      }
      if (NotifyLightUtil.a(BaseApplication.getContext(), paramBaseQQAppInterface))
      {
        Calendar.getInstance().get(11);
        paramBitmap.flags |= 0x1;
        paramBitmap.ledARGB = -16711936;
        paramBitmap.ledOffMS = 2000;
        paramBitmap.ledOnMS = 2000;
      }
      return paramBitmap;
    }
    Object localObject = new Notification.Builder(BaseApplication.getContext()).setSmallIcon(i).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(paramString1);
    if (paramBoolean2) {
      ((Notification.Builder)localObject).setOngoing(true);
    }
    try
    {
      Method localMethod = Class.forName("android.app.Notification$Builder").getDeclaredMethod("setInternalApp", new Class[] { Integer.TYPE });
      if (localMethod != null) {
        localMethod.invoke(localObject, new Object[] { Integer.valueOf(1) });
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (NotifyLightUtil.a(BaseApplication.getContext(), paramBaseQQAppInterface))
    {
      Calendar.getInstance().get(11);
      ((Notification.Builder)localObject).setLights(-16711936, 2000, 2000);
    }
    if (paramBoolean1)
    {
      if (paramBitmap != null) {
        ((Notification.Builder)localObject).setLargeIcon(paramBitmap);
      }
      ((Notification.Builder)localObject).setContentTitle(paramString2).setContentText(paramString3).setContentIntent(paramIntent);
    }
    else
    {
      ((Notification.Builder)localObject).setContentTitle(paramString2).setContentText(paramString3).setContentIntent(paramIntent);
      if (paramBitmap != null) {
        ((Notification.Builder)localObject).setLargeIcon(paramBitmap);
      }
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 16) {
        return ((Notification.Builder)localObject).build();
      }
      if ((Build.VERSION.SDK_INT < 16) && (Build.VERSION.SDK_INT >= 11)) {
        return ((Notification.Builder)localObject).getNotification();
      }
      paramIntent = new Notification(i, paramString1, System.currentTimeMillis());
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.e("kapalaiBuildNotificationForMeizu", 2, paramIntent.getMessage());
      }
    }
    return new Notification(i, paramString1, System.currentTimeMillis());
  }
  
  public Intent a(Intent paramIntent)
  {
    paramIntent.putExtra(a(), Integer.parseInt(b()));
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap != null) {
      return Bitmap.createScaledBitmap(paramBitmap, paramInt, paramInt, true);
    }
    return null;
  }
  
  public String a()
  {
    return DualSimManager.a;
  }
  
  public String a(Camera.Parameters paramParameters)
  {
    paramParameters = paramParameters.getSupportedFlashModes();
    if (paramParameters.contains("torch")) {
      return "torch";
    }
    if (paramParameters.contains("on")) {
      return "on";
    }
    if (paramParameters.contains("auto")) {
      return "auto";
    }
    return "off";
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent.setFlags(337641472);
  }
  
  public void a(Window paramWindow)
  {
    paramWindow.setType(2004);
  }
  
  public void a(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.screenBrightness = 0.035F;
  }
  
  public boolean a()
  {
    return (!this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager.a(0)) && (this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager.a(1));
  }
  
  public String b()
  {
    return DualSimManager.c;
  }
  
  public void b(Window paramWindow)
  {
    paramWindow.setType(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil
 * JD-Core Version:    0.7.0.1
 */