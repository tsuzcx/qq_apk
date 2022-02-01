package dualsim.common;

import java.lang.reflect.Field;

public class DualErrCode
{
  private static final int NET_PHONE_BASE = -20000;
  public static final int NONE = 0;
  public static final int NUMBER_ACQUIRE_TOO_FREQUENTLY = -20012;
  public static final int NUMBER_AUTH_CODE_WRONG = -20004;
  public static final int NUMBER_DATA_USAGE_REQUIRED = -20009;
  public static final int NUMBER_FETCH_RESULT_PARSE_ERROR = -20007;
  public static final int NUMBER_GET_AUTH_CODE_FAILED = -20003;
  public static final int NUMBER_GET_AUTH_URL_FAILED = -20002;
  public static final int NUMBER_GET_IN_MAIN_THREAD = -20016;
  public static final int NUMBER_GET_LOCAL_IP_ERROR = -20008;
  public static final int NUMBER_GET_NO_VALID_PARAM = -20017;
  public static final int NUMBER_NETWORK_ERROR = -20006;
  public static final int NUMBER_NETWORK_IO_ERROR = -20005;
  public static final int NUMBER_NETWORK_UNKNOW_SAHRK_ERROR = -20013;
  public static final int NUMBER_NOT_UNICOM = -20011;
  public static final int NUMBER_SERVER_ERROR = -20010;
  public static final int NUMBER_SERVER_FROM_UNICOM_ERROR = -20015;
  public static final int NUMBER_SERVER_NOT_UNICOM_ERROR = -20014;
  public static final int NUMBER_UNKNOWN_ERROR = -20001;
  public static final int ORDER_ACQUIRE_TOO_FREQUENTLY = -10007;
  private static final int ORDER_BASE = -10000;
  public static final int ORDER_ERROR_NOT_UNICOM = -10009;
  public static final int ORDER_ERROR_SYN_IN_MAIN_THREAD = -10008;
  public static final int ORDER_IO_ERROR = -10002;
  public static final int ORDER_NETWORK_ERROR = -10001;
  public static final int ORDER_NOT_RELIABLE_IMSI = -10011;
  public static final int ORDER_NOT_UNICOME = -10005;
  public static final int ORDER_NO_VALID_PARAM_ERROR = -10006;
  public static final int ORDER_PARSE_ERROR = -10003;
  public static final int ORDER_SHARK_ERROR = -10010;
  public static final int ORDER_UNKNOWN_ERROR = -10004;
  public static final int SDK_LOAD_FAILED = -1;
  
  public static String printCodeName(int paramInt)
  {
    try
    {
      Object localObject1 = DualErrCode.class.getDeclaredFields();
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.getInt(null) == paramInt)
          {
            localObject1 = localObject2.getName();
            return localObject1;
          }
          i += 1;
        }
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dualsim.common.DualErrCode
 * JD-Core Version:    0.7.0.1
 */