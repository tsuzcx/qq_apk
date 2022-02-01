package cooperation.qzone.report.wmd;

import NS_MOBILE_CLIENT_REPORT.CLIENT_NBP_REPORT_REQ;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QZoneCommonRequest;
import java.util.ArrayList;
import java.util.Map;

public class WMDReportReq
  extends QZoneCommonRequest
{
  private static final String CMD = "nbpClientReport";
  public JceStruct req;
  
  public WMDReportReq(String paramString, ArrayList<String> paramArrayList, Map<String, String> paramMap)
  {
    CLIENT_NBP_REPORT_REQ localCLIENT_NBP_REPORT_REQ = new CLIENT_NBP_REPORT_REQ();
    localCLIENT_NBP_REPORT_REQ.strABTestId = paramString;
    localCLIENT_NBP_REPORT_REQ.report_info = paramArrayList;
    localCLIENT_NBP_REPORT_REQ.extra_info = paramMap;
    this.req = localCLIENT_NBP_REPORT_REQ;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.nbpClientReport";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public int getType()
  {
    return 0;
  }
  
  public String uniKey()
  {
    return "nbpClientReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.report.wmd.WMDReportReq
 * JD-Core Version:    0.7.0.1
 */