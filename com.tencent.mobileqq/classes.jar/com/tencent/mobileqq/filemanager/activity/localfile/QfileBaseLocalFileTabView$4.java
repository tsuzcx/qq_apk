package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

class QfileBaseLocalFileTabView$4
  implements View.OnLongClickListener
{
  QfileBaseLocalFileTabView$4(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView != null) && (!QfileBaseLocalFileTabView.b(this.a)))
    {
      paramView.setSelected(true);
      QQCustomMenu localQQCustomMenu = new QQCustomMenu();
      localQQCustomMenu.a(2131433639, paramView.getContext().getString(2131889568));
      FileInfo localFileInfo = null;
      if ((paramView.getTag() instanceof ImageHolder)) {
        localFileInfo = (FileInfo)((ImageHolder)paramView.getTag()).i;
      } else if ((paramView.getTag() instanceof QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)) {
        localFileInfo = (FileInfo)((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag()).j;
      }
      if ((localFileInfo != null) && (localFileInfo.c())) {
        localQQCustomMenu.a(2131431689, paramView.getContext().getString(2131889566));
      }
      this.a.x = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).showAsDropDown(paramView, localQQCustomMenu, new QfileBaseLocalFileTabView.4.1(this, paramView), new QfileBaseLocalFileTabView.4.2(this, paramView));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.4
 * JD-Core Version:    0.7.0.1
 */