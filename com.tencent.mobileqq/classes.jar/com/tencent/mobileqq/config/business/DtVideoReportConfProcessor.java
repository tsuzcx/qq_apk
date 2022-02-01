package com.tencent.mobileqq.config.business;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class DtVideoReportConfProcessor
  extends IQConfigProcessor<DtVideoReportConfProcessor.DtVideoReportConfBean>
{
  @NonNull
  public DtVideoReportConfProcessor.DtVideoReportConfBean a(int paramInt)
  {
    return new DtVideoReportConfProcessor.DtVideoReportConfBean();
  }
  
  @Nullable
  public DtVideoReportConfProcessor.DtVideoReportConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return DtVideoReportConfProcessor.DtVideoReportConfBean.a(paramArrayOfQConfItem[0].a);
    }
    return new DtVideoReportConfProcessor.DtVideoReportConfBean();
  }
  
  public void a(DtVideoReportConfProcessor.DtVideoReportConfBean paramDtVideoReportConfBean)
  {
    QLog.d("DtVideoReportConfProcessor", 1, new Object[] { "[onUpdate] switch: ", Boolean.valueOf(paramDtVideoReportConfBean.a) });
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      localQQAppInterface.getApp().getSharedPreferences("dt_sdk_start", 4).edit().putBoolean("key_need_turn_on_dt_video", paramDtVideoReportConfBean.a).apply();
    }
    DtSdkInitStep.a(paramDtVideoReportConfBean.a);
  }
  
  public Class<DtVideoReportConfProcessor.DtVideoReportConfBean> clazz()
  {
    return DtVideoReportConfProcessor.DtVideoReportConfBean.class;
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
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 711;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.DtVideoReportConfProcessor
 * JD-Core Version:    0.7.0.1
 */