package com.tencent.mobileqq.gamecenter.msginfo;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class GameSwitchConfig
  extends Entity
{
  public static final String TAG = "GameCenterMsg.GameSwitchConfig";
  @unique
  public String mAppId;
  public int mBlockSwitch;
  public int mBoxSwitch;
  public int mSyncSwitch;
  
  public void print()
  {
    StringBuilder localStringBuilder = new StringBuilder(500);
    localStringBuilder.append("appId:");
    localStringBuilder.append(this.mAppId);
    localStringBuilder.append(",syncSwitch:");
    localStringBuilder.append(this.mSyncSwitch);
    localStringBuilder.append(",blockSwitch:");
    localStringBuilder.append(this.mBlockSwitch);
    localStringBuilder.append(", boxSwitch:");
    localStringBuilder.append(this.mBoxSwitch);
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterMsg.GameSwitchConfig", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig
 * JD-Core Version:    0.7.0.1
 */