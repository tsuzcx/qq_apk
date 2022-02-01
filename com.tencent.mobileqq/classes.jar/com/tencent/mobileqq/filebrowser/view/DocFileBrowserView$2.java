package com.tencent.mobileqq.filebrowser.view;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DocFileBrowserView$2
  implements ActionSheet.OnButtonClickListener
{
  DocFileBrowserView$2(DocFileBrowserView paramDocFileBrowserView, AppInterface paramAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      TeamWorkConvertUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.a, "FileBrowserViewBase", this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.DocFileBrowserView.2
 * JD-Core Version:    0.7.0.1
 */