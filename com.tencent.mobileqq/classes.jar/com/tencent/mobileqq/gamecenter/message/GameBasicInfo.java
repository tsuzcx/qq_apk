package com.tencent.mobileqq.gamecenter.message;

import atyn;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class GameBasicInfo
  extends Entity
{
  public static final String TAG = atyn.a + "GameBasicInfo";
  @unique
  public String mAppId;
  public String mIconUrl;
  public int mMsgMaxLen;
  public String mName;
  public String mStartGameUrl;
  public long mUpdateTs;
  
  public static String getDefaultGameLaunchUrl(String paramString)
  {
    return "https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=" + paramString + "&_wv=2164260896&_wwv=448&autodownload=1&autolaunch=1&autosubscribe=1&ADTAG=youxixiaoxi";
  }
  
  public void print()
  {
    StringBuilder localStringBuilder = new StringBuilder(500);
    localStringBuilder.append("appId:").append(this.mAppId).append(",name:").append(this.mName).append(",iconUrl:").append(this.mIconUrl).append(",maxMsgLen:").append(this.mMsgMaxLen).append(",ts:").append(this.mUpdateTs).append(",startGameUrl:").append(this.mStartGameUrl);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameBasicInfo
 * JD-Core Version:    0.7.0.1
 */