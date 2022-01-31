package com.tencent.mobileqq.gamecenter.message;

import asne;
import awge;
import awhs;
import com.tencent.qphone.base.util.QLog;

public class GameSwitchConfig
  extends awge
{
  public static final String TAG = asne.a + "GameSwitchConfig";
  @awhs
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameSwitchConfig
 * JD-Core Version:    0.7.0.1
 */