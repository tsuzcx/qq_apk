package com.tencent.mobileqq.uniformdownload.core;

import android.content.IntentFilter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class UniformDownloadMgr$1
  implements Runnable
{
  UniformDownloadMgr$1(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    try
    {
      Object localObject = UniformDownloadMgr.a(this.this$0);
      if (localObject != null)
      {
        QLog.w("UniformDownloadMgr_Impl", 1, "[UniformDL-onAppInit] mRecv is already setted");
        return;
      }
      UniformDownloadMgr.a(this.this$0, new UniformDownloadMgr.1.1(this));
      localObject = new IntentFilter("com.tencent.mobileqq.qfile_unifromdownload");
      BaseApplication.getContext().registerReceiver(UniformDownloadMgr.a(this.this$0), (IntentFilter)localObject);
      QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-onAppInit] UniformDownloadMgr Register UNIDOWNLOAD_BORDCAST");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */