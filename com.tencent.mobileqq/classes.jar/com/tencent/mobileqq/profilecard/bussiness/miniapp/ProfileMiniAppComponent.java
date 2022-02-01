package com.tencent.mobileqq.profilecard.bussiness.miniapp;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class ProfileMiniAppComponent
  extends AbsQQProfileContentComponent
  implements View.OnClickListener
{
  private static final String TAG = "ProfileMiniAppComponent";
  
  public ProfileMiniAppComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean makeOrRefreshMini(Card paramCard)
  {
    Object localObject2 = (ProfileCardInfo)this.mData;
    Object localObject3 = this.mQQAppInterface;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramCard == null) {
      return false;
    }
    boolean bool4 = paramCard.uin.equals(((QQAppInterface)localObject3).getCurrentAccountUin());
    Object localObject1 = (View)this.mViewContainer;
    ThemeUtil.isInNightMode((AppRuntime)localObject3);
    int i;
    if (((ProfileCardInfo)localObject2).currentTemplate != null) {
      i = 1;
    } else {
      i = 0;
    }
    localObject3 = (ProfileMiniAppInfo)((ProfileCardInfo)this.mData).getBusinessInfo(ProfileMiniAppInfo.class);
    if ((localObject3 != null) && (((ProfileMiniAppInfo)localObject3).isShowMiniPlaying))
    {
      Object localObject4;
      if (localObject1 == null)
      {
        localObject1 = new ProfileContentTitleView(this.mActivity);
        if (bool4)
        {
          if ((((ProfileMiniAppInfo)localObject3).miniAppInfoArrayList != null) && (((ProfileMiniAppInfo)localObject3).miniAppInfoArrayList.size() > 0))
          {
            ((ProfileContentTitleView)localObject1).setTitle(QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingName", "最近在玩"));
            if (((ProfileMiniAppInfo)localObject3).miniAppInfoArrayList.size() > 1) {
              bool1 = true;
            }
            ((ProfileContentTitleView)localObject1).setArrowEnable(bool1);
            paramCard = ((IMiniAppService)QRoute.api(IMiniAppService.class)).createMiniAppProfileCardView(this.mActivity);
            localObject2 = (BaseMiniAppProfileCardView)paramCard;
            ((BaseMiniAppProfileCardView)localObject2).setData(((ProfileMiniAppInfo)localObject3).miniAppInfoArrayList);
            ((ProfileContentTitleView)localObject1).addContentView(paramCard);
            if (i != 0) {
              updateMiniItemColor((BaseMiniAppProfileCardView)localObject2);
            }
          }
          else
          {
            return false;
          }
        }
        else
        {
          if ((((ProfileMiniAppInfo)localObject3).appPlayingInfos == null) || (((ProfileMiniAppInfo)localObject3).appPlayingInfos.size() <= 0)) {
            break label385;
          }
          ((ProfileContentTitleView)localObject1).setTitle(QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingNameGuestDefault", "一起在玩"));
          bool1 = bool3;
          if (((ProfileMiniAppInfo)localObject3).appPlayingInfos.size() > 1) {
            bool1 = true;
          }
          ((ProfileContentTitleView)localObject1).setArrowEnable(bool1);
          localObject2 = new MiniAppProfileCardGuestView(this.mActivity);
          localObject4 = (MiniAppProfileCardGuestView)localObject2;
          ((MiniAppProfileCardGuestView)localObject4).setData(((ProfileMiniAppInfo)localObject3).appPlayingInfos, ((ProfileMiniAppInfo)localObject3).guestJumpUrl, paramCard.uin);
          ((ProfileContentTitleView)localObject1).addContentView((View)localObject2);
          if (i != 0) {
            updateMiniGuestItemColor((MiniAppProfileCardGuestView)localObject4);
          }
        }
        this.mViewContainer = localObject1;
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportProfileCardExposed(localObject3, bool4);
        paramCard = (Card)localObject1;
        break label733;
        label385:
        return false;
      }
      else
      {
        if (bool4)
        {
          bool1 = bool2;
          localObject2 = localObject1;
          if (!(localObject1 instanceof ProfileContentTitleView)) {
            break label738;
          }
          paramCard = (ProfileContentTitleView)localObject1;
          if (((ProfileMiniAppInfo)localObject3).miniAppInfoArrayList.size() > 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          paramCard.setArrowEnable(bool1);
          localObject2 = (BaseMiniAppProfileCardView)paramCard.getContentView();
          ((BaseMiniAppProfileCardView)localObject2).setData(((ProfileMiniAppInfo)localObject3).miniAppInfoArrayList);
          if (i != 0) {
            updateMiniItemColor((BaseMiniAppProfileCardView)localObject2);
          }
          bool1 = bool2;
          localObject2 = localObject1;
          if (((ProfileMiniAppInfo)localObject3).miniAppInfoArrayList.size() <= 1) {
            break label738;
          }
          paramCard = paramCard.mTitleContainer;
          paramCard.setTag(new DataTag(96, Boolean.valueOf(true)));
          paramCard.setOnClickListener(this);
          bool1 = bool2;
          localObject2 = localObject1;
          break label738;
        }
        bool1 = bool2;
        localObject2 = localObject1;
        if (!(localObject1 instanceof ProfileContentTitleView)) {
          break label738;
        }
        localObject4 = (ProfileContentTitleView)localObject1;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((ProfileMiniAppInfo)localObject3).guestAppTotal);
        ((StringBuilder)localObject2).append(QzoneConfig.getInstance().getConfig("QZoneSetting", "ProfileCardMiniPlayingNameGuest", "个一起在玩的小游戏"));
        ((ProfileContentTitleView)localObject4).setTitle(((StringBuilder)localObject2).toString());
        if (((ProfileMiniAppInfo)localObject3).guestAppTotal > 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((ProfileContentTitleView)localObject4).setArrowEnable(bool1);
        localObject2 = (MiniAppProfileCardGuestView)((ProfileContentTitleView)localObject4).getContentView();
        ((MiniAppProfileCardGuestView)localObject2).setData(((ProfileMiniAppInfo)localObject3).appPlayingInfos, ((ProfileMiniAppInfo)localObject3).guestJumpUrl, paramCard.uin);
        if (i != 0) {
          updateMiniGuestItemColor((MiniAppProfileCardGuestView)localObject2);
        }
        bool1 = bool2;
        localObject2 = localObject1;
        if (((ProfileMiniAppInfo)localObject3).guestAppTotal <= 1) {
          break label738;
        }
        paramCard = ((ProfileContentTitleView)localObject4).mTitleContainer;
        paramCard.setTag(new DataTag(96, Boolean.valueOf(false)));
        paramCard.setOnClickListener(this);
        bool1 = bool2;
        localObject2 = localObject1;
        break label738;
      }
    }
    else
    {
      bool1 = bool2;
      localObject2 = localObject1;
      if (localObject1 == null) {
        break label738;
      }
      this.mViewContainer = null;
      paramCard = (Card)localObject1;
    }
    label733:
    bool1 = true;
    localObject2 = paramCard;
    label738:
    if ((localObject2 instanceof ProfileContentTitleView)) {
      updateItemTheme((ProfileContentTitleView)localObject2, true);
    }
    return bool1;
  }
  
  private void updateMiniGuestItemColor(MiniAppProfileCardGuestView paramMiniAppProfileCardGuestView)
  {
    Object localObject = ((ProfileCardInfo)this.mData).currentTemplate.templateAttr.get("commonItemContentColor");
    if (localObject != null)
    {
      if ((localObject instanceof ColorStateList))
      {
        paramMiniAppProfileCardGuestView.setTextColor((ColorStateList)localObject);
        return;
      }
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        if (((String)localObject).startsWith("#")) {
          paramMiniAppProfileCardGuestView.setTextColor(Color.parseColor((String)localObject));
        }
      }
    }
  }
  
  private void updateMiniItemColor(BaseMiniAppProfileCardView paramBaseMiniAppProfileCardView)
  {
    Object localObject = ((ProfileCardInfo)this.mData).currentTemplate.templateAttr.get("commonItemContentColor");
    if (localObject != null)
    {
      if ((localObject instanceof ColorStateList))
      {
        paramBaseMiniAppProfileCardView.setTextColor((ColorStateList)localObject);
        return;
      }
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        if (((String)localObject).startsWith("#")) {
          paramBaseMiniAppProfileCardView.setTextColor(Color.parseColor((String)localObject));
        }
      }
    }
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
    boolean bool = ((Boolean)((DataTag)paramView.getTag()).b).booleanValue();
    Object localObject = (ProfileMiniAppInfo)((ProfileCardInfo)this.mData).getBusinessInfo(ProfileMiniAppInfo.class);
    IMiniAppService localIMiniAppService = (IMiniAppService)QRoute.api(IMiniAppService.class);
    Context localContext = paramView.getContext();
    if (bool) {
      localObject = ((ProfileMiniAppInfo)localObject).tabJumpUrl;
    } else {
      localObject = ((ProfileMiniAppInfo)localObject).guestJumpUrl;
    }
    localIMiniAppService.startAppByLink(localContext, (String)localObject, 2, 2062, null);
    ProfileCardReport.reportMiniAppClick(this.mQQAppInterface, (ProfileCardInfo)this.mData);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshMini(((ProfileCardInfo)this.mData).card);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.miniapp.ProfileMiniAppComponent
 * JD-Core Version:    0.7.0.1
 */