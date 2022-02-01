package com.tencent.mobileqq.filemanager.activity;

import android.app.Activity;
import com.tencent.biz.troop.file.TroopFileProtocol.OnGetZipFileList;
import com.tencent.biz.troop.file.ZipFilesListAdapter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import com.tencent.widget.XListView;
import java.util.List;

class TroopFileZipPreviewActivity$2
  implements TroopFileProtocol.OnGetZipFileList
{
  TroopFileZipPreviewActivity$2(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(List<ZipFilePresenter.FileData> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.stopTitleProgress();
    if (paramList != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity;
      ((TroopFileZipPreviewActivity)localObject).jdField_a_of_type_JavaUtilList = paramList;
      ((TroopFileZipPreviewActivity)localObject).jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter = new ZipFilesListAdapter(paramList, (Activity)localObject);
      paramList = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.e);
      ((StringBuilder)localObject).append("/");
      paramList.e = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_b_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.c = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.c;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.d = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.d;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.f, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_Short);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */