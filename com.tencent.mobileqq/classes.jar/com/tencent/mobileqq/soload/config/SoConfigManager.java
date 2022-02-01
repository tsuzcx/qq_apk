package com.tencent.mobileqq.soload.config;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadConfBean;
import com.tencent.mobileqq.soload.entity.SoConfig;
import com.tencent.mobileqq.soload.entity.SoCrashInfo;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import com.tencent.mobileqq.soload.util.SoLoadUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class SoConfigManager
{
  private static volatile SoConfigManager b;
  SoConfig a;
  
  private SoConfigManager()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoConfigManager", 2, "SoConfigManager init");
    }
    if (SoLoadUtils.a()) {
      this.a = SoConfig.readConfig();
    }
  }
  
  private SoInfo a(String paramString)
  {
    SoConfig localSoConfig = this.a;
    if ((localSoConfig != null) && (localSoConfig.mSoInfos != null)) {
      return (SoInfo)this.a.mSoInfos.get(paramString);
    }
    return null;
  }
  
  public static SoConfigManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new SoConfigManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static boolean a(SoCrashInfo paramSoCrashInfo)
  {
    if (paramSoCrashInfo != null)
    {
      if (paramSoCrashInfo.e()) {
        return Math.abs(NetConnInfoCenter.getServerTimeMillis() - SoDataUtil.a()) < 600000L;
      }
      if (paramSoCrashInfo.b()) {
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
      localStringBuilder.append(this.a);
      QLog.i("SoLoadWidget.SoConfigManager", 2, localStringBuilder.toString());
    }
    if (!this.a.isValid(paramString))
    {
      if (paramBoolean) {
        return null;
      }
      ((SoLoaderConfProcessor)QConfigManager.b().a(526)).a(new SoConfigManager.1(this, paramOnGetSoInfoListener, paramString));
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
  
  public void a(SoLoadConfBean paramSoLoadConfBean)
  {
    this.a.update(paramSoLoadConfBean);
    ((IHippyLibrary)QRoute.api(IHippyLibrary.class)).downloadWhenSoInfoUpdated();
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
      ((SoLoaderConfProcessor)QConfigManager.b().a(526)).a(new SoConfigManager.2(this, paramOnGetSoInfoListener, paramString), false);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    SoInfo localSoInfo = a(paramString1);
    if ((localSoInfo != null) && (TextUtils.equals(localSoInfo.ver, paramString2)))
    {
      this.a.mSoInfos.remove(paramString1);
      this.a.saveConfig(true);
    }
  }
  
  @Deprecated
  public Map<String, SoInfo> b()
  {
    return this.a.mSoInfos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.config.SoConfigManager
 * JD-Core Version:    0.7.0.1
 */