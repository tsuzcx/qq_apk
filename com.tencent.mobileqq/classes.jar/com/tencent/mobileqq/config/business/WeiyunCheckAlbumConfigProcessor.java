package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;

public class WeiyunCheckAlbumConfigProcessor
  extends IQConfigProcessor<WeiyunCheckAlbumConfigBean>
{
  @NonNull
  public WeiyunCheckAlbumConfigBean a(int paramInt)
  {
    return new WeiyunCheckAlbumConfigBean();
  }
  
  @Nullable
  public WeiyunCheckAlbumConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return WeiyunCheckAlbumConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(WeiyunCheckAlbumConfigBean paramWeiyunCheckAlbumConfigBean) {}
  
  public Class<WeiyunCheckAlbumConfigBean> clazz()
  {
    return WeiyunCheckAlbumConfigBean.class;
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
  
  public int type()
  {
    return 484;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WeiyunCheckAlbumConfigProcessor
 * JD-Core Version:    0.7.0.1
 */