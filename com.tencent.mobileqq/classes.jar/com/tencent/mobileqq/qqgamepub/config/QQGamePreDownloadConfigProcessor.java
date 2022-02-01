package com.tencent.mobileqq.qqgamepub.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class QQGamePreDownloadConfigProcessor
  extends IQConfigProcessor<QQGamePreDownloadConfigBean>
{
  public static QQGamePreDownloadConfigBean a()
  {
    Object localObject;
    try
    {
      QQGamePreDownloadConfigBean localQQGamePreDownloadConfigBean = (QQGamePreDownloadConfigBean)QConfigManager.a().a(739);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_QQGameTeamConfProcessor", 1, localThrowable, new Object[0]);
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadConfig bean:");
      localStringBuilder.append(localObject);
      QLog.i("QQGamePub_QQGameTeamConfProcessor", 2, localStringBuilder.toString());
    }
    if (localObject != null) {
      return localObject;
    }
    return new QQGamePreDownloadConfigBean();
  }
  
  @NonNull
  public QQGamePreDownloadConfigBean a(int paramInt)
  {
    return new QQGamePreDownloadConfigBean();
  }
  
  @Nullable
  public QQGamePreDownloadConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      paramArrayOfQConfItem = QQGamePreDownloadConfigBean.a(paramArrayOfQConfItem);
    } else {
      paramArrayOfQConfItem = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onParsed:");
      localStringBuilder.append(paramArrayOfQConfItem);
      QLog.d("QQGamePub_QQGameTeamConfProcessor", 2, localStringBuilder.toString());
    }
    return paramArrayOfQConfItem;
  }
  
  public void a(QQGamePreDownloadConfigBean paramQQGamePreDownloadConfigBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramQQGamePreDownloadConfigBean);
      QLog.d("QQGamePub_QQGameTeamConfProcessor", 2, localStringBuilder.toString());
    }
    ThreadManagerV2.excute(new QQGamePreDownloadConfigProcessor.1(this), 64, null, false);
  }
  
  public Class<QQGamePreDownloadConfigBean> clazz()
  {
    return QQGamePreDownloadConfigBean.class;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("QQGamePub_QQGameTeamConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 739;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.QQGamePreDownloadConfigProcessor
 * JD-Core Version:    0.7.0.1
 */