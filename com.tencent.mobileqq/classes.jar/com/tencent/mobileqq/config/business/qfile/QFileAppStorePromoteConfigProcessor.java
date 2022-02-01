package com.tencent.mobileqq.config.business.qfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.filemanager.api.util.QStorage;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.qphone.base.util.QLog;

public class QFileAppStorePromoteConfigProcessor
  extends IQConfigProcessor<QFileAppStorePromoteConfigBean>
{
  @NonNull
  public QFileAppStorePromoteConfigBean a(int paramInt)
  {
    return new QFileAppStorePromoteConfigBean();
  }
  
  @Nullable
  public QFileAppStorePromoteConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QFileAppStorePromoteConfigProcessor<QFile>", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return (QFileAppStorePromoteConfigBean)QStorage.a(paramArrayOfQConfItem[0].b, QFileAppStorePromoteConfigBean.class);
    }
    return null;
  }
  
  public void a(QFileAppStorePromoteConfigBean paramQFileAppStorePromoteConfigBean)
  {
    if (paramQFileAppStorePromoteConfigBean == null)
    {
      QLog.i("QFileAppStorePromoteConfigProcessor<QFile>", 1, "onUpdate: newConf is null.");
      return;
    }
    QLog.i("QFileAppStorePromoteConfigProcessor<QFile>", 1, "onUpdate");
    BaseQQAppInterface localBaseQQAppInterface = QQFileManagerUtilImpl.l();
    if (localBaseQQAppInterface != null)
    {
      Object localObject = localBaseQQAppInterface.getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file_config_");
      localStringBuilder.append(localBaseQQAppInterface.getCurrentUin());
      localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      ((SharedPreferences.Editor)localObject).putString("yyb_promote_action_key", paramQFileAppStorePromoteConfigBean.d);
      ((SharedPreferences.Editor)localObject).apply();
      QFileConfigManager.a(localBaseQQAppInterface).a(paramQFileAppStorePromoteConfigBean);
    }
  }
  
  public Class<QFileAppStorePromoteConfigBean> clazz()
  {
    return QFileAppStorePromoteConfigBean.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 626;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileAppStorePromoteConfigProcessor
 * JD-Core Version:    0.7.0.1
 */