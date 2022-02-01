package com.tencent.mobileqq.vip;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.TreasureCardConfig;
import com.tencent.mobileqq.vas.config.business.qvip.TreasureCardProcessor;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class TMSManager
{
  protected static final String[] a = { "tmsdualcore", "tmsdualcore785", "tmsdualcore790", "tmsdualcore7901" };
  private KCWraper b = null;
  
  public static TMSManager a()
  {
    if (TMSManager.SingletonInstance.a().b == null) {
      synchronized (TMSManager.SingletonInstance.a())
      {
        if (TMSManager.SingletonInstance.a().b == null)
        {
          TMSManager.SingletonInstance.a().f();
          if (TreasureCardProcessor.e().d == 1) {
            VasUtil.a().getVasFtManager().init();
          }
        }
      }
    }
    return TMSManager.SingletonInstance.a();
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
  
  public static TMSManager.DynamicLoadHelper b()
  {
    return TMSManager.DynamicLoadInstance.a();
  }
  
  private void f()
  {
    int i = QVipSDKProcessor.e().a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KingCardConfig : ");
    localStringBuilder.append(i);
    QLog.d("KC.TMSManager", 1, localStringBuilder.toString());
    if (i != -1) {
      if (i != 2) {
        this.b = new KCWraper();
      } else if (a(VasUtil.c().getApplicationContext())) {
        this.b = new KCWraperV2();
      } else if (KCWraper.e()) {
        this.b = new KCWraperV2InOtherProcess();
      }
    }
    if (this.b != null) {
      g();
    }
  }
  
  private void g()
  {
    KCWraper localKCWraper = this.b;
    if (localKCWraper != null) {
      localKCWraper.a(new TMSManager.2(this));
    }
  }
  
  void a(ViewGroup paramViewGroup)
  {
    KCWraper localKCWraper = this.b;
    if ((localKCWraper != null) && (localKCWraper.b())) {
      this.b.a(paramViewGroup);
    }
  }
  
  public void a(TMSManager.Callback paramCallback, boolean paramBoolean)
  {
    KCWraper localKCWraper = this.b;
    if ((localKCWraper != null) && (localKCWraper.b()))
    {
      this.b.a(paramCallback, paramBoolean);
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
  
  public boolean a(Activity paramActivity)
  {
    KCWraper localKCWraper = this.b;
    if ((localKCWraper != null) && (localKCWraper.b())) {
      return this.b.a(paramActivity);
    }
    return false;
  }
  
  public boolean c()
  {
    try
    {
      if (this.b != null)
      {
        boolean bool = this.b.b();
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
  
  public boolean d()
  {
    return CUKingCardUtils.a() > 0;
  }
  
  public boolean e()
  {
    KCWraper localKCWraper = this.b;
    if ((localKCWraper != null) && (localKCWraper.b())) {
      return this.b.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.TMSManager
 * JD-Core Version:    0.7.0.1
 */