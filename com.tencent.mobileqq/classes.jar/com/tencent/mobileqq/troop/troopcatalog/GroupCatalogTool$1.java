package com.tencent.mobileqq.troop.troopcatalog;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class GroupCatalogTool$1
  extends DownloadListener
{
  GroupCatalogTool$1(GroupCatalogTool paramGroupCatalogTool, File paramFile, GroupCatalogTool.GetChoiceListCallback paramGetChoiceListCallback) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupCatalogTool", 2, "getChoiceListFromServer download suc ");
    }
    int i;
    if ((paramDownloadTask.a == 0) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogTool.a(MobileQQ.getContext())) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogTool.b(MobileQQ.getContext())))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogTool.a(MobileQQ.getContext(), System.currentTimeMillis());
      paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogTool$GetChoiceListCallback;
      if (paramDownloadTask != null) {
        paramDownloadTask.a(true);
      }
      i = 1;
    }
    else
    {
      i = 0;
    }
    if ((i == 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogTool$GetChoiceListCallback != null))
    {
      QLog.e("GroupCatalogTool", 1, "getChoiceListFromServer failed!");
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogTool$GetChoiceListCallback.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool.1
 * JD-Core Version:    0.7.0.1
 */