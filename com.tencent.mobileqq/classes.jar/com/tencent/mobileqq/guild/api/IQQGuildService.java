package com.tencent.mobileqq.guild.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQQGuildService
  extends IRuntimeService
{
  public abstract void addGuild(Context paramContext, String paramString1, String paramString2, int paramInt, IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void addGuildAndJump2AIO(Context paramContext, String paramString1, String paramString2, int paramInt, @Nullable String paramString3, Bundle paramBundle);
  
  public abstract Drawable getAvatarDrawable(String paramString);
  
  public abstract Drawable getAvatarDrawable(String paramString1, int paramInt, String paramString2, boolean paramBoolean);
  
  public abstract void globalSetJumpEntrance(int paramInt);
  
  public abstract boolean isCategoryCollapse(String paramString1, String paramString2);
  
  public abstract boolean isCurrentGuildManager(AppInterface paramAppInterface, String paramString);
  
  public abstract boolean isWhiteUser();
  
  public abstract void setCategoryCollapse(String paramString1, String paramString2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IQQGuildService
 * JD-Core Version:    0.7.0.1
 */