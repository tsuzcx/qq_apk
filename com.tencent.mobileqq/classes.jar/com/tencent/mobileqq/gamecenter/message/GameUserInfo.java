package com.tencent.mobileqq.gamecenter.message;

import asiv;
import awbv;
import awdj;
import com.tencent.TMG.utils.QLog;

public class GameUserInfo
  extends awbv
{
  public static final String TAG = asiv.a + "GameUserInfo";
  public String mAppId;
  public String mFaceUrl;
  public String mLevelPic;
  public String mLevelText;
  public String mNickInGame;
  public String mOnLineDesc;
  public int mOnlineType;
  public String mPartitioName;
  @awdj
  public String mRoleId;
  public long mSaveTs;
  public int mSex;
  public int mSwitchInGame;
  public long mUpdateTs;
  
  public static boolean isUsrInfoUpdate(GameUserInfo paramGameUserInfo1, GameUserInfo paramGameUserInfo2)
  {
    return (paramGameUserInfo1 == null) || (paramGameUserInfo1.mUpdateTs != paramGameUserInfo2.mUpdateTs);
  }
  
  public void print()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" roleId:").append(this.mRoleId).append(",appid:").append(this.mAppId).append(",onlineType:").append(this.mOnlineType).append(",sex:").append(this.mSex).append(",ts:").append(this.mUpdateTs).append(",nick:").append(this.mNickInGame).append(",faceUrl:").append(this.mFaceUrl).append(",partName:").append(this.mPartitioName).append(",levelPic:").append(this.mLevelPic).append(",levelText:").append(this.mLevelText).append(",saveTs:").append(this.mSaveTs).append(",switchInGame:").append(this.mSwitchInGame).append(",onlineDesc:").append(this.mOnLineDesc);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 0, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameUserInfo
 * JD-Core Version:    0.7.0.1
 */