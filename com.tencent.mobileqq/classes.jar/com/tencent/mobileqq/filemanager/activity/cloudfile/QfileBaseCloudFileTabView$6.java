package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QfileBaseCloudFileTabView$6
  implements ActionSheet.OnButtonClickListener
{
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (((IQQFileEngine)QfileBaseCloudFileTabView.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView).getRuntimeService(IQQFileEngine.class, "")).delete(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView.jdField_a_of_type_Long))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView.setListFooter();
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileBaseCloudFileTabView.ai_();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.6
 * JD-Core Version:    0.7.0.1
 */