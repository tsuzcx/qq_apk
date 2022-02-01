package cooperation.qzone.qboss;

import NS_MOBILE_QBOSS_PROTO.MobileQbossReportExceptionReq;
import NS_MOBILE_QBOSS_PROTO.MobileQbossReportExceptionRsp;
import NS_MOBILE_QBOSS_PROTO.ReportExceptionInfo;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class QbossErrorReportRequest
  extends QzoneExternalRequest
{
  private static final String CMD_STRING = "mobileqboss.reportException";
  private static final String UNIKEY = "reportException";
  private JceStruct req;
  
  public QbossErrorReportRequest(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    ReportExceptionInfo localReportExceptionInfo = new ReportExceptionInfo();
    localReportExceptionInfo.iCode = paramInt3;
    localReportExceptionInfo.iAppid = paramInt1;
    localReportExceptionInfo.iTaskId = paramInt2;
    localReportExceptionInfo.strMsg = paramString;
    localArrayList.add(localReportExceptionInfo);
    this.req = new MobileQbossReportExceptionReq(paramLong, localArrayList);
  }
  
  public static MobileQbossReportExceptionRsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    MobileQbossReportExceptionRsp localMobileQbossReportExceptionRsp;
    do
    {
      return paramArrayOfByte;
      localMobileQbossReportExceptionRsp = (MobileQbossReportExceptionRsp)decode(paramArrayOfByte, "reportException");
      paramArrayOfByte = localMobileQbossReportExceptionRsp;
    } while (localMobileQbossReportExceptionRsp != null);
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.mobileqboss.reportException";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "reportException";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.qboss.QbossErrorReportRequest
 * JD-Core Version:    0.7.0.1
 */