package com.tencent.qqmini.sdk.ipc;

import android.os.Bundle;
import beou;
import beoy;
import bepd;
import bepk;
import besl;

public class AppBrandProxyImpl$6
  implements Runnable
{
  public AppBrandProxyImpl$6(beou parambeou, String paramString, bepd parambepd, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.this$0.a() == null)
    {
      besl.d("minisdk-start_AppBrandProxy", "sendCmd IAppBrandService Connection is Null 1. cmd=" + this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Bepd != null) {}
      try
      {
        this.jdField_a_of_type_Bepd.a(false, new Bundle());
        return;
      }
      catch (Throwable localThrowable1)
      {
        besl.d("minisdk-start_AppBrandProxy", "sendCmd exception.", localThrowable1);
        return;
      }
    }
    try
    {
      beou.a(this.this$0).a(this.jdField_a_of_type_JavaLangString, bepk.a().a(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bepd);
      return;
    }
    catch (Throwable localThrowable2)
    {
      besl.d("minisdk-start_AppBrandProxy", "sendCmd exception.", localThrowable2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */