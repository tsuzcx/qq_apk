package com.tencent.mobileqq.profilecard.collector;

import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileComponentConst;
import com.tencent.mobileqq.profilecard.base.component.ProfileHeaderBaseComponent;
import com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileHeaderContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileLogicContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileTitleContainer;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelComponent;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelHeaderComponent;
import com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent;
import com.tencent.mobileqq.profilecard.bussiness.cmshow.ProfileCmShowComponent;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;
import com.tencent.mobileqq.profilecard.bussiness.diamondwall.ProfileDiamondWallComponent;
import com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMediaWallComponent;
import com.tencent.mobileqq.profilecard.bussiness.miniapp.ProfileMiniAppComponent;
import com.tencent.mobileqq.profilecard.bussiness.musicbox.ProfileMusicBoxComponent;
import com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent;
import com.tencent.mobileqq.profilecard.bussiness.presentwall.ProfilePresentWallComponent;
import com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent;
import com.tencent.mobileqq.profilecard.bussiness.stickynote.ProfileStickyNoteComponent;
import com.tencent.mobileqq.profilecard.bussiness.thirdapp.ProfileThirdAppComponent;
import com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent;
import com.tencent.mobileqq.profilecard.bussiness.troopgame.ProfileTroopMemGameInfoComponent;
import com.tencent.mobileqq.profilecard.bussiness.weishi.ProfileWeishiComponent;
import com.tencent.mobileqq.profilecard.vas.component.baseinfo.ProfileBaseInfoComponent;

public class TempProfileComponentCollector
  implements IProfileComponentConst, IProfileComponentCollector
{
  public SparseArray<Class<? extends AbsProfileComponent>> collect()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(102, ProfileHeaderContainer.class);
    localSparseArray.put(106, ProfileTitleContainer.class);
    localSparseArray.put(107, ProfileBottomContainer.class);
    localSparseArray.put(108, ProfileLogicContainer.class);
    localSparseArray.put(1002, ProfileHeaderBaseComponent.class);
    localSparseArray.put(1004, ProfileColorScreenComponent.class);
    localSparseArray.put(1005, ProfileStickyNoteComponent.class);
    localSparseArray.put(1010, ProfilePersonalityLabelComponent.class);
    localSparseArray.put(1011, ProfileContentSignComponent.class);
    localSparseArray.put(1012, ProfileQZoneComponent.class);
    localSparseArray.put(1013, ProfileTroopMemInfoComponent.class);
    localSparseArray.put(1014, ProfileMiniAppComponent.class);
    localSparseArray.put(1015, ProfileCircleComponent.class);
    localSparseArray.put(1016, ProfileWeishiComponent.class);
    localSparseArray.put(1017, ProfileMusicBoxComponent.class);
    localSparseArray.put(1018, ProfilePresentWallComponent.class);
    localSparseArray.put(1019, ProfileDiamondWallComponent.class);
    localSparseArray.put(1020, ProfileCmShowComponent.class);
    localSparseArray.put(1021, ProfileAccountLevelComponent.class);
    localSparseArray.put(1022, ProfileAccountLevelHeaderComponent.class);
    localSparseArray.put(1025, ProfileMediaWallComponent.class);
    localSparseArray.put(1027, ProfileTroopFansInfoComponent.class);
    localSparseArray.put(1028, ProfileTroopMemGameInfoComponent.class);
    localSparseArray.put(1031, ProfileThirdAppComponent.class);
    localSparseArray.put(1035, ProfileBaseInfoComponent.class);
    return localSparseArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.collector.TempProfileComponentCollector
 * JD-Core Version:    0.7.0.1
 */