package com.tencent.mobileqq.vas.adv.common.data;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "", "(Ljava/lang/String;I)V", "SUCCEED", "CREATE_REQUEST_ERR", "REQUEST_CMD_ERROR", "REQUEST_RSP_PARSE_ERR", "REQUEST_RSP_FAIL", "CREATE_REPORT_ERR", "REPORT_CMD_ERROR", "REPORT_RSP_PARSE_ERR", "REPORT_RSP_FAIL", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public enum VasAdvServiceCode
{
  static
  {
    VasAdvServiceCode localVasAdvServiceCode1 = new VasAdvServiceCode("SUCCEED", 0);
    SUCCEED = localVasAdvServiceCode1;
    VasAdvServiceCode localVasAdvServiceCode2 = new VasAdvServiceCode("CREATE_REQUEST_ERR", 1);
    CREATE_REQUEST_ERR = localVasAdvServiceCode2;
    VasAdvServiceCode localVasAdvServiceCode3 = new VasAdvServiceCode("REQUEST_CMD_ERROR", 2);
    REQUEST_CMD_ERROR = localVasAdvServiceCode3;
    VasAdvServiceCode localVasAdvServiceCode4 = new VasAdvServiceCode("REQUEST_RSP_PARSE_ERR", 3);
    REQUEST_RSP_PARSE_ERR = localVasAdvServiceCode4;
    VasAdvServiceCode localVasAdvServiceCode5 = new VasAdvServiceCode("REQUEST_RSP_FAIL", 4);
    REQUEST_RSP_FAIL = localVasAdvServiceCode5;
    VasAdvServiceCode localVasAdvServiceCode6 = new VasAdvServiceCode("CREATE_REPORT_ERR", 5);
    CREATE_REPORT_ERR = localVasAdvServiceCode6;
    VasAdvServiceCode localVasAdvServiceCode7 = new VasAdvServiceCode("REPORT_CMD_ERROR", 6);
    REPORT_CMD_ERROR = localVasAdvServiceCode7;
    VasAdvServiceCode localVasAdvServiceCode8 = new VasAdvServiceCode("REPORT_RSP_PARSE_ERR", 7);
    REPORT_RSP_PARSE_ERR = localVasAdvServiceCode8;
    VasAdvServiceCode localVasAdvServiceCode9 = new VasAdvServiceCode("REPORT_RSP_FAIL", 8);
    REPORT_RSP_FAIL = localVasAdvServiceCode9;
    $VALUES = new VasAdvServiceCode[] { localVasAdvServiceCode1, localVasAdvServiceCode2, localVasAdvServiceCode3, localVasAdvServiceCode4, localVasAdvServiceCode5, localVasAdvServiceCode6, localVasAdvServiceCode7, localVasAdvServiceCode8, localVasAdvServiceCode9 };
  }
  
  private VasAdvServiceCode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode
 * JD-Core Version:    0.7.0.1
 */