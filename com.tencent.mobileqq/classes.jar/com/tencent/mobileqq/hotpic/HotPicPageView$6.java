package com.tencent.mobileqq.hotpic;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class HotPicPageView$6
  implements DialogInterface.OnClickListener
{
  HotPicPageView$6(HotPicPageView paramHotPicPageView, HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a(-11);
    QLog.d("HotPicManagerHotPicPageView", 2, "User disallowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.6
 * JD-Core Version:    0.7.0.1
 */