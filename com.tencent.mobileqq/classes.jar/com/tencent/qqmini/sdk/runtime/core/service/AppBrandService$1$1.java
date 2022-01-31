package com.tencent.qqmini.sdk.runtime.core.service;

import betc;
import bfdg;
import bfdh;

public class AppBrandService$1$1
  implements Runnable
{
  public AppBrandService$1$1(bfdh parambfdh) {}
  
  public void run()
  {
    try
    {
      this.a.jdField_a_of_type_Bfdg.a(this.a.jdField_a_of_type_AndroidContentContext);
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("AppBrandService", "onCoreInitFinished exception in thread --> " + this.a.jdField_a_of_type_Bfdg.a, localThrowable);
      this.a.jdField_a_of_type_Bfdg.a(this.a.jdField_a_of_type_Bfdg.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.service.AppBrandService.1.1
 * JD-Core Version:    0.7.0.1
 */