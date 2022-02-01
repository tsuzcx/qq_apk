package com.tencent.smtt.sdk;

import android.util.Log;
import com.tencent.smtt.utils.TbsLog;

public class TbsLogReport$TbsLogInfo
  implements Cloneable
{
  int a;
  private long b;
  private String c;
  private String d;
  private int e;
  private int f;
  private int g;
  private int h;
  private String i;
  private int j;
  private int k;
  private long l;
  private long m;
  private int n;
  private String o;
  private String p;
  private long q;
  
  private TbsLogReport$TbsLogInfo()
  {
    resetArgs();
  }
  
  protected Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return this;
  }
  
  public int getDownFinalFlag()
  {
    return this.k;
  }
  
  public void resetArgs()
  {
    this.b = 0L;
    this.c = null;
    this.d = null;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 2;
    this.i = "unknown";
    this.j = 0;
    this.k = 2;
    this.l = 0L;
    this.m = 0L;
    this.n = 1;
    this.a = 0;
    this.o = null;
    this.p = null;
    this.q = 0L;
  }
  
  public void setApn(String paramString)
  {
    this.i = paramString;
  }
  
  public void setCheckErrorDetail(String paramString)
  {
    setErrorCode(108);
    this.o = paramString;
  }
  
  public void setDownConsumeTime(long paramLong)
  {
    this.m += paramLong;
  }
  
  public void setDownFinalFlag(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setDownloadCancel(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setDownloadSize(long paramLong)
  {
    this.q += paramLong;
  }
  
  public void setDownloadUrl(String paramString)
  {
    if (this.c == null)
    {
      this.c = paramString;
      return;
    }
    this.c = (this.c + ";" + paramString);
  }
  
  public void setErrorCode(int paramInt)
  {
    if ((paramInt != 100) && (paramInt != 110) && (paramInt != 120) && (paramInt != 111) && (paramInt < 400)) {
      TbsLog.i("TbsDownload", "error occured, errorCode:" + paramInt, true);
    }
    if (paramInt == 111) {
      TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
    }
    this.a = paramInt;
  }
  
  public void setEventTime(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void setFailDetail(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String str = paramString;
    if (paramString.length() > 1024) {
      str = paramString.substring(0, 1024);
    }
    this.p = str;
  }
  
  public void setFailDetail(Throwable paramThrowable)
  {
    if (paramThrowable == null)
    {
      this.p = "";
      return;
    }
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    this.p = paramThrowable;
  }
  
  public void setHttpCode(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setNetworkChange(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setNetworkType(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setPatchUpdateFlag(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setPkgSize(long paramLong)
  {
    this.l = paramLong;
  }
  
  public void setResolveIp(String paramString)
  {
    this.d = paramString;
  }
  
  public void setUnpkgFlag(int paramInt)
  {
    this.h = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo
 * JD-Core Version:    0.7.0.1
 */