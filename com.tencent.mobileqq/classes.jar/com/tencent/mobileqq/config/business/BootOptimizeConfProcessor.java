package com.tencent.mobileqq.config.business;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.statistics.natmem.NativeMemoryUtils;
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
      BootOptimizeConfigureBean localBootOptimizeConfigureBean = BootOptimizeConfigureBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
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
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "onUpdate " + paramBootOptimizeConfigureBean.toString());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    RecentParcelUtil.a(localQQAppInterface, paramBootOptimizeConfigureBean.jdField_a_of_type_Boolean);
    TripleGraySwitchUtil.a(localQQAppInterface.getApp(), "KEY_DELAY_LOAD_PROXY", paramBootOptimizeConfigureBean.e);
    TripleGraySwitchUtil.a(localQQAppInterface.getApp(), "KEY_ENABLE_MEMORY_LEAK", paramBootOptimizeConfigureBean.f);
    TripleGraySwitchUtil.a(localQQAppInterface.getApp(), "KEY_DISABLE_NAVIGATION_BAR", paramBootOptimizeConfigureBean.g);
    TripleGraySwitchUtil.a(localQQAppInterface.getApp(), "KEY_DISABLE_SAVE_PLUGIN_INFO", paramBootOptimizeConfigureBean.i);
    TripleGraySwitchUtil.a(localQQAppInterface.getApp(), "KEY_USE_NEW_COUNT", paramBootOptimizeConfigureBean.h);
    TripleGraySwitchUtil.a(localQQAppInterface.getApp(), "KEY_CLEAR_INVALID_UNREAD_MARK", paramBootOptimizeConfigureBean.j);
    localQQAppInterface.getApp().getSharedPreferences("acc_info" + localQQAppInterface.getAccount(), 0).edit().putLong("PREF_PLUGIN_DELAY_TIME", paramBootOptimizeConfigureBean.jdField_a_of_type_Long).apply();
    try
    {
      localFile = new File(localQQAppInterface.getApp().getFilesDir() + File.separator + "enableKernelServiceInVivo");
      if (paramBootOptimizeConfigureBean.b)
      {
        if (!localFile.exists()) {
          localFile.createNewFile();
        }
        localQQAppInterface.getApp().getSharedPreferences("dt_sdk_start", 4).edit().putBoolean("is_init_dt_sdk_at_start_b", paramBootOptimizeConfigureBean.d).apply();
      }
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        for (;;)
        {
          File localFile;
          BaseApplicationImpl.getApplication().getSharedPreferences("suspend_thread_pref_file", 0).edit().putInt("enable_syslog_key", paramBootOptimizeConfigureBean.jdField_a_of_type_Int).apply();
          NativeMemoryUtils.a(paramBootOptimizeConfigureBean.k);
          return;
          if (localFile.exists()) {
            localFile.delete();
          }
        }
        localThrowable2 = localThrowable2;
        QLog.e("BootOptimizeConfProcessor", 1, "create file failed", localThrowable2);
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          QLog.e("BootOptimizeConfProcessor", 1, "syslog print config failed", localThrowable1);
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.BootOptimizeConfProcessor
 * JD-Core Version:    0.7.0.1
 */