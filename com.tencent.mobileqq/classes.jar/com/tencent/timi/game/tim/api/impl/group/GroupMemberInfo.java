package com.tencent.timi.game.tim.api.impl.group;

import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.timi.game.tim.api.group.IGroupMemberInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/impl/group/GroupMemberInfo;", "Lcom/tencent/timi/game/tim/api/group/IGroupMemberInfo;", "v2TIMGroupMember", "Lcom/tencent/imsdk/v2/V2TIMGroupMemberInfo;", "(Lcom/tencent/imsdk/v2/V2TIMGroupMemberInfo;)V", "uid", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GroupMemberInfo
  implements IGroupMemberInfo
{
  private final V2TIMGroupMemberInfo a;
  
  public GroupMemberInfo(@NotNull V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo)
  {
    this.a = paramV2TIMGroupMemberInfo;
  }
  
  @NotNull
  public String a()
  {
    String str = this.a.getUserID();
    Intrinsics.checkExpressionValueIsNotNull(str, "v2TIMGroupMember.userID");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.group.GroupMemberInfo
 * JD-Core Version:    0.7.0.1
 */