package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.base.LogUtility;
import java.util.Map;

class DownloaderGetCodeClient$1
  implements Runnable
{
  DownloaderGetCodeClient$1(DownloaderGetCodeClient paramDownloaderGetCodeClient, String paramString, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (((Boolean)DownloaderGetCodeClient.a(this.this$0).get(DownloaderGetCodeClient.a(this.this$0, this.a, this.b))).booleanValue())
    {
      LogUtility.c("DownloaderGetCodeClient", "last request not back,retry ......");
      QIPCClientHelper.getInstance().callServer("Module_DownloaderGetCodeServer", "DownloaderWriteCodeIPC_Action__GetCode", this.c, DownloaderGetCodeClient.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloaderGetCodeClient.1
 * JD-Core Version:    0.7.0.1
 */