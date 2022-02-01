package com.tencent.mobileqq.subaccount.logic;

public class SubAccountThirdQQBackProtocData
{
  public String a;
  public int b = 0;
  public String c = "";
  public int d;
  public int e;
  public int f = 0;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" mainAccount:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" errorType:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" errorMsg:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" interval:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" allLastMsgTime:");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData
 * JD-Core Version:    0.7.0.1
 */