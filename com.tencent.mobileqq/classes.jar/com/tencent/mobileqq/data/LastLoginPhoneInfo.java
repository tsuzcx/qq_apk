package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class LastLoginPhoneInfo
  extends Entity
{
  @unique
  public String unifiedCode;
  
  public String toString()
  {
    return "LastLoginPhoneInfo:unifiedCode=" + this.unifiedCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.LastLoginPhoneInfo
 * JD-Core Version:    0.7.0.1
 */