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

public class QFileAppStorePromoteDialogConfigProcessor
  extends IQConfigProcessor<QFileAppStorePromoteDialogConfigBean>
{
  @NonNull
  public QFileAppStorePromoteDialogConfigBean a(int paramInt)
  {
    return new QFileAppStorePromoteDialogConfigBean();
  }
  
  @Nullable
  public QFileAppStorePromoteDialogConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QFileAppStorePromoteDialogConfigProcessor<QFile>", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return (QFileAppStorePromoteDialogConfigBean)QStorage.a(paramArrayOfQConfItem[0].b, QFileAppStorePromoteDialogConfigBean.class);
    }
    return null;
  }
  
  public void a(QFileAppStorePromoteDialogConfigBean paramQFileAppStorePromoteDialogConfigBean)
  {
    if (paramQFileAppStorePromoteDialogConfigBean == null)
    {
      QLog.i("QFileAppStorePromoteDialogConfigProcessor<QFile>", 1, "onUpdate: newConf is null.");
      return;
    }
    QLog.i("QFileAppStorePromoteDialogConfigProcessor<QFile>", 1, "onUpdate");
    BaseQQAppInterface localBaseQQAppInterface = QQFileManagerUtilImpl.l();
    if (localBaseQQAppInterface != null)
    {
      Object localObject = localBaseQQAppInterface.getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file_config_");
      localStringBuilder.append(localBaseQQAppInterface.getCurrentUin());
      localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      ((SharedPreferences.Editor)localObject).putString("yyb_promote_dialog_key", paramQFileAppStorePromoteDialogConfigBean.b);
      ((SharedPreferences.Editor)localObject).apply();
      QFileConfigManager.a(localBaseQQAppInterface).a(paramQFileAppStorePromoteDialogConfigBean);
    }
  }
  
  public Class<QFileAppStorePromoteDialogConfigBean> clazz()
  {
    return QFileAppStorePromoteDialogConfigBean.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 625;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileAppStorePromoteDialogConfigProcessor
 * JD-Core Version:    0.7.0.1
 */