package com.tencent.qqmini.sdk.utils;

import java.util.HashMap;

public class MiniSDKConst$AdConst
{
  public static final HashMap<Integer, String> CODE_MSG_MAP = new MiniSDKConst.AdConst.1();
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
  public static final String ERROR_MSG_BANNED = "广告组件被封禁";
  public static final String ERROR_MSG_CLOSED = "广告单元已关闭";
  public static final String ERROR_MSG_INNER_ERROR = "内部错误";
  public static final String ERROR_MSG_INVALID_ADUNITID = "广告单元无效";
  public static final String ERROR_MSG_INVALID_POSITION = "广告位置设置有误";
  public static final String ERROR_MSG_IN_REVIEW = "广告组件审核中";
  public static final String ERROR_MSG_NO_AD = "无合适的广告";
  public static final String ERROR_MSG_PARAM_ERROR = "参数错误";
  public static final String ERROR_MSG_REJECTED = "广告组件被驳回";
  public static final String ERROR_MSG_SERVICE_FAIL = "后端接口调用失败";
  public static final int KErrAdBlocked = -100100009;
  public static final int KErrAdDeleted = -100100002;
  public static final int KErrAdGdtNoData = -100100008;
  public static final int KErrAdNotFound = -100100007;
  public static final int KErrAdPositionExtIsNil = -100100005;
  public static final int KErrAdPositionIsNil = -100100004;
  public static final int KErrAdShutdown = -100100001;
  public static final int KErrAdStatusUnkown = -100100003;
  public static final int KErrAppNotFound = -100100006;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst
 * JD-Core Version:    0.7.0.1
 */