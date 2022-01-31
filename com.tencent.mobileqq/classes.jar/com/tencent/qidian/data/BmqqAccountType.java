package com.tencent.qidian.data;

import auko;
import aumc;

public class BmqqAccountType
  extends auko
{
  public static final int TYPE_ACCOUNT_BMQQ_EXT = 0;
  public static final int TYPE_ACCOUNT_CRM_EXT = 2;
  public static final int TYPE_ACCOUNT_CRM_MAIN = 3;
  public static final int TYPE_ACCOUNT_NOT_UIN = 5;
  public static final int TYPE_ACCOUNT_QIDIAN_EXT = 1;
  public static final int TYPE_ACCOUNT_QIDIAN_MAIN = 6;
  public static final int TYPE_ACCOUNT_UNKNOW = 4;
  public int mAccountType;
  @aumc
  public String mUin = "";
  
  public BmqqAccountType() {}
  
  public BmqqAccountType(String paramString, int paramInt)
  {
    this.mUin = paramString;
    this.mAccountType = paramInt;
  }
  
  public int getAccountType()
  {
    return this.mAccountType;
  }
  
  public String getUin()
  {
    return this.mUin;
  }
  
  public void setAccountType(int paramInt)
  {
    this.mAccountType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.qidian.data.BmqqAccountType
 * JD-Core Version:    0.7.0.1
 */