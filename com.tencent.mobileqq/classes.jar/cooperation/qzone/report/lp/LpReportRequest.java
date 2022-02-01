package cooperation.qzone.report.lp;

import NS_MOBILE_CLIENT_UPDATE.CLIENT_REPORT_REQ;
import NS_MOBILE_CLIENT_UPDATE.CLIENT_REPORT_RSP;
import NS_MOBILE_CLIENT_UPDATE.REPORT_INFO;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;
import java.util.Map;

public class LpReportRequest
  extends QzoneExternalRequest
{
  private static final String CMD = "update.ClientReport";
  public static final String UNI_KEY = "ClientReport";
  public JceStruct req;
  
  public LpReportRequest(long paramLong, ArrayList<Map<String, String>> paramArrayList, Map<String, String> paramMap, ArrayList<REPORT_INFO> paramArrayList1)
  {
    CLIENT_REPORT_REQ localCLIENT_REPORT_REQ = new CLIENT_REPORT_REQ();
    localCLIENT_REPORT_REQ.type = paramLong;
    localCLIENT_REPORT_REQ.info = paramArrayList;
    localCLIENT_REPORT_REQ.extra_info = paramMap;
    localCLIENT_REPORT_REQ.multi_info = paramArrayList1;
    this.req = localCLIENT_REPORT_REQ;
  }
  
  public static CLIENT_REPORT_RSP onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = decode(paramArrayOfByte, "ClientReport");
    if ((paramArrayOfByte instanceof CLIENT_REPORT_RSP)) {
      return (CLIENT_REPORT_RSP)paramArrayOfByte;
    }
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.update.ClientReport";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "ClientReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportRequest
 * JD-Core Version:    0.7.0.1
 */