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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent: type[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i("QFileApkCheckConfigProcessor", 1, localStringBuilder.toString());
    return new QFileApkCheckConfigBean();
  }
  
  @Nullable
  public QFileApkCheckConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QFileApkCheckConfigProcessor", 1, "onParsed");
    if (paramArrayOfQConfItem != null) {}
    try
    {
      if (paramArrayOfQConfItem.length > 0)
      {
        paramArrayOfQConfItem = (QFileApkCheckConfigBean)QStorage.a(paramArrayOfQConfItem[0].b, QFileApkCheckConfigBean.class);
        return paramArrayOfQConfItem;
      }
    }
    catch (QStorageInstantiateException paramArrayOfQConfItem)
    {
      label34:
      break label34;
    }
    return null;
  }
  
  public void a(QFileApkCheckConfigBean paramQFileApkCheckConfigBean)
  {
    if (paramQFileApkCheckConfigBean == null)
    {
      QLog.i("QFileApkCheckConfigProcessor", 1, "apkcheckConfig onUpdate: newConf is null.");
      return;
    }
    QLog.i("QFileApkCheckConfigProcessor", 1, "apkcheckConfig onUpdate");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface = null;
    if ((localObject instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)localObject;
    }
    if (localQQAppInterface != null)
    {
      localObject = localQQAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file_config_");
      localStringBuilder.append(localQQAppInterface.getCurrentUin());
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("apkcheck_enable_switch", paramQFileApkCheckConfigBean.a);
      ((SharedPreferences.Editor)localObject).apply();
      ((IQFileConfigManager)localQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).setMMApkFileCheckEnable(paramQFileApkCheckConfigBean.a);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed: failCode[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i("QFileApkCheckConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 663;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileApkCheckConfigProcessor
 * JD-Core Version:    0.7.0.1
 */