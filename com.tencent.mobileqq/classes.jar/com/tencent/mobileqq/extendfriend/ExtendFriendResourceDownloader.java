package com.tencent.mobileqq.extendfriend;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.extendfriend.config.ExpandConfigManager.LimitChatRes;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatResourceUtil;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendResourceUtil;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class ExtendFriendResourceDownloader
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendFriendResourceDownloader.ResourceDownloaderListener jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader$ResourceDownloaderListener;
  private PreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, ExpandConfigManager.LimitChatRes> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private String b;
  
  public ExtendFriendResourceDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController = ((PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2));
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
  
  private boolean a(ExpandConfigManager.LimitChatRes paramLimitChatRes)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramLimitChatRes != null)
    {
      bool1 = bool3;
      if (paramLimitChatRes.a()) {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      }
    }
    try
    {
      bool3 = this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramLimitChatRes.jdField_a_of_type_JavaLangString);
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
      return bool1;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (new File(paramString1).exists())
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
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject2 != null)
    {
      localObject2 = ((File)localObject2).getAbsolutePath() + "/pddata/prd/ef_res";
      File localFile = new File((String)localObject2);
      localObject1 = localObject2;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  private void b(ExpandConfigManager.LimitChatRes paramLimitChatRes)
  {
    c(paramLimitChatRes);
    ThreadManager.getSubThreadHandler().post(new ExtendFriendResourceDownloader.3(this, paramLimitChatRes));
  }
  
  private boolean b()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(this.b)) {
      bool = a(a(this.b), this.b);
    }
    return bool;
  }
  
  private boolean b(ExpandConfigManager.LimitChatRes paramLimitChatRes)
  {
    return (paramLimitChatRes != null) && (paramLimitChatRes.a()) && (ExtendFriendLimitChatResourceUtil.a.contains(paramLimitChatRes.jdField_a_of_type_JavaLangString));
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
  
  private void c(ExpandConfigManager.LimitChatRes paramLimitChatRes)
  {
    if ((paramLimitChatRes != null) && (paramLimitChatRes.a())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
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
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.b))
    {
      bool1 = bool2;
      if (ExtendFriendResourceUtil.a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void d(ExpandConfigManager.LimitChatRes paramLimitChatRes)
  {
    if ((paramLimitChatRes != null) && (paramLimitChatRes.a())) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    }
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
  
  public void a()
  {
    int i = 1;
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b))) {
      QLog.e("ExtendFriendResourceDownloader", 1, "downloadResource invalid parameters.");
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
    }
    Object localObject1 = a(this.b);
    if (!a((String)localObject1, this.b))
    {
      a((String)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController != null)
      {
        localObject2 = new HttpNetReq();
        ((HttpNetReq)localObject2).mCallback = new ExtendFriendResourceDownloader.1(this);
        ((HttpNetReq)localObject2).mReqUrl = this.jdField_a_of_type_JavaLangString;
        ((HttpNetReq)localObject2).mHttpMethod = 0;
        ((HttpNetReq)localObject2).mOutPath = ((String)localObject1);
        ((HttpNetReq)localObject2).mPrioty = 0;
        ((HttpNetReq)localObject2).mSupportBreakResume = true;
        localObject2 = new HttpEngineTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, new ExtendFriendResourceDownloader.2(this), (HttpNetReq)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.requestPreDownload(10073, "prd", this.b, 0, this.jdField_a_of_type_JavaLangString, (String)localObject1, 2, 0, false, (AbsPreDownloadTask)localObject2);
      }
    }
    while (c())
    {
      Object localObject2;
      return;
    }
    boolean bool3 = b((String)localObject1, a());
    boolean bool2 = c();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("downloadResource unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2) }));
    }
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader$ResourceDownloaderListener != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader$ResourceDownloaderListener;
      if ((bool3) && (bool2))
      {
        bool1 = true;
        ((ExtendFriendResourceDownloader.ResourceDownloaderListener)localObject1).a(bool1);
      }
    }
    else
    {
      localObject1 = ExtendFriendReport.a();
      if ((!bool3) || (!bool2)) {
        break label340;
      }
      bool1 = true;
      label323:
      if (bool2) {
        break label345;
      }
    }
    for (;;)
    {
      ((ExtendFriendReport)localObject1).b(bool1, i);
      return;
      bool1 = false;
      break;
      label340:
      bool1 = false;
      break label323;
      label345:
      i = 0;
    }
  }
  
  public void a(ExtendFriendResourceDownloader.ResourceDownloaderListener paramResourceDownloaderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendResourceDownloader$ResourceDownloaderListener = paramResourceDownloaderListener;
  }
  
  public void a(ExpandConfigManager.LimitChatRes paramLimitChatRes)
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
    QLog.i("ExtendFriendResourceDownloader", 2, "Limitchatres is downloading" + paramLimitChatRes.jdField_a_of_type_JavaLangString);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.cancelPreDownload(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader
 * JD-Core Version:    0.7.0.1
 */