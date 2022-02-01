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
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

public class SoLoadUtils
{
  private static final ISoLoaderBaseCommonetService a = (ISoLoaderBaseCommonetService)QRoute.api(ISoLoaderBaseCommonetService.class);
  
  public static int a(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
  {
    a(paramFileChannel, paramByteBuffer, 2, paramLong);
    return paramByteBuffer.getShort() & 0xFFFF;
  }
  
  public static long a(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
  {
    a(paramFileChannel, paramByteBuffer, 8, paramLong);
    return paramByteBuffer.getLong();
  }
  
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
    SoLocalInfo localSoLocalInfo = b(paramLoadItem, paramSoDetailInfo);
    Object localObject = localSoLocalInfo.mSoPath;
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!new File((String)localObject).exists()))
    {
      ISoLoaderBaseCommonetService localISoLoaderBaseCommonetService = a;
      if (localISoLoaderBaseCommonetService != null) {
        localObject = localISoLoaderBaseCommonetService.getResPathSync(paramLoadItem.soFileName, paramSoDetailInfo.url, paramSoDetailInfo.md5);
      }
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoDataUtil", 2, "[getLocalxxConfig] try get so from sync method");
      }
      localSoLocalInfo.mSoPath = ((String)localObject);
      localSoLocalInfo.mSoCRC = -1L;
    }
    if (paramSoDetailInfo.relatedFileInfo != null)
    {
      paramLoadItem = localSoLocalInfo.mRFileFolder;
      if ((TextUtils.isEmpty(paramLoadItem)) || (!new File(paramLoadItem).exists()))
      {
        localObject = a;
        if (localObject != null) {
          paramLoadItem = ((ISoLoaderBaseCommonetService)localObject).getResFolderPathSync(paramSoDetailInfo.relatedFileInfo.url, paramSoDetailInfo.relatedFileInfo.md5);
        }
        if (QLog.isColorLevel())
        {
          paramSoDetailInfo = new StringBuilder();
          paramSoDetailInfo.append("[getLocalxxConfig] try get rPath from sync method, rFileFolder: ");
          paramSoDetailInfo.append(paramLoadItem);
          QLog.i("SoLoadWidget.SoDataUtil", 2, paramSoDetailInfo.toString());
        }
        localSoLocalInfo.mRFileFolder = paramLoadItem;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_local_info_");
    localStringBuilder.append(paramString);
    if (SoDataUtil.a()) {
      paramString = "_64";
    } else {
      paramString = "_32";
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = a(paramFileChannel, paramByteBuffer, paramLong);
      if (i == 0) {
        break;
      }
      localStringBuilder.append((char)i);
      paramLong = 1L + paramLong;
    }
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
  
  public static short a(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
  {
    a(paramFileChannel, paramByteBuffer, 1, paramLong);
    return (short)(paramByteBuffer.get() & 0xFF);
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
        localSharedPreferences = SoDataUtil.a("dynamic_so_load");
        str1 = a(paramLoadItem.name);
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
        str2 = paramSoLoadInfo.soDetailInfo.url;
        if (localObject == null) {
          break label238;
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
        SharedPreferences localSharedPreferences;
        String str1;
        String str2;
        long l;
        paramLoadItem.printStackTrace();
        return;
      }
      paramLoadItem = new SoLocalInfo(paramSoLoadInfo.getVer(), paramLoadItem.name, paramSoLoadInfo.soPathToLoad, l, str2, (String)localObject, paramSoLoadInfo.rFileFolder);
      localSharedPreferences.edit().putString(str1, paramLoadItem.encode()).apply();
      return;
      label238:
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
  
  public static void a(String paramString)
  {
    SharedPreferences localSharedPreferences = SoDataUtil.a("dynamic_so_load");
    paramString = a(paramString);
    localSharedPreferences.edit().remove(paramString).apply();
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, OnSoGetPathListener paramOnSoGetPathListener)
  {
    ISoLoaderBaseCommonetService localISoLoaderBaseCommonetService = a;
    if (localISoLoaderBaseCommonetService != null) {
      localISoLoaderBaseCommonetService.getResPathAsync(paramString1, paramString2, paramBoolean, paramOnSoGetPathListener);
    }
  }
  
  public static void a(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    paramByteBuffer.position(0);
    paramByteBuffer.limit(paramInt);
    while (paramByteBuffer.remaining() > 0)
    {
      paramInt = paramFileChannel.read(paramByteBuffer, paramLong);
      if (paramInt == -1) {
        break;
      }
      paramLong += paramInt;
    }
    if (paramByteBuffer.remaining() <= 0)
    {
      paramByteBuffer.position(0);
      return;
    }
    paramFileChannel = new RuntimeException("ELF file truncated");
    for (;;)
    {
      throw paramFileChannel;
    }
  }
  
  public static boolean a()
  {
    ISoLoaderBaseCommonetService localISoLoaderBaseCommonetService = a;
    return (localISoLoaderBaseCommonetService != null) && (localISoLoaderBaseCommonetService.isQQProcess());
  }
  
  private static boolean a(@NonNull SoLocalInfo paramSoLocalInfo, @NonNull SoDetailInfo paramSoDetailInfo)
  {
    if (!TextUtils.equals(paramSoDetailInfo.url, paramSoLocalInfo.mUrl)) {
      return false;
    }
    return (paramSoDetailInfo.relatedFileInfo == null) || (TextUtils.equals(paramSoDetailInfo.relatedFileInfo.url, paramSoLocalInfo.mRFileUrl));
  }
  
  private static boolean a(@NonNull SoLocalInfo paramSoLocalInfo, @NonNull SoLoadInfo paramSoLoadInfo)
  {
    return (TextUtils.equals(paramSoLocalInfo.mSoPath, paramSoLoadInfo.soPathToLoad)) && (paramSoLocalInfo.mSoCRC != -1L);
  }
  
  private static boolean a(@NonNull SoLocalInfo paramSoLocalInfo, @NonNull SoLoadInfo paramSoLoadInfo, RelatedFileInfo paramRelatedFileInfo)
  {
    return (paramRelatedFileInfo == null) || (TextUtils.equals(paramSoLocalInfo.mRFileFolder, paramSoLoadInfo.rFileFolder));
  }
  
  public static long b(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
  {
    a(paramFileChannel, paramByteBuffer, 4, paramLong);
    return paramByteBuffer.getInt() & 0xFFFFFFFF;
  }
  
  public static SoLocalInfo b(LoadParam.LoadItem paramLoadItem, @NonNull SoDetailInfo paramSoDetailInfo)
  {
    try
    {
      paramLoadItem = SoLocalInfo.createSoLocalInfo(SoDataUtil.a("dynamic_so_load").getString(a(paramLoadItem.name), ""));
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_crash_info_");
    localStringBuilder.append(paramString);
    if (SoDataUtil.a()) {
      paramString = "_64";
    } else {
      paramString = "_32";
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.util.SoLoadUtils
 * JD-Core Version:    0.7.0.1
 */