package com.tencent.mobileqq.guild.profilecard.manage;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.util.GuildLiveDtUtil;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.ICheckUserBannedSpeakInChannelCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/profilecard/manage/GuildProfileLiveManageComponent;", "Lcom/tencent/mobileqq/guild/profilecard/baseprofile/framework/component/AbsGuildProfileComponent;", "Landroid/view/View$OnClickListener;", "componentController", "Lcom/tencent/mobileqq/guild/profilecard/baseprofile/framework/controller/IGuildComponentController;", "data", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "(Lcom/tencent/mobileqq/guild/profilecard/baseprofile/framework/controller/IGuildComponentController;Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;)V", "TAG", "", "appRuntime", "Lmqq/app/AppRuntime;", "gPServiceObserver", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpsService", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "isMute", "Landroidx/lifecycle/MutableLiveData;", "", "muteIcon", "Landroid/widget/ImageView;", "muteTips", "Landroid/widget/TextView;", "operatorType", "", "userData", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildBaseProfileData;", "userDstType", "checkCanShow", "", "detachFromComponentController", "getComponentName", "getComponentType", "getContentLayoutId", "getReportUserMasterType", "Ljava/util/HashMap;", "", "onClick", "v", "Landroid/view/View;", "onInitData", "guildProfileData", "setDtElement", "setDtPage", "setMuteInLive", "setObservers", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildProfileLiveManageComponent
  extends AbsGuildProfileComponent
  implements View.OnClickListener
{
  private final String TAG = "GuildProfileLiveManageComponent";
  private AppRuntime appRuntime;
  private GPServiceObserver gPServiceObserver;
  private IGPSService gpsService;
  private MutableLiveData<Boolean> isMute = new MutableLiveData(Boolean.valueOf(false));
  private ImageView muteIcon;
  private TextView muteTips;
  private int operatorType;
  private GuildBaseProfileData userData;
  private MutableLiveData<Integer> userDstType = new MutableLiveData();
  
  public GuildProfileLiveManageComponent(@NotNull IGuildComponentController paramIGuildComponentController, @NotNull GuildProfileData paramGuildProfileData)
  {
    super(paramIGuildComponentController, paramGuildProfileData);
  }
  
  private final void checkCanShow()
  {
    Object localObject1 = QQGuildLiveRoomUiData.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QQGuildLiveRoomUiData.getInstance()");
    localObject1 = ((QQGuildLiveRoomUiData)localObject1).g();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QQGuildLiveRoomUiData.getInstance().channelInfo");
    Object localObject2;
    Object localObject3;
    if (((LiveData)localObject1).getValue() != null)
    {
      localObject1 = QQGuildLiveRoomUiData.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "QQGuildLiveRoomUiData.getInstance()");
      localObject1 = ((QQGuildLiveRoomUiData)localObject1).g();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "QQGuildLiveRoomUiData.getInstance().channelInfo");
      localObject1 = ((LiveData)localObject1).getValue();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "QQGuildLiveRoomUiData.ge…nce().channelInfo.value!!");
      localObject1 = String.valueOf(((IGProChannelInfo)localObject1).getLiveAnchorTinyId());
      localObject2 = this.TAG;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("currentAnchorId ");
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.d((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    }
    else
    {
      localObject1 = "";
    }
    if (QQGuildLiveStartParamsCache.a().roomIdIsValid())
    {
      localObject2 = this.userData;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("userData");
      }
      if (!Intrinsics.areEqual(localObject1, ((GuildBaseProfileData)localObject2).c()))
      {
        localObject1 = this.userData;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("userData");
        }
        localObject1 = ((GuildBaseProfileData)localObject1).c();
        localObject2 = this.userData;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("userData");
        }
        if (!Intrinsics.areEqual(localObject1, ((GuildBaseProfileData)localObject2).d()))
        {
          localObject1 = QQGuildLiveStartParamsCache.a();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "QQGuildLiveStartParamsCache.getCache()");
          boolean bool = QQGuildUtil.a(((QQGuildLiveRoomStartParams)localObject1).getGuildInfo());
          localObject1 = this.TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("checkCanShow self isGuildManager ");
          ((StringBuilder)localObject2).append(bool);
          QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          if (!bool)
          {
            localObject1 = QQGuildLiveRoomUiData.a();
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "QQGuildLiveRoomUiData.getInstance()");
            localObject1 = ((QQGuildLiveRoomUiData)localObject1).b();
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "QQGuildLiveRoomUiData.ge…ance().selfIsAnchorLiving");
            localObject1 = ((LiveData)localObject1).getValue();
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            if (!((Boolean)localObject1).booleanValue())
            {
              localObject1 = this.mViewContainer;
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "mViewContainer");
              ((ViewGroup)localObject1).setVisibility(8);
              return;
            }
          }
          localObject1 = new ArrayList();
          localObject2 = this.userData;
          if (localObject2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
          }
          ((ArrayList)localObject1).add(((GuildBaseProfileData)localObject2).c());
          localObject2 = this.gpsService;
          if (localObject2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gpsService");
          }
          localObject3 = this.userData;
          if (localObject3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
          }
          ((IGPSService)localObject2).fetchUserInfo(((GuildBaseProfileData)localObject3).a(), (List)localObject1, false, (IGetUserInfoCallback)new GuildProfileLiveManageComponent.checkCanShow.1(this));
          localObject1 = this.userDstType;
          localObject2 = this.mFragment;
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "mFragment");
          ((MutableLiveData)localObject1).observe(((Fragment)localObject2).getViewLifecycleOwner(), (Observer)new GuildProfileLiveManageComponent.checkCanShow.2(this));
          return;
        }
      }
    }
    localObject1 = this.mViewContainer;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mViewContainer");
    ((ViewGroup)localObject1).setVisibility(8);
  }
  
  private final HashMap<String, Object> getReportUserMasterType(GuildProfileData paramGuildProfileData)
  {
    Object localObject1 = QQGuildLiveStartParamsCache.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QQGuildLiveStartParamsCache.getCache()");
    localObject1 = ((QQGuildLiveRoomStartParams)localObject1).getChannelInfo();
    Object localObject2 = QQGuildLiveStartParamsCache.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "QQGuildLiveStartParamsCache.getCache()");
    localObject1 = new GuildLiveDtUtil((IGProChannelInfo)localObject1, ((QQGuildLiveRoomStartParams)localObject2).getGuildInfo()).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "pageParams");
    localObject2 = (Map)localObject1;
    ((Map)localObject2).put("sgrp_profile_scene", Integer.valueOf(4));
    String str = paramGuildProfileData.getGuildBaseProfileData().d();
    paramGuildProfileData = paramGuildProfileData.getGuildBaseProfileData().c();
    Integer localInteger = Integer.valueOf(0);
    if ((str != null) && (paramGuildProfileData != null))
    {
      ((Map)localObject2).put("sgrp_profile_userid", paramGuildProfileData);
      if (Intrinsics.areEqual(str, paramGuildProfileData))
      {
        ((Map)localObject2).put("sgrp_user_master", Integer.valueOf(1));
        return localObject1;
      }
      ((Map)localObject2).put("sgrp_user_master", localInteger);
      return localObject1;
    }
    ((Map)localObject2).put("sgrp_user_master", localInteger);
    ((Map)localObject2).put("sgrp_profile_userid", localInteger);
    return localObject1;
  }
  
  private final void setDtElement()
  {
    int i = 1;
    Map localMap = (Map)new HashMap(1);
    Object localObject = QQGuildLiveStartParamsCache.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QQGuildLiveStartParamsCache.getCache()");
    localObject = ((QQGuildLiveRoomStartParams)localObject).getChannelInfo();
    if (localObject == null) {
      return;
    }
    if (((IGProChannelInfo)localObject).getBannedSpeak() == 1) {
      i = 2;
    }
    localMap.put("sgrp_voicechannel_profile_block_condition", Integer.valueOf(i));
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.mViewContainer.findViewById(2131436469), "em_sgrp_voicechannel_profile_block", localMap);
  }
  
  private final void setDtPage(GuildProfileData paramGuildProfileData)
  {
    Object localObject = QQGuildLiveStartParamsCache.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QQGuildLiveStartParamsCache.getCache()");
    localObject = ((QQGuildLiveRoomStartParams)localObject).getChannelInfo();
    if (localObject == null) {
      return;
    }
    paramGuildProfileData = getReportUserMasterType(paramGuildProfileData);
    VideoReport.setPageId(this.mViewContainer, "pg_sgrp_profile");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setChannelPageParams((View)this.mViewContainer, (IGProChannelInfo)localObject, (Map)paramGuildProfileData);
  }
  
  private final void setMuteInLive()
  {
    Object localObject1 = QQGuildLiveStartParamsCache.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QQGuildLiveStartParamsCache.getCache()");
    long l = ((QQGuildLiveRoomStartParams)localObject1).getRoomId();
    localObject1 = this.gpsService;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("gpsService");
    }
    Object localObject2 = this.userData;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("userData");
    }
    localObject2 = ((GuildBaseProfileData)localObject2).a();
    Object localObject3 = this.userData;
    if (localObject3 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("userData");
    }
    localObject3 = ((GuildBaseProfileData)localObject3).i();
    GuildBaseProfileData localGuildBaseProfileData = this.userData;
    if (localGuildBaseProfileData == null) {
      Intrinsics.throwUninitializedPropertyAccessException("userData");
    }
    ((IGPSService)localObject1).setLiveChannelBannedUser((String)localObject2, (String)localObject3, String.valueOf(l), localGuildBaseProfileData.c(), this.operatorType, (IResultCallback)new GuildProfileLiveManageComponent.setMuteInLive.1(this));
    setDtElement();
  }
  
  private final void setObservers()
  {
    Object localObject1 = this.isMute;
    Object localObject2 = this.mFragment;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "mFragment");
    ((MutableLiveData)localObject1).observe(((Fragment)localObject2).getViewLifecycleOwner(), (Observer)new GuildProfileLiveManageComponent.setObservers.1(this));
    this.gPServiceObserver = ((GPServiceObserver)new GuildProfileLiveManageComponent.setObservers.2(this));
    localObject1 = (IGPSService)QQGuildUtil.b(IGPSService.class);
    localObject2 = this.gPServiceObserver;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("gPServiceObserver");
    }
    ((IGPSService)localObject1).addObserver((GPServiceObserver)localObject2);
  }
  
  public void detachFromComponentController()
  {
    super.detachFromComponentController();
    IGPSService localIGPSService = (IGPSService)QQGuildUtil.b(IGPSService.class);
    GPServiceObserver localGPServiceObserver = this.gPServiceObserver;
    if (localGPServiceObserver == null) {
      Intrinsics.throwUninitializedPropertyAccessException("gPServiceObserver");
    }
    localIGPSService.deleteObserver(localGPServiceObserver);
  }
  
  @NotNull
  public String getComponentName()
  {
    return this.TAG;
  }
  
  public int getComponentType()
  {
    return 1004;
  }
  
  public int getContentLayoutId()
  {
    return 2131625108;
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    if (paramView.getId() == 2131436469) {
      setMuteInLive();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onInitData(@NotNull GuildProfileData paramGuildProfileData)
  {
    Intrinsics.checkParameterIsNotNull(paramGuildProfileData, "guildProfileData");
    Object localObject1 = this.mViewContainer.findViewById(2131436469);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mViewContainer.findViewById(R.id.iv_mute_in_live)");
    this.muteIcon = ((ImageView)localObject1);
    localObject1 = this.mViewContainer.findViewById(2131448596);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mViewContainer.findViewById(R.id.tv_mute_live)");
    this.muteTips = ((TextView)localObject1);
    localObject1 = this.muteIcon;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("muteIcon");
    }
    ((ImageView)localObject1).setOnClickListener((View.OnClickListener)this);
    setObservers();
    localObject1 = MobileQQ.sMobileQQ.peekAppRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "MobileQQ.sMobileQQ.peekAppRuntime()");
    this.appRuntime = ((AppRuntime)localObject1);
    localObject1 = this.appRuntime;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
    }
    localObject1 = ((AppRuntime)localObject1).getRuntimeService(IGPSService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appRuntime.getRuntimeSer…va, ProcessConstant.MAIN)");
    this.gpsService = ((IGPSService)localObject1);
    super.onInitData(paramGuildProfileData);
    localObject1 = paramGuildProfileData.getGuildBaseProfileData();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "guildProfileData.guildBaseProfileData");
    this.userData = ((GuildBaseProfileData)localObject1);
    localObject1 = this.gpsService;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("gpsService");
    }
    Object localObject2 = this.userData;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("userData");
    }
    localObject2 = ((GuildBaseProfileData)localObject2).a();
    Object localObject3 = this.userData;
    if (localObject3 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("userData");
    }
    localObject3 = ((GuildBaseProfileData)localObject3).i();
    GuildBaseProfileData localGuildBaseProfileData = this.userData;
    if (localGuildBaseProfileData == null) {
      Intrinsics.throwUninitializedPropertyAccessException("userData");
    }
    ((IGPSService)localObject1).checkUserBannedSpeakInChannel((String)localObject2, (String)localObject3, localGuildBaseProfileData.c(), (ICheckUserBannedSpeakInChannelCallback)new GuildProfileLiveManageComponent.onInitData.1(this));
    checkCanShow();
    setDtPage(paramGuildProfileData);
    setDtElement();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileLiveManageComponent
 * JD-Core Version:    0.7.0.1
 */