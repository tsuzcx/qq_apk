package com.tencent.mobileqq.equipmentlock;

import QQService.DeviceItemDes;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.DevlockQuickLoginActivity;
import com.tencent.mobileqq.antiphing.DeviceLockItemInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class EquipmentLockImpl
  implements EquipmentLockInterface
{
  private static EquipmentLockImpl jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipmentLockImpl;
  public static boolean a;
  private static byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private int jdField_a_of_type_Int = -1;
  Runnable jdField_a_of_type_JavaLangRunnable = new EquipmentLockImpl.1(this);
  String jdField_a_of_type_JavaLangString = null;
  private ArrayList<DeviceLockItemInfo> jdField_a_of_type_JavaUtilArrayList = null;
  private Map<Integer, Handler> jdField_a_of_type_JavaUtilMap = new HashMap();
  byte[] jdField_a_of_type_ArrayOfByte = null;
  String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = true;
  String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString = null;
  private boolean jdField_d_of_type_Boolean = false;
  private String e = null;
  private String f = "Manually";
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipmentLockImpl = null;
    jdField_a_of_type_Boolean = false;
  }
  
  public static EquipmentLockImpl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipmentLockImpl == null) {
      synchronized (jdField_b_of_type_ArrayOfByte)
      {
        if (jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipmentLockImpl == null) {
          jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipmentLockImpl = new EquipmentLockImpl();
        }
      }
    }
    return jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipmentLockImpl;
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    this.e = paramString;
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime, Context paramContext)
  {
    if (paramContext != null)
    {
      if (paramAppRuntime == null) {
        return -1;
      }
      paramAppRuntime = paramAppRuntime.getCurrentAccountUin();
      if (TextUtils.isEmpty(paramAppRuntime)) {
        return -1;
      }
      if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!this.jdField_d_of_type_JavaLangString.equalsIgnoreCase(paramAppRuntime)))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Int = -1;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        paramContext = paramContext.getSharedPreferences("devlock_sharedpref", 0);
        if (paramContext == null) {
          return -1;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("devlock_status");
        localStringBuilder.append(paramAppRuntime);
        this.jdField_a_of_type_Int = paramContext.getInt(localStringBuilder.toString(), -1);
      }
      this.jdField_d_of_type_JavaLangString = paramAppRuntime;
      return this.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public int a(AppRuntime paramAppRuntime, Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (paramAppRuntime == null) {
        return -1;
      }
      if (TextUtils.isEmpty(paramString)) {
        return -1;
      }
      paramContext = paramContext.getSharedPreferences("devlock_sharedpref", 0);
      if (paramContext == null) {
        return -1;
      }
      paramAppRuntime = paramAppRuntime.getAccount();
      StringBuilder localStringBuilder;
      if (paramBoolean)
      {
        paramContext = paramContext.edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("devlock_status");
        localStringBuilder.append(paramString);
        paramContext.putInt(localStringBuilder.toString(), 0).commit();
        if (paramString.equalsIgnoreCase(paramAppRuntime))
        {
          this.jdField_a_of_type_Int = 0;
          return 0;
        }
      }
      else
      {
        paramContext = paramContext.edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("devlock_status");
        localStringBuilder.append(paramString);
        paramContext.putInt(localStringBuilder.toString(), 1).commit();
        if (paramString.equalsIgnoreCase(paramAppRuntime)) {
          this.jdField_a_of_type_Int = 1;
        }
      }
      return 0;
    }
    return -1;
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString1, String paramString2, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return -1;
      }
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
      if (paramAppRuntime == null) {
        return -1;
      }
      return paramAppRuntime.checkDevLockSms(paramString1, AppSetting.a(), paramString2, paramArrayOfByte, paramWtloginObserver);
    }
    return -1;
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return -1;
      }
      int i = AppSetting.a();
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
      if (paramAppRuntime == null) {
        return -1;
      }
      return paramAppRuntime.checkDevLockStatus(paramString, i, paramWtloginObserver);
    }
    return -1;
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime = (VerifyDevLockManager)paramAppRuntime.getManager(7);
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime.cancelVerify(paramVerifyDevLockObserver);
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, String paramString, HashMap<String, Object> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime = (VerifyDevLockManager)paramAppRuntime.getManager(7);
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime.submitSms(paramVerifyDevLockObserver, paramString, paramHashMap);
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, HashMap<String, Object> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime = (VerifyDevLockManager)paramAppRuntime.getManager(7);
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime.refreshDevLockSms(paramVerifyDevLockObserver, paramHashMap);
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, byte[] paramArrayOfByte)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime = (VerifyDevLockManager)paramAppRuntime.getManager(7);
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime.gatewayVerify(paramVerifyDevLockObserver, paramArrayOfByte);
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime = (VerifyDevLockManager)paramAppRuntime.getManager(7);
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime.refreshDevLockSms(paramVerifyDevLockObserver, paramArrayOfByte);
    return 0;
  }
  
  public String a()
  {
    return this.e;
  }
  
  public ArrayList<DeviceLockItemInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), DevlockQuickLoginActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("qrcode", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("maintip", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("smalltip", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("loginConfig", this.jdField_a_of_type_ArrayOfByte);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_a_of_type_ArrayOfByte = null;
    }
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(ArrayList<DeviceLockItemInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramAppRuntime != null)
    {
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
      if (paramAppRuntime != null) {
        paramAppRuntime.setDevLockMobileType(paramInt);
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramAppRuntime != null) {
        str = paramAppRuntime.getCurrentAccountUin();
      }
    }
    ReportController.b(paramAppRuntime, "P_CliOper", "Safe_DeviceLock", str, "UserBehavior", this.f, 0, paramInt, "", "", "", "");
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (paramAppRuntime == null) {
      return;
    }
    boolean bool;
    if ((!paramAppRuntime.isBackgroundPause) && (!paramAppRuntime.isBackgroundStop)) {
      bool = false;
    } else {
      bool = true;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleQuickloginPush isInBackground=");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(" app.isBackground_Pause=");
      ((StringBuilder)localObject1).append(paramAppRuntime.isBackgroundPause);
      ((StringBuilder)localObject1).append(" app.isBackground_Stop=");
      ((StringBuilder)localObject1).append(paramAppRuntime.isBackgroundStop);
      QLog.d("DevLock", 2, ((StringBuilder)localObject1).toString());
    }
    if (bool)
    {
      paramAppRuntime = BaseApplicationImpl.getContext();
      localObject1 = paramAppRuntime.getString(2131692034);
      Object localObject2 = paramAppRuntime.getString(2131692034);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString2);
      ((StringBuilder)localObject3).append("\n");
      ((StringBuilder)localObject3).append(paramString3);
      String str = ((StringBuilder)localObject3).toString();
      localObject3 = BitmapManager.a(paramAppRuntime.getResources(), 2130844282);
      localObject1 = new NotificationCompat.Builder(paramAppRuntime).setContentTitle((CharSequence)localObject2).setContentText(str).setAutoCancel(true).setSmallIcon(BaseApplicationImpl.appnewmsgicon).setTicker((CharSequence)localObject1).setWhen(System.currentTimeMillis());
      if (localObject3 != null) {
        ((NotificationCompat.Builder)localObject1).setLargeIcon((Bitmap)localObject3);
      } else {
        ((NotificationCompat.Builder)localObject1).setLargeIcon(BitmapManager.a(paramAppRuntime.getResources(), 2130844282));
      }
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject1).setSmallIcon(2130844282);
      }
      localObject2 = new Intent(paramAppRuntime, DevlockQuickLoginActivity.class);
      ((Intent)localObject2).addFlags(268435456);
      ((Intent)localObject2).putExtra("qrcode", paramString1);
      ((Intent)localObject2).putExtra("maintip", paramString2);
      ((Intent)localObject2).putExtra("smalltip", paramString3);
      ((Intent)localObject2).putExtra("loginConfig", paramArrayOfByte);
      ((Intent)localObject2).putExtra("param_notifyid", 276);
      ((NotificationCompat.Builder)localObject1).setContentIntent(PendingIntent.getActivity(paramAppRuntime, 0, (Intent)localObject2, 134217728));
      if ((localObject1 != null) && (Build.VERSION.SDK_INT >= 26)) {
        ((NotificationCompat.Builder)localObject1).setChannelId("CHANNEL_ID_SHOW_BADGE");
      }
      paramAppRuntime = ((NotificationCompat.Builder)localObject1).build();
      localObject1 = QQNotificationManager.getInstance();
      if (localObject1 != null)
      {
        ((QQNotificationManager)localObject1).cancel("EquipmentLockImpl", 276);
        jdField_a_of_type_Boolean = true;
        ((QQNotificationManager)localObject1).notify("EquipmentLockImpl", 276, paramAppRuntime);
        this.jdField_a_of_type_JavaLangString = paramString1;
        this.jdField_b_of_type_JavaLangString = paramString2;
        this.jdField_c_of_type_JavaLangString = paramString3;
        this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte.length];
        System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte.length);
        ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 120000L);
        return;
      }
      return;
    }
    paramAppRuntime = new Intent(BaseApplicationImpl.getContext(), DevlockQuickLoginActivity.class);
    paramAppRuntime.addFlags(268435456);
    paramAppRuntime.putExtra("qrcode", paramString1);
    paramAppRuntime.putExtra("maintip", paramString2);
    paramAppRuntime.putExtra("smalltip", paramString3);
    paramAppRuntime.putExtra("loginConfig", paramArrayOfByte);
    BaseApplicationImpl.getContext().startActivity(paramAppRuntime);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    long l = Long.parseLong(paramAppRuntime.getAccount());
    String str = null;
    int i = AppSetting.a();
    paramAppRuntime.getApplication();
    Object localObject = MobileQQ.getContext();
    if (localObject != null) {
      str = ((Context)localObject).getPackageName();
    }
    if (str != null)
    {
      localObject = str;
      if (str.length() >= 1) {}
    }
    else
    {
      localObject = "com.tencent.mobileqq";
    }
    if (!(paramAppRuntime instanceof AppInterface)) {
      return false;
    }
    paramAppRuntime = (FriendListHandler)((AppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (paramAppRuntime != null)
    {
      paramAppRuntime.getRecommandAuthDeviceList(l, (String)localObject, i);
      return true;
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, long paramLong, byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    if (!(paramAppRuntime instanceof AppInterface)) {
      return false;
    }
    paramAppRuntime = (FriendListHandler)((AppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (paramAppRuntime != null)
    {
      paramAppRuntime.kickOutDev(paramLong, paramByte, paramArrayOfByte, paramInt);
      return true;
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString, long paramLong)
  {
    if (!(paramAppRuntime instanceof AppInterface)) {
      return false;
    }
    paramAppRuntime = (FriendListHandler)((AppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (paramAppRuntime != null)
    {
      paramAppRuntime.getLoginDevList(paramLong, paramString, 0L);
      return true;
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    if (!(paramAppRuntime instanceof AppInterface)) {
      return false;
    }
    paramAppRuntime = (FriendListHandler)((AppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (paramAppRuntime != null)
    {
      paramAppRuntime.delHistoryDev(paramString, paramArrayList, paramInt);
      return true;
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    if (!(paramAppRuntime instanceof AppInterface)) {
      return false;
    }
    paramAppRuntime = (FriendListHandler)((AppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (paramAppRuntime != null)
    {
      paramAppRuntime.delAuthDev(paramString, paramArrayList, paramInt, paramBoolean, paramLong);
      return true;
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, ArrayList<DeviceLockItemInfo> paramArrayList)
  {
    if (paramAppRuntime != null)
    {
      if (paramArrayList == null) {
        return false;
      }
      long l = Long.parseLong(paramAppRuntime.getAccount());
      String str = null;
      int i = AppSetting.a();
      paramAppRuntime.getApplication();
      Object localObject = MobileQQ.getContext();
      if (localObject != null) {
        str = ((Context)localObject).getPackageName();
      }
      if (str != null)
      {
        localObject = str;
        if (str.length() >= 1) {}
      }
      else
      {
        localObject = "com.tencent.mobileqq";
      }
      if (!(paramAppRuntime instanceof AppInterface)) {
        return false;
      }
      paramAppRuntime = (FriendListHandler)((AppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (paramAppRuntime != null)
      {
        paramAppRuntime.updateTrustDeviceList(l, i, (String)localObject, 1000, paramArrayList);
        return true;
      }
    }
    return false;
  }
  
  public int b(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return -1;
      }
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
      if (paramAppRuntime == null) {
        return -1;
      }
      return paramAppRuntime.closeDevLock(paramString, AppSetting.a(), paramWtloginObserver);
    }
    return -1;
  }
  
  public void b()
  {
    BaseApplicationImpl.getContext();
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    if (localQQNotificationManager != null) {}
    try
    {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      localQQNotificationManager.cancel("EquipmentLockImpl", 276);
      jdField_a_of_type_Boolean = false;
      label36:
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_a_of_type_ArrayOfByte = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label36;
    }
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramAppRuntime != null) {
        str = paramAppRuntime.getCurrentAccountUin();
      }
    }
    ReportController.b(paramAppRuntime, "dc00899", "Safe_DeviceLock", str, "H5UserBehavior", "H5_Manually", 0, paramInt, "", "", "", "");
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean b(AppRuntime paramAppRuntime, String paramString, long paramLong)
  {
    if (!(paramAppRuntime instanceof AppInterface)) {
      return false;
    }
    paramAppRuntime = (FriendListHandler)((AppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (paramAppRuntime != null)
    {
      paramAppRuntime.getRecentLoginDevList(paramLong, paramString, 0L);
      return true;
    }
    return false;
  }
  
  public int c(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return -1;
      }
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
      if (paramAppRuntime == null) {
        return -1;
      }
      return paramAppRuntime.askDevLockSms(paramString, paramWtloginObserver);
    }
    return -1;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean c(AppRuntime paramAppRuntime, String paramString, long paramLong)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    if (!(paramAppRuntime instanceof AppInterface)) {
      return false;
    }
    paramAppRuntime = (FriendListHandler)((AppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (paramAppRuntime != null)
    {
      paramAppRuntime.getAuthLoginDevList(paramLong, paramString, 0L);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.EquipmentLockImpl
 * JD-Core Version:    0.7.0.1
 */