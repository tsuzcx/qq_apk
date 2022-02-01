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

public class QFileDatalineConfigProcessor
  extends IQConfigProcessor<QFileDatalineConfigBean>
{
  @NonNull
  public QFileDatalineConfigBean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent: type[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i("QFileDatalineConfigProcessor", 1, localStringBuilder.toString());
    return new QFileDatalineConfigBean();
  }
  
  @Nullable
  public QFileDatalineConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QFileDatalineConfigProcessor", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return (QFileDatalineConfigBean)QStorage.a(paramArrayOfQConfItem[0].b, QFileDatalineConfigBean.class);
    }
    return null;
  }
  
  public void a(QFileDatalineConfigBean paramQFileDatalineConfigBean)
  {
    if (paramQFileDatalineConfigBean == null)
    {
      QLog.i("QFileDatalineConfigProcessor", 1, "onUpdate: newConf is null.");
      return;
    }
    QLog.i("QFileDatalineConfigProcessor", 1, "onUpdate");
    BaseQQAppInterface localBaseQQAppInterface = QQFileManagerUtilImpl.l();
    if (localBaseQQAppInterface != null)
    {
      Object localObject = localBaseQQAppInterface.getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file_config_");
      localStringBuilder.append(localBaseQQAppInterface.getCurrentUin());
      localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      ((SharedPreferences.Editor)localObject).putString("file_dataline_key", paramQFileDatalineConfigBean.f);
      ((SharedPreferences.Editor)localObject).apply();
      QFileConfigManager.a(localBaseQQAppInterface).a(paramQFileDatalineConfigBean);
    }
  }
  
  public Class<QFileDatalineConfigBean> clazz()
  {
    return QFileDatalineConfigBean.class;
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
    QLog.i("QFileDatalineConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 687;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileDatalineConfigProcessor
 * JD-Core Version:    0.7.0.1
 */