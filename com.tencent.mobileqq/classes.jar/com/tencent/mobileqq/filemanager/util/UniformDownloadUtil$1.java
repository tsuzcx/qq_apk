package com.tencent.mobileqq.filemanager.util;

import apwc;
import apwe;
import apwg;

public final class UniformDownloadUtil$1
  implements Runnable
{
  public UniformDownloadUtil$1(String paramString, apwg paramapwg) {}
  
  public void run()
  {
    apwe localapwe = apwc.a(this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Apwg != null) && (localapwe != null)) {
      this.jdField_a_of_type_Apwg.a(localapwe.jdField_a_of_type_JavaLangString, localapwe.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.1
 * JD-Core Version:    0.7.0.1
 */