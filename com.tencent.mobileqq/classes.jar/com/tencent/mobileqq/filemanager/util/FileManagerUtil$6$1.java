package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.statistics.ReportController;

class FileManagerUtil$6$1
  implements FMDialogUtil.FMDialogInterface
{
  FileManagerUtil$6$1(FileManagerUtil.6 param6, Activity paramActivity) {}
  
  public void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X800AE48", "0X800AE48", 0, 0, "", "", "", "");
    Bundle localBundle = new Bundle();
    localBundle.putString("_open_with_qq_browser_", this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$6.a);
    FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, "https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10386", localBundle);
  }
  
  public void b()
  {
    ReportController.b(null, "dc00898", "", "", "0X800AE49", "0X800AE49", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.6.1
 * JD-Core Version:    0.7.0.1
 */