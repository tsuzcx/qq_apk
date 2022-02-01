package com.tencent.mobileqq.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class SoLibraryChecker
{
  private static Map<String, Boolean> f = new ConcurrentHashMap();
  int a = 0;
  private Context b;
  private String c;
  private String d;
  private String e;
  
  public SoLibraryChecker(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.b = paramContext.getApplicationContext();
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("code");
    String str = OfflineEnvHelper.c(this.c);
    boolean bool1 = TextUtils.isEmpty(str);
    boolean bool2 = true;
    if (!bool1)
    {
      if (i == 4)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(".7z");
        str = ((StringBuilder)localObject).toString();
        bool1 = true;
        break label199;
      }
      if ((i != 3) && (i != 2))
      {
        QLog.e("SoLibraryLoader", 1, "do not know what format, use default zip name!");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(".zip");
        str = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(".zip");
        str = ((StringBuilder)localObject).toString();
        bool1 = false;
        break label202;
      }
    }
    else
    {
      str = null;
    }
    bool1 = false;
    label199:
    bool2 = false;
    label202:
    Object localObject = new SoLibraryChecker.3(this, str, bool2, bool1);
    if (!TextUtils.isEmpty(str)) {
      ThreadManager.post(new SoLibraryChecker.4(this, paramJSONObject, str, (DownloadListener)localObject), 8, null, false);
    }
  }
  
  private boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      str = this.c;
      boolean bool2 = TextUtils.isEmpty(str);
      bool1 = false;
      if (bool2) {
        return false;
      }
      bool2 = TextUtils.isEmpty(OfflineEnvHelper.c(str));
      if (bool2) {
        return false;
      }
      localObject2 = new File(paramString);
      if (!((File)localObject2).exists())
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("doUnzipZip: no zip ! : businessId:");
          paramString.append(str);
          QLog.i("SoLibraryLoader", 2, paramString.toString());
        }
        return false;
      }
      l = System.currentTimeMillis();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((File)localObject2).getParent());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(str);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject3 = BidDownloader.d(paramString);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fileFormat: ");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(", path: ");
        localStringBuilder.append(paramString);
        QLog.i("SoLibraryLoader", 2, localStringBuilder.toString());
      }
      bool2 = TextUtils.isEmpty((CharSequence)localObject3);
      i = 1;
      if (!bool2)
      {
        if (((String)localObject3).equals("zip"))
        {
          i = ZipUtils.unZipFolder(paramString, (String)localObject1);
          break label702;
        }
        if (((String)localObject3).equals("7z"))
        {
          i = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramString, (String)localObject1);
          break label702;
        }
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("can not recognize download compress file format, ");
        ((StringBuilder)localObject3).append(paramString);
        QLog.w("SoLibraryLoader", 1, ((StringBuilder)localObject3).toString());
        if (paramBoolean1) {
          i = ZipUtils.unZipFolder(paramString, (String)localObject1);
        } else if (paramBoolean2) {
          i = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramString, (String)localObject1);
        }
      }
    }
    finally
    {
      label702:
      label705:
      for (;;)
      {
        String str;
        boolean bool1;
        Object localObject2;
        long l;
        Object localObject1;
        Object localObject3;
        StringBuilder localStringBuilder;
        int i;
        for (;;)
        {
          throw paramString;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("now delete original download offline zip, path: ");
      ((StringBuilder)localObject3).append(paramString);
      QLog.i("SoLibraryLoader", 2, ((StringBuilder)localObject3).toString());
    }
    Util.b(paramString);
    if (i > 0)
    {
      HtmlOffline.a(str, 13, 0L, i, "lixian_update", "0");
      paramBoolean1 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.i("SoLibraryLoader", 2, "unZipFolder fail!");
        paramBoolean1 = bool1;
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append(File.separator);
      paramString.append(str);
      paramString.append(".zip");
      paramString = paramString.toString();
      localObject3 = new File(paramString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject2).getParent());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      localStringBuilder.append(".zip");
      str = localStringBuilder.toString();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("now move zip file to location: ");
        ((StringBuilder)localObject2).append(str);
        QLog.i("SoLibraryLoader", 2, ((StringBuilder)localObject2).toString());
      }
      paramBoolean1 = bool1;
      if (((File)localObject3).exists())
      {
        paramBoolean1 = ((File)localObject3).renameTo(new File(str));
        if (paramBoolean1) {
          break label705;
        }
        paramBoolean1 = FileUtils.moveFile(paramString, str);
      }
    }
    Util.a((String)localObject1);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("time of unzip zip：");
      paramString.append(System.currentTimeMillis() - l);
      paramString.append(", isSuccess: ");
      paramString.append(paramBoolean1);
      QLog.i("SoLibraryLoader", 2, paramString.toString());
    }
    return paramBoolean1;
  }
  
  private void b()
  {
    this.a = 0;
    HtmlOffline.b();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool;
    if ((localQQAppInterface != null) && (localQQAppInterface.getLongAccountUin() % 10L == 6L)) {
      bool = true;
    } else {
      bool = false;
    }
    HtmlOffline.i = bool;
    Object localObject = HtmlOffline.d(this.c);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkSoUpdate version = ");
      localStringBuilder.append((String)localObject);
      QLog.d("SoLibraryLoader", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(OfflineEnvHelper.b(this.c));
    localStringBuilder.append(this.c);
    localStringBuilder.append("/");
    localStringBuilder.append(this.d);
    if ((!new File(localStringBuilder.toString()).exists()) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!"0".equals(localObject)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(OfflineEnvHelper.b(this.c));
      ((StringBuilder)localObject).append(this.c);
      FileUtils.deleteDirectory(((StringBuilder)localObject).toString());
    }
    if (localQQAppInterface == null) {
      return;
    }
    HtmlOffline.a(this.c, localQQAppInterface, new SoLibraryChecker.1(this), false);
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return new File(localStringBuilder.toString()).exists();
  }
  
  private void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("?_bid=");
    ((StringBuilder)localObject).append(this.c);
    localObject = ((StringBuilder)localObject).toString();
    long l = System.currentTimeMillis();
    if ((!HtmlOffline.a(BaseApplicationImpl.getContext(), (String)localObject, new SoLibraryChecker.2(this, l))) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("so file = ");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(" transToLocalUrl: return false");
      QLog.i("SoLibraryLoader", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private DownloaderInterface d()
  {
    return ((DownloaderFactory)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
  }
  
  public void a()
  {
    if (!f.containsKey(this.c)) {
      f.put(this.c, Boolean.valueOf(false));
    }
    if ((!b(this.b, this.d)) || (!((Boolean)f.get(this.c)).booleanValue()))
    {
      b();
      f.put(this.c, Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLibraryChecker
 * JD-Core Version:    0.7.0.1
 */