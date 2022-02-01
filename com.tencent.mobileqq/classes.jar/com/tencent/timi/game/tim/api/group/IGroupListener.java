package com.tencent.timi.game.tim.api.group;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/group/IGroupListener;", "", "onGroupDismiss", "", "groupId", "", "opUser", "Lcom/tencent/timi/game/tim/api/group/IGroupMemberInfo;", "onMemberInvited", "memberList", "", "onMemberKicked", "onMemberLeave", "member", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IGroupListener
{
  public abstract void a(long paramLong, @NotNull IGroupMemberInfo paramIGroupMemberInfo);
  
  public abstract void a(long paramLong, @NotNull IGroupMemberInfo paramIGroupMemberInfo, @NotNull List<? extends IGroupMemberInfo> paramList);
  
  public abstract void b(long paramLong, @NotNull IGroupMemberInfo paramIGroupMemberInfo);
  
  public abstract void b(long paramLong, @NotNull IGroupMemberInfo paramIGroupMemberInfo, @NotNull List<? extends IGroupMemberInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.group.IGroupListener
 * JD-Core Version:    0.7.0.1
 */