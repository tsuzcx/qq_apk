package com.tencent.mobileqq.mini.appbrand.jsapi;

import ajjy;
import java.util.HashMap;

public class PluginConst$AdConst
{
  public static final HashMap<Integer, String> CodeMsgMap = new PluginConst.AdConst.1();
  public static final int ERROR_CODE_BANNED = 1007;
  public static final int ERROR_CODE_CLOSED = 1008;
  public static final int ERROR_CODE_INNER_ERROR = 1003;
  public static final int ERROR_CODE_INVALID_ADUNITID = 1002;
  public static final int ERROR_CODE_IN_REVIEW = 1005;
  public static final int ERROR_CODE_NO_AD = 1004;
  public static final int ERROR_CODE_PARAM_ERROR = 1001;
  public static final int ERROR_CODE_REJECTED = 1006;
  public static final int ERROR_CODE_SERVICE_FAIL = 1000;
  public static final String ERROR_MSG_BANNED;
  public static final String ERROR_MSG_CLOSED;
  public static final String ERROR_MSG_INNER_ERROR;
  public static final String ERROR_MSG_INVALID_ADUNITID;
  public static final String ERROR_MSG_IN_REVIEW;
  public static final String ERROR_MSG_NO_AD;
  public static final String ERROR_MSG_PARAM_ERROR;
  public static final String ERROR_MSG_REJECTED;
  public static final String ERROR_MSG_SERVICE_FAIL = ajjy.a(2131642472);
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
    ERROR_MSG_PARAM_ERROR = ajjy.a(2131642478);
    ERROR_MSG_INVALID_ADUNITID = ajjy.a(2131642476);
    ERROR_MSG_INNER_ERROR = ajjy.a(2131642479);
    ERROR_MSG_NO_AD = ajjy.a(2131642475);
    ERROR_MSG_IN_REVIEW = ajjy.a(2131642473);
    ERROR_MSG_REJECTED = ajjy.a(2131642474);
    ERROR_MSG_BANNED = ajjy.a(2131642477);
    ERROR_MSG_CLOSED = ajjy.a(2131642471);
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
    }
    return 1004;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst
 * JD-Core Version:    0.7.0.1
 */