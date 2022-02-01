package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class PhoneNumInfo
  extends Entity
{
  @unique
  public String phoneNum;
  public String uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.PhoneNumInfo
 * JD-Core Version:    0.7.0.1
 */