package com.tencent.mobileqq.filemanager.activity;

import android.widget.TextView;

class FilePreviewActivity$16$1
  implements Runnable
{
  FilePreviewActivity$16$1(FilePreviewActivity.16 param16, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$16.a.a()) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(this.jdField_a_of_type_Int));
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(String.valueOf(this.b));
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$16.a.a.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16.1
 * JD-Core Version:    0.7.0.1
 */