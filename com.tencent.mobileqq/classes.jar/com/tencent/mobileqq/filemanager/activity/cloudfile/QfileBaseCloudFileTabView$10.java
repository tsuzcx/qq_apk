package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

class QfileBaseCloudFileTabView$10
  implements View.OnLongClickListener
{
  QfileBaseCloudFileTabView$10(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseCloudFileTabView.b(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131365630, paramView.getContext().getString(2131691558));
    this.a.a = BubbleContextMenu.a(paramView, localQQCustomMenu, new QfileBaseCloudFileTabView.10.1(this, paramView), new QfileBaseCloudFileTabView.10.2(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.10
 * JD-Core Version:    0.7.0.1
 */