package com.tencent.mobileqq.mini.appbrand.ui;

import ajya;
import android.app.Activity;
import android.os.Handler;
import bcql;

class AppLoadingUI$11$3
  implements Runnable
{
  AppLoadingUI$11$3(AppLoadingUI.11 param11) {}
  
  public void run()
  {
    bcql.a(this.this$1.this$0.getActivity().getApplicationContext(), ajya.a(2131700621), 0).a();
    this.this$1.this$0.uiHandler.postDelayed(new AppLoadingUI.11.3.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI.11.3
 * JD-Core Version:    0.7.0.1
 */