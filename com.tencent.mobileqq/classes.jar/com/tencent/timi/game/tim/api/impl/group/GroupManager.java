package com.tencent.timi.game.tim.api.impl.group;

import com.tencent.imsdk.v2.V2TIMGroupListener;
import com.tencent.imsdk.v2.V2TIMGroupManager;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.ILoginCallback;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.group.IGroupListener;
import com.tencent.timi.game.tim.api.group.IGroupManager;
import com.tencent.timi.game.tim.api.group.IGroupMemberInfo;
import com.tencent.timi.game.utils.IResultListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/impl/group/GroupManager;", "Lcom/tencent/timi/game/tim/api/group/IGroupManager;", "()V", "groupListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/timi/game/tim/api/group/IGroupListener;", "v2TIMGroupListener", "Lcom/tencent/imsdk/v2/V2TIMGroupListener;", "addGroupListener", "", "listener", "getGroupMembersInfo", "groupId", "", "memberList", "", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/tim/api/group/IGroupMemberInfo;", "removeGroupListener", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GroupManager
  implements IGroupManager
{
  public static final GroupManager.Companion a = new GroupManager.Companion(null);
  private final V2TIMGroupListener b = (V2TIMGroupListener)new GroupManager.v2TIMGroupListener.1(this);
  private final CopyOnWriteArrayList<IGroupListener> c = new CopyOnWriteArrayList();
  
  public void a(@Nullable IGroupListener paramIGroupListener)
  {
    if (!this.c.contains(paramIGroupListener)) {
      this.c.add(paramIGroupListener);
    }
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).a((ILoginCallback)new GroupManager.addGroupListener.1(this));
  }
  
  public void a(@NotNull String paramString, @NotNull List<String> paramList, @NotNull IResultListener<List<IGroupMemberInfo>> paramIResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "groupId");
    Intrinsics.checkParameterIsNotNull(paramList, "memberList");
    Intrinsics.checkParameterIsNotNull(paramIResultListener, "callback");
    V2TIMManager.getGroupManager().getGroupMembersInfo(paramString, paramList, (V2TIMValueCallback)new GroupManager.getGroupMembersInfo.1(paramIResultListener));
  }
  
  public void b(@Nullable IGroupListener paramIGroupListener)
  {
    this.c.remove(paramIGroupListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.group.GroupManager
 * JD-Core Version:    0.7.0.1
 */