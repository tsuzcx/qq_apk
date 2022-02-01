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
  private final QQAppInterface a;
  private IPreDownloadController b;
  private ExtendFriendResourceDownloader.ResourceDownloaderListener c;
  private String d;
  private String e;
  private final HashMap<String, LimitChatRes> f = new HashMap();
  private final Lock g = new ReentrantLock();
  
  public ExtendFriendResourceDownloader(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    paramQQAppInterface = this.a;
    if (paramQQAppInterface != null) {
      this.b = ((IPreDownloadController)paramQQAppInterface.getRuntimeService(IPreDownloadController.class));
    }
  }
  
  public static String a()
  {
    return String.format("%s/res", new Object[] { e() });
  }
  
  private String a(String paramString)
  {
    return String.format("%s/%s.zip", new Object[] { e(), paramString });
  }
  
  private void b(LimitChatRes paramLimitChatRes)
  {
    d(paramLimitChatRes);
    ThreadManager.getSubThreadHandler().post(new ExtendFriendResourceDownloader.3(this, paramLimitChatRes));
  }
  
  private void b(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private boolean b(String paramString1, String paramString2)
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
  
  private boolean c(LimitChatRes paramLimitChatRes)
  {
    if ((paramLimitChatRes != null) && (paramLimitChatRes.a()))
    {
      this.g.lock();
      try
      {
        boolean bool = this.f.containsKey(paramLimitChatRes.a);
        return bool;
      }
      finally
      {
        this.g.unlock();
      }
    }
    return false;
  }
  
  private boolean c(String paramString1, String paramString2)
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
  
  private void d(LimitChatRes paramLimitChatRes)
  {
    if ((paramLimitChatRes != null) && (paramLimitChatRes.a()))
    {
      this.g.lock();
      try
      {
        this.f.put(paramLimitChatRes.a, paramLimitChatRes);
        return;
      }
      finally
      {
        this.g.unlock();
      }
    }
  }
  
  private static String e()
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
  
  private void e(LimitChatRes paramLimitChatRes)
  {
    if ((paramLimitChatRes != null) && (paramLimitChatRes.a()))
    {
      this.g.lock();
      try
      {
        this.f.remove(paramLimitChatRes.a);
        return;
      }
      finally
      {
        this.g.unlock();
      }
    }
  }
  
  private boolean f()
  {
    if (!TextUtils.isEmpty(this.e)) {
      return b(a(this.e), this.e);
    }
    return false;
  }
  
  private boolean f(LimitChatRes paramLimitChatRes)
  {
    return (paramLimitChatRes != null) && (paramLimitChatRes.a()) && (ExpandLimitChatResourceUtil.b.contains(paramLimitChatRes.a));
  }
  
  private boolean g()
  {
    return (!TextUtils.isEmpty(this.e)) && (ExpandResourceUtil.c());
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
    if (!c(paramLimitChatRes))
    {
      b(paramLimitChatRes);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Limitchatres is downloading");
    localStringBuilder.append(paramLimitChatRes.a);
    QLog.i("ExtendFriendResourceDownloader", 2, localStringBuilder.toString());
  }
  
  public void a(ExtendFriendResourceDownloader.ResourceDownloaderListener paramResourceDownloaderListener)
  {
    this.c = paramResourceDownloaderListener;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("setDownloadInfo url=%s md5=%s", new Object[] { paramString1, paramString2 }));
    }
    this.d = paramString1;
    this.e = paramString2;
  }
  
  public boolean b()
  {
    boolean bool1 = f();
    boolean bool2 = g();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (bool2);
  }
  
  public void c()
  {
    if ((TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.e))) {
      QLog.e("ExtendFriendResourceDownloader", 1, "downloadResource invalid parameters.");
    }
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    if (bool1) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { this.d, this.e }));
    }
    Object localObject1 = a(this.e);
    if (!b((String)localObject1, this.e))
    {
      b((String)localObject1);
      if (this.b != null)
      {
        Object localObject2 = new HttpNetReq();
        ((HttpNetReq)localObject2).mCallback = new ExtendFriendResourceDownloader.1(this);
        ((HttpNetReq)localObject2).mReqUrl = this.d;
        ((HttpNetReq)localObject2).mHttpMethod = 0;
        ((HttpNetReq)localObject2).mOutPath = ((String)localObject1);
        ((HttpNetReq)localObject2).mPrioty = 0;
        ((HttpNetReq)localObject2).mSupportBreakResume = true;
        localObject2 = new HttpEngineTask(this.a, this.e, new ExtendFriendResourceDownloader.2(this), (HttpNetReq)localObject2);
        this.b.requestPreDownload(10073, "prd", this.e, 0, this.d, (String)localObject1, 2, 0, false, (AbsPreDownloadTask)localObject2);
      }
    }
    else if (!g())
    {
      boolean bool4 = c((String)localObject1, a());
      boolean bool3 = g();
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendResourceDownloader", 2, String.format("downloadResource unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
      }
      localObject1 = this.c;
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
  
  public void d()
  {
    if ((this.b != null) && (!TextUtils.isEmpty(this.d))) {
      this.b.cancelPreDownload(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.downloader.ExtendFriendResourceDownloader
 * JD-Core Version:    0.7.0.1
 */