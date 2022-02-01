package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

class QfileBaseLocalFileTabView$4$1$1
  implements ActionSheet.OnButtonClickListener
{
  QfileBaseLocalFileTabView$4$1$1(QfileBaseLocalFileTabView.4.1 param1, FileInfo paramFileInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())) || (FileUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())))
    {
      FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileBaseLocalFileTabView$4$1.a.a.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    }
    try
    {
      paramView = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      paramView.setData(Uri.fromFile(new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileBaseLocalFileTabView$4$1.a.a.a.sendBroadcast(paramView);
      label104:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileBaseLocalFileTabView$4$1.a.a.f();
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      FMToastUtil.a(2131692346);
      return;
    }
    catch (Exception paramView)
    {
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.4.1.1
 * JD-Core Version:    0.7.0.1
 */