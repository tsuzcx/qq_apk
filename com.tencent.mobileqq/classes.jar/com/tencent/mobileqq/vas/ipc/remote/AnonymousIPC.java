package com.tencent.mobileqq.vas.ipc.remote;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ipc/remote/AnonymousIPC;", "Lcom/tencent/mobileqq/vas/ipc/remote/IAnonymousIPC;", "()V", "getAvatarID", "", "troopUin", "getNickname", "getRankColor", "isAnonymous", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AnonymousIPC
  implements IAnonymousIPC
{
  @Nullable
  public String getAvatarID(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "troopUin");
    paramString = AnonymousChatHelper.a().b(paramString);
    if (paramString != null) {
      return String.valueOf(paramString.c);
    }
    return "";
  }
  
  @Nullable
  public String getNickname(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "troopUin");
    paramString = AnonymousChatHelper.a().b(paramString);
    if (paramString != null) {
      return paramString.d;
    }
    return "";
  }
  
  @Nullable
  public String getRankColor(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "troopUin");
    paramString = AnonymousChatHelper.a().b(paramString);
    if (paramString != null) {
      return paramString.g;
    }
    return "";
  }
  
  public boolean isAnonymous(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "troopUin");
    paramString = AnonymousChatHelper.a().b(paramString);
    if (paramString != null) {
      return paramString.a;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.AnonymousIPC
 * JD-Core Version:    0.7.0.1
 */