package com.tencent.timi.game.tim.api.impl.group;

import com.tencent.imsdk.v2.V2TIMGroupListener;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.group.IGroupListener;
import com.tencent.timi.game.tim.api.group.IGroupMemberInfo;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass.TimMsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/group/GroupManager$v2TIMGroupListener$1", "Lcom/tencent/imsdk/v2/V2TIMGroupListener;", "onGroupCreated", "", "groupID", "", "onGroupDismissed", "opUser", "Lcom/tencent/imsdk/v2/V2TIMGroupMemberInfo;", "onMemberInvited", "memberList", "", "onMemberKicked", "onMemberLeave", "member", "onReceiveRESTCustomData", "customData", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GroupManager$v2TIMGroupListener$1
  extends V2TIMGroupListener
{
  public void onGroupCreated(@Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGroupCreated: ");
    localStringBuilder.append(paramString);
    Logger.a("GroupManager", localStringBuilder.toString());
  }
  
  public void onGroupDismissed(@NotNull String paramString, @NotNull V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "groupID");
    Intrinsics.checkParameterIsNotNull(paramV2TIMGroupMemberInfo, "opUser");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGroupDismissed: ");
    localStringBuilder.append(paramString);
    Logger.a("GroupManager", localStringBuilder.toString());
    paramString = UStringsKt.toULongOrNull(paramString);
    if (paramString != null)
    {
      long l = paramString.unbox-impl();
      paramString = ((Iterable)GroupManager.b(this.a)).iterator();
      while (paramString.hasNext()) {
        ((IGroupListener)paramString.next()).b(l, (IGroupMemberInfo)new GroupMemberInfo(paramV2TIMGroupMemberInfo));
      }
    }
  }
  
  public void onMemberInvited(@NotNull String paramString, @NotNull V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo, @NotNull List<V2TIMGroupMemberInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "groupID");
    Intrinsics.checkParameterIsNotNull(paramV2TIMGroupMemberInfo, "opUser");
    Intrinsics.checkParameterIsNotNull(paramList, "memberList");
    paramString = UStringsKt.toULongOrNull(paramString);
    if (paramString != null)
    {
      long l = paramString.unbox-impl();
      paramString = ((Iterable)GroupManager.b(this.a)).iterator();
      while (paramString.hasNext())
      {
        IGroupListener localIGroupListener = (IGroupListener)paramString.next();
        IGroupMemberInfo localIGroupMemberInfo = (IGroupMemberInfo)new GroupMemberInfo(paramV2TIMGroupMemberInfo);
        Object localObject = (Iterable)paramList;
        Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localCollection.add(new GroupMemberInfo((V2TIMGroupMemberInfo)((Iterator)localObject).next()));
        }
        localIGroupListener.a(l, localIGroupMemberInfo, (List)localCollection);
      }
    }
  }
  
  public void onMemberKicked(@NotNull String paramString, @NotNull V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo, @NotNull List<V2TIMGroupMemberInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "groupID");
    Intrinsics.checkParameterIsNotNull(paramV2TIMGroupMemberInfo, "opUser");
    Intrinsics.checkParameterIsNotNull(paramList, "memberList");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onMemberKicked: ");
    ((StringBuilder)localObject1).append(paramString);
    Logger.a("GroupManager", ((StringBuilder)localObject1).toString());
    paramString = UStringsKt.toULongOrNull(paramString);
    if (paramString != null)
    {
      long l = paramString.unbox-impl();
      paramString = ((Iterable)GroupManager.b(this.a)).iterator();
      while (paramString.hasNext())
      {
        localObject1 = (IGroupListener)paramString.next();
        IGroupMemberInfo localIGroupMemberInfo = (IGroupMemberInfo)new GroupMemberInfo(paramV2TIMGroupMemberInfo);
        Object localObject2 = (Iterable)paramList;
        Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localCollection.add(new GroupMemberInfo((V2TIMGroupMemberInfo)((Iterator)localObject2).next()));
        }
        ((IGroupListener)localObject1).b(l, localIGroupMemberInfo, (List)localCollection);
      }
    }
  }
  
  public void onMemberLeave(@NotNull String paramString, @NotNull V2TIMGroupMemberInfo paramV2TIMGroupMemberInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "groupID");
    Intrinsics.checkParameterIsNotNull(paramV2TIMGroupMemberInfo, "member");
    paramString = UStringsKt.toULongOrNull(paramString);
    if (paramString != null)
    {
      long l = paramString.unbox-impl();
      paramString = ((Iterable)GroupManager.b(this.a)).iterator();
      while (paramString.hasNext()) {
        ((IGroupListener)paramString.next()).a(l, (IGroupMemberInfo)new GroupMemberInfo(paramV2TIMGroupMemberInfo));
      }
    }
  }
  
  public void onReceiveRESTCustomData(@NotNull String paramString, @Nullable byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "groupID");
    super.onReceiveRESTCustomData(paramString, paramArrayOfByte);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceiveRESTCustomData() called with: groupID = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(']');
    Logger.b("GroupManager", ((StringBuilder)localObject).toString());
    try
    {
      paramArrayOfByte = (MessageOuterClass.TimMsgBody)new MessageOuterClass.TimMsgBody().mergeFrom(Base64Util.decode(paramArrayOfByte, 0));
      localObject = (ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class);
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "timMsg");
      ((ITimiGameTimApi)localObject).a(paramString, paramArrayOfByte);
      return;
    }
    catch (Exception paramString)
    {
      Logger.a("GroupManager", "onReceiveRESTCustomData error", (Throwable)paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.group.GroupManager.v2TIMGroupListener.1
 * JD-Core Version:    0.7.0.1
 */