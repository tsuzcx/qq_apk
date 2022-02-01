package com.tencent.mobileqq.leba.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class LebaRedTouchSwitchProcessor
  extends IQConfigProcessor<LebaRedTouchSwitchBean>
{
  @NonNull
  public LebaRedTouchSwitchBean a(int paramInt)
  {
    return new LebaRedTouchSwitchBean();
  }
  
  @Nullable
  public LebaRedTouchSwitchBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaRedTouchSwitchProcessor", 2, "[onParsed] config");
    }
    return LebaRedTouchSwitchBean.a(paramArrayOfQConfItem);
  }
  
  public void a(LebaRedTouchSwitchBean paramLebaRedTouchSwitchBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaRedTouchSwitchProcessor", 2, "[onUpdate]");
    }
  }
  
  public Class<LebaRedTouchSwitchBean> clazz()
  {
    return LebaRedTouchSwitchBean.class;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReqFailed] failCode=");
    localStringBuilder.append(paramInt);
    QLog.d("LebaRedTouchSwitchProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 598;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.config.LebaRedTouchSwitchProcessor
 * JD-Core Version:    0.7.0.1
 */