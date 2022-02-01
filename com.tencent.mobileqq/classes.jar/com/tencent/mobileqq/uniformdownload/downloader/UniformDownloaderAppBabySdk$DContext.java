package com.tencent.mobileqq.uniformdownload.downloader;

import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderAppBabyListener;
import com.tencent.qphone.base.util.QLog;

class UniformDownloaderAppBabySdk$DContext
{
  final long a;
  final String b;
  final long c;
  long d;
  Object e = new Object();
  int f;
  Object g = new Object();
  Object h = new Object();
  int i;
  IUniformDownloaderAppBabyListener j;
  
  UniformDownloaderAppBabySdk$DContext(UniformDownloaderAppBabySdk paramUniformDownloaderAppBabySdk, long paramLong1, String paramString, long paramLong2)
  {
    this.a = paramLong1;
    this.f = 2;
    this.b = paramString;
    this.c = paramLong2;
    this.d = 0L;
    this.i = -1;
  }
  
  long a()
  {
    synchronized (this.e)
    {
      long l = this.d;
      return l;
    }
  }
  
  void a(int paramInt)
  {
    synchronized (this.g)
    {
      String str = UniformDownloaderAppBabySdk.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] setStatus:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" -> ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("url:");
      localStringBuilder.append(this.b);
      QLog.i(str, 1, localStringBuilder.toString());
      this.f = paramInt;
      return;
    }
  }
  
  void a(long paramLong)
  {
    synchronized (this.e)
    {
      this.d = paramLong;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk.DContext
 * JD-Core Version:    0.7.0.1
 */