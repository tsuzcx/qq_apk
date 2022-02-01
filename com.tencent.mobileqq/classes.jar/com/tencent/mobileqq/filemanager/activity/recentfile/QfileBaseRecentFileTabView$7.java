package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseRecentFileTabView$7
  implements View.OnClickListener
{
  QfileBaseRecentFileTabView$7(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject2;
    FileManagerEntity localFileManagerEntity;
    int i;
    if ((localObject1 instanceof QfileRecentFileBaseExpandableListAdapter.RecentItemHolder))
    {
      localObject2 = (QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView.getTag();
      localObject1 = ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
      localFileManagerEntity = (FileManagerEntity)((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_JavaLangObject;
      i = ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject2).b;
      i = ((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)localObject2).c;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131366919) && (QfileBaseRecentFileTabView.b(this.a))) {
        ReportController.b(QfileBaseRecentFileTabView.s(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (localFileManagerEntity != null)
      {
        localObject2 = this.a;
        if (paramView.getId() != 2131366919) {
          break label190;
        }
      }
      label190:
      for (boolean bool = true;; bool = false)
      {
        ((QfileBaseRecentFileTabView)localObject2).a(localFileManagerEntity, (View)localObject1, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!(localObject1 instanceof ImageHolder)) {
          break label195;
        }
        localObject2 = (ImageHolder)paramView.getTag();
        localObject1 = ((ImageHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
        localFileManagerEntity = (FileManagerEntity)((ImageHolder)localObject2).jdField_a_of_type_JavaLangObject;
        i = ((ImageHolder)localObject2).b;
        i = ((ImageHolder)localObject2).jdField_a_of_type_Int;
        break;
      }
      label195:
      localObject1 = null;
      localFileManagerEntity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.7
 * JD-Core Version:    0.7.0.1
 */