package com.tencent.mobileqq.profilecard.base.component;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.FriendProfilePhotoHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelHeaderComponent;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class ProfileHeaderBaseComponent
  extends AbsProfileHeaderComponent
{
  private static final String TAG = "ProfileHeaderBaseComponent";
  private AbsProfileComponent mAccountInfoComponent;
  private ProfileAccountLevelHeaderComponent mAccountLevelComponent;
  private boolean mIsFromArkBabyQ;
  private PullToZoomHeaderListView mListView;
  private FriendProfilePhotoHelper mPhotoHelper;
  
  public ProfileHeaderBaseComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void destroyProfileAccountInfoComponent()
  {
    AbsProfileComponent localAbsProfileComponent = this.mAccountInfoComponent;
    if (localAbsProfileComponent != null)
    {
      removeComponent(localAbsProfileComponent);
      this.mAccountInfoComponent.detachFromComponentCenter();
      this.mAccountInfoComponent = null;
    }
  }
  
  private void destroyProfileAccountLevelComponent()
  {
    ProfileAccountLevelHeaderComponent localProfileAccountLevelHeaderComponent = this.mAccountLevelComponent;
    if (localProfileAccountLevelHeaderComponent != null)
    {
      removeComponent(localProfileAccountLevelHeaderComponent);
      this.mAccountLevelComponent.detachFromComponentCenter();
      this.mAccountLevelComponent = null;
    }
  }
  
  private void destroyProfilePhotoHelper()
  {
    FriendProfilePhotoHelper localFriendProfilePhotoHelper = this.mPhotoHelper;
    if (localFriendProfilePhotoHelper != null)
    {
      localFriendProfilePhotoHelper.a();
      this.mPhotoHelper = null;
    }
  }
  
  private void handleProfileCoverClick()
  {
    if (ProfilePAUtils.isPaTypeHasUin(((ProfileCardInfo)this.mData).allInOne))
    {
      if (this.mApp == null) {
        return;
      }
      if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
        showProfileCoverActionSheet();
      } else {
        previewProfileCover(false);
      }
      int i;
      if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(this.mApp, "dc00898", "", "", "0X800A889", "0X800A889", i, 0, "", "", "", "");
    }
  }
  
  private void initProfileAccountInfoComponent()
  {
    if (this.mAccountInfoComponent == null)
    {
      View localView = this.mHeaderView.findViewById(2131442129);
      this.mAccountInfoComponent = ProfileUtils.create(1024, this.mComponentCenter, (ProfileCardInfo)this.mData, this.mDelegate);
      this.mAccountInfoComponent.setContainerView(localView);
      this.mAccountInfoComponent.attachToComponentCenter();
      addComponent(this.mAccountInfoComponent);
    }
  }
  
  private void initProfileAccountLevelComponent()
  {
    if (this.mAccountLevelComponent == null)
    {
      View localView = this.mHeaderView.findViewById(2131442131);
      this.mAccountLevelComponent = ((ProfileAccountLevelHeaderComponent)ProfileUtils.create(1022, this.mComponentCenter, (ProfileCardInfo)this.mData, this.mDelegate));
      this.mAccountLevelComponent.setContainerView(localView);
      this.mAccountLevelComponent.attachToComponentCenter();
      addComponent(this.mAccountLevelComponent);
    }
  }
  
  private void initProfilePhotoHelper()
  {
    if (this.mPhotoHelper == null) {
      this.mPhotoHelper = new FriendProfilePhotoHelper(this.mActivity, new ProfileHeaderBaseComponent.1(this));
    }
  }
  
  private void previewProfileCover(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.mHeaderView.mCoverUrl);
    int i;
    if (this.mHeaderView.mCoverTimeStamp == 0) {
      i = ((ProfileCardInfo)this.mData).card.defaultCardId;
    } else {
      i = 0;
    }
    Intent localIntent = new Intent(this.mActivity, CardPicGalleryActivity.class);
    localIntent.putExtra("extra_mode", 2);
    localIntent.putExtra("is_from_mine_profile", paramBoolean);
    localIntent.putStringArrayListExtra("business_card_pics", localArrayList);
    localIntent.putExtra("default_card_id", i);
    if (TextUtils.isEmpty(this.mHeaderView.mCoverUrl)) {
      localIntent.putExtra("extra_default", 2130847393);
    }
    this.mActivity.startActivity(localIntent);
    this.mActivity.overridePendingTransition(2130772443, 0);
  }
  
  private void reportProfileCoverActionSheetItemClick(int paramInt)
  {
    ReportController.b(this.mApp, "dc00898", "", "", "0X800A88A", "0X800A88A", paramInt, 0, "", "", "", "");
  }
  
  private void showProfileCoverActionSheet()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.mActivity, null);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.mHeaderView.mCoverUrl)) {
      localArrayList.add(new ProfileHeaderBaseComponent.2(this, 2131890833));
    }
    localArrayList.add(new ProfileHeaderBaseComponent.3(this, 2131890831));
    localArrayList.add(new ProfileHeaderBaseComponent.4(this, 2131890829));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      localActionSheet.addButton(((ProfileHeaderBaseComponent.ActionSheetItem)localIterator.next()).buttonStrId);
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new ProfileHeaderBaseComponent.5(this, localArrayList, localActionSheet));
    try
    {
      localActionSheet.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ProfileHeaderBaseComponent", 2, "showProfileCoverActionSheet fail.", localException);
    }
  }
  
  public void enterCustomCover()
  {
    boolean bool;
    if (this.mHeaderView.mCoverTimeStamp == 0) {
      bool = true;
    } else {
      bool = false;
    }
    FriendProfilePhotoHelper localFriendProfilePhotoHelper = this.mPhotoHelper;
    if (localFriendProfilePhotoHelper != null) {
      localFriendProfilePhotoHelper.a(bool);
    }
  }
  
  public String getComponentName()
  {
    return "ProfileHeaderBaseComponent";
  }
  
  public int getComponentType()
  {
    return 1002;
  }
  
  protected void initHeaderView()
  {
    if (this.mHeaderView == null)
    {
      ProfileBaseView localProfileBaseView = new ProfileBaseView(this.mActivity, (ProfileCardInfo)this.mData);
      localProfileBaseView.setProfileArgs(this.mListView, this.mIsFromArkBabyQ);
      localProfileBaseView.setClickListener(this);
      localProfileBaseView.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
      this.mHeaderView = localProfileBaseView;
      ((FrameLayout)this.mViewContainer).removeAllViews();
      ((FrameLayout)this.mViewContainer).addView(this.mHeaderView);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 1024) {
      return;
    }
    FriendProfilePhotoHelper localFriendProfilePhotoHelper = this.mPhotoHelper;
    if (localFriendProfilePhotoHelper != null) {
      localFriendProfilePhotoHelper.a(paramInt2, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if ((paramView.getTag() instanceof DataTag))
    {
      DataTag localDataTag = (DataTag)paramView.getTag();
      if (localDataTag.a == 17) {
        handleProfileCoverClick();
      } else if (localDataTag.a == 105) {
        VipQidHelper.a(this.mActivity, (ProfileCardInfo)this.mData);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    Intent localIntent = paramQBaseActivity.getIntent();
    if (localIntent != null) {
      this.mIsFromArkBabyQ = localIntent.getBooleanExtra("key_from_ark_babyq", false);
    }
    super.onCreate(paramQBaseActivity, paramBundle);
    initProfilePhotoHelper();
    initProfileAccountInfoComponent();
    initProfileAccountLevelComponent();
  }
  
  public void onDestroy()
  {
    destroyProfilePhotoHelper();
    destroyProfileAccountInfoComponent();
    destroyProfileAccountLevelComponent();
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      FriendProfilePhotoHelper localFriendProfilePhotoHelper = this.mPhotoHelper;
      if (localFriendProfilePhotoHelper != null) {
        localFriendProfilePhotoHelper.a(paramIntent, localArrayList);
      }
    }
  }
  
  public void setProfileActivityDelegate(IProfileActivityDelegate paramIProfileActivityDelegate)
  {
    super.setProfileActivityDelegate(paramIProfileActivityDelegate);
    if (this.mDelegate != null) {
      this.mListView = this.mDelegate.getListView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.ProfileHeaderBaseComponent
 * JD-Core Version:    0.7.0.1
 */