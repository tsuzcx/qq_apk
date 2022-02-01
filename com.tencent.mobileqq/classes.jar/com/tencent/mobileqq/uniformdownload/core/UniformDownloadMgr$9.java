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
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      Object localObject = this.jdField_a_of_type_AndroidOsBundle;
      if (localObject != null)
      {
        int i = ((Bundle)localObject).getInt("_notify_param_Id");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[UniformDL] >>>onDownloadNotificationBeClean. URL:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(" nofiyid:");
        ((StringBuilder)localObject).append(i);
        QLog.i("UniformDownloadMgr_Impl", 1, ((StringBuilder)localObject).toString());
        UniformDownloadMgr.a(this.this$0).a(this.jdField_a_of_type_JavaLangString);
        UniformDownloadMgr.a(this.this$0).d(this.jdField_a_of_type_JavaLangString);
        UniformDownloadMgr.a(this.this$0).a(this.jdField_a_of_type_JavaLangString);
        UniformDownloadMgr.a(this.this$0).a(this.jdField_a_of_type_JavaLangString);
        UniformDownloadMgr.a(this.this$0).b();
        return;
      }
    }
    QLog.e("UniformDownloadMgr_Impl", 1, "[UniformDL] onDownloadNotificationBeClean. param error!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.9
 * JD-Core Version:    0.7.0.1
 */