package com.tencent.mobileqq.soload.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoConfigService;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.RelatedFileInfo;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.mobileqq.soload.entity.SoCrashInfo;
import com.tencent.mobileqq.soload.temp.api.ISoloadOtherService;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;

public class SoLoadUtils
{
  private static final ISoloadOtherService a = (ISoloadOtherService)QRoute.api(ISoloadOtherService.class);
  
  public static SoLoadInfo a(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 17);
    localBundle.putBoolean("is_sync", true);
    localBundle.putSerializable("load_param", paramLoadParam);
    localBundle.putSerializable("load_item", paramLoadItem);
    paramLoadParam = (ISoConfigService)QRoute.api(ISoConfigService.class);
    if (paramLoadParam == null) {
      paramLoadParam = SoLoadInfo.sDefault;
    }
    for (;;)
    {
      return paramLoadParam;
      paramLoadParam = paramLoadParam.getSoLoadInfoSync(localBundle);
      if ((paramLoadParam != null) && (paramLoadParam.isSuccess()) && (paramLoadParam.data != null)) {
        try
        {
          paramLoadItem = (SoLoadInfo)paramLoadParam.data.getSerializable("res");
          paramLoadParam = paramLoadItem;
          if (paramLoadItem == null)
          {
            paramLoadParam = SoLoadInfo.sDefault;
            return paramLoadParam;
          }
        }
        catch (Throwable paramLoadParam)
        {
          QLog.e("SoLoadWidget.IPC", 1, paramLoadParam, new Object[0]);
        }
      }
    }
    return SoLoadInfo.sDefault;
  }
  
  public static SoLocalInfo a(LoadParam.LoadItem paramLoadItem, @NonNull SoDetailInfo paramSoDetailInfo)
  {
    SoLocalInfo localSoLocalInfo = b(paramLoadItem, paramSoDetailInfo);
    String str = localSoLocalInfo.c;
    if ((TextUtils.isEmpty(str)) || (!new File(str).exists()))
    {
      if (a != null) {
        str = a.getResPathSync(paramLoadItem.soFileName, paramSoDetailInfo.url, paramSoDetailInfo.md5);
      }
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoDataUtil", 2, "[getLocalxxConfig] try get so from sync method");
      }
      localSoLocalInfo.c = str;
      localSoLocalInfo.jdField_a_of_type_Long = -1L;
    }
    if (paramSoDetailInfo.relatedFileInfo != null)
    {
      paramLoadItem = localSoLocalInfo.f;
      if ((TextUtils.isEmpty(paramLoadItem)) || (!new File(paramLoadItem).exists()))
      {
        if (a != null) {
          paramLoadItem = a.getResFolderPathSync(paramSoDetailInfo.relatedFileInfo.url, paramSoDetailInfo.relatedFileInfo.md5);
        }
        if (QLog.isColorLevel()) {
          QLog.i("SoLoadWidget.SoDataUtil", 2, "[getLocalxxConfig] try get rPath from sync method, rFileFolder: " + paramLoadItem);
        }
        localSoLocalInfo.f = paramLoadItem;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoDataUtil", 2, "[getLocalInfoFromCacheOrConfig] return info from cache");
    }
    return localSoLocalInfo;
  }
  
  public static SoCrashInfo a(String paramString)
  {
    return SoCrashInfo.a(SoDataUtil.a("so_crash").getString(b(paramString), ""));
  }
  
  public static SoCrashInfo a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if ((paramString1 != null) && (paramString1.jdField_a_of_type_JavaLangString.equals(paramString2))) {
      return paramString1;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("key_local_info_").append(paramString);
    if (SoDataUtil.a()) {}
    for (paramString = "_64";; paramString = "_32") {
      return paramString;
    }
  }
  
  public static void a(LoadParam.LoadItem paramLoadItem, @NonNull SoLoadInfo paramSoLoadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoDataUtil", 2, "[saveLocalInfo] Path=" + paramSoLoadInfo.soPathToLoad);
    }
    for (;;)
    {
      try
      {
        SharedPreferences localSharedPreferences = SoDataUtil.a("dynamic_so_load");
        String str1 = a(paramLoadItem.name);
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
        String str2 = paramSoLoadInfo.soDetailInfo.url;
        if (localObject != null)
        {
          localObject = ((RelatedFileInfo)localObject).url;
          if (!bool1) {
            break label206;
          }
          l = localSoLocalInfo.jdField_a_of_type_Long;
          paramLoadItem = new SoLocalInfo(paramSoLoadInfo.getVer(), paramLoadItem.name, paramSoLoadInfo.soPathToLoad, l, str2, (String)localObject, paramSoLoadInfo.rFileFolder);
          localSharedPreferences.edit().putString(str1, paramLoadItem.a()).apply();
          return;
        }
      }
      catch (Throwable paramLoadItem)
      {
        paramLoadItem.printStackTrace();
        return;
      }
      Object localObject = null;
      continue;
      label206:
      long l = IOUtil.a(new File(paramSoLoadInfo.soPathToLoad));
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
  
  public static void a(String paramString)
  {
    SharedPreferences localSharedPreferences = SoDataUtil.a("dynamic_so_load");
    paramString = a(paramString);
    localSharedPreferences.edit().remove(paramString).apply();
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, OnSoGetPathListener paramOnSoGetPathListener)
  {
    if (a != null) {
      a.getResPathAsync(paramString1, paramString2, paramBoolean, paramOnSoGetPathListener);
    }
  }
  
  public static boolean a()
  {
    return (a != null) && (a.isQQProcess());
  }
  
  private static boolean a(@NonNull SoLocalInfo paramSoLocalInfo, @NonNull SoDetailInfo paramSoDetailInfo)
  {
    if (!TextUtils.equals(paramSoDetailInfo.url, paramSoLocalInfo.d)) {}
    while ((paramSoDetailInfo.relatedFileInfo != null) && (!TextUtils.equals(paramSoDetailInfo.relatedFileInfo.url, paramSoLocalInfo.e))) {
      return false;
    }
    return true;
  }
  
  private static boolean a(@NonNull SoLocalInfo paramSoLocalInfo, @NonNull SoLoadInfo paramSoLoadInfo)
  {
    return (TextUtils.equals(paramSoLocalInfo.c, paramSoLoadInfo.soPathToLoad)) && (paramSoLocalInfo.jdField_a_of_type_Long != -1L);
  }
  
  private static boolean a(@NonNull SoLocalInfo paramSoLocalInfo, @NonNull SoLoadInfo paramSoLoadInfo, RelatedFileInfo paramRelatedFileInfo)
  {
    return (paramRelatedFileInfo == null) || (TextUtils.equals(paramSoLocalInfo.f, paramSoLoadInfo.rFileFolder));
  }
  
  public static SoLocalInfo b(LoadParam.LoadItem paramLoadItem, @NonNull SoDetailInfo paramSoDetailInfo)
  {
    try
    {
      paramLoadItem = SoLocalInfo.a(SoDataUtil.a("dynamic_so_load").getString(a(paramLoadItem.name), ""));
      boolean bool = a(paramLoadItem, paramSoDetailInfo);
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
    StringBuilder localStringBuilder = new StringBuilder().append("key_crash_info_").append(paramString);
    if (SoDataUtil.a()) {}
    for (paramString = "_64";; paramString = "_32") {
      return paramString;
    }
  }
  
  public static void b(String paramString)
  {
    SoCrashInfo localSoCrashInfo = a(paramString);
    if (localSoCrashInfo != null)
    {
      localSoCrashInfo.jdField_a_of_type_Int = 0;
      localSoCrashInfo.jdField_a_of_type_Long = 0L;
      a(localSoCrashInfo, paramString);
    }
  }
  
  public static void c(String paramString)
  {
    SoCrashInfo localSoCrashInfo = a(paramString);
    if ((localSoCrashInfo != null) && (!localSoCrashInfo.b()))
    {
      localSoCrashInfo.b = 0L;
      a(localSoCrashInfo, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.util.SoLoadUtils
 * JD-Core Version:    0.7.0.1
 */