package com.tencent.mobileqq.gamecenter.msginfo;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class GameDetailInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public int i;
  public int j;
  public String k;
  public String l;
  public int m;
  public String n;
  public String o;
  public int p;
  public String q;
  
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
        localGameDetailInfo.b = paramGameUserInfo.mUin;
        localGameDetailInfo.a = paramGameUserInfo.mRoleId;
        localGameDetailInfo.c = paramGameUserInfo.mAppId;
        localGameDetailInfo.d = paramGameUserInfo.mFaceUrl;
        localGameDetailInfo.i = paramGameUserInfo.mSex;
        localGameDetailInfo.g = paramGameUserInfo.mLevelPic;
        localGameDetailInfo.h = paramGameUserInfo.mLevelText;
        localGameDetailInfo.e = paramGameUserInfo.mNickInGame;
        localGameDetailInfo.f = paramGameUserInfo.mPartitioName;
        localGameDetailInfo.j = paramGameUserInfo.mOnlineType;
        localGameDetailInfo.m = paramGameUserInfo.mSwitchInGame;
        localGameDetailInfo.n = paramGameUserInfo.mOnLineDesc;
        localGameDetailInfo.q = paramGameUserInfo.mVipRankUrl;
        localGameDetailInfo.k = paramGameBasicInfo.mName;
        localGameDetailInfo.l = paramGameBasicInfo.mIconUrl;
        localGameDetailInfo.o = paramGameBasicInfo.mStartGameUrl;
        localGameDetailInfo.p = paramGameBasicInfo.mMsgMaxLen;
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
      localStringBuilder.append(this.a);
      localStringBuilder.append(",appid:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(",mSwitchInGame:");
      localStringBuilder.append(this.m);
      localStringBuilder.append(",onlineType:");
      localStringBuilder.append(this.j);
      localStringBuilder.append(",mOnLineDesc:");
      localStringBuilder.append(this.n);
      localStringBuilder.append(",partName:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(",mMsgMaxLen:");
      localStringBuilder.append(this.p);
      localStringBuilder.append(",levelText:");
      localStringBuilder.append(this.h);
      localStringBuilder.append(",gameName:");
      localStringBuilder.append(this.k);
      localStringBuilder.append(",sex:");
      localStringBuilder.append(this.i);
      localStringBuilder.append(",nick:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(",levelPic:");
      localStringBuilder.append(this.g);
      localStringBuilder.append(",iconUrl:");
      localStringBuilder.append(this.l);
      localStringBuilder.append(",faceUrl:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(",startGameUrl:");
      localStringBuilder.append(this.o);
      localStringBuilder.append(",vipRank:");
      localStringBuilder.append(this.q);
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
  
  public String b()
  {
    int i1 = this.j;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return "";
      }
      return "游戏中";
    }
    return "游戏在线";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameDetailInfo{mRoleId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mAppId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFaceUrl='");
    localStringBuilder.append(this.d);
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
    localStringBuilder.append(this.i);
    localStringBuilder.append(", mOnlineType=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", mName='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIconUrl='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSwitchInGame=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", mOnLineDesc='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mStartGameUrl='");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMsgMaxLen=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", mVipRankUrl");
    localStringBuilder.append(this.q);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo
 * JD-Core Version:    0.7.0.1
 */