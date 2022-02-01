package com.tencent.mobileqq.vip;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.config.business.qvip.QVipSDKProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
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
    if (TMSManager.SingletonInstance.a().jdField_a_of_type_ComTencentMobileqqVipKCWraper == null) {}
    synchronized (TMSManager.SingletonInstance.a())
    {
      if (TMSManager.SingletonInstance.a().jdField_a_of_type_ComTencentMobileqqVipKCWraper == null) {
        TMSManager.SingletonInstance.a().a();
      }
      return TMSManager.SingletonInstance.a();
    }
  }
  
  private void a()
  {
    int i = QVipSDKProcessor.c().a;
    QLog.d("KC.TMSManager", 1, "KingCardConfig : " + i);
    switch (i)
    {
    case 0: 
    case 1: 
    default: 
      this.jdField_a_of_type_ComTencentMobileqqVipKCWraper = new KCWraper();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVipKCWraper != null) {
        b();
      }
      return;
      if (a(BaseApplicationImpl.getApplication())) {
        this.jdField_a_of_type_ComTencentMobileqqVipKCWraper = new KCWraperV2();
      } else if (KCWraper.c()) {
        this.jdField_a_of_type_ComTencentMobileqqVipKCWraper = new KCWraperV2InOtherProcess();
      }
    }
  }
  
  protected static boolean a(Context paramContext)
  {
    int i = Process.myPid();
    String str = "";
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    if (localObject == null) {
      return false;
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid != i) {
        break label88;
      }
      str = localRunningAppProcessInfo.processName;
    }
    label88:
    for (;;)
    {
      break;
      return paramContext.getPackageName().equals(str);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipKCWraper != null) {
      this.jdField_a_of_type_ComTencentMobileqqVipKCWraper.a(new TMSManager.2(this));
    }
  }
  
  void a(ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVipKCWraper != null) && (this.jdField_a_of_type_ComTencentMobileqqVipKCWraper.a())) {
      this.jdField_a_of_type_ComTencentMobileqqVipKCWraper.a(paramViewGroup);
    }
  }
  
  public void a(TMSManager.Callback paramCallback, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVipKCWraper != null) && (this.jdField_a_of_type_ComTencentMobileqqVipKCWraper.a())) {
      this.jdField_a_of_type_ComTencentMobileqqVipKCWraper.a(paramCallback, paramBoolean);
    }
    while (paramCallback == null) {
      return;
    }
    if (paramBoolean)
    {
      ThreadManager.getUIHandler().post(new TMSManager.1(this, paramCallback));
      return;
    }
    paramCallback.a(false, false, 0);
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/mobileqq/vip/TMSManager:jdField_a_of_type_ComTencentMobileqqVipKCWraper	Lcom/tencent/mobileqq/vip/KCWraper;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 27	com/tencent/mobileqq/vip/TMSManager:jdField_a_of_type_ComTencentMobileqqVipKCWraper	Lcom/tencent/mobileqq/vip/KCWraper;
    //   13: invokevirtual 162	com/tencent/mobileqq/vip/KCWraper:a	()Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq +9 -> 27
    //   21: iconst_1
    //   22: istore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -6 -> 23
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	TMSManager
    //   16	13	1	bool	boolean
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  public boolean a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVipKCWraper != null) && (this.jdField_a_of_type_ComTencentMobileqqVipKCWraper.a())) {
      return this.jdField_a_of_type_ComTencentMobileqqVipKCWraper.a(paramActivity);
    }
    return false;
  }
  
  public boolean b()
  {
    return CUKingCardHelper.a() > 0;
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVipKCWraper != null) && (this.jdField_a_of_type_ComTencentMobileqqVipKCWraper.a())) {
      return this.jdField_a_of_type_ComTencentMobileqqVipKCWraper.b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.TMSManager
 * JD-Core Version:    0.7.0.1
 */