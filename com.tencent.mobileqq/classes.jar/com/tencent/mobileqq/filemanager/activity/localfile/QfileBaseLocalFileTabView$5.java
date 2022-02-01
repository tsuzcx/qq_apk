package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QfileBaseLocalFileTabView$5
  implements View.OnClickListener
{
  QfileBaseLocalFileTabView$5(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    boolean bool2 = localObject1 instanceof QfileLocalFileBaseExpandableListAdapter.LocalItemHolder;
    boolean bool1 = true;
    FileInfo localFileInfo = null;
    Object localObject2;
    if (bool2)
    {
      localObject1 = (QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag();
      localFileInfo = (FileInfo)((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject1).jdField_a_of_type_JavaLangObject;
      localObject1 = ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    }
    else if ((localObject1 instanceof ImageHolder))
    {
      localObject2 = (ImageHolder)paramView.getTag();
      localFileInfo = (FileInfo)((ImageHolder)localObject2).jdField_a_of_type_JavaLangObject;
      localObject1 = ((ImageHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
      if ((this.a.a.g()) || (this.a.a.h()))
      {
        SharedPreferences.Editor localEditor = this.a.a.getSharedPreferences("LAST_CHOOSE_", 0).edit();
        localEditor.putInt("GROUP", ((ImageHolder)localObject2).b);
        localEditor.putInt("CHILD", (((ImageHolder)localObject2).jdField_a_of_type_Int + 1) / 4);
        localEditor.commit();
      }
    }
    else
    {
      localObject1 = null;
    }
    if ((paramView.getId() == 2131366781) && (QfileBaseLocalFileTabView.b(this.a))) {
      ReportController.b(QfileBaseLocalFileTabView.a(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
    }
    if (localFileInfo != null)
    {
      localObject2 = this.a;
      if (paramView.getId() != 2131366781) {
        bool1 = false;
      }
      ((QfileBaseLocalFileTabView)localObject2).a(localFileInfo, (View)localObject1, bool1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.5
 * JD-Core Version:    0.7.0.1
 */