package com.tencent.mobileqq.filemanager.activity;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.open.downloadnew.DownloadInfo;

class UniformDownloadActivity$10$2
  implements Runnable
{
  UniformDownloadActivity$10$2(UniformDownloadActivity.10 param10, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    UniformDownloadActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityUniformDownloadActivity$10.a).setVisibility(0);
    UniformDownloadActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityUniformDownloadActivity$10.a).setVisibility(0);
    TextView localTextView = UniformDownloadActivity.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityUniformDownloadActivity$10.a);
    UniformDownloadActivity localUniformDownloadActivity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityUniformDownloadActivity$10.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f);
    localStringBuilder.append("%");
    localTextView.setText(localUniformDownloadActivity.getString(2131691846, new Object[] { localStringBuilder.toString() }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.2
 * JD-Core Version:    0.7.0.1
 */