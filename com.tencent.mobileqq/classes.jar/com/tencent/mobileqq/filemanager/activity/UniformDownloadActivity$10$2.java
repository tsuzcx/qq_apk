package com.tencent.mobileqq.filemanager.activity;

import android.widget.RelativeLayout;
import android.widget.TextView;
import aopp;
import com.tencent.open.downloadnew.DownloadInfo;

public class UniformDownloadActivity$10$2
  implements Runnable
{
  public UniformDownloadActivity$10$2(aopp paramaopp, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    UniformDownloadActivity.b(this.jdField_a_of_type_Aopp.a).setVisibility(0);
    UniformDownloadActivity.a(this.jdField_a_of_type_Aopp.a).setVisibility(0);
    UniformDownloadActivity.b(this.jdField_a_of_type_Aopp.a).setText(this.jdField_a_of_type_Aopp.a.getString(2131691939, new Object[] { this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f + "%" }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.2
 * JD-Core Version:    0.7.0.1
 */