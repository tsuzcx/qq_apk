package com.tencent.mobileqq.qwallet.red;

public class IQWalletRedService$ShowInfo
{
  public boolean a;
  public boolean b;
  public String c;
  public String d;
  
  public IQWalletRedService$ShowInfo(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShowInfo{Red=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",Corner=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",con='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(",buf='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.red.IQWalletRedService.ShowInfo
 * JD-Core Version:    0.7.0.1
 */