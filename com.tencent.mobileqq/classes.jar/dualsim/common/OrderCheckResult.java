package dualsim.common;

public class OrderCheckResult
{
  public static final int KINGCARD_NEGATIVE = -1;
  public static final int KINGCARD_POSITIVE = 1;
  public static final int KINGCARD_UNKNOWN = 0;
  public static final int OPERATOR_CHINA_MOBILE = 0;
  public static final int OPERATOR_CHINA_TELECOM = 2;
  public static final int OPERATOR_CHINA_UNICOM = 1;
  public static final int OPERATOR_UNKNOWN = -2;
  public String activationUrl;
  public int kingcard;
  public int operator;
  public String phoneNum;
  public int product;
  
  public String toString()
  {
    return "OrderCheckResult{kingcard=" + this.kingcard + ", product=" + this.product + ", phoneNum='" + this.phoneNum + '\'' + ", operator=" + this.operator + ", activationUrl='" + this.activationUrl + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dualsim.common.OrderCheckResult
 * JD-Core Version:    0.7.0.1
 */