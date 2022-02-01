package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopFileZipPreviewActivity$1
  implements View.OnClickListener
{
  TroopFileZipPreviewActivity$1(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isNeedFinish", true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.setResult(-1, localIntent);
    TroopFileZipPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.app, "dc00899", "Grp_files", null, "oper", "pre_arc_close", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin, "", "", "1");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity.1
 * JD-Core Version:    0.7.0.1
 */