package com.tencent.qqperf.opt.suspendthread;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class LowEndPerfProcessor
  extends IQConfigProcessor<LowEndPerfBean>
{
  public static LowEndPerfBean a()
  {
    LowEndPerfBean localLowEndPerfBean2 = (LowEndPerfBean)QConfigManager.b().b(581);
    LowEndPerfBean localLowEndPerfBean1 = localLowEndPerfBean2;
    if (localLowEndPerfBean2 == null) {
      localLowEndPerfBean1 = new LowEndPerfBean();
    }
    return localLowEndPerfBean1;
  }
  
  @NonNull
  public LowEndPerfBean a(int paramInt)
  {
    return new LowEndPerfBean();
  }
  
  @Nullable
  public LowEndPerfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      LowEndPerfBean localLowEndPerfBean = LowEndPerfBean.a(paramArrayOfQConfItem[0].b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("Perf", 2, localStringBuilder.toString());
      }
      return localLowEndPerfBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(LowEndPerfBean paramLowEndPerfBean)
  {
    if (paramLowEndPerfBean == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdate ");
      ((StringBuilder)localObject).append(paramLowEndPerfBean.toString());
      QLog.d("Perf", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = DeviceOptSwitch.a().edit();
    ((SharedPreferences.Editor)localObject).putBoolean("disablepreloadproc_new", paramLowEndPerfBean.a);
    ((SharedPreferences.Editor)localObject).putBoolean("disablegettrooplist_new", paramLowEndPerfBean.c);
    ((SharedPreferences.Editor)localObject).putBoolean("disablepredownload_new", paramLowEndPerfBean.b);
    ((SharedPreferences.Editor)localObject).putBoolean("enableautoperf_new", paramLowEndPerfBean.d);
    ((SharedPreferences.Editor)localObject).putString("userratio_new", paramLowEndPerfBean.e);
    ((SharedPreferences.Editor)localObject).putString("extralsteps_new", paramLowEndPerfBean.f);
    ((SharedPreferences.Editor)localObject).putString("predownloadwhitelist_new", paramLowEndPerfBean.g);
    ((SharedPreferences.Editor)localObject).putBoolean("enable_thread_suspend", paramLowEndPerfBean.i);
    ((SharedPreferences.Editor)localObject).putBoolean("fake_enable_thread_suspend", paramLowEndPerfBean.j);
    ((SharedPreferences.Editor)localObject).putBoolean("suspendWhiteListOnly", paramLowEndPerfBean.k);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public Class<LowEndPerfBean> clazz()
  {
    return LowEndPerfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 581;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.suspendthread.LowEndPerfProcessor
 * JD-Core Version:    0.7.0.1
 */