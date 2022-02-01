package com.tencent.mobileqq.config.business.qfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.filemanager.api.util.QStorage;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.qphone.base.util.QLog;

public class QFileIPv6ConfigProcessor
  extends IQConfigProcessor<QFileIPv6ConfigBean>
{
  @NonNull
  public QFileIPv6ConfigBean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent: type[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i("QFileIPv6ConfigProcessor", 1, localStringBuilder.toString());
    return new QFileIPv6ConfigBean();
  }
  
  @Nullable
  public QFileIPv6ConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return (QFileIPv6ConfigBean)QStorage.a(paramArrayOfQConfItem[0].a, QFileIPv6ConfigBean.class);
    }
    return null;
  }
  
  public void a(QFileIPv6ConfigBean paramQFileIPv6ConfigBean)
  {
    if (paramQFileIPv6ConfigBean == null)
    {
      QLog.i("QFileIPv6ConfigProcessor", 1, "FileIPv6Config onUpdate: newConf is null.");
      return;
    }
    QLog.i("QFileIPv6ConfigProcessor", 1, "FileIPv6Config onUpdate");
    BaseQQAppInterface localBaseQQAppInterface = QQFileManagerUtilImpl.a();
    if (localBaseQQAppInterface != null)
    {
      Object localObject = localBaseQQAppInterface.getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file_config_");
      localStringBuilder.append(localBaseQQAppInterface.getCurrentUin());
      localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("ipv6_all_switch", paramQFileIPv6ConfigBean.jdField_a_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("ipv6_c2c_switch", paramQFileIPv6ConfigBean.b);
      ((SharedPreferences.Editor)localObject).putBoolean("ipv6_group_switch", paramQFileIPv6ConfigBean.c);
      ((SharedPreferences.Editor)localObject).putBoolean("ipv6_disc_switch", paramQFileIPv6ConfigBean.d);
      ((SharedPreferences.Editor)localObject).putBoolean("ipv6_dataline_switch", paramQFileIPv6ConfigBean.e);
      ((SharedPreferences.Editor)localObject).putInt("ipv6_strategy", paramQFileIPv6ConfigBean.jdField_a_of_type_Int);
      ((SharedPreferences.Editor)localObject).apply();
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("ipv6_all_switch", paramQFileIPv6ConfigBean.jdField_a_of_type_Boolean);
      ((Bundle)localObject).putBoolean("ipv6_c2c_switch", paramQFileIPv6ConfigBean.b);
      ((Bundle)localObject).putBoolean("ipv6_group_switch", paramQFileIPv6ConfigBean.c);
      ((Bundle)localObject).putBoolean("ipv6_disc_switch", paramQFileIPv6ConfigBean.d);
      ((Bundle)localObject).putBoolean("ipv6_dataline_switch", paramQFileIPv6ConfigBean.e);
      ((Bundle)localObject).putInt("ipv6_strategy", paramQFileIPv6ConfigBean.jdField_a_of_type_Int);
      QFileConfigManager.a(localBaseQQAppInterface).b((Bundle)localObject);
    }
  }
  
  public Class<QFileIPv6ConfigBean> clazz()
  {
    return QFileIPv6ConfigBean.class;
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
    QLog.i("QFileIPv6ConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 449;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileIPv6ConfigProcessor
 * JD-Core Version:    0.7.0.1
 */