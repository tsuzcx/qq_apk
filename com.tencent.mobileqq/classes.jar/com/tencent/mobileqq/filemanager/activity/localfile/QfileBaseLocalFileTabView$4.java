package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

class QfileBaseLocalFileTabView$4
  implements View.OnLongClickListener
{
  QfileBaseLocalFileTabView$4(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseLocalFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131367401, paramView.getContext().getString(2131692687));
    localQQCustomMenu.a(2131365630, paramView.getContext().getString(2131691558));
    this.a.a = BubbleContextMenu.a(paramView, localQQCustomMenu, new QfileBaseLocalFileTabView.4.1(this, paramView), new QfileBaseLocalFileTabView.4.2(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.4
 * JD-Core Version:    0.7.0.1
 */