package com.tencent.mobileqq.filebrowser;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.util.QBrowserUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FileBrowserActivity$6
  implements View.OnClickListener
{
  FileBrowserActivity$6(FileBrowserActivity paramFileBrowserActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A745", "0X800A745", QBrowserUtils.b(FileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileBrowserActivity).a()), 0, "", "", "", "");
      if (FileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileBrowserActivity)) {
        this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileBrowserActivity.finish();
      }
    }
    else if (i == 2)
    {
      FileBrowserActivity.c(this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileBrowserActivity);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.FileBrowserActivity.6
 * JD-Core Version:    0.7.0.1
 */