package com.tencent.mobileqq.config.business;

import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class LocaleConfProcessor
  extends IQConfigProcessor<LocaleConfProcessor.LocaleConfBean>
{
  public static boolean a()
  {
    if ((Build.VERSION.SDK_INT >= 26) && (Build.MODEL.toLowerCase().contains("vivo")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocaleConfProcessor", 2, "hide entrance for vivo");
      }
      return false;
    }
    LocaleConfProcessor.LocaleConfBean localLocaleConfBean = (LocaleConfProcessor.LocaleConfBean)QConfigManager.b().b(552);
    if ((localLocaleConfBean != null) && (!TextUtils.isEmpty(localLocaleConfBean.a))) {
      LocaleManager.a = "1".equals(localLocaleConfBean.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, new Object[] { "isLocaleEntranceEnable: ", Boolean.valueOf(LocaleManager.a) });
    }
    if (!LocaleManager.a()) {
      return true;
    }
    return LocaleManager.a;
  }
  
  @NonNull
  public LocaleConfProcessor.LocaleConfBean a(int paramInt)
  {
    return new LocaleConfProcessor.LocaleConfBean();
  }
  
  @Nullable
  public LocaleConfProcessor.LocaleConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      LocaleConfProcessor.LocaleConfBean localLocaleConfBean = LocaleConfProcessor.LocaleConfBean.a(paramArrayOfQConfItem[0].b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("LocaleConfProcessor", 2, localStringBuilder.toString());
      }
      return localLocaleConfBean;
    }
    return new LocaleConfProcessor.LocaleConfBean();
  }
  
  public void a(LocaleConfProcessor.LocaleConfBean paramLocaleConfBean)
  {
    if ((paramLocaleConfBean != null) && (!TextUtils.isEmpty(paramLocaleConfBean.a))) {
      LocaleManager.a = "1".equals(paramLocaleConfBean.a);
    }
    if (QLog.isColorLevel())
    {
      paramLocaleConfBean = new StringBuilder();
      paramLocaleConfBean.append("onUpdate, isConfShowEntrance: ");
      paramLocaleConfBean.append(LocaleManager.a);
      QLog.e("LocaleConfProcessor", 2, paramLocaleConfBean.toString());
    }
  }
  
  public Class<LocaleConfProcessor.LocaleConfBean> clazz()
  {
    return LocaleConfProcessor.LocaleConfBean.class;
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
    return 552;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.LocaleConfProcessor
 * JD-Core Version:    0.7.0.1
 */