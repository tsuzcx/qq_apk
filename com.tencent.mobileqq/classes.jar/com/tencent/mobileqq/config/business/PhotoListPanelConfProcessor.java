package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.widget.SwipeUpAndDragListener;
import com.tencent.qphone.base.util.QLog;

public class PhotoListPanelConfProcessor
  extends IQConfigProcessor<PhotoListPanelBean>
{
  @NonNull
  public PhotoListPanelBean a(int paramInt)
  {
    return new PhotoListPanelBean();
  }
  
  @Nullable
  public PhotoListPanelBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onParsed ");
      ((StringBuilder)localObject1).append(paramArrayOfQConfItem.length);
      QLog.d("PhotoListPanelConfProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfQConfItem != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfQConfItem.length > 0) {
        localObject1 = PhotoListPanelBean.a(paramArrayOfQConfItem);
      }
    }
    return localObject1;
  }
  
  public void a(PhotoListPanelBean paramPhotoListPanelBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramPhotoListPanelBean.toString());
      QLog.d("PhotoListPanelConfProcessor", 2, localStringBuilder.toString());
    }
    SwipeUpAndDragListener.a(paramPhotoListPanelBean.a);
  }
  
  public Class<PhotoListPanelBean> clazz()
  {
    return PhotoListPanelBean.class;
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
      QLog.d("PhotoListPanelConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 587;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PhotoListPanelConfProcessor
 * JD-Core Version:    0.7.0.1
 */