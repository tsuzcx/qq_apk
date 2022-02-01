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
    if ((paramView != null) && (!QfileBaseRecentFileTabView.g(this.a)))
    {
      paramView.setSelected(true);
      QQCustomMenu localQQCustomMenu = new QQCustomMenu();
      localQQCustomMenu.a(2131433639, paramView.getContext().getString(2131889568));
      localQQCustomMenu.a(2131431689, paramView.getContext().getString(2131889566));
      this.a.r = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).showAsDropDown(paramView, localQQCustomMenu, new QfileBaseRecentFileTabView.RecentFileItemLongClickListener.1(this, paramView), new QfileBaseRecentFileTabView.RecentFileItemLongClickListener.2(this, paramView));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.RecentFileItemLongClickListener
 * JD-Core Version:    0.7.0.1
 */