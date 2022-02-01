package com.tencent.mobileqq.mini.entry.desktop.widget;

import com.tencent.qphone.base.util.QLog;

class DragAdapter$5$1
  implements Runnable
{
  DragAdapter$5$1(DragAdapter.5 param5, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$isSuc)
    {
      QLog.d("DragAdapter", 2, "setUserAppTop success.");
      return;
    }
    QLog.d("DragAdapter", 2, "setUserAppTop failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter.5.1
 * JD-Core Version:    0.7.0.1
 */