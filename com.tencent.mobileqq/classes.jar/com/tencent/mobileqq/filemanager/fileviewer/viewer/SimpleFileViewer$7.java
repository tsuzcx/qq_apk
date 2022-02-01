package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class SimpleFileViewer$7
  implements ActionSheet.OnButtonClickListener
{
  SimpleFileViewer$7(SimpleFileViewer paramSimpleFileViewer, QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    TeamWorkConvertUtils.a(this.a, this.d.c, "FileBrowserViewBase", this.b);
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.7
 * JD-Core Version:    0.7.0.1
 */