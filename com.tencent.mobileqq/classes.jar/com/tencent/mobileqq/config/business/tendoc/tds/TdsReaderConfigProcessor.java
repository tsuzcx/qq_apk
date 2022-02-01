package com.tencent.mobileqq.config.business.tendoc.tds;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public final class TdsReaderConfigProcessor
  extends IQConfigProcessor<TdsReaderConfigBean>
{
  public static void a()
  {
    QLog.d("TdsReaderView_TdsReaderConfigProcessor", 1, "initConfig");
    TdsReaderConfigBean.a(false, (TdsReaderConfigBean)QConfigManager.a().a(482));
  }
  
  @NonNull
  public TdsReaderConfigBean a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new TdsReaderConfigBean();
  }
  
  @Nullable
  public TdsReaderConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    return TdsReaderConfigBean.a(paramArrayOfQConfItem);
  }
  
  public void a(TdsReaderConfigBean paramTdsReaderConfigBean)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "onUpdate");
    TdsReaderConfigBean.a(true, paramTdsReaderConfigBean);
  }
  
  public Class<TdsReaderConfigBean> clazz()
  {
    return TdsReaderConfigBean.class;
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
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public int type()
  {
    return 482;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.tds.TdsReaderConfigProcessor
 * JD-Core Version:    0.7.0.1
 */