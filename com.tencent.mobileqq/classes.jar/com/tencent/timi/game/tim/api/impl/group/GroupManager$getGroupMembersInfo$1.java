package com.tencent.timi.game.tim.api.impl.group;

import com.tencent.imsdk.v2.V2TIMGroupMemberFullInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/group/GroupManager$getGroupMembersInfo$1", "Lcom/tencent/imsdk/v2/V2TIMValueCallback;", "", "Lcom/tencent/imsdk/v2/V2TIMGroupMemberFullInfo;", "onError", "", "p0", "", "p1", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GroupManager$getGroupMembersInfo$1
  implements V2TIMValueCallback<List<? extends V2TIMGroupMemberFullInfo>>
{
  GroupManager$getGroupMembersInfo$1(IResultListener paramIResultListener) {}
  
  public void a(@Nullable List<? extends V2TIMGroupMemberFullInfo> paramList)
  {
    IResultListener localIResultListener = this.a;
    if (paramList != null)
    {
      Object localObject = (Iterable)paramList;
      paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add(new GroupMemberInfo((V2TIMGroupMemberInfo)((Iterator)localObject).next()));
      }
      paramList = (List)paramList;
    }
    else
    {
      paramList = CollectionsKt.emptyList();
    }
    localIResultListener.a(paramList);
  }
  
  public void onError(int paramInt, @Nullable String paramString)
  {
    this.a.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.group.GroupManager.getGroupMembersInfo.1
 * JD-Core Version:    0.7.0.1
 */