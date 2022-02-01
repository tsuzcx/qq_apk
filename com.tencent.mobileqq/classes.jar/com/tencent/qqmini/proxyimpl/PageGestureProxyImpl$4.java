package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class PageGestureProxyImpl$4
  implements DialogInterface.OnClickListener
{
  PageGestureProxyImpl$4(PageGestureProxyImpl paramPageGestureProxyImpl, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (PageGestureProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplPageGestureProxyImpl).isShowing()) {
      PageGestureProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplPageGestureProxyImpl).dismiss();
    }
    ColorNoteSmallScreenUtil.a(this.jdField_a_of_type_AndroidAppActivity, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.PageGestureProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */