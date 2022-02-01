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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OrderCheckResult{kingcard=");
    localStringBuilder.append(this.kingcard);
    localStringBuilder.append(", product=");
    localStringBuilder.append(this.product);
    localStringBuilder.append(", phoneNum='");
    localStringBuilder.append(this.phoneNum);
    localStringBuilder.append('\'');
    localStringBuilder.append(", operator=");
    localStringBuilder.append(this.operator);
    localStringBuilder.append(", activationUrl='");
    localStringBuilder.append(this.activationUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dualsim.common.OrderCheckResult
 * JD-Core Version:    0.7.0.1
 */