package com.tencent.mobileqq.kandian.biz.account;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xefb.oidb_cmd0xefb.ReqBody;

public class RIJUserLevelTimeUtils
{
  private static int a(String paramString, int paramInt)
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(390);
    int i = paramInt;
    if (localAladdinConfig != null) {
      i = localAladdinConfig.getIntegerFromString(paramString, paramInt);
    }
    return i;
  }
  
  public static void a(int paramInt)
  {
    long l1 = RIJQQAppInterfaceUtil.c();
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    paramInt /= 60000;
    oidb_cmd0xefb.ReqBody localReqBody = new oidb_cmd0xefb.ReqBody();
    localReqBody.timeInterval.set(paramInt);
    localReqBody.timestamp.set(l2);
    localReqBody.uin.set(l1);
    ProtoUtils.a(localQQAppInterface, new RIJUserLevelTimeUtils.Observer(null), localReqBody.toByteArray(), "OidbSvc.0xefb", 3835, 0);
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (a("rij_ugc_privilege_timer_switch", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static long b()
  {
    return a("rij_ugc_privilege_max_time_day", 60) * 60 * 1000;
  }
  
  public static void b(int paramInt)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    Object localObject = Long.valueOf(0L);
    long l2 = ((Long)RIJSPUtils.b("last_record_date", localObject)).longValue();
    if (l1 - l2 >= 86400000L)
    {
      a(paramInt);
      RIJSPUtils.a("last_record_date", Long.valueOf(l1));
      RIJSPUtils.a("has_record_time", Integer.valueOf(paramInt));
    }
    else
    {
      long l3 = ((Long)RIJSPUtils.b("has_record_time", localObject)).longValue();
      if (l3 <= b())
      {
        a(paramInt);
        RIJSPUtils.a("has_record_time", Long.valueOf(l3 + paramInt));
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doReport ,currentTime=");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(" ，firstRecordTime=");
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append(" ,reportTime=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("RIJUserLevelTimeUtils", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.RIJUserLevelTimeUtils
 * JD-Core Version:    0.7.0.1
 */