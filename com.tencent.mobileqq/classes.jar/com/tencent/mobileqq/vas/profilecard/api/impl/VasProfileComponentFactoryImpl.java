package com.tencent.mobileqq.vas.profilecard.api.impl;

import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileComponentConst;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.component.accountinfo.VasProfileAccountInfoComponent;
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
import com.tencent.mobileqq.profilecard.vas.component.taglabel.VasProfileTagLabelComponent;
import com.tencent.mobileqq.profilecard.vas.component.template.VasProfileTemplateComponent;
import com.tencent.mobileqq.vas.profilecard.api.IVasProfileComponentFactory;

public class VasProfileComponentFactoryImpl
  implements IProfileComponentConst, IVasProfileComponentFactory
{
  private static final String TAG = "ProfileVasComponentFactory";
  
  private static AbsProfileComponent createProfileBgComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    long l = paramProfileCardInfo.curUseStyleId;
    if (ProfileTemplateApi.isDiyTemplateStyleID(l)) {
      return new VasProfileDiyBackgroundComponent(paramIComponentCenter, paramProfileCardInfo);
    }
    if ((l != ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC) && (l != ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC))
    {
      if (l == ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE) {
        return new VasProfileSimpleBackgroundComponent(paramIComponentCenter, paramProfileCardInfo);
      }
      return new VasProfileBackgroundComponent(paramIComponentCenter, paramProfileCardInfo);
    }
    return new VasProfileWzBackgroundComponent(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private static AbsProfileComponent createProfileHeaderComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    long l = paramProfileCardInfo.curUseStyleId;
    if ((l != ProfileCardTemplate.PROFILE_CARD_STYLE_FRESH) && (l != ProfileCardTemplate.PROFILE_CARD_STYLE_JANYUE) && (l != ProfileCardTemplate.PROFILE_CARD_STYLE_GAME))
    {
      if (l == ProfileCardTemplate.PROFILE_CARD_STYLE_SOCIAL) {
        return new VasProfileHeaderPhotoComponent(paramIComponentCenter, paramProfileCardInfo);
      }
      if (l == ProfileCardTemplate.PROFILE_CARD_STYLE_TAG) {
        return new VasProfileHeaderTagComponent(paramIComponentCenter, paramProfileCardInfo);
      }
      if (l == ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE) {
        return new VasProfileHeaderSimpleComponent(paramIComponentCenter, paramProfileCardInfo);
      }
      if ((l != ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC) && (l != ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC))
      {
        if (l == ProfileCardTemplate.PROFILE_CARD_STYLE_NEW_V800) {
          return new VasProfileHeaderV5Component(paramIComponentCenter, paramProfileCardInfo);
        }
        if (ProfileTemplateApi.isDiyTemplateStyleID(l)) {
          return new VasProfileHeaderDiyComponent(paramIComponentCenter, paramProfileCardInfo);
        }
        return null;
      }
      return new VasProfileHeaderWZRYComponent(paramIComponentCenter, paramProfileCardInfo);
    }
    return new VasProfileHeaderGameComponent(paramIComponentCenter, paramProfileCardInfo);
  }
  
  public AbsProfileComponent create(int paramInt, IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    if (paramInt != 1002)
    {
      if (paramInt != 1003)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 1034: 
          return new VasProfileTemplateComponent(paramIComponentCenter, paramProfileCardInfo);
        case 1033: 
          return new VasProfileTagLabelComponent(paramIComponentCenter, paramProfileCardInfo);
        }
        return new VasProfileAccountInfoComponent(paramIComponentCenter, paramProfileCardInfo);
      }
      return createProfileBgComponent(paramIComponentCenter, paramProfileCardInfo);
    }
    return createProfileHeaderComponent(paramIComponentCenter, paramProfileCardInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.profilecard.api.impl.VasProfileComponentFactoryImpl
 * JD-Core Version:    0.7.0.1
 */