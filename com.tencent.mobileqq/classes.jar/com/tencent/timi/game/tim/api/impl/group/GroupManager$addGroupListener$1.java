package com.tencent.timi.game.tim.api.impl.group;

import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.timi.game.tim.api.ILoginCallback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/group/GroupManager$addGroupListener$1", "Lcom/tencent/timi/game/tim/api/ILoginCallback;", "onError", "", "errorCode", "", "errorMsg", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GroupManager$addGroupListener$1
  implements ILoginCallback
{
  public void a()
  {
    V2TIMManager.getInstance().setGroupListener(GroupManager.a(this.a));
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addGroupListener errorCode = [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], errorMsg = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append(']');
    Logger.b("GroupManager", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.group.GroupManager.addGroupListener.1
 * JD-Core Version:    0.7.0.1
 */