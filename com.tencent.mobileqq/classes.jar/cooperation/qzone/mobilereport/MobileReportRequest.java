package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.QQSchemaInfo;
import NS_USER_ACTION_REPORT.QQStayTimeInfo;
import NS_USER_ACTION_REPORT.UserActionReport;
import NS_USER_ACTION_REPORT.UserActionReportReq;
import NS_USER_ACTION_REPORT.UserActionReportRsp;
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
  
  public MobileReportRequest(int paramInt, UserCommReport paramUserCommReport, ArrayList<UserActionReport> paramArrayList, ArrayList<QQStayTimeInfo> paramArrayList1, ArrayList<QQSchemaInfo> paramArrayList2)
  {
    this.req = new UserActionReportReq(paramInt, paramUserCommReport, paramArrayList, paramArrayList1, paramArrayList2);
    this.needCompress = false;
  }
  
  public static UserActionReportRsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    UserActionReportRsp localUserActionReportRsp;
    do
    {
      return paramArrayOfByte;
      localUserActionReportRsp = (UserActionReportRsp)decode(paramArrayOfByte, "UserActionReport");
      paramArrayOfByte = localUserActionReportRsp;
    } while (localUserActionReportRsp != null);
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.mobilereport.MobileReportRequest
 * JD-Core Version:    0.7.0.1
 */