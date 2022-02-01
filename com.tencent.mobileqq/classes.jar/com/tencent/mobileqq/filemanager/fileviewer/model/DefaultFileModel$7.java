package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DefaultFileModel$7
  implements View.OnClickListener
{
  DefaultFileModel$7(DefaultFileModel paramDefaultFileModel, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.a != null)
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label86;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A745", "0X800A745", QFileUtils.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.e()), 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.a.d()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.a.b();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label86:
      if (this.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.a.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel.7
 * JD-Core Version:    0.7.0.1
 */