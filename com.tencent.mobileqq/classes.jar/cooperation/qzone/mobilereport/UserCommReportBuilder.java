package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.UserCommReport;
import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import cooperation.qzone.QUA;

public class UserCommReportBuilder
{
  private String network_type;
  private long uin;
  
  public UserCommReport build()
  {
    UserCommReport localUserCommReport = new UserCommReport();
    localUserCommReport.uin = this.uin;
    localUserCommReport.platform = "AND";
    localUserCommReport.client_type = "SQ";
    localUserCommReport.network_type = this.network_type;
    localUserCommReport.qua = QUA.getQUA3();
    localUserCommReport.app_version = AppSetting.f();
    localUserCommReport.os_version = DeviceInfoUtil.e();
    localUserCommReport.mobile_type = Build.MODEL;
    return localUserCommReport;
  }
  
  public UserCommReportBuilder setNetwork_type(String paramString)
  {
    this.network_type = paramString;
    return this;
  }
  
  public UserCommReportBuilder setUin(long paramLong)
  {
    this.uin = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.mobilereport.UserCommReportBuilder
 * JD-Core Version:    0.7.0.1
 */