package com.tencent.mobileqq.utils;

import mqq.app.AppRuntime;

final class TroopReportor$1
  implements Runnable
{
  TroopReportor$1(String paramString1, String paramString2, int paramInt1, int paramInt2, String[] paramArrayOfString, AppRuntime paramAppRuntime, String paramString3) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_b_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    String str3 = this.jdField_a_of_type_ArrayOfJavaLangString[0];
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    localObject = TroopReportor.a((AppRuntime)localObject, this.c, ((AppRuntime)localObject).getCurrentAccountUin());
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    TroopReportor.a("Grp_edu", str1, str2, i, j, new String[] { str3, localObject, arrayOfString[2], arrayOfString[3] });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TroopReportor.1
 * JD-Core Version:    0.7.0.1
 */