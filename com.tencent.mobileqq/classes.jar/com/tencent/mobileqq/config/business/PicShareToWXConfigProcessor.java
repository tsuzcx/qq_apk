package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class PicShareToWXConfigProcessor
  extends IQConfigProcessor<PicShareToWXConfigProcessor.PicShareToWXConifgBean>
{
  @NonNull
  public PicShareToWXConfigProcessor.PicShareToWXConifgBean a(int paramInt)
  {
    return new PicShareToWXConfigProcessor.PicShareToWXConifgBean();
  }
  
  @Nullable
  public PicShareToWXConfigProcessor.PicShareToWXConifgBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed, content:");
        localStringBuilder.append(paramArrayOfQConfItem);
        QLog.d("PicShareToWXConfigProcessor", 2, localStringBuilder.toString());
      }
      return PicShareToWXConfigProcessor.PicShareToWXConifgBean.a(paramArrayOfQConfItem);
    }
    return new PicShareToWXConfigProcessor.PicShareToWXConifgBean();
  }
  
  public void a(PicShareToWXConfigProcessor.PicShareToWXConifgBean paramPicShareToWXConifgBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onUpdate");
    }
  }
  
  public Class clazz()
  {
    return PicShareToWXConfigProcessor.PicShareToWXConifgBean.class;
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
      QLog.d("PicShareToWXConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 530;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PicShareToWXConfigProcessor
 * JD-Core Version:    0.7.0.1
 */