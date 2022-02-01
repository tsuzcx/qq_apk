package dualsim.common;

public class OrderDetailInfo
{
  private String message;
  private int productIdentity;
  private int result;
  private String stateTag;
  private String stateTime;
  
  public String getMessage()
  {
    return this.message;
  }
  
  public int getProductIdentity()
  {
    return this.productIdentity;
  }
  
  public int getResult()
  {
    return this.result;
  }
  
  public String getStateTag()
  {
    return this.stateTag;
  }
  
  public String getStateTime()
  {
    return this.stateTime;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setProductIdentity(int paramInt)
  {
    this.productIdentity = paramInt;
  }
  
  public void setResult(int paramInt)
  {
    this.result = paramInt;
  }
  
  public void setStateTag(String paramString)
  {
    this.stateTag = paramString;
  }
  
  public void setStateTime(String paramString)
  {
    this.stateTime = paramString;
  }
  
  public String toStrLine()
  {
    return this.result + "," + this.productIdentity + "," + this.stateTag + "," + this.stateTime + "," + this.message;
  }
  
  public String toString()
  {
    return "result:" + this.result + ", productIdentity:" + this.productIdentity + ",stateTag:" + this.stateTag + ",stateTime:" + this.stateTime + ",message:" + this.message;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dualsim.common.OrderDetailInfo
 * JD-Core Version:    0.7.0.1
 */