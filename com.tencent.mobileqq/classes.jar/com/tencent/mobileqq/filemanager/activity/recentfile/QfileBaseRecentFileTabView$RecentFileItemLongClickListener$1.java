package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

class QfileBaseRecentFileTabView$RecentFileItemLongClickListener$1
  implements View.OnClickListener
{
  QfileBaseRecentFileTabView$RecentFileItemLongClickListener$1(QfileBaseRecentFileTabView.RecentFileItemLongClickListener paramRecentFileItemLongClickListener, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof ImageHolder))
    {
      localObject = (FileManagerEntity)((ImageHolder)localObject).a;
      if (paramView.getId() != 2131365630) {
        break label121;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView$RecentFileItemLongClickListener.a.a, null);
      localActionSheet.setMainTitle(HardCodeUtil.a(2131709595));
      localActionSheet.addButton(HardCodeUtil.a(2131709599), 3);
      localActionSheet.addCancelButton(HardCodeUtil.a(2131709597));
      localActionSheet.setOnButtonClickListener(new QfileBaseRecentFileTabView.RecentFileItemLongClickListener.1.1(this, (FileManagerEntity)localObject, localActionSheet));
      localActionSheet.show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (FileManagerEntity)((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject).a;
      break;
      label121:
      if (paramView.getId() == 2131367401) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView$RecentFileItemLongClickListener.a.c((FileManagerEntity)localObject);
      } else if (paramView.getId() == 2131377800) {
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).importDebugFile(paramView, (FileManagerEntity)localObject, QfileBaseRecentFileTabView.r(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView$RecentFileItemLongClickListener.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.RecentFileItemLongClickListener.1
 * JD-Core Version:    0.7.0.1
 */