package com.tencent.mobileqq.onlinestatus.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

public class ZipResourcesDownloader
{
  WeakReference<IPreDownloadController> a;
  ArrayList<String> b = new ArrayList();
  ArrayList<ZipResourcesDownloader.CallbackCacheItem> c = new ArrayList();
  boolean d = false;
  
  public static String a(String paramString)
  {
    Object localObject3 = null;
    Object localObject2;
    try
    {
      localObject4 = MD5.getPartfileMd5(paramString, 0L);
      Object localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = MD5FileUtil.b((byte[])localObject4);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("error ........ error getFileMD5String filePath: ");
      ((StringBuilder)localObject4).append(paramString);
      ((StringBuilder)localObject4).append(", error=");
      ((StringBuilder)localObject4).append(localException.getMessage());
      QLog.e("ZipResourcesDownloader", 2, ((StringBuilder)localObject4).toString());
      localObject2 = localObject3;
    }
    if (QLog.isDebugVersion())
    {
      paramString = new StringBuilder();
      paramString.append("getFileMD5String md5: ");
      paramString.append(localObject2);
      QLog.e("ZipResourcesDownloader", 2, paramString.toString());
    }
    return localObject2;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return d(paramString2);
  }
  
  private void a(BaseQQAppInterface arg1, int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, ZipResourcesDownloader.OnZipResourcesDownloadCallback paramOnZipResourcesDownloadCallback, IPreDownloadController paramIPreDownloadController, String paramString4)
  {
    synchronized (this.b)
    {
      boolean bool = this.b.contains(paramString2);
      if (bool)
      {
        if (paramOnZipResourcesDownloadCallback != null) {
          synchronized (this.c)
          {
            this.c.add(new ZipResourcesDownloader.CallbackCacheItem(this, paramString2, paramOnZipResourcesDownloadCallback));
            return;
          }
        }
        return;
      }
      e(paramString4);
      ??? = new HttpNetReq();
      ((HttpNetReq)???).mCallback = new ZipResourcesDownloader.1(this);
      ((HttpNetReq)???).mReqUrl = paramString2;
      ((HttpNetReq)???).mHttpMethod = 0;
      ((HttpNetReq)???).mOutPath = paramString4;
      ((HttpNetReq)???).mPrioty = 0;
      ((HttpNetReq)???).mSupportBreakResume = true;
      paramIPreDownloadController.requestPreDownload(paramInt, paramString1, paramString3, 0, paramString2, paramString4, 2, 0, false, new HttpEngineTask(???, paramString3, new ZipResourcesDownloader.2(this, paramString3, paramArrayOfString, paramOnZipResourcesDownloadCallback), (HttpNetReq)???));
      synchronized (this.b)
      {
        this.b.add(paramString2);
        return;
      }
    }
  }
  
