package com.tencent.mobileqq.phonecontact.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ContactMatch
  extends Entity
{
  public short age;
  public int commonFriend;
  public short gender = 255;
  public boolean isReaded;
  @unique
  public String mobileNo;
  public String name;
  public long timestamp;
  public String unifiedCode;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.data.ContactMatch
 * JD-Core Version:    0.7.0.1
 */