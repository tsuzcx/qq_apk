package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.util.ConfigSimplifier;
import dov.com.qq.im.capture.util.ConfigSimplifier.ZipConfig;
import java.io.File;

public class QIMDynamicTextConfigProcessor
  extends IQConfigProcessor<ConfigSimplifier.ZipConfig>
{
  @NonNull
  public ConfigSimplifier.ZipConfig a(int paramInt)
  {
    return new ConfigSimplifier.ZipConfig();
  }
  
  @Nullable
  public ConfigSimplifier.ZipConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length == 0)) {
      return null;
    }
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onParsed, content:" + paramArrayOfQConfItem);
    }
    return new ConfigSimplifier().a(paramArrayOfQConfItem, DynamicTextConfigManager.a.getAbsolutePath(), "temp_dynamic_text_zip", new QIMDynamicTextConfigProcessor.1(this));
  }
  
  public void a(ConfigSimplifier.ZipConfig paramZipConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onUpdate");
    }
  }
  
  public Class<ConfigSimplifier.ZipConfig> clazz()
  {
    return ConfigSimplifier.ZipConfig.class;
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
    if (!DynamicTextConfigManager.b()) {
      return 0;
    }
    return SharedPreUtils.a(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!DynamicTextConfigManager.b())
    {
      QLog.i("QIMDynamicTextConfigProcessor", 1, "config file not exist");
      QConfigManager.a().a(309, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 309;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QIMDynamicTextConfigProcessor
 * JD-Core Version:    0.7.0.1
 */