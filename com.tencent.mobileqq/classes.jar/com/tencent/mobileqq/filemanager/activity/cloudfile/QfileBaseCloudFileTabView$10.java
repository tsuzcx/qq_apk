package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

class QfileBaseCloudFileTabView$10
  implements View.OnLongClickListener
{
  QfileBaseCloudFileTabView$10(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView != null) && (!QfileBaseCloudFileTabView.e(this.a)))
    {
      paramView.setSelected(true);
      QQCustomMenu localQQCustomMenu = new QQCustomMenu();
      localQQCustomMenu.a(2131431689, paramView.getContext().getString(2131896078));
      this.a.m = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).showAsDropDown(paramView, localQQCustomMenu, new QfileBaseCloudFileTabView.10.1(this, paramView), new QfileBaseCloudFileTabView.10.2(this, paramView));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.10
 * JD-Core Version:    0.7.0.1
 */