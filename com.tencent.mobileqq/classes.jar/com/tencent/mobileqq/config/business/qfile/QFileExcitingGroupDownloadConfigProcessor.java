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

public class QFileExcitingGroupDownloadConfigProcessor
  extends IQConfigProcessor<QFileExcitingGroupDownloadConfigBean>
{
  @NonNull
  public QFileExcitingGroupDownloadConfigBean a(int paramInt)
  {
    return new QFileExcitingGroupDownloadConfigBean();
  }
  
  @Nullable
  public QFileExcitingGroupDownloadConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return (QFileExcitingGroupDownloadConfigBean)QStorage.a(paramArrayOfQConfItem[0].b, QFileExcitingGroupDownloadConfigBean.class);
    }
    return null;
  }
  
  public void a(QFileExcitingGroupDownloadConfigBean paramQFileExcitingGroupDownloadConfigBean)
  {
    if (paramQFileExcitingGroupDownloadConfigBean != null)
    {
      BaseQQAppInterface localBaseQQAppInterface = QQFileManagerUtilImpl.l();
      if (localBaseQQAppInterface != null)
      {
        if (TextUtils.isEmpty(paramQFileExcitingGroupDownloadConfigBean.a)) {
          paramQFileExcitingGroupDownloadConfigBean.a = "{}";
        }
        Object localObject = localBaseQQAppInterface.getApplicationContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("groupfile_excitingdownload_");
        localStringBuilder.append(localBaseQQAppInterface.getCurrentUin());
        localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        ((SharedPreferences.Editor)localObject).putString("qfile_groupfile_excitingdownload", paramQFileExcitingGroupDownloadConfigBean.a);
        ((SharedPreferences.Editor)localObject).apply();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("save Exciting-Group-Download config [");
        ((StringBuilder)localObject).append(paramQFileExcitingGroupDownloadConfigBean.a);
        ((StringBuilder)localObject).append("]");
        QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        QFileConfigManager.a(localBaseQQAppInterface).a(paramQFileExcitingGroupDownloadConfigBean);
      }
    }
  }
  
  public Class<QFileExcitingGroupDownloadConfigBean> clazz()
  {
    return QFileExcitingGroupDownloadConfigBean.class;
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
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 555;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileExcitingGroupDownloadConfigProcessor
 * JD-Core Version:    0.7.0.1
 */