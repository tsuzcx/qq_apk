package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploader;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploaderCallback;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnMoreUrlFUperProp;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnMoreUrlFUperPropV1;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.IUFTRetryCallback;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTSmartUrlProvider;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTUrlProvider;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.depend.UFTSscm;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import mqq.app.AppRuntime;

public class UFTFtnFileUploader
  extends UFTFileUploaderCbWrapper
  implements IUFTFileUploader, IUFTFtnUploaderCallback, IUFTRetryCallback
{
  private final long a;
  private final String b;
  private final long c;
  private final UFTUrlProvider d;
  private String e;
  private boolean f = true;
  private long g = 0L;
  private InputStream h = null;
  private long i = 0L;
  private long j = 0L;
  private boolean k = false;
  private long o = 0L;
  private UFTSscm p = new UFTSscm();
  private IUFTFtnUploader q;
  private long r = 0L;
  private int s = 0;
  private boolean t = false;
  
  private UFTFtnFileUploader(AppRuntime paramAppRuntime, UFTFileUploaderProp.FtnMoreUrlFUperProp paramFtnMoreUrlFUperProp)
  {
    this.a = paramFtnMoreUrlFUperProp.c();
    this.b = paramFtnMoreUrlFUperProp.e();
    this.c = new File(this.b).length();
    if (paramFtnMoreUrlFUperProp.f()) {
      this.d = new UFTSmartUrlProvider(paramAppRuntime, paramFtnMoreUrlFUperProp.j(), paramFtnMoreUrlFUperProp.k(), this.a, paramFtnMoreUrlFUperProp.l(), this);
    } else {
      this.d = new UFTUrlProvider(paramAppRuntime, paramFtnMoreUrlFUperProp.j(), paramFtnMoreUrlFUperProp.k(), this.a, paramFtnMoreUrlFUperProp.l(), this);
    }
    this.e = this.d.a();
    UFTFtnUploader.UperProp localUperProp = new UFTFtnUploader.UperProp();
    localUperProp.a(this.c);
    localUperProp.a(paramFtnMoreUrlFUperProp.d());
    localUperProp.b(0);
    localUperProp.a(paramFtnMoreUrlFUperProp.g());
    localUperProp.b(paramFtnMoreUrlFUperProp.h());
    localUperProp.a(paramFtnMoreUrlFUperProp.l());
    localUperProp.c(paramFtnMoreUrlFUperProp.m());
    localUperProp.d(paramFtnMoreUrlFUperProp.i());
    this.q = UFTFtnUploader.a(paramAppRuntime, this.a, localUperProp);
    paramAppRuntime = this.q;
    if (paramAppRuntime != null) {
      paramAppRuntime.a(this);
    }
  }
  
  private UFTFtnFileUploader(AppRuntime paramAppRuntime, UFTFileUploaderProp.FtnMoreUrlFUperPropV1 paramFtnMoreUrlFUperPropV1)
  {
    this.a = paramFtnMoreUrlFUperPropV1.c();
    this.b = paramFtnMoreUrlFUperPropV1.e();
    this.c = new File(this.b).length();
    if (paramFtnMoreUrlFUperPropV1.f()) {
      this.d = new UFTSmartUrlProvider(paramAppRuntime, paramFtnMoreUrlFUperPropV1.j(), paramFtnMoreUrlFUperPropV1.k(), this.a, paramFtnMoreUrlFUperPropV1.l(), this);
    } else {
      this.d = new UFTUrlProvider(paramAppRuntime, paramFtnMoreUrlFUperPropV1.j(), paramFtnMoreUrlFUperPropV1.k(), this.a, paramFtnMoreUrlFUperPropV1.l(), this);
    }
    this.e = this.d.a();
    this.q = UFTFtnV1Uploader.a(paramAppRuntime, this.a, paramFtnMoreUrlFUperPropV1.d(), 0, paramFtnMoreUrlFUperPropV1.l(), paramFtnMoreUrlFUperPropV1.m());
    paramAppRuntime = this.q;
    if (paramAppRuntime != null) {
      paramAppRuntime.a(this);
    }
  }
  
  public static UFTFtnFileUploader a(AppRuntime paramAppRuntime, UFTFileUploaderProp.FtnMoreUrlFUperProp paramFtnMoreUrlFUperProp)
  {
    if ((paramAppRuntime != null) && (paramFtnMoreUrlFUperProp != null))
    {
      if (!paramFtnMoreUrlFUperProp.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("prop invaild:");
        localStringBuilder.append(paramFtnMoreUrlFUperProp.b());
        UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, localStringBuilder.toString());
      }
      return new UFTFtnFileUploader(paramAppRuntime, paramFtnMoreUrlFUperProp);
    }
    UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, "app|prop is null");
    return null;
  }
  
  public static UFTFtnFileUploader a(AppRuntime paramAppRuntime, UFTFileUploaderProp.FtnMoreUrlFUperPropV1 paramFtnMoreUrlFUperPropV1)
  {
    if ((paramAppRuntime != null) && (paramFtnMoreUrlFUperPropV1 != null))
    {
      if (!paramFtnMoreUrlFUperPropV1.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("prop invaild:");
        localStringBuilder.append(paramFtnMoreUrlFUperPropV1.b());
        UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, localStringBuilder.toString());
      }
      return new UFTFtnFileUploader(paramAppRuntime, paramFtnMoreUrlFUperPropV1);
    }
    UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, "app|prop is null");
    return null;
  }
  
  private void a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    this.f = true;
    l();
    i();
    a(true, paramInt, paramLong, paramString1, paramString2, null);
  }
  
  private void b(long paramLong)
  {
    Object localObject = c(paramLong);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("] getSendStreamSlice return null");
      UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, ((StringBuilder)localObject).toString());
      UFTLogicThread.a().a(new UFTFtnFileUploader.1(this));
      return;
    }
    if (!this.q.a(this.e, paramLong, (byte[])localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("] upload file data fail");
      UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, ((StringBuilder)localObject).toString());
      UFTLogicThread.a().a(new UFTFtnFileUploader.2(this));
    }
  }
  
  private void b(long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RangSizeError_rangError tSize[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]<=mSize[");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append("], lastRoolbackSize[");
    ((StringBuilder)localObject).append(this.r);
    ((StringBuilder)localObject).append("], retry[");
    ((StringBuilder)localObject).append(this.s);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    if (paramLong <= this.r)
    {
      int m = this.s + 1;
      this.s = m;
      if (m > 6)
      {
        a(9009, paramLong, (String)localObject, paramString);
        return;
      }
    }
    this.r = paramLong;
    this.g = paramLong;
    UFTLogicThread.a().a(new UFTFtnFileUploader.3(this), 6000L);
    a(paramLong, (String)localObject, paramString);
  }
  
  private void b(boolean paramBoolean)
  {
    this.f = true;
    l();
    a(paramBoolean, null);
  }
  
  private byte[] c(long paramLong)
  {
    if (paramLong == 0L) {}
    try
    {
      if (!k())
      {
        return null;
        long l = this.i;
        if (paramLong > l)
        {
          try
          {
            this.h.skip(paramLong - this.i);
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
            return null;
          }
        }
        else if (paramLong < this.i)
        {
          boolean bool = k();
          if (!bool) {
            return null;
          }
          try
          {
            this.h.skip(paramLong);
          }
          catch (IOException localIOException2)
          {
            this.h = null;
            localIOException2.printStackTrace();
            return null;
          }
        }
      }
      this.i = paramLong;
      int m = this.p.a(this.g, this.c);
      byte[] arrayOfByte = new byte[m];
      try
      {
        this.h.read(arrayOfByte, 0, m);
        this.i += m;
        return arrayOfByte;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Id[");
        localStringBuilder.append(this.a);
        localStringBuilder.append("] getSendStreamSlice exception:");
        localStringBuilder.append(localException1.toString());
        UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, localStringBuilder.toString());
        return null;
      }
      return null;
    }
    catch (Exception localException2) {}
  }
  
  private void i()
  {
    IUFTFtnUploader localIUFTFtnUploader = this.q;
    if (localIUFTFtnUploader != null) {
      localIUFTFtnUploader.a();
    }
  }
  
  private boolean k()
  {
    InputStream localInputStream = this.h;
    if (localInputStream != null)
    {
      try
      {
        localInputStream.close();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      this.h = null;
    }
    try
    {
      this.h = new FileInputStream(this.b);
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      this.h = null;
      localFileNotFoundException.printStackTrace();
    }
    return false;
  }
  
  private void l()
  {
    InputStream localInputStream = this.h;
    if (localInputStream != null) {}
    try
    {
      localInputStream.close();
      label13:
      this.h = null;
      return;
    }
    catch (Exception localException)
    {
      break label13;
    }
  }
  
  public void a()
  {
    a(true);
    l();
    i();
    this.f = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("] cancel");
    UFTLog.b("[UFTTransfer] UFTFtnFileUploader", 1, localStringBuilder.toString());
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.f) {
      return;
    }
    a(9343, this.g, "parseDataErr", null);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.f) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("] onUploadErr.errcode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString1);
    UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, localStringBuilder.toString());
    if (!UFTDependFeatureApi.c())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Id[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("] onUploadErr. no network");
      UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, localStringBuilder.toString());
      a(9004, this.g, paramString1, paramString2);
      return;
    }
    if (-9527 == paramInt)
    {
      if (paramString1.indexOf("-29602") > 0)
      {
        a(-29602, this.g, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-6101") > 0)
      {
        a(9042, this.g, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-29120") > 0)
      {
        dx_();
        return;
      }
      if ((paramString1.indexOf("-38006") > 0) || (paramString1.indexOf("-38007") > 0) || (paramString1.indexOf("-38020") > 0))
      {
        a(paramInt, this.g, paramString1, paramString2);
        return;
      }
    }
    if ((paramString1 != null) && (paramString1.contains("SSLPeerUnverifiedException")))
    {
      a(paramInt, this.g, paramString1, paramString2);
      return;
    }
    if (this.d.b(this.e, paramInt, false))
    {
      a(false, paramInt, this.g, paramString1, paramString2, null);
      return;
    }
    a(paramInt, this.g, paramString1, paramString2);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.f) {
      return;
    }
    this.p.a();
    if (this.k)
    {
      this.k = false;
      if (paramLong == this.o) {
        this.j = 0L;
      } else {
        this.j = paramLong;
      }
    }
    long l = this.g;
    if (paramLong <= l)
    {
      b(paramLong, paramString);
      return;
    }
    if (l == 0L)
    {
      l = this.c;
      if (paramLong == l)
      {
        this.j = 0L;
        this.g = l;
        this.t = true;
        b(true);
        return;
      }
    }
    this.g = paramLong;
    if (UFTLog.a())
    {
      paramString = new StringBuilder();
      paramString.append("send http data size[");
      paramString.append(String.valueOf(this.g));
      paramString.append("] fileSize[");
      paramString.append(this.c);
      paramString.append("] success!");
      UFTLog.b("[UFTTransfer] UFTFtnFileUploader", 4, paramString.toString());
    }
    if (paramLong < this.c)
    {
      a(paramLong, this.j, 0L);
      this.d.a(this.e);
      b(this.g);
      return;
    }
    b(false);
  }
  
  public void a(IUFTFileUploaderCallback paramIUFTFileUploaderCallback)
  {
    b(paramIUFTFileUploaderCallback);
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = false;
    a(false);
    if (this.q == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("]uploadFile fail. uploader is null");
      UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("id[");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("]uploadFile url:");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(" pos:");
    ((StringBuilder)localObject).append(paramLong);
    UFTLog.b("[UFTTransfer] UFTFtnFileUploader", 1, ((StringBuilder)localObject).toString());
    this.k = true;
    this.t = false;
    this.f = false;
    localObject = c(paramLong);
    if (localObject != null) {
      bool = this.q.a(this.e, paramLong, (byte[])localObject);
    }
    if (bool)
    {
      long l = this.i;
      if (l > paramLong)
      {
        this.o = (l - paramLong);
        break label213;
      }
    }
    this.o = 0L;
    label213:
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("]uploadFile return fail");
      UFTLog.d("[UFTTransfer] UFTFtnFileUploader", 1, ((StringBuilder)localObject).toString());
      this.f = true;
    }
    return bool;
  }
  
  public int b()
  {
    return this.d.b();
  }
  
  public void c(String paramString)
  {
    if (this.f) {
      return;
    }
    if (!paramString.equals(this.e)) {
      a(paramString);
    }
    this.e = paramString;
    this.p = new UFTSscm();
    this.g = 0L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("] onRetry. url:");
    localStringBuilder.append(paramString);
    UFTLog.b("[UFTTransfer] UFTFtnFileUploader", 1, localStringBuilder.toString());
    b(this.e);
    b(0L);
  }
  
  public boolean c()
  {
    return this.d.c();
  }
  
  public String d()
  {
    return this.e;
  }
  
  public long e()
  {
    return this.g;
  }
  
  public long f()
  {
    return this.j;
  }
  
  public void g()
  {
    if (this.f) {
      return;
    }
    long l = this.c;
    this.g = l;
    if (this.k)
    {
      this.k = false;
      this.j = l;
      this.t = true;
    }
    b(this.t);
  }
  
  public long h()
  {
    return 6000L;
  }
  
  public boolean j()
  {
    return this.f;
  }
  
  public void r_(String paramString)
  {
    if (this.f) {
      return;
    }
    a(9062, this.g, "UrlOver", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFtnFileUploader
 * JD-Core Version:    0.7.0.1
 */