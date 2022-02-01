package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class SimpleFileViewer$10
  implements ActionSheet.OnButtonClickListener
{
  SimpleFileViewer$10(SimpleFileViewer paramSimpleFileViewer, QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    TeamWorkConvertUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a, "FileBrowserViewBase", this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.10
 * JD-Core Version:    0.7.0.1
 */