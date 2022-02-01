package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class MutualMarkConfProcessor
  extends IQConfigProcessor<MutualMarkConfBean>
{
  private static MutualMarkConfBean a = null;
  
  public static MutualMarkConfBean a()
  {
    MutualMarkConfBean localMutualMarkConfBean2 = (MutualMarkConfBean)QConfigManager.a().a(524);
    MutualMarkConfBean localMutualMarkConfBean1 = localMutualMarkConfBean2;
    if (localMutualMarkConfBean2 == null) {
      localMutualMarkConfBean1 = MutualMarkConfBean.a();
    }
    return localMutualMarkConfBean1;
  }
  
  @NonNull
  public MutualMarkConfBean a(int paramInt)
  {
    if (a != null) {
      return a;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    a = MutualMarkConfBean.a();
    return a;
  }
  
  @Nullable
  public MutualMarkConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      QLog.d("MutualMarkConfProcessor", 1, "MutualMarkConfProcessor#onParsed: success");
      paramArrayOfQConfItem = MutualMarkConfBean.a(paramArrayOfQConfItem[0].a);
      a = null;
      return paramArrayOfQConfItem;
    }
    QLog.d("MutualMarkConfProcessor", 1, "MutualMarkConfProcessor#onParsed: fail");
    return MutualMarkConfBean.a();
  }
  
  public void a(MutualMarkConfBean paramMutualMarkConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onUpdate newConf:" + paramMutualMarkConfBean);
    }
  }
  
  public Class<MutualMarkConfBean> clazz()
  {
    return MutualMarkConfBean.class;
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
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public int type()
  {
    return 524;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MutualMarkConfProcessor
 * JD-Core Version:    0.7.0.1
 */