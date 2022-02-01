package com.tencent.mobileqq.phonecontact.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class PhoneContactAdd
  extends Entity
{
  @unique
  public String mobileNo;
  public String name;
  public String remindInfo;
  public long timestamp;
  public String unifiedCode;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.data.PhoneContactAdd
 * JD-Core Version:    0.7.0.1
 */