package com.tencent.timi.game.tim.api.group;

import com.tencent.timi.game.utils.IResultListener;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/group/IGroupManager;", "", "addGroupListener", "", "listener", "Lcom/tencent/timi/game/tim/api/group/IGroupListener;", "getGroupMembersInfo", "groupId", "", "memberList", "", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/tim/api/group/IGroupMemberInfo;", "removeGroupListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IGroupManager
{
  public abstract void a(@Nullable IGroupListener paramIGroupListener);
  
  public abstract void a(@NotNull String paramString, @NotNull List<String> paramList, @NotNull IResultListener<List<IGroupMemberInfo>> paramIResultListener);
  
  public abstract void b(@Nullable IGroupListener paramIGroupListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.group.IGroupManager
 * JD-Core Version:    0.7.0.1
 */