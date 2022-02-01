package com.tencent.mobileqq.miniapp;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MiniAppInfoManager
{
  Map<String, MiniAppInfo> a = new ConcurrentHashMap();
  
  MiniAppInfo a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    MiniAppInfo localMiniAppInfo = (MiniAppInfo)this.a.get(paramString);
    if ((localMiniAppInfo != null) && (paramBoolean)) {
      if (!a(localMiniAppInfo, paramInt1, paramInt2)) {}
    }
    while (!QLog.isColorLevel())
    {
      return localMiniAppInfo;
      return null;
    }
    QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache invalid. cacheKey=", paramString });
    return localMiniAppInfo;
  }
  
  void a(MiniAppInfo paramMiniAppInfo, int paramInt, MiniAppInfoManager.MiniAppInfoCallback paramMiniAppInfoCallback)
  {
    ThreadManagerV2.excute(new MiniAppInfoManager.1(this, paramMiniAppInfoCallback, paramMiniAppInfo, paramInt), 128, null, true);
  }
  
  boolean a(MiniAppInfo paramMiniAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyAppInfo. appState=", Integer.valueOf(paramMiniAppInfo.jdField_c_of_type_Int) });
    }
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.jdField_c_of_type_Int == 1);
  }
  
  boolean a(MiniAppInfo paramMiniAppInfo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache valid. cacheKey=", paramMiniAppInfo.h });
    }
    if (paramInt2 == 1)
    {
      if (paramMiniAppInfo.jdField_c_of_type_Long <= NetConnInfoCenter.getServerTimeMillis()) {}
    }
    else {
      while ((paramInt2 == 0) && (((paramInt1 == 1) && (paramMiniAppInfo.a > NetConnInfoCenter.getServerTimeMillis())) || ((paramInt1 == 2) && (paramMiniAppInfo.b > NetConnInfoCenter.getServerTimeMillis())))) {
        return true;
      }
    }
    return false;
  }
  
  boolean b(MiniAppInfo paramMiniAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyDownloadUrl. downloadUrl=", paramMiniAppInfo.f });
    }
    return !TextUtils.isEmpty(paramMiniAppInfo.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppInfoManager
 * JD-Core Version:    0.7.0.1
 */