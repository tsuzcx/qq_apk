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
    SafeBitmapFactory.setNeedRegionDecode(paramPicCommonBean.jdField_a_of_type_Boolean);
    SafeBitmapFactory.setPxThreshoidToSp(paramPicCommonBean.jdField_a_of_type_Long);
    SafeBitmapFactory.setRamThreshoidToSp(paramPicCommonBean.jdField_a_of_type_Int);
    SafeBitmapFactory.setThreadCountToSp(paramPicCommonBean.jdField_b_of_type_Int);
    PicUploadFileSizeLimit.setLimitC2C(paramPicCommonBean.jdField_b_of_type_Long);
    PicUploadFileSizeLimit.setLimitGroup(paramPicCommonBean.jdField_c_of_type_Long);
    PicUploadExifInfoSwitch.setSwitch(paramPicCommonBean.jdField_c_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PicCommonConfProcessor
 * JD-Core Version:    0.7.0.1
 */