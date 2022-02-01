package com.tencent.mobileqq.config.business;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.utils.TripleGraySwitchUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class BootOptimizeConfProcessor
  extends IQConfigProcessor<BootOptimizeConfigureBean>
{
  @NonNull
  public BootOptimizeConfigureBean a(int paramInt)
  {
    return new BootOptimizeConfigureBean();
  }
  
  @Nullable
  public BootOptimizeConfigureBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      BootOptimizeConfigureBean localBootOptimizeConfigureBean = BootOptimizeConfigureBean.a(paramArrayOfQConfItem[0].b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("BootOptimizeConfProcessor", 2, localStringBuilder.toString());
      }
      return localBootOptimizeConfigureBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(BootOptimizeConfigureBean paramBootOptimizeConfigureBean)
  {
    if (paramBootOptimizeConfigureBean == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onUpdate ");
      ((StringBuilder)localObject1).append(paramBootOptimizeConfigureBean.toString());
      QLog.d("BootOptimizeConfProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    RecentParcelUtil.a((BaseQQAppInterface)localObject1, paramBootOptimizeConfigureBean.a);
    TripleGraySwitchUtil.a(((QQAppInterface)localObject1).getApp(), "KEY_DELAY_LOAD_PROXY", paramBootOptimizeConfigureBean.g);
    TripleGraySwitchUtil.a(((QQAppInterface)localObject1).getApp(), "KEY_ENABLE_MEMORY_LEAK", paramBootOptimizeConfigureBean.h);
    TripleGraySwitchUtil.a(((QQAppInterface)localObject1).getApp(), "KEY_DISABLE_NAVIGATION_BAR", paramBootOptimizeConfigureBean.i);
    TripleGraySwitchUtil.a(((QQAppInterface)localObject1).getApp(), "KEY_DISABLE_SAVE_PLUGIN_INFO", paramBootOptimizeConfigureBean.k);
    TripleGraySwitchUtil.a(((QQAppInterface)localObject1).getApp(), "KEY_USE_NEW_COUNT", paramBootOptimizeConfigureBean.j);
    TripleGraySwitchUtil.a(((QQAppInterface)localObject1).getApp(), "KEY_CLEAR_INVALID_UNREAD_MARK", paramBootOptimizeConfigureBean.l);
    TripleGraySwitchUtil.a(((QQAppInterface)localObject1).getApp(), "KEY_DISABLE_START_DF_PLUGIN", paramBootOptimizeConfigureBean.n);
    TripleGraySwitchUtil.a(((QQAppInterface)localObject1).getApp(), "KEY_REMINDER_CALENDAR", paramBootOptimizeConfigureBean.o);
    Object localObject2 = ((QQAppInterface)localObject1).getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("acc_info");
    localStringBuilder.append(((QQAppInterface)localObject1).getAccount());
    ((BaseApplication)localObject2).getSharedPreferences(localStringBuilder.toString(), 0).edit().putLong("PREF_PLUGIN_DELAY_TIME", paramBootOptimizeConfigureBean.b).apply();
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((QQAppInterface)localObject1).getApp().getFilesDir());
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("enableKernelServiceInVivo");
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if (paramBootOptimizeConfigureBean.c)
      {
        if (!((File)localObject2).exists()) {
          ((File)localObject2).createNewFile();
        }
      }
      else if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BootOptimizeConfProcessor", 1, "create file failed", localThrowable);
    }
    ((QQAppInterface)localObject1).getApp().getSharedPreferences("dt_sdk_start", 4).edit().putBoolean("is_init_dt_sdk_at_start_b", paramBootOptimizeConfigureBean.e).apply();
    try
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("suspend_thread_pref_file", 0).edit().putInt("enable_syslog_key", paramBootOptimizeConfigureBean.f).apply();
      BaseApplicationImpl.getApplication().getSharedPreferences("suspend_thread_pref_file", 0).edit().putString("ignore_list_key", paramBootOptimizeConfigureBean.q).apply();
      return;
    }
    catch (Throwable paramBootOptimizeConfigureBean)
    {
      QLog.e("BootOptimizeConfProcessor", 1, "syslog print config failed", paramBootOptimizeConfigureBean);
    }
  }
  
  public Class<BootOptimizeConfigureBean> clazz()
  {
    return BootOptimizeConfigureBean.class;
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
      QLog.d("BootOptimizeConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 566;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.BootOptimizeConfProcessor
 * JD-Core Version:    0.7.0.1
 */