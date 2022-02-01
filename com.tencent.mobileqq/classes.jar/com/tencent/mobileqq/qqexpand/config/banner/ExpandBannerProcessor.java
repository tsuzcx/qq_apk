package com.tencent.mobileqq.qqexpand.config.banner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class ExpandBannerProcessor
  extends IQConfigProcessor<ExpandBannerConfBean>
{
  public static ExpandBannerConfBean a()
  {
    ExpandBannerConfBean localExpandBannerConfBean2 = (ExpandBannerConfBean)QConfigManager.b().b(583);
    ExpandBannerConfBean localExpandBannerConfBean1 = localExpandBannerConfBean2;
    if (localExpandBannerConfBean2 == null) {
      localExpandBannerConfBean1 = new ExpandBannerConfBean();
    }
    return localExpandBannerConfBean1;
  }
  
  @NonNull
  public ExpandBannerConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExpandBannerProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new ExpandBannerConfBean();
  }
  
  @Nullable
  public ExpandBannerConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExpandBannerProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem.length);
        QLog.d("ExpandBannerProcessor", 2, localStringBuilder.toString());
      }
      return ExpandBannerConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(ExpandBannerConfBean paramExpandBannerConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      if (paramExpandBannerConfBean != null) {
        paramExpandBannerConfBean = paramExpandBannerConfBean.toString();
      } else {
        paramExpandBannerConfBean = " empty";
      }
      localStringBuilder.append(paramExpandBannerConfBean);
      QLog.d("ExpandBannerProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<ExpandBannerConfBean> clazz()
  {
    return ExpandBannerConfBean.class;
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
      QLog.e("ExpandBannerProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 583;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerProcessor
 * JD-Core Version:    0.7.0.1
 */