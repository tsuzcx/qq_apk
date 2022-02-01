package com.tencent.mobileqq.config.business.dataline;

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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class QDatalineHttpsConfigProcessor
  extends IQConfigProcessor<QDatalineHttpsConfigBean>
{
  @NonNull
  public QDatalineHttpsConfigBean a(int paramInt)
  {
    QLog.i("QDatalineHttpsConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new QDatalineHttpsConfigBean();
  }
  
  @Nullable
  public QDatalineHttpsConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QDatalineHttpsConfigProcessor", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return (QDatalineHttpsConfigBean)QStorage.a(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString, QDatalineHttpsConfigBean.class);
    }
    return null;
  }
  
  public void a(QDatalineHttpsConfigBean paramQDatalineHttpsConfigBean)
  {
    QLog.i("QDatalineHttpsConfigProcessor", 1, "onUpdate");
    Object localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getApp();
    if (localObject != null)
    {
      localObject = ((BaseQQAppInterface)localObject).getApplicationContext().getSharedPreferences("dataline_config_" + ((BaseQQAppInterface)localObject).getCurrentUin(), 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("use_new_httpclient", paramQDatalineHttpsConfigBean.jdField_a_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("use_https_connect", paramQDatalineHttpsConfigBean.b);
      ((SharedPreferences.Editor)localObject).apply();
      QLog.i("QDatalineHttpsConfigProcessor", 1, "save download config." + paramQDatalineHttpsConfigBean.jdField_a_of_type_JavaLangString);
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
    QLog.i("QDatalineHttpsConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
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