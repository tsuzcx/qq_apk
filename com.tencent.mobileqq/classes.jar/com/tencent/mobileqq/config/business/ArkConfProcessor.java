package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class ArkConfProcessor
  extends IQConfigProcessor<ArkConfBean>
{
  public static ArkConfBean b(int paramInt)
  {
    ArkConfBean localArkConfBean = (ArkConfBean)QConfigManager.a().a(paramInt);
    if (localArkConfBean != null) {
      return localArkConfBean;
    }
    return new ArkConfBean();
  }
  
  @NonNull
  public ArkConfBean a(int paramInt)
  {
    return new ArkConfBean();
  }
  
  public ArkConfBean a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    return new ArkConfBean(paramString);
  }
  
  @Nullable
  public ArkConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onParsed] config type = " + type());
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      if (!TextUtils.isEmpty(paramArrayOfQConfItem)) {
        return a(paramArrayOfQConfItem);
      }
      QLog.d("ArkConfProcessor", 1, "[onParsed] content is empty, config type = " + type());
    }
    return null;
  }
  
  public void a(ArkConfBean paramArkConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onUpdate]  config type = " + type());
    }
  }
  
  public Class<ArkConfBean> clazz()
  {
    return ArkConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    QLog.d("ArkConfProcessor", 1, "[onReqFailed] failCode=" + paramInt + ", config type = " + type());
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
  }
  
  public int type()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ArkConfProcessor
 * JD-Core Version:    0.7.0.1
 */