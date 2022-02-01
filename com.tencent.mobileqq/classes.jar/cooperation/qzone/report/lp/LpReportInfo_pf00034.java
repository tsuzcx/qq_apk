package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

public class LpReportInfo_pf00034
  implements LpReportInfo
{
  private static final String AND_APPID = "1000027";
  private static final String OS_AND = "android";
  private static final int REPORT_FROM_CLIENT = 2;
  public static String TAG = "LpReport.LpReportInfo_pf00034";
  private String browserType;
  private String cpu;
  private String deviceInfo;
  private String gatewayIp;
  private String imei;
  public int isActivity = 0;
  public int loginFrom;
  public String loginSource;
  private String memory;
  private String mobileType;
  private String networkType;
  private String osVersion;
  private int pageType;
  private String platform;
  private String qua;
  private String respondType;
  public String source;
  public String testId;
  public int toUin;
  private int uin;
  
  public LpReportInfo_pf00034(int paramInt)
  {
    this.loginFrom = paramInt;
  }
  
  public LpReportInfo_pf00034(int paramInt1, int paramInt2)
  {
    this.loginFrom = paramInt1;
    this.toUin = paramInt2;
  }
  
  public String getSimpleInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pf00034:login from = ");
    localStringBuilder.append(this.loginFrom);
    return localStringBuilder.toString();
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    try
    {
      LpReportUtils.safePut(localHashMap, "app_id", "1000027");
      LpReportUtils.safePut(localHashMap, "uin", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount());
      LpReportUtils.safePut(localHashMap, "touin", this.toUin);
      LpReportUtils.safePut(localHashMap, "network_type", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getnetworkType());
      LpReportUtils.safePut(localHashMap, "app_version", "8.7.0");
      LpReportUtils.safePut(localHashMap, "qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
      LpReportUtils.safePut(localHashMap, "platform", "android");
      LpReportUtils.safePut(localHashMap, "device_info", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getDeviceInfor());
      LpReportUtils.safePut(localHashMap, "login_from", this.loginFrom);
      LpReportUtils.safePut(localHashMap, "is_activity", this.isActivity);
      LpReportUtils.safePut(localHashMap, "test_id", this.testId);
      LpReportUtils.safePut(localHashMap, "report_from", 2);
      return localHashMap;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, localException, new Object[0]);
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_pf00034
 * JD-Core Version:    0.7.0.1
 */