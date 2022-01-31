package com.tencent.mobileqq.redtouch;

import java.io.Serializable;

public class RedTypeInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String red_content;
  private String red_desc;
  private int red_priority;
  private int red_type;
  
  public String getRed_content()
  {
    return this.red_content;
  }
  
  public String getRed_desc()
  {
    return this.red_desc;
  }
  
  public int getRed_priority()
  {
    return this.red_priority;
  }
  
  public int getRed_type()
  {
    return this.red_type;
  }
  
  public void setRed_content(String paramString)
  {
    this.red_content = paramString;
  }
  
  public void setRed_desc(String paramString)
  {
    this.red_desc = paramString;
  }
  
  public void setRed_priority(int paramInt)
  {
    this.red_priority = paramInt;
  }
  
  public void setRed_type(int paramInt)
  {
    this.red_type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTypeInfo
 * JD-Core Version:    0.7.0.1
 */