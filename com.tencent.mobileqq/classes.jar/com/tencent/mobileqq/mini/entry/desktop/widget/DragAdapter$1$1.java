package com.tencent.mobileqq.mini.entry.desktop.widget;

import com.tencent.qphone.base.util.QLog;

class DragAdapter$1$1
  implements Runnable
{
  DragAdapter$1$1(DragAdapter.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$isSuc)
    {
      QLog.i("DragAdapter", 1, "**setUserAppTop success**.");
      return;
    }
    QLog.e("DragAdapter", 1, "**setUserAppTop failed**.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */