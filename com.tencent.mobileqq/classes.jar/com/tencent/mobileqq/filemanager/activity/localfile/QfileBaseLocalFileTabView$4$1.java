package com.tencent.mobileqq.filemanager.activity.localfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

class QfileBaseLocalFileTabView$4$1
  implements View.OnClickListener
{
  QfileBaseLocalFileTabView$4$1(QfileBaseLocalFileTabView.4 param4, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof ImageHolder))
    {
      localObject = (FileInfo)((ImageHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
      if (paramView.getId() != 2131365630) {
        break label158;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileBaseLocalFileTabView$4.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
      localActionSheet.setMainTitle(HardCodeUtil.a(2131709594));
      localActionSheet.addButton(HardCodeUtil.a(2131709590), 3);
      localActionSheet.addCancelButton(HardCodeUtil.a(2131709591));
      localActionSheet.setOnButtonClickListener(new QfileBaseLocalFileTabView.4.1.1(this, (FileInfo)localObject, localActionSheet));
      localActionSheet.show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof QfileLocalFileBaseExpandableListAdapter.LocalItemHolder))
      {
        localObject = (FileInfo)((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "unknow Object");
        continue;
        label158:
        if (paramView.getId() == 2131367401)
        {
          localObject = FileManagerUtil.a((FileInfo)localObject);
          QFileUtils.b(QfileBaseLocalFileTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileBaseLocalFileTabView$4.a), this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileBaseLocalFileTabView$4.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.4.1
 * JD-Core Version:    0.7.0.1
 */