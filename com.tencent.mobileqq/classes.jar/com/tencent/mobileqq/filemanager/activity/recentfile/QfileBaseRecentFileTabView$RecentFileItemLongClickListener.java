package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

class QfileBaseRecentFileTabView$RecentFileItemLongClickListener
  implements View.OnLongClickListener
{
  QfileBaseRecentFileTabView$RecentFileItemLongClickListener(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView != null) && (!QfileBaseRecentFileTabView.a(this.a)))
    {
      paramView.setSelected(true);
      QQCustomMenu localQQCustomMenu = new QQCustomMenu();
      localQQCustomMenu.a(2131367183, paramView.getContext().getString(2131692545));
      localQQCustomMenu.a(2131365474, paramView.getContext().getString(2131692543));
      this.a.a = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).showAsDropDown(paramView, localQQCustomMenu, new QfileBaseRecentFileTabView.RecentFileItemLongClickListener.1(this, paramView), new QfileBaseRecentFileTabView.RecentFileItemLongClickListener.2(this, paramView));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.RecentFileItemLongClickListener
 * JD-Core Version:    0.7.0.1
 */