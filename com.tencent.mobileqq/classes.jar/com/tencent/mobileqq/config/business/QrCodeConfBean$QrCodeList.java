package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.jsonconverter.Alias;

public class QrCodeConfBean$QrCodeList
{
  @Alias(a="isStatusBarWhite")
  public int a;
  @Alias(a="bkgURL")
  public String a;
  @Alias(a="isNavBarWhite")
  public int b;
  @Alias(a="logoColor")
  public String b;
  @Alias(a="needShowLogo")
  public int c = 1;
  
  public QrCodeConfBean$QrCodeList()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public QrCodeConfBean$QrCodeList(QrCodeList paramQrCodeList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    QrCodeList localQrCodeList = paramQrCodeList;
    if (paramQrCodeList == null) {
      localQrCodeList = new QrCodeList();
    }
    this.jdField_a_of_type_Int = localQrCodeList.jdField_a_of_type_Int;
    this.jdField_b_of_type_JavaLangString = localQrCodeList.jdField_b_of_type_JavaLangString;
    this.c = localQrCodeList.c;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Int == 1;
  }
  
  public boolean c()
  {
    return this.c == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QrCodeList{bkgURL = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", isStatusBarWhite = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", isNavBarWhite = ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", logoColor = ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", needShowLogo = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QrCodeConfBean.QrCodeList
 * JD-Core Version:    0.7.0.1
 */