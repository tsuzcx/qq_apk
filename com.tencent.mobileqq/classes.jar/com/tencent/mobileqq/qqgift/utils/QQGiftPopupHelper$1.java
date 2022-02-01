package com.tencent.mobileqq.qqgift.utils;

import android.widget.PopupWindow.OnDismissListener;

class QQGiftPopupHelper$1
  implements PopupWindow.OnDismissListener
{
  QQGiftPopupHelper$1(QQGiftPopupHelper paramQQGiftPopupHelper) {}
  
  public void onDismiss()
  {
    if (QQGiftPopupHelper.a(this.a)) {
      this.a.a(1.0F, false);
    }
    if (QQGiftPopupHelper.b(this.a) != null) {
      QQGiftPopupHelper.b(this.a).onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.QQGiftPopupHelper.1
 * JD-Core Version:    0.7.0.1
 */