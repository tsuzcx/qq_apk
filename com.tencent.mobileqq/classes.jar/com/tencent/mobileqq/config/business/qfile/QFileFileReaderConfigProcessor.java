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
import mqq.app.AppRuntime;

public class QFileFileReaderConfigProcessor
  extends IQConfigProcessor<QFileFileReaderConfigBean>
{
  @NonNull
  public QFileFileReaderConfigBean a(int paramInt)
  {
    return new QFileFileReaderConfigBean();
  }
  
  @Nullable
  public QFileFileReaderConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return (QFileFileReaderConfigBean)QStorage.a(paramArrayOfQConfItem[0].b, QFileFileReaderConfigBean.class);
    }
    return null;
  }
  
  public void a(QFileFileReaderConfigBean paramQFileFileReaderConfigBean)
  {
    if (paramQFileFileReaderConfigBean == null)
    {
      QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onUpdate: newConf is null.");
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onUpdate: config[");
    ((StringBuilder)localObject1).append(paramQFileFileReaderConfigBean.strConfigContent);
    ((StringBuilder)localObject1).append("]");
    QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, ((StringBuilder)localObject1).toString());
    localObject1 = QQFileManagerUtilImpl.l();
    if (localObject1 != null)
    {
      Object localObject2 = ((BaseQQAppInterface)localObject1).getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file_config_");
      localStringBuilder.append(((BaseQQAppInterface)localObject1).getCurrentUin());
      localObject2 = ((Context)localObject2).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      ((SharedPreferences.Editor)localObject2).putString("file_reader_key", paramQFileFileReaderConfigBean.strConfigContent);
      ((SharedPreferences.Editor)localObject2).apply();
      QFileConfigManager.a((AppRuntime)localObject1).a(paramQFileFileReaderConfigBean);
    }
  }
  
  public Class<QFileFileReaderConfigBean> clazz()
  {
    return QFileFileReaderConfigBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 645;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileFileReaderConfigProcessor
 * JD-Core Version:    0.7.0.1
 */