package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.filemanager.FileManagerUtil;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloader;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.UDConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class UniformDownloaderGen
  extends UniformDownloaderAssinfo
  implements IUniformDownloader
{
  public static String g = "UniformDownloaderGen";
  long jdField_a_of_type_Long = 0L;
  private UniformDownloaderGenWorker jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderGenWorker = null;
  private IUniformDownloaderListener jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
  private Object d;
  
  public UniformDownloaderGen(long paramLong)
  {
    super(paramLong);
    this.jdField_d_of_type_JavaLangObject = new Object();
  }
  
  private UniformDownloaderGenWorker a()
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      UniformDownloaderGenWorker localUniformDownloaderGenWorker = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderGenWorker;
      return localUniformDownloaderGenWorker;
    }
  }
  
  private void a()
  {
    QLog.i(g, 1, "[UniformDL][" + this.c + "] killWoker. ");
    UniformDownloaderGenWorker localUniformDownloaderGenWorker = a();
    if (localUniformDownloaderGenWorker != null)
    {
      localUniformDownloaderGenWorker.a();
      a(null);
      return;
    }
    QLog.i(g, 1, "[UniformDL][" + this.c + "] killWoker. not worker");
  }
  
  private void a(UniformDownloaderGenWorker paramUniformDownloaderGenWorker)
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderGenWorker = paramUniformDownloaderGenWorker;
      return;
    }
  }
  
  private boolean a(long paramLong)
  {
    UniformDownloaderGenWorker localUniformDownloaderGenWorker = a();
    if (localUniformDownloaderGenWorker != null)
    {
      QLog.w(g, 1, "[UniformDL][" + this.c + "] runWorker. before worker be stoped");
      localUniformDownloaderGenWorker.a();
    }
    if (UniformDownloadMgr.a().a() == null) {
      return false;
    }
    localUniformDownloaderGenWorker = new UniformDownloaderGenWorker(this.c, UniformDownloadMgr.a().a(), this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long, this.f, new UniformDownloaderGen.1(this));
    a(localUniformDownloaderGenWorker);
    QLog.i(g, 1, "[UniformDL][" + this.c + "] runWorker. start ,mTempStrFilePath=" + this.e);
    return localUniformDownloaderGenWorker.a(this.e, paramLong);
  }
  
  private void b()
  {
    String str = UDConstants.a(1);
    AppRuntime localAppRuntime = UniformDownloadMgr.a().a();
    if (localAppRuntime != null)
    {
      FileManagerUtil.a(localAppRuntime, this.c, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 1, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
      FileManagerUtil.a(localAppRuntime, this.c, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 1, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
      return;
    }
    QLog.w(g, 1, "[UniformDL][" + this.c + "].report failed - 9");
  }
  
  public int a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    AppRuntime localAppRuntime = UniformDownloadMgr.a().a();
    if (!a())
    {
      QLog.e(g, 1, "[UniformDL][" + this.c + "] start. not inited");
      b();
      if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener.a(1, UDConstants.a(1), null);
      }
      return -1;
    }
    String str;
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QLog.e(g, 1, "[UniformDL][" + this.c + "] start. but net is broken. failed drictly");
      a();
      c(5);
      str = UDConstants.a(5);
      if (localAppRuntime != null)
      {
        FileManagerUtil.a(localAppRuntime, this.c, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 5, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
        FileManagerUtil.a(localAppRuntime, this.c, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 5, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener.a(5, "net broken", null);
        }
        return -2;
        QLog.w(g, 1, "[UniformDL][" + this.c + "].report failed - 11");
      }
    }
    int i = e();
    if (2 == i)
    {
      QLog.w(g, 1, "[UniformDL][" + this.c + "] start. is runing");
      return 0;
    }
    if ((1 != i) && (6 != i) && (8 != i))
    {
      QLog.e(g, 1, "[UniformDL][" + this.c + "] start. before status is error:" + i);
      return -1;
    }
    long l2 = FileManagerUtil.a(this.e);
    if (l2 > this.jdField_b_of_type_Long)
    {
      a(0);
      long l1 = 0L;
      if (SystemUtil.a()) {
        l1 = SystemUtil.a() * 1024L;
      }
      if (l1 >= this.jdField_b_of_type_Long - l2) {
        break label718;
      }
      QLog.e(g, 1, "[UniformDL][" + this.c + "] start. sd card space is no enough:[" + this.jdField_b_of_type_Long + " " + l2 + " " + l1 + "]");
      a();
      c(5);
      if (localAppRuntime == null) {
        break label681;
      }
      str = UDConstants.a(9);
      FileManagerUtil.a(localAppRuntime, this.c, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 9, str, 0L, l2, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
      FileManagerUtil.a(localAppRuntime, this.c, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 9, str, 0L, l2, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener.a(9, "no space", null);
      }
      return -2;
      a((int)(l2 / this.jdField_b_of_type_Long));
      break;
      label681:
      QLog.w(g, 1, "[UniformDL][" + this.c + "].report failed - 5");
    }
    for (;;)
    {
      try
      {
        label718:
        a(l2);
        QLog.i(g, 1, "[UniformDL][" + this.c + "] start. ST:" + i + " PGR:" + h());
        if (1 == i)
        {
          i = 1;
          c(2);
          if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener != null)) {
            this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener.a(h(), null);
          }
          return 0;
        }
      }
      finally {}
      i = 0;
    }
  }
  
  public int a(IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener = paramIUniformDownloaderListener;
    return 0;
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    super.a(paramString, paramBundle);
    paramBundle = UniformDownloadBPTrans.a().a(paramString);
    if (paramBundle != null)
    {
      QLog.i(g, 1, "[UniformDL][" + this.c + "] >>>init. HAPPY.have a BreakpointTransInfo,tempPath:" + paramBundle.jdField_b_of_type_JavaLangString);
      if (FileManagerUtil.a(paramBundle.jdField_b_of_type_JavaLangString)) {
        this.e = paramBundle.jdField_b_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      return 0;
      QLog.e(g, 1, "[UniformDL][" + this.c + "] >>>init. no exsit");
      continue;
      QLog.i(g, 1, "[UniformDL][" + this.c + "] >>>init. NO HAPPY. Not BreakpointTransInfo,add it:");
      UniformDownloadBPTrans.a().a(paramString, null, this.jdField_b_of_type_Long, this.e, this.jdField_d_of_type_JavaLangString);
    }
  }
  
  public int b()
  {
    if (!a())
    {
      QLog.e(g, 1, "[UniformDL][" + this.c + "] stop. not inited");
      return -1;
    }
    try
    {
      a();
      int i = e();
      QLog.i(g, 1, "[UniformDL][" + this.c + "] stop. ST:" + i + " PGR:" + h());
      b(0);
      c(7);
      return 0;
    }
    finally {}
  }
  
  public int c()
  {
    int i = 0;
    if (!a())
    {
      QLog.e(g, 1, "[UniformDL][" + this.c + "] pause. not inited");
      b();
      if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener.a(1, UDConstants.a(1), null);
      }
      i = -1;
    }
    for (;;)
    {
      return i;
      int j = e();
      if ((3 == j) || (7 == j))
      {
        QLog.w(g, 1, "[UniformDL][" + this.c + "] pause. had be paused");
        return 0;
      }
      try
      {
        a();
        QLog.i(g, 1, "[UniformDL][" + this.c + "] pause. ST:" + j + " PGR:" + h());
        c(3);
        if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener.c(h(), null);
        return 0;
      }
      finally {}
    }
  }
  
  public int d()
  {
    int i = 0;
    if (!a())
    {
      QLog.e(g, 1, "[UniformDL][" + this.c + "] resume. not inited");
      b();
      if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener.a(1, UDConstants.a(1), null);
      }
      i = -1;
    }
    do
    {
      return i;
      int j = e();
      if ((6 == j) || (2 == j) || (4 == j))
      {
        QLog.w(g, 1, "[UniformDL][" + this.c + "] resume. had be resumed");
        return 0;
      }
      QLog.i(g, 1, "[UniformDL][" + this.c + "] resume. ST:" + j + " PGR:" + h());
      c(6);
    } while (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener == null);
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener.d(h(), null);
    return 0;
  }
  
  public int e()
  {
    return super.e();
  }
  
  public int f()
  {
    QLog.i(g, 1, "[UniformDL][" + this.c + "] resume. ST:" + e() + " PGR:" + h());
    c(8);
    UniformDownloaderGenWorker localUniformDownloaderGenWorker = a();
    if (localUniformDownloaderGenWorker != null) {
      localUniformDownloaderGenWorker.b();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderGen
 * JD-Core Version:    0.7.0.1
 */