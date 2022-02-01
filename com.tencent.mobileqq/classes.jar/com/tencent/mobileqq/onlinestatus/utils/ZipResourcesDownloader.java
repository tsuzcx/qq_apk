package com.tencent.mobileqq.onlinestatus.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
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
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  WeakReference<IPreDownloadController> jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  ArrayList<ZipResourcesDownloader.CallbackCacheItem> b = new ArrayList();
  
  private static String a()
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
      ???.append(this.jdField_a_of_type_Boolean);
      QLog.d("ZipResourcesDownloader", 2, ???.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramString1);
      if (paramOnZipResourcesDownloadCallback != null) {
        paramOnZipResourcesDownloadCallback.a(paramBoolean);
      }
      synchronized (this.b)
      {
        i = this.b.size() - 1;
        if (i >= 0)
        {
          paramOnZipResourcesDownloadCallback = (ZipResourcesDownloader.CallbackCacheItem)this.b.get(i);
          if ((paramOnZipResourcesDownloadCallback != null) && (TextUtils.equals(paramString1, paramOnZipResourcesDownloadCallback.jdField_a_of_type_JavaLangString)))
          {
            if (paramOnZipResourcesDownloadCallback.jdField_a_of_type_ComTencentMobileqqOnlinestatusUtilsZipResourcesDownloader$OnZipResourcesDownloadCallback != null) {
              paramOnZipResourcesDownloadCallback.jdField_a_of_type_ComTencentMobileqqOnlinestatusUtilsZipResourcesDownloader$OnZipResourcesDownloadCallback.a(paramBoolean);
            }
            this.b.remove(i);
          }
        }
        else
        {
          return;
        }
      }
    }
  }
  
  private static boolean a(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static boolean a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return c(paramString1, paramString2, paramArrayOfString);
  }
  
  private static void b(String paramString)
  {
    FileUtils.delete(paramString, false);
  }
  
  private static String c(String paramString)
  {
    return String.format("%s/%s.zip", new Object[] { a(), paramString });
  }
  
  private static boolean c(String paramString1, String paramString2)
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
  
  private static boolean c(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = a(paramString1, paramString2);
      if (!a(paramString1)) {
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
          if (!a(paramString2))
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
  
  private static String d(String paramString)
  {
    return String.format("%s/%s", new Object[] { a(), paramString });
  }
  
  private static boolean d(String paramString1, String paramString2)
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
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      synchronized (this.b)
      {
        this.b.clear();
        return;
      }
    }
  }
  
  public void a(AppInterface arg1, int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, ZipResourcesDownloader.OnZipResourcesDownloadCallback paramOnZipResourcesDownloadCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("downloadResource url=%s md5=%s callback=%s", new Object[] { paramString2, paramString3, paramOnZipResourcesDownloadCallback }));
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (??? != null))
    {
      Object localObject1 = null;
      Object localObject2 = this.jdField_a_of_type_MqqUtilWeakReference;
      if (localObject2 != null) {
        localObject1 = (IPreDownloadController)((WeakReference)localObject2).get();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = (IPreDownloadController)???.getRuntimeService(IPreDownloadController.class, "");
        this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(localObject2);
      }
      if (localObject2 == null) {
        return;
      }
      localObject1 = c(paramString3);
      if (!c((String)localObject1, paramString3)) {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          bool1 = this.jdField_a_of_type_JavaUtilArrayList.contains(paramString2);
          if (bool1)
          {
            if (paramOnZipResourcesDownloadCallback != null) {
              synchronized (this.b)
              {
                this.b.add(new ZipResourcesDownloader.CallbackCacheItem(this, paramString2, paramOnZipResourcesDownloadCallback));
                return;
              }
            }
            return;
          }
          b((String)localObject1);
          ??? = new HttpNetReq();
          ((HttpNetReq)???).mCallback = new ZipResourcesDownloader.1(this);
          ((HttpNetReq)???).mReqUrl = paramString2;
          ((HttpNetReq)???).mHttpMethod = 0;
          ((HttpNetReq)???).mOutPath = ((String)localObject1);
          ((HttpNetReq)???).mPrioty = 0;
          ((HttpNetReq)???).mSupportBreakResume = true;
          ((IPreDownloadController)localObject2).requestPreDownload(paramInt, paramString1, paramString3, 0, paramString2, (String)localObject1, 2, 0, false, new HttpEngineTask((BaseQQAppInterface)???, paramString3, new ZipResourcesDownloader.2(this, paramString3, paramArrayOfString, paramOnZipResourcesDownloadCallback), (HttpNetReq)???));
          synchronized (this.jdField_a_of_type_JavaUtilArrayList)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(paramString2);
            return;
          }
        }
      }
      boolean bool2 = c(paramString2, paramString3, paramArrayOfString);
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool2 = d((String)localObject1, d(paramString3));
        bool1 = c(paramString2, paramString3, paramArrayOfString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.ZipResourcesDownloader
 * JD-Core Version:    0.7.0.1
 */