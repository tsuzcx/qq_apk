package com.tencent.mobileqq.soload.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoConfigService;
import com.tencent.mobileqq.soload.api.ISoLoaderBaseCommonetService;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.RelatedFileInfo;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.mobileqq.soload.entity.SoCrashInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SoLoadUtils
{
  private static final ISoLoaderBaseCommonetService a = (ISoLoaderBaseCommonetService)QRoute.api(ISoLoaderBaseCommonetService.class);
  
  public static SoLoadInfo a(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 17);
    localBundle.putBoolean("is_sync", true);
    localBundle.putSerializable("load_param", paramLoadParam);
    localBundle.putSerializable("load_item", paramLoadItem);
    paramLoadParam = (ISoConfigService)QRoute.api(ISoConfigService.class);
    if (paramLoadParam == null) {
      return SoLoadInfo.sDefault;
    }
    paramLoadParam = paramLoadParam.getSoLoadInfoSync(localBundle);
    if ((paramLoadParam != null) && (paramLoadParam.isSuccess()) && (paramLoadParam.data != null)) {
      try
      {
        paramLoadItem = (SoLoadInfo)paramLoadParam.data.getSerializable("res");
        paramLoadParam = paramLoadItem;
        if (paramLoadItem == null) {
          paramLoadParam = SoLoadInfo.sDefault;
        }
        return paramLoadParam;
      }
      catch (Throwable paramLoadParam)
      {
        QLog.e("SoLoadWidget.IPC", 1, paramLoadParam, new Object[0]);
      }
    }
    return SoLoadInfo.sDefault;
  }
  
  public static SoLocalInfo a(LoadParam.LoadItem paramLoadItem, @NonNull SoDetailInfo paramSoDetailInfo)
  {
    paramLoadItem = c(paramLoadItem, paramSoDetailInfo);
    paramLoadItem.mRFileFolder = a(paramLoadItem, paramSoDetailInfo);
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoDataUtil", 2, "[getLocalInfoFromCacheOrConfig] return info from cache");
    }
    return paramLoadItem;
  }
  
  public static SoCrashInfo a(String paramString1, String paramString2)
  {
    paramString1 = d(paramString1);
    if ((paramString1 != null) && (paramString1.a.equals(paramString2))) {
      return paramString1;
    }
    return null;
  }
  
  private static String a(SoLocalInfo paramSoLocalInfo, SoDetailInfo paramSoDetailInfo)
  {
    paramSoLocalInfo = paramSoLocalInfo.mRFileFolder;
    Object localObject = paramSoLocalInfo;
    if (paramSoDetailInfo.relatedFileInfo != null) {
      if (!TextUtils.isEmpty(paramSoLocalInfo))
      {
        localObject = paramSoLocalInfo;
        if (new File(paramSoLocalInfo).exists()) {}
      }
      else
      {
        localObject = a;
        if (localObject != null) {
          paramSoLocalInfo = ((ISoLoaderBaseCommonetService)localObject).getResFolderPathSync(paramSoDetailInfo.relatedFileInfo.url, paramSoDetailInfo.relatedFileInfo.md5);
        }
        localObject = paramSoLocalInfo;
        if (QLog.isColorLevel())
        {
          paramSoDetailInfo = new StringBuilder();
          paramSoDetailInfo.append("[getLocalxxConfig] try get rPath from sync method, rFileFolder: ");
          paramSoDetailInfo.append(paramSoLocalInfo);
          QLog.i("SoLoadWidget.SoDataUtil", 2, paramSoDetailInfo.toString());
          localObject = paramSoLocalInfo;
        }
      }
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_local_info_");
    localStringBuilder.append(paramString);
    if (SoDataUtil.c()) {
      paramString = "_64";
    } else {
      paramString = "_32";
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static List<File> a(ClassLoader paramClassLoader)
  {
    Field localField2;
    try
    {
      Field localField1 = ReflectUtil.a(paramClassLoader, "pathList");
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      localNoSuchFieldException1.printStackTrace();
      localField2 = null;
    }
    try
    {
      paramClassLoader = localField2.get(paramClassLoader);
    }
    catch (IllegalAccessException paramClassLoader)
    {
      paramClassLoader.printStackTrace();
      paramClassLoader = null;
    }
    List localList;
    try
    {
      localField2 = ReflectUtil.a(paramClassLoader, "nativeLibraryDirectories");
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      localNoSuchFieldException2.printStackTrace();
      localList = null;
    }
    try
    {
      localList = (List)localList.get(paramClassLoader);
      try
      {
        localList.addAll((List)ReflectUtil.a(paramClassLoader, "systemNativeLibraryDirectories").get(paramClassLoader));
        return localList;
      }
      catch (NoSuchFieldException paramClassLoader) {}catch (IllegalAccessException paramClassLoader) {}
      paramClassLoader.printStackTrace();
    }
    catch (NoSuchFieldException paramClassLoader)
    {
      localList = null;
      paramClassLoader.printStackTrace();
      return localList;
    }
    catch (IllegalAccessException paramClassLoader)
    {
      localList = null;
    }
    return localList;
  }
  
  public static void a(LoadParam.LoadItem paramLoadItem, @NonNull SoLoadInfo paramSoLoadInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[saveLocalInfo] Path=");
      ((StringBuilder)localObject).append(paramSoLoadInfo.soPathToLoad);
      QLog.d("SoLoadWidget.SoDataUtil", 2, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        SoLocalInfo localSoLocalInfo = b(paramLoadItem, paramSoLoadInfo.soDetailInfo);
        localObject = paramSoLoadInfo.soDetailInfo.relatedFileInfo;
        boolean bool1 = a(localSoLocalInfo, paramSoLoadInfo);
        boolean bool2 = a(localSoLocalInfo, paramSoLoadInfo, (RelatedFileInfo)localObject);
        if ((bool1) && (bool2)) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("SoLoadWidget.SoDataUtil", 2, "[saveLocalInfo] need cal crc or save!");
        }
        str = paramSoLoadInfo.soDetailInfo.url;
        if (localObject == null) {
          break label228;
        }
        localObject = ((RelatedFileInfo)localObject).url;
        if (bool1) {
          l = localSoLocalInfo.mSoCRC;
        } else {
          l = IOUtil.a(new File(paramSoLoadInfo.soPathToLoad));
        }
      }
      catch (Throwable paramLoadItem)
      {
        String str;
        long l;
        paramLoadItem.printStackTrace();
        return;
      }
      paramSoLoadInfo = new SoLocalInfo(paramSoLoadInfo.getVer(), paramLoadItem.name, paramSoLoadInfo.soPathToLoad, l, str, (String)localObject, paramSoLoadInfo.rFileFolder);
      SoDataUtil.a("dynamic_so_load").edit().putString(a(paramLoadItem.name), paramSoLoadInfo.encode()).apply();
      return;
      label228:
      localObject = null;
    }
  }
  
  public static void a(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem, OnGetSoLoadInfoListener paramOnGetSoLoadInfoListener)
  {
    ISoConfigService localISoConfigService = (ISoConfigService)QRoute.api(ISoConfigService.class);
    if (localISoConfigService != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("oper_type", 17);
      localBundle.putBoolean("is_sync", false);
      localBundle.putSerializable("load_param", paramLoadParam);
      localBundle.putSerializable("load_item", paramLoadItem);
      localISoConfigService.getSoLoadInfoAsync(localBundle, paramOnGetSoLoadInfoListener);
    }
  }
  
  public static void a(SoCrashInfo paramSoCrashInfo, String paramString)
  {
    SharedPreferences localSharedPreferences = SoDataUtil.a("so_crash");
    paramString = b(paramString);
    localSharedPreferences.edit().putString(paramString, paramSoCrashInfo.a()).apply();
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, OnSoGetPathListener paramOnSoGetPathListener)
  {
    ISoLoaderBaseCommonetService localISoLoaderBaseCommonetService = a;
    if (localISoLoaderBaseCommonetService != null) {
      localISoLoaderBaseCommonetService.getResPathAsync(paramString1, paramString2, paramBoolean, paramOnSoGetPathListener);
    }
  }
  
  public static boolean a()
  {
    ISoLoaderBaseCommonetService localISoLoaderBaseCommonetService = a;
    return (localISoLoaderBaseCommonetService != null) && (localISoLoaderBaseCommonetService.isQQProcess());
  }
  
  private static boolean a(@NonNull SoLocalInfo paramSoLocalInfo, @NonNull SoLoadInfo paramSoLoadInfo)
  {
    return (TextUtils.equals(paramSoLocalInfo.mSoPath, paramSoLoadInfo.soPathToLoad)) && (paramSoLocalInfo.mSoCRC != -1L);
  }
  
  private static boolean a(@NonNull SoLocalInfo paramSoLocalInfo, @NonNull SoLoadInfo paramSoLoadInfo, RelatedFileInfo paramRelatedFileInfo)
  {
    return (paramRelatedFileInfo == null) || (TextUtils.equals(paramSoLocalInfo.mRFileFolder, paramSoLoadInfo.rFileFolder));
  }
  
  public static long b()
  {
    return MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin();
  }
  
  public static SoLocalInfo b(LoadParam.LoadItem paramLoadItem, @NonNull SoDetailInfo paramSoDetailInfo)
  {
    try
    {
      paramLoadItem = SoLocalInfo.createSoLocalInfo(SoDataUtil.a("dynamic_so_load").getString(a(paramLoadItem.name), ""));
      boolean bool = b(paramLoadItem, paramSoDetailInfo);
      if (bool) {
        return paramLoadItem;
      }
    }
    catch (Throwable paramLoadItem)
    {
      QLog.e("SoLoadWidget.SoDataUtil", 1, paramLoadItem, new Object[0]);
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoDataUtil", 2, "[getLocalInfoFromCache] no cache, use default!");
      }
    }
    return new SoLocalInfo();
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_crash_info_");
    localStringBuilder.append(paramString);
    if (SoDataUtil.c()) {
      paramString = "_64";
    } else {
      paramString = "_32";
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static boolean b(@NonNull SoLocalInfo paramSoLocalInfo, @NonNull SoDetailInfo paramSoDetailInfo)
  {
    if (!TextUtils.equals(paramSoDetailInfo.url, paramSoLocalInfo.mUrl)) {
      return false;
    }
    return (paramSoDetailInfo.relatedFileInfo == null) || (TextUtils.equals(paramSoDetailInfo.relatedFileInfo.url, paramSoLocalInfo.mRFileUrl));
  }
  
  private static SoLocalInfo c(LoadParam.LoadItem paramLoadItem, @NonNull SoDetailInfo paramSoDetailInfo)
  {
    SoLocalInfo localSoLocalInfo = b(paramLoadItem, paramSoDetailInfo);
    String str = localSoLocalInfo.mSoPath;
    if ((TextUtils.isEmpty(str)) || (!new File(str).exists()))
    {
      ISoLoaderBaseCommonetService localISoLoaderBaseCommonetService = a;
      if (localISoLoaderBaseCommonetService != null) {
        str = localISoLoaderBaseCommonetService.getResPathSync(paramLoadItem.soFileName, paramSoDetailInfo.url, paramSoDetailInfo.md5);
      }
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoDataUtil", 2, "[getLocalConfig] try get so from sync method");
      }
      localSoLocalInfo.mSoPath = str;
      localSoLocalInfo.mSoCRC = -1L;
    }
    return localSoLocalInfo;
  }
  
  public static void c(String paramString)
  {
    SharedPreferences localSharedPreferences = SoDataUtil.a("dynamic_so_load");
    paramString = a(paramString);
    localSharedPreferences.edit().remove(paramString).apply();
  }
  
  public static SoCrashInfo d(String paramString)
  {
    return SoCrashInfo.a(SoDataUtil.a("so_crash").getString(b(paramString), ""));
  }
  
  public static void e(String paramString)
  {
    SoCrashInfo localSoCrashInfo = d(paramString);
    if (localSoCrashInfo != null)
    {
      localSoCrashInfo.b = 0;
      localSoCrashInfo.c = 0L;
      a(localSoCrashInfo, paramString);
    }
  }
  
  public static void f(String paramString)
  {
    SoCrashInfo localSoCrashInfo = d(paramString);
    if ((localSoCrashInfo != null) && (!localSoCrashInfo.c()))
    {
      localSoCrashInfo.e = 0L;
      a(localSoCrashInfo, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.util.SoLoadUtils
 * JD-Core Version:    0.7.0.1
 */