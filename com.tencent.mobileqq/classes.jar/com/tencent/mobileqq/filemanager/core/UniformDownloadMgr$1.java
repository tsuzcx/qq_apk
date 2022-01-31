package com.tencent.mobileqq.filemanager.core;

import android.content.IntentFilter;
import aqwa;
import aqwb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$1
  implements Runnable
{
  public UniformDownloadMgr$1(aqwa paramaqwa) {}
  
  public void run()
  {
    try
    {
      if (aqwa.a(this.this$0) == null)
      {
        aqwa.a(this.this$0, new aqwb(this));
        IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.qfile_unifromdownload");
        BaseApplicationImpl.getApplication().registerReceiver(aqwa.a(this.this$0), localIntentFilter);
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr Register UNIDOWNLOAD_BORDCAST");
        return;
      }
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] UniformDownloadMgr onAppInit, but mRecv is already setted");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */