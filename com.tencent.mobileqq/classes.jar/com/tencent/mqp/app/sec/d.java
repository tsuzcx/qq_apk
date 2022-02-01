package com.tencent.mqp.app.sec;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqprotect.common.QPMiscUtils;
import com.tencent.qqprotect.qsec.QSecFramework;
import mqq.app.MobileQQ;

public class d
{
  private static final String CMD_IE = "HunganSvc.Ie";
  public static final String CMD_PA = "MamonoSvc.Pa";
  public static final int TYPE_INIT = 1;
  public static final int TYPE_PUSH = 2;
  public static final int TYPE_QUERY = 3;
  public static final int TYPE_WORK = 4;
  private static Object[] ectx;
  private static byte[] edata;
  private static int etype = -1;
  
  public static void e(int paramInt, Object[] paramArrayOfObject, byte[] paramArrayOfByte)
  {
    QSecFramework.c().a(1, 0, paramInt, new Object[] { d.class, paramArrayOfObject, paramArrayOfByte }, null);
  }
  
  public static void e1(int paramInt, Object[] paramArrayOfObject, byte[] paramArrayOfByte)
  {
    ThreadManager.excute(new d.1(paramInt, paramArrayOfObject, paramArrayOfByte), 128, null, false);
  }
  
  public static void s(ToServiceMsg paramToServiceMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localQQAppInterface != null) {
      localQQAppInterface.sendToService(paramToServiceMsg);
    }
  }
  
  public static void w()
  {
    try
    {
      e(4, null, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public static Object[] x()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Object localObject7 = "";
    if (localBaseApplication != null) {
      localObject1 = Settings.System.getString(localBaseApplication.getContentResolver(), "android_id");
    } else {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "";
    }
    Object localObject3 = QPMiscUtils.c(2);
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    if (AppNetConnInfo.isNetSupport())
    {
      if (AppNetConnInfo.isWifiConn())
      {
        i = 1;
        break label91;
      }
      if (AppNetConnInfo.isMobileConn())
      {
        i = AppNetConnInfo.getMobileInfo() + 1;
        break label91;
      }
    }
    int i = 0;
    label91:
    localObject3 = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject3 != null) {
      localObject3 = ((QQAppInterface)localObject3).getCurrentAccountUin();
    } else {
      localObject3 = "";
    }
    Object localObject5 = QPMiscUtils.c(1);
    Object localObject4 = localObject5;
    if (localObject5 == null) {
      localObject4 = "";
    }
    Object localObject6 = QPMiscUtils.c(3);
    localObject5 = localObject6;
    if (localObject6 == null) {
      localObject5 = "";
    }
    String str = Build.CPU_ABI;
    localObject6 = str;
    if (str == null) {
      localObject6 = "";
    }
    str = Build.MODEL;
    if (str != null) {
      localObject7 = str;
    }
    return new Object[] { localBaseApplication, d.class, Build.VERSION.RELEASE, Integer.valueOf(AppSetting.d()), NetConnInfoCenter.GUID, ((String)localObject4).getBytes(), ((String)localObject2).getBytes(), Integer.valueOf(i), "mobileqq.service", localObject3, "req_pb_protocol_flag", ((String)localObject5).getBytes(), localObject1, localObject6, localObject7 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqp.app.sec.d
 * JD-Core Version:    0.7.0.1
 */