package com.tencent.qqmini.sdk.ipc;

import android.os.Bundle;
import bepl;
import bepp;
import bepu;
import beqb;
import betc;

public class AppBrandProxyImpl$6
  implements Runnable
{
  public AppBrandProxyImpl$6(bepl parambepl, String paramString, bepu parambepu, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.this$0.a() == null)
    {
      betc.d("minisdk-start_AppBrandProxy", "sendCmd IAppBrandService Connection is Null 1. cmd=" + this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Bepu != null) {}
      try
      {
        this.jdField_a_of_type_Bepu.a(false, new Bundle());
        return;
      }
      catch (Throwable localThrowable1)
      {
        betc.d("minisdk-start_AppBrandProxy", "sendCmd exception.", localThrowable1);
        return;
      }
    }
    try
    {
      bepl.a(this.this$0).a(this.jdField_a_of_type_JavaLangString, beqb.a().a(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bepu);
      return;
    }
    catch (Throwable localThrowable2)
    {
      betc.d("minisdk-start_AppBrandProxy", "sendCmd exception.", localThrowable2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */