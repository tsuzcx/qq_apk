package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class AEPituCameraConfigProcessor
  extends IQConfigProcessor<AEPituCameraConfigProcessor.AEPituCameraConfigBean>
{
  @NonNull
  public AEPituCameraConfigProcessor.AEPituCameraConfigBean a(int paramInt)
  {
    return new AEPituCameraConfigProcessor.AEPituCameraConfigBean();
  }
  
  @Nullable
  public AEPituCameraConfigProcessor.AEPituCameraConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      AEPituCameraConfigProcessor.AEPituCameraConfigBean localAEPituCameraConfigBean = AEPituCameraConfigProcessor.AEPituCameraConfigBean.a(paramArrayOfQConfItem[0].b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed:");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("AEPituCameraConfigProcessor", 2, localStringBuilder.toString());
      }
      return localAEPituCameraConfigBean;
    }
    return null;
  }
  
  public void a(AEPituCameraConfigProcessor.AEPituCameraConfigBean paramAEPituCameraConfigBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate: ");
      localStringBuilder.append(paramAEPituCameraConfigBean.a());
      QLog.d("AEPituCameraConfigProcessor", 2, localStringBuilder.toString());
    }
    ShortVideoUtils.setAEPituCameraTaKeSameSwitch(paramAEPituCameraConfigBean.a());
  }
  
  public Class<AEPituCameraConfigProcessor.AEPituCameraConfigBean> clazz()
  {
    return AEPituCameraConfigProcessor.AEPituCameraConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int onSend(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSend: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", isOpen:");
      localStringBuilder.append(ShortVideoUtils.isAEPituTakeSameOpen());
      QLog.d("AEPituCameraConfigProcessor", 2, localStringBuilder.toString());
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 574;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.AEPituCameraConfigProcessor
 * JD-Core Version:    0.7.0.1
 */