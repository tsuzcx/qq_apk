package com.tencent.mobileqq.config.business.qfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.api.util.QStorage;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

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
      return (QFileFileReaderConfigBean)QStorage.a(paramArrayOfQConfItem[0].a, QFileFileReaderConfigBean.class);
    }
    return null;
  }
  
  public void a(QFileFileReaderConfigBean paramQFileFileReaderConfigBean)
  {
    if (paramQFileFileReaderConfigBean == null) {
      QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onUpdate: newConf is null.");
    }
    do
    {
      return;
      QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onUpdate: config[" + paramQFileFileReaderConfigBean.a + "]");
      localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getApp();
    } while (localObject == null);
    Object localObject = ((BaseQQAppInterface)localObject).getApplicationContext().getSharedPreferences("file_config_" + ((BaseQQAppInterface)localObject).getCurrentUin(), 0).edit();
    ((SharedPreferences.Editor)localObject).putString("file_reader_key", paramQFileFileReaderConfigBean.a);
    ((SharedPreferences.Editor)localObject).apply();
    QFileConfigManager.a().a(paramQFileFileReaderConfigBean);
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