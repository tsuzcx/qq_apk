package com.tencent.mobileqq.qqguildsdk.data;

import java.util.List;

public class FocusChannelReqInfo
{
  private String a;
  private List<String> b;
  
  public FocusChannelReqInfo(String paramString, List<String> paramList)
  {
    this.a = paramString;
    this.b = paramList;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public List<String> b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.FocusChannelReqInfo
 * JD-Core Version:    0.7.0.1
 */