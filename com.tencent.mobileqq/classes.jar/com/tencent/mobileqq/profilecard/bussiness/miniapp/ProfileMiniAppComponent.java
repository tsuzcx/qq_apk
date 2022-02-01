package com.tencent.mobileqq.profilecard.bussiness.miniapp;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class ProfileMiniAppComponent
  extends AbsProfileContentComponent
  implements View.OnClickListener
{
  private static final String TAG = "ProfileMiniAppComponent";
  
  public ProfileMiniAppComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean makeOrRefreshMini(Card paramCard)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    Object localObject2 = (ProfileCardInfo)this.mData;
    Object localObject3 = this.mApp;
    if (paramCard == null) {
      bool2 = bool1;
    }
    boolean bool5;
    Object localObject1;
    int i;
    label75:
    do
    {
      do
      {
        return bool2;
        bool5 = paramCard.uin.equals(((QQAppInterface)localObject3).getCurrentAccountUin());
        localObject1 = (View)this.mViewContainer;
        ThemeUtil.isInNightMode((AppRuntime)localObject3);
        if (((ProfileCardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null) {
          break;
        }
        i = 1;
        localObject2 = (ProfileMiniAppInfo)((ProfileCardInfo)this.mData).a(ProfileMiniAppInfo.class);
        if ((localObject2 == null) || (!((ProfileMiniAppInfo)localObject2).isShowMiniPlaying)) {
          break label722;
        }
        if (localObject1 != null) {
          break label436;
        }
        localObject1 = new ProfileContentTitleView(this.mActivity);
        if (!bool5) {
          break label302;
        }
        bool2 = bool1;
      } while (((ProfileMiniAppInfo)localObject2).miniAppInfoArrayList == null);
      bool2 = bool1;
    } while (((ProfileMiniAppInfo)localObject2).miniAppInfoArrayList.size() <= 0);
    ((ProfileContentTitleView)localObject1).setTitle(QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingName", "最近在玩"));
    bool1 = bool3;
    if (((ProfileMiniAppInfo)localObject2).miniAppInfoArrayList.size() > 1) {
      bool1 = true;
    }
    ((ProfileContentTitleView)localObject1).setArrowEnable(bool1);
    paramCard = ((IMiniAppService)QRoute.api(IMiniAppService.class)).createMiniAppProfileCardView(this.mActivity);
    ((BaseMiniAppProfileCardView)paramCard).setData(((ProfileMiniAppInfo)localObject2).miniAppInfoArrayList);
    ((ProfileContentTitleView)localObject1).setVisibility(8);
    ((ProfileContentTitleView)localObject1).addContentView(paramCard);
    if (i != 0) {
      updateMiniItemColor((BaseMiniAppProfileCardView)paramCard);
    }
    label248:
    this.mViewContainer = localObject1;
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportProfileCardExposed(localObject2, bool5);
    paramCard = (Card)localObject1;
    bool1 = true;
    for (;;)
    {
      bool2 = bool1;
      if (!(paramCard instanceof ProfileContentTitleView)) {
        break;
      }
      updateItemTheme((ProfileContentTitleView)paramCard, true);
      return bool1;
      i = 0;
      break label75;
      label302:
      bool2 = bool1;
      if (((ProfileMiniAppInfo)localObject2).appPlayingInfos == null) {
        break;
      }
      bool2 = bool1;
      if (((ProfileMiniAppInfo)localObject2).appPlayingInfos.size() <= 0) {
        break;
      }
      ((ProfileContentTitleView)localObject1).setTitle(QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingNameGuestDefault", "一起在玩"));
      bool1 = bool4;
      if (((ProfileMiniAppInfo)localObject2).appPlayingInfos.size() > 1) {
        bool1 = true;
      }
      ((ProfileContentTitleView)localObject1).setArrowEnable(bool1);
      localObject3 = new MiniAppProfileCardGuestView(this.mActivity);
      ((MiniAppProfileCardGuestView)localObject3).setData(((ProfileMiniAppInfo)localObject2).appPlayingInfos, ((ProfileMiniAppInfo)localObject2).guestJumpUrl, paramCard.uin);
      ((ProfileContentTitleView)localObject1).setVisibility(8);
      ((ProfileContentTitleView)localObject1).addContentView((View)localObject3);
      if (i == 0) {
        break label248;
      }
      updateMiniGuestItemColor((MiniAppProfileCardGuestView)localObject3);
      break label248;
      label436:
      if (bool5)
      {
        if ((localObject1 instanceof ProfileContentTitleView))
        {
          paramCard = (ProfileContentTitleView)localObject1;
          if (((ProfileMiniAppInfo)localObject2).miniAppInfoArrayList.size() > 1) {}
          for (bool1 = true;; bool1 = false)
          {
            paramCard.setArrowEnable(bool1);
            localObject3 = (BaseMiniAppProfileCardView)paramCard.getContentView();
            ((BaseMiniAppProfileCardView)localObject3).setData(((ProfileMiniAppInfo)localObject2).miniAppInfoArrayList);
            if (i != 0) {
              updateMiniItemColor((BaseMiniAppProfileCardView)localObject3);
            }
            if (((ProfileMiniAppInfo)localObject2).miniAppInfoArrayList.size() > 1)
            {
              paramCard = paramCard.mTitleContainer;
              paramCard.setTag(new DataTag(96, Boolean.valueOf(true)));
              paramCard.setOnClickListener(this);
            }
            paramCard = (Card)localObject1;
            bool1 = bool2;
            break;
          }
        }
      }
      else if ((localObject1 instanceof ProfileContentTitleView))
      {
        localObject3 = (ProfileContentTitleView)localObject1;
        ((ProfileContentTitleView)localObject3).setTitle(((ProfileMiniAppInfo)localObject2).guestAppTotal + QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingNameGuest", "个一起在玩的小游戏"));
        if (((ProfileMiniAppInfo)localObject2).guestAppTotal > 1) {}
        for (bool1 = true;; bool1 = false)
        {
          ((ProfileContentTitleView)localObject3).setArrowEnable(bool1);
          MiniAppProfileCardGuestView localMiniAppProfileCardGuestView = (MiniAppProfileCardGuestView)((ProfileContentTitleView)localObject3).getContentView();
          localMiniAppProfileCardGuestView.setData(((ProfileMiniAppInfo)localObject2).appPlayingInfos, ((ProfileMiniAppInfo)localObject2).guestJumpUrl, paramCard.uin);
          if (i != 0) {
            updateMiniGuestItemColor(localMiniAppProfileCardGuestView);
          }
          if (((ProfileMiniAppInfo)localObject2).guestAppTotal > 1)
          {
            paramCard = ((ProfileContentTitleView)localObject3).mTitleContainer;
            paramCard.setTag(new DataTag(96, Boolean.valueOf(false)));
            paramCard.setOnClickListener(this);
          }
          paramCard = (Card)localObject1;
          bool1 = bool2;
          break;
        }
        label722:
        if (localObject1 != null)
        {
          this.mViewContainer = null;
          paramCard = (Card)localObject1;
          bool1 = true;
          continue;
        }
      }
      paramCard = (Card)localObject1;
      bool1 = bool2;
    }
  }
  
  private void updateMiniGuestItemColor(MiniAppProfileCardGuestView paramMiniAppProfileCardGuestView)
  {
    Object localObject = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a.get("commonItemContentColor");
    if (localObject != null)
    {
      if (!(localObject instanceof ColorStateList)) {
        break label39;
      }
      paramMiniAppProfileCardGuestView.setTextColor((ColorStateList)localObject);
    }
    label39:
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof String));
      localObject = (String)localObject;
    } while (!((String)localObject).startsWith("#"));
    paramMiniAppProfileCardGuestView.setTextColor(Color.parseColor((String)localObject));
  }
  
  private void updateMiniItemColor(BaseMiniAppProfileCardView paramBaseMiniAppProfileCardView)
  {
    Object localObject = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a.get("commonItemContentColor");
    if (localObject != null)
    {
      if (!(localObject instanceof ColorStateList)) {
        break label39;
      }
      paramBaseMiniAppProfileCardView.setTextColor((ColorStateList)localObject);
    }
    label39:
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof String));
      localObject = (String)localObject;
    } while (!((String)localObject).startsWith("#"));
    paramBaseMiniAppProfileCardView.setTextColor(Color.parseColor((String)localObject));
  }
  
  public String getComponentName()
  {
    return "ProfileMiniAppComponent";
  }
  
  public int getComponentType()
  {
    return 1014;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_mini_playing";
  }
  
  public void onClick(View paramView)
  {
    boolean bool = ((Boolean)((DataTag)paramView.getTag()).a).booleanValue();
    Object localObject = (ProfileMiniAppInfo)((ProfileCardInfo)this.mData).a(ProfileMiniAppInfo.class);
    IMiniAppService localIMiniAppService = (IMiniAppService)QRoute.api(IMiniAppService.class);
    Context localContext = paramView.getContext();
    if (bool) {}
    for (localObject = ((ProfileMiniAppInfo)localObject).tabJumpUrl;; localObject = ((ProfileMiniAppInfo)localObject).guestJumpUrl)
    {
      localIMiniAppService.startAppByLink(localContext, (String)localObject, 2, 2062, null);
      ProfileCardReport.reportMiniAppClick(this.mApp, (ProfileCardInfo)this.mData);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshMini(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard) | bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.miniapp.ProfileMiniAppComponent
 * JD-Core Version:    0.7.0.1
 */