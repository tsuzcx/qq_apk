package com.tencent.mobileqq.guild.live.fragment.audience.module.videobar;

import android.content.res.Configuration;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.control.IGuildLiveTopBarControl;
import com.tencent.mobileqq.guild.live.fragment.base.control.QQGuildLiveModuleControl;
import com.tencent.mobileqq.guild.live.fragment.base.module.videobar.QQGuildLiveBaseVideoBarFragment;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveRoomVM;
import com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveViewModelProvider;
import com.tencent.mobileqq.guild.live.widget.GuildLiveNetLoadingView;
import com.tencent.mobileqq.guild.util.GuildFastClickUtil;
import com.tencent.mobileqq.guild.util.GuildLiveDtUtil;
import com.tencent.mobileqq.guild.util.livedata.GulidLiveDataUtils;
import com.tencent.mobileqq.guild.util.livedata.LiveDataExtKt;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

public class QQGuildVideoBarLiveFragment
  extends QQGuildLiveBaseVideoBarFragment
  implements View.OnClickListener
{
  private View a;
  private View d;
  private boolean e;
  private FrameLayout f;
  private QQGuildLiveRoomVM g;
  private GuildLiveNetLoadingView h;
  private FrameLayout i;
  private final Observer<View> j = new QQGuildVideoBarLiveFragment.1(this);
  private View k;
  
  private void a(FrameLayout paramFrameLayout)
  {
    View localView = (View)QQGuildLiveRoomUiData.a().d().getValue();
    if (localView != null) {
      a(paramFrameLayout, localView);
    }
  }
  
  private void a(FrameLayout paramFrameLayout, View paramView)
  {
    if (this.e) {
      return;
    }
    Object localObject = paramView.getParent();
    if ((localObject instanceof ViewGroup))
    {
      QLog.i("QGL.QQGuildVideoBarLiveFragment", 1, "videoView.parent remove.");
      ((ViewGroup)localObject).removeView(paramView);
    }
    localObject = new FrameLayout.LayoutParams(-1, -1);
    QLog.i("QGL.QQGuildVideoBarLiveFragment", 1, "containerView add videoView suc.");
    paramFrameLayout.addView(paramView, 0, (ViewGroup.LayoutParams)localObject);
    this.e = true;
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.h.setGravity(17);
      this.i.addView(this.h);
      return;
    }
    this.i.removeView(this.h);
  }
  
  private void b(View paramView)
  {
    if (paramView == null)
    {
      e();
      return;
    }
    a(this.f, paramView);
  }
  
  private void b(boolean paramBoolean)
  {
    this.f.setKeepScreenOn(paramBoolean);
  }
  
  private void c(View paramView)
  {
    IGProChannelInfo localIGProChannelInfo = QQGuildLiveStartParamsCache.a().getChannelInfo();
    Object localObject = QQGuildLiveStartParamsCache.a().getGuildInfo();
    if (localIGProChannelInfo != null)
    {
      if (localObject == null) {
        return;
      }
      localObject = new GuildLiveDtUtil(localIGProChannelInfo, (IGProGuildInfo)localObject).a();
      VideoReport.setPageId(paramView, "pg_sgrp_stream_aio");
      ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(paramView, localIGProChannelInfo, (Map)localObject);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    View localView = this.a;
    int m;
    if (paramBoolean) {
      m = 0;
    } else {
      m = 8;
    }
    localView.setVisibility(m);
  }
  
  public static QQGuildLiveModuleBaseFragment d()
  {
    return new QQGuildVideoBarLiveFragment();
  }
  
  private void d(View paramView)
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.a, "em_stream_aio_zoom", null);
  }
  
  private void e()
  {
    this.f.removeAllViews();
    this.e = false;
  }
  
  private void g()
  {
    if (getActivity() == null) {
      return;
    }
    if (GuildFastClickUtil.a("QGL.video_root_fast_click")) {
      return;
    }
    int m = getActivity().getRequestedOrientation();
    boolean bool = ((Boolean)LiveDataExtKt.a(this.g.g(), Boolean.valueOf(false))).booleanValue();
    if (((m == 0) || (bool)) && (this.c != null) && (this.c.b() != null)) {
      this.c.b().cv_();
    }
  }
  
  private void h()
  {
    if (((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().e(), Boolean.valueOf(true))).booleanValue())
    {
      if (getActivity() != null) {
        getActivity().setRequestedOrientation(0);
      }
    }
    else {
      this.g.b(true);
    }
  }
  
  protected void a()
  {
    this.g = ((QQGuildLiveRoomVM)QQGuildLiveViewModelProvider.a(this.b).get(QQGuildLiveRoomVM.class));
  }
  
  protected void a(@NonNull View paramView)
  {
    this.i = ((FrameLayout)paramView.findViewById(2131434674));
    this.d = paramView;
    this.a = paramView.findViewById(2131434673);
    this.a.setOnClickListener(this);
    this.h = new GuildLiveNetLoadingView(getContext());
    this.k = paramView.findViewById(2131434671);
    this.k.setOnClickListener(this);
    paramView.setOnClickListener(this);
    this.f = ((FrameLayout)paramView.findViewById(2131434675));
    a(this.f);
    c(paramView);
    d(paramView);
  }
  
  protected int b()
  {
    return 2131625062;
  }
  
  protected void cs_()
  {
    QQGuildLiveRoomUiData.a().d().observeForever(this.j);
    LiveData localLiveData = QQGuildLiveRoomUiData.a().c();
    localLiveData.observe(getViewLifecycleOwner(), new QQGuildVideoBarLiveFragment.2(this));
    GulidLiveDataUtils.a(localLiveData, this.g.g()).observe(getViewLifecycleOwner(), new QQGuildVideoBarLiveFragment.3(this));
    QQGuildLiveRoomUiData.a().m().observe(getViewLifecycleOwner(), new QQGuildVideoBarLiveFragment.4(this));
    QQGuildLiveRoomUiData.a().c().observe(getViewLifecycleOwner(), new QQGuildVideoBarLiveFragment.5(this));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131434673) {
      h();
    } else if (paramView.getId() == 2131434671) {
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onConfigurationChanged(@NonNull Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int m = paramConfiguration.orientation;
    boolean bool = true;
    if (m == 2) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      c(false);
      return;
    }
    if (QQGuildLiveRoomUiData.a().e().getValue() != Boolean.TRUE) {
      bool = false;
    }
    c(bool);
  }
  
  public void onDestroyView()
  {
    QQGuildLiveRoomUiData.a().d().removeObserver(this.j);
    e();
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.videobar.QQGuildVideoBarLiveFragment
 * JD-Core Version:    0.7.0.1
 */