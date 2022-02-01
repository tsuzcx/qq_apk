package com.tencent.mobileqq.uftransfer.common.transfer.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileDownloader;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTTransferUtil;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTTransferUtil.HostInfo;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.IUFTRetryCallback;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTUrlProvider;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.util.SystemUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UFTFtnFileDownloader
  extends UFTFileDownloaderCbWrapper
  implements IUFTFileDownloader, IUFTFtnDownloaderCallback, IUFTRetryCallback
{
  protected final long a;
  protected String b;
  protected String c;
  protected int d;
  protected int e;
  protected boolean f;
  protected String g;
  protected long h;
  protected long m;
  protected UFTFtnDownloader n;
  protected FileOutputStream o;
  protected long p;
  private final UFTUrlProvider q;
  private boolean r;
  
  private boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.equals("-441")) || (paramString.equals("-443")) || (paramString.equals("-447")) || (paramString.equals("-29224")) || (paramString.equals("-31717")));
  }
  
  private boolean e(String paramString)
  {
    return (paramString.indexOf("-29120") > 0) || (paramString.indexOf("-502") > 0) || (paramString.indexOf("HTTP_PROXY_AUTH") > 0) || (paramString.indexOf("-21122") > 0) || (paramString.indexOf("-28123") > 0) || (paramString.indexOf("-25081") > 0) || (paramString.indexOf("-28126") > 0);
  }
  
  private boolean f(String paramString)
  {
    return (paramString.indexOf("-6101") > 0) || (paramString.indexOf("-7003") > 0) || (paramString.indexOf("-403") > 0) || (paramString.indexOf("-9006") > 0) || (paramString.indexOf("-9004") > 0) || (paramString.indexOf("-9017") > 0) || (paramString.indexOf("-29150") > 0) || (paramString.indexOf("-28137") > 0);
  }
  
  private long i()
  {
    long l;
    if (SystemUtil.a()) {
      l = SystemUtil.b();
    } else {
      l = SystemUtil.c();
    }
    return l * 1024L;
  }
  
  private void j()
  {
    if (this.f) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("] reDownload mstrUrl:");
    localStringBuilder.append(this.b);
    UFTLog.b("[UFTTransfer] UFTFtnFileDownloader", 1, localStringBuilder.toString());
    g();
    b(this.b);
    this.m = new File(this.g).length();
    if (!UFTDependFeatureApi.c())
    {
      a(true, 9004, this.m, "no net work", "", null);
      return;
    }
    if (!c()) {
      a(true, 9049, this.m, "download filedata fail", "", null);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.f) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("] onDownloadErr.errcode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" rspHeader:");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    UFTLog.d("[UFTTransfer] UFTFtnFileDownloader", 1, (String)localObject);
    if (!UFTDependFeatureApi.c())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Id[");
      paramBundle.append(this.a);
      paramBundle.append("] onDownloadErr. no network");
      UFTLog.d("[UFTTransfer] UFTFtnFileDownloader", 1, paramBundle.toString());
      a(true, 9004, this.m, paramString1, paramString2, null);
      return;
    }
    if (paramString1.indexOf("-29602") > 0)
    {
      a(true, -29602, this.m, paramString1, paramString2, null);
      return;
    }
    if (paramBundle != null) {
      paramBundle = paramBundle.getString("User-ReturnCode");
    } else {
      paramBundle = "";
    }
    if (d(paramBundle))
    {
      a(true, -5003, this.m, paramString1, paramString2, null);
      return;
    }
    if (f(paramString1))
    {
      a(true, 9042, this.m, paramString1, paramString2, null);
      return;
    }
    if (("content zero".equalsIgnoreCase(paramString1)) && (paramString2 != null) && (paramString2.indexOf("-31713") > 0))
    {
      a(true, 9042, this.m, paramString1, paramString2, null);
      return;
    }
    if (paramString1.contains("SSLPeerUnverifiedException"))
    {
      a(true, paramInt, this.m, paramString1, paramString2, null);
      return;
    }
    if (e(paramString1)) {
      paramInt = 9042;
    } else {
      bool = false;
    }
    this.r = false;
    if (this.q.b(this.b, paramInt, bool))
    {
      a(false, paramInt, this.m, paramString1, paramString2, null);
      return;
    }
    a(true, paramInt, this.m, paramString1, paramString2, null);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, String paramString)
  {
    if (this.f) {
      return;
    }
    if ((this.h == 0L) && (paramLong != 0L))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("] onData getted filesize=");
      localStringBuilder.append(paramLong);
      UFTLog.b("[UFTTransfer] UFTFtnFileDownloader", 1, localStringBuilder.toString());
      this.h = paramLong;
    }
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return;
      }
      try
      {
        this.o.write(paramArrayOfByte);
        paramLong = paramArrayOfByte.length;
        this.m += paramLong;
        this.p += paramLong;
        if (!this.r)
        {
          this.r = true;
          this.q.a(this.b);
        }
        paramLong = this.m;
        long l = this.h;
        if (paramLong == l)
        {
          a(this.g, null);
          return;
        }
        if (paramLong > l)
        {
          a(true, -5001, paramLong, "transfersize > filesize", paramString, null);
          return;
        }
        a(paramLong, l);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.getMessage().contains("ENOSPC");
        a(true, 9301, this.m, "write exception", paramString, null);
      }
    }
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  protected boolean b()
  {
    Object localObject = new File(this.g);
    if (!((File)localObject).exists()) {}
    try
    {
      ((File)localObject).createNewFile();
    }
    catch (IOException localIOException1)
    {
      label30:
      long l1;
      long l2;
      break label30;
    }
    a(true, -5000, this.m, "create new file excption", null, null);
    return true;
    this.m = ((File)localObject).length();
    l1 = this.h;
    if (l1 == 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("] checkexcpover fileSize=0");
      UFTLog.c("[UFTTransfer] UFTFtnFileDownloader", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    l2 = this.m;
    if (l2 > l1) {
      ((File)localObject).delete();
    }
    try
    {
      ((File)localObject).createNewFile();
      this.m = 0L;
      return false;
    }
    catch (IOException localIOException2)
    {
      label148:
      break label148;
    }
    a(true, -5000, this.m, "create new file excption", null, null);
    return true;
    if (l2 == l1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("] checkexcpover tmpfilesize=filesize");
      UFTLog.b("[UFTTransfer] UFTFtnFileDownloader", 1, ((StringBuilder)localObject).toString());
      a(this.g, null);
      return true;
    }
    if (i() < l1 - l2)
    {
      a(true, 9040, this.m, "no enugh space", null, null);
      return true;
    }
    return false;
  }
  
  public void c(String paramString)
  {
    if (this.f)
    {
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.a);
      paramString.append("] onRetry but stoped");
      UFTLog.b("[UFTTransfer] UFTFtnFileDownloader", 1, paramString.toString());
      return;
    }
    int i = 0;
    if (!this.b.equalsIgnoreCase(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("] onRetry urlChanged");
      UFTLog.b("[UFTTransfer] UFTFtnFileDownloader", 1, localStringBuilder.toString());
      i = 1;
    }
    this.b = paramString;
    if (i != 0)
    {
      paramString = UFTTransferUtil.a(this.b);
      if (paramString != null)
      {
        this.c = paramString.a;
        this.d = paramString.b;
        this.e = paramString.c;
      }
      a(this.b);
    }
    j();
  }
  
  protected boolean c()
  {
    d();
    return this.n.a(this.b, this.m);
  }
  
  protected void d()
  {
    this.n.a();
  }
  
  protected boolean e()
  {
    f();
    try
    {
      this.o = new FileOutputStream(this.g, true);
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("] openOutputStream excp");
      UFTLog.d("[UFTTransfer] UFTFtnFileDownloader", 1, localStringBuilder.toString());
      this.o = null;
      localFileNotFoundException.printStackTrace();
    }
    return false;
  }
  
  protected void f()
  {
    FileOutputStream localFileOutputStream = this.o;
    if (localFileOutputStream != null)
    {
      try
      {
        localFileOutputStream.close();
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.a);
        localStringBuilder.append("] closeOutputStream excp");
        UFTLog.d("[UFTTransfer] UFTFtnFileDownloader", 1, localStringBuilder.toString());
        localIOException.printStackTrace();
      }
      this.o = null;
    }
  }
  
  protected void g()
  {
    FileOutputStream localFileOutputStream = this.o;
    if (localFileOutputStream != null) {
      try
      {
        localFileOutputStream.flush();
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.a);
        localStringBuilder.append("] flushOutputStream excp");
        UFTLog.d("[UFTTransfer] UFTFtnFileDownloader", 1, localStringBuilder.toString());
        localIOException.printStackTrace();
      }
    }
    this.p = 0L;
  }
  
  public long h()
  {
    return 6000L;
  }
  
  public void q_(String paramString)
  {
    if (this.f) {
      return;
    }
    a(true, 9062, this.m, "net redirect", "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.download.UFTFtnFileDownloader
 * JD-Core Version:    0.7.0.1
 */