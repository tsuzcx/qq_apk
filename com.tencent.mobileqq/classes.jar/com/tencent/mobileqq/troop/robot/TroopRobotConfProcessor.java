package com.tencent.mobileqq.troop.robot;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem.length);
        QLog.d("TroopRobotConfProcessor", 2, localStringBuilder.toString());
      }
      return TroopRobotConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(TroopRobotConfBean paramTroopRobotConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      String str;
      if (paramTroopRobotConfBean != null) {
        str = paramTroopRobotConfBean.toString();
      } else {
        str = " empty";
      }
      localStringBuilder.append(str);
      QLog.d("TroopRobotConfProcessor", 2, localStringBuilder.toString());
    }
    if (paramTroopRobotConfBean != null) {
      ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).updateTroopRobotConfig(paramTroopRobotConfBean.a(), paramTroopRobotConfBean.b());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.e("TroopRobotConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 460;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.TroopRobotConfProcessor
 * JD-Core Version:    0.7.0.1
 */