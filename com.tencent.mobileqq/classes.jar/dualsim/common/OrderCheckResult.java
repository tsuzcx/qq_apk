package dualsim.common;

public class OrderCheckResult
{
  public static final int FREE_TYPE_KINGCARD = 1;
  public static final int FREE_TYPE_USAGE_PACKAGE = 2;
  public static final int REQUEST_TYPE_CACHE = 3;
  public static final int REQUEST_TYPE_IMSI = 1;
  public static final int REQUEST_TYPE_PHONE_NUMBER = 2;
  public String cardStatus;
  public int errCode;
  public int freeType;
  public boolean isKingCard;
  public int networkCode;
  public int product;
  public int requestParamType;
  public String requestParamValue;
  public int subErrCode;
  
  public OrderCheckResult() {}
  
  public OrderCheckResult(int paramInt)
  {
    this.errCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     dualsim.common.OrderCheckResult
 * JD-Core Version:    0.7.0.1
 */