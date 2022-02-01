package com.tencent.mobileqq.qqlive.data.pendant;

public class PushWebPendantData
{
  public long viewId;
  public String webData;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PushWebPendantDataBean{webData='");
    localStringBuilder.append(this.webData);
    localStringBuilder.append('\'');
    localStringBuilder.append(", viewId=");
    localStringBuilder.append(this.viewId);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.pendant.PushWebPendantData
 * JD-Core Version:    0.7.0.1
 */