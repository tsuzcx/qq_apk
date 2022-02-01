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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appid = ");
    localStringBuilder.append(this.appID);
    localStringBuilder.append("; openid = ");
    localStringBuilder.append(this.openID);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.OpenID
 * JD-Core Version:    0.7.0.1
 */