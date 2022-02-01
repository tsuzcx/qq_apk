package dualsim.common;

public class PhoneGetResult
{
  public static final int SOURCE_CACHE = 1;
  public static final int SOURCE_SERVER = 0;
  private PhoneGetResult.PhoneGetDetail detail = new PhoneGetResult.PhoneGetDetail();
  private int errorCode = -20001;
  private String phoneNumber;
  
  public PhoneGetResult(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public PhoneGetResult(int paramInt, PhoneGetResult.PhoneGetDetail paramPhoneGetDetail)
  {
    this.errorCode = paramInt;
    this.detail = paramPhoneGetDetail;
  }
  
  public PhoneGetResult(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.phoneNumber = paramString;
  }
  
  public PhoneGetResult(int paramInt, String paramString, PhoneGetResult.PhoneGetDetail paramPhoneGetDetail)
  {
    this.errorCode = paramInt;
    this.phoneNumber = paramString;
    this.detail = paramPhoneGetDetail;
  }
  
  public String getCurrentPhoneNumber()
  {
    return this.phoneNumber;
  }
  
  public PhoneGetResult.PhoneGetDetail getDetail()
  {
    return this.detail;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorCodeName()
  {
    return DualErrCode.printCodeName(this.errorCode);
  }
  
  public void setCurrentPhoneNumber(String paramString)
  {
    this.phoneNumber = paramString;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dualsim.common.PhoneGetResult
 * JD-Core Version:    0.7.0.1
 */