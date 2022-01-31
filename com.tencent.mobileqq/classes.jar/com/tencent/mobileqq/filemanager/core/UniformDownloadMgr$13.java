package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import aqwa;
import aqwf;
import azmy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class UniformDownloadMgr$13
  implements Runnable
{
  public UniformDownloadMgr$13(aqwa paramaqwa, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_AndroidOsBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] onDownloadNotificationBeClean. param error!!");
      return;
    }
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("_notify_param_Id");
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>onDownloadNotificationBeClean. URL:" + this.jdField_a_of_type_JavaLangString + " nofiyid:" + i);
    aqwf localaqwf = aqwa.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localaqwf != null) && (this.this$0.a != null))
    {
      if (localaqwf.a != 1) {
        break label175;
      }
      azmy.a(this.this$0.a.getApplication().getApplicationContext(), this.this$0.a.getCurrentAccountUin(), "Stop_download_2-1_3-0");
    }
    for (;;)
    {
      aqwa.c(this.this$0, this.jdField_a_of_type_JavaLangString);
      aqwa.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      this.this$0.b(this.jdField_a_of_type_JavaLangString);
      aqwa.b(this.this$0);
      return;
      label175:
      azmy.a(this.this$0.a.getApplication().getApplicationContext(), this.this$0.a.getCurrentAccountUin(), "Stop_download_2-1_3-1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.13
 * JD-Core Version:    0.7.0.1
 */