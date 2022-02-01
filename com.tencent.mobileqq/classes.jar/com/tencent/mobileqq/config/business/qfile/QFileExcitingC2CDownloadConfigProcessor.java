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

public class QFileExcitingC2CDownloadConfigProcessor
  extends IQConfigProcessor<QFileExcitingC2CDownloadConfigBean>
{
  @NonNull
  public QFileExcitingC2CDownloadConfigBean a(int paramInt)
  {
    return new QFileExcitingC2CDownloadConfigBean();
  }
  
  @Nullable
  public QFileExcitingC2CDownloadConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return (QFileExcitingC2CDownloadConfigBean)QStorage.a(paramArrayOfQConfItem[0].a, QFileExcitingC2CDownloadConfigBean.class);
    }
    return null;
  }
  
  public void a(QFileExcitingC2CDownloadConfigBean paramQFileExcitingC2CDownloadConfigBean)
  {
    if (paramQFileExcitingC2CDownloadConfigBean != null)
    {
      BaseQQAppInterface localBaseQQAppInterface = QQFileManagerUtilImpl.a();
      if (localBaseQQAppInterface != null)
      {
        if (TextUtils.isEmpty(paramQFileExcitingC2CDownloadConfigBean.a)) {
          paramQFileExcitingC2CDownloadConfigBean.a = "{}";
        }
        Object localObject = localBaseQQAppInterface.getApplicationContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("c2cfile_excitingdownload_");
        localStringBuilder.append(localBaseQQAppInterface.getCurrentUin());
        localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
        ((SharedPreferences.Editor)localObject).putString("qfile_c2cfile_excitingdownload", paramQFileExcitingC2CDownloadConfigBean.a);
        ((SharedPreferences.Editor)localObject).apply();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("save Exciting-C2C-Download config [");
        ((StringBuilder)localObject).append(paramQFileExcitingC2CDownloadConfigBean.a);
        ((StringBuilder)localObject).append("]");
        QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        QFileConfigManager.a(localBaseQQAppInterface).a(paramQFileExcitingC2CDownloadConfigBean);
      }
    }
  }
  
  public Class<QFileExcitingC2CDownloadConfigBean> clazz()
  {
    return QFileExcitingC2CDownloadConfigBean.class;
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
    QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 556;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileExcitingC2CDownloadConfigProcessor
 * JD-Core Version:    0.7.0.1
 */