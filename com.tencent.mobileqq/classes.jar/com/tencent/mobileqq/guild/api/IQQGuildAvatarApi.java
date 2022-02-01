package com.tencent.mobileqq.guild.api;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQQGuildAvatarApi
  extends IRuntimeService
{
  public abstract Drawable getAvatarDrawable(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public abstract Drawable getAvatarDrawable(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract Drawable getAvatarDrawable(AppRuntime paramAppRuntime, GuildUserAvatar paramGuildUserAvatar, int paramInt);
  
  public abstract Drawable getAvatarDrawable(AppRuntime paramAppRuntime, String paramString);
  
  @Nullable
  public abstract String getAvatarUrl(AppRuntime paramAppRuntime, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IQQGuildAvatarApi
 * JD-Core Version:    0.7.0.1
 */