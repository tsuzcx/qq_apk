package com.tencent.mobileqq.uniformdownload.core;

import android.os.Bundle;
import com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr;
import com.tencent.mobileqq.uniformdownload.data.DownloadingRbResmeInfoMgr;
import com.tencent.qphone.base.util.QLog;

class UniformDownloadMgr$9
  implements Runnable
{
  UniformDownloadMgr$9(UniformDownloadMgr paramUniformDownloadMgr, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_AndroidOsBundle == null))
    {
      QLog.e("UniformDownloadMgr_Impl", 1, "[UniformDL] onDownloadNotificationBeClean. param error!!");
      return;
    }
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("_notify_param_Id");
    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>onDownloadNotificationBeClean. URL:" + this.jdField_a_of_type_JavaLangString + " nofiyid:" + i);
    UniformDownloadMgr.a(this.this$0).a(this.jdField_a_of_type_JavaLangString);
    UniformDownloadMgr.a(this.this$0).d(this.jdField_a_of_type_JavaLangString);
    UniformDownloadMgr.a(this.this$0).a(this.jdField_a_of_type_JavaLangString);
    UniformDownloadMgr.a(this.this$0).a(this.jdField_a_of_type_JavaLangString);
    UniformDownloadMgr.a(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.9
 * JD-Core Version:    0.7.0.1
 */