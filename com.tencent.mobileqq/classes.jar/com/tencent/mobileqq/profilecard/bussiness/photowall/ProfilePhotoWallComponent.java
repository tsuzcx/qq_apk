package com.tencent.mobileqq.profilecard.bussiness.photowall;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.container.IProfileHeaderContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallHandler;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView.PhotoWallUpdaterListener;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class ProfilePhotoWallComponent
  extends AbsProfileContentComponent
  implements View.OnClickListener, PhotoWallView.PhotoWallUpdaterListener
{
  private static final String TAG = "ProfilePhotoWallComponent";
  private Handler mHandler;
  private boolean mHasScrollToPhotoWall;
  private PhotoWallObserver mPhotoWallObserver = new ProfilePhotoWallComponent.1(this);
  private boolean mScrollToPhotoWall;
  
  public ProfilePhotoWallComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void freshQZonePhotoWall()
  {
    if (this.mApp != null) {
      ((PhotoWallHandler)this.mApp.getBusinessHandler(PhotoWallHandler.class.getName())).getQzonePhotoWall(((ProfileCardInfo)this.mData).allInOne.uin, "");
    }
  }
  
  private void handleDelQZonePhotoWall(boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = MobileQQ.sMobileQQ.getApplicationContext().getString(2131897172);
      QQToast.makeText(BaseApplication.getContext(), 2, str, 0).show();
    }
    else
    {
      str = MobileQQ.sMobileQQ.getApplicationContext().getString(2131897173);
      QQToast.makeText(BaseApplication.getContext(), 1, str, 0).show();
    }
    freshQZonePhotoWall();
  }
  
  private void handleGetQZonePhotoWall(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    if (((ProfileCardInfo)this.mData).allInOne.uin.equals(paramString2))
    {
      if (this.mViewContainer != null) {
        ((PhotoWallView)((ProfileCardFavorShowView)this.mViewContainer).getViewInContainer(0)).onGetQZonePhotoWall(paramBoolean, paramString1, parammobile_sub_get_photo_wall_rsp);
      }
      paramString1 = this.mComponentCenter.getComponent(1002);
      if ((paramString1 instanceof IProfileHeaderContainer)) {
        ((IProfileHeaderContainer)paramString1).onGetQZoneCover(paramBoolean, paramString2, parammobile_sub_get_photo_wall_rsp);
      }
    }
  }
  
  private boolean makeOrRefreshPhotoWall(Card paramCard, boolean paramBoolean)
  {
    paramCard = this.mComponentCenter.getComponent(1002);
    if ((paramCard instanceof IProfileHeaderContainer)) {
      paramBoolean = ((IProfileHeaderContainer)paramCard).hasPhotoWall();
    } else {
      paramBoolean = false;
    }
    boolean bool4 = ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo)this.mData).allInOne);
    boolean bool5 = Utils.c(((ProfileCardInfo)this.mData).allInOne.uin);
    paramCard = this.mConfigHelper;
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool1;
    if ((paramCard != null) && (!this.mConfigHelper.isSwitchEnable(2))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfilePhotoWallComponent", 2, String.format("makeOrRefreshPhotoWall photoWallInHeader=%s strangerInContact=%s isBabyQ=%s configDisable=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1) }));
    }
    if ((!paramBoolean) && (!bool4) && (!bool5) && (!bool1))
    {
      if (this.mViewContainer == null)
      {
        localObject = (ProfileCardFavorShowView)ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).getPhotoWallDiyView((ProfileCardInfo)this.mData);
        paramCard = (Card)localObject;
        if (localObject == null)
        {
          localObject = new PhotoWallView(this.mActivity, this.mApp, ((ProfileCardInfo)this.mData).allInOne.uin);
          paramCard = new ProfileCardFavorShowView(this.mActivity);
          paramCard.setTitle(HardCodeUtil.a(2131906240));
          paramCard.setVisibility(8);
          paramCard.addView((View)localObject);
        }
        this.mViewContainer = paramCard;
        paramBoolean = bool2;
      }
      else
      {
        paramBoolean = false;
      }
      paramCard = (ProfileCardFavorShowView)this.mViewContainer;
      Object localObject = (PhotoWallView)paramCard.getViewInContainer(0);
      ((PhotoWallView)localObject).setPhotoWallUpdaterListener(this);
      DataTag localDataTag = new DataTag(85, localObject);
      paramCard.mTitleBar.setTag(localDataTag);
      paramCard.mTitleBar.setOnClickListener(this);
      updateItemTheme(paramCard.mTitleBar, paramCard.mTitleText, null, paramCard.mArrowImage);
      updateItemTheme(((PhotoWallView)localObject).mEmptyTitle, ((PhotoWallView)localObject).mEmptyInfo, null);
    }
    else if (this.mViewContainer != null)
    {
      this.mViewContainer = null;
      paramBoolean = bool3;
    }
    else
    {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      paramCard = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
      if (ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy()) {
        paramCard.updatePhotoWallForDeepDiy((View)this.mViewContainer);
      }
    }
    return paramBoolean;
  }
  
  private void scrollToPhotoWall()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.postDelayed(new ProfilePhotoWallComponent.2(this), 1000L);
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
      if ((localDataTag.a == 85) && ((localDataTag.b instanceof PhotoWallView))) {
        ((PhotoWallView)localDataTag.b).peformClickMoreText();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    paramQBaseActivity = this.mActivity.getIntent();
    if (paramQBaseActivity != null) {
      this.mScrollToPhotoWall = paramQBaseActivity.getBooleanExtra("profile_scroll_to_photo_wall", false);
    }
    this.mHandler = new Handler(Looper.getMainLooper());
    this.mApp.addObserver(this.mPhotoWallObserver);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshPhotoWall(((ProfileCardInfo)this.mData).card, ((ProfileCardInfo)this.mData).isNetRet);
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.mPhotoWallObserver);
    super.onDestroy();
  }
  
  public void onUpdatePhotoWall(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfilePhotoWallComponent", 2, String.format("onUpdatePhotoWall size=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (this.mViewContainer != null)
    {
      int i;
      if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) || (paramInt > 0))
      {
        ((View)this.mViewContainer).setVisibility(0);
        if (i != 0)
        {
          AppInterface localAppInterface = this.mApp;
          if (paramInt > 0) {
            paramInt = 1;
          } else {
            paramInt = 2;
          }
          ReportController.b(localAppInterface, "dc00898", "", "", "0X8007EBC", "0X8007EBC", paramInt, 0, "", "", "", "");
          return;
        }
        ReportController.b(this.mApp, "dc00898", "", "", "0X8007EBD", "0X8007EBD", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.ProfilePhotoWallComponent
 * JD-Core Version:    0.7.0.1
 */