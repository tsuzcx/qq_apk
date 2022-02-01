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
    Object localObject = g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] killWoker. ");
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = a();
    if (localObject != null)
    {
      ((UniformDownloaderGenWorker)localObject).a();
      a(null);
      return;
    }
    localObject = g;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] killWoker. not worker");
    QLog.i((String)localObject, 1, localStringBuilder.toString());
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
      str = g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] runWorker. before worker be stoped");
      QLog.w(str, 1, localStringBuilder.toString());
      localUniformDownloaderGenWorker.a();
    }
    if (UniformDownloadMgr.a().a() == null) {
      return false;
    }
    localUniformDownloaderGenWorker = new UniformDownloaderGenWorker(this.c, UniformDownloadMgr.a().a(), this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long, this.f, new UniformDownloaderGen.1(this));
    a(localUniformDownloaderGenWorker);
    String str = g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] runWorker. start ,mTempStrFilePath=");
    localStringBuilder.append(this.e);
    QLog.i(str, 1, localStringBuilder.toString());
    return localUniformDownloaderGenWorker.a(this.e, paramLong);
  }
  
  private void b()
  {
    String str = UDConstants.a(1);
    Object localObject = UniformDownloadMgr.a().a();
    if (localObject != null)
    {
      localObject = (BaseQQAppInterface)localObject;
      long l1 = this.c;
      long l2 = this.jdField_a_of_type_Long;
      long l3 = 1;
      QQFileManagerUtil.a((BaseQQAppInterface)localObject, l1, "actFileUfGenDownload", l2, "", "", "", "", l3, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
      QQFileManagerUtil.a((BaseQQAppInterface)localObject, this.c, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", l3, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
      return;
    }
    str = g;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL][");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("].report failed - 9");
    QLog.w(str, 1, ((StringBuilder)localObject).toString());
  }
  
  public int a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject1 = UniformDownloadMgr.a().a();
    boolean bool = a();
    int i = 1;
    Object localObject3;
    if (!bool)
    {
      localObject1 = g;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[UniformDL][");
      ((StringBuilder)localObject3).append(this.c);
      ((StringBuilder)localObject3).append("] start. not inited");
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      b();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
      if (localObject1 != null) {
        ((IUniformDownloaderListener)localObject1).a(1, UDConstants.a(1), null);
      }
      return -1;
    }
    StringBuilder localStringBuilder;
    long l3;
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject3 = g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] start. but net is broken. failed drictly");
      QLog.e((String)localObject3, 1, localStringBuilder.toString());
      a();
      c(5);
      localObject3 = UDConstants.a(5);
      if (localObject1 != null)
      {
        localObject1 = (BaseQQAppInterface)localObject1;
        l1 = this.c;
        l2 = this.jdField_a_of_type_Long;
        l3 = 5;
        QQFileManagerUtil.a((BaseQQAppInterface)localObject1, l1, "actFileUfGenDownload", l2, "", "", "", "", l3, (String)localObject3, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, (String)localObject3, null);
        QQFileManagerUtil.a((BaseQQAppInterface)localObject1, this.c, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", l3, (String)localObject3, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, (String)localObject3, null);
      }
      else
      {
        localObject1 = g;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[UniformDL][");
        ((StringBuilder)localObject3).append(this.c);
        ((StringBuilder)localObject3).append("].report failed - 11");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
      if (localObject1 != null) {
        ((IUniformDownloaderListener)localObject1).a(5, "net broken", null);
      }
      return -2;
    }
    int j = e();
    if (2 == j)
    {
      localObject1 = g;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[UniformDL][");
      ((StringBuilder)localObject3).append(this.c);
      ((StringBuilder)localObject3).append("] start. is runing");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      return 0;
    }
    if ((1 != j) && (6 != j) && (8 != j))
    {
      localObject1 = g;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[UniformDL][");
      ((StringBuilder)localObject3).append(this.c);
      ((StringBuilder)localObject3).append("] start. before status is error:");
      ((StringBuilder)localObject3).append(j);
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      return -1;
    }
    long l2 = QQFileManagerUtil.b(this.e);
    if (l2 > this.jdField_b_of_type_Long) {
      a(0);
    } else {
      a((int)(l2 / this.jdField_b_of_type_Long));
    }
    long l1 = 0L;
    if (SystemUtil.a()) {
      l1 = SystemUtil.a() * 1024L;
    }
    if (l1 < this.jdField_b_of_type_Long - l2)
    {
      localObject3 = g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] start. sd card space is no enough:[");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      localStringBuilder.append(" ");
      localStringBuilder.append(l2);
      localStringBuilder.append(" ");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.e((String)localObject3, 1, localStringBuilder.toString());
      a();
      c(5);
      if (localObject1 != null)
      {
        localObject3 = UDConstants.a(9);
        localObject1 = (BaseQQAppInterface)localObject1;
        l1 = this.c;
        l3 = this.jdField_a_of_type_Long;
        long l4 = 9;
        QQFileManagerUtil.a((BaseQQAppInterface)localObject1, l1, "actFileUfGenDownload", l3, "", "", "", "", l4, (String)localObject3, 0L, l2, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, (String)localObject3, null);
        QQFileManagerUtil.a((BaseQQAppInterface)localObject1, this.c, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", l4, (String)localObject3, 0L, l2, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, (String)localObject3, null);
      }
      else
      {
        localObject1 = g;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[UniformDL][");
        ((StringBuilder)localObject3).append(this.c);
        ((StringBuilder)localObject3).append("].report failed - 5");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
      if (localObject1 != null) {
        ((IUniformDownloaderListener)localObject1).a(9, "no space", null);
      }
      return -2;
    }
    try
    {
      a(l2);
      localObject1 = g;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[UniformDL][");
      ((StringBuilder)localObject3).append(this.c);
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
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
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
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener = paramIUniformDownloaderListener;
    return 0;
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    super.a(paramString, paramBundle);
    paramBundle = UniformDownloadBPTrans.a().a(paramString);
    StringBuilder localStringBuilder;
    if (paramBundle != null)
    {
      paramString = g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] >>>init. HAPPY.have a BreakpointTransInfo,tempPath:");
      localStringBuilder.append(paramBundle.jdField_b_of_type_JavaLangString);
      QLog.i(paramString, 1, localStringBuilder.toString());
      if (QQFileManagerUtil.a(paramBundle.jdField_b_of_type_JavaLangString))
      {
        this.e = paramBundle.jdField_b_of_type_JavaLangString;
      }
      else
      {
        paramString = g;
        paramBundle = new StringBuilder();
        paramBundle.append("[UniformDL][");
        paramBundle.append(this.c);
        paramBundle.append("] >>>init. no exsit");
        QLog.e(paramString, 1, paramBundle.toString());
      }
    }
    else
    {
      paramBundle = g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] >>>init. NO HAPPY. Not BreakpointTransInfo,add it:");
      QLog.i(paramBundle, 1, localStringBuilder.toString());
      UniformDownloadBPTrans.a().a(paramString, null, this.jdField_b_of_type_Long, this.e, this.jdField_d_of_type_JavaLangString);
    }
    return 0;
  }
  
  public int b()
  {
    String str;
    StringBuilder localStringBuilder;
    if (!a())
    {
      str = g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] stop. not inited");
      QLog.e(str, 1, localStringBuilder.toString());
      return -1;
    }
    try
    {
      a();
      int i = e();
      str = g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.c);
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
    if (!a())
    {
      localObject1 = g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] pause. not inited");
      QLog.e((String)localObject1, 1, localStringBuilder.toString());
      b();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
      if (localObject1 != null) {
        ((IUniformDownloaderListener)localObject1).a(1, UDConstants.a(1), null);
      }
      return -1;
    }
    int i = e();
    if ((3 != i) && (7 != i)) {
      try
      {
        a();
        localObject1 = g;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL][");
        localStringBuilder.append(this.c);
        localStringBuilder.append("] pause. ST:");
        localStringBuilder.append(i);
        localStringBuilder.append(" PGR:");
        localStringBuilder.append(h());
        QLog.i((String)localObject1, 1, localStringBuilder.toString());
        c(3);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
        if (localObject1 != null) {
          ((IUniformDownloaderListener)localObject1).c(h(), null);
        }
        return 0;
      }
      finally {}
    }
    String str = g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] pause. had be paused");
    QLog.w(str, 1, localStringBuilder.toString());
    return 0;
  }
  
  public int d()
  {
    if (!a())
    {
      localObject = g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] resume. not inited");
      QLog.e((String)localObject, 1, localStringBuilder.toString());
      b();
      localObject = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
      if (localObject != null) {
        ((IUniformDownloaderListener)localObject).a(1, UDConstants.a(1), null);
      }
      return -1;
    }
    int i = e();
    if ((6 != i) && (2 != i) && (4 != i))
    {
      localObject = g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] resume. ST:");
      localStringBuilder.append(i);
      localStringBuilder.append(" PGR:");
      localStringBuilder.append(h());
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      c(6);
      localObject = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
      if (localObject != null) {
        ((IUniformDownloaderListener)localObject).d(h(), null);
      }
      return 0;
    }
    Object localObject = g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.c);
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
    Object localObject = g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] resume. ST:");
    localStringBuilder.append(e());
    localStringBuilder.append(" PGR:");
    localStringBuilder.append(h());
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    c(8);
    localObject = a();
    if (localObject != null) {
      ((UniformDownloaderGenWorker)localObject).b();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderGen
 * JD-Core Version:    0.7.0.1
 */