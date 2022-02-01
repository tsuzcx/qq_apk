package com.tencent.timi.game.userinfo.impl.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/util/UserInfoNetUtil;", "", "()V", "removeRepeatUserId", "", "", "srcUserList", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserInfoNetUtil
{
  public static final UserInfoNetUtil a = new UserInfoNetUtil();
  
  @NotNull
  public final List<Long> a(@NotNull List<Long> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "srcUserList");
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      long l = ((Number)paramList.next()).longValue();
      if (!localList.contains(Long.valueOf(l))) {
        localList.add(Long.valueOf(l));
      }
    }
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.util.UserInfoNetUtil
 * JD-Core Version:    0.7.0.1
 */