package com.tencent.mobileqq.profilecard.collector;

import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileComponentConst;
import com.tencent.mobileqq.profilecard.base.container.ProfileBgContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileContentContainer;
import com.tencent.mobileqq.profilecard.base.container.ProfileFgContainer;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.ProfileAccountInfoHeaderComponent;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.ProfileAccountInfoV2Component;
import com.tencent.mobileqq.profilecard.bussiness.achievement.ProfileAchievementComponent;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.ProfileAnonymousComponent;
import com.tencent.mobileqq.profilecard.bussiness.contact.ProfileContactComponent;
import com.tencent.mobileqq.profilecard.bussiness.favor.ProfileFavorComponent;
import com.tencent.mobileqq.profilecard.bussiness.guide.ProfileGuideComponent;
import com.tencent.mobileqq.profilecard.bussiness.photowall.ProfilePhotoWallComponent;

public class ProfileComponentCollector
  implements IProfileComponentConst, IProfileComponentCollector
{
  public SparseArray<Class<? extends AbsProfileComponent>> collect()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(103, ProfileContentContainer.class);
    localSparseArray.put(104, ProfileBgContainer.class);
    localSparseArray.put(105, ProfileFgContainer.class);
    localSparseArray.put(1029, ProfileGuideComponent.class);
    localSparseArray.put(1007, ProfileAchievementComponent.class);
    localSparseArray.put(1026, ProfileAnonymousComponent.class);
    localSparseArray.put(1009, ProfilePhotoWallComponent.class);
    localSparseArray.put(1006, ProfileFavorComponent.class);
    localSparseArray.put(1023, ProfileAccountInfoV2Component.class);
    localSparseArray.put(1024, ProfileAccountInfoHeaderComponent.class);
    localSparseArray.put(1030, ProfileContactComponent.class);
    return localSparseArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.collector.ProfileComponentCollector
 * JD-Core Version:    0.7.0.1
 */