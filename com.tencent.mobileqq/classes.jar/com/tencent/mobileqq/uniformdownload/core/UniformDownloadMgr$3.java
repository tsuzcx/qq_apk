package com.tencent.mobileqq.uniformdownload.core;

import android.os.Bundle;
import com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr;
import com.tencent.mobileqq.uniformdownload.data.UDFileInfo;

class UniformDownloadMgr$3
  implements Runnable
{
  UniformDownloadMgr$3(UniformDownloadMgr paramUniformDownloadMgr, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    UDFileInfo.a(this.a, this.b);
    this.this$0.c(this.a, this.b);
    UniformDownloadMgr.b(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.3
 * JD-Core Version:    0.7.0.1
 */