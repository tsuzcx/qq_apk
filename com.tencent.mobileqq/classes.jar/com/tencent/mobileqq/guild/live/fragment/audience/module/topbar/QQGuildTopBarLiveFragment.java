package com.tencent.mobileqq.guild.live.fragment.audience.module.topbar;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.control.IGuildLiveChatBarControl;
import com.tencent.mobileqq.guild.live.fragment.base.control.IGuildLiveRootControl;
import com.tencent.mobileqq.guild.live.fragment.base.control.QQGuildLiveModuleControl;
import com.tencent.mobileqq.guild.live.fragment.base.module.topbar.QQGuildLiveBaseTopBarFragment;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveRoomVM;
import com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveViewModelProvider;
import com.tencent.mobileqq.guild.share.GuildShareActionSheet;
import com.tencent.mobileqq.guild.util.GuildLiveDtUtil;
import com.tencent.mobileqq.guild.util.livedata.GulidLiveDataUtils;
import com.tencent.mobileqq.guild.util.livedata.LiveDataExtKt;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

public class QQGuildTopBarLiveFragment
  extends QQGuildLiveBaseTopBarFragment
  implements View.OnClickListener
{
  private QQGuildLiveRoomVM a;
  private TextView d;
  private View e;
  private ImageView f;
  private View g;
  private TextView h;
  private QQCustomDialog i;
  private ViewGroup j;
  private View k;
  
  private void a(boolean paramBoolean)
  {
    View localView = this.g;
    int m;
    if (paramBoolean) {
      m = 0;
    } else {
      m = 8;
    }
    localView.setVisibility(m);
  }
  
  private void b(View paramView)
  {
    IGProChannelInfo localIGProChannelInfo = QQGuildLiveStartParamsCache.a().getChannelInfo();
    HashMap localHashMap = new GuildLiveDtUtil(localIGProChannelInfo, QQGuildLiveStartParamsCache.a().getGuildInfo()).a();
    VideoReport.setPageId(paramView, "pg_sgrp_stream_aio");
    VideoReport.setPageId(this.j, "pg_sgrp_stream_aio_pop");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(paramView, localIGProChannelInfo, localHashMap);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(this.j, localIGProChannelInfo, localHashMap);
  }
  
  private void c(View paramView)
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView.findViewById(2131434666), "em_stream_aio_share", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView.findViewById(2131434664), "em_stream_aio_fwindow", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView.findViewById(2131434673), "em_stream_aio_zoom", null);
    if (((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().b(), Boolean.valueOf(false))).booleanValue())
    {
      ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView.findViewById(2131434662), "em_stream_aio_button", null);
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("sgroup_stream_aio_manage_type", Integer.valueOf(1));
      ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView.findViewById(2131434665), "em_stream_aio_manage", localHashMap);
      return;
    }
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView.findViewById(2131434662), "em_return_button_aio_pg", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(paramView.findViewById(2131434665), "em_aio_channel_setting", null);
  }
  
  public static QQGuildLiveModuleBaseFragment d()
  {
    return new QQGuildTopBarLiveFragment();
  }
  
  private void j()
  {
    if ((this.c != null) && (this.c.a() != null)) {
      this.c.a().b(true);
    }
  }
  
  private void k()
  {
    if (getActivity() != null)
    {
      QQGuildLiveRoomStartParams localQQGuildLiveRoomStartParams = QQGuildLiveStartParamsCache.a();
      new GuildShareActionSheet(getActivity(), localQQGuildLiveRoomStartParams.getGuildInfo(), localQQGuildLiveRoomStartParams.getChannelInfo()).a();
    }
  }
  
  private void l()
  {
    if ((this.c != null) && (this.c.c() != null)) {
      this.c.c().e();
    }
  }
  
  private void m()
  {
    boolean bool = ((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().l(), Boolean.valueOf(false))).booleanValue();
    IGProChannelInfo localIGProChannelInfo = QQGuildLiveStartParamsCache.a().getChannelInfo();
    IGProGuildInfo localIGProGuildInfo = QQGuildLiveStartParamsCache.a().getGuildInfo();
    if (bool)
    {
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildChannelInfoSetting(getActivity(), localIGProGuildInfo.getGuildID(), localIGProChannelInfo, localIGProChannelInfo.getCategoryName(), 2);
      return;
    }
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildChannelInfoSettingForMember(getActivity(), localIGProGuildInfo.getGuildID(), localIGProChannelInfo.getChannelUin());
  }
  
  private void n()
  {
    if (getActivity() != null) {
      getActivity().onBackPressed();
    }
  }
  
  private void o()
  {
    if (getContext() == null) {
      return;
    }
    Object localObject1 = getResources().getString(2131890431);
    Object localObject2 = getResources().getString(2131890432);
    String str = getResources().getString(2131890433);
    this.i = DialogUtil.a(getContext(), 230, null, (CharSequence)localObject1, (String)localObject2, str, new QQGuildTopBarLiveFragment.8(this), new QQGuildTopBarLiveFragment.9(this));
    this.j = this.i.getRootView();
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.j.findViewById(2131431864), "em_stream_aio_cancel", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.j.findViewById(2131431870), "em_stream_aio_end", null);
    localObject1 = QQGuildLiveStartParamsCache.a().getChannelInfo();
    localObject2 = new GuildLiveDtUtil((IGProChannelInfo)localObject1, QQGuildLiveStartParamsCache.a().getGuildInfo()).a();
    VideoReport.setPageId(this.j, "pg_sgrp_stream_aio_pop");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(this.j, (IGProChannelInfo)localObject1, (Map)localObject2);
    this.i.show();
  }
  
  protected void a()
  {
    this.a = ((QQGuildLiveRoomVM)QQGuildLiveViewModelProvider.a(this.b).get(QQGuildLiveRoomVM.class));
  }
  
  protected void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.f = ((ImageView)paramView.findViewById(2131434662));
    this.f.setOnClickListener(this);
    paramView.findViewById(2131434666).setOnClickListener(this);
    this.g = paramView.findViewById(2131434665);
    this.g.setOnClickListener(this);
    this.h = ((TextView)paramView.findViewById(2131434668));
    this.h.setOnClickListener(this);
    this.d = ((TextView)paramView.findViewById(2131434667));
    this.e = paramView.findViewById(2131434664);
    this.e.setVisibility(4);
    this.e.setOnClickListener(this);
    this.k = paramView;
    b(paramView);
    c(paramView);
  }
  
  protected int b()
  {
    return 2131625060;
  }
  
  protected void cs_()
  {
    this.a.f().observe(getViewLifecycleOwner(), new QQGuildTopBarLiveFragment.1(this));
    GulidLiveDataUtils.a(QQGuildLiveRoomUiData.a().b(), this.a.g()).observe(getViewLifecycleOwner(), new QQGuildTopBarLiveFragment.2(this));
    this.a.g().observe(getViewLifecycleOwner(), new QQGuildTopBarLiveFragment.3(this));
    QQGuildLiveRoomUiData.a().l().observe(getViewLifecycleOwner(), new QQGuildTopBarLiveFragment.4(this));
    QQGuildLiveRoomUiData.a().g().observe(getViewLifecycleOwner(), new QQGuildTopBarLiveFragment.5(this));
  }
  
  public void e()
  {
    if (((Boolean)LiveDataExtKt.a(this.a.g(), Boolean.valueOf(false))).booleanValue()) {
      super.e();
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.a.g().getValue() == Boolean.TRUE)
    {
      this.a.b(false);
      return true;
    }
    if (QQGuildLiveRoomUiData.a().b().getValue() == Boolean.TRUE)
    {
      o();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131434662) {
      n();
    } else if (paramView.getId() == 2131434664) {
      j();
    } else if (paramView.getId() == 2131434665) {
      m();
    } else if (paramView.getId() == 2131434668) {
      l();
    } else if (paramView.getId() == 2131434666) {
      k();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLiveFragment
 * JD-Core Version:    0.7.0.1
 */