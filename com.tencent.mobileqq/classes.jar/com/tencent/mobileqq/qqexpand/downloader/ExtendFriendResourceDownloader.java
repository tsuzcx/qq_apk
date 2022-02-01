package com.tencent.mobileqq.qqexpand.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.qqexpand.bean.chat.LimitChatRes;
import com.tencent.mobileqq.qqexpand.utils.ExpandLimitChatResourceUtil;
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class ExtendFriendResourceDownloader
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendFriendResourceDownloader.ResourceDownloaderListener jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExtendFriendResourceDownloader$ResourceDownloaderListener;
  private IPreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController;
  private String jdField_a_of_type_JavaLangString;
  private final HashMap<String, LimitChatRes> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private String b;
  
  public ExtendFriendResourceDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController = ((IPreDownloadController)paramQQAppInterface.getRuntimeService(IPreDownloadController.class));
    }
  }
  
  public static String a()
  {
    return String.format("%s/res", new Object[] { b() });
  }
  
  private String a(String paramString)
  {
    return String.format("%s/%s.zip", new Object[] { b(), paramString });
  }
  
  private void a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private boolean a(LimitChatRes paramLimitChatRes)
  {
    if ((paramLimitChatRes != null) && (paramLimitChatRes.a()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramLimitChatRes.jdField_a_of_type_JavaLangString);
        return bool;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool3 = new File(paramString1).exists();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramString1 = PortalUtils.a(paramString1);
      bool1 = bool2;
      if (paramString2 != null)
      {
        bool1 = bool2;
        if (paramString2.equalsIgnoreCase(paramString1)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static String b()
  {
    Object localObject1 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject1 != null)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      ((StringBuilder)localObject2).append("/pddata/prd/ef_res");
      localObject2 = ((StringBuilder)localObject2).toString();
      File localFile = new File((String)localObject2);
      localObject1 = localObject2;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        return localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    return localObject1;
  }
  
  private void b(LimitChatRes paramLimitChatRes)
  {
    c(paramLimitChatRes);
    ThreadManager.getSubThreadHandler().post(new ExtendFriendResourceDownloader.3(this, paramLimitChatRes));
  }
  
  private boolean b()
  {
    if (!TextUtils.isEmpty(this.b)) {
      return a(a(this.b), this.b);
    }
    return false;
  }
  
  private boolean b(LimitChatRes paramLimitChatRes)
  {
    return (paramLimitChatRes != null) && (paramLimitChatRes.a()) && (ExpandLimitChatResourceUtil.a.contains(paramLimitChatRes.jdField_a_of_type_JavaLangString));
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    try
    {
      ArConfigUtils.a(paramString1, paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      QLog.e("ExtendFriendResourceDownloader", 1, "unzipResource fail.", paramString1);
    }
    return false;
  }
  
  private void c(LimitChatRes paramLimitChatRes)
  {
    if ((paramLimitChatRes != null) && (paramLimitChatRes.a()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramLimitChatRes.jdField_a_of_type_JavaLangString, paramLimitChatRes);
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  private boolean c()
  {
    return (!TextUtils.isEmpty(this.b)) && (ExpandResourceUtil.a());
  }
  
  private void d(LimitChatRes paramLimitChatRes)
  {
    if ((paramLimitChatRes != null) && (paramLimitChatRes.a()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramLimitChatRes.jdField_a_of_type_JavaLangString);
        return;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public void a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b))) {
      QLog.e("ExtendFriendResourceDownloader", 1, "downloadResource invalid parameters.");
    }
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    if (bool1) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
    }
    Object localObject1 = a(this.b);
    if (!a((String)localObject1, this.b))
    {
      a((String)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController != null)
      {
        Object localObject2 = new HttpNetReq();
        ((HttpNetReq)localObject2).mCallback = new ExtendFriendResourceDownloader.1(this);
        ((HttpNetReq)localObject2).mReqUrl = this.jdField_a_of_type_JavaLangString;
        ((HttpNetReq)localObject2).mHttpMethod = 0;
        ((HttpNetReq)localObject2).mOutPath = ((String)localObject1);
        ((HttpNetReq)localObject2).mPrioty = 0;
        ((HttpNetReq)localObject2).mSupportBreakResume = true;
        localObject2 = new HttpEngineTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, new ExtendFriendResourceDownloader.2(this), (HttpNetReq)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController.requestPreDownload(10073, "prd", this.b, 0, this.jdField_a_of_type_JavaLangString, (String)localObject1, 2, 0, false, (AbsPreDownloadTask)localObject2);
      }
    }
    else if (!c())
    {
      boolean bool4 = b((String)localObject1, a());
      boolean bool3 = c();
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendResourceDownloader", 2, String.format("downloadResource unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExtendFriendResourceDownloader$ResourceDownloaderListener;
      if (localObject1 != null)
      {
        if ((bool4) && (bool3)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((ExtendFriendResourceDownloader.ResourceDownloaderListener)localObject1).a(bool1);
      }
      localObject1 = ExtendFriendReport.a();
      bool1 = bool2;
      if (bool4)
      {
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      ((ExtendFriendReport)localObject1).b(bool1, bool3 ^ true);
    }
  }
  
  public void a(LimitChatRes paramLimitChatRes)
  {
    if (paramLimitChatRes == null)
    {
      QLog.e("ExtendFriendResourceDownloader", 2, "Limitchatres resInfo is null");
      return;
    }
    if (!paramLimitChatRes.a())
    {
      QLog.e("ExtendFriendResourceDownloader", 2, "Limitchatres resInfo is not effect");
      return;
    }
    if (!a(paramLimitChatRes))
    {
      b(paramLimitChatRes);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Limitchatres is downloading");
    localStringBuilder.append(paramLimitChatRes.jdField_a_of_type_JavaLangString);
    QLog.i("ExtendFriendResourceDownloader", 2, localStringBuilder.toString());
  }
  
  public void a(ExtendFriendResourceDownloader.ResourceDownloaderListener paramResourceDownloaderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandDownloaderExtendFriendResourceDownloader$ResourceDownloaderListener = paramResourceDownloaderListener;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("setDownloadInfo url=%s md5=%s", new Object[] { paramString1, paramString2 }));
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public boolean a()
  {
    boolean bool1 = b();
    boolean bool2 = c();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (bool2);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController.cancelPreDownload(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.downloader.ExtendFriendResourceDownloader
 * JD-Core Version:    0.7.0.1
 */