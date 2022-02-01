package com.tencent.timi.game.userinfo.api;

import androidx.annotation.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;
import trpc.yes.common.UserProxyCmdOuterClass.QQUserInfo;
import trpc.yes.common.UserProxyCmdOuterClass.UserGameOpenid;

public abstract interface IUserInfo
{
  public abstract Long a();
  
  public abstract String a(@Nullable CommonOuterClass.QQUserId paramQQUserId);
  
  public abstract String b(@Nullable CommonOuterClass.QQUserId paramQQUserId);
  
  @Nullable
  public abstract UserProxyCmdOuterClass.UserGameOpenid b();
  
  public abstract String c(@Nullable CommonOuterClass.QQUserId paramQQUserId);
  
  @Nullable
  public abstract GameDataServerOuterClass.SmobaGameRoleInfo c();
  
  public abstract String d(@Nullable CommonOuterClass.QQUserId paramQQUserId);
  
  @Nullable
  public abstract UserProxyCmdOuterClass.QQUserInfo d();
  
  public abstract String e(@Nullable CommonOuterClass.QQUserId paramQQUserId);
  
  public abstract boolean e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.api.IUserInfo
 * JD-Core Version:    0.7.0.1
 */