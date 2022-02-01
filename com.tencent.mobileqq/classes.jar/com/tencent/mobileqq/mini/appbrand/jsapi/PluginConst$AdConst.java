package com.tencent.mobileqq.mini.appbrand.jsapi;

import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.HashMap;

public class PluginConst$AdConst
{
  public static final HashMap<Integer, String> CodeMsgMap = new PluginConst.AdConst.1();
  public static final int ERROR_CODE_BANNED = 1007;
  public static final int ERROR_CODE_CLOSED = 1008;
  public static final int ERROR_CODE_INNER_ERROR = 1003;
  public static final int ERROR_CODE_INVALID_ADUNITID = 1002;
  public static final int ERROR_CODE_INVALID_POSITION = 1009;
  public static final int ERROR_CODE_IN_REVIEW = 1005;
  public static final int ERROR_CODE_NO_AD = 1004;
  public static final int ERROR_CODE_PARAM_ERROR = 1001;
  public static final int ERROR_CODE_REJECTED = 1006;
  public static final int ERROR_CODE_SERVICE_FAIL = 1000;
  public static final String ERROR_MSG_BANNED;
  public static final String ERROR_MSG_CLOSED;
  public static final String ERROR_MSG_INNER_ERROR;
  public static final String ERROR_MSG_INVALID_ADUNITID;
  public static final String ERROR_MSG_INVALID_POSITION;
  public static final String ERROR_MSG_IN_REVIEW;
  public static final String ERROR_MSG_NO_AD;
  public static final String ERROR_MSG_PARAM_ERROR;
  public static final String ERROR_MSG_REJECTED;
  public static final String ERROR_MSG_SERVICE_FAIL = HardCodeUtil.a(2131708243);
  public static final int KErrAdBlocked = -100100009;
  public static final int KErrAdDeleted = -100100002;
  public static final int KErrAdGdtNoData = -100100008;
  public static final int KErrAdNotFound = -100100007;
  public static final int KErrAdPositionExtIsNil = -100100005;
  public static final int KErrAdPositionIsNil = -100100004;
  public static final int KErrAdShutdown = -100100001;
  public static final int KErrAdStatusUnkown = -100100003;
  public static final int KErrAppNotFound = -100100006;
  
  static
  {
    ERROR_MSG_PARAM_ERROR = HardCodeUtil.a(2131708249);
    ERROR_MSG_INVALID_ADUNITID = HardCodeUtil.a(2131708247);
    ERROR_MSG_INNER_ERROR = HardCodeUtil.a(2131708250);
    ERROR_MSG_NO_AD = HardCodeUtil.a(2131708246);
    ERROR_MSG_IN_REVIEW = HardCodeUtil.a(2131708244);
    ERROR_MSG_REJECTED = HardCodeUtil.a(2131708245);
    ERROR_MSG_BANNED = HardCodeUtil.a(2131708248);
    ERROR_MSG_CLOSED = HardCodeUtil.a(2131708242);
    ERROR_MSG_INVALID_POSITION = HardCodeUtil.a(2131694157);
  }
  
  public static int getRetCodeByServerResult(int paramInt)
  {
    if ((paramInt >= -100101009) && (paramInt <= -100101000)) {
      return 1000;
    }
    switch (paramInt)
    {
    default: 
      return -1;
    case -100100002: 
    case -100100001: 
      return 1008;
    case -100100007: 
    case -100100004: 
    case -100100003: 
      return 1002;
    case -100100006: 
    case -100100005: 
      return 1001;
    case -100100008: 
      return 1004;
    }
    return 1007;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst
 * JD-Core Version:    0.7.0.1
 */