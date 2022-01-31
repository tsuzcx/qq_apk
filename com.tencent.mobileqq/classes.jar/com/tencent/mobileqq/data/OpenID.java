package com.tencent.mobileqq.data;

import atmo;
import atoc;

public class OpenID
  extends atmo
{
  @atoc
  public String appID;
  public String openID;
  
  public String toString()
  {
    return "appid = " + this.appID + "; openid = " + this.openID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.OpenID
 * JD-Core Version:    0.7.0.1
 */