package com.tencent.mobileqq.forward;

import android.content.res.Resources;
import auxu;
import bhnv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ForwardBaseOption$5
  implements Runnable
{
  public ForwardBaseOption$5(auxu paramauxu) {}
  
  public void run()
  {
    if (bhnv.a(BaseApplication.getContext()) != 0) {
      QQToast.a(this.this$0.a.getApp(), 2, 2131692401, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299011));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.5
 * JD-Core Version:    0.7.0.1
 */