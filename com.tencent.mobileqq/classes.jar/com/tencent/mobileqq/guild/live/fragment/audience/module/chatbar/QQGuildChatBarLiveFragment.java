package com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.data.QQGuildDTConstant;
import com.tencent.mobileqq.guild.live.IQQGuildLiveAIOListener;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.control.IGuildLiveRootControl;
import com.tencent.mobileqq.guild.live.fragment.base.control.QQGuildLiveModuleControl;
import com.tencent.mobileqq.guild.live.fragment.base.module.chatbar.QQGuildLiveBaseChatBarFragment;
import com.tencent.mobileqq.guild.live.livemanager.audience.QQGuildLiveAudienceRoomMgr;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveRoomVM;
import com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveViewModelProvider;
import com.tencent.mobileqq.guild.util.GuildFastClickUtil;
import com.tencent.mobileqq.guild.util.GuildLiveDtUtil;
import com.tencent.mobileqq.guild.util.GuildLiveToast;
import com.tencent.mobileqq.guild.util.livedata.GulidLiveDataUtils;
import com.tencent.mobileqq.guild.util.livedata.LiveDataExtKt;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.api.view.IQQGiftViewModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftEngineAnimationListener;
import com.tencent.mobileqq.qqgift.data.service.GiftSendReqData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class QQGuildChatBarLiveFragment
  extends QQGuildLiveBaseChatBarFragment
  implements IQQGuildLiveAIOListener, IQQGiftEngineAnimationListener
{
  private QBaseFragment a;
  private IQQGiftAnimationEngine d;
  private QQGuildLiveRoomVM e;
  private IQQGiftSDK f;
  private View g;
  
  private int a(int paramInt)
  {
    if (paramInt == 1) {
      return 2130840829;
    }
    return 2130840839;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, long paramLong, int paramInt5)
  {
    GiftAnimData localGiftAnimData = new GiftAnimData();
    localGiftAnimData.a = paramInt1;
    localGiftAnimData.c = paramString;
    localGiftAnimData.d = paramInt2;
    localGiftAnimData.m = paramInt3;
    localGiftAnimData.e = paramInt4;
    localGiftAnimData.g = paramLong;
    localGiftAnimData.b = paramInt5;
    paramString = this.d;
    if (paramString != null) {
      paramString.b(localGiftAnimData);
    }
  }
  
  private void a(@NonNull GiftMessage paramGiftMessage)
  {
    if ((QQGuildLiveAudienceRoomMgr.a().d() != paramGiftMessage.sender) && (paramGiftMessage.giftType == 0))
    {
      a(paramGiftMessage.giftID, paramGiftMessage.giftName, paramGiftMessage.materialID, paramGiftMessage.effectLevel, 1, paramGiftMessage.sender, paramGiftMessage.giftType);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QGL.QQGuildChatBarLiveFragment", 2, "[receiveGiftMessage] sender is myself");
    }
  }
  
  private boolean a(GiftServiceData paramGiftServiceData)
  {
    if ((paramGiftServiceData != null) && (paramGiftServiceData.d != 0))
    {
      GuildLiveToast.a(2131890485);
      return true;
    }
    if (QQGuildLiveStartParamsCache.a().getGuildInfo() == null)
    {
      QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "doBeforeSendGift guildInfo == null.");
      return true;
    }
    Object localObject = QQGuildLiveStartParamsCache.a().getGuildInfo().getGuildID();
    long l1 = QQGuildLiveStartParamsCache.a().getRoomId();
    long l2 = QQGuildLiveAudienceRoomMgr.a().d();
    long l3 = QQGuildLiveAudienceRoomMgr.a().e();
    paramGiftServiceData = new GiftSendReqData();
    paramGiftServiceData.a = l2;
    paramGiftServiceData.b = l3;
    paramGiftServiceData.f.put("room_id", String.valueOf(l1));
    paramGiftServiceData.f.put("user_from", "2");
    paramGiftServiceData.f.put("guild_id", localObject);
    paramGiftServiceData.e.put("roomid", String.valueOf(l1));
    paramGiftServiceData.e.put("anchor_uid", String.valueOf(l3));
    localObject = QQGuildLiveStartParamsCache.a().getChannelInfo();
    paramGiftServiceData.e.put("clusterid", ((IGProChannelInfo)localObject).getChannelUin());
    paramGiftServiceData.e.put("program_id", QQGuildLiveStartParamsCache.a().getLiveRoomProgramId());
    this.f.d().a(paramGiftServiceData);
    if (QLog.isColorLevel())
    {
      paramGiftServiceData = new StringBuilder();
      paramGiftServiceData.append("[initGiftSdk] senderUin:");
      paramGiftServiceData.append(l2);
      paramGiftServiceData.append(",receiverUin:");
      paramGiftServiceData.append(l3);
      paramGiftServiceData.append(",roomId:");
      paramGiftServiceData.append(l1);
      QLog.i("QGL.QQGuildChatBarLiveFragment", 2, paramGiftServiceData.toString());
    }
    return false;
  }
  
  public static QQGuildLiveModuleBaseFragment d()
  {
    return new QQGuildChatBarLiveFragment();
  }
  
  private void g()
  {
    this.a = ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).createGuildLiveChannelChatFragment(getActivity(), 2131434623);
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setLiveChannelAIOListener(this.a, this);
  }
  
  private void h()
  {
    IGPSService localIGPSService = (IGPSService)i().getRuntimeService(IGPSService.class, "");
    IGProChannelInfo localIGProChannelInfo = QQGuildLiveStartParamsCache.a().getChannelInfo();
    int j = localIGProChannelInfo.getBannedSpeak();
    int i = 1;
    if (j == 1) {
      i = 0;
    }
    localIGPSService.setChannelBannedSpeak(localIGProChannelInfo.getChannelUin(), i, new QQGuildChatBarLiveFragment.3(this, i));
    o();
  }
  
  private void j()
  {
    this.f = this.e.d();
    Object localObject = this.f;
    if (localObject == null)
    {
      QLog.e("QGL.QQGuildChatBarLiveFragment", 1, "mGiftSDK == null.");
      return;
    }
    this.d = ((IQQGiftSDK)localObject).e().a((QBaseActivity)getContext(), 0);
    this.d.a();
    this.d.a(this);
    localObject = k();
    if (localObject != null) {
      ((FrameLayout)localObject).addView(this.d.d(), new ViewGroup.LayoutParams(-1, -1));
    }
    this.e.c();
  }
  
  private FrameLayout k()
  {
    if ((this.c != null) && (this.c.a() != null)) {
      return this.c.a().d();
    }
    return null;
  }
  
  private void l()
  {
    Object localObject1 = (QBaseActivity)getContext();
    if (localObject1 != null)
    {
      Object localObject2 = this.f;
      if (localObject2 != null)
      {
        localObject2 = ((IQQGiftSDK)localObject2).e().a((QBaseActivity)localObject1);
        ((IQQGiftPanelView)localObject2).setPanelEventListener(((IQQGiftPanelView)localObject2).a(new QQGuildChatBarLiveFragment.4(this, (IQQGiftPanelView)localObject2)));
        localObject1 = ((QBaseActivity)localObject1).getWindow().getDecorView().findViewById(16908290);
        ((IQQGiftPanelView)localObject2).setCacheList(this.f.d().d());
        ((IQQGiftPanelView)localObject2).setDtPageExtra(m());
        ((IQQGiftPanelView)localObject2).a((View)localObject1);
      }
    }
  }
  
  private HashMap<String, String> m()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = QQGuildLiveStartParamsCache.a().getChannelInfo();
    IGProGuildInfo localIGProGuildInfo = QQGuildLiveStartParamsCache.a().getGuildInfo();
    if ((localObject != null) && (localIGProGuildInfo != null))
    {
      localHashMap.put("sgrp_channel_id", localIGProGuildInfo.getGuildID());
      localHashMap.put("sgrp_sub_channel_id", ((IGProChannelInfo)localObject).getChannelUin());
      localHashMap.put("sgrp_sub_channel_name", ((IGProChannelInfo)localObject).getChannelName());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(QQGuildDTConstant.a(localIGProGuildInfo.getUserType()));
      ((StringBuilder)localObject).append("");
      localHashMap.put("sgrp_user_type", ((StringBuilder)localObject).toString());
    }
    return localHashMap;
  }
  
  private void n()
  {
    IGProChannelInfo localIGProChannelInfo = QQGuildLiveStartParamsCache.a().getChannelInfo();
    Object localObject = QQGuildLiveStartParamsCache.a().getGuildInfo();
    if (localIGProChannelInfo != null)
    {
      if (localObject == null) {
        return;
      }
      localObject = new GuildLiveDtUtil(localIGProChannelInfo, (IGProGuildInfo)localObject).a();
      VideoReport.setPageId(this.g, "pg_sgrp_stream_aio");
      ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(this.g, localIGProChannelInfo, (Map)localObject);
    }
  }
  
  private void o()
  {
    IGProChannelInfo localIGProChannelInfo = QQGuildLiveStartParamsCache.a().getChannelInfo();
    if (localIGProChannelInfo == null) {
      return;
    }
    int i = 1;
    HashMap localHashMap = new HashMap(1);
    if (localIGProChannelInfo.getBannedSpeak() != 1) {
      i = 2;
    }
    localHashMap.put("sgrp_stream_aio_comment_set_click", Integer.valueOf(i));
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.g.findViewById(2131427968), "em_stream_aio_comment_set", localHashMap);
  }
  
  private void p()
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.g.findViewById(2131427968), "em_aio_gifts", null);
  }
  
  protected void a()
  {
    this.e = ((QQGuildLiveRoomVM)QQGuildLiveViewModelProvider.a(this.b).get(QQGuildLiveRoomVM.class));
  }
  
  protected void a(@NonNull View paramView)
  {
    this.g = paramView;
    g();
    j();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.c != null) && (this.c.a() != null)) {
      this.c.a().a(paramBoolean);
    }
  }
  
  protected int b()
  {
    return 2131625057;
  }
  
  public LiveData<String> c()
  {
    return this.e.f();
  }
  
  protected void cs_()
  {
    GulidLiveDataUtils.a(QQGuildLiveRoomUiData.a().b(), QQGuildLiveRoomUiData.a().c()).observe(getViewLifecycleOwner(), new QQGuildChatBarLiveFragment.1(this));
    QQGuildLiveRoomUiData.a().k().observe(getViewLifecycleOwner(), new QQGuildChatBarLiveFragment.2(this));
  }
  
  public void ct_()
  {
    if (GuildFastClickUtil.a("QGL.QQGuildChatBarLiveFragment.leftIconClick")) {
      return;
    }
    boolean bool = ((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().c(), Boolean.valueOf(false))).booleanValue();
    if (((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().b(), Boolean.valueOf(false))).booleanValue())
    {
      h();
      return;
    }
    if (bool) {
      l();
    }
  }
  
  public int cu_()
  {
    int j = ViewUtils.dip2px(108.0F);
    int i;
    if (getContext() != null) {
      i = DisplayUtil.a(getContext()).a * 9 / 16;
    } else {
      i = ViewUtils.dip2px(240.0F);
    }
    return j + i;
  }
  
  public void e() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).onLiveChannelOnActivityResult(this.a, paramInt1, paramInt2, paramIntent);
  }
  
  public void onAnimationEnd(GiftAnimData paramGiftAnimData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "onAnimationEnd");
    }
    this.e.b(paramGiftAnimData);
  }
  
  public void onAnimationStart(GiftAnimData paramGiftAnimData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QGL.QQGuildChatBarLiveFragment", 1, "onAnimationStart");
    }
    this.e.a(paramGiftAnimData);
  }
  
  public boolean onBackEvent()
  {
    return ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).onLiveChannelBackEvent(this.a);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    IQQGiftAnimationEngine localIQQGiftAnimationEngine = this.d;
    if (localIQQGiftAnimationEngine != null)
    {
      localIQQGiftAnimationEngine.b(this);
      this.d.c();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (this.a != null) {
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).onNewIntentInLiveChannel(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.QQGuildChatBarLiveFragment
 * JD-Core Version:    0.7.0.1
 */