package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloaderAssinfo
{
  public static String b = "UniformDownloaderAssinfo";
  protected String c = null;
  protected String d;
  protected long e = 0L;
  protected String f;
  protected String g;
  protected final long h;
  protected String i = null;
  protected int j = 0;
  protected Object k = new Object();
  protected int l = 0;
  protected Object m = new Object();
  protected int n = 0;
  protected Object o = new Object();
  
  public UniformDownloaderAssinfo(long paramLong)
  {
    this.h = paramLong;
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    if (i()) {
      return 0;
    }
    if ((paramString != null) && (paramBundle != null)) {}
    try
    {
      this.c = paramString;
      this.f = paramBundle.getString("_PARAM_FILEPATH");
      this.g = paramBundle.getString("_PARAM_TMP_FILEPATH");
      this.d = paramBundle.getString("_PARAM_FILENAME");
      this.e = paramBundle.getLong("_PARAM_FILESIZE");
      this.i = paramBundle.getString("_PARAM_COOKIE");
      paramString = b;
      paramBundle = new StringBuilder();
      paramBundle.append("[UniformDL][");
      paramBundle.append(this.h);
      paramBundle.append("] init. ST:");
      paramBundle.append(e());
      paramBundle.append(" PGR:");
      paramBundle.append(h());
      QLog.i(paramString, 1, paramBundle.toString());
      c(1);
      return 0;
    }
    finally {}
    paramString = b;
    paramBundle = new StringBuilder();
    paramBundle.append("[UniformDL][");
    paramBundle.append(this.h);
    paramBundle.append("]. init param error");
    QLog.e(paramString, 1, paramBundle.toString());
    return -1;
  }
  
  protected void a(int paramInt)
  {
    synchronized (this.k)
    {
      this.j = paramInt;
      return;
    }
  }
  
  protected void b(int paramInt)
  {
    synchronized (this.m)
    {
      this.l = paramInt;
      return;
    }
  }
  
  protected void c(int paramInt)
  {
    synchronized (this.o)
    {
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] setStatus. ");
      localStringBuilder.append(this.n);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      QLog.i(str, 1, localStringBuilder.toString());
      this.n = paramInt;
      return;
    }
  }
  
  public int e()
  {
    synchronized (this.o)
    {
      int i1 = this.n;
      return i1;
    }
  }
  
  protected int g()
  {
    synchronized (this.k)
    {
      int i1 = this.j;
      return i1;
    }
  }
  
  public int h()
  {
    synchronized (this.m)
    {
      int i1 = this.l;
      return i1;
    }
  }
  
  protected boolean i()
  {
    return e() >= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAssinfo
 * JD-Core Version:    0.7.0.1
 */