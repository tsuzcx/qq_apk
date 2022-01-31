package com.tencent.mobileqq.filemanager.activity;

import android.widget.RelativeLayout;
import android.widget.TextView;
import aqmw;
import com.tencent.open.downloadnew.DownloadInfo;

public class UniformDownloadActivity$10$2
  implements Runnable
{
  public UniformDownloadActivity$10$2(aqmw paramaqmw, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    UniformDownloadActivity.b(this.jdField_a_of_type_Aqmw.a).setVisibility(0);
    UniformDownloadActivity.a(this.jdField_a_of_type_Aqmw.a).setVisibility(0);
    UniformDownloadActivity.b(this.jdField_a_of_type_Aqmw.a).setText(this.jdField_a_of_type_Aqmw.a.getString(2131691995, new Object[] { this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f + "%" }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.2
 * JD-Core Version:    0.7.0.1
 */