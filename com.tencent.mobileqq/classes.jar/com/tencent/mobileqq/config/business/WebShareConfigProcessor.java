package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class WebShareConfigProcessor
  extends IQConfigProcessor<GeneralDataBean>
{
  public static GeneralDataBean a()
  {
    return (GeneralDataBean)QConfigManager.a().a(716);
  }
  
  @NonNull
  public GeneralDataBean a(int paramInt)
  {
    return new GeneralDataBean();
  }
  
  @Nullable
  public GeneralDataBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("WebShareConfigProcessor", 1, "[onParsed] config");
    Object localObject = null;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      localGeneralDataBean = GeneralDataBean.a(paramArrayOfQConfItem[0].a);
      localObject = localGeneralDataBean;
      if (QLog.isColorLevel())
      {
        QLog.d("WebShareConfigProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
        localObject = localGeneralDataBean;
      }
    }
    while (!QLog.isColorLevel())
    {
      GeneralDataBean localGeneralDataBean;
      return localObject;
    }
    QLog.d("WebShareConfigProcessor", 2, "onParsed is null");
    return null;
  }
  
  public void a(GeneralDataBean paramGeneralDataBean)
  {
    QLog.i("WebShareConfigProcessor", 1, "[onUpdate]");
  }
  
  public Class<GeneralDataBean> clazz()
  {
    return GeneralDataBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    QLog.i("WebShareConfigProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 716;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WebShareConfigProcessor
 * JD-Core Version:    0.7.0.1
 */