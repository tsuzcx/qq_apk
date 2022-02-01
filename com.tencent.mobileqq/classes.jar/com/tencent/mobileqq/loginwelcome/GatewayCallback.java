package com.tencent.mobileqq.loginwelcome;

import tencent.im.login.GatewayVerify.SelfPhoneUrl;

public abstract interface GatewayCallback
{
  public abstract void a(Exception paramException);
  
  public abstract void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl);
  
  public abstract void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, String paramString);
  
  public abstract void b(int paramInt, Exception paramException);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GatewayCallback
 * JD-Core Version:    0.7.0.1
 */