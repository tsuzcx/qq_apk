package com.tencent.mobileqq.uniformdownload.data;

import android.os.Bundle;
import com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader;
import com.tencent.qphone.base.util.QLog;

public class DownloadInstContextMgr$DownloadInstContext
{
  final long a;
  final Bundle b;
  public final int c;
  public String d;
  public UniformDownloader e;
  public final int f;
  
  public DownloadInstContextMgr$DownloadInstContext(Bundle paramBundle, int paramInt1, UniformDownloader paramUniformDownloader, long paramLong, int paramInt2)
  {
    this.b = paramBundle;
    this.c = paramInt1;
    this.e = paramUniformDownloader;
    this.a = paramLong;
    this.d = paramUniformDownloader.a();
    this.f = paramInt2;
    paramBundle = new StringBuilder();
    paramBundle.append("[UniformDL] new DownloadInst.[ mUDID:[");
    paramBundle.append(this.a);
    paramBundle.append("] url:");
    paramBundle.append(this.d);
    paramBundle.append(" ]");
    QLog.i("DownloadInstContextMgr", 1, paramBundle.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr.DownloadInstContext
 * JD-Core Version:    0.7.0.1
 */