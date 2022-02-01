package com.tencent.mobileqq.gamecenter.message;

import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler;

public class GameDetailInfo
{
  public static final String a;
  public int a;
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
  public String m;
  
  static
  {
    jdField_a_of_type_JavaLangString = GameCenterUnissoHandler.jdField_a_of_type_JavaLangString + "GameDetailInfo";
  }
  
  public static GameDetailInfo a(GameBasicInfo paramGameBasicInfo, GameUserInfo paramGameUserInfo)
  {
    GameDetailInfo localGameDetailInfo = new GameDetailInfo();
    if ((paramGameBasicInfo == null) || (paramGameUserInfo == null)) {
      return localGameDetailInfo;
    }
    if ((TextUtils.isEmpty(paramGameBasicInfo.mAppId)) || (TextUtils.isEmpty(paramGameUserInfo.mAppId)))
    {
      com.tencent.qphone.base.util.QLog.w(jdField_a_of_type_JavaLangString, 1, "appId is empty.");
      return localGameDetailInfo;
    }
    if (!paramGameBasicInfo.mAppId.equals(paramGameUserInfo.mAppId))
    {
      com.tencent.qphone.base.util.QLog.w(jdField_a_of_type_JavaLangString, 1, "warning! appId should be the same!");
      return localGameDetailInfo;
    }
    localGameDetailInfo.jdField_c_of_type_JavaLangString = paramGameUserInfo.mUin;
    localGameDetailInfo.jdField_b_of_type_JavaLangString = paramGameUserInfo.mRoleId;
    localGameDetailInfo.jdField_d_of_type_JavaLangString = paramGameUserInfo.mAppId;
    localGameDetailInfo.e = paramGameUserInfo.mFaceUrl;
    localGameDetailInfo.jdField_a_of_type_Int = paramGameUserInfo.mSex;
    localGameDetailInfo.h = paramGameUserInfo.mLevelPic;
    localGameDetailInfo.i = paramGameUserInfo.mLevelText;
    localGameDetailInfo.f = paramGameUserInfo.mNickInGame;
    localGameDetailInfo.g = paramGameUserInfo.mPartitioName;
    localGameDetailInfo.jdField_b_of_type_Int = paramGameUserInfo.mOnlineType;
    localGameDetailInfo.jdField_c_of_type_Int = paramGameUserInfo.mSwitchInGame;
    localGameDetailInfo.l = paramGameUserInfo.mOnLineDesc;
    localGameDetailInfo.j = paramGameBasicInfo.mName;
    localGameDetailInfo.k = paramGameBasicInfo.mIconUrl;
    localGameDetailInfo.m = paramGameBasicInfo.mStartGameUrl;
    localGameDetailInfo.jdField_d_of_type_Int = paramGameBasicInfo.mMsgMaxLen;
    return localGameDetailInfo;
  }
  
  public void a()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(600);
      localStringBuilder.append(" roleId:").append(this.jdField_b_of_type_JavaLangString).append(",appid:").append(this.jdField_d_of_type_JavaLangString).append(",mSwitchInGame:").append(this.jdField_c_of_type_Int).append(",onlineType:").append(this.jdField_b_of_type_Int).append(",mOnLineDesc:").append(this.l).append(",partName:").append(this.g).append(",mMsgMaxLen:").append(this.jdField_d_of_type_Int).append(",levelText:").append(this.i).append(",gameName:").append(this.j).append(",sex:").append(this.jdField_a_of_type_Int).append(",nick:").append(this.f).append(",levelPic:").append(this.h).append(",iconUrl:").append(this.k).append(",faceUrl:").append(this.e).append(",startGameUrl:").append(this.m);
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d(jdField_a_of_type_JavaLangString, 0, localStringBuilder.toString());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.qphone.base.util.QLog.w(jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
    }
  }
  
  public String toString()
  {
    return "GameDetailInfo{mRoleId='" + this.jdField_b_of_type_JavaLangString + '\'' + ", mAppId='" + this.jdField_d_of_type_JavaLangString + '\'' + ", mFaceUrl='" + this.e + '\'' + ", mNickInGame='" + this.f + '\'' + ", mPartitioName='" + this.g + '\'' + ", mLevelPic='" + this.h + '\'' + ", mLevelText='" + this.i + '\'' + ", mSex=" + this.jdField_a_of_type_Int + ", mOnlineType=" + this.jdField_b_of_type_Int + ", mName='" + this.j + '\'' + ", mIconUrl='" + this.k + '\'' + ", mSwitchInGame=" + this.jdField_c_of_type_Int + ", mOnLineDesc='" + this.l + '\'' + ", mStartGameUrl='" + this.m + '\'' + ", mMsgMaxLen=" + this.jdField_d_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameDetailInfo
 * JD-Core Version:    0.7.0.1
 */