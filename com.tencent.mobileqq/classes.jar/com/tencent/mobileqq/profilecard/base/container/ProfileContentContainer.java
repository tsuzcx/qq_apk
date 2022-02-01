package com.tencent.mobileqq.profilecard.base.container;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.factory.ProfileComponentFactory;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.ProfileAccountInfoV2Component;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelComponent;
import com.tencent.mobileqq.profilecard.bussiness.achievement.ProfileAchievementComponent;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.ProfileAnonymousComponent;
import com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent;
import com.tencent.mobileqq.profilecard.bussiness.diamondwall.ProfileDiamondWallComponent;
import com.tencent.mobileqq.profilecard.bussiness.extendfriend.ProfileExtendFriendComponent;
import com.tencent.mobileqq.profilecard.bussiness.favor.ProfileFavorComponent;
import com.tencent.mobileqq.profilecard.bussiness.guide.ProfileGuideComponent;
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
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PullToZoomHeaderListView;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class ProfileContentContainer
  extends AbsProfileComponent<ProfileCardMoreInfoView>
{
  private static final String TAG = "ProfileContentContainer";
  private ProfileAccountInfoV2Component mAccountInfoV2Component;
  private ProfileAccountLevelComponent mAccountLevelComponent;
  private ProfileAchievementComponent mAchievementComponent;
  private ProfileAnonymousComponent mAnonymousComponent;
  private ProfileCircleComponent mCircleComponent;
  private ProfileConfigHelper mConfigHelper;
  private ProfileContentSignComponent mContentSignComponent;
  private ProfileExtendFriendComponent mExtendFriendComponent;
  private ProfileFavorComponent mFavorComponent;
  private PullToZoomHeaderListView mListView;
  private ProfileDiamondWallComponent mMedalWallComponent;
  private ProfileMiniAppComponent mMiniAppPlayingComponent;
  private ProfileMusicBoxComponent mMusicBoxComponent;
  private ProfilePersonalityLabelComponent mPersonalityLabelComponent;
  private ProfilePhotoWallComponent mPhotoWallComponent;
  private ProfilePresentWallComponent mPresentWallComponent;
  private IProfileActivityDelegate mProfileDelegate;
  private ProfileGuideComponent mProfileGuideComponent;
  private ProfileTroopMemGameInfoComponent mProfileTroopMemGameCardComponent;
  private ProfileTroopMemInfoComponent mProfileTroopMemInfoComponent;
  private ProfileQZoneComponent mQZoneComponent;
  private ProfileStickyNoteComponent mStickyNoteComponent;
  private ProfileTroopFansInfoComponent mTroopFansInfoComponent;
  private ProfileWeishiComponent mWeishiComponent;
  
  public ProfileContentContainer(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void destroyComponent(AbsProfileContentComponent paramAbsProfileContentComponent)
  {
    if (paramAbsProfileContentComponent != null)
    {
      removeComponent(paramAbsProfileContentComponent);
      paramAbsProfileContentComponent.detachFromComponentCenter();
    }
  }
  
  private void initAccountInfoV2Component()
  {
    if (this.mAccountInfoV2Component == null)
    {
      this.mAccountInfoV2Component = ((ProfileAccountInfoV2Component)ProfileComponentFactory.create(1023, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mAccountInfoV2Component.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mAccountInfoV2Component.attachToComponentCenter();
      addComponent(this.mAccountInfoV2Component);
    }
  }
  
  private void initAccountLevelComponent()
  {
    if (this.mAccountLevelComponent == null)
    {
      this.mAccountLevelComponent = ((ProfileAccountLevelComponent)ProfileComponentFactory.create(1021, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mAccountLevelComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mAccountLevelComponent.attachToComponentCenter();
      addComponent(this.mAccountLevelComponent);
    }
  }
  
  private void initAchievementComponent()
  {
    if (this.mAchievementComponent == null)
    {
      this.mAchievementComponent = ((ProfileAchievementComponent)ProfileComponentFactory.create(1007, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mAchievementComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mAchievementComponent.attachToComponentCenter();
      addComponent(this.mAchievementComponent);
    }
  }
  
  private void initAnonymousComponent()
  {
    if (this.mAnonymousComponent == null)
    {
      this.mAnonymousComponent = ((ProfileAnonymousComponent)ProfileComponentFactory.create(1026, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mAnonymousComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mAnonymousComponent.attachToComponentCenter();
      addComponent(this.mAnonymousComponent);
    }
  }
  
  private void initCircleComponent()
  {
    if (this.mCircleComponent == null)
    {
      this.mCircleComponent = ((ProfileCircleComponent)ProfileComponentFactory.create(1015, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mCircleComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mCircleComponent.attachToComponentCenter();
      addComponent(this.mCircleComponent);
    }
  }
  
  private void initContentSignComponent()
  {
    if (this.mContentSignComponent == null)
    {
      this.mContentSignComponent = ((ProfileContentSignComponent)ProfileComponentFactory.create(1011, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mContentSignComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mContentSignComponent.attachToComponentCenter();
      addComponent(this.mContentSignComponent);
    }
  }
  
  private void initExtendFriendComponent()
  {
    if (this.mExtendFriendComponent == null)
    {
      this.mExtendFriendComponent = ((ProfileExtendFriendComponent)ProfileComponentFactory.create(1008, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mExtendFriendComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mExtendFriendComponent.attachToComponentCenter();
      addComponent(this.mExtendFriendComponent);
    }
  }
  
  private void initFavorComponent()
  {
    if (this.mFavorComponent == null)
    {
      this.mFavorComponent = ((ProfileFavorComponent)ProfileComponentFactory.create(1006, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mFavorComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mFavorComponent.attachToComponentCenter();
      addComponent(this.mFavorComponent);
    }
  }
  
  private void initMedalWallComponent()
  {
    if (this.mMedalWallComponent == null)
    {
      this.mMedalWallComponent = ((ProfileDiamondWallComponent)ProfileComponentFactory.create(1019, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mMedalWallComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mMedalWallComponent.attachToComponentCenter();
      addComponent(this.mMedalWallComponent);
    }
  }
  
  private void initMiniAppPlayingComponent()
  {
    if (this.mMiniAppPlayingComponent == null)
    {
      this.mMiniAppPlayingComponent = ((ProfileMiniAppComponent)ProfileComponentFactory.create(1014, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mMiniAppPlayingComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mMiniAppPlayingComponent.attachToComponentCenter();
      addComponent(this.mMiniAppPlayingComponent);
    }
  }
  
  private void initMusicBoxComponent()
  {
    if (this.mMusicBoxComponent == null)
    {
      this.mMusicBoxComponent = ((ProfileMusicBoxComponent)ProfileComponentFactory.create(1017, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mMusicBoxComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mMusicBoxComponent.attachToComponentCenter();
      addComponent(this.mMusicBoxComponent);
    }
  }
  
  private void initPersonalityLabelComponent()
  {
    if (this.mPersonalityLabelComponent == null)
    {
      this.mPersonalityLabelComponent = ((ProfilePersonalityLabelComponent)ProfileComponentFactory.create(1010, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mPersonalityLabelComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mPersonalityLabelComponent.attachToComponentCenter();
      addComponent(this.mPersonalityLabelComponent);
    }
  }
  
  private void initPhotoWallComponent()
  {
    if (this.mPhotoWallComponent == null)
    {
      this.mPhotoWallComponent = ((ProfilePhotoWallComponent)ProfileComponentFactory.create(1009, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mPhotoWallComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mPhotoWallComponent.attachToComponentCenter();
      addComponent(this.mPhotoWallComponent);
    }
  }
  
  private void initPresentComponent()
  {
    if (this.mPresentWallComponent == null)
    {
      this.mPresentWallComponent = ((ProfilePresentWallComponent)ProfileComponentFactory.create(1018, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mPresentWallComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mPresentWallComponent.attachToComponentCenter();
      addComponent(this.mPresentWallComponent);
    }
  }
  
  private void initProfileGuideComponent()
  {
    if (this.mProfileGuideComponent == null)
    {
      this.mProfileGuideComponent = ((ProfileGuideComponent)ProfileComponentFactory.create(1029, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mProfileGuideComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mProfileGuideComponent.attachToComponentCenter();
      addComponent(this.mProfileGuideComponent);
    }
  }
  
  private void initQZoneComponent()
  {
    if (this.mQZoneComponent == null)
    {
      this.mQZoneComponent = ((ProfileQZoneComponent)ProfileComponentFactory.create(1012, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mQZoneComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mQZoneComponent.attachToComponentCenter();
      addComponent(this.mQZoneComponent);
    }
  }
  
  private void initStickyNoteComponent()
  {
    if (this.mStickyNoteComponent == null)
    {
      this.mStickyNoteComponent = ((ProfileStickyNoteComponent)ProfileComponentFactory.create(1005, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mStickyNoteComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mStickyNoteComponent.setProfileArgs(this.mListView);
      this.mStickyNoteComponent.attachToComponentCenter();
      addComponent(this.mStickyNoteComponent);
    }
  }
  
  private void initTroopFansInfoComponent()
  {
    if (this.mTroopFansInfoComponent == null)
    {
      this.mTroopFansInfoComponent = ((ProfileTroopFansInfoComponent)ProfileComponentFactory.create(1027, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mTroopFansInfoComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mTroopFansInfoComponent.attachToComponentCenter();
      addComponent(this.mTroopFansInfoComponent);
    }
  }
  
  private void initTroopMemGameCardComponent()
  {
    if (this.mProfileTroopMemGameCardComponent == null)
    {
      this.mProfileTroopMemGameCardComponent = ((ProfileTroopMemGameInfoComponent)ProfileComponentFactory.create(1028, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mProfileTroopMemGameCardComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mProfileTroopMemGameCardComponent.attachToComponentCenter();
      addComponent(this.mProfileTroopMemGameCardComponent);
    }
  }
  
  private void initTroopMemInfoComponent()
  {
    if (this.mProfileTroopMemInfoComponent == null)
    {
      this.mProfileTroopMemInfoComponent = ((ProfileTroopMemInfoComponent)ProfileComponentFactory.create(1013, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mProfileTroopMemInfoComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mProfileTroopMemInfoComponent.attachToComponentCenter();
      addComponent(this.mProfileTroopMemInfoComponent);
      this.mProfileTroopMemInfoComponent.init();
    }
  }
  
  private void initWeishiComponent()
  {
    if (this.mWeishiComponent == null)
    {
      this.mWeishiComponent = ((ProfileWeishiComponent)ProfileComponentFactory.create(1016, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mWeishiComponent.setCommonDependence(this.mProfileDelegate, this.mConfigHelper, ((ProfileCardMoreInfoView)this.mViewContainer).a);
      this.mWeishiComponent.attachToComponentCenter();
      addComponent(this.mWeishiComponent);
    }
  }
  
  public String getComponentName()
  {
    return "ProfileContentContainer";
  }
  
  public int getComponentType()
  {
    return 103;
  }
  
  public void onCreate(@NotNull BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    initStickyNoteComponent();
    initFavorComponent();
    initAchievementComponent();
    initExtendFriendComponent();
    initPhotoWallComponent();
    initPersonalityLabelComponent();
    initContentSignComponent();
    initCircleComponent();
    initQZoneComponent();
    initMiniAppPlayingComponent();
    initTroopMemInfoComponent();
    initMusicBoxComponent();
    initPresentComponent();
    initMedalWallComponent();
    initWeishiComponent();
    initAccountLevelComponent();
    initAccountInfoV2Component();
    initAnonymousComponent();
    initTroopFansInfoComponent();
    initTroopMemGameCardComponent();
    initProfileGuideComponent();
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileContentContainer", 2, String.format("onDateUpdate this=%s", new Object[] { this }));
    }
    this.mData = paramProfileCardInfo;
    int j = this.mChildComponent.size();
    int i = 0;
    boolean bool1 = false;
    Object localObject;
    if (i < j)
    {
      localObject = (AbsProfileContentComponent)this.mChildComponent.valueAt(i);
      if (localObject == null) {
        break label234;
      }
    }
    label234:
    for (;;)
    {
      try
      {
        bool2 = ((AbsProfileContentComponent)localObject).onDataUpdate(paramProfileCardInfo);
        String str = ((AbsProfileContentComponent)localObject).getProfileContentKey();
        localView = (View)((AbsProfileContentComponent)localObject).getContainerView();
        if (localView != null)
        {
          localObject = localView.getParent();
          if (QLog.isColorLevel()) {
            QLog.d("ProfileContentContainer", 2, String.format("onDataUpdate update=%s key=%s view=%s viewParent=%s", new Object[] { Boolean.valueOf(bool2), str, localView, localObject }));
          }
          if (bool2)
          {
            localObject = ((ProfileCardMoreInfoView)this.mViewContainer).a();
            if (localView != null) {
              continue;
            }
            ((HashMap)localObject).remove(str);
          }
          bool1 |= bool2;
          i += 1;
        }
      }
      catch (Exception localException)
      {
        View localView;
        QLog.e("ProfileContentContainer", 1, "onDataUpdate fail.", localException);
        boolean bool2 = false;
        continue;
        localObject = null;
        continue;
        ((HashMap)localObject).put(localException, localView);
        continue;
      }
      return bool1;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    destroyComponent(this.mStickyNoteComponent);
    this.mStickyNoteComponent = null;
    destroyComponent(this.mFavorComponent);
    this.mFavorComponent = null;
    destroyComponent(this.mAchievementComponent);
    this.mAchievementComponent = null;
    destroyComponent(this.mExtendFriendComponent);
    this.mExtendFriendComponent = null;
    destroyComponent(this.mPhotoWallComponent);
    this.mPhotoWallComponent = null;
    destroyComponent(this.mPersonalityLabelComponent);
    this.mPersonalityLabelComponent = null;
    destroyComponent(this.mContentSignComponent);
    this.mContentSignComponent = null;
    destroyComponent(this.mQZoneComponent);
    this.mQZoneComponent = null;
    destroyComponent(this.mCircleComponent);
    this.mCircleComponent = null;
    destroyComponent(this.mProfileTroopMemInfoComponent);
    this.mProfileTroopMemInfoComponent = null;
    destroyComponent(this.mMusicBoxComponent);
    this.mMusicBoxComponent = null;
    destroyComponent(this.mPresentWallComponent);
    this.mPresentWallComponent = null;
    destroyComponent(this.mMedalWallComponent);
    this.mMedalWallComponent = null;
    destroyComponent(this.mWeishiComponent);
    this.mWeishiComponent = null;
    destroyComponent(this.mStickyNoteComponent);
    this.mStickyNoteComponent = null;
    destroyComponent(this.mAccountLevelComponent);
    this.mAccountLevelComponent = null;
    destroyComponent(this.mAccountInfoV2Component);
    this.mAccountInfoV2Component = null;
    destroyComponent(this.mAnonymousComponent);
    this.mAnonymousComponent = null;
    destroyComponent(this.mTroopFansInfoComponent);
    this.mTroopFansInfoComponent = null;
    destroyComponent(this.mProfileTroopMemGameCardComponent);
    this.mProfileTroopMemGameCardComponent = null;
    destroyComponent(this.mProfileGuideComponent);
    this.mProfileGuideComponent = null;
  }
  
  public void setProfileArgs(ProfileConfigHelper paramProfileConfigHelper, PullToZoomHeaderListView paramPullToZoomHeaderListView)
  {
    this.mConfigHelper = paramProfileConfigHelper;
    this.mListView = paramPullToZoomHeaderListView;
  }
  
  public void setProfileDelegate(IProfileActivityDelegate paramIProfileActivityDelegate)
  {
    this.mProfileDelegate = paramIProfileActivityDelegate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileContentContainer
 * JD-Core Version:    0.7.0.1
 */