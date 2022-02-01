package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DefaultFileModel$8
  implements View.OnClickListener
{
  DefaultFileModel$8(DefaultFileModel paramDefaultFileModel, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.a != null)
    {
      int i = this.jdField_a_of_type_Int;
      if (i == 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A745", "0X800A745", QFileUtils.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.e()), 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.a.d()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.a.b();
        }
      }
      else if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.a.g();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel.8
 * JD-Core Version:    0.7.0.1
 */