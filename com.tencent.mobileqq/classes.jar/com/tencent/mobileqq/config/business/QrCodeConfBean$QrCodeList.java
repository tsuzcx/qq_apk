package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.jsonconverter.Alias;

public class QrCodeConfBean$QrCodeList
{
  @Alias(a="bkgURL")
  public String a = "";
  @Alias(a="isStatusBarWhite")
  public int b = 0;
  @Alias(a="isNavBarWhite")
  public int c = 0;
  @Alias(a="logoColor")
  public String d = "";
  @Alias(a="needShowLogo")
  public int e = 1;
  
  public QrCodeConfBean$QrCodeList() {}
  
  public QrCodeConfBean$QrCodeList(QrCodeList paramQrCodeList, String paramString, int paramInt)
  {
    QrCodeList localQrCodeList = paramQrCodeList;
    if (paramQrCodeList == null) {
      localQrCodeList = new QrCodeList();
    }
    this.b = localQrCodeList.b;
    this.d = localQrCodeList.d;
    this.e = localQrCodeList.e;
    this.c = paramInt;
    this.a = paramString;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean b()
  {
    return this.c == 1;
  }
  
  public boolean c()
  {
    return this.e == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QrCodeList{bkgURL = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", isStatusBarWhite = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isNavBarWhite = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", logoColor = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", needShowLogo = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QrCodeConfBean.QrCodeList
 * JD-Core Version:    0.7.0.1
 */