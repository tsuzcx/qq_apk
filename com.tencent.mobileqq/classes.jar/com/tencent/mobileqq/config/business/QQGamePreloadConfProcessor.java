package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.qphone.base.util.QLog;

public class QQGamePreloadConfProcessor
  extends IQConfigProcessor<QQGamePreloadConfBean>
{
  public static QQGamePreloadConfBean a()
  {
    return (QQGamePreloadConfBean)QConfigManager.a().a(631);
  }
  
  @NonNull
  public QQGamePreloadConfBean a(int paramInt)
  {
    return new QQGamePreloadConfBean();
  }
  
  @Nullable
  public QQGamePreloadConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      new QQGamePreloadConfBean();
      return QQGamePreloadConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(QQGamePreloadConfBean paramQQGamePreloadConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onUpdate " + paramQQGamePreloadConfBean.toString());
    }
    QQGameHelper.a = true;
    QQGameHelper.d();
  }
  
  public Class<QQGamePreloadConfBean> clazz()
  {
    return QQGamePreloadConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
      QLog.d("QQGamePreloadConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onReqNoReceive");
    }
    QQGameHelper.a = true;
    QQGameHelper.d();
  }
  
  public int type()
  {
    return 631;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQGamePreloadConfProcessor
 * JD-Core Version:    0.7.0.1
 */