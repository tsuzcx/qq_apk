package com.tencent.mobileqq.mini.entry;

import ahfx;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class QQMessagePageMiniAppEntryManager$2
  implements View.OnClickListener
{
  QQMessagePageMiniAppEntryManager$2(QQMessagePageMiniAppEntryManager paramQQMessagePageMiniAppEntryManager) {}
  
  public void onClick(View paramView)
  {
    try
    {
      ((ahfx)MiniAppUtils.getAppInterface().getManager(342)).a(2);
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("QQMessagePageMicroAppEntryManager", 1, paramView, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager.2
 * JD-Core Version:    0.7.0.1
 */