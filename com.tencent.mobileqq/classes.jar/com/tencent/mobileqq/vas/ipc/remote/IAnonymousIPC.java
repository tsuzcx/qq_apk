package com.tencent.mobileqq.vas.ipc.remote;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ipc/remote/IAnonymousIPC;", "", "getAvatarID", "", "troopUin", "getNickname", "getRankColor", "isAnonymous", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IAnonymousIPC
{
  @Nullable
  public abstract String getAvatarID(@NotNull String paramString);
  
  @Nullable
  public abstract String getNickname(@NotNull String paramString);
  
  @Nullable
  public abstract String getRankColor(@NotNull String paramString);
  
  public abstract boolean isAnonymous(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.IAnonymousIPC
 * JD-Core Version:    0.7.0.1
 */