package com.tencent.qqprotect.common;

import com.tencent.mobileqq.utils.HexUtil;

public class QSecRptHelper
{
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private boolean jdField_a_of_type_Boolean;
  
  public QSecRptHelper()
  {
    a();
  }
  
  private void a()
  {
    a(",");
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramString);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public QSecRptHelper a()
  {
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public QSecRptHelper a(int paramInt)
  {
    return a(String.format("%d", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public QSecRptHelper a(String paramString)
  {
    a();
    paramString = paramString.replace(',', ';');
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramString);
    return this;
  }
  
  public QSecRptHelper a(byte[] paramArrayOfByte)
  {
    return a(HexUtil.a(paramArrayOfByte));
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.common.QSecRptHelper
 * JD-Core Version:    0.7.0.1
 */