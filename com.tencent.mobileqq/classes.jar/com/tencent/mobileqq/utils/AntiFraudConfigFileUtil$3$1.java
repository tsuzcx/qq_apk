package com.tencent.mobileqq.utils;

import bhce;
import bhcf;

public class AntiFraudConfigFileUtil$3$1
  implements Runnable
{
  public AntiFraudConfigFileUtil$3$1(bhcf parambhcf, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bhcf.a.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    String str = SecUtil.getFileMd5(this.jdField_a_of_type_Bhcf.a.a(this.jdField_a_of_type_JavaLangString));
    if (!this.b.equalsIgnoreCase(str))
    {
      this.jdField_a_of_type_Bhcf.a.a(this.jdField_a_of_type_JavaLangString, this.b, this.c);
      return;
    }
    this.jdField_a_of_type_Bhcf.a.a(this.jdField_a_of_type_JavaLangString, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.3.1
 * JD-Core Version:    0.7.0.1
 */