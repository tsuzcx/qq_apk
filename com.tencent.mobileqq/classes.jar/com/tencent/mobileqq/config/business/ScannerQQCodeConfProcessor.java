package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class ScannerQQCodeConfProcessor
  extends IQConfigProcessor<ScannerQQCodeConfBean>
{
  private static ScannerQQCodeConfBean a = null;
  
  public static ScannerQQCodeConfBean a()
  {
    ScannerQQCodeConfBean localScannerQQCodeConfBean2 = (ScannerQQCodeConfBean)QConfigManager.a().a(436);
    ScannerQQCodeConfBean localScannerQQCodeConfBean1 = localScannerQQCodeConfBean2;
    if (localScannerQQCodeConfBean2 == null) {
      localScannerQQCodeConfBean1 = ScannerQQCodeConfBean.a();
    }
    return localScannerQQCodeConfBean1;
  }
  
  @NonNull
  public ScannerQQCodeConfBean a(int paramInt)
  {
    if (a != null) {
      return a;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ScannerQQCodeConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    a = ScannerQQCodeConfBean.a();
    return a;
  }
  
  @Nullable
  public ScannerQQCodeConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = ScannerQQCodeConfBean.a(paramArrayOfQConfItem[0].a);
      a = null;
      return paramArrayOfQConfItem;
    }
    return ScannerQQCodeConfBean.a();
  }
  
  public void a(ScannerQQCodeConfBean paramScannerQQCodeConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerQQCodeConfProcessor", 2, "onUpdate newConf:" + paramScannerQQCodeConfBean);
    }
  }
  
  public Class<ScannerQQCodeConfBean> clazz()
  {
    return ScannerQQCodeConfBean.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("ScannerQQCodeConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public int type()
  {
    return 436;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ScannerQQCodeConfProcessor
 * JD-Core Version:    0.7.0.1
 */