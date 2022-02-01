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
    this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.d = false;
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a == 1) {
      this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a(0);
    }
    QLog.d("HotPicManagerHotPicPageView", 2, "user click button");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.4.2.1
 * JD-Core Version:    0.7.0.1
 */