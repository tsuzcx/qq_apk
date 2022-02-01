package com.tencent.mobileqq.multiaio.manager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.multiaio.model.MultiAIOManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class MultiAIOEntranceConfigProcessor
  extends IQConfigProcessor<MultiAIOEntranceConfigData>
{
  @NonNull
  public MultiAIOEntranceConfigData a(int paramInt)
  {
    return new MultiAIOEntranceConfigData();
  }
  
  @Nullable
  public MultiAIOEntranceConfigData a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed : ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("MultiAIOEntranceConfigProcessor", 2, localStringBuilder.toString());
      }
      return MultiAIOEntranceConfigData.a(paramArrayOfQConfItem[0].b);
    }
    return new MultiAIOEntranceConfigData();
  }
  
  public void a(MultiAIOEntranceConfigData paramMultiAIOEntranceConfigData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate : ");
      localStringBuilder.append(paramMultiAIOEntranceConfigData);
      QLog.d("MultiAIOEntranceConfigProcessor", 2, localStringBuilder.toString());
    }
    ((MultiAIOManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).a(paramMultiAIOEntranceConfigData);
  }
  
  public Class<MultiAIOEntranceConfigData> clazz()
  {
    return MultiAIOEntranceConfigData.class;
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
      localStringBuilder.append("onUpdate : ");
      localStringBuilder.append(paramInt);
      QLog.d("MultiAIOEntranceConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 478;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.manager.MultiAIOEntranceConfigProcessor
 * JD-Core Version:    0.7.0.1
 */