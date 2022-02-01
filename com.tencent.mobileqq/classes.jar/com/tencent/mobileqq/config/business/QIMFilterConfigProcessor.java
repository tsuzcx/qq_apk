package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.av.AVPathUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.util.ConfigSimplifier;
import dov.com.qq.im.capture.util.ConfigSimplifier.ZipConfig;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import java.io.File;

public class QIMFilterConfigProcessor
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
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onParsed, content:" + paramArrayOfQConfItem);
    }
    return new ConfigSimplifier().a(paramArrayOfQConfItem, AVPathUtil.f(), "temp_filter_zip", new QIMFilterConfigProcessor.1(this));
  }
  
  public void a(ConfigSimplifier.ZipConfig paramZipConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onUpdate");
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
    if (!new File(CaptureVideoFilterManager.a + "filter_config_new.xml").exists()) {
      return 0;
    }
    return VideoFilterTools.a(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!new File(CaptureVideoFilterManager.a + "filter_config_new.xml").exists())
    {
      QLog.i("QIMFilterConfigProcessor", 1, "config file not exist");
      QConfigManager.a().a(306, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 306;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QIMFilterConfigProcessor
 * JD-Core Version:    0.7.0.1
 */