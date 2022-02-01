package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloader;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.UDConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloaderAppBaby
  extends UniformDownloaderAssinfo
  implements IUniformDownloader
{
  long a = 0L;
  private IUniformDownloaderListener p;
  private boolean q = false;
  private Object r = new Object();
  
  public UniformDownloaderAppBaby(long paramLong)
  {
    super(paramLong);
  }
  
  private void a(boolean paramBoolean)
  {
    synchronized (this.r)
    {
      this.q = paramBoolean;
      return;
    }
  }
  
  private int j()
  {
    int i = UniformDownloaderAppBabySdk.a().a(this.h, this.c, this.e, new UniformDownloaderAppBaby.1(this));
    if (i == 0) {
      a(true);
    }
    return i;
  }
  
  private boolean k()
  {
    synchronized (this.r)
    {
      boolean bool = this.q;
      return bool;
    }
  }
  
  private void l()
  {
    String str = UDConstants.a(1);
    Object localObject = UniformDownloadMgr.a().b();
    if (localObject != null)
    {
      localObject = (BaseQQAppInterface)localObject;
      long l1 = this.h;
      long l2 = this.a;
      long l3 = 1;
      QQFileManagerUtil.a((BaseQQAppInterface)localObject, l1, "actFileUfAppBabySdkDownload", l2, "", "", "", "", l3, str, 0L, h() * this.e, this.e, this.c, "", 0, str, null);
      QQFileManagerUtil.a((BaseQQAppInterface)localObject, this.h, "actFileUfAppBabySdkDownloadDetail", this.a, "", "", "", "", l3, str, 0L, h() * this.e, this.e, this.c, "", 0, str, null);
      return;
    }
    str = b;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL][");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append("].report failed - 9");
    QLog.w(str, 1, ((StringBuilder)localObject).toString());
  }
  
  public int a()
  {
    this.a = System.currentTimeMillis();
    Object localObject1 = UniformDownloadMgr.a().b();
    if (!i())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append("] start. not inited");
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      l();
      localObject1 = this.p;
      if (localObject1 != null) {
        ((IUniformDownloaderListener)localObject1).a(1, UDConstants.a(1), null);
      }
      return -1;
    }
    long l1;
    long l2;
    long l3;
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      c(5);
      localObject2 = UDConstants.a(5);
      if (localObject1 != null)
      {
        localObject1 = (BaseQQAppInterface)localObject1;
        l1 = this.h;
        l2 = this.a;
        l3 = 5;
        QQFileManagerUtil.a((BaseQQAppInterface)localObject1, l1, "actFileUfAppBabySdkDownload", l2, "", "", "", "", l3, (String)localObject2, 0L, h() * this.e, this.e, this.c, "", 0, (String)localObject2, null);
        QQFileManagerUtil.a((BaseQQAppInterface)localObject1, this.h, "actFileUfAppBabySdkDownloadDetail", this.a, "", "", "", "", l3, (String)localObject2, 0L, h() * this.e, this.e, this.c, "", 0, (String)localObject2, null);
      }
      else
      {
        localObject1 = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL][");
        localStringBuilder.append(this.h);
        localStringBuilder.append("].report failed - 8");
        QLog.w((String)localObject1, 1, localStringBuilder.toString());
      }
      localObject1 = this.p;
      if (localObject1 != null) {
        ((IUniformDownloaderListener)localObject1).a(5, (String)localObject2, null);
      }
      return -1;
    }
    int i = e();
    if (2 == i)
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append("] start. is runing");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return 0;
    }
    if ((1 != i) && (6 != i))
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append("] start. before status is error:");
      ((StringBuilder)localObject2).append(i);
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return -1;
    }
    a(0);
    if (1 == i)
    {
      localObject2 = b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] start download. AddDownloadToAppBabySdk");
      QLog.i((String)localObject2, 1, localStringBuilder.toString());
      j();
    }
    else if ((6 == i) && (!UniformDownloaderAppBabySdk.a().a(this.c)))
    {
      localObject2 = b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] resume download and start it. sdk is not this download, AddDownloadToAppBabySdk");
      QLog.i((String)localObject2, 1, localStringBuilder.toString());
      j();
    }
    int j = UniformDownloaderAppBabySdk.a().b(this.c);
    if (j == 0)
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append("] start. ST:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" PGR:");
      ((StringBuilder)localObject2).append(h());
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      c(2);
      return j;
    }
    Object localObject2 = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.h);
    localStringBuilder.append("] start failed. ST:");
    localStringBuilder.append(i);
    localStringBuilder.append(" PGR:");
    localStringBuilder.append(h());
    QLog.i((String)localObject2, 1, localStringBuilder.toString());
    c(5);
    localObject2 = UDConstants.a(2);
    if (localObject1 != null)
    {
      localObject1 = (BaseQQAppInterface)localObject1;
      l1 = this.h;
      l2 = this.a;
      l3 = 2;
      QQFileManagerUtil.a((BaseQQAppInterface)localObject1, l1, "actFileUfAppBabySdkDownload", l2, "", "", "", "", l3, (String)localObject2, 0L, h() * this.e, this.e, this.c, "", 0, (String)localObject2, null);
      QQFileManagerUtil.a((BaseQQAppInterface)localObject1, this.h, "actFileUfAppBabySdkDownloadDetail", this.a, "", "", "", "", l3, (String)localObject2, 0L, h() * this.e, this.e, this.c, "", 0, (String)localObject2, null);
    }
    else
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append("].report failed - 8");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    localObject1 = this.p;
    if (localObject1 != null) {
      ((IUniformDownloaderListener)localObject1).a(2, null, null);
    }
    return j;
  }
  
  public int a(IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    this.p = paramIUniformDownloaderListener;
    return 0;
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    return super.a(paramString, paramBundle);
  }
  
  public int b()
  {
    int i = e();
    String str = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.h);
    localStringBuilder.append("] stop. ST:");
    localStringBuilder.append(i);
    localStringBuilder.append(" PGR:");
    localStringBuilder.append(h());
    QLog.i(str, 1, localStringBuilder.toString());
    c(7);
    return UniformDownloaderAppBabySdk.a().d(this.c);
  }
  
  public int c()
  {
    if (!i())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append("] pause. not inited");
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      localObject1 = this.p;
      if (localObject1 != null) {
        ((IUniformDownloaderListener)localObject1).a(1, UDConstants.a(1), null);
      }
      return -1;
    }
    boolean bool = k();
    int i = e();
    if ((1 != i) && (bool))
    {
      if ((3 != i) && (7 != i))
      {
        int j = UniformDownloaderAppBabySdk.a().c(this.c);
        if (j == 0)
        {
          localObject1 = b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[UniformDL][");
          ((StringBuilder)localObject2).append(this.h);
          ((StringBuilder)localObject2).append("] pause. ST:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" PGR:");
          ((StringBuilder)localObject2).append(h());
          QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          c(3);
          return j;
        }
        localObject1 = b;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[UniformDL][");
        ((StringBuilder)localObject2).append(this.h);
        ((StringBuilder)localObject2).append("] pause failed. ST:");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" PGR:");
        ((StringBuilder)localObject2).append(h());
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        c(5);
        localObject1 = UDConstants.a(15);
        localObject2 = UniformDownloadMgr.a().b();
        if (localObject2 != null)
        {
          localObject2 = (BaseQQAppInterface)localObject2;
          long l1 = this.h;
          long l2 = this.a;
          long l3 = 15;
          QQFileManagerUtil.a((BaseQQAppInterface)localObject2, l1, "actFileUfAppBabySdkDownload", l2, "", "", "", "", l3, (String)localObject1, 0L, h() * this.e, this.e, this.c, "", 0, (String)localObject1, null);
          QQFileManagerUtil.a((BaseQQAppInterface)localObject2, this.h, "actFileUfAppBabySdkDownloadDetail", this.a, "", "", "", "", l3, (String)localObject1, 0L, h() * this.e, this.e, this.c, "", 0, (String)localObject1, null);
        }
        else
        {
          localObject1 = b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[UniformDL][");
          ((StringBuilder)localObject2).append(this.h);
          ((StringBuilder)localObject2).append("].report failed - 8");
          QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        localObject1 = this.p;
        if (localObject1 != null) {
          ((IUniformDownloaderListener)localObject1).a(15, null, null);
        }
        return j;
      }
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append("] pause. had be paused");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return 0;
    }
    Object localObject1 = b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL][");
    ((StringBuilder)localObject2).append(this.h);
    ((StringBuilder)localObject2).append("] waiting and pause. ST:");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(" PGR:");
    ((StringBuilder)localObject2).append(h());
    ((StringBuilder)localObject2).append("(inited)");
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    c(3);
    localObject1 = this.p;
    if (localObject1 != null) {
      ((IUniformDownloaderListener)localObject1).c(h(), null);
    }
    return 0;
  }
  
  public int d()
  {
    if (!i())
    {
      localObject = b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] resume. not inited");
      QLog.e((String)localObject, 1, localStringBuilder.toString());
      localObject = this.p;
      if (localObject != null) {
        ((IUniformDownloaderListener)localObject).a(1, UDConstants.a(1), null);
      }
      return -1;
    }
    int i = e();
    if ((6 != i) && (2 != i) && (4 != i))
    {
      localObject = b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] resume. ST:");
      localStringBuilder.append(i);
      localStringBuilder.append(" PGR:");
      localStringBuilder.append(h());
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      c(6);
      localObject = this.p;
      if (localObject != null) {
        ((IUniformDownloaderListener)localObject).d(h(), null);
      }
      return 0;
    }
    Object localObject = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.h);
    localStringBuilder.append("] resume. had be resumed");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    return 0;
  }
  
  public int e()
  {
    return super.e();
  }
  
  public int f()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBaby
 * JD-Core Version:    0.7.0.1
 */