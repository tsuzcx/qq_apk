package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloader;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.UDConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloaderGen
  extends UniformDownloaderAssinfo
  implements IUniformDownloader
{
  public static String a = "UniformDownloaderGen";
  long p = 0L;
  private IUniformDownloaderListener q;
  private UniformDownloaderGenWorker r = null;
  private Object s = new Object();
  
  public UniformDownloaderGen(long paramLong)
  {
    super(paramLong);
  }
  
  private void a(UniformDownloaderGenWorker paramUniformDownloaderGenWorker)
  {
    synchronized (this.s)
    {
      this.r = paramUniformDownloaderGenWorker;
      return;
    }
  }
  
  private boolean a(long paramLong)
  {
    UniformDownloaderGenWorker localUniformDownloaderGenWorker = k();
    if (localUniformDownloaderGenWorker != null)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] runWorker. before worker be stoped");
      QLog.w(str, 1, localStringBuilder.toString());
      localUniformDownloaderGenWorker.a();
    }
    if (UniformDownloadMgr.a().b() == null) {
      return false;
    }
    localUniformDownloaderGenWorker = new UniformDownloaderGenWorker(this.h, UniformDownloadMgr.a().b(), this.c, this.e, this.i, new UniformDownloaderGen.1(this));
    a(localUniformDownloaderGenWorker);
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.h);
    localStringBuilder.append("] runWorker. start ,mTempStrFilePath=");
    localStringBuilder.append(this.g);
    QLog.i(str, 1, localStringBuilder.toString());
    return localUniformDownloaderGenWorker.a(this.g, paramLong);
  }
  
  private void j()
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.h);
    localStringBuilder.append("] killWoker. ");
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = k();
    if (localObject != null)
    {
      ((UniformDownloaderGenWorker)localObject).a();
      a(null);
      return;
    }
    localObject = a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.h);
    localStringBuilder.append("] killWoker. not worker");
    QLog.i((String)localObject, 1, localStringBuilder.toString());
  }
  
  private UniformDownloaderGenWorker k()
  {
    synchronized (this.s)
    {
      UniformDownloaderGenWorker localUniformDownloaderGenWorker = this.r;
      return localUniformDownloaderGenWorker;
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
      long l2 = this.p;
      long l3 = 1;
      QQFileManagerUtil.a((BaseQQAppInterface)localObject, l1, "actFileUfGenDownload", l2, "", "", "", "", l3, str, 0L, h() * this.e, this.e, this.c, "", 0, str, null);
      QQFileManagerUtil.a((BaseQQAppInterface)localObject, this.h, "actFileUfGenDownloadDetail", this.p, "", "", "", "", l3, str, 0L, h() * this.e, this.e, this.c, "", 0, str, null);
      return;
    }
    str = a;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL][");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append("].report failed - 9");
    QLog.w(str, 1, ((StringBuilder)localObject).toString());
  }
  
  public int a()
  {
    this.p = System.currentTimeMillis();
    Object localObject1 = UniformDownloadMgr.a().b();
    boolean bool = i();
    int i = 1;
    Object localObject3;
    if (!bool)
    {
      localObject1 = a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[UniformDL][");
      ((StringBuilder)localObject3).append(this.h);
      ((StringBuilder)localObject3).append("] start. not inited");
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      l();
      localObject1 = this.q;
      if (localObject1 != null) {
        ((IUniformDownloaderListener)localObject1).a(1, UDConstants.a(1), null);
      }
      return -1;
    }
    StringBuilder localStringBuilder;
    long l3;
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject3 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] start. but net is broken. failed drictly");
      QLog.e((String)localObject3, 1, localStringBuilder.toString());
      j();
      c(5);
      localObject3 = UDConstants.a(5);
      if (localObject1 != null)
      {
        localObject1 = (BaseQQAppInterface)localObject1;
        l1 = this.h;
        l2 = this.p;
        l3 = 5;
        QQFileManagerUtil.a((BaseQQAppInterface)localObject1, l1, "actFileUfGenDownload", l2, "", "", "", "", l3, (String)localObject3, 0L, h() * this.e, this.e, this.c, "", 0, (String)localObject3, null);
        QQFileManagerUtil.a((BaseQQAppInterface)localObject1, this.h, "actFileUfGenDownloadDetail", this.p, "", "", "", "", l3, (String)localObject3, 0L, h() * this.e, this.e, this.c, "", 0, (String)localObject3, null);
      }
      else
      {
        localObject1 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[UniformDL][");
        ((StringBuilder)localObject3).append(this.h);
        ((StringBuilder)localObject3).append("].report failed - 11");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      }
      localObject1 = this.q;
      if (localObject1 != null) {
        ((IUniformDownloaderListener)localObject1).a(5, "net broken", null);
      }
      return -2;
    }
    int j = e();
    if (2 == j)
    {
      localObject1 = a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[UniformDL][");
      ((StringBuilder)localObject3).append(this.h);
      ((StringBuilder)localObject3).append("] start. is runing");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      return 0;
    }
    if ((1 != j) && (6 != j) && (8 != j))
    {
      localObject1 = a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[UniformDL][");
      ((StringBuilder)localObject3).append(this.h);
      ((StringBuilder)localObject3).append("] start. before status is error:");
      ((StringBuilder)localObject3).append(j);
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      return -1;
    }
    long l2 = QQFileManagerUtil.m(this.g);
    if (l2 > this.e) {
      a(0);
    } else {
      a((int)(l2 / this.e));
    }
    long l1 = 0L;
    if (SystemUtil.a()) {
      l1 = SystemUtil.b() * 1024L;
    }
    if (l1 < this.e - l2)
    {
      localObject3 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] start. sd card space is no enough:[");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" ");
      localStringBuilder.append(l2);
      localStringBuilder.append(" ");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.e((String)localObject3, 1, localStringBuilder.toString());
      j();
      c(5);
      if (localObject1 != null)
      {
        localObject3 = UDConstants.a(9);
        localObject1 = (BaseQQAppInterface)localObject1;
        l1 = this.h;
        l3 = this.p;
        long l4 = 9;
        QQFileManagerUtil.a((BaseQQAppInterface)localObject1, l1, "actFileUfGenDownload", l3, "", "", "", "", l4, (String)localObject3, 0L, l2, this.e, this.c, "", 0, (String)localObject3, null);
        QQFileManagerUtil.a((BaseQQAppInterface)localObject1, this.h, "actFileUfGenDownloadDetail", this.p, "", "", "", "", l4, (String)localObject3, 0L, l2, this.e, this.c, "", 0, (String)localObject3, null);
      }
      else
      {
        localObject1 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[UniformDL][");
        ((StringBuilder)localObject3).append(this.h);
        ((StringBuilder)localObject3).append("].report failed - 5");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      }
      localObject1 = this.q;
      if (localObject1 != null) {
        ((IUniformDownloaderListener)localObject1).a(9, "no space", null);
      }
      return -2;
    }
    try
    {
      a(l2);
      localObject1 = a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[UniformDL][");
      ((StringBuilder)localObject3).append(this.h);
      ((StringBuilder)localObject3).append("] start. ST:");
      ((StringBuilder)localObject3).append(j);
      ((StringBuilder)localObject3).append(" PGR:");
      ((StringBuilder)localObject3).append(h());
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      if (1 != j) {
        i = 0;
      }
      c(2);
      if (i != 0)
      {
        localObject1 = this.q;
        if (localObject1 != null) {
          ((IUniformDownloaderListener)localObject1).a(h(), null);
        }
      }
      return 0;
    }
    finally {}
  }
  
  public int a(IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    this.q = paramIUniformDownloaderListener;
    return 0;
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    super.a(paramString, paramBundle);
    paramBundle = UniformDownloadBPTrans.a().b(paramString);
    StringBuilder localStringBuilder;
    if (paramBundle != null)
    {
      paramString = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] >>>init. HAPPY.have a BreakpointTransInfo,tempPath:");
      localStringBuilder.append(paramBundle.c);
      QLog.i(paramString, 1, localStringBuilder.toString());
      if (QQFileManagerUtil.v(paramBundle.c))
      {
        this.g = paramBundle.c;
      }
      else
      {
        paramString = a;
        paramBundle = new StringBuilder();
        paramBundle.append("[UniformDL][");
        paramBundle.append(this.h);
        paramBundle.append("] >>>init. no exsit");
        QLog.e(paramString, 1, paramBundle.toString());
      }
    }
    else
    {
      paramBundle = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] >>>init. NO HAPPY. Not BreakpointTransInfo,add it:");
      QLog.i(paramBundle, 1, localStringBuilder.toString());
      UniformDownloadBPTrans.a().a(paramString, null, this.e, this.g, this.f);
    }
    return 0;
  }
  
  public int b()
  {
    String str;
    StringBuilder localStringBuilder;
    if (!i())
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] stop. not inited");
      QLog.e(str, 1, localStringBuilder.toString());
      return -1;
    }
    try
    {
      j();
      int i = e();
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] stop. ST:");
      localStringBuilder.append(i);
      localStringBuilder.append(" PGR:");
      localStringBuilder.append(h());
      QLog.i(str, 1, localStringBuilder.toString());
      b(0);
      c(7);
      return 0;
    }
    finally {}
  }
  
  public int c()
  {
    Object localObject1;
    if (!i())
    {
      localObject1 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] pause. not inited");
      QLog.e((String)localObject1, 1, localStringBuilder.toString());
      l();
      localObject1 = this.q;
      if (localObject1 != null) {
        ((IUniformDownloaderListener)localObject1).a(1, UDConstants.a(1), null);
      }
      return -1;
    }
    int i = e();
    if ((3 != i) && (7 != i)) {
      try
      {
        j();
        localObject1 = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL][");
        localStringBuilder.append(this.h);
        localStringBuilder.append("] pause. ST:");
        localStringBuilder.append(i);
        localStringBuilder.append(" PGR:");
        localStringBuilder.append(h());
        QLog.i((String)localObject1, 1, localStringBuilder.toString());
        c(3);
        localObject1 = this.q;
        if (localObject1 != null) {
          ((IUniformDownloaderListener)localObject1).c(h(), null);
        }
        return 0;
      }
      finally {}
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.h);
    localStringBuilder.append("] pause. had be paused");
    QLog.w(str, 1, localStringBuilder.toString());
    return 0;
  }
  
  public int d()
  {
    if (!i())
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] resume. not inited");
      QLog.e((String)localObject, 1, localStringBuilder.toString());
      l();
      localObject = this.q;
      if (localObject != null) {
        ((IUniformDownloaderListener)localObject).a(1, UDConstants.a(1), null);
      }
      return -1;
    }
    int i = e();
    if ((6 != i) && (2 != i) && (4 != i))
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.h);
      localStringBuilder.append("] resume. ST:");
      localStringBuilder.append(i);
      localStringBuilder.append(" PGR:");
      localStringBuilder.append(h());
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      c(6);
      localObject = this.q;
      if (localObject != null) {
        ((IUniformDownloaderListener)localObject).d(h(), null);
      }
      return 0;
    }
    Object localObject = a;
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
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.h);
    localStringBuilder.append("] resume. ST:");
    localStringBuilder.append(e());
    localStringBuilder.append(" PGR:");
    localStringBuilder.append(h());
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    c(8);
    localObject = k();
    if (localObject != null) {
      ((UniformDownloaderGenWorker)localObject).b();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderGen
 * JD-Core Version:    0.7.0.1
 */