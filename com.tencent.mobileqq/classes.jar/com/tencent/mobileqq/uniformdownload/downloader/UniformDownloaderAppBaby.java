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
    Object localObject = UniformDownloadMgr.a().a();
    if (localObject != null)
    {
      localObject = (BaseQQAppInterface)localObject;
      long l1 = this.c;
      long l2 = this.jdField_a_of_type_Long;
      long l3 = 1;
      QQFileManagerUtil.a((BaseQQAppInterface)localObject, l1, "actFileUfAppBabySdkDownload", l2, "", "", "", "", l3, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
      QQFileManagerUtil.a((BaseQQAppInterface)localObject, this.c, "actFileUfAppBabySdkDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", l3, str, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, str, null);
      return;
    }
    str = jdField_a_of_type_JavaLangString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL][");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("].report failed - 9");
    QLog.w(str, 1, ((StringBuilder)localObject).toString());
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
    Object localObject1 = UniformDownloadMgr.a().a();
    if (!a())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("] start. not inited");
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      a();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
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
        l1 = this.c;
        l2 = this.jdField_a_of_type_Long;
        l3 = 5;
        QQFileManagerUtil.a((BaseQQAppInterface)localObject1, l1, "actFileUfAppBabySdkDownload", l2, "", "", "", "", l3, (String)localObject2, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, (String)localObject2, null);
        QQFileManagerUtil.a((BaseQQAppInterface)localObject1, this.c, "actFileUfAppBabySdkDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", l3, (String)localObject2, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, (String)localObject2, null);
      }
      else
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL][");
        localStringBuilder.append(this.c);
        localStringBuilder.append("].report failed - 8");
        QLog.w((String)localObject1, 1, localStringBuilder.toString());
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
      if (localObject1 != null) {
        ((IUniformDownloaderListener)localObject1).a(5, (String)localObject2, null);
      }
      return -1;
    }
    int i = e();
    if (2 == i)
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("] start. is runing");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return 0;
    }
    if ((1 != i) && (6 != i))
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("] start. before status is error:");
      ((StringBuilder)localObject2).append(i);
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return -1;
    }
    a(0);
    if (1 == i)
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] start download. AddDownloadToAppBabySdk");
      QLog.i((String)localObject2, 1, localStringBuilder.toString());
      i();
    }
    else if ((6 == i) && (!UniformDownloaderAppBabySdk.a().a(this.jdField_b_of_type_JavaLangString)))
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] resume download and start it. sdk is not this download, AddDownloadToAppBabySdk");
      QLog.i((String)localObject2, 1, localStringBuilder.toString());
      i();
    }
    int j = UniformDownloaderAppBabySdk.a().a(this.jdField_b_of_type_JavaLangString);
    if (j == 0)
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("] start. ST:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" PGR:");
      ((StringBuilder)localObject2).append(h());
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      c(2);
      return j;
    }
    Object localObject2 = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.c);
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
      l1 = this.c;
      l2 = this.jdField_a_of_type_Long;
      l3 = 2;
      QQFileManagerUtil.a((BaseQQAppInterface)localObject1, l1, "actFileUfAppBabySdkDownload", l2, "", "", "", "", l3, (String)localObject2, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, (String)localObject2, null);
      QQFileManagerUtil.a((BaseQQAppInterface)localObject1, this.c, "actFileUfAppBabySdkDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", l3, (String)localObject2, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, (String)localObject2, null);
    }
    else
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("].report failed - 8");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
    if (localObject1 != null) {
      ((IUniformDownloaderListener)localObject1).a(2, null, null);
    }
    return j;
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
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] stop. ST:");
    localStringBuilder.append(i);
    localStringBuilder.append(" PGR:");
    localStringBuilder.append(h());
    QLog.i(str, 1, localStringBuilder.toString());
    c(7);
    return UniformDownloaderAppBabySdk.a().c(this.jdField_b_of_type_JavaLangString);
  }
  
  public int c()
  {
    if (!a())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("] pause. not inited");
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
      if (localObject1 != null) {
        ((IUniformDownloaderListener)localObject1).a(1, UDConstants.a(1), null);
      }
      return -1;
    }
    boolean bool = b();
    int i = e();
    if ((1 != i) && (bool))
    {
      if ((3 != i) && (7 != i))
      {
        int j = UniformDownloaderAppBabySdk.a().b(this.jdField_b_of_type_JavaLangString);
        if (j == 0)
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[UniformDL][");
          ((StringBuilder)localObject2).append(this.c);
          ((StringBuilder)localObject2).append("] pause. ST:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" PGR:");
          ((StringBuilder)localObject2).append(h());
          QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          c(3);
          return j;
        }
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[UniformDL][");
        ((StringBuilder)localObject2).append(this.c);
        ((StringBuilder)localObject2).append("] pause failed. ST:");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" PGR:");
        ((StringBuilder)localObject2).append(h());
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        c(5);
        localObject1 = UDConstants.a(15);
        localObject2 = UniformDownloadMgr.a().a();
        if (localObject2 != null)
        {
          localObject2 = (BaseQQAppInterface)localObject2;
          long l1 = this.c;
          long l2 = this.jdField_a_of_type_Long;
          long l3 = 15;
          QQFileManagerUtil.a((BaseQQAppInterface)localObject2, l1, "actFileUfAppBabySdkDownload", l2, "", "", "", "", l3, (String)localObject1, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, (String)localObject1, null);
          QQFileManagerUtil.a((BaseQQAppInterface)localObject2, this.c, "actFileUfAppBabySdkDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", l3, (String)localObject1, 0L, h() * this.jdField_b_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, (String)localObject1, null);
        }
        else
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[UniformDL][");
          ((StringBuilder)localObject2).append(this.c);
          ((StringBuilder)localObject2).append("].report failed - 8");
          QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
        if (localObject1 != null) {
          ((IUniformDownloaderListener)localObject1).a(15, null, null);
        }
        return j;
      }
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("] pause. had be paused");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return 0;
    }
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL][");
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("] waiting and pause. ST:");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(" PGR:");
    ((StringBuilder)localObject2).append(h());
    ((StringBuilder)localObject2).append("(inited)");
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    c(3);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
    if (localObject1 != null) {
      ((IUniformDownloaderListener)localObject1).c(h(), null);
    }
    return 0;
  }
  
  public int d()
  {
    if (!a())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] resume. not inited");
      QLog.e((String)localObject, 1, localStringBuilder.toString());
      localObject = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener;
      if (localObject != null) {
        ((IUniformDownloaderListener)localObject).a(1, UDConstants.a(1), null);
      }
      return -1;
    }
    int i = e();
    if ((6 != i) && (2 != i) && (4 != i))
    {
      localObject = jdField_a_of_type_JavaLangString;
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
    Object localObject = jdField_a_of_type_JavaLangString;
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
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBaby
 * JD-Core Version:    0.7.0.1
 */