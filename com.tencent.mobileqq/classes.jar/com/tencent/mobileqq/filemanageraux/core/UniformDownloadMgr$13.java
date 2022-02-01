package com.tencent.mobileqq.filemanageraux.core;

import android.os.Bundle;
import aure;
import aurj;
import bdmb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class UniformDownloadMgr$13
  implements Runnable
{
  public UniformDownloadMgr$13(aure paramaure, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_AndroidOsBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] onDownloadNotificationBeClean. param error!!");
      return;
    }
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("_notify_param_Id");
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>onDownloadNotificationBeClean. URL:" + this.jdField_a_of_type_JavaLangString + " nofiyid:" + i);
    aurj localaurj = aure.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localaurj != null) && (this.this$0.a != null))
    {
      if (localaurj.a != 1) {
        break label175;
      }
      bdmb.a(this.this$0.a.getApplication().getApplicationContext(), this.this$0.a.getCurrentAccountUin(), "Stop_download_2-1_3-0");
    }
    for (;;)
    {
      aure.c(this.this$0, this.jdField_a_of_type_JavaLangString);
      aure.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      this.this$0.b(this.jdField_a_of_type_JavaLangString);
      aure.b(this.this$0);
      return;
      label175:
      bdmb.a(this.this$0.a.getApplication().getApplicationContext(), this.this$0.a.getCurrentAccountUin(), "Stop_download_2-1_3-1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.13
 * JD-Core Version:    0.7.0.1
 */