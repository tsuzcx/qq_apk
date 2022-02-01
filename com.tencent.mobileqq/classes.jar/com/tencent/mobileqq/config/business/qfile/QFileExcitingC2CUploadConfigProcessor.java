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

public class QFileExcitingC2CUploadConfigProcessor
  extends IQConfigProcessor<QFileExcitingC2CUploadConfigBean>
{
  @NonNull
  public QFileExcitingC2CUploadConfigBean a(int paramInt)
  {
    return new QFileExcitingC2CUploadConfigBean();
  }
  
  @Nullable
  public QFileExcitingC2CUploadConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return (QFileExcitingC2CUploadConfigBean)QStorage.a(paramArrayOfQConfItem[0].a, QFileExcitingC2CUploadConfigBean.class);
    }
    return null;
  }
  
  public void a(QFileExcitingC2CUploadConfigBean paramQFileExcitingC2CUploadConfigBean)
  {
    if (paramQFileExcitingC2CUploadConfigBean != null)
    {
      Object localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getApp();
      if (localObject != null)
      {
        if (TextUtils.isEmpty(paramQFileExcitingC2CUploadConfigBean.a)) {
          paramQFileExcitingC2CUploadConfigBean.a = "{}";
        }
        localObject = ((BaseQQAppInterface)localObject).getApplicationContext().getSharedPreferences("c2cfile_excitingupload_" + ((BaseQQAppInterface)localObject).getCurrentUin(), 0).edit();
        ((SharedPreferences.Editor)localObject).putString("qfile_c2cfile_excitingupload", paramQFileExcitingC2CUploadConfigBean.a);
        ((SharedPreferences.Editor)localObject).apply();
        QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramQFileExcitingC2CUploadConfigBean.a + "]");
        QFileConfigManager.a().a(paramQFileExcitingC2CUploadConfigBean);
      }
    }
  }
  
  public Class<QFileExcitingC2CUploadConfigBean> clazz()
  {
    return QFileExcitingC2CUploadConfigBean.class;
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
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 557;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileExcitingC2CUploadConfigProcessor
 * JD-Core Version:    0.7.0.1
 */