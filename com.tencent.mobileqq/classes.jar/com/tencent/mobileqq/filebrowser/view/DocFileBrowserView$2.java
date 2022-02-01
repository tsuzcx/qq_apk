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
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      TeamWorkConvertUtils.a(this.a, this.d.e, "FileBrowserViewBase", this.b);
      this.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.DocFileBrowserView.2
 * JD-Core Version:    0.7.0.1
 */