package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import bgnf;
import bgqj;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;

public class BaseUIProxy$3
  implements Runnable
{
  public BaseUIProxy$3(bgqj parambgqj, int paramInt, String paramString) {}
  
  public void run()
  {
    bgnf.a(AppLoaderFactory.g().getMiniAppEnv().getContext(), "加载失败 retCode=" + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString, 0).a();
    if (this.this$0.mActivity != null) {
      this.this$0.mActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.BaseUIProxy.3
 * JD-Core Version:    0.7.0.1
 */