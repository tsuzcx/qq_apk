package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$10
  implements View.OnClickListener
{
  FileOperaterUtils$10(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    label97:
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (this.jdField_a_of_type_Boolean)
      {
        TenDocLogReportHelper.a(null, "0X800A21D");
        localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
        localTeamWorkFileImportInfo.c = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
        localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
        localTeamWorkFileImportInfo.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType;
        if (!this.jdField_a_of_type_Boolean) {
          break label241;
        }
        localTeamWorkFileImportInfo.jdField_d_of_type_Int = 8;
        localTeamWorkFileImportInfo.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity)) {
          break label415;
        }
        bool2 = ((FileBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).g();
        if ((!((FileBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).c()) || (bool2)) {
          break label250;
        }
        bool1 = true;
        label149:
        localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = bool1;
      }
    }
    label415:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if ((bool1) && (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))) {
        QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131719809), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299166));
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009063", "0X8009063", 0, 0, "", "", "", "");
        break;
        label241:
        localTeamWorkFileImportInfo.jdField_d_of_type_Int = 5;
        break label97;
        label250:
        bool1 = false;
        break label149;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin))
        {
          localTeamWorkFileImportInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
          localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin);
          localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
          localTeamWorkFileImportInfo.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.busId;
          localTeamWorkFileImportInfo.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq;
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {
            localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
          }
        }
        TeamWorkConvertUtils.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidAppActivity, localQQAppInterface, localTeamWorkFileImportInfo.jdField_d_of_type_Int);
        continue;
        QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131719804), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299166));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.10
 * JD-Core Version:    0.7.0.1
 */