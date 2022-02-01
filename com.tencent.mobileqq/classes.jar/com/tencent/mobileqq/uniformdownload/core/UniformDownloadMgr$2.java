package com.tencent.mobileqq.uniformdownload.core;

import android.content.BroadcastReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class UniformDownloadMgr$2
  implements Runnable
{
  UniformDownloadMgr$2(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    try
    {
      BroadcastReceiver localBroadcastReceiver = UniformDownloadMgr.a(this.this$0);
      if (localBroadcastReceiver == null)
      {
        QLog.w("UniformDownloadMgr_Impl", 1, "[UniformDL-onAppDestroy] UniformDownloadMgr unRegister UNIDOWNLOAD_BORDCAST, had unRegister");
        return;
      }
      BaseApplication.getContext().unregisterReceiver(UniformDownloadMgr.a(this.this$0));
      UniformDownloadMgr.a(this.this$0, null);
      QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-onAppDestroy] UniformDownloadMgr unRegister UNIDOWNLOAD_BORDCAST");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.2
 * JD-Core Version:    0.7.0.1
 */