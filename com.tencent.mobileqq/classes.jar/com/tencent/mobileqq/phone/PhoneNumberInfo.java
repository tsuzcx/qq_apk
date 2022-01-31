package com.tencent.mobileqq.phone;

public class PhoneNumberInfo
{
  public String a;
  public String b;
  public String c;
  
  public PhoneNumberInfo(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public String toString()
  {
    return "PhoneInfo{countryCode='" + this.a + '\'' + ", areaCode='" + this.b + '\'' + ", rawPhoneNum='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.phone.PhoneNumberInfo
 * JD-Core Version:    0.7.0.1
 */