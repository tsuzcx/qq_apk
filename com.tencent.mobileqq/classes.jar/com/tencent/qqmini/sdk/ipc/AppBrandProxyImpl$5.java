package com.tencent.qqmini.sdk.ipc;

import android.os.Bundle;
import bdkr;
import bdku;
import bdkz;
import bdle;
import bdnw;

public class AppBrandProxyImpl$5
  implements Runnable
{
  public AppBrandProxyImpl$5(bdkr parambdkr, String paramString, bdkz parambdkz, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.this$0.a() == null)
    {
      bdnw.d("minisdk-start_AppBrandProxy", "sendCmd IAppBrandService Connection is Null 1. cmd=" + this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Bdkz != null) {}
      try
      {
        this.jdField_a_of_type_Bdkz.a(false, new Bundle());
        return;
      }
      catch (Throwable localThrowable1)
      {
        bdnw.d("minisdk-start_AppBrandProxy", "sendCmd exception.", localThrowable1);
        return;
      }
    }
    try
    {
      bdkr.a(this.this$0).a(this.jdField_a_of_type_JavaLangString, bdle.a().a(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bdkz);
      return;
    }
    catch (Throwable localThrowable2)
    {
      bdnw.d("minisdk-start_AppBrandProxy", "sendCmd exception.", localThrowable2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */