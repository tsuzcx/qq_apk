package com.tencent.mobileqq.config.business.qfile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QFileApkCheckConfigProcessor
  extends IQConfigProcessor<QFileApkCheckConfigBean>
{
  @NonNull
  public QFileApkCheckConfigBean a(int paramInt)
  {
    QLog.i("QFileApkCheckConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new QFileApkCheckConfigBean();
  }
  
  @Nullable
  public QFileApkCheckConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QFileApkCheckConfigProcessor", 1, "onParsed");
    if (paramArrayOfQConfItem != null) {
      try
      {
        if (paramArrayOfQConfItem.length > 0)
        {
          paramArrayOfQConfItem = (QFileApkCheckConfigBean)QStorage.a(paramArrayOfQConfItem[0].a, QFileApkCheckConfigBean.class);
          return paramArrayOfQConfItem;
        }
      }
      catch (QStorageInstantiateException paramArrayOfQConfItem) {}
    }
    return null;
  }
  
  public void a(QFileApkCheckConfigBean paramQFileApkCheckConfigBean)
  {
    if (paramQFileApkCheckConfigBean == null) {
      QLog.i("QFileApkCheckConfigProcessor", 1, "apkcheckConfig onUpdate: newConf is null.");
    }
    for (;;)
    {
      return;
      QLog.i("QFileApkCheckConfigProcessor", 1, "apkcheckConfig onUpdate");
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {}
      for (localObject = (QQAppInterface)localObject; localObject != null; localObject = null)
      {
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        localEditor.putBoolean("apkcheck_enable_switch", paramQFileApkCheckConfigBean.a);
        localEditor.apply();
        ((IQFileConfigManager)((QQAppInterface)localObject).getRuntimeService(IQFileConfigManager.class, "")).setMMApkFileCheckEnable(paramQFileApkCheckConfigBean.a);
        return;
      }
    }
  }
  
  public Class<QFileApkCheckConfigBean> clazz()
  {
    return QFileApkCheckConfigBean.class;
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
    QLog.i("QFileApkCheckConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 663;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileApkCheckConfigProcessor
 * JD-Core Version:    0.7.0.1
 */