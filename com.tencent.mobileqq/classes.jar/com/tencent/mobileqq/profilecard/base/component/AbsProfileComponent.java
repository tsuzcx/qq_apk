package com.tencent.mobileqq.profilecard.base.component;

import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;

public abstract class AbsProfileComponent<VIEW>
  extends AbsComponent<VIEW, ProfileCardInfo>
{
  public AbsProfileComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent
 * JD-Core Version:    0.7.0.1
 */