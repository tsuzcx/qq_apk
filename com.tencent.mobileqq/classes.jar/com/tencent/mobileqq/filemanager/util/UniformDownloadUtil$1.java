package com.tencent.mobileqq.filemanager.util;

import apei;
import apek;
import apem;

public final class UniformDownloadUtil$1
  implements Runnable
{
  public UniformDownloadUtil$1(String paramString, apem paramapem) {}
  
  public void run()
  {
    apek localapek = apei.a(this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Apem != null) && (localapek != null)) {
      this.jdField_a_of_type_Apem.a(localapek.jdField_a_of_type_JavaLangString, localapek.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.1
 * JD-Core Version:    0.7.0.1
 */