package com.tencent.mobileqq.weiyun.sdk.upload;

import com.tencent.weiyun.uploader.IReporter;
import com.tencent.weiyun.uploader.IUploader;
import com.tencent.weiyun.uploader.IUploader.IUploadListener;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.uploader.UploadResponse;
import com.tencent.weiyun.uploader.UploadResponse.Builder;
import com.tencent.weiyun.uploader.xplatform.UploadNative.CanceledFlag;
import java.io.File;

public class WyUploadJob
  implements IUploader, Runnable
{
  protected File a;
  protected UploadRequest b;
  protected volatile boolean c = false;
  protected volatile boolean d = false;
  private IUploader.IUploadListener e;
  private volatile int f = 0;
  
  public int a()
  {
    return this.f;
  }
  
  Transfer a(UploadRequest paramUploadRequest)
  {
    return new UploadTransfer(paramUploadRequest, this);
  }
  
  protected void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    double d1 = paramLong1;
    double d2 = paramLong2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    this.e.onUploadProgress(this.b, paramLong2, (float)d1, 0L, 0L, 0L);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    UploadResponse localUploadResponse = b(paramInt);
    this.e.onUploadFinished(this.b, paramBoolean, localUploadResponse);
  }
  
  UploadResponse b(int paramInt)
  {
    UploadResponse.Builder localBuilder = new UploadResponse.Builder();
    localBuilder.request(this.b);
    localBuilder.code(paramInt);
    return localBuilder.build();
  }
  
  public boolean b()
  {
    return (!this.c) && (!this.d);
  }
  
  boolean c()
  {
    if (!b()) {
      return false;
    }
    return d();
  }
  
  public String[] calSliceSha1(String paramString, UploadNative.CanceledFlag paramCanceledFlag)
  {
    return null;
  }
  
  public void cancel(UploadRequest paramUploadRequest)
  {
    if (paramUploadRequest != null)
    {
      UploadRequest localUploadRequest = this.b;
      if (localUploadRequest != null)
      {
        if (localUploadRequest.requestKey() == null) {
          return;
        }
        if (this.b.requestKey().equals(paramUploadRequest.requestKey())) {
          this.c = true;
        }
      }
    }
  }
  
  public void cancelAll()
  {
    this.c = true;
  }
  
  boolean d()
  {
    int i = a(this.b).a();
    a(i);
    return i == 0;
  }
  
  void e()
  {
    this.e.onUploadCanceled(this.b);
  }
  
  public void reportError(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean2, int paramInt2) {}
  
  public void run()
  {
    try
    {
      if (c() == true)
      {
        a(true, 0);
        return;
      }
      if ((!Thread.interrupted()) && (b()))
      {
        a(false, a());
        return;
      }
      if (this.c)
      {
        e();
        return;
      }
      a(false, a());
      return;
    }
    catch (Throwable localThrowable)
    {
      label63:
      break label63;
    }
    if (a() == 0) {
      a(1810014);
    }
    a(false, a());
  }
  
  public void setHttpProxy(String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void setIpConfig(String paramString1, String paramString2) {}
  
  public void setNetType(int paramInt) {}
  
  public void setReporter(IReporter paramIReporter) {}
  
  public void speedDown() {}
  
  public void trialSpeedUp(int paramInt) {}
  
  public boolean upload(UploadRequest paramUploadRequest)
  {
    if (paramUploadRequest == null) {
      return false;
    }
    this.b = paramUploadRequest;
    this.a = new File(this.b.path());
    this.e = this.b.listener();
    new Thread(this).start();
    return true;
  }
  
  public void vipSpeedUp() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.upload.WyUploadJob
 * JD-Core Version:    0.7.0.1
 */