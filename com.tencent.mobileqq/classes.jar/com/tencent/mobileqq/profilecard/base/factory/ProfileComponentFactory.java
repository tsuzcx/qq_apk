package com.tencent.mobileqq.profilecard.base.factory;

import android.util.SparseArray;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.ProfileHeaderBaseComponent;
import com.tencent.mobileqq.profilecard.base.container.ProfileBgContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileContentContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileFgContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileHeaderContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileTitleContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.ProfileAccountInfoHeaderComponent;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.ProfileAccountInfoV2Component;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelComponent;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelHeaderComponent;
import com.tencent.mobileqq.profilecard.bussiness.achievement.ProfileAchievementComponent;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.ProfileAnonymousComponent;
import com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent;
import com.tencent.mobileqq.profilecard.bussiness.cmshow.ProfileCmShowComponent;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;
import com.tencent.mobileqq.profilecard.bussiness.diamondwall.ProfileDiamondWallComponent;
import com.tencent.mobileqq.profilecard.bussiness.extendfriend.ProfileExtendFriendComponent;
import com.tencent.mobileqq.profilecard.bussiness.favor.ProfileFavorComponent;
import com.tencent.mobileqq.profilecard.bussiness.guide.ProfileGuideComponent;
import com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMediaWallComponent;
import com.tencent.mobileqq.profilecard.bussiness.miniapp.ProfileMiniAppComponent;
import com.tencent.mobileqq.profilecard.bussiness.musicbox.ProfileMusicBoxComponent;
import com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent;
import com.tencent.mobileqq.profilecard.bussiness.photowall.ProfilePhotoWallComponent;
import com.tencent.mobileqq.profilecard.bussiness.presentwall.ProfilePresentWallComponent;
import com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent;
import com.tencent.mobileqq.profilecard.bussiness.stickynote.ProfileStickyNoteComponent;
import com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent;
import com.tencent.mobileqq.profilecard.bussiness.troopgame.ProfileTroopMemGameInfoComponent;
import com.tencent.mobileqq.profilecard.bussiness.weishi.ProfileWeishiComponent;
import com.tencent.mobileqq.profilecard.vas.factory.VasProfileComponentFactory;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;

public class ProfileComponentFactory
{
  private static SparseArray<Class<? extends AbsProfileComponent>> PROFILE_COMPONENT_MAP = new SparseArray();
  private static final String TAG = "ProfileComponentFactory";
  
  static
  {
    PROFILE_COMPONENT_MAP.put(102, ProfileHeaderContainer.class);
    PROFILE_COMPONENT_MAP.put(103, ProfileContentContainer.class);
    PROFILE_COMPONENT_MAP.put(104, ProfileBgContainer.class);
    PROFILE_COMPONENT_MAP.put(105, ProfileFgContainer.class);
    PROFILE_COMPONENT_MAP.put(106, ProfileTitleContainer.class);
    PROFILE_COMPONENT_MAP.put(1002, ProfileHeaderBaseComponent.class);
    PROFILE_COMPONENT_MAP.put(1004, ProfileColorScreenComponent.class);
    PROFILE_COMPONENT_MAP.put(1005, ProfileStickyNoteComponent.class);
    PROFILE_COMPONENT_MAP.put(1006, ProfileFavorComponent.class);
    PROFILE_COMPONENT_MAP.put(1007, ProfileAchievementComponent.class);
    PROFILE_COMPONENT_MAP.put(1008, ProfileExtendFriendComponent.class);
    PROFILE_COMPONENT_MAP.put(1009, ProfilePhotoWallComponent.class);
    PROFILE_COMPONENT_MAP.put(1010, ProfilePersonalityLabelComponent.class);
    PROFILE_COMPONENT_MAP.put(1011, ProfileContentSignComponent.class);
    PROFILE_COMPONENT_MAP.put(1012, ProfileQZoneComponent.class);
    PROFILE_COMPONENT_MAP.put(1013, ProfileTroopMemInfoComponent.class);
    PROFILE_COMPONENT_MAP.put(1014, ProfileMiniAppComponent.class);
    PROFILE_COMPONENT_MAP.put(1015, ProfileCircleComponent.class);
    PROFILE_COMPONENT_MAP.put(1016, ProfileWeishiComponent.class);
    PROFILE_COMPONENT_MAP.put(1017, ProfileMusicBoxComponent.class);
    PROFILE_COMPONENT_MAP.put(1018, ProfilePresentWallComponent.class);
    PROFILE_COMPONENT_MAP.put(1019, ProfileDiamondWallComponent.class);
    PROFILE_COMPONENT_MAP.put(1020, ProfileCmShowComponent.class);
    PROFILE_COMPONENT_MAP.put(1021, ProfileAccountLevelComponent.class);
    PROFILE_COMPONENT_MAP.put(1022, ProfileAccountLevelHeaderComponent.class);
    PROFILE_COMPONENT_MAP.put(1023, ProfileAccountInfoV2Component.class);
    PROFILE_COMPONENT_MAP.put(1024, ProfileAccountInfoHeaderComponent.class);
    PROFILE_COMPONENT_MAP.put(1025, ProfileMediaWallComponent.class);
    PROFILE_COMPONENT_MAP.put(1026, ProfileAnonymousComponent.class);
    PROFILE_COMPONENT_MAP.put(1027, ProfileTroopFansInfoComponent.class);
    PROFILE_COMPONENT_MAP.put(1028, ProfileTroopMemGameInfoComponent.class);
    PROFILE_COMPONENT_MAP.put(1029, ProfileGuideComponent.class);
  }
  
  public static IComponent create(int paramInt, IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileComponentFactory", 2, String.format("create componentType=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    IComponent localIComponent = VasProfileComponentFactory.create(paramInt, paramIComponentCenter, paramProfileCardInfo);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileComponentFactory", 2, String.format("create from vas component factory. component=%s", new Object[] { localIComponent }));
    }
    if (localIComponent == null)
    {
      Class localClass = (Class)PROFILE_COMPONENT_MAP.get(paramInt);
      if (localClass != null) {}
      for (;;)
      {
        try
        {
          paramIComponentCenter = (IComponent)localClass.getConstructor(new Class[] { IComponentCenter.class, ProfileCardInfo.class }).newInstance(new Object[] { paramIComponentCenter, paramProfileCardInfo });
          if (QLog.isColorLevel()) {
            QLog.d("ProfileComponentFactory", 2, String.format("create from base component factory. component=%s", new Object[] { paramIComponentCenter }));
          }
          return paramIComponentCenter;
        }
        catch (Exception paramIComponentCenter)
        {
          QLog.e("ProfileComponentFactory", 1, "create component fail.", paramIComponentCenter);
        }
        paramIComponentCenter = localIComponent;
      }
    }
    return localIComponent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.factory.ProfileComponentFactory
 * JD-Core Version:    0.7.0.1
 */