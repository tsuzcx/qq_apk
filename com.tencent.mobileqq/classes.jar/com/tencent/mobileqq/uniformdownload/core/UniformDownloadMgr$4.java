package com.tencent.mobileqq.uniformdownload.core;

import android.os.Bundle;
import com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr;
import com.tencent.mobileqq.uniformdownload.data.UDFileInfo;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;

class UniformDownloadMgr$4
  implements Runnable
{
  UniformDownloadMgr$4(UniformDownloadMgr paramUniformDownloadMgr, String paramString, Bundle paramBundle, IUniformDownloaderListener paramIUniformDownloaderListener) {}
  
  public void run()
  {
    UDFileInfo.a(this.a, this.b);
    this.this$0.a(this.a, this.c);
    this.this$0.c(this.a, this.b);
    UniformDownloadMgr.b(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.4
 * JD-Core Version:    0.7.0.1
 */