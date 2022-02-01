package com.tencent.mobileqq.uniformdownload.core;

import android.os.Bundle;
import com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr;
import com.tencent.mobileqq.uniformdownload.data.UDFileInfo;
import com.tencent.qphone.base.util.QLog;

class UniformDownloadMgr$5
  implements Runnable
{
  UniformDownloadMgr$5(UniformDownloadMgr paramUniformDownloadMgr, Bundle paramBundle, String paramString) {}
  
  public void run()
  {
    this.a.putLong("_filesize_from_dlg", UDFileInfo.a(this.b, 4));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【UniformDL-startDownloadNoSzie】 fileSize: ");
    localStringBuilder.append(this.a.getLong("_filesize_from_dlg", 0L));
    QLog.d("UniformDownloadMgr_Impl", 1, localStringBuilder.toString());
    this.this$0.c(this.b, this.a);
    UniformDownloadMgr.b(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.5
 * JD-Core Version:    0.7.0.1
 */