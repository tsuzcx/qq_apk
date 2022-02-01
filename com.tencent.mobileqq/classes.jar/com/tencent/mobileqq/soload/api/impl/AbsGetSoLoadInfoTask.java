package com.tencent.mobileqq.soload.api.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.mobileqq.soload.temp.api.ISoloadOtherService;
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
  private static ISoloadOtherService jdField_a_of_type_ComTencentMobileqqSoloadTempApiISoloadOtherService = (ISoloadOtherService)QRoute.api(ISoloadOtherService.class);
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
    return !SoLoadUtils.a();
  }
  
  protected static boolean a(@NonNull SoLocalInfo paramSoLocalInfo)
  {
    return (!TextUtils.isEmpty(paramSoLocalInfo.c)) && (new File(paramSoLocalInfo.c).exists());
  }
  
  protected static boolean a(@NonNull SoLocalInfo paramSoLocalInfo, @NonNull SoDetailInfo paramSoDetailInfo)
  {
    return (paramSoDetailInfo.relatedFileInfo == null) || ((!TextUtils.isEmpty(paramSoLocalInfo.f)) && (new File(paramSoLocalInfo.f).exists()));
  }
  
  static boolean a(String paramString, long paramLong, LoadParam.LoadItem paramLoadItem, SoDetailInfo paramSoDetailInfo, int paramInt)
  {
    if ((paramLoadItem.lops.flag & 0x8) != 0) {
      return true;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        Object localObject = jdField_a_of_type_JavaUtilMap.get(paramLoadItem.name);
        if (localObject == null)
        {
          localObject = new byte[0];
          jdField_a_of_type_JavaUtilMap.put(paramLoadItem.name, localObject);
          try
          {
            boolean bool = b(paramString, paramLong, paramLoadItem, paramSoDetailInfo, paramInt);
            return bool;
          }
          finally {}
        }
      }
    }
  }
  
  private static boolean b(String paramString, long paramLong, LoadParam.LoadItem paramLoadItem, SoDetailInfo paramSoDetailInfo, int paramInt)
  {
    if ((paramLong == -1L) && (paramSoDetailInfo.crc == -1L)) {
      return true;
    }
    boolean bool = false;
    if (paramSoDetailInfo.crc != -1L)
    {
      paramLong = paramSoDetailInfo.crc;
      bool = true;
    }
    for (;;)
    {
      long l = IOUtil.getCRC32Value(new File(paramString));
      if (paramLong == l) {
        break label148;
      }
      SoLoadUtils.a(paramLoadItem.name);
      if ((jdField_a_of_type_ComTencentMobileqqSoloadTempApiISoloadOtherService == null) || (!jdField_a_of_type_ComTencentMobileqqSoloadTempApiISoloadOtherService.getResPathSyncWithUnZip(paramLoadItem.soFileName, paramSoDetailInfo.url, paramSoDetailInfo.md5, bool, paramLong, l, paramLoadItem.name + "_" + paramSoDetailInfo.ver, paramInt))) {
        break;
      }
      return true;
    }
    return false;
    label148:
    return true;
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
    SoDetailInfo localSoDetailInfo;
    if (paramSoInfo != null)
    {
      if (SoDataUtil.a())
      {
        localSoDetailInfo = paramSoInfo.arm64Info;
        this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo = localSoDetailInfo;
      }
    }
    else {
      if ((this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntitySoDetailInfo.url))) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.AbsGetSoTask", 2, "[initConfig] isConfValid=" + bool + ",info:" + paramSoInfo + ",is64:" + SoDataUtil.a());
      }
      return bool;
      localSoDetailInfo = paramSoInfo.arm32Info;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.AbsGetSoLoadInfoTask
 * JD-Core Version:    0.7.0.1
 */