package com.tencent.mobileqq.guild.mainframe.container.facade;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.main.QQGuildChannelView.ConstructParams;
import com.tencent.mobileqq.guild.main.QQGuildChannelView.ConstructParamsBuilder;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.container.discover.GuildDiscoverAnimationManager;
import com.tencent.mobileqq.guild.mainframe.helper.ChannelListViewHelper;
import com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemViewExtHelper;
import com.tencent.mobileqq.guild.message.GuildGuestObserver;
import com.tencent.mobileqq.guild.message.guest.IGuildGuestHandler;
import com.tencent.mobileqq.guild.widget.BannerLayout;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QQGuildFacadeFragment
  extends QPublicBaseFragment
{
  public static String b;
  public ViewGroup a;
  protected String c;
  private ViewGroup d;
  private ViewGroup e;
  private BannerLayout f;
  private RoundRectUrlImageView g;
  private FacadeArgsData h;
  private boolean i = false;
  private GuildFacadeTopFrameController j;
  private GuildFacadeChannelFrameController k;
  private GuildMainViewContext l;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private GuildGuestObserver p = new QQGuildFacadeFragment.1(this);
  
  public static QQGuildFacadeFragment a(FacadeArgsData paramFacadeArgsData)
  {
    QQGuildFacadeFragment localQQGuildFacadeFragment = new QQGuildFacadeFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("data", paramFacadeArgsData);
    localQQGuildFacadeFragment.setArguments(localBundle);
    return localQQGuildFacadeFragment;
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    ((GuildLeftItemViewExtHelper)this.l.a(GuildMainFrameConstants.d)).a(paramString1, paramString2, paramString3);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.d == null) {
      return;
    }
    if (!GuildDiscoverAnimationManager.d) {
      return;
    }
    b = GuildDiscoverAnimationManager.a(this.h);
    Object localObject = this.j;
    if ((localObject != null) && (this.k != null))
    {
      ((GuildFacadeTopFrameController)localObject).a(this.h);
      this.k.a(this.h);
      this.d.setVisibility(0);
      return;
    }
    this.j = new GuildFacadeTopFrameController(this.l, this.h, this.e, this.f);
    localObject = this.j.c();
    localObject = new QQGuildChannelView.ConstructParamsBuilder().a((View)localObject).a(this.h).a(this.j).a(ChannelListViewHelper.a()).a();
    this.k = new GuildFacadeChannelFrameController(this.l, this.e, (QQGuildChannelView.ConstructParams)localObject);
    this.d.setVisibility(0);
  }
  
  private void g()
  {
    this.g = ((RoundRectUrlImageView)this.d.findViewById(2131431420));
    this.e = ((ViewGroup)this.d.findViewById(2131435278));
    this.a = ((ViewGroup)this.d.findViewById(2131435277));
    this.f = ((BannerLayout)this.d.findViewById(2131436894));
    this.g.getLayoutParams().height = ChannelListViewHelper.a(getActivity());
    h();
    ((AppInterface)this.l.a()).addObserver(this.p);
  }
  
  private void h()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showFacadeFrame, guildId = ");
      localStringBuilder.append(this.h.b);
      localStringBuilder.append(",type = ");
      localStringBuilder.append(this.h.a);
      QLog.d("QQGuildFacadeFragment", 2, localStringBuilder.toString());
    }
    if (this.h.a == 1)
    {
      i();
      return;
    }
    if (this.h.a == 0) {
      j();
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showLocalGuildCard guildId = ");
      ((StringBuilder)localObject1).append(this.h.b);
      QLog.d("QQGuildFacadeFragment", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (IGPSService)this.l.a().getRuntimeService(IGPSService.class, "");
    ((IGPSService)localObject2).getSelfGuildMemberName(this.h.b);
    Object localObject1 = ((IGPSService)localObject2).getGuildInfo(this.h.b);
    if (localObject1 == null)
    {
      a(false, true);
      ((IGPSService)localObject2).fetchGuildInfo(this.h.b, new QQGuildFacadeFragment.2(this));
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("showLocalGuildCard, 本地缓存");
    ((StringBuilder)localObject2).append(localObject1);
    QLog.i("GuildDiscover", 2, ((StringBuilder)localObject2).toString());
    a(true, false);
  }
  
  private void j()
  {
    Object localObject = (IGuildAdapterService)this.l.a().getRuntimeService(IGuildAdapterService.class, "");
    IGProGuildInfo localIGProGuildInfo = ((IGuildAdapterService)localObject).getGuildInfo(this.h.b, this.h.a);
    if (localIGProGuildInfo == null)
    {
      ((IGuildAdapterService)localObject).setVisitorGuildCardInfo(null, null, null);
      a(false, true);
      if ((this.o) && (this.h.b.equals(this.c)))
      {
        a(false, false);
        return;
      }
      l();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showVisitorGuildCard, 本地缓存");
    ((StringBuilder)localObject).append(localIGProGuildInfo);
    QLog.i("GuildDiscover", 2, ((StringBuilder)localObject).toString());
    a(localIGProGuildInfo.getGuildID(), localIGProGuildInfo.getAvatarUrl(100), localIGProGuildInfo.getGuildName());
    a(true, false);
  }
  
  private void k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMaskGone, isMockAnimationOver = ");
    localStringBuilder.append(GuildDiscoverAnimationManager.b);
    QLog.i("GuildDiscover", 2, localStringBuilder.toString());
    if (GuildDiscoverAnimationManager.b)
    {
      QLog.i("GuildDiscover", 2, "setMaskGone, 动画已经播完，直接 GONE");
      GuildDiscoverAnimationManager.a(this.g, this.a);
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new QQGuildFacadeFragment.3(this), 500L);
  }
  
  private void l()
  {
    ((IGuildGuestHandler)((AppInterface)this.l.a()).getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildGuestHandlerName())).a(this.h.b);
    this.o = true;
  }
  
  private void m()
  {
    ((IGPSService)this.l.a().getRuntimeService(IGPSService.class, "")).fetchGuildInfoForGuest(this.h.b, new QQGuildFacadeFragment.4(this));
  }
  
  private void n()
  {
    ((IGPSService)this.l.a().getRuntimeService(IGPSService.class, "")).fetchGuestGuild(this.h.b, new QQGuildFacadeFragment.5(this));
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mFacadeFragment.show(), ");
    ((StringBuilder)localObject).append(this.d);
    QLog.i("GuildDiscover", 2, ((StringBuilder)localObject).toString());
    localObject = this.d;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(0);
    }
    localObject = this.k;
    if (localObject != null) {
      ((GuildFacadeChannelFrameController)localObject).f();
    }
  }
  
  public void a(GuildMainViewContext paramGuildMainViewContext)
  {
    this.l = paramGuildMainViewContext;
  }
  
  public void a(boolean paramBoolean)
  {
    ((AppInterface)this.l.a()).addObserver(this.p);
    GuildFacadeChannelFrameController localGuildFacadeChannelFrameController = this.k;
    if (localGuildFacadeChannelFrameController != null) {
      localGuildFacadeChannelFrameController.a(paramBoolean);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildFacadeFragment", 2, "hide.");
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(8);
    }
    localObject = this.k;
    if (localObject != null) {
      ((GuildFacadeChannelFrameController)localObject).g();
    }
    localObject = this.j;
    if (localObject != null) {
      ((GuildFacadeTopFrameController)localObject).e();
    }
  }
  
  public void b(FacadeArgsData paramFacadeArgsData)
  {
    if ((paramFacadeArgsData != null) && (!TextUtils.isEmpty(paramFacadeArgsData.b)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mFacadeFragment.update(), ");
      ((StringBuilder)localObject).append(paramFacadeArgsData);
      QLog.i("GuildDiscover", 2, ((StringBuilder)localObject).toString());
      localObject = this.h;
      if ((localObject != null) && (!TextUtils.isEmpty(((FacadeArgsData)localObject).b)) && (!this.h.b.equals(paramFacadeArgsData.b)))
      {
        this.c = this.h.b;
        this.o = false;
      }
      this.h = paramFacadeArgsData;
      this.i = true;
      h();
      return;
    }
    QLog.e("QQGuildFacadeFragment", 1, "update args is null !");
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildFacadeFragment", 2, "pause.");
    }
    Object localObject = this.k;
    if (localObject != null) {
      ((GuildFacadeChannelFrameController)localObject).d();
    }
    localObject = this.j;
    if (localObject != null) {
      ((GuildFacadeTopFrameController)localObject).d();
    }
  }
  
  public boolean c(FacadeArgsData paramFacadeArgsData)
  {
    if (paramFacadeArgsData != null)
    {
      if (this.h == null) {
        return true;
      }
      if (paramFacadeArgsData.b != null)
      {
        if (this.h.b == null) {
          return true;
        }
        if ((paramFacadeArgsData.b.equals(this.h.b)) && (paramFacadeArgsData.a == this.h.a))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("needUpdate false");
            localStringBuilder.append(paramFacadeArgsData.toString());
            QLog.d("QQGuildFacadeFragment", 1, localStringBuilder.toString());
          }
          return false;
        }
      }
    }
    return true;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildFacadeFragment", 2, "resume.");
    }
    GuildFacadeChannelFrameController localGuildFacadeChannelFrameController = this.k;
    if (localGuildFacadeChannelFrameController != null) {
      localGuildFacadeChannelFrameController.e();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildFacadeFragment", 2, "destroy.");
    }
    Object localObject = this.j;
    if (localObject != null)
    {
      ((GuildFacadeTopFrameController)localObject).b();
      this.j = null;
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((GuildFacadeChannelFrameController)localObject).b();
      this.k = null;
    }
  }
  
  public void f()
  {
    ((IGuildAdapterService)this.l.a().getRuntimeService(IGuildAdapterService.class, "")).setVisitorGuildCardInfo(null, null, null);
    this.c = null;
    this.o = false;
    ((AppInterface)this.l.a()).removeObserver(this.p);
    GuildFacadeChannelFrameController localGuildFacadeChannelFrameController = this.k;
    if (localGuildFacadeChannelFrameController != null) {
      localGuildFacadeChannelFrameController.c();
    }
  }
  
  public boolean onBackEvent()
  {
    GuildFacadeTopFrameController localGuildFacadeTopFrameController = this.j;
    if ((localGuildFacadeTopFrameController != null) && (localGuildFacadeTopFrameController.h())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if ((paramBundle != null) && (!this.i)) {
      this.h = ((FacadeArgsData)paramBundle.getParcelable("data"));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildFacadeFragment", 2, "onCreate.");
    }
    this.m = true;
  }
  
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.d = ((ViewGroup)paramLayoutInflater.inflate(2131625039, paramViewGroup, false));
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildFacadeFragment", 2, "onCreateView.");
    }
    paramLayoutInflater = this.h;
    if ((paramLayoutInflater != null) && (!TextUtils.isEmpty(paramLayoutInflater.b))) {
      g();
    } else {
      QLog.e("QQGuildFacadeFragment", 1, "onCreateView args is null !");
    }
    paramLayoutInflater = this.d;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildFacadeFragment", 2, "onDestroy.");
    }
    ((AppInterface)this.l.a()).removeObserver(this.p);
    this.i = false;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildFacadeFragment", 2, "onDestroyView.");
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildFacadeFragment", 2, "onDetach.");
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHiddenChanged. hidden == ");
      localStringBuilder.append(paramBoolean);
      QLog.i("QQGuildFacadeFragment", 2, localStringBuilder.toString());
    }
    if ((!paramBoolean) && (isAdded()))
    {
      this.n = false;
      return;
    }
    this.n = true;
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildFacadeFragment", 2, "onPause.");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildFacadeFragment", 2, "onResume.");
    }
    if (this.m)
    {
      this.m = false;
      GuildFacadeChannelFrameController localGuildFacadeChannelFrameController = this.k;
      if (localGuildFacadeChannelFrameController != null) {
        localGuildFacadeChannelFrameController.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.facade.QQGuildFacadeFragment
 * JD-Core Version:    0.7.0.1
 */