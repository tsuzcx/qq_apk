package com.tencent.mobileqq.nearby.now.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;

class ShortVideoCommentsView$20
  implements DialogInterface.OnClickListener
{
  ShortVideoCommentsView$20(ShortVideoCommentsView paramShortVideoCommentsView, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NearbyUtils.a(this.a, 302);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.bindphone", 2, "openBindPhonePage");
    }
    paramDialogInterface = this.b;
    paramDialogInterface.reportBindPhoneAction(paramDialogInterface.app, "playpage_phone_clk");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.20
 * JD-Core Version:    0.7.0.1
 */