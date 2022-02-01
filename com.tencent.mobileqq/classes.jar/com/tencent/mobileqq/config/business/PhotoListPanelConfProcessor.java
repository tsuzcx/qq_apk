package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
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
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onParsed " + paramArrayOfQConfItem.length);
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
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onUpdate " + paramPhotoListPanelBean.toString());
    }
    PhotoListPanel.setShowModeToSp(paramPhotoListPanelBean.a);
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
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 587;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PhotoListPanelConfProcessor
 * JD-Core Version:    0.7.0.1
 */