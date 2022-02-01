package com.tencent.mobileqq.profilecard.bussiness.photowall;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoViewHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.mobileqq.widget.PhotoWallView.PhotoWallUpdaterListener;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ProfilePhotoWallComponent
  extends AbsProfileContentComponent
  implements View.OnClickListener, PhotoWallView.PhotoWallUpdaterListener
{
  public static final int REQUEST_EDIT_PHOTO_WALL = 100;
  private static final String TAG = "ProfilePhotoWallComponent";
  private CardObserver mCardObserver = new ProfilePhotoWallComponent.1(this);
  private Handler mHandler;
  private boolean mHasScrollToPhotoWall;
  private boolean mScrollToPhotoWall;
  
  public ProfilePhotoWallComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void freshQZonePhotoWall()
  {
    if (this.mApp != null) {
      ((CardHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
    }
  }
  
  private void handleDelQZonePhotoWall(boolean paramBoolean)
  {
    if (paramBoolean) {
      ProfileCardUtils.notifyUser(2, 2131699052);
    }
    for (;;)
    {
      freshQZonePhotoWall();
      return;
      ProfileCardUtils.notifyUser(1, 2131699053);
    }
  }
  
  private void handleGetQZonePhotoWall(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramString2))
    {
      if (this.mViewContainer != null) {
        ((PhotoWallView)((ProfileCardFavorShowView)this.mViewContainer).a(0)).a(paramBoolean, paramString1, parammobile_sub_get_photo_wall_rsp);
      }
      paramString1 = (AbsProfileHeaderComponent)this.mComponentCenter.getComponent(1002);
      if (paramString1 != null)
      {
        paramString1 = paramString1.getHeaderView();
        if (paramString1 != null) {
          paramString1.onGetQZoneCover(paramBoolean, paramString2, parammobile_sub_get_photo_wall_rsp);
        }
      }
    }
  }
  
  private boolean makeOrRefreshPhotoWall(Card paramCard, boolean paramBoolean)
  {
    boolean bool2 = true;
    paramCard = (AbsProfileHeaderComponent)this.mComponentCenter.getComponent(1002);
    if ((paramCard instanceof AbsVasProfileHeaderComponent)) {}
    for (paramBoolean = ((AbsVasProfileHeaderComponent)paramCard).hasPhotoWall();; paramBoolean = false)
    {
      boolean bool3 = ProfileActivity.AllInOne.i(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      boolean bool4 = Utils.b(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((this.mConfigHelper != null) && (!this.mConfigHelper.a(2))) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfilePhotoWallComponent", 2, String.format("makeOrRefreshPhotoWall photoWallInHeader=%s strangerInContact=%s isBabyQ=%s configDisable=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1) }));
        }
        if ((!paramBoolean) && (!bool3) && (!bool4) && (!bool1)) {
          break;
        }
        if (this.mViewContainer == null) {
          break label369;
        }
        this.mViewContainer = null;
        return true;
      }
      Object localObject;
      if (this.mViewContainer == null)
      {
        localObject = (ProfileCardFavorShowView)this.mDiyHelper.getDiyView(getProfileContentKey());
        paramCard = (Card)localObject;
        if (localObject == null)
        {
          localObject = new PhotoWallView(this.mActivity, this.mApp, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          paramCard = new ProfileCardFavorShowView(this.mActivity);
          paramCard.setTitle(HardCodeUtil.a(2131708448));
          paramCard.setVisibility(8);
          paramCard.addView((View)localObject);
        }
        this.mViewContainer = paramCard;
      }
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramCard = (ProfileCardFavorShowView)this.mViewContainer;
        localObject = (PhotoWallView)paramCard.a(0);
        ((PhotoWallView)localObject).setPhotoWallUpdaterListener(this);
        DataTag localDataTag = new DataTag(85, localObject);
        paramCard.b.setTag(localDataTag);
        paramCard.b.setOnClickListener(this);
        updateItemTheme(paramCard.jdField_a_of_type_AndroidWidgetTextView, null, paramCard.jdField_a_of_type_AndroidWidgetImageView);
        updateItemTheme(((PhotoWallView)localObject).b, ((PhotoWallView)localObject).c, null);
        return paramBoolean;
      }
      label369:
      return false;
    }
  }
  
  private void scrollToPhotoWall()
  {
    if (this.mHandler != null) {
      this.mHandler.postDelayed(new ProfilePhotoWallComponent.2(this), 1000L);
    }
  }
  
  public String getComponentName()
  {
    return "ProfilePhotoWallComponent";
  }
  
  public int getComponentType()
  {
    return 1009;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_photo_wall";
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 100) {
      freshQZonePhotoWall();
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof DataTag))
    {
      DataTag localDataTag = (DataTag)paramView.getTag();
      if ((localDataTag.jdField_a_of_type_Int == 85) && ((localDataTag.jdField_a_of_type_JavaLangObject instanceof PhotoWallView))) {
        ((PhotoWallView)localDataTag.jdField_a_of_type_JavaLangObject).a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    paramBaseActivity = this.mActivity.getIntent();
    if (paramBaseActivity != null) {
      this.mScrollToPhotoWall = paramBaseActivity.getBooleanExtra("profile_scroll_to_photo_wall", false);
    }
    this.mHandler = new Handler(Looper.getMainLooper());
    this.mApp.addObserver(this.mCardObserver);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshPhotoWall(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, ((ProfileCardInfo)this.mData).d) | bool;
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.mCardObserver);
    super.onDestroy();
  }
  
  public void onUpdatePhotoWall(int paramInt)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ProfilePhotoWallComponent", 2, String.format("onUpdatePhotoWall size=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    int i;
    QQAppInterface localQQAppInterface;
    if (this.mViewContainer != null)
    {
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label120;
      }
      i = 1;
      if ((i != 0) || (paramInt > 0))
      {
        ((View)this.mViewContainer).setVisibility(0);
        if (i == 0) {
          break label130;
        }
        localQQAppInterface = this.mApp;
        if (paramInt <= 0) {
          break label125;
        }
      }
    }
    label120:
    label125:
    for (paramInt = j;; paramInt = 2)
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8007EBC", "0X8007EBC", paramInt, 0, "", "", "", "");
      return;
      i = 0;
      break;
    }
    label130:
    ReportController.b(this.mApp, "dc00898", "", "", "0X8007EBD", "0X8007EBD", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.ProfilePhotoWallComponent
 * JD-Core Version:    0.7.0.1
 */