package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.filemanager.FileManagerUtil;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloader;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.UDConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class UniformDownloaderAppBaby
  extends UniformDownloaderAssinfo
  implements IUniformDownloader
{
  long jdField_a_of_type_Long = 0L;
  private IUniformDownloaderListener jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
  private boolean jdField_a_of_type_Boolean = false;
  private Object d = new Object();
  
  public UniformDownloaderAppBaby(long paramLong)
  {
    super(paramLong);
  }
  
  private void a()
  {
    String str = UDConstants.a(1);
    AppRuntime localAppRuntime = UniformDownloadMgr.a().a();
    if (localAppRuntime != null)
    {
      FileManagerUtil.a(localAppRuntime, this.c, "actFileUfAppBabySdkDownload", this.jdField_a_of_type_Long, "", "", "", "", 1, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
      FileManagerUtil.a(localAppRuntime, this.c, "actFileUfAppBabySdkDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 1, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "].report failed - 9");
  }
  
  private void a(boolean paramBoolean)
  {
    synchronized (this.d)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  private boolean b()
  {
    synchronized (this.d)
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
  }
  
  private int i()
  {
    int i = UniformDownloaderAppBabySdk.a().a(this.c, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long, new UniformDownloaderAppBaby.1(this));
    if (i == 0) {
      a(true);
    }
    return i;
  }
  
  public int a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    AppRuntime localAppRuntime = UniformDownloadMgr.a().a();
    if (!a())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] start. not inited");
      a();
      if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener.a(1, UDConstants.a(1), null);
      }
      i = -1;
      return i;
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      c(5);
      str = UDConstants.a(5);
      if (localAppRuntime != null)
      {
        FileManagerUtil.a(localAppRuntime, this.c, "actFileUfAppBabySdkDownload", this.jdField_a_of_type_Long, "", "", "", "", 5, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
        FileManagerUtil.a(localAppRuntime, this.c, "actFileUfAppBabySdkDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 5, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener.a(5, str, null);
        }
        return -1;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "].report failed - 8");
      }
    }
    int i = e();
    if (2 == i)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] start. is runing");
      return 0;
    }
    if ((1 != i) && (6 != i))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] start. before status is error:" + i);
      return -1;
    }
    a(0);
    if (1 == i)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] start download. AddDownloadToAppBabySdk");
      i();
    }
    int j;
    for (;;)
    {
      j = UniformDownloaderAppBabySdk.a().a(this.jdField_b_of_type_JavaLangString);
      if (j != 0) {
        break;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] start. ST:" + i + " PGR:" + h());
      c(2);
      return j;
      if ((6 == i) && (!UniformDownloaderAppBabySdk.a().a(this.jdField_b_of_type_JavaLangString)))
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] resume download and start it. sdk is not this download, AddDownloadToAppBabySdk");
        i();
      }
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] start failed. ST:" + i + " PGR:" + h());
    c(5);
    String str = UDConstants.a(2);
    if (localAppRuntime != null)
    {
      FileManagerUtil.a(localAppRuntime, this.c, "actFileUfAppBabySdkDownload", this.jdField_a_of_type_Long, "", "", "", "", 2, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
      FileManagerUtil.a(localAppRuntime, this.c, "actFileUfAppBabySdkDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 2, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
    }
    for (;;)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener.a(2, null, null);
      return j;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "].report failed - 8");
    }
  }
  
  public int a(IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener = paramIUniformDownloaderListener;
    return 0;
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    return super.a(paramString, paramBundle);
  }
  
  public int b()
  {
    int i = e();
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] stop. ST:" + i + " PGR:" + h());
    c(7);
    return UniformDownloaderAppBabySdk.a().c(this.jdField_b_of_type_JavaLangString);
  }
  
  public int c()
  {
    if (!a())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] pause. not inited");
      if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener.a(1, UDConstants.a(1), null);
      }
      i = -1;
      return i;
    }
    boolean bool = b();
    int i = e();
    if ((1 == i) || (!bool))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] waiting and pause. ST:" + i + " PGR:" + h() + "(inited)");
      c(3);
      if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener.c(h(), null);
      }
      return 0;
    }
    if ((3 == i) || (7 == i))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] pause. had be paused");
      return 0;
    }
    int j = UniformDownloaderAppBabySdk.a().b(this.jdField_b_of_type_JavaLangString);
    if (j == 0)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] pause. ST:" + i + " PGR:" + h());
      c(3);
      return j;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] pause failed. ST:" + i + " PGR:" + h());
    c(5);
    String str = UDConstants.a(15);
    AppRuntime localAppRuntime = UniformDownloadMgr.a().a();
    if (localAppRuntime != null)
    {
      FileManagerUtil.a(localAppRuntime, this.c, "actFileUfAppBabySdkDownload", this.jdField_a_of_type_Long, "", "", "", "", 15, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
      FileManagerUtil.a(localAppRuntime, this.c, "actFileUfAppBabySdkDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 15, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
    }
    for (;;)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener.a(15, null, null);
      return j;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "].report failed - 8");
    }
  }
  
  public int d()
  {
    int i = 0;
    if (!a())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] resume. not inited");
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
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] resume. had be resumed");
        return 0;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.c + "] resume. ST:" + j + " PGR:" + h());
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
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBaby
 * JD-Core Version:    0.7.0.1
 */