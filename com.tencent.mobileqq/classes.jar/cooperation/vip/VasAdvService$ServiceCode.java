package cooperation.vip;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/VasAdvService$ServiceCode;", "", "(Ljava/lang/String;I)V", "CREATE_REQUEST_ERR", "REQUEST_CMD_ERROR", "REQUEST_RSP_PARSE_ERR", "REQUEST_RSP_FAIL", "CREATE_REPORT_ERR", "REPORT_CMD_ERROR", "REPORT_RSP_PARSE_ERR", "REPORT_RSP_FAIL", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum VasAdvService$ServiceCode
{
  static
  {
    ServiceCode localServiceCode1 = new ServiceCode("CREATE_REQUEST_ERR", 0);
    CREATE_REQUEST_ERR = localServiceCode1;
    ServiceCode localServiceCode2 = new ServiceCode("REQUEST_CMD_ERROR", 1);
    REQUEST_CMD_ERROR = localServiceCode2;
    ServiceCode localServiceCode3 = new ServiceCode("REQUEST_RSP_PARSE_ERR", 2);
    REQUEST_RSP_PARSE_ERR = localServiceCode3;
    ServiceCode localServiceCode4 = new ServiceCode("REQUEST_RSP_FAIL", 3);
    REQUEST_RSP_FAIL = localServiceCode4;
    ServiceCode localServiceCode5 = new ServiceCode("CREATE_REPORT_ERR", 4);
    CREATE_REPORT_ERR = localServiceCode5;
    ServiceCode localServiceCode6 = new ServiceCode("REPORT_CMD_ERROR", 5);
    REPORT_CMD_ERROR = localServiceCode6;
    ServiceCode localServiceCode7 = new ServiceCode("REPORT_RSP_PARSE_ERR", 6);
    REPORT_RSP_PARSE_ERR = localServiceCode7;
    ServiceCode localServiceCode8 = new ServiceCode("REPORT_RSP_FAIL", 7);
    REPORT_RSP_FAIL = localServiceCode8;
    $VALUES = new ServiceCode[] { localServiceCode1, localServiceCode2, localServiceCode3, localServiceCode4, localServiceCode5, localServiceCode6, localServiceCode7, localServiceCode8 };
  }
  
  private VasAdvService$ServiceCode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.VasAdvService.ServiceCode
 * JD-Core Version:    0.7.0.1
 */