package com.tencent.mobileqq.mini.entry;

import android.widget.PopupWindow;

class QQMessagePageMiniAppEntryManager$4
  implements Runnable
{
  QQMessagePageMiniAppEntryManager$4(QQMessagePageMiniAppEntryManager paramQQMessagePageMiniAppEntryManager, PopupWindow paramPopupWindow) {}
  
  public void run()
  {
    if (this.val$popupWindow.isShowing()) {
      this.val$popupWindow.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager.4
 * JD-Core Version:    0.7.0.1
 */