package com.tencent.mobileqq.util;

import com.tencent.ad.tangram.version.AdVersion;
import com.tencent.gathererga.tangram.TangramGlobalSetting.Builder;
import com.tencent.gathererga.tangram.TangramService.Factory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ADGatherSdkInitHelper
{
  private static boolean a = false;
  
  public static void a()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    QLog.i("ADGatherSdkInitHelper", 1, "init GatherSDK ");
    if (a)
    {
      QLog.i("ADGatherSdkInitHelper", 1, "init GatherSDK already done,return");
      return;
    }
    try
    {
      ADGatherSdkInitHelper.1 local1 = new ADGatherSdkInitHelper.1();
      TangramService.Factory.a(localBaseApplication, new TangramGlobalSetting.Builder().a(new ADGatherSdkInitHelper.2()).a(false).a("1109803375").b(AdVersion.INSTANCE.getAppVersion()).a(local1).a());
      a = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ADGatherSdkInitHelper", 1, localThrowable, new Object[] { "Gather init crash fail" });
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ADGatherSdkInitHelper
 * JD-Core Version:    0.7.0.1
 */