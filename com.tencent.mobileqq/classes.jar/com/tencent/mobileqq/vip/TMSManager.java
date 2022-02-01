package com.tencent.mobileqq.vip;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class TMSManager
{
  protected static final String[] a;
  private KCWraper a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "tmsdualcore", "tmsdualcore785", "tmsdualcore790", "tmsdualcore7901" };
  }
  
  public TMSManager()
  {
    this.jdField_a_of_type_ComTencentMobileqqVipKCWraper = null;
  }
  
  public static TMSManager.DynamicLoadHelper a()
  {
    return TMSManager.DynamicLoadInstance.a();
  }
  
  public static TMSManager a()
  {
    if (TMSManager.SingletonInstance.a().jdField_a_of_type_ComTencentMobileqqVipKCWraper == null) {
      synchronized (TMSManager.SingletonInstance.a())
      {
        if (TMSManager.SingletonInstance.a().jdField_a_of_type_ComTencentMobileqqVipKCWraper == null) {
          TMSManager.SingletonInstance.a().a();
        }
      }
    }
    return TMSManager.SingletonInstance.a();
  }
  
  private void a()
  {
    int i = QVipSDKProcessor.c().a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KingCardConfig : ");
    localStringBuilder.append(i);
    QLog.d("KC.TMSManager", 1, localStringBuilder.toString());
    if (i != -1) {
      if (i != 2) {
        this.jdField_a_of_type_ComTencentMobileqqVipKCWraper = new KCWraper();
      } else if (a(VasUtil.a().getApplicationContext())) {
        this.jdField_a_of_type_ComTencentMobileqqVipKCWraper = new KCWraperV2();
      } else if (KCWraper.c()) {
        this.jdField_a_of_type_ComTencentMobileqqVipKCWraper = new KCWraperV2InOtherProcess();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipKCWraper != null) {
      b();
    }
  }
  
  protected static boolean a(Context paramContext)
  {
    int i = Process.myPid();
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    if (localObject == null) {
      return false;
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    Iterator localIterator = ((List)localObject).iterator();
    localObject = "";
    while (localIterator.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (localRunningAppProcessInfo.pid == i) {
        localObject = localRunningAppProcessInfo.processName;
      }
    }
    return paramContext.getPackageName().equals(localObject);
  }
  
  private void b()
  {
    KCWraper localKCWraper = this.jdField_a_of_type_ComTencentMobileqqVipKCWraper;
    if (localKCWraper != null) {
      localKCWraper.a(new TMSManager.2(this));
    }
  }
  
  void a(ViewGroup paramViewGroup)
  {
    KCWraper localKCWraper = this.jdField_a_of_type_ComTencentMobileqqVipKCWraper;
    if ((localKCWraper != null) && (localKCWraper.a())) {
      this.jdField_a_of_type_ComTencentMobileqqVipKCWraper.a(paramViewGroup);
    }
  }
  
  public void a(TMSManager.Callback paramCallback, boolean paramBoolean)
  {
    KCWraper localKCWraper = this.jdField_a_of_type_ComTencentMobileqqVipKCWraper;
    if ((localKCWraper != null) && (localKCWraper.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqVipKCWraper.a(paramCallback, paramBoolean);
      return;
    }
    if (paramCallback != null)
    {
      if (paramBoolean)
      {
        ThreadManager.getUIHandler().post(new TMSManager.1(this, paramCallback));
        return;
      }
      paramCallback.a(false, false, 0);
    }
  }
  
  public boolean a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVipKCWraper != null)
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqVipKCWraper.a();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(Activity paramActivity)
  {
    KCWraper localKCWraper = this.jdField_a_of_type_ComTencentMobileqqVipKCWraper;
    if ((localKCWraper != null) && (localKCWraper.a())) {
      return this.jdField_a_of_type_ComTencentMobileqqVipKCWraper.a(paramActivity);
    }
    return false;
  }
  
  public boolean b()
  {
    return CUKingCardUtils.a() > 0;
  }
  
  public boolean c()
  {
    KCWraper localKCWraper = this.jdField_a_of_type_ComTencentMobileqqVipKCWraper;
    if ((localKCWraper != null) && (localKCWraper.a())) {
      return this.jdField_a_of_type_ComTencentMobileqqVipKCWraper.b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.TMSManager
 * JD-Core Version:    0.7.0.1
 */