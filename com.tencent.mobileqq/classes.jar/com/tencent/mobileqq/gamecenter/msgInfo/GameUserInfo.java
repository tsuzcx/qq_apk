package com.tencent.mobileqq.gamecenter.msgInfo;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class GameUserInfo
  extends Entity
{
  public static final String TAG = "GameCenterMsg.GameUserInfo";
  public String mAppId;
  public String mFaceUrl;
  public String mLevelPic;
  public String mLevelText;
  public String mNickInGame;
  public String mOnLineDesc;
  public int mOnlineType;
  public String mPartitioName;
  @unique
  public String mRoleId;
  public long mSaveTs;
  public int mSex;
  public int mSwitchInGame;
  public String mUin;
  public long mUpdateTs;
  
  public static boolean isUsrInfoUpdate(GameUserInfo paramGameUserInfo1, GameUserInfo paramGameUserInfo2)
  {
    return (paramGameUserInfo1 == null) || (paramGameUserInfo1.mUpdateTs != paramGameUserInfo2.mUpdateTs);
  }
  
  public void print()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" roleId:");
    localStringBuilder.append(this.mRoleId);
    localStringBuilder.append(",appid:");
    localStringBuilder.append(this.mAppId);
    localStringBuilder.append(",onlineType:");
    localStringBuilder.append(this.mOnlineType);
    localStringBuilder.append(",sex:");
    localStringBuilder.append(this.mSex);
    localStringBuilder.append(",ts:");
    localStringBuilder.append(this.mUpdateTs);
    localStringBuilder.append(",nick:");
    localStringBuilder.append(this.mNickInGame);
    localStringBuilder.append(",faceUrl:");
    localStringBuilder.append(this.mFaceUrl);
    localStringBuilder.append(",partName:");
    localStringBuilder.append(this.mPartitioName);
    localStringBuilder.append(",levelPic:");
    localStringBuilder.append(this.mLevelPic);
    localStringBuilder.append(",levelText:");
    localStringBuilder.append(this.mLevelText);
    localStringBuilder.append(",saveTs:");
    localStringBuilder.append(this.mSaveTs);
    localStringBuilder.append(",switchInGame:");
    localStringBuilder.append(this.mSwitchInGame);
    localStringBuilder.append(",onlineDesc:");
    localStringBuilder.append(this.mOnLineDesc);
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterMsg.GameUserInfo", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.msgInfo.GameUserInfo
 * JD-Core Version:    0.7.0.1
 */