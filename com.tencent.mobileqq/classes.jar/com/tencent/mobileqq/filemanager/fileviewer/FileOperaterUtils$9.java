package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils.GetTeamWorkImportInfoListener;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

final class FileOperaterUtils$9
  implements View.OnClickListener
{
  FileOperaterUtils$9(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean, TeamWorkConvertUtils.GetTeamWorkImportInfoListener paramGetTeamWorkImportInfoListener) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (this.jdField_a_of_type_Boolean) {
        TenDocLogReportHelper.a(null, "0X800A21D");
      } else {
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009063", "0X8009063", 0, 0, "", "", "", "");
      }
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.c = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
      localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
      localTeamWorkFileImportInfo.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType;
      if (this.jdField_a_of_type_Boolean) {
        localTeamWorkFileImportInfo.jdField_d_of_type_Int = 8;
      } else {
        localTeamWorkFileImportInfo.jdField_d_of_type_Int = 5;
      }
      localTeamWorkFileImportInfo.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
      boolean bool1;
      if ((localActivity instanceof FileBrowserActivity))
      {
        boolean bool2 = ((FileBrowserActivity)localActivity).g();
        if ((((FileBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).c()) && (!bool2)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = bool1;
        bool1 = bool2;
      }
      else
      {
        bool1 = false;
      }
      if ((bool1) && (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath())))
      {
        QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131719533), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299168));
      }
      else
      {
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
        TeamWorkConvertUtils.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidAppActivity, (AppInterface)localObject, localTeamWorkFileImportInfo.jdField_d_of_type_Int);
        localObject = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkConvertUtils$GetTeamWorkImportInfoListener;
        if (localObject != null) {
          ((TeamWorkConvertUtils.GetTeamWorkImportInfoListener)localObject).a(localTeamWorkFileImportInfo);
        }
      }
    }
    else
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131719528), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299168));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.9
 * JD-Core Version:    0.7.0.1
 */