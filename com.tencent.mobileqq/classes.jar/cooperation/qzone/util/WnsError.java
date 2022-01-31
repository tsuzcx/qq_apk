package cooperation.qzone.util;

import common.config.service.QzoneConfig;

public final class WnsError
{
  public static final String DEFAULT_ERROR_MESSAGE = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "WnsErrorMessage", "服务器繁忙");
  public static final String DEFAULT_ERROR_MESSAGE_ILLIGAL_APPID = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "WnsErrorMessageIllegalAppid", "非法APPID");
  public static final String DEFAULT_ERROR_MESSAGE_WAIT = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "WnsErrorMessageWait", "网络繁忙，请等待");
  public static final String DEFAULT_SUCCESS_MESSAGE = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "WnsSuccessMessage", "成功");
  public static final boolean SHOW_RESULT_CODE = true;
  public static final int SUCCESS = 0;
  public static final int WNS_CODE_DIS_STAT_BEGIN = 2400;
  public static final int WNS_CODE_DIS_STAT_END = 2499;
  public static final int WNS_CODE_LOGIN_3GSVR_BUSY = 1902;
  public static final int WNS_CODE_LOGIN_A2_CHANGED = 1907;
  public static final int WNS_CODE_LOGIN_A2_EXPIRED = 1906;
  public static final int WNS_CODE_LOGIN_A2_ILLEGAL = 1903;
  public static final int WNS_CODE_LOGIN_B2_EXPIRED = 1910;
  public static final int WNS_CODE_LOGIN_CREATEUIDFAIL = 1909;
  public static final int WNS_CODE_LOGIN_ILLIGAL_APPID = 1912;
  public static final int WNS_CODE_LOGIN_NOTOKEN = 1908;
  public static final int WNS_CODE_LOGIN_PTLOGIN_BUSY = 1901;
  public static final int WNS_CODE_LOGIN_SID_EXPIRED = 1905;
  public static final int WNS_CODE_LOGIN_SID_ILLEGAL = 1904;
  public static final int WNS_CODE_SUCCESS = 0;
  public static final int WNS_CODE_WNS_NOT_WORKING = 3000;
  public static final int WNS_UID_ERROR = 3013;
  
  private static String __getErrorMessage(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= 2400)
    {
      i = paramInt;
      if (paramInt < 2499) {
        i = 2400;
      }
    }
    switch (i)
    {
    default: 
      return DEFAULT_ERROR_MESSAGE;
    case 0: 
      return DEFAULT_SUCCESS_MESSAGE;
    case 1901: 
    case 1902: 
    case 1903: 
    case 1904: 
    case 1905: 
    case 1906: 
    case 1907: 
    case 1908: 
    case 1909: 
    case 1910: 
    case 2400: 
      return DEFAULT_ERROR_MESSAGE_WAIT;
    }
    return DEFAULT_ERROR_MESSAGE_ILLIGAL_APPID;
  }
  
  public static String getErrorMessage(int paramInt)
  {
    return __getErrorMessage(paramInt) + "  (" + String.valueOf(paramInt) + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.WnsError
 * JD-Core Version:    0.7.0.1
 */