package com.tencent.mobileqq.hotpic;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class HotPicPageView$5
  implements DialogInterface.OnClickListener
{
  HotPicPageView$5(HotPicPageView paramHotPicPageView, HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.c.a(this.a, this.b);
    QLog.d("HotPicManagerHotPicPageView", 2, "User allowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.5
 * JD-Core Version:    0.7.0.1
 */