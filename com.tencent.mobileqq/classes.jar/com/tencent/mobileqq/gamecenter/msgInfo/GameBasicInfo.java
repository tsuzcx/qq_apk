package com.tencent.mobileqq.gamecenter.msgInfo;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class GameBasicInfo
  extends Entity
{
  public static final String COMMON_PRE = "GameCenterMsg.";
  public static final String TAG = "GameCenterMsg.GameBasicInfo";
  @unique
  public String mAppId;
  public String mIconUrl;
  public int mMsgMaxLen;
  public String mName;
  public String mStartGameUrl;
  public long mUpdateTs;
  
  public static String getDefaultGameLaunchUrl(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://speed.gamecenter.qq.com/pushgame/v1/detail?appid=");
    localStringBuilder.append(paramString);
    localStringBuilder.append("&_wv=2164260896&_wwv=448&autodownload=1&autolaunch=1&autosubscribe=1&ADTAG=youxixiaoxi");
    return localStringBuilder.toString();
  }
  
  public void print()
  {
    StringBuilder localStringBuilder = new StringBuilder(500);
    localStringBuilder.append("appId:");
    localStringBuilder.append(this.mAppId);
    localStringBuilder.append(",name:");
    localStringBuilder.append(this.mName);
    localStringBuilder.append(",iconUrl:");
    localStringBuilder.append(this.mIconUrl);
    localStringBuilder.append(",maxMsgLen:");
    localStringBuilder.append(this.mMsgMaxLen);
    localStringBuilder.append(",ts:");
    localStringBuilder.append(this.mUpdateTs);
    localStringBuilder.append(",startGameUrl:");
    localStringBuilder.append(this.mStartGameUrl);
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterMsg.GameBasicInfo", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.msgInfo.GameBasicInfo
 * JD-Core Version:    0.7.0.1
 */