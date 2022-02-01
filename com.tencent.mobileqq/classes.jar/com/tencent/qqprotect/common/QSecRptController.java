package com.tencent.qqprotect.common;

import android.os.Build;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.SafeReport.LogItem;
import com.tencent.ims.SafeReport.ReqBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QSecRptController
{
  protected static int a(int paramInt)
  {
    if (paramInt > 100) {
      return 2;
    }
    return 1;
  }
  
  public static void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, 0, 1);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, 0, paramInt2);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    QSecRptControllerImpl.a().b(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface)
  {
    SafeReport.ReqBody localReqBody = new SafeReport.ReqBody();
    SafeReport.LogItem localLogItem = new SafeReport.LogItem();
    localLogItem.uint32_rpt_id.set(paramInt1);
    String str = b(a(paramInt1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localLogItem.bytes_rpt_data.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    localReqBody.LogItem_reportdata.add(localLogItem);
    if (QLog.isColorLevel()) {
      QLog.d("QSRPT", 2, paramString);
    }
    ThreadManager.post(new QSecRptController.1(paramQQAppInterface, localReqBody), 5, null, true);
  }
  
  protected static String b(int paramInt)
  {
    try
    {
      Object localObject1 = NetConnInfoCenter.GUID;
      String str1 = DeviceInfoUtil.g();
      String str2 = DeviceInfoUtil.a(MobileQQ.sMobileQQ);
      String str3 = QPMiscUtils.c();
      String str4 = QPMiscUtils.d();
      String str5 = Build.CPU_ABI;
      String str6 = Build.MODEL;
      String str7 = Build.MANUFACTURER;
      QSecRptHelper localQSecRptHelper = new QSecRptHelper();
      localQSecRptHelper.a((byte[])localObject1).a(str1).a(str2).a(str3).a(str4).a(str5).a(str6).a(str7);
      if (paramInt >= 2) {
        localQSecRptHelper.a(QPMiscUtils.a()).a(AppSetting.d()).a(DeviceInfoUtil.j()).a("").a("");
      }
      localObject1 = localQSecRptHelper.toString();
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      Object localObject2 = ",,,,,,,";
      if (paramInt >= 2)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(",,,,,,,");
        ((StringBuilder)localObject2).append(",,,,");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      return localObject2;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SafeReport.ReqBody paramReqBody)
  {
    if (paramReqBody == null) {
      return;
    }
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    ProtoUtils.a(localQQAppInterface, new QSecRptController.2(), paramReqBody.toByteArray(), "MqqSafeDataRpt.MQDun");
  }
  
  public static void b(String paramString, int paramInt)
  {
    a(paramString, paramInt, 0, null);
  }
  
  protected void b(String paramString, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.common.QSecRptController
 * JD-Core Version:    0.7.0.1
 */