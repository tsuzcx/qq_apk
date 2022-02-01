package com.tencent.mobileqq.qrscan.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class ScannerQQCodeConfProcessor
  extends IQConfigProcessor<ScannerQQCodeConfBean>
{
  private static ScannerQQCodeConfBean a;
  
  public static ScannerQQCodeConfBean a()
  {
    ScannerQQCodeConfBean localScannerQQCodeConfBean2 = (ScannerQQCodeConfBean)QConfigManager.b().b(436);
    ScannerQQCodeConfBean localScannerQQCodeConfBean1 = localScannerQQCodeConfBean2;
    if (localScannerQQCodeConfBean2 == null) {
      localScannerQQCodeConfBean1 = ScannerQQCodeConfBean.a();
    }
    return localScannerQQCodeConfBean1;
  }
  
  @NonNull
  public ScannerQQCodeConfBean a(int paramInt)
  {
    ScannerQQCodeConfBean localScannerQQCodeConfBean = a;
    if (localScannerQQCodeConfBean != null) {
      return localScannerQQCodeConfBean;
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
      paramArrayOfQConfItem = ScannerQQCodeConfBean.a(paramArrayOfQConfItem[0].b);
      a = null;
      return paramArrayOfQConfItem;
    }
    return ScannerQQCodeConfBean.a();
  }
  
  public void a(ScannerQQCodeConfBean paramScannerQQCodeConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate newConf:");
      localStringBuilder.append(paramScannerQQCodeConfBean);
      QLog.d("ScannerQQCodeConfProcessor", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed failCode:");
      localStringBuilder.append(paramInt);
      QLog.d("ScannerQQCodeConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 436;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.config.ScannerQQCodeConfProcessor
 * JD-Core Version:    0.7.0.1
 */