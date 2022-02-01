package com.tencent.mobileqq.utils;

class AntiFraudConfigFileUtil$3$1
  implements Runnable
{
  AntiFraudConfigFileUtil$3$1(AntiFraudConfigFileUtil.3 param3, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil$3.a.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    String str = SecUtil.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil$3.a.a(this.jdField_a_of_type_JavaLangString));
    if (!this.b.equalsIgnoreCase(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil$3.a.a(this.jdField_a_of_type_JavaLangString, this.b, this.c);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsAntiFraudConfigFileUtil$3.a.a(this.jdField_a_of_type_JavaLangString, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.3.1
 * JD-Core Version:    0.7.0.1
 */