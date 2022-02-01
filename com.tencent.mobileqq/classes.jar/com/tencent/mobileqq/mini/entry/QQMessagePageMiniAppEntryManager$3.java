package com.tencent.mobileqq.mini.entry;

import android.widget.PopupWindow;

class QQMessagePageMiniAppEntryManager$3
  implements Runnable
{
  QQMessagePageMiniAppEntryManager$3(QQMessagePageMiniAppEntryManager paramQQMessagePageMiniAppEntryManager, PopupWindow paramPopupWindow) {}
  
  public void run()
  {
    if (this.val$popupWindow.isShowing()) {
      this.val$popupWindow.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager.3
 * JD-Core Version:    0.7.0.1
 */