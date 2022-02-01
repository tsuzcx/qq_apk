package com.tencent.mobileqq.profilecard.bussiness.stickynote;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PullToZoomHeaderListView;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.stickynote.QzoneStickyNoteManager;

public class ProfileStickyNoteComponent
  extends AbsProfileContentComponent
{
  private static final String TAG = "ProfileStickyNoteComponent";
  private boolean mFirstNetUpdated;
  private PullToZoomHeaderListView mListView;
  private QzoneStickyNoteManager mStickyNoteManager;
  
  public ProfileStickyNoteComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void destroyStickyNoteManager()
  {
    if (this.mStickyNoteManager != null)
    {
      if (this.mDelegate != null) {
        this.mDelegate.removeProfileScrollListener(this.mStickyNoteManager);
      }
      this.mStickyNoteManager.destroy();
      this.mStickyNoteManager = null;
    }
  }
  
  private void initStickyNoteManager(Card paramCard, View paramView)
  {
    if (this.mStickyNoteManager == null)
    {
      this.mStickyNoteManager = new QzoneStickyNoteManager();
      this.mStickyNoteManager.init(this.mActivity, this.mApp, paramCard, this.mListView, paramView, this);
      if (this.mDelegate != null) {
        this.mDelegate.addProfileScrollListener(this.mStickyNoteManager);
      }
    }
  }
  
  private boolean makeOrRefreshStickyNote(Card paramCard, boolean paramBoolean)
  {
    boolean bool4 = true;
    boolean bool1;
    boolean bool2;
    label50:
    boolean bool5;
    if ((this.mConfigHelper == null) || (this.mConfigHelper.a(8)))
    {
      bool1 = true;
      if (((!this.mFirstNetUpdated) && (!paramBoolean)) || (paramCard == null) || (paramCard.switchStickyNote == 1)) {
        break label192;
      }
      bool2 = true;
      bool5 = ProfileActivity.AllInOne.b(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      bool3 = QZoneApiProxy.isRightAndroidVersionForStickyNote();
      if ((!bool1) || (!bool2) || (!bool5) || (!bool3)) {
        break label198;
      }
    }
    label192:
    label198:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileStickyNoteComponent", 2, String.format("makeOrRefreshStickyNote showStickyNote=%s configEnable=%s switchEnable=%s isFriend=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool5) }));
      }
      if ((!this.mFirstNetUpdated) && (paramBoolean)) {
        this.mFirstNetUpdated = true;
      }
      if ((paramCard != null) && (bool3)) {
        break label204;
      }
      destroyStickyNoteManager();
      if (this.mViewContainer == null) {
        break label292;
      }
      this.mViewContainer = null;
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label50;
    }
    label204:
    if (this.mViewContainer == null)
    {
      ProfileContentTitleView localProfileContentTitleView = new ProfileContentTitleView(this.mActivity);
      localProfileContentTitleView.setTitle(this.mActivity.getString(2131691272));
      localProfileContentTitleView.setArrowEnable(false);
      localProfileContentTitleView.setMarginBottomEnable(false);
      localProfileContentTitleView.setVisibility(8);
      initStickyNoteManager(paramCard, localProfileContentTitleView);
      this.mViewContainer = localProfileContentTitleView;
    }
    for (paramBoolean = bool4;; paramBoolean = false)
    {
      updateItemTheme((ProfileContentTitleView)this.mViewContainer, false);
      return paramBoolean;
    }
    label292:
    return false;
  }
  
  public String getComponentName()
  {
    return "ProfileStickyNoteComponent";
  }
  
  public int getComponentType()
  {
    return 1005;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_sticky_note";
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (((paramInt1 == 20121207) || (paramInt1 == 20121208) || (paramInt1 == 201209)) && (this.mStickyNoteManager != null)) {
      this.mStickyNoteManager.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshStickyNote(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, ((ProfileCardInfo)this.mData).d) | bool;
  }
  
  public void onDestroy()
  {
    destroyStickyNoteManager();
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mStickyNoteManager != null) {
      this.mStickyNoteManager.onResume();
    }
  }
  
  public void setProfileArgs(PullToZoomHeaderListView paramPullToZoomHeaderListView)
  {
    this.mListView = paramPullToZoomHeaderListView;
  }
  
  public void updateItemTheme(View paramView, TextView paramTextView, Button paramButton)
  {
    if (paramView != null)
    {
      if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData)) {
        paramView.setBackgroundResource(0);
      }
    }
    else if (paramButton != null)
    {
      if (!ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData)) {
        break label80;
      }
      paramButton.setTextColor(paramButton.getResources().getColor(2131167066));
    }
    for (;;)
    {
      super.updateItemTheme(paramTextView, null);
      return;
      ProfileCardTemplate.a(paramView, "background", ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonMaskBackground");
      break;
      label80:
      super.updateItemTheme(paramButton, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.stickynote.ProfileStickyNoteComponent
 * JD-Core Version:    0.7.0.1
 */