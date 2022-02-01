package com.tencent.mobileqq.vas.profilecard.api;

import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IVasProfileComponentFactory
  extends QRouteApi
{
  public abstract AbsProfileComponent create(int paramInt, IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.profilecard.api.IVasProfileComponentFactory
 * JD-Core Version:    0.7.0.1
 */