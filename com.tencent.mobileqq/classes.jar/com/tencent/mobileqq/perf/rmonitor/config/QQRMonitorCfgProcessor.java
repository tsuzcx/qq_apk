package com.tencent.mobileqq.perf.rmonitor.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class QQRMonitorCfgProcessor
  extends IQConfigProcessor
{
  public Class clazz()
  {
    return QQRMonitorConfigBean.class;
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
  
  @NonNull
  @NotNull
  public Object migrateOldOrDefaultContent(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRMonitorCfgProcessor", 2, new Object[] { "[config] migrateOldOrDefaultContent: invoked. ", " type: ", Integer.valueOf(paramInt) });
    }
    return new QQRMonitorConfigBean();
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @android.support.annotation.Nullable
  @org.jetbrains.annotations.Nullable
  public Object onParsed(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQRMonitorCfgProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return QQRMonitorConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public void onUpdate(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRMonitorCfgProcessor", 2, new Object[] { "[config] onUpdate: invoked. ", " newConf: ", paramObject });
    }
  }
  
  public int type()
  {
    return 768;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.perf.rmonitor.config.QQRMonitorCfgProcessor
 * JD-Core Version:    0.7.0.1
 */