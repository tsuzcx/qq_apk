package com.tencent.mobileqq.filemanageraux.core;

import android.content.IntentFilter;
import auht;
import auhu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$1
  implements Runnable
{
  public UniformDownloadMgr$1(auht paramauht) {}
  
  public void run()
  {
    try
    {
      if (auht.a(this.this$0) == null)
      {
        auht.a(this.this$0, new auhu(this));
        IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.qfile_unifromdownload");
        BaseApplicationImpl.getApplication().registerReceiver(auht.a(this.this$0), localIntentFilter);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */