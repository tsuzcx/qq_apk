package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class LightalkShieldData
  extends Entity
{
  @unique
  public String phone;
  public long qcallId;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.LightalkShieldData
 * JD-Core Version:    0.7.0.1
 */