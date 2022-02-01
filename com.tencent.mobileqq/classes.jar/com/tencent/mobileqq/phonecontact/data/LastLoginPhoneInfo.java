package com.tencent.mobileqq.phonecontact.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class LastLoginPhoneInfo
  extends Entity
{
  @unique
  public String unifiedCode;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LastLoginPhoneInfo:unifiedCode=");
    localStringBuilder.append(this.unifiedCode);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.data.LastLoginPhoneInfo
 * JD-Core Version:    0.7.0.1
 */