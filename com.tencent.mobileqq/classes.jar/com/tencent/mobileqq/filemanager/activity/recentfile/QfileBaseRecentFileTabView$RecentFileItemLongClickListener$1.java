package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class QfileBaseRecentFileTabView$RecentFileItemLongClickListener$1
  implements View.OnClickListener
{
  QfileBaseRecentFileTabView$RecentFileItemLongClickListener$1(QfileBaseRecentFileTabView.RecentFileItemLongClickListener paramRecentFileItemLongClickListener, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof ImageHolder)) {
      localObject = (FileManagerEntity)((ImageHolder)localObject).a;
    } else {
      localObject = (FileManagerEntity)((RecentItemHolder)localObject).a;
    }
    if (paramView.getId() == 2131365474)
    {
      ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView$RecentFileItemLongClickListener.a.a);
      localActionSheet.setMainTitle(HardCodeUtil.a(2131698181));
      localActionSheet.addButton(HardCodeUtil.a(2131698177), 3);
      localActionSheet.addCancelButton(HardCodeUtil.a(2131692263));
      localActionSheet.setOnButtonClickListener(new QfileBaseRecentFileTabView.RecentFileItemLongClickListener.1.1(this, (FileManagerEntity)localObject, localActionSheet));
      localActionSheet.show();
    }
    else if (paramView.getId() == 2131367183)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView$RecentFileItemLongClickListener.a.c((FileManagerEntity)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.RecentFileItemLongClickListener.1
 * JD-Core Version:    0.7.0.1
 */