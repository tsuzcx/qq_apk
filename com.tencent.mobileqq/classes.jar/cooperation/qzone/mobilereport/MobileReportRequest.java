package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.UserActionReport;
import NS_USER_ACTION_REPORT.UserActionReportReq;
import NS_USER_ACTION_REPORT.UserCommReport;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class MobileReportRequest
  extends QzoneExternalRequest
{
  private static final String CmdString = "MobileReport.UserActionReport";
  private static final String UNIKEY = "UserActionReport";
  private final JceStruct req;
  
  public MobileReportRequest(int paramInt, UserCommReport paramUserCommReport, ArrayList<UserActionReport> paramArrayList)
  {
    this.req = new UserActionReportReq(paramInt, paramUserCommReport, paramArrayList);
    this.needCompress = false;
  }
  
  public String getCmdString()
  {
    return "MobileReport.UserActionReport";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "UserActionReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.mobilereport.MobileReportRequest
 * JD-Core Version:    0.7.0.1
 */