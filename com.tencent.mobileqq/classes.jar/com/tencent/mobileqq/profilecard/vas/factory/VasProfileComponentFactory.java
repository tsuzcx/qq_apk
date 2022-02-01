package com.tencent.mobileqq.profilecard.vas.factory;

import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.vas.component.background.VasProfileBackgroundComponent;
import com.tencent.mobileqq.profilecard.vas.component.background.VasProfileDiyBackgroundComponent;
import com.tencent.mobileqq.profilecard.vas.component.background.VasProfileSimpleBackgroundComponent;
import com.tencent.mobileqq.profilecard.vas.component.background.VasProfileWzBackgroundComponent;
import com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderDiyComponent;
import com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderGameComponent;
import com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderPhotoComponent;
import com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderSimpleComponent;
import com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderTagComponent;
import com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderV5Component;
import com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderWZRYComponent;

public class VasProfileComponentFactory
{
  private static final String TAG = "ProfileVasComponentFactory";
  
  public static IComponent create(int paramInt, IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1002: 
      return createProfileHeaderComponent(paramIComponentCenter, paramProfileCardInfo);
    }
    return createProfileBgComponent(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private static IComponent createProfileBgComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    long l = paramProfileCardInfo.a;
    if (ProfileCardTemplate.a(l)) {
      return new VasProfileDiyBackgroundComponent(paramIComponentCenter, paramProfileCardInfo);
    }
    if ((l == ProfileCardTemplate.i) || (l == ProfileCardTemplate.j)) {
      return new VasProfileWzBackgroundComponent(paramIComponentCenter, paramProfileCardInfo);
    }
    if (l == ProfileCardTemplate.g) {
      return new VasProfileSimpleBackgroundComponent(paramIComponentCenter, paramProfileCardInfo);
    }
    return new VasProfileBackgroundComponent(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private static IComponent createProfileHeaderComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    VasProfileHeaderGameComponent localVasProfileHeaderGameComponent = null;
    long l = paramProfileCardInfo.a;
    if ((l == ProfileCardTemplate.b) || (l == ProfileCardTemplate.c) || (l == ProfileCardTemplate.d)) {
      localVasProfileHeaderGameComponent = new VasProfileHeaderGameComponent(paramIComponentCenter, paramProfileCardInfo);
    }
    do
    {
      return localVasProfileHeaderGameComponent;
      if (l == ProfileCardTemplate.e) {
        return new VasProfileHeaderPhotoComponent(paramIComponentCenter, paramProfileCardInfo);
      }
      if (l == ProfileCardTemplate.f) {
        return new VasProfileHeaderTagComponent(paramIComponentCenter, paramProfileCardInfo);
      }
      if (l == ProfileCardTemplate.g) {
        return new VasProfileHeaderSimpleComponent(paramIComponentCenter, paramProfileCardInfo);
      }
      if ((l == ProfileCardTemplate.i) || (l == ProfileCardTemplate.j)) {
        return new VasProfileHeaderWZRYComponent(paramIComponentCenter, paramProfileCardInfo);
      }
      if (l == ProfileCardTemplate.k) {
        return new VasProfileHeaderV5Component(paramIComponentCenter, paramProfileCardInfo);
      }
    } while (!ProfileCardTemplate.a(l));
    return new VasProfileHeaderDiyComponent(paramIComponentCenter, paramProfileCardInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.factory.VasProfileComponentFactory
 * JD-Core Version:    0.7.0.1
 */