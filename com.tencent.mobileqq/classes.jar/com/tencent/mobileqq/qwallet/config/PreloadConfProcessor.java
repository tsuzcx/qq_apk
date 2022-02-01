package com.tencent.mobileqq.qwallet.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.PreloadConfBean;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

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
    IPreloadService localIPreloadService = (IPreloadService)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getRuntimeService(IPreloadService.class, "");
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReqNoReceive] failCode=");
      localStringBuilder.append(paramInt);
      QLog.d("PreloadConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqNoReceive: type=");
      localStringBuilder.append(type());
      QLog.d("PreloadConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 68;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.PreloadConfProcessor
 * JD-Core Version:    0.7.0.1
 */