  private void a(NetResp paramNetResp, String paramString, String[] paramArrayOfString, ZipResourcesDownloader.OnZipResourcesDownloadCallback paramOnZipResourcesDownloadCallback)
  {
    String str = ((HttpNetReq)paramNetResp.mReq).mReqUrl;
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { str, Integer.valueOf(paramNetResp.mResult) }));
    }
    int i = paramNetResp.mResult;
    Object localObject2 = null;
    Object localObject1 = null;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      paramArrayOfString = this.a;
      paramNetResp = (NetResp)localObject1;
      if (paramArrayOfString != null) {
        paramNetResp = (IPreDownloadController)paramArrayOfString.get();
      }
      if (paramNetResp != null) {
        paramNetResp.preDownloadSuccess(str, -1L);
      }
      a(str, paramString, false, paramOnZipResourcesDownloadCallback);
      return;
    }
    WeakReference localWeakReference = this.a;
    localObject1 = localObject2;
    if (localWeakReference != null) {
      localObject1 = (IPreDownloadController)localWeakReference.get();
    }
    if (localObject1 != null) {
      ((IPreDownloadController)localObject1).preDownloadSuccess(str, paramNetResp.mTotalFileLen);
    }
    paramNetResp = (HttpNetReq)paramNetResp.mReq;
    if (b(paramNetResp.mOutPath, paramString))
    {
      localObject1 = new File(d(paramString));
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      boolean bool1 = c(paramNetResp.mOutPath, d(paramString));
      boolean bool2 = b(str, paramString, paramArrayOfString);
      if (QLog.isColorLevel()) {
        QLog.d("ZipResourcesDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      a(str, paramString, bool2, paramOnZipResourcesDownloadCallback);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ZipResourcesDownloader", 2, "onResp ResultOk file check invalid.");
    }
    e(paramNetResp.mOutPath);
    a(str, paramString, false, paramOnZipResourcesDownloadCallback);
  }
  
  private void a(String paramString1, String arg2, boolean paramBoolean, ZipResourcesDownloader.OnZipResourcesDownloadCallback paramOnZipResourcesDownloadCallback)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ???.append("onDownloadEnd url:");
      ???.append(paramString1);
      ???.append(" success:");
      ???.append(paramBoolean);
      ???.append(" mDestroyed:");
      ???.append(this.d);
      QLog.d("ZipResourcesDownloader", 2, ???.toString());
    }
    if (this.d) {
      return;
    }
    int i;
    synchronized (this.b)
    {
      this.b.remove(paramString1);
      if (paramOnZipResourcesDownloadCallback != null) {
        paramOnZipResourcesDownloadCallback.a(paramBoolean);
      }
      synchronized (this.c)
      {
        i = this.c.size() - 1;
        if (i >= 0)
        {
          paramOnZipResourcesDownloadCallback = (ZipResourcesDownloader.CallbackCacheItem)this.c.get(i);
          if ((paramOnZipResourcesDownloadCallback != null) && (TextUtils.equals(paramString1, paramOnZipResourcesDownloadCallback.a)))
          {
            if (paramOnZipResourcesDownloadCallback.b != null) {
              paramOnZipResourcesDownloadCallback.b.a(paramBoolean);
            }
            this.c.remove(i);
          }
        }
        else
        {
          return;
        }
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return b(paramString1, paramString2, paramArrayOfString);
  }
  
  private static String b()
  {
    Object localObject1 = MobileQQ.sMobileQQ.getFilesDir();
    if (localObject1 != null)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      ((StringBuilder)localObject2).append("/pddata/prd/common_resources");
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
  
  private static boolean b(String paramString)
  {
    return new File(paramString).exists();
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    boolean bool3 = new File(paramString1).exists();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramString1 = a(paramString1);
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
  
  private static boolean b(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = a(paramString1, paramString2);
      if (!b(paramString1)) {
        return false;
      }
      if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
      {
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          paramString2 = paramArrayOfString[i];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append("/");
          localStringBuilder.append(paramString2);
          paramString2 = localStringBuilder.toString();
          if (!b(paramString2))
          {
            QLog.e("ZipResourcesDownloader", 1, String.format("isFilesExist check fail. filePath=%s", new Object[] { paramString2 }));
            return false;
          }
          i += 1;
        }
      }
      return true;
    }
    return false;
  }
  
  private static String c(String paramString)
  {
    return String.format("%s/%s.zip", new Object[] { b(), paramString });
  }
  
  private static boolean c(String paramString1, String paramString2)
  {
    try
    {
      ArConfigUtils.a(paramString1, paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      QLog.e("ZipResourcesDownloader", 1, "unzipResource fail.", paramString1);
    }
    return false;
  }
  
  private static String d(String paramString)
  {
    return String.format("%s/%s", new Object[] { b(), paramString });
  }
  
  private static void e(String paramString)
  {
    FileUtils.delete(paramString, false);
  }
  
  public void a()
  {
    this.d = true;
    synchronized (this.b)
    {
      this.b.clear();
      synchronized (this.c)
      {
        this.c.clear();
        return;
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, ZipResourcesDownloader.OnZipResourcesDownloadCallback paramOnZipResourcesDownloadCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("downloadResource url=%s md5=%s callback=%s", new Object[] { paramString2, paramString3, paramOnZipResourcesDownloadCallback }));
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (paramAppInterface != null))
    {
      Object localObject1 = null;
      Object localObject2 = this.a;
      if (localObject2 != null) {
        localObject1 = (IPreDownloadController)((WeakReference)localObject2).get();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = (IPreDownloadController)paramAppInterface.getRuntimeService(IPreDownloadController.class, "");
        this.a = new WeakReference(localObject2);
      }
      if (localObject2 == null) {
        return;
      }
      localObject1 = c(paramString3);
      if (!b((String)localObject1, paramString3))
      {
        a((BaseQQAppInterface)paramAppInterface, paramInt, paramString1, paramString2, paramString3, paramArrayOfString, paramOnZipResourcesDownloadCallback, (IPreDownloadController)localObject2, (String)localObject1);
        return;
      }
      boolean bool2 = b(paramString2, paramString3, paramArrayOfString);
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool2 = c((String)localObject1, d(paramString3));
        bool1 = b(paramString2, paramString3, paramArrayOfString);
        if (QLog.isColorLevel()) {
          QLog.d("ZipResourcesDownloader", 2, String.format("downloadResource unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        }
      }
      if (paramOnZipResourcesDownloadCallback != null) {
        paramOnZipResourcesDownloadCallback.a(bool1);
      }
      return;
    }
    QLog.e("ZipResourcesDownloader", 1, "downloadResource invalid parameters.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.ZipResourcesDownloader
 * JD-Core Version:    0.7.0.1
 */