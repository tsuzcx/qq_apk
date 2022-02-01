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
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.api.util.QStorage;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class QFileCommonConfigProcessor
  extends IQConfigProcessor<QFileCommonConfigBean>
{
  @NonNull
  public QFileCommonConfigBean a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new QFileCommonConfigBean();
  }
  
  @Nullable
  public QFileCommonConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onParsed");
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return (QFileCommonConfigBean)QStorage.a(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString, QFileCommonConfigBean.class);
    }
    return null;
  }
  
  public void a(QFileCommonConfigBean paramQFileCommonConfigBean)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onUpdate");
    Object localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getApp();
    if (localObject != null)
    {
      localObject = ((BaseQQAppInterface)localObject).getApplicationContext().getSharedPreferences("file_config_" + ((BaseQQAppInterface)localObject).getCurrentUin(), 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("https_c2c_up", paramQFileCommonConfigBean.jdField_a_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("https_c2c_down", paramQFileCommonConfigBean.b);
      ((SharedPreferences.Editor)localObject).putBoolean("https_c2czip_down", paramQFileCommonConfigBean.c);
      ((SharedPreferences.Editor)localObject).putBoolean("https_c2c_thumb", paramQFileCommonConfigBean.d);
      ((SharedPreferences.Editor)localObject).putBoolean("https_disc_up", paramQFileCommonConfigBean.e);
      ((SharedPreferences.Editor)localObject).putBoolean("https_disc_down", paramQFileCommonConfigBean.f);
      ((SharedPreferences.Editor)localObject).putBoolean("https_disczip_down", paramQFileCommonConfigBean.g);
      ((SharedPreferences.Editor)localObject).putBoolean("https_disc_thumb", paramQFileCommonConfigBean.h);
      ((SharedPreferences.Editor)localObject).putBoolean("https_troop_up", paramQFileCommonConfigBean.i);
      ((SharedPreferences.Editor)localObject).putBoolean("https_troop_down", paramQFileCommonConfigBean.j);
      ((SharedPreferences.Editor)localObject).putBoolean("https_troopzip_down", paramQFileCommonConfigBean.k);
      ((SharedPreferences.Editor)localObject).putBoolean("https_troop_thumb", paramQFileCommonConfigBean.l);
      ((SharedPreferences.Editor)localObject).putBoolean("troop_video_preivew", paramQFileCommonConfigBean.m);
      ((SharedPreferences.Editor)localObject).putBoolean("troop_video_preivew_for_svip", paramQFileCommonConfigBean.n);
      ((SharedPreferences.Editor)localObject).putBoolean("troop_video_preivew_for_yearsvip", paramQFileCommonConfigBean.o);
      ((SharedPreferences.Editor)localObject).putBoolean("enable_file_media_platform", paramQFileCommonConfigBean.p);
      ((SharedPreferences.Editor)localObject).apply();
      QLog.i("QFileCommonConfigProcessor", 1, "save download config." + paramQFileCommonConfigBean.jdField_a_of_type_JavaLangString);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("troop_video_preivew", paramQFileCommonConfigBean.m);
      ((Bundle)localObject).putBoolean("troop_video_preivew_for_svip", paramQFileCommonConfigBean.n);
      ((Bundle)localObject).putBoolean("troop_video_preivew_for_yearsvip", paramQFileCommonConfigBean.o);
      ((Bundle)localObject).putBoolean("enable_file_media_platform", paramQFileCommonConfigBean.p);
      QFileConfigManager.a().a((Bundle)localObject);
    }
  }
  
  public Class<QFileCommonConfigBean> clazz()
  {
    return QFileCommonConfigBean.class;
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
    QLog.i("QFileCommonConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 396;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileCommonConfigProcessor
 * JD-Core Version:    0.7.0.1
 */