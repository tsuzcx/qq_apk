package com.tencent.mobileqq.config.business.extendfriend;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class ExtendFriendBannerProcessor
  extends IQConfigProcessor<ExtendFriendBannerConfBean>
{
  public static ExtendFriendBannerConfBean a()
  {
    ExtendFriendBannerConfBean localExtendFriendBannerConfBean2 = (ExtendFriendBannerConfBean)QConfigManager.a().a(583);
    ExtendFriendBannerConfBean localExtendFriendBannerConfBean1 = localExtendFriendBannerConfBean2;
    if (localExtendFriendBannerConfBean2 == null) {
      localExtendFriendBannerConfBean1 = new ExtendFriendBannerConfBean();
    }
    return localExtendFriendBannerConfBean1;
  }
  
  @NonNull
  public ExtendFriendBannerConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new ExtendFriendBannerConfBean();
  }
  
  @Nullable
  public ExtendFriendBannerConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBannerProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerProcessor", 2, "onParsed " + paramArrayOfQConfItem.length);
      }
      return ExtendFriendBannerConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(ExtendFriendBannerConfBean paramExtendFriendBannerConfBean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramExtendFriendBannerConfBean == null) {
        break label43;
      }
    }
    label43:
    for (paramExtendFriendBannerConfBean = paramExtendFriendBannerConfBean.toString();; paramExtendFriendBannerConfBean = " empty")
    {
      QLog.d("ExtendFriendBannerProcessor", 2, paramExtendFriendBannerConfBean);
      return;
    }
  }
  
  public Class<ExtendFriendBannerConfBean> clazz()
  {
    return ExtendFriendBannerConfBean.class;
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
      QLog.e("ExtendFriendBannerProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 583;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.extendfriend.ExtendFriendBannerProcessor
 * JD-Core Version:    0.7.0.1
 */