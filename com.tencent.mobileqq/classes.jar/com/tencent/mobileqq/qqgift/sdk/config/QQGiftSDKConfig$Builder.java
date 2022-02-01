package com.tencent.mobileqq.qqgift.sdk.config;

public class QQGiftSDKConfig$Builder
{
  private QQGiftSDKConfig a = new QQGiftSDKConfig(null);
  
  private boolean b()
  {
    return true;
  }
  
  public Builder a(int paramInt)
  {
    this.a.a = paramInt;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.a.b = paramString;
    return this;
  }
  
  public QQGiftSDKConfig a()
  {
    if ((this.a.c) && (!b())) {
      throw new RuntimeException("config params error");
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig.Builder
 * JD-Core Version:    0.7.0.1
 */