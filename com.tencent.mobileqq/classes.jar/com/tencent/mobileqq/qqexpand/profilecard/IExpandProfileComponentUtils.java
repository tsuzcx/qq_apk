package com.tencent.mobileqq.qqexpand.profilecard;

import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/profilecard/IExpandProfileComponentUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "interceptAddFriend", "", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "info", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandProfileComponentUtils
  extends QRouteApi
{
  public abstract boolean interceptAddFriend(@NotNull IComponentCenter paramIComponentCenter, @NotNull ProfileCardInfo paramProfileCardInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.IExpandProfileComponentUtils
 * JD-Core Version:    0.7.0.1
 */