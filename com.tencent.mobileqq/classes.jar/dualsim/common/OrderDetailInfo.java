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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.result);
    localStringBuilder.append(",");
    localStringBuilder.append(this.productIdentity);
    localStringBuilder.append(",");
    localStringBuilder.append(this.stateTag);
    localStringBuilder.append(",");
    localStringBuilder.append(this.stateTime);
    localStringBuilder.append(",");
    localStringBuilder.append(this.message);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result:");
    localStringBuilder.append(this.result);
    localStringBuilder.append(", productIdentity:");
    localStringBuilder.append(this.productIdentity);
    localStringBuilder.append(",stateTag:");
    localStringBuilder.append(this.stateTag);
    localStringBuilder.append(",stateTime:");
    localStringBuilder.append(this.stateTime);
    localStringBuilder.append(",message:");
    localStringBuilder.append(this.message);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dualsim.common.OrderDetailInfo
 * JD-Core Version:    0.7.0.1
 */