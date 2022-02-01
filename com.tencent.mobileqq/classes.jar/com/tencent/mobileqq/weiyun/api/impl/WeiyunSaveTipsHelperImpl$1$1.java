package com.tencent.mobileqq.weiyun.api.impl;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;

class WeiyunSaveTipsHelperImpl$1$1
  implements View.OnTouchListener
{
  WeiyunSaveTipsHelperImpl$1$1(WeiyunSaveTipsHelperImpl.1 param1) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool = false;
    if (i == 0)
    {
      bool = true;
      QLog.d("hehe", 2, new Object[] { "", "toast touch event" });
      this.a.this$0.startWeiyunDisk(this.a.c, this.a.a, this.a.a.getApplicationContext());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiyunSaveTipsHelperImpl.1.1
 * JD-Core Version:    0.7.0.1
 */