package com.tencent.mqp.app.sec;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import bdzl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
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
    QSecFramework.a().a(1, 0, paramInt, new Object[] { d.class, paramArrayOfObject, paramArrayOfByte }, null);
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
      while (localThrowable == null) {}
      localThrowable.printStackTrace();
    }
  }
  
  public static Object[] x()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str1 = "";
    if (localBaseApplication != null) {
      str1 = Settings.Secure.getString(localBaseApplication.getContentResolver(), "android_id");
    }
    if (TextUtils.isEmpty(str1)) {
      str1 = "";
    }
    for (;;)
    {
      String str2 = bdzl.b(2);
      if (str2 == null) {
        str2 = "";
      }
      for (;;)
      {
        int i;
        if (AppNetConnInfo.isNetSupport()) {
          if (AppNetConnInfo.isWifiConn()) {
            i = 1;
          }
        }
        for (;;)
        {
          Object localObject1 = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
          if (localObject1 != null) {}
          for (localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin();; localObject1 = "")
          {
            Object localObject3 = bdzl.b(1);
            Object localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            Object localObject4 = bdzl.b(3);
            localObject3 = localObject4;
            if (localObject4 == null) {
              localObject3 = "";
            }
            Object localObject5 = Build.CPU_ABI;
            localObject4 = localObject5;
            if (localObject5 == null) {
              localObject4 = "";
            }
            String str3 = Build.MODEL;
            localObject5 = str3;
            if (str3 == null) {
              localObject5 = "";
            }
            return new Object[] { localBaseApplication, d.class, Build.VERSION.RELEASE, Integer.valueOf(AppSetting.a()), NetConnInfoCenter.GUID, ((String)localObject2).getBytes(), str1.getBytes(), Integer.valueOf(i), "mobileqq.service", localObject1, "req_pb_protocol_flag", ((String)localObject3).getBytes(), str2, localObject4, localObject5 };
            if (!AppNetConnInfo.isMobileConn()) {
              break label279;
            }
            i = AppNetConnInfo.getMobileInfo() + 1;
            break;
          }
          label279:
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mqp.app.sec.d
 * JD-Core Version:    0.7.0.1
 */