package com.tencent.mobileqq.qqexpand.profilecard.impl;

import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qqexpand.profilecard.IExpandProfileComponentUtils;
import com.tencent.mobileqq.qqexpand.profilecard.ProfileExtendFriendComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/profilecard/impl/ExpandProfileComponentUtilsImpl;", "Lcom/tencent/mobileqq/qqexpand/profilecard/IExpandProfileComponentUtils;", "()V", "interceptAddFriend", "", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "info", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandProfileComponentUtilsImpl
  implements IExpandProfileComponentUtils
{
  public boolean interceptAddFriend(@NotNull IComponentCenter paramIComponentCenter, @NotNull ProfileCardInfo paramProfileCardInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramIComponentCenter, "componentCenter");
    Intrinsics.checkParameterIsNotNull(paramProfileCardInfo, "info");
    IComponent localIComponent = paramIComponentCenter.getComponent(1008);
    paramIComponentCenter = localIComponent;
    if (!(localIComponent instanceof ProfileExtendFriendComponent)) {
      paramIComponentCenter = null;
    }
    paramIComponentCenter = (ProfileExtendFriendComponent)paramIComponentCenter;
    if (paramIComponentCenter != null) {
      return paramIComponentCenter.b(paramProfileCardInfo);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.impl.ExpandProfileComponentUtilsImpl
 * JD-Core Version:    0.7.0.1
 */