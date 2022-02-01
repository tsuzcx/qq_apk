package com.tencent.mobileqq.soload.api.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoaderBaseCommonetService;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import com.tencent.mobileqq.soload.util.SoLoadUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

class AbsGetSoLoadInfoTask
{
  private static final Map<String, Object> j = new HashMap();
  private static ISoLoaderBaseCommonetService k = (ISoLoaderBaseCommonetService)QRoute.api(ISoLoaderBaseCommonetService.class);
  LoadParam a;
  LoadParam.LoadItem b;
  int c;
  boolean d = false;
  boolean e = true;
  String f;
  String g;
  SoDetailInfo h;
  String i;
  
  AbsGetSoLoadInfoTask(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    this.a = paramLoadParam;
    this.b = paramLoadItem;
  }
  
  static boolean a()
  {
    return SoLoadUtils.a() ^ true;
  }
  
  protected static boolean a(@NonNull SoLocalInfo paramSoLocalInfo, @NonNull SoDetailInfo paramSoDetailInfo)
  {
    return (paramSoDetailInfo.relatedFileInfo == null) || ((!TextUtils.isEmpty(paramSoLocalInfo.mRFileFolder)) && (new File(paramSoLocalInfo.mRFileFolder).exists()));
  }
  
  static boolean a(String paramString, long paramLong, LoadParam.LoadItem paramLoadItem, SoDetailInfo paramSoDetailInfo, int paramInt)
  {
    if ((paramLoadItem.lops.flag & 0x8) != 0) {
      return true;
    }
    synchronized (j)
    {
      Object localObject2 = j.get(paramLoadItem.name);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new byte[0];
        j.put(paramLoadItem.name, localObject1);
      }
      try
      {
        boolean bool = b(paramString, paramLong, paramLoadItem, paramSoDetailInfo, paramInt);
        return bool;
      }
      finally {}
    }
  }
  
  static int b()
  {
    if (!SoLoadUtils.a()) {
      return 0;
    }
    try
    {
      int m = QConfigManager.b().a(526, SoLoadUtils.b());
      return m;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SoLoadWidget.AbsGetSoTask", 1, localThrowable, new Object[0]);
    }
    return 0;
  }
  
  private static boolean b(String paramString, long paramLong, LoadParam.LoadItem paramLoadItem, SoDetailInfo paramSoDetailInfo, int paramInt)
  {
    boolean bool2 = true;
    if ((paramLong == -1L) && (paramSoDetailInfo.crc == -1L)) {
      return true;
    }
    boolean bool1;
    if (paramSoDetailInfo.crc != -1L)
    {
      paramLong = paramSoDetailInfo.crc;
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    long l = IOUtil.getCRC32Value(new File(paramString));
    if (paramLong != l)
    {
      SoLoadUtils.c(paramLoadItem.name);
      paramString = k;
      if (paramString != null)
      {
        String str1 = paramLoadItem.soFileName;
        String str2 = paramSoDetailInfo.url;
        String str3 = paramSoDetailInfo.md5;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLoadItem.name);
        localStringBuilder.append("_");
        localStringBuilder.append(paramSoDetailInfo.ver);
        if (paramString.getResPathSyncWithUnZip(str1, str2, str3, bool1, paramLong, l, localStringBuilder.toString(), paramInt)) {
          return true;
        }
      }
      bool2 = false;
    }
    return bool2;
  }
  
  @NonNull
  SoLoadInfo a(int paramInt)
  {
    SoLoadInfo localSoLoadInfo = new SoLoadInfo();
    localSoLoadInfo.curCode = paramInt;
    localSoLoadInfo.soPathToLoad = this.f;
    localSoLoadInfo.subErrCode = this.c;
    localSoLoadInfo.isFinishDownload = this.d;
    localSoLoadInfo.isNeedDownload = this.e;
    localSoLoadInfo.soDetailInfo = this.h;
    localSoLoadInfo.rFileFolder = this.g;
    localSoLoadInfo.failDetail = this.i;
    return localSoLoadInfo;
  }
  
  boolean a(SoInfo paramSoInfo)
  {
    if (paramSoInfo != null)
    {
      if (SoDataUtil.c()) {
        localObject = paramSoInfo.arm64Info;
      } else {
        localObject = paramSoInfo.arm32Info;
      }
      this.h = ((SoDetailInfo)localObject);
    }
    Object localObject = this.h;
    boolean bool;
    if ((localObject != null) && (!TextUtils.isEmpty(((SoDetailInfo)localObject).url))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[initConfig] isConfValid=");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(",info:");
      ((StringBuilder)localObject).append(paramSoInfo);
      ((StringBuilder)localObject).append(",is64:");
      ((StringBuilder)localObject).append(SoDataUtil.c());
      QLog.i("SoLoadWidget.AbsGetSoTask", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  protected boolean a(@NonNull SoLocalInfo paramSoLocalInfo)
  {
    return (!TextUtils.isEmpty(paramSoLocalInfo.mSoPath)) && (new File(paramSoLocalInfo.mSoPath).exists());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.AbsGetSoLoadInfoTask
 * JD-Core Version:    0.7.0.1
 */