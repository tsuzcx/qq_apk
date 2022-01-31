package com.tencent.qqmini.sdk.runtime.core.service;

import bhhd;
import bhhe;
import com.tencent.qqmini.sdk.log.QMLog;

public class AppBrandService$1$1
  implements Runnable
{
  public AppBrandService$1$1(bhhe parambhhe) {}
  
  public void run()
  {
    try
    {
      this.a.jdField_a_of_type_Bhhd.a(this.a.jdField_a_of_type_AndroidContentContext);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBrandService", "onCoreInitFinished exception in thread --> " + this.a.jdField_a_of_type_Bhhd.a, localThrowable);
      this.a.jdField_a_of_type_Bhhd.setCurrState(this.a.jdField_a_of_type_Bhhd.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.service.AppBrandService.1.1
 * JD-Core Version:    0.7.0.1
 */