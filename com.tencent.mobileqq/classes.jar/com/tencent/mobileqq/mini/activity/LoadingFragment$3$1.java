package com.tencent.mobileqq.mini.activity;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class LoadingFragment$3$1
  implements Runnable
{
  LoadingFragment$3$1(LoadingFragment.3 param3, String paramString, long paramLong) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, "" + this.val$errMsg, 1).a();
    this.this$1.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.LoadingFragment.3.1
 * JD-Core Version:    0.7.0.1
 */