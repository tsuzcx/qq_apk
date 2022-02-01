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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class AbsGetSoLoadInfoTask
{
  private static ISoLoaderBaseCommonetService jdField_a_of_type_ComTencentMobileqqSoloadApiISoLoaderBaseCommonetService = (ISoLoaderBaseCommonetService)QRoute.api(ISoLoaderBaseCommonetService.class);
  private static final Map<String, Object> jdField_a_of_type_JavaUtilMap = new HashMap();
  int jdField_a_of_type_Int;
  LoadParam.LoadItem jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem;
  LoadParam jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam;
  SoDetailInfo jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = true;
  String c;
  
  AbsGetSoLoadInfoTask(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam = paramLoadParam;
    this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam$LoadItem = paramLoadItem;
  }
  
  static int a()
  {
    if (!SoLoadUtils.a()) {
      return 0;
    }
    try
    {
      int i = QConfigManager.a().a(526, MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin());
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SoLoadWidget.AbsGetSoTask", 1, localThrowable, new Object[0]);
    }
    return 0;
  }
  
  static boolean a()
  {
    return SoLoadUtils.a() ^ true;
  }
  
  protected static boolean a(@NonNull SoLocalInfo paramSoLocalInfo)
  {
    return (!TextUtils.isEmpty(paramSoLocalInfo.mSoPath)) && (new File(paramSoLocalInfo.mSoPath).exists());
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
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      Object localObject2 = jdField_a_of_type_JavaUtilMap.get(paramLoadItem.name);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new byte[0];
        jdField_a_of_type_JavaUtilMap.put(paramLoadItem.name, localObject1);
      }
      try
      {
        boolean bool = b(paramString, paramLong, paramLoadItem, paramSoDetailInfo, paramInt);
        return bool;
      }
      finally {}
    }
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
      SoLoadUtils.a(paramLoadItem.name);
      paramString = jdField_a_of_type_ComTencentMobileqqSoloadApiISoLoaderBaseCommonetService;
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
    localSoLoadInfo.soPathToLoad = this.jdField_a_of_type_JavaLangString;
    localSoLoadInfo.subErrCode = this.jdField_a_of_type_Int;
    localSoLoadInfo.isFinishDownload = this.jdField_a_of_type_Boolean;
    localSoLoadInfo.isNeedDownload = this.jdField_b_of_type_Boolean;
    localSoLoadInfo.soDetailInfo = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo;
    localSoLoadInfo.rFileFolder = this.jdField_b_of_type_JavaLangString;
    localSoLoadInfo.failDetail = this.c;
    return localSoLoadInfo;
  }
  
  boolean a(SoInfo paramSoInfo)
  {
    if (paramSoInfo != null)
    {
      if (SoDataUtil.a()) {
        localObject = paramSoInfo.arm64Info;
      } else {
        localObject = paramSoInfo.arm32Info;
      }
      this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo = ((SoDetailInfo)localObject);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo;
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
      ((StringBuilder)localObject).append(SoDataUtil.a());
      QLog.i("SoLoadWidget.AbsGetSoTask", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.AbsGetSoLoadInfoTask
 * JD-Core Version:    0.7.0.1
 */