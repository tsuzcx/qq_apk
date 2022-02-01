package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.PreloadConfBean;
import com.tencent.qphone.base.util.QLog;

public class PreloadConfProcessor
  extends IQConfigProcessor<PreloadConfBean>
{
  @NonNull
  public PreloadConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new PreloadConfBean();
  }
  
  @Nullable
  public PreloadConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onParsed]");
    }
    PreloadConfBean localPreloadConfBean = new PreloadConfBean();
    localPreloadConfBean.a = paramArrayOfQConfItem;
    return localPreloadConfBean;
  }
  
  public void a(PreloadConfBean paramPreloadConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onUpdate]");
    }
    IPreloadService localIPreloadService = (IPreloadService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IPreloadService.class, "");
    localIPreloadService.replaceConfig(paramPreloadConfBean);
    localIPreloadService.savePreloadConfig();
    localIPreloadService.startCheckConfig(true);
  }
  
  public Class<PreloadConfBean> clazz()
  {
    return PreloadConfBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[get migrateOldVersion]");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onReqNoReceive] failCode=" + paramInt);
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "onReqNoReceive: type=" + type());
    }
  }
  
  public int type()
  {
    return 68;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PreloadConfProcessor
 * JD-Core Version:    0.7.0.1
 */