package com.tencent.mobileqq.gamecenter.msgInfo;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class GameDetailInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public static GameDetailInfo a(GameBasicInfo paramGameBasicInfo, GameUserInfo paramGameUserInfo)
  {
    GameDetailInfo localGameDetailInfo = new GameDetailInfo();
    if (paramGameBasicInfo != null)
    {
      if (paramGameUserInfo == null) {
        return localGameDetailInfo;
      }
      if ((!TextUtils.isEmpty(paramGameBasicInfo.mAppId)) && (!TextUtils.isEmpty(paramGameUserInfo.mAppId)))
      {
        if (!paramGameBasicInfo.mAppId.equals(paramGameUserInfo.mAppId))
        {
          QLog.w("GameCenterMsg.GameDetailInfo", 1, "warning! appId should be the same!");
          return localGameDetailInfo;
        }
        localGameDetailInfo.jdField_b_of_type_JavaLangString = paramGameUserInfo.mUin;
        localGameDetailInfo.jdField_a_of_type_JavaLangString = paramGameUserInfo.mRoleId;
        localGameDetailInfo.jdField_c_of_type_JavaLangString = paramGameUserInfo.mAppId;
        localGameDetailInfo.jdField_d_of_type_JavaLangString = paramGameUserInfo.mFaceUrl;
        localGameDetailInfo.jdField_a_of_type_Int = paramGameUserInfo.mSex;
        localGameDetailInfo.g = paramGameUserInfo.mLevelPic;
        localGameDetailInfo.h = paramGameUserInfo.mLevelText;
        localGameDetailInfo.e = paramGameUserInfo.mNickInGame;
        localGameDetailInfo.f = paramGameUserInfo.mPartitioName;
        localGameDetailInfo.jdField_b_of_type_Int = paramGameUserInfo.mOnlineType;
        localGameDetailInfo.jdField_c_of_type_Int = paramGameUserInfo.mSwitchInGame;
        localGameDetailInfo.k = paramGameUserInfo.mOnLineDesc;
        localGameDetailInfo.i = paramGameBasicInfo.mName;
        localGameDetailInfo.j = paramGameBasicInfo.mIconUrl;
        localGameDetailInfo.l = paramGameBasicInfo.mStartGameUrl;
        localGameDetailInfo.jdField_d_of_type_Int = paramGameBasicInfo.mMsgMaxLen;
        return localGameDetailInfo;
      }
      QLog.w("GameCenterMsg.GameDetailInfo", 1, "appId is empty.");
    }
    return localGameDetailInfo;
  }
  
  public void a()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(600);
      localStringBuilder.append(" roleId:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(",appid:");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append(",mSwitchInGame:");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append(",onlineType:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(",mOnLineDesc:");
      localStringBuilder.append(this.k);
      localStringBuilder.append(",partName:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(",mMsgMaxLen:");
      localStringBuilder.append(this.jdField_d_of_type_Int);
      localStringBuilder.append(",levelText:");
      localStringBuilder.append(this.h);
      localStringBuilder.append(",gameName:");
      localStringBuilder.append(this.i);
      localStringBuilder.append(",sex:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(",nick:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(",levelPic:");
      localStringBuilder.append(this.g);
      localStringBuilder.append(",iconUrl:");
      localStringBuilder.append(this.j);
      localStringBuilder.append(",faceUrl:");
      localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
      localStringBuilder.append(",startGameUrl:");
      localStringBuilder.append(this.l);
      if (QLog.isColorLevel())
      {
        QLog.d("GameCenterMsg.GameDetailInfo", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.w("GameCenterMsg.GameDetailInfo", 1, localThrowable.getMessage());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameDetailInfo{mRoleId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mAppId='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFaceUrl='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mNickInGame='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPartitioName='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLevelPic='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLevelText='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSex=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mOnlineType=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mName='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIconUrl='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSwitchInGame=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", mOnLineDesc='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mStartGameUrl='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMsgMaxLen=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.msgInfo.GameDetailInfo
 * JD-Core Version:    0.7.0.1
 */