package com.tencent.tbs.one.impl.common;

public class ReceiverConfig
{
  private String mClassName;
  private String mComponentName;
  private String mEventName;
  
  public ReceiverConfig(String paramString1, String paramString2, String paramString3)
  {
    this.mComponentName = paramString1;
    this.mClassName = paramString2;
    this.mEventName = paramString3;
  }
  
  public String getClassName()
  {
    return this.mClassName;
  }
  
  public String getComponentName()
  {
    return this.mComponentName;
  }
  
  public String getEventName()
  {
    return this.mEventName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.ReceiverConfig
 * JD-Core Version:    0.7.0.1
 */