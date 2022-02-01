package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class OpenID
  extends Entity
{
  @unique
  public String appID;
  public String openID;
  
  public String toString()
  {
    return "appid = " + this.appID + "; openid = " + this.openID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.OpenID
 * JD-Core Version:    0.7.0.1
 */