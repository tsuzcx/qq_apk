package com.tencent.mobileqq.redtouch;

import java.io.Serializable;

public class RedTypeInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String redContent;
  private String redDesc;
  private int redPriority;
  private int redType;
  
  public String getRedContent()
  {
    return this.redContent;
  }
  
  public String getRedDesc()
  {
    return this.redDesc;
  }
  
  public int getRedPriority()
  {
    return this.redPriority;
  }
  
  public int getRedType()
  {
    return this.redType;
  }
  
  public void setRedContent(String paramString)
  {
    this.redContent = paramString;
  }
  
  public void setRedDesc(String paramString)
  {
    this.redDesc = paramString;
  }
  
  public void setRedPriority(int paramInt)
  {
    this.redPriority = paramInt;
  }
  
  public void setRedType(int paramInt)
  {
    this.redType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTypeInfo
 * JD-Core Version:    0.7.0.1
 */