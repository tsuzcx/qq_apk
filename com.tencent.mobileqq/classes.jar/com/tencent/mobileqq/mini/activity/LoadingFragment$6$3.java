package com.tencent.mobileqq.mini.activity;

import ajya;
import android.app.Activity;
import android.os.Handler;
import bcql;

class LoadingFragment$6$3
  implements Runnable
{
  LoadingFragment$6$3(LoadingFragment.6 param6) {}
  
  public void run()
  {
    bcql.a(this.this$1.this$0.getActivity().getApplicationContext(), ajya.a(2131706246), 0).a();
    this.this$1.this$0.uiHandler.postDelayed(new LoadingFragment.6.3.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.LoadingFragment.6.3
 * JD-Core Version:    0.7.0.1
 */