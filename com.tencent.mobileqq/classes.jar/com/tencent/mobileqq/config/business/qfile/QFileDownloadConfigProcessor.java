package com.tencent.mobileqq.config.business.qfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
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

public class QFileDownloadConfigProcessor
  extends IQConfigProcessor<QFileDownloadConfigBean>
{
  @NonNull
  public QFileDownloadConfigBean a(int paramInt)
  {
    return new QFileDownloadConfigBean();
  }
  
  @Nullable
  public QFileDownloadConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QFileDownloadConfigProcessor", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return (QFileDownloadConfigBean)QStorage.a(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString, QFileDownloadConfigBean.class);
    }
    return null;
  }
  
  public void a(QFileDownloadConfigBean paramQFileDownloadConfigBean)
  {
    if ((paramQFileDownloadConfigBean != null) && (paramQFileDownloadConfigBean.jdField_a_of_type_JavaUtilHashMap != null))
    {
      Object localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getApp();
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(paramQFileDownloadConfigBean.jdField_a_of_type_JavaLangString))
        {
          localObject = ((BaseQQAppInterface)localObject).getApplicationContext().getSharedPreferences("file_config_" + ((BaseQQAppInterface)localObject).getCurrentUin(), 0).edit();
          ((SharedPreferences.Editor)localObject).putString("qfile_file_auto_download", paramQFileDownloadConfigBean.jdField_a_of_type_JavaLangString);
          ((SharedPreferences.Editor)localObject).apply();
          QLog.i("QFileDownloadConfigProcessor", 1, "save download config [" + paramQFileDownloadConfigBean.jdField_a_of_type_JavaLangString + "]");
        }
        QFileConfigManager.a().a(paramQFileDownloadConfigBean.jdField_a_of_type_JavaUtilHashMap);
      }
    }
  }
  
  public Class<QFileDownloadConfigBean> clazz()
  {
    return QFileDownloadConfigBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
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
    QLog.i("QFileDownloadConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 85;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileDownloadConfigProcessor
 * JD-Core Version:    0.7.0.1
 */