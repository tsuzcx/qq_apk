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
  private static MutualMarkConfBean a;
  
  public static MutualMarkConfBean a()
  {
    MutualMarkConfBean localMutualMarkConfBean2 = (MutualMarkConfBean)QConfigManager.b().b(524);
    MutualMarkConfBean localMutualMarkConfBean1 = localMutualMarkConfBean2;
    if (localMutualMarkConfBean2 == null) {
      localMutualMarkConfBean1 = MutualMarkConfBean.a();
    }
    return localMutualMarkConfBean1;
  }
  
  @NonNull
  public MutualMarkConfBean a(int paramInt)
  {
    MutualMarkConfBean localMutualMarkConfBean = a;
    if (localMutualMarkConfBean != null) {
      return localMutualMarkConfBean;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MutualMarkConfProcessor#onParsed: success，confFiles:");
      localStringBuilder.append(paramArrayOfQConfItem);
      QLog.d("MutualMarkConfProcessor", 1, localStringBuilder.toString());
      paramArrayOfQConfItem = MutualMarkConfBean.a(paramArrayOfQConfItem[0].b);
      a = null;
      return paramArrayOfQConfItem;
    }
    QLog.d("MutualMarkConfProcessor", 1, "MutualMarkConfProcessor#onParsed: fail");
    return MutualMarkConfBean.a();
  }
  
  public void a(MutualMarkConfBean paramMutualMarkConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate newConf:");
      localStringBuilder.append(paramMutualMarkConfBean);
      QLog.d("MutualMarkConfProcessor", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed failCode:");
      localStringBuilder.append(paramInt);
      QLog.d("MutualMarkConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 524;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MutualMarkConfProcessor
 * JD-Core Version:    0.7.0.1
 */