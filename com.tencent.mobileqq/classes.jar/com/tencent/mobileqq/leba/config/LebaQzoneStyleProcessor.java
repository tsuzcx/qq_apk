package com.tencent.mobileqq.leba.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class LebaQzoneStyleProcessor
  extends IQConfigProcessor<LebaQzoneStyleBean>
{
  @NonNull
  public LebaQzoneStyleBean a(int paramInt)
  {
    return new LebaQzoneStyleBean();
  }
  
  @Nullable
  public LebaQzoneStyleBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.i("LebaQzoneStyleProcessor", 1, "[onParsed] config");
    return LebaQzoneStyleBean.a(paramArrayOfQConfItem);
  }
  
  public void a(LebaQzoneStyleBean paramLebaQzoneStyleBean)
  {
    QLog.i("LebaQzoneStyleProcessor", 1, "[onUpdate]");
  }
  
  public Class<LebaQzoneStyleBean> clazz()
  {
    return LebaQzoneStyleBean.class;
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
    QLog.i("LebaQzoneStyleProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 614;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.config.LebaQzoneStyleProcessor
 * JD-Core Version:    0.7.0.1
 */