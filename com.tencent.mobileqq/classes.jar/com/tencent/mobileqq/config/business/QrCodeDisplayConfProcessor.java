package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class QrCodeDisplayConfProcessor
  extends IQConfigProcessor<QrCodeConfBean>
{
  @NonNull
  public static QrCodeConfBean a()
  {
    QrCodeConfBean localQrCodeConfBean2 = (QrCodeConfBean)QConfigManager.b().b(630);
    QrCodeConfBean localQrCodeConfBean1 = localQrCodeConfBean2;
    if (localQrCodeConfBean2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QrCodeDisplay.ConfProcessor", 2, "loadConfig(): bean is null then new QrCodeConfBean()");
      }
      localQrCodeConfBean1 = new QrCodeConfBean();
    }
    return localQrCodeConfBean1;
  }
  
  @NonNull
  public QrCodeConfBean a(int paramInt)
  {
    return new QrCodeConfBean();
  }
  
  @Nullable
  public QrCodeConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length != 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QrCodeDisplayConfProcessor onParsed, content:");
        localStringBuilder.append(paramArrayOfQConfItem);
        QLog.d("QrCodeDisplay.ConfProcessor", 2, localStringBuilder.toString());
      }
      return QrCodeConfBean.a(paramArrayOfQConfItem);
    }
    QLog.d("QrCodeDisplay.ConfProcessor", 1, "QrCodeDisplayConfProcessor onParsed, confFiles is null empty");
    return null;
  }
  
  public void a(QrCodeConfBean paramQrCodeConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramQrCodeConfBean.toString());
      QLog.d("QrCodeDisplay.ConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<QrCodeConfBean> clazz()
  {
    return QrCodeConfBean.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 630;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QrCodeDisplayConfProcessor
 * JD-Core Version:    0.7.0.1
 */