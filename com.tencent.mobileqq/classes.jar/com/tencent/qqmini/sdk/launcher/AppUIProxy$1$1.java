package com.tencent.qqmini.sdk.launcher;

import android.os.Handler;
import bdit;
import bdlm;
import bdlq;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

public class AppUIProxy$1$1
  implements Runnable
{
  public AppUIProxy$1$1(bdlm parambdlm, int paramInt, bdlq parambdlq, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Bdlq != null))
    {
      AppUIProxy.access$000(this.jdField_a_of_type_Bdlm.a, this.jdField_a_of_type_Bdlq);
      return;
    }
    bdit.a(MiniAppEnv.g().getContext(), "小程序加载失败 retCode=" + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString, 0).a();
    AppUIProxy.access$100(this.jdField_a_of_type_Bdlm.a).postDelayed(new AppUIProxy.1.1.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppUIProxy.1.1
 * JD-Core Version:    0.7.0.1
 */