package com.tencent.mobileqq.gamecenter.message;

import avln;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class GameSwitchConfig
  extends Entity
{
  public static final String TAG = avln.a + "GameSwitchConfig";
  @unique
  public String mAppId;
  public int mBlockSwitch;
  public int mSyncSwitch;
  
  public void print()
  {
    StringBuilder localStringBuilder = new StringBuilder(500);
    localStringBuilder.append("appId:").append(this.mAppId).append(",syncSwitch:").append(this.mSyncSwitch).append(",blockSwitch:").append(this.mBlockSwitch);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameSwitchConfig
 * JD-Core Version:    0.7.0.1
 */