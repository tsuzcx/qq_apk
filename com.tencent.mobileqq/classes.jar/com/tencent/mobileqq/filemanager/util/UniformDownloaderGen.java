package com.tencent.mobileqq.filemanager.util;

import adir;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class UniformDownloaderGen
  extends UniformDownloaderAssinfo
  implements UniformDownloader.IUniformDownloader
{
  public static String a;
  public long a;
  private UniformDownloader.IUniformDownloaderListener jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener;
  private UniformDownloaderGenWorker jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderGenWorker;
  private Object d = new Object();
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloaderGen<FileAssistant>";
  }
  
  public UniformDownloaderGen(long paramLong)
  {
    super(paramLong);
    this.jdField_a_of_type_Long = 0L;
  }
  
  private UniformDownloaderGenWorker a()
  {
    synchronized (this.d)
    {
      UniformDownloaderGenWorker localUniformDownloaderGenWorker = this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderGenWorker;
      return localUniformDownloaderGenWorker;
    }
  }
  
  private void a()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] killWoker. ");
    UniformDownloaderGenWorker localUniformDownloaderGenWorker = a();
    if (localUniformDownloaderGenWorker != null)
    {
      localUniformDownloaderGenWorker.a();
      a(null);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] killWoker. not worker");
  }
  
  private void a(UniformDownloaderGenWorker paramUniformDownloaderGenWorker)
  {
    synchronized (this.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderGenWorker = paramUniformDownloaderGenWorker;
      return;
    }
  }
  
  private boolean a(long paramLong)
  {
    UniformDownloaderGenWorker localUniformDownloaderGenWorker = a();
    if (localUniformDownloaderGenWorker != null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] runWorker. before worker be stoped");
      localUniformDownloaderGenWorker.a();
    }
    localUniformDownloaderGenWorker = new UniformDownloaderGenWorker(this.jdField_c_of_type_Long, UniformDownloadMgr.a().a(), this.jdField_c_of_type_JavaLangString, this.b, this.g, new adir(this));
    a(localUniformDownloaderGenWorker);
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] runWorker. start ,mTempStrFilePath=" + this.f);
    return localUniformDownloaderGenWorker.a(this.f, paramLong);
  }
  
  private void b()
  {
    String str = UniformDownloader.a(1);
    QQAppInterface localQQAppInterface = UniformDownloadMgr.a().a();
    if (localQQAppInterface != null)
    {
      FileManagerUtil.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 1, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      FileManagerUtil.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 1, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
      StatisticAssist.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 9");
  }
  
  public int a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QQAppInterface localQQAppInterface = UniformDownloadMgr.a().a();
    if (localQQAppInterface != null) {
      StatisticAssist.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Start_download_2-3_3-1");
    }
    if (!a())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. not inited");
      b();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener.a(1, UniformDownloader.a(1), null);
      }
      return -1;
    }
    String str;
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. but net is broken. failed drictly");
      a();
      c(5);
      str = UniformDownloader.a(2);
      if (localQQAppInterface != null)
      {
        FileManagerUtil.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 2, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
        FileManagerUtil.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 2, str, 0L, h() * this.b, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
        StatisticAssist.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener.a(2, "net broken", null);
        }
        return -2;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 11");
      }
    }
    int i = e();
    if (2 == i)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. is runing");
      return 0;
    }
    if ((1 != i) && (6 != i) && (8 != i))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. before status is error:" + i);
      return -1;
    }
    long l2 = FileManagerUtil.a(this.f);
    a((int)(l2 / this.b));
    long l1 = 0L;
    if (SystemUtil.a()) {
      l1 = SystemUtil.a() * 1024L;
    }
    if (l1 < this.b - l2)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. sd card space is no enough:[" + this.b + " " + l2 + " " + l1 + "]");
      a();
      c(5);
      if (localQQAppInterface != null)
      {
        str = UniformDownloader.a(9);
        FileManagerUtil.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 9, str, 0L, l2, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
        FileManagerUtil.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 9, str, 0L, l2, this.b, this.jdField_c_of_type_JavaLangString, "", 0, str, null);
        StatisticAssist.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener.a(9, "no space", null);
        }
        return -2;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 5");
      }
    }
    for (;;)
    {
      try
      {
        a(l2);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] start. ST:" + i + " PGR:" + h());
        if (1 == i)
        {
          i = 1;
          c(2);
          if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener != null)) {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener.a(h(), null);
          }
          return 0;
        }
      }
      finally {}
      i = 0;
    }
  }
  
  public int a(UniformDownloader.IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener = paramIUniformDownloaderListener;
    return 0;
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    super.a(paramString, paramBundle);
    paramBundle = UniformDownloadBPTrans.a().a(paramString);
    if (paramBundle != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] >>>init. HAPPY.have a BreakpointTransInfo,tempPath:" + paramBundle.b);
      if (FileManagerUtil.b(paramBundle.b)) {
        this.f = paramBundle.b;
      }
    }
    for (;;)
    {
      return 0;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] >>>init. no exsit");
      continue;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] >>>init. NO HAPPY. Not BreakpointTransInfo,add it:");
      UniformDownloadBPTrans.a().a(paramString, null, this.b, this.f, this.e);
    }
  }
  
  public int b()
  {
    if (!a())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] stop. not inited");
      return -1;
    }
    try
    {
      a();
      int i = e();
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] stop. ST:" + i + " PGR:" + h());
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
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] pause. not inited");
      b();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener.a(1, UniformDownloader.a(1), null);
      }
      i = -1;
    }
    for (;;)
    {
      return i;
      int j = e();
      if ((3 == j) || (7 == j))
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] pause. had be paused");
        return 0;
      }
      try
      {
        a();
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] pause. ST:" + j + " PGR:" + h());
        c(3);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener.c(h(), null);
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
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] resume. not inited");
      b();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener.a(1, UniformDownloader.a(1), null);
      }
      i = -1;
    }
    do
    {
      return i;
      int j = e();
      if ((6 == j) || (2 == j) || (4 == j))
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] resume. had be resumed");
        return 0;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] resume. ST:" + j + " PGR:" + h());
      c(6);
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader$IUniformDownloaderListener.d(h(), null);
    return 0;
  }
  
  public int e()
  {
    return super.e();
  }
  
  public int f()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] resume. ST:" + e() + " PGR:" + h());
    c(8);
    UniformDownloaderGenWorker localUniformDownloaderGenWorker = a();
    if (localUniformDownloaderGenWorker != null) {
      localUniformDownloaderGenWorker.b();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloaderGen
 * JD-Core Version:    0.7.0.1
 */