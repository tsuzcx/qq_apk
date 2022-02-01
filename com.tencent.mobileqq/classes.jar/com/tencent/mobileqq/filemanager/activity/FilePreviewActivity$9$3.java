package com.tencent.mobileqq.filemanager.activity;

import android.os.Handler;
import android.widget.TextView;

class FilePreviewActivity$9$3
  implements Runnable
{
  FilePreviewActivity$9$3(FilePreviewActivity.9 param9) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    try
    {
      str = (String)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.getText();
    }
    catch (Exception localException)
    {
      String str;
      label31:
      break label31;
    }
    str = null;
    if (str != null)
    {
      if (str.length() == 0) {
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.clearAnimation();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.9.3
 * JD-Core Version:    0.7.0.1
 */