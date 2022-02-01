package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.transfile.chatpic.PicUploadExifInfoSwitch;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import com.tencent.qphone.base.util.QLog;

public class PicCommonConfProcessor
  extends IQConfigProcessor<PicCommonBean>
{
  @NonNull
  public PicCommonBean a(int paramInt)
  {
    return new PicCommonBean();
  }
  
  @Nullable
  public PicCommonBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onParsed ");
      ((StringBuilder)localObject1).append(paramArrayOfQConfItem.length);
      QLog.d("PicCommonConfProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfQConfItem != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfQConfItem.length > 0) {
        localObject1 = PicCommonBean.a(paramArrayOfQConfItem);
      }
    }
    return localObject1;
  }
  
  public void a(PicCommonBean paramPicCommonBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramPicCommonBean.toString());
      QLog.d("PicCommonConfProcessor", 2, localStringBuilder.toString());
    }
    SafeBitmapFactory.setNeedRegionDecode(paramPicCommonBean.a);
    SafeBitmapFactory.setPxThreshoidToSp(paramPicCommonBean.c);
    SafeBitmapFactory.setRamThreshoidToSp(paramPicCommonBean.b);
    SafeBitmapFactory.setThreadCountToSp(paramPicCommonBean.d);
    PicUploadFileSizeLimit.setLimitC2C(paramPicCommonBean.e);
    PicUploadFileSizeLimit.setLimitGroup(paramPicCommonBean.f);
    PicUploadExifInfoSwitch.setSwitch(paramPicCommonBean.g);
  }
  
  public Class<PicCommonBean> clazz()
  {
    return PicCommonBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("PicCommonConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 251;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PicCommonConfProcessor
 * JD-Core Version:    0.7.0.1
 */