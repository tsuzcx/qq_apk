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
    LowEndPerfBean localLowEndPerfBean2 = (LowEndPerfBean)QConfigManager.a().a(581);
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
      LowEndPerfBean localLowEndPerfBean = LowEndPerfBean.a(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onParsed " + paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
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
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onUpdate " + paramLowEndPerfBean.toString());
    }
    SharedPreferences.Editor localEditor = DeviceOptSwitch.a().edit();
    localEditor.putBoolean("disablepreloadproc_new", paramLowEndPerfBean.jdField_a_of_type_Boolean);
    localEditor.putBoolean("disablegettrooplist_new", paramLowEndPerfBean.jdField_c_of_type_Boolean);
    localEditor.putBoolean("disablepredownload_new", paramLowEndPerfBean.jdField_b_of_type_Boolean);
    localEditor.putBoolean("enableautoperf_new", paramLowEndPerfBean.d);
    localEditor.putString("userratio_new", paramLowEndPerfBean.jdField_a_of_type_JavaLangString);
    localEditor.putString("extralsteps_new", paramLowEndPerfBean.jdField_b_of_type_JavaLangString);
    localEditor.putString("predownloadwhitelist_new", paramLowEndPerfBean.jdField_c_of_type_JavaLangString);
    localEditor.putBoolean("enable_thread_suspend", paramLowEndPerfBean.f);
    localEditor.putBoolean("fake_enable_thread_suspend", paramLowEndPerfBean.g);
    localEditor.putBoolean("suspendWhiteListOnly", paramLowEndPerfBean.h);
    localEditor.commit();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.opt.suspendthread.LowEndPerfProcessor
 * JD-Core Version:    0.7.0.1
 */