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
    if (this.a != null)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        int i = ((Bundle)localObject).getInt("_notify_param_Id");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[UniformDL] >>>onDownloadNotificationBeClean. URL:");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(" nofiyid:");
        ((StringBuilder)localObject).append(i);
        QLog.i("UniformDownloadMgr_Impl", 1, ((StringBuilder)localObject).toString());
        UniformDownloadMgr.b(this.this$0).a(this.a);
        UniformDownloadMgr.b(this.this$0).e(this.a);
        UniformDownloadMgr.b(this.this$0).b(this.a);
        UniformDownloadMgr.e(this.this$0).a(this.a);
        UniformDownloadMgr.b(this.this$0).b();
        return;
      }
    }
    QLog.e("UniformDownloadMgr_Impl", 1, "[UniformDL] onDownloadNotificationBeClean. param error!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.9
 * JD-Core Version:    0.7.0.1
 */