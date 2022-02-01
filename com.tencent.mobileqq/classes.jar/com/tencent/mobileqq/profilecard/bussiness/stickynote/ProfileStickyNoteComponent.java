package com.tencent.mobileqq.profilecard.bussiness.stickynote;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.QZoneApiProxy;

public class ProfileStickyNoteComponent
  extends AbsQQProfileContentComponent
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
      this.mStickyNoteManager.init(this.mActivity, this.mQQAppInterface, paramCard, this.mListView, paramView, this);
      if (this.mDelegate != null) {
        this.mDelegate.addProfileScrollListener(this.mStickyNoteManager);
      }
    }
  }
  
  private boolean makeOrRefreshStickyNote(Card paramCard, boolean paramBoolean)
  {
    Object localObject = this.mConfigHelper;
    boolean bool4 = true;
    boolean bool1;
    if ((localObject != null) && (!this.mConfigHelper.isSwitchEnable(8))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2;
    if (((this.mFirstNetUpdated) || (paramBoolean)) && (paramCard != null) && (paramCard.switchStickyNote != 1)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool5 = ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo)this.mData).allInOne);
    boolean bool3 = QZoneApiProxy.isRightAndroidVersionForStickyNote();
    if ((bool1) && (bool2) && (bool5) && (bool3)) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileStickyNoteComponent", 2, String.format("makeOrRefreshStickyNote showStickyNote=%s configEnable=%s switchEnable=%s isFriend=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool5) }));
    }
    if ((!this.mFirstNetUpdated) && (paramBoolean)) {
      this.mFirstNetUpdated = true;
    }
    if ((paramCard != null) && (bool3))
    {
      if (this.mViewContainer == null)
      {
        localObject = new ProfileContentTitleView(this.mActivity);
        ((ProfileContentTitleView)localObject).setTitle(this.mActivity.getString(2131691193));
        ((ProfileContentTitleView)localObject).setArrowEnable(false);
        ((ProfileContentTitleView)localObject).setMarginBottomEnable(false);
        ((ProfileContentTitleView)localObject).setVisibility(8);
        initStickyNoteManager(paramCard, (View)localObject);
        this.mViewContainer = localObject;
        paramBoolean = bool4;
      }
      else
      {
        paramBoolean = false;
      }
      updateItemTheme((ProfileContentTitleView)this.mViewContainer, false);
      return paramBoolean;
    }
    destroyStickyNoteManager();
    if (this.mViewContainer != null)
    {
      this.mViewContainer = null;
      return true;
    }
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
    if ((paramInt1 == 1207) || (paramInt1 == 1208) || (paramInt1 == 1209))
    {
      QzoneStickyNoteManager localQzoneStickyNoteManager = this.mStickyNoteManager;
      if (localQzoneStickyNoteManager != null) {
        localQzoneStickyNoteManager.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshStickyNote(((ProfileCardInfo)this.mData).card, ((ProfileCardInfo)this.mData).isNetRet);
  }
  
  public void onDestroy()
  {
    destroyStickyNoteManager();
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    QzoneStickyNoteManager localQzoneStickyNoteManager = this.mStickyNoteManager;
    if (localQzoneStickyNoteManager != null) {
      localQzoneStickyNoteManager.onResume();
    }
  }
  
  public void setProfileActivityDelegate(IProfileActivityDelegate paramIProfileActivityDelegate)
  {
    super.setProfileActivityDelegate(paramIProfileActivityDelegate);
    if (this.mDelegate != null) {
      this.mListView = this.mDelegate.getListView();
    }
  }
  
  public void updateItemTheme(View paramView, TextView paramTextView, Button paramButton)
  {
    if (paramView != null) {
      if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData)) {
        paramView.setBackgroundResource(0);
      } else {
        ProfileTemplateApi.getTemplateUtils(this.mComponentCenter).updateViewAttr(paramView, "background", ((ProfileCardInfo)this.mData).currentTemplate, "commonMaskBackground");
      }
    }
    if (paramButton != null) {
      if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData)) {
        paramButton.setTextColor(paramButton.getResources().getColor(2131167089));
      } else {
        super.updateItemTheme(paramButton, null);
      }
    }
    super.updateItemTheme(paramTextView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.stickynote.ProfileStickyNoteComponent
 * JD-Core Version:    0.7.0.1
 */