package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import aome;
import aomj;
import awrm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class UniformDownloadMgr$13
  implements Runnable
{
  public UniformDownloadMgr$13(aome paramaome, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_AndroidOsBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] onDownloadNotificationBeClean. param error!!");
      return;
    }
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("_notify_param_Id");
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>onDownloadNotificationBeClean. URL:" + this.jdField_a_of_type_JavaLangString + " nofiyid:" + i);
    aomj localaomj = aome.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localaomj != null) && (this.this$0.a != null))
    {
      if (localaomj.a != 1) {
        break label175;
      }
      awrm.a(this.this$0.a.getApplication().getApplicationContext(), this.this$0.a.getCurrentAccountUin(), "Stop_download_2-1_3-0");
    }
    for (;;)
    {
      aome.c(this.this$0, this.jdField_a_of_type_JavaLangString);
      aome.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      this.this$0.b(this.jdField_a_of_type_JavaLangString);
      aome.b(this.this$0);
      return;
      label175:
      awrm.a(this.this$0.a.getApplication().getApplicationContext(), this.this$0.a.getCurrentAccountUin(), "Stop_download_2-1_3-1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.13
 * JD-Core Version:    0.7.0.1
 */