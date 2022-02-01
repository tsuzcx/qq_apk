package com.tencent.mobileqq.config.business.dataline;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.filemanager.api.util.QStorage;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class QDatalineHttpsConfigProcessor
  extends IQConfigProcessor<QDatalineHttpsConfigBean>
{
  @NonNull
  public QDatalineHttpsConfigBean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent: type[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i("QDatalineHttpsConfigProcessor", 1, localStringBuilder.toString());
    return new QDatalineHttpsConfigBean();
  }
  
  @Nullable
  public QDatalineHttpsConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QDatalineHttpsConfigProcessor", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return (QDatalineHttpsConfigBean)QStorage.a(paramArrayOfQConfItem[0].b, QDatalineHttpsConfigBean.class);
    }
    return null;
  }
  
  public void a(QDatalineHttpsConfigBean paramQDatalineHttpsConfigBean)
  {
    QLog.i("QDatalineHttpsConfigProcessor", 1, "onUpdate");
    Object localObject = QQFileManagerUtil.f();
    if (localObject != null)
    {
      Context localContext = ((BaseQQAppInterface)localObject).getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dataline_config_");
      localStringBuilder.append(((BaseQQAppInterface)localObject).getCurrentUin());
      localObject = localContext.getSharedPreferences(localStringBuilder.toString(), 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("use_new_httpclient", paramQDatalineHttpsConfigBean.a);
      ((SharedPreferences.Editor)localObject).putBoolean("use_https_connect", paramQDatalineHttpsConfigBean.b);
      ((SharedPreferences.Editor)localObject).apply();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("save download config.");
      ((StringBuilder)localObject).append(paramQDatalineHttpsConfigBean.c);
      QLog.i("QDatalineHttpsConfigProcessor", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public Class<QDatalineHttpsConfigBean> clazz()
  {
    return QDatalineHttpsConfigBean.class;
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
    QLog.i("QDatalineHttpsConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 637;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.dataline.QDatalineHttpsConfigProcessor
 * JD-Core Version:    0.7.0.1
 */