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
      Object localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getApp();
      if (localObject != null)
      {
        if (TextUtils.isEmpty(paramQFileExcitingC2CDownloadConfigBean.a)) {
          paramQFileExcitingC2CDownloadConfigBean.a = "{}";
        }
        localObject = ((BaseQQAppInterface)localObject).getApplicationContext().getSharedPreferences("c2cfile_excitingdownload_" + ((BaseQQAppInterface)localObject).getCurrentUin(), 0).edit();
        ((SharedPreferences.Editor)localObject).putString("qfile_c2cfile_excitingdownload", paramQFileExcitingC2CDownloadConfigBean.a);
        ((SharedPreferences.Editor)localObject).apply();
        QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-C2C-Download config [" + paramQFileExcitingC2CDownloadConfigBean.a + "]");
        QFileConfigManager.a().a(paramQFileExcitingC2CDownloadConfigBean);
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
    QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 556;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileExcitingC2CDownloadConfigProcessor
 * JD-Core Version:    0.7.0.1
 */