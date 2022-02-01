package com.tencent.mobileqq.guild.live.livemanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.live.livemanager.model.QQGuildEndLiveModel;

public abstract interface LiveRoomEventListener
{
  public abstract void a(@NonNull QQGuildEndLiveModel paramQQGuildEndLiveModel);
  
  public abstract void a(@Nullable String paramString);
  
  public abstract boolean e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.LiveRoomEventListener
 * JD-Core Version:    0.7.0.1
 */