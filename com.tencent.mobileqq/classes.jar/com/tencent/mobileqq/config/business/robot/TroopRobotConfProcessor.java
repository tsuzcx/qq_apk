package com.tencent.mobileqq.config.business.robot;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopRobotConfProcessor
  extends IQConfigProcessor<TroopRobotConfBean>
{
  @NonNull
  public TroopRobotConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopRobotConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new TroopRobotConfBean();
  }
  
  @Nullable
  public TroopRobotConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfProcessor", 2, "onParsed " + paramArrayOfQConfItem.length);
      }
      return TroopRobotConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(TroopRobotConfBean paramTroopRobotConfBean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramTroopRobotConfBean == null) {
        break label58;
      }
    }
    label58:
    for (String str = paramTroopRobotConfBean.toString();; str = " empty")
    {
      QLog.d("TroopRobotConfProcessor", 2, str);
      if (paramTroopRobotConfBean != null) {
        RobotUtils.a(paramTroopRobotConfBean.a(), paramTroopRobotConfBean.a());
      }
      return;
    }
  }
  
  public Class<TroopRobotConfBean> clazz()
  {
    return TroopRobotConfBean.class;
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
      QLog.e("TroopRobotConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 460;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.robot.TroopRobotConfProcessor
 * JD-Core Version:    0.7.0.1
 */