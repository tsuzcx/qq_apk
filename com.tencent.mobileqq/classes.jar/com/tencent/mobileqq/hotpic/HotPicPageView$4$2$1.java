package com.tencent.mobileqq.hotpic;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class HotPicPageView$4$2$1
  implements DialogInterface.OnClickListener
{
  HotPicPageView$4$2$1(HotPicPageView.4.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.c.J = false;
    if (this.a.a.a.n == 1) {
      this.a.a.a.a(0);
    }
    QLog.d("HotPicManagerHotPicPageView", 2, "user click button");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.4.2.1
 * JD-Core Version:    0.7.0.1
 */