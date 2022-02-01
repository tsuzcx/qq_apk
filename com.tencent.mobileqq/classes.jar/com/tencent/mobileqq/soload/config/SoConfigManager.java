package com.tencent.mobileqq.soload.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadConfBean;
import com.tencent.mobileqq.soload.entity.SoConfig;
import com.tencent.mobileqq.soload.entity.SoCrashInfo;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import com.tencent.mobileqq.soload.util.SoLoadUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SoConfigManager
{
  private static volatile SoConfigManager jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfigManager;
  SoConfig jdField_a_of_type_ComTencentMobileqqSoloadEntitySoConfig;
  
  private SoConfigManager()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoConfigManager", 2, "SoConfigManager init");
    }
    QLog.i("SoLoadWidget.SoConfigManager", 2, "---isQQProcess1---");
    if (SoLoadUtils.a()) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadEntitySoConfig = SoConfig.readConfig();
    }
  }
  
  private SoInfo a(String paramString)
  {
    SoConfig localSoConfig = this.jdField_a_of_type_ComTencentMobileqqSoloadEntitySoConfig;
    if ((localSoConfig != null) && (localSoConfig.mSoInfos != null)) {
      return (SoInfo)this.jdField_a_of_type_ComTencentMobileqqSoloadEntitySoConfig.mSoInfos.get(paramString);
    }
    return null;
  }
  
  public static SoConfigManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfigManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfigManager == null) {
          jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfigManager = new SoConfigManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfigManager;
  }
  
  public static boolean a(SoCrashInfo paramSoCrashInfo)
  {
    if (paramSoCrashInfo != null)
    {
      if (paramSoCrashInfo.d()) {
        return Math.abs(NetConnInfoCenter.getServerTimeMillis() - SoDataUtil.a()) < 600000L;
      }
      if (paramSoCrashInfo.a()) {
        return Math.abs(NetConnInfoCenter.getServerTimeMillis() - SoDataUtil.a()) < 1800000L;
      }
    }
    return Math.abs(NetConnInfoCenter.getServerTimeMillis() - SoDataUtil.a()) < 600000L;
  }
  
  public SoInfo a(String paramString, SoConfigManager.OnGetSoInfoListener paramOnGetSoInfoListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSoInfo, name=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",isSync=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", SoConfig=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqSoloadEntitySoConfig);
      QLog.i("SoLoadWidget.SoConfigManager", 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqSoloadEntitySoConfig.isValid(paramString))
    {
      if (paramBoolean) {
        return null;
      }
      ((SoLoaderConfProcessor)QConfigManager.a().a(526)).a(new SoConfigManager.1(this, paramOnGetSoInfoListener, paramString));
      return null;
    }
    if (paramBoolean) {
      return a(paramString);
    }
    if (paramOnGetSoInfoListener != null) {
      paramOnGetSoInfoListener.a(0, a(paramString));
    }
    return null;
  }
  
  @Deprecated
  public Map<String, SoInfo> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSoloadEntitySoConfig.mSoInfos;
  }
  
  public Set<String> a()
  {
    SoConfig localSoConfig = this.jdField_a_of_type_ComTencentMobileqqSoloadEntitySoConfig;
    if (localSoConfig != null) {
      return localSoConfig.mSoInfos.keySet();
    }
    return new HashSet();
  }
  
  public void a(SoLoadConfBean paramSoLoadConfBean)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadEntitySoConfig.update(paramSoLoadConfBean);
  }
  
  public void a(String paramString, SoCrashInfo paramSoCrashInfo, SoConfigManager.OnGetSoInfoListener paramOnGetSoInfoListener)
  {
    if (a(paramSoCrashInfo))
    {
      if (paramOnGetSoInfoListener != null) {
        paramOnGetSoInfoListener.a(0, a(paramString));
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramSoCrashInfo = new StringBuilder();
        paramSoCrashInfo.append("[getNewestConfig], name=");
        paramSoCrashInfo.append(paramString);
        QLog.i("SoLoadWidget.SoConfigManager", 2, paramSoCrashInfo.toString());
      }
      ((SoLoaderConfProcessor)QConfigManager.a().a(526)).a(new SoConfigManager.2(this, paramOnGetSoInfoListener, paramString), false);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    SoInfo localSoInfo = a(paramString1);
    if ((localSoInfo != null) && (TextUtils.equals(localSoInfo.ver, paramString2)))
    {
      this.jdField_a_of_type_ComTencentMobileqqSoloadEntitySoConfig.mSoInfos.remove(paramString1);
      this.jdField_a_of_type_ComTencentMobileqqSoloadEntitySoConfig.saveConfig(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.config.SoConfigManager
 * JD-Core Version:    0.7.0.1
 */