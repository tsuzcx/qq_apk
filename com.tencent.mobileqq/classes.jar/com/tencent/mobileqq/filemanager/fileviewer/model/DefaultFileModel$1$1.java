package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.biz.troop.file.TroopFileProtocol.OnGetZipFileList;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

class DefaultFileModel$1$1
  implements TroopFileProtocol.OnGetZipFileList
{
  DefaultFileModel$1$1(DefaultFileModel.1 param1, boolean paramBoolean, String paramString, short paramShort) {}
  
  public void a(List<ZipFilePresenter.FileData> paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel$1.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel$1.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener.a(paramList, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel$1.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel$1.a.b, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel$1.a.c, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel$1.a.d, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Short);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel$1.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener.a(-1000L);
      }
    }
    if (paramList != null)
    {
      paramList = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel$1.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel$1.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin);
      ReportController.b(paramList, "dc00899", "Grp_files", null, "oper", "pre_arc_suc", 0, 0, localStringBuilder.toString(), "", FileManagerUtil.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel$1.a.c()), "1");
      return;
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel$1.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel$1.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin);
    ReportController.b(paramList, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, localStringBuilder.toString(), "-1", FileManagerUtil.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel$1.a.c()), "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel.1.1
 * JD-Core Version:    0.7.0.1
 */