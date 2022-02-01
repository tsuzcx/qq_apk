package com.tencent.widget;

import android.widget.PopupWindow.OnDismissListener;

class KandianPopupWindow$1
  implements PopupWindow.OnDismissListener
{
  KandianPopupWindow$1(KandianPopupWindow paramKandianPopupWindow) {}
  
  public void onDismiss()
  {
    this.a.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnUninterestConfirmListener = null;
    this.a.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnComplainListener = null;
    this.a.c();
    com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.KandianPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */