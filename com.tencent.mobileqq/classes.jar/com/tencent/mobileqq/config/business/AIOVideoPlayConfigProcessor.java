package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.structmsg.AIOVideoPlayController;
import com.tencent.qphone.base.util.QLog;

public class AIOVideoPlayConfigProcessor
  extends IQConfigProcessor<AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean>
{
  @NonNull
  public AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean a(int paramInt)
  {
    return new AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean();
  }
  
  @Nullable
  public AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed, content:" + paramArrayOfQConfItem);
      }
      return AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean.a(paramArrayOfQConfItem);
    }
    return new AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean();
  }
  
  public void a(AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean paramAIOVideoPlayConfigBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onUpdate");
    }
    AIOVideoPlayController.a().a(paramAIOVideoPlayConfigBean);
  }
  
  public Class clazz()
  {
    return AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 537;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.AIOVideoPlayConfigProcessor
 * JD-Core Version:    0.7.0.1
 */