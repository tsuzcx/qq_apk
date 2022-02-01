package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

class QfileBaseRecentFileTabView$RecentFileItemLongClickListener
  implements View.OnLongClickListener
{
  QfileBaseRecentFileTabView$RecentFileItemLongClickListener(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseRecentFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131367401, paramView.getContext().getString(2131692687));
    localQQCustomMenu.a(2131365630, paramView.getContext().getString(2131691558));
    ((IApolloUtil)QRoute.api(IApolloUtil.class)).addDebugMenu(paramView, QfileBaseRecentFileTabView.n(this.a), localQQCustomMenu);
    this.a.a = BubbleContextMenu.a(paramView, localQQCustomMenu, new QfileBaseRecentFileTabView.RecentFileItemLongClickListener.1(this, paramView), new QfileBaseRecentFileTabView.RecentFileItemLongClickListener.2(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.RecentFileItemLongClickListener
 * JD-Core Version:    0.7.0.1
 */