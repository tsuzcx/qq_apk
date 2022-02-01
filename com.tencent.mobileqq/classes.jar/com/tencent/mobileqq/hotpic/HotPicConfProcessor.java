package com.tencent.mobileqq.hotpic;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class HotPicConfProcessor
  extends IQConfigProcessor<HotPicConfBean>
{
  private HotPicManager a()
  {
    try
    {
      HotPicManager localHotPicManager = HotPicManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      return localHotPicManager;
    }
    catch (Exception localException)
    {
      label15:
      break label15;
    }
    return null;
  }
  
  @NonNull
  public HotPicConfBean a(int paramInt)
  {
    HotPicConfBean localHotPicConfBean = new HotPicConfBean();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("migrateOldOrDefaultContent ");
      localStringBuilder.append(paramInt);
      QLog.d("HotPicConfProcessor", 2, localStringBuilder.toString());
    }
    return localHotPicConfBean;
  }
  
  @Nullable
  public HotPicConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      HotPicConfBean localHotPicConfBean = HotPicConfBean.a(paramArrayOfQConfItem[0].b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("HotPicConfProcessor", 2, localStringBuilder.toString());
      }
      return localHotPicConfBean;
    }
    return null;
  }
  
  public void a(HotPicConfBean paramHotPicConfBean)
  {
    HotPicManager localHotPicManager = a();
    if (localHotPicManager != null) {
      localHotPicManager.f(paramHotPicConfBean.a);
    }
  }
  
  public Class<HotPicConfBean> clazz()
  {
    return HotPicConfBean.class;
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
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      return HotPicManager.b(localQQAppInterface);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("HotPicConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 164;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicConfProcessor
 * JD-Core Version:    0.7.0.1
 */