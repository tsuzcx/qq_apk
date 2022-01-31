package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import araj;
import arao;
import azrh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class UniformDownloadMgr$13
  implements Runnable
{
  public UniformDownloadMgr$13(araj paramaraj, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_AndroidOsBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] onDownloadNotificationBeClean. param error!!");
      return;
    }
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("_notify_param_Id");
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>onDownloadNotificationBeClean. URL:" + this.jdField_a_of_type_JavaLangString + " nofiyid:" + i);
    arao localarao = araj.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localarao != null) && (this.this$0.a != null))
    {
      if (localarao.a != 1) {
        break label175;
      }
      azrh.a(this.this$0.a.getApplication().getApplicationContext(), this.this$0.a.getCurrentAccountUin(), "Stop_download_2-1_3-0");
    }
    for (;;)
    {
      araj.c(this.this$0, this.jdField_a_of_type_JavaLangString);
      araj.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      this.this$0.b(this.jdField_a_of_type_JavaLangString);
      araj.b(this.this$0);
      return;
      label175:
      azrh.a(this.this$0.a.getApplication().getApplicationContext(), this.this$0.a.getCurrentAccountUin(), "Stop_download_2-1_3-1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.13
 * JD-Core Version:    0.7.0.1
 */