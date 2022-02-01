package com.tencent.mobileqq.filemanager.activity.localfile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

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
    }
    else
    {
      if (!(localObject instanceof QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)) {
        break label172;
      }
      localObject = (FileInfo)((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)this.jdField_a_of_type_AndroidViewView.getTag()).a;
    }
    if (paramView.getId() == 2131365474)
    {
      ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileBaseLocalFileTabView$4.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      localActionSheet.setMainTitle(HardCodeUtil.a(2131698184));
      localActionSheet.addButton(HardCodeUtil.a(2131698177), 3);
      localActionSheet.addCancelButton(HardCodeUtil.a(2131692263));
      localActionSheet.setOnButtonClickListener(new QfileBaseLocalFileTabView.4.1.1(this, (FileInfo)localObject, localActionSheet));
      localActionSheet.show();
    }
    else if (paramView.getId() == 2131367183)
    {
      localObject = QQFileManagerUtil.a((FileInfo)localObject);
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).forwardFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileBaseLocalFileTabView$4.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (FileManagerEntity)localObject);
      break label187;
      label172:
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseLocalFileTabView.jdField_a_of_type_JavaLangString, 2, "unknow Object");
      }
    }
    label187:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.4.1
 * JD-Core Version:    0.7.0.1
 */