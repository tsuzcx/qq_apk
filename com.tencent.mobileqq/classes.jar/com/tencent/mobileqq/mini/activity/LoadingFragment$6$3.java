package com.tencent.mobileqq.mini.activity;

import alpo;
import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.widget.QQToast;

class LoadingFragment$6$3
  implements Runnable
{
  LoadingFragment$6$3(LoadingFragment.6 param6) {}
  
  public void run()
  {
    QQToast.a(this.this$1.this$0.getActivity().getApplicationContext(), alpo.a(2131706618), 0).a();
    this.this$1.this$0.uiHandler.postDelayed(new LoadingFragment.6.3.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.LoadingFragment.6.3
 * JD-Core Version:    0.7.0.1
 */