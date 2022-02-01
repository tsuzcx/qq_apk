package com.tencent.mobileqq.cmshow.engine.resource.downloader;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.utils.ApolloResDownloaderUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnAudioDownloadListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public abstract class AbsApolloResDownloader
  implements IApolloResDownloader
{
  public static int a = -5011;
  public static int b = -5012;
  public static int c = -5013;
  
  private AbsApolloResDownloader.ApolloLoadResTask a(ApolloBaseInfo paramApolloBaseInfo)
  {
    Object localObject = null;
    if (paramApolloBaseInfo == null) {
      paramApolloBaseInfo = null;
    } else {
      paramApolloBaseInfo = paramApolloBaseInfo.getApolloPetDress();
    }
    if ((paramApolloBaseInfo != null) && (paramApolloBaseInfo.roleId >= 0))
    {
      if (a().g(1, paramApolloBaseInfo.roleId) / 1000L != paramApolloBaseInfo.roleTimeStamp)
      {
        if (QLog.isColorLevel())
        {
          localObject = b();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[buildLoadPetDressTask] update pet role :");
          localStringBuilder.append(paramApolloBaseInfo.roleId);
          localStringBuilder.append(" to:");
          localStringBuilder.append(paramApolloBaseInfo.roleTimeStamp);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        localObject = new AbsApolloResDownloader.ApolloLoadResTask(1, paramApolloBaseInfo.roleId);
      }
      return localObject;
    }
    QLog.w(b(), 2, "[buildLoadPetDressTask] invalid params!");
    return null;
  }
  
  private List<AbsApolloResDownloader.ApolloLoadResTask> a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramAppRuntime == null)
    {
      QLog.e(b(), 1, "[buildLoadResTasks] error, app is null!");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramAppRuntime = a(((IApolloDaoManagerService)paramAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramString));
    if (paramAppRuntime != null) {
      localArrayList.add(paramAppRuntime);
    }
    if (paramInt1 >= 0) {
      localArrayList.add(new AbsApolloResDownloader.ApolloLoadResTask(1, paramInt1));
    }
    paramAppRuntime = a(paramArrayOfInt);
    if (paramAppRuntime != null) {
      localArrayList.addAll(paramAppRuntime);
    }
    if (paramInt2 > 0) {
      localArrayList.add(new AbsApolloResDownloader.ApolloLoadResTask(3, paramInt2));
    }
    return localArrayList;
  }
  
  private List<AbsApolloResDownloader.ApolloLoadResTask> a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        localArrayList.add(new AbsApolloResDownloader.ApolloLoadResTask(2, paramArrayOfInt[i]));
        i += 1;
      }
      return localArrayList;
    }
    QLog.w(b(), 2, "[buildLoadSpriteDressTask] invalid params!");
    return null;
  }
  
  private void a(IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramOnApolloDownLoadListener != null) {
      paramOnApolloDownLoadListener.a(paramBoolean, paramString, paramInt1, paramArrayOfInt, paramInt2);
    }
  }
  
  private void a(AppRuntime paramAppRuntime, String paramString1, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, int[] paramArrayOfInt, int paramInt2, String paramString2, int paramInt3, int paramInt4, DownloaderInterface paramDownloaderInterface, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3)
  {
    Object localObject = a().d(paramInt3, paramInt4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("res.zip");
    localObject = new File((String)localObject, localStringBuilder.toString());
    ((File)localObject).getParentFile().mkdirs();
    paramString2 = new DownloadTask(paramString2, (File)localObject);
    paramString2.N = true;
    paramString2.J = true;
    paramString2.L = "apollo_res";
    paramString2.e = 1;
    paramString2.P = true;
    paramString2.Q = true;
    QLog.d(b(), 2, new Object[] { "[downloadApolloRes]startDownload  resType = ", Integer.valueOf(paramInt3), " id = ", Integer.valueOf(paramInt4) });
    paramDownloaderInterface.startDownload(paramString2, new AbsApolloResDownloader.2(this, (File)localObject, paramAppRuntime, paramInt3, paramInt4, paramAtomicInteger3, paramAtomicInteger2, paramAtomicInteger1, paramOnApolloDownLoadListener, paramString1, paramInt1, paramArrayOfInt, paramInt2), null);
  }
  
  private boolean a(IApolloResManager paramIApolloResManager, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBoolean) {
      return true;
    }
    if (paramInt1 == 3) {
      paramBoolean = paramIApolloResManager.c(paramInt2, paramInt3);
    } else {
      paramBoolean = paramIApolloResManager.b(paramInt1, paramInt2);
    }
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = false;
    if (bool2) {
      QLog.d(b(), 2, new Object[] { "[downloadApolloRes] fileExist = ", Boolean.valueOf(paramBoolean) });
    }
    if (!paramBoolean) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void a(AppInterface paramAppInterface, IApolloResDownloader.OnAudioDownloadListener paramOnAudioDownloadListener, int paramInt, boolean paramBoolean)
  {
    if ((paramAppInterface != null) && (NetworkUtil.isNetworkAvailable(paramAppInterface.getApplication())))
    {
      Object localObject2 = a();
      Object localObject1 = new File(((IApolloResManager)localObject2).i(paramInt));
      if ((!paramBoolean) && (((File)localObject1).exists()))
      {
        if (QLog.isColorLevel())
        {
          paramAppInterface = b();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("file exsit resType->4 id->");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.d(paramAppInterface, 2, ((StringBuilder)localObject1).toString());
        }
        if (paramOnAudioDownloadListener != null) {
          paramOnAudioDownloadListener.a(true, paramInt);
        }
        return;
      }
      localObject2 = ((IApolloResManager)localObject2).a(4, paramInt);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isColorLevel())
        {
          paramAppInterface = b();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("downloadApolloRes url is empty resType->4 id->");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.d(paramAppInterface, 2, ((StringBuilder)localObject1).toString());
        }
        if (paramOnAudioDownloadListener != null) {
          paramOnAudioDownloadListener.a(false, paramInt);
        }
        return;
      }
      paramAppInterface = ApolloResDownloaderUtil.a(paramAppInterface);
      if (paramAppInterface == null)
      {
        if (paramOnAudioDownloadListener != null) {
          paramOnAudioDownloadListener.a(false, paramInt);
        }
        return;
      }
      ((File)localObject1).getParentFile().mkdirs();
      localObject1 = new DownloadTask((String)localObject2, (File)localObject1);
      ((DownloadTask)localObject1).N = true;
      ((DownloadTask)localObject1).J = true;
      ((DownloadTask)localObject1).L = "apollo_res";
      ((DownloadTask)localObject1).e = 1;
      ((DownloadTask)localObject1).P = true;
      ((DownloadTask)localObject1).Q = true;
      paramAppInterface.startDownload((DownloadTask)localObject1, new AbsApolloResDownloader.5(this, paramInt, paramOnAudioDownloadListener), null);
      return;
    }
    if (paramOnAudioDownloadListener != null) {
      paramOnAudioDownloadListener.a(false, paramInt);
    }
    QLog.e(b(), 1, "downloadApolloRes null Parameters!");
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    a(paramAppRuntime, paramString, a().g(), paramInt1, paramArrayOfInt, paramInt2, paramInt3, paramBoolean);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramAppRuntime == null) {
      return;
    }
    if (paramInt1 < 0)
    {
      b(paramAppRuntime, paramString, paramOnApolloDownLoadListener, -1, paramArrayOfInt, paramInt2, paramInt3, paramBoolean);
      return;
    }
    b(paramAppRuntime, paramString, new AbsApolloResDownloader.1(this, paramOnApolloDownLoadListener, paramInt1, paramArrayOfInt, paramAppRuntime, paramBoolean), paramInt1, null, paramInt2, paramInt3, paramBoolean);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      StringBuilder localStringBuilder;
      try
      {
        String str = MD5Utils.toMD5(paramString);
      }
      catch (Exception localException)
      {
        localObject2 = b();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkDownloadFaceData e");
        localStringBuilder.append(localException);
        QLog.e((String)localObject2, 1, localStringBuilder.toString());
        localObject1 = null;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/").mkdir();
      new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/").mkdir();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(".zip");
      Object localObject1 = new File(((StringBuilder)localObject2).toString());
      if (((File)localObject1).exists())
      {
        paramAppRuntime = b();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkDownloadFaceData url data is exists:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.i(paramAppRuntime, 1, ((StringBuilder)localObject1).toString());
        if (paramOnFaceDataDownloadListener != null) {
          paramOnFaceDataDownloadListener.a(true, 0);
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = b();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkDownloadFaceData url:");
        localStringBuilder.append(paramString);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      ((File)localObject1).getParentFile().mkdir();
      localObject2 = new DownloadTask(paramString, (File)localObject1);
      ((DownloadTask)localObject2).N = true;
      ((DownloadTask)localObject2).J = true;
      ((DownloadTask)localObject2).L = "apollo_res";
      ((DownloadTask)localObject2).e = 1;
      ((DownloadTask)localObject2).P = true;
      ((DownloadTask)localObject2).Q = true;
      ApolloResDownloaderUtil.a(paramAppRuntime).startDownload((DownloadTask)localObject2, new AbsApolloResDownloader.4(this, paramString, paramOnFaceDataDownloadListener, (File)localObject1), null);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString1);
    paramString1.getParentFile().mkdirs();
    paramString2 = new DownloadTask(paramString2, paramString1);
    paramString2.N = true;
    paramString2.J = true;
    paramString2.L = "apollo_res";
    paramString2.e = 1;
    paramString2.P = true;
    paramString2.Q = true;
    ApolloResDownloaderUtil.a(paramAppRuntime).startDownload(paramString2, new AbsApolloResDownloader.3(this, paramString1), null);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, Bundle paramBundle, DownloadListener paramDownloadListener)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString1);
    paramString1.getParentFile().mkdirs();
    paramString1 = new DownloadTask(paramString2, paramString1);
    paramString1.N = true;
    paramString1.J = true;
    paramString1.L = "apollo_res";
    paramString1.e = 1;
    paramString1.P = true;
    paramString1.Q = true;
    ApolloResDownloaderUtil.a(paramAppRuntime).startDownload(paramString1, paramDownloadListener, paramBundle);
  }
  
  protected String b()
  {
    return "[cmshow][ApolloResDownloader]";
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramAppRuntime == null)
    {
      a(paramOnApolloDownLoadListener, false, paramString, paramInt1, paramArrayOfInt, paramInt2);
      QLog.e(b(), 1, "[downloadApolloRes] null Parameters!");
      return;
    }
    List localList = a(paramAppRuntime, paramString, paramInt1, paramArrayOfInt, paramInt2);
    if ((localList != null) && (!localList.isEmpty()))
    {
      DownloaderInterface localDownloaderInterface = ApolloResDownloaderUtil.a(paramAppRuntime);
      if (localDownloaderInterface == null)
      {
        a(paramOnApolloDownLoadListener, false, paramString, paramInt1, paramArrayOfInt, paramInt2);
        QLog.e(b(), 1, "[downloadApolloRes] DownloaderInterface is null!");
        return;
      }
      AtomicInteger localAtomicInteger1 = new AtomicInteger(localList.size());
      AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
      AtomicInteger localAtomicInteger3 = new AtomicInteger(0);
      int i = localList.size();
      IApolloResManager localIApolloResManager = a();
      int j = 0;
      while (j < i)
      {
        Object localObject = (AbsApolloResDownloader.ApolloLoadResTask)localList.get(j);
        int k = ((AbsApolloResDownloader.ApolloLoadResTask)localObject).a;
        int m = ((AbsApolloResDownloader.ApolloLoadResTask)localObject).b;
        localObject = localIApolloResManager.a(k, m);
        QLog.d(b(), 2, new Object[] { "[downloadApolloRes] resType = ", Integer.valueOf(k), " id = ", Integer.valueOf(m) });
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.e(b(), 1, "[downloadApolloRes] url is empty");
          localAtomicInteger1.decrementAndGet();
        }
        for (;;)
        {
          break;
          if (!a(localIApolloResManager, paramBoolean, k, m, paramInt3))
          {
            localAtomicInteger1.decrementAndGet();
          }
          else
          {
            if (!NetworkUtil.isNetworkAvailable(paramAppRuntime.getApplication()))
            {
              a(paramOnApolloDownLoadListener, false, paramString, paramInt1, paramArrayOfInt, paramInt2);
              QLog.e(b(), 1, "[downloadApolloRes] NetworkUtil.isNetworkAvailable is false!");
              return;
            }
            a(paramAppRuntime, paramString, paramOnApolloDownLoadListener, paramInt1, paramArrayOfInt, paramInt2, (String)localObject, k, m, localDownloaderInterface, localAtomicInteger1, localAtomicInteger2, localAtomicInteger3);
          }
        }
        j += 1;
      }
      if (localAtomicInteger1.get() == 0)
      {
        a(paramOnApolloDownLoadListener, true, paramString, paramInt1, paramArrayOfInt, paramInt2);
        QLog.d(b(), 2, "[downloadApolloRes] all resource ready!");
      }
      return;
    }
    a(paramOnApolloDownLoadListener, false, paramString, paramInt1, paramArrayOfInt, paramInt2);
    QLog.e(b(), 1, "[downloadApolloRes] download tasks is empty!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.downloader.AbsApolloResDownloader
 * JD-Core Version:    0.7.0.1
 */