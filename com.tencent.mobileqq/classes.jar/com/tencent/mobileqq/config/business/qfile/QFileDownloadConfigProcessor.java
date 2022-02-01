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
import com.tencent.mobileqq.filemanager.api.util.QStorage;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
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
      return (QFileDownloadConfigBean)QStorage.a(paramArrayOfQConfItem[0].b, QFileDownloadConfigBean.class);
    }
    return null;
  }
  
  public void a(QFileDownloadConfigBean paramQFileDownloadConfigBean)
  {
    if ((paramQFileDownloadConfigBean != null) && (paramQFileDownloadConfigBean.a != null))
    {
      BaseQQAppInterface localBaseQQAppInterface = QQFileManagerUtilImpl.l();
      if (localBaseQQAppInterface != null)
      {
        if (!TextUtils.isEmpty(paramQFileDownloadConfigBean.b))
        {
          Object localObject = localBaseQQAppInterface.getApplicationContext();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("file_config_");
          localStringBuilder.append(localBaseQQAppInterface.getCurrentUin());
          localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
          ((SharedPreferences.Editor)localObject).putString("qfile_file_auto_download", paramQFileDownloadConfigBean.b);
          ((SharedPreferences.Editor)localObject).apply();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("save download config [");
          ((StringBuilder)localObject).append(paramQFileDownloadConfigBean.b);
          ((StringBuilder)localObject).append("]");
          QLog.i("QFileDownloadConfigProcessor", 1, ((StringBuilder)localObject).toString());
        }
        QFileConfigManager.a(localBaseQQAppInterface).a(paramQFileDownloadConfigBean.a);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed: failCode[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i("QFileDownloadConfigProcessor", 1, localStringBuilder.toString());
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