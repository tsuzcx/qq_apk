package com.tencent.mobileqq.filemanager.activity;

import android.widget.RelativeLayout;
import android.widget.TextView;

class UniformDownloadActivity$11$4
  implements Runnable
{
  UniformDownloadActivity$11$4(UniformDownloadActivity.11 param11, int paramInt) {}
  
  public void run()
  {
    UniformDownloadActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityUniformDownloadActivity$11.a).setVisibility(0);
    TextView localTextView = UniformDownloadActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityUniformDownloadActivity$11.a);
    UniformDownloadActivity localUniformDownloadActivity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityUniformDownloadActivity$11.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("%");
    localTextView.setText(localUniformDownloadActivity.getString(2131691845, new Object[] { localStringBuilder.toString() }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11.4
 * JD-Core Version:    0.7.0.1
 */