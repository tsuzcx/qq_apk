package com.tencent.mobileqq.config.anisticker;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class RandomAniStickerConfigProcessor
  extends IQConfigProcessor<RandomAniStickerConfigBean>
{
  @NonNull
  public RandomAniStickerConfigBean a(int paramInt)
  {
    return new RandomAniStickerConfigBean();
  }
  
  @Nullable
  public RandomAniStickerConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    return RandomAniStickerConfigBean.a(paramArrayOfQConfItem);
  }
  
  public void a(RandomAniStickerConfigBean paramRandomAniStickerConfigBean)
  {
    QLog.i("RandomAniStickerConfigProcessor", 1, "onUpdate");
  }
  
  public Class<RandomAniStickerConfigBean> clazz()
  {
    return RandomAniStickerConfigBean.class;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed failCode=");
    localStringBuilder.append(paramInt);
    QLog.i("RandomAniStickerConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 773;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.anisticker.RandomAniStickerConfigProcessor
 * JD-Core Version:    0.7.0.1
 */