import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xefb.oidb_cmd0xefb.ReqBody;

public class prj
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
  
  public static long a()
  {
    return a("rij_ugc_privilege_max_time_day", 60) * 60 * 1000;
  }
  
  public static void a(int paramInt)
  {
    long l1 = pkh.a();
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    QQAppInterface localQQAppInterface = pnn.a();
    paramInt /= 60000;
    oidb_cmd0xefb.ReqBody localReqBody = new oidb_cmd0xefb.ReqBody();
    localReqBody.timeInterval.set(paramInt);
    localReqBody.timestamp.set(l2);
    localReqBody.uin.set(l1);
    ntb.a(localQQAppInterface, new prl(null), localReqBody.toByteArray(), "OidbSvc.0xefb", 3835, 0);
  }
  
  public static boolean a()
  {
    return a("rij_ugc_privilege_timer_switch", 0) == 1;
  }
  
  public static void b(int paramInt)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = ((Long)bmhv.a("last_record_date", Long.valueOf(0L))).longValue();
    if (l1 - l2 >= 86400000L)
    {
      a(paramInt);
      bmhv.a("last_record_date", Long.valueOf(l1));
      bmhv.a("has_record_time", Integer.valueOf(paramInt));
    }
    for (;;)
    {
      QLog.d("RIJUserLevelTimeUtils", 2, "doReport ,currentTime=" + l1 + " ，firstRecordTime=" + l2 + " ,reportTime=" + paramInt);
      return;
      long l3 = ((Long)bmhv.a("has_record_time", Long.valueOf(0L))).longValue();
      if (l3 <= a())
      {
        a(paramInt);
        bmhv.a("has_record_time", Long.valueOf(l3 + paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prj
 * JD-Core Version:    0.7.0.1
 */