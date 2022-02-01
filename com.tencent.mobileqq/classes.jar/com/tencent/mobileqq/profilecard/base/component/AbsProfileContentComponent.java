package com.tencent.mobileqq.profilecard.base.component;

import android.view.View;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

public abstract class AbsProfileContentComponent
  extends AbsProfileComponent<View>
{
  public AbsProfileContentComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  public abstract String getProfileContentKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
 * JD-Core Version:    0.7.0.1
 */