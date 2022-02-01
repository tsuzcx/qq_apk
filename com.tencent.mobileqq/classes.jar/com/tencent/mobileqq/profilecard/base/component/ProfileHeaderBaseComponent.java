package com.tencent.mobileqq.profilecard.base.component;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.FriendProfilePhotoHelper;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.factory.ProfileComponentFactory;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.ProfileAccountInfoHeaderComponent;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelHeaderComponent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PullToZoomHeaderListView;
import java.util.ArrayList;
import java.util.Iterator;

public class ProfileHeaderBaseComponent
  extends AbsProfileHeaderComponent
{
  private static final String TAG = "ProfileHeaderBaseComponent";
  private ProfileAccountInfoHeaderComponent mAccountInfoComponent;
  private ProfileAccountLevelHeaderComponent mAccountLevelComponent;
  private ProfileConfigHelper mConfigHelper;
  private boolean mIsFromArkBabyQ;
  private PullToZoomHeaderListView mListView;
  private FriendProfilePhotoHelper mPhotoHelper;
  
  public ProfileHeaderBaseComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void destroyProfileAccountInfoComponent()
  {
    if (this.mAccountInfoComponent != null)
    {
      removeComponent(this.mAccountInfoComponent);
      this.mAccountInfoComponent.detachFromComponentCenter();
      this.mAccountInfoComponent = null;
    }
  }
  
  private void destroyProfileAccountLevelComponent()
  {
    if (this.mAccountLevelComponent != null)
    {
      removeComponent(this.mAccountLevelComponent);
      this.mAccountLevelComponent.detachFromComponentCenter();
      this.mAccountLevelComponent = null;
    }
  }
  
  private void destroyProfilePhotoHelper()
  {
    if (this.mPhotoHelper != null)
    {
      this.mPhotoHelper.a();
      this.mPhotoHelper = null;
    }
  }
  
  private void handleProfileCoverClick()
  {
    if ((!ProfileActivity.AllInOne.g(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.mApp == null)) {
      return;
    }
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      showProfileCoverActionSheet();
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0) {
        break label98;
      }
    }
    label98:
    for (int i = 1;; i = 2)
    {
      ReportController.b(this.mApp, "dc00898", "", "", "0X800A889", "0X800A889", i, 0, "", "", "", "");
      return;
      previewProfileCover(false);
      break;
    }
  }
  
  private void initProfileAccountInfoComponent()
  {
    if (this.mAccountInfoComponent == null)
    {
      View localView = this.mHeaderView.findViewById(2131374497);
      this.mAccountInfoComponent = ((ProfileAccountInfoHeaderComponent)ProfileComponentFactory.create(1024, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mAccountInfoComponent.setCommonDependence(this.mDelegate, this.mConfigHelper, null);
      this.mAccountInfoComponent.setContainerView(localView);
      this.mAccountInfoComponent.attachToComponentCenter();
      addComponent(this.mAccountInfoComponent);
    }
  }
  
  private void initProfileAccountLevelComponent()
  {
    if (this.mAccountLevelComponent == null)
    {
      View localView = this.mHeaderView.findViewById(2131374499);
      this.mAccountLevelComponent = ((ProfileAccountLevelHeaderComponent)ProfileComponentFactory.create(1022, this.mComponentCenter, (ProfileCardInfo)this.mData));
      this.mAccountLevelComponent.setCommonDependence(this.mDelegate, this.mConfigHelper, null);
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
    if (this.mHeaderView.mCoverTimeStamp == 0) {}
    for (int i = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.defaultCardId;; i = 0)
    {
      Intent localIntent = new Intent(this.mActivity, CardPicGalleryActivity.class);
      localIntent.putExtra("extra_mode", 2);
      localIntent.putExtra("is_from_mine_profile", paramBoolean);
      localIntent.putStringArrayListExtra("business_card_pics", localArrayList);
      localIntent.putExtra("default_card_id", i);
      if (TextUtils.isEmpty(this.mHeaderView.mCoverUrl)) {
        localIntent.putExtra("extra_default", 2130846048);
      }
      this.mActivity.startActivity(localIntent);
      this.mActivity.overridePendingTransition(2130772323, 0);
      return;
    }
  }
  
  private void reportProfileCoverActionSheetItemClick(int paramInt)
  {
    ReportController.b(this.mApp, "dc00898", "", "", "0X800A88A", "0X800A88A", paramInt, 0, "", "", "", "");
  }
  
  private void showProfileCoverActionSheet()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.mActivity, null);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.mHeaderView.mCoverUrl)) {
      localArrayList.add(new ProfileHeaderBaseComponent.2(this, 2131693330));
    }
    localArrayList.add(new ProfileHeaderBaseComponent.3(this, 2131693328));
    localArrayList.add(new ProfileHeaderBaseComponent.4(this, 2131693326));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      localActionSheet.addButton(((ProfileHeaderBaseComponent.ActionSheetItem)localIterator.next()).buttonStrId);
    }
    localActionSheet.addCancelButton(2131690800);
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
    if (this.mHeaderView.mCoverTimeStamp == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.mPhotoHelper != null) {
        this.mPhotoHelper.a(bool);
      }
      return;
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
      localProfileBaseView.onInit();
      this.mHeaderView = localProfileBaseView;
      ((FrameLayout)this.mViewContainer).removeAllViews();
      ((FrameLayout)this.mViewContainer).addView(this.mHeaderView);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (this.mPhotoHelper == null);
    this.mPhotoHelper.a(paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    DataTag localDataTag;
    if ((paramView.getTag() instanceof DataTag))
    {
      localDataTag = (DataTag)paramView.getTag();
      if (localDataTag.a != 17) {
        break label44;
      }
      handleProfileCoverClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label44:
      if (localDataTag.a == 105) {
        VipQidHelper.a(this.mActivity, (ProfileCardInfo)this.mData);
      }
    }
  }
  
  public void onCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    Intent localIntent = paramBaseActivity.getIntent();
    if (localIntent != null) {
      this.mIsFromArkBabyQ = localIntent.getBooleanExtra("key_from_ark_babyq", false);
    }
    super.onCreate(paramBaseActivity, paramBundle);
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
    if ((localArrayList != null) && (localArrayList.size() > 0) && (this.mPhotoHelper != null)) {
      this.mPhotoHelper.a(paramIntent, localArrayList);
    }
  }
  
  public void setProfileArgs(ProfileConfigHelper paramProfileConfigHelper, PullToZoomHeaderListView paramPullToZoomHeaderListView)
  {
    this.mConfigHelper = paramProfileConfigHelper;
    this.mListView = paramPullToZoomHeaderListView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.ProfileHeaderBaseComponent
 * JD-Core Version:    0.7.0.1
 */