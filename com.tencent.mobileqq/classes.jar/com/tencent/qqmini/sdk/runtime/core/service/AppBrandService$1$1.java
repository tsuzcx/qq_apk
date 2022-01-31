package com.tencent.qqmini.sdk.runtime.core.service;

import bhcw;
import bhcx;
import com.tencent.qqmini.sdk.log.QMLog;

public class AppBrandService$1$1
  implements Runnable
{
  public AppBrandService$1$1(bhcx parambhcx) {}
  
  public void run()
  {
    try
    {
      this.a.jdField_a_of_type_Bhcw.a(this.a.jdField_a_of_type_AndroidContentContext);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBrandService", "onCoreInitFinished exception in thread --> " + this.a.jdField_a_of_type_Bhcw.a, localThrowable);
      this.a.jdField_a_of_type_Bhcw.setCurrState(this.a.jdField_a_of_type_Bhcw.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.service.AppBrandService.1.1
 * JD-Core Version:    0.7.0.1
 */