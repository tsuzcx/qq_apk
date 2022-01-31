package dualsim.common;

public class PhoneGetResult
{
  public static final int SOURCE_CACHE = 1;
  public static final int SOURCE_SERVER = 0;
  public int customOrderId;
  public long doneTime;
  public int errorCode = -20001;
  public String extraInfo;
  public int function;
  public long imei;
  public long imsi;
  public String innerPhoneNumber;
  public int networkCode;
  public int orderId;
  public long orderTime;
  public String phoneNumber;
  public int province;
  public int queryType = 2;
  public int ratType;
  public int respCode;
  public String respDesc;
  public int respType;
  public int result = -1;
  public int source = 0;
  public int subErrCode;
  
  public PhoneGetResult(int paramInt)
  {
    this.errorCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     dualsim.common.PhoneGetResult
 * JD-Core Version:    0.7.0.1
 */