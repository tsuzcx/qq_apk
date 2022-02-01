package com.tencent.mobileqq.guild.mainframe.container.discover;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.container.discover.handler.QQGuildDiscoverDataCenter;
import com.tencent.mobileqq.guild.mainframe.container.discover.handler.QQGuildDiscoverHandler;
import com.tencent.mobileqq.guild.mainframe.container.discover.handler.QQGuildDiscoverObserver;
import com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.QQGuildDiscoverBaseSubTabFragment.RefreshDataListener;
import com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.adapter.QQGuildDiscoverSubTabCommonRvAdapter.QQGuildDiscoverRvItemListener;
import com.tencent.mobileqq.guild.mainframe.container.discover.tab.GuildDiscoverViewPager;
import com.tencent.mobileqq.guild.mainframe.container.discover.tab.GuildDiscoverViewPagerAdapter;
import com.tencent.mobileqq.guild.mainframe.container.discover.tab.QQGuildDisSubTabInfo;
import com.tencent.mobileqq.guild.mainframe.container.discover.view.GuildDiscoverSlidingIndicator;
import com.tencent.mobileqq.guild.mainframe.container.discover.view.GuildDiscoverSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.guild.mainframe.container.discover.view.HeaderScrollView;
import com.tencent.mobileqq.guild.mainframe.container.discover.view.InterceptListener;
import com.tencent.mobileqq.guild.mainframe.container.discover.view.QQGuildDiscoverRefreshHeader;
import com.tencent.mobileqq.guild.mainframe.container.discover.view.QQGuildDiscoverRefreshLayout;
import com.tencent.mobileqq.guild.mainframe.container.discover.view.QQGuildDiscoverRefreshLayout.OnRefreshListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class QQGuildDiscoverFragment
  extends QBaseFragment
  implements View.OnClickListener, QQGuildDiscoverBaseSubTabFragment.RefreshDataListener, GuildDiscoverSlidingIndicator.OnTabListener, InterceptListener, QQGuildDiscoverRefreshLayout.OnRefreshListener
{
  public static boolean a = true;
  private QQGuildDiscoverObserver A = new QQGuildDiscoverFragment.4(this);
  MqqHandler b = new MqqHandler(Looper.getMainLooper(), new QQGuildDiscoverFragment.5(this));
  public QQGuildDiscoverSubTabCommonRvAdapter.QQGuildDiscoverRvItemListener c = new QQGuildDiscoverFragment.6(this);
  private ViewGroup d;
  private View e;
  private GuildMainViewContext f;
  private int g;
  private int h;
  private int i = -1;
  private boolean j = false;
  private boolean k;
  private GuildDiscoverSlidingIndicator l;
  private QQGuildDiscoverRefreshLayout m;
  private QQGuildDiscoverRefreshHeader n;
  private HeaderScrollView o;
  private GuildDiscoverViewPager p;
  private GuildDiscoverViewPagerAdapter q;
  private int r = 2;
  private FrameLayout s;
  private ArrayList<QQGuildDisSubTabInfo> t = new ArrayList();
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private View y;
  private QQGuildDiscoverFragment.QQGuidDiscoverAnimationListener z;
  
  public static QQGuildDiscoverFragment a(Intent paramIntent)
  {
    QQGuildDiscoverFragment localQQGuildDiscoverFragment = new QQGuildDiscoverFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("data", paramIntent);
    localQQGuildDiscoverFragment.setArguments(localBundle);
    return localQQGuildDiscoverFragment;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageChange. position:");
      localStringBuilder.append(paramInt);
      QLog.d("GuildDiscover.QQGuildDiscoverFragment", 2, localStringBuilder.toString());
    }
    this.o.setCurrentScrollableContainer(this.q.a(paramInt, true));
    this.q.b(paramInt, this.i);
    this.l.setCurrentPosition(paramInt, this.v ^ true);
    this.h = paramInt;
  }
  
  private void a(View paramView)
  {
    this.s = ((FrameLayout)paramView.findViewById(2131435291));
    this.s.setOnClickListener(this);
    this.l = ((GuildDiscoverSlidingIndicator)paramView.findViewById(2131434525));
    f();
    this.o = ((HeaderScrollView)paramView.findViewById(2131434524));
    HeaderScrollView localHeaderScrollView = this.o;
    localHeaderScrollView.setPadding(localHeaderScrollView.getPaddingLeft(), this.o.getPaddingTop(), this.o.getPaddingRight(), Utils.a(54.0F, getResources()));
    this.p = ((GuildDiscoverViewPager)paramView.findViewById(2131434523));
    this.q = new GuildDiscoverViewPagerAdapter(getChildFragmentManager(), e(), getQBaseActivity(), this.t, this);
    this.q.a(this);
    this.p.setAdapter(this.q);
    this.p.setOffscreenPageLimit(6);
    this.p.setOnPageChangeListener(new QQGuildDiscoverFragment.1(this));
    this.l.setOnTabListener(this);
    this.l.setInterceptListener(this);
    this.m = ((QQGuildDiscoverRefreshLayout)paramView.findViewById(2131434526));
    this.m.setRefreshCompleteDelayDuration(0);
    this.m.setRefreshEnabled(false);
    this.n = ((QQGuildDiscoverRefreshHeader)this.m.findViewById(2131434732));
    this.n.setRefreshHeaderUpdateListener(new QQGuildDiscoverFragment.2(this));
    this.m.setOnRefreshListener(this);
    b(b(false));
    if (this.h != 0) {
      this.j = true;
    }
    this.o.setOnScrollListener(new QQGuildDiscoverFragment.3(this));
    j();
  }
  
  private void a(View paramView, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sgrp_sub_channel_id", Long.valueOf(paramLong));
    VideoReport.reportEvent("clck", paramView, localHashMap);
  }
  
  private int b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.w = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDefaultTabPosition. defaultPos:");
      localStringBuilder.append(0);
      QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, localStringBuilder.toString());
    }
    return 0;
  }
  
  private void b(int paramInt)
  {
    if ((this.q != null) && (this.p != null) && (this.l != null) && (e() != null))
    {
      if (this.o == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("switchToTabPos mCurrentTabPos:");
        localStringBuilder.append(this.h);
        localStringBuilder.append("  pos:");
        localStringBuilder.append(paramInt);
        QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, localStringBuilder.toString());
      }
      if ((paramInt == 0) && (this.h == 0)) {
        a(paramInt, false);
      }
      this.h = paramInt;
      this.l.setCurrentPosition(this.h, false);
      this.p.setCurrentItem(this.h, false);
      this.o.setCurrentScrollableContainer(this.q.a(this.h, true));
    }
  }
  
  private long g()
  {
    return getActivity().getSharedPreferences("last_guild_discover_list_refresh_time", 0).getLong("last_guild_discover_list_refresh_time", 0L);
  }
  
  private void h()
  {
    long l1 = System.currentTimeMillis();
    getActivity().getSharedPreferences("last_guild_discover_list_refresh_time", 0).edit().putLong("last_guild_discover_list_refresh_time", l1).commit();
  }
  
  private void i()
  {
    Object localObject = this.m;
    if (localObject != null) {
      ((QQGuildDiscoverRefreshLayout)localObject).setRefreshing(false);
    }
    localObject = this.n;
    if (localObject != null) {
      ((QQGuildDiscoverRefreshHeader)localObject).setRefresh(false);
    }
  }
  
  private void j()
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.e, "pg_sgrp_discover");
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "0S200MNJT807V3GE");
    VideoReport.setPageParams(this.e, new PageParams(localHashMap));
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDiscoverTabChange. position:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" fromUserClick:");
      localStringBuilder.append(paramBoolean);
      QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, localStringBuilder.toString());
    }
    this.i = this.p.getCurrentItem();
    if (this.i != paramInt) {
      this.k = true;
    }
    this.h = paramInt;
    this.p.setCurrentItem(paramInt, false);
    return 0;
  }
  
  public void a()
  {
    Object localObject;
    if (NetworkUtil.isNetworkAvailable(getQBaseActivity()))
    {
      localObject = this.q;
      if (localObject != null)
      {
        GuildDiscoverViewPager localGuildDiscoverViewPager = this.p;
        if (localGuildDiscoverViewPager != null) {
          ((GuildDiscoverViewPagerAdapter)localObject).g(localGuildDiscoverViewPager.getCurrentItem());
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildDiscover.QQGuildDiscoverFragment", 2, "refresh falied. network unavailable");
      }
      localObject = this.b.obtainMessage(3);
      this.b.sendMessageDelayed((Message)localObject, 1000L);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.d = paramViewGroup;
  }
  
  public void a(GuildMainViewContext paramGuildMainViewContext)
  {
    this.f = paramGuildMainViewContext;
  }
  
  public void a(QQGuildDiscoverFragment.QQGuidDiscoverAnimationListener paramQQGuidDiscoverAnimationListener)
  {
    this.z = paramQQGuidDiscoverAnimationListener;
  }
  
  public void a(boolean paramBoolean)
  {
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(paramBoolean ^ true);
  }
  
  public void b()
  {
    GuildDiscoverViewPagerAdapter localGuildDiscoverViewPagerAdapter = this.q;
    if (localGuildDiscoverViewPagerAdapter != null) {
      localGuildDiscoverViewPagerAdapter.b();
    }
  }
  
  public void c()
  {
    this.x = false;
    Object localObject = this.e;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      this.e.setAlpha(1.0F);
      localObject = this.y;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      if ((!QQGuildDiscoverDataCenter.b()) && (this.u))
      {
        ((QQGuildDiscoverHandler)e().getBusinessHandler(QQGuildDiscoverHandler.class.getName())).a(0);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("show. isHasGuildData() == ");
          ((StringBuilder)localObject).append(QQGuildDiscoverDataCenter.b());
          ((StringBuilder)localObject).append(", mIsResumed == ");
          ((StringBuilder)localObject).append(this.u);
          ((StringBuilder)localObject).append(", mCurrentTabPos:");
          ((StringBuilder)localObject).append(this.h);
          ((StringBuilder)localObject).append(" isBackground_Stop:");
          ((StringBuilder)localObject).append(e().isBackgroundStop);
          ((StringBuilder)localObject).append(" isBackground_Pause:");
          ((StringBuilder)localObject).append(e().isBackgroundPause);
          QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void d()
  {
    this.x = true;
    View localView = this.e;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public AppInterface e()
  {
    if ((getQBaseActivity().getAppRuntime() instanceof AppInterface)) {
      return (AppInterface)getQBaseActivity().getAppRuntime();
    }
    return null;
  }
  
  protected void f()
  {
    if (this.l != null)
    {
      boolean bool1 = ThemeUtil.isNowThemeIsDefaultCache(e(), true);
      int i2 = 200;
      boolean bool2 = ThemeUtil.isNowThemeIsNight(e(), false, null);
      boolean bool3 = QQTheme.isNowSimpleUI();
      int i3 = 2131168002;
      int i4 = 2131168122;
      int i1;
      if (bool3)
      {
        if (bool2) {
          i1 = 2131167341;
        } else {
          i1 = 2131167340;
        }
        i2 = 255;
      }
      else
      {
        if (bool2)
        {
          i3 = 2131165915;
          i4 = 2131165914;
          i1 = 2131165913;
          i2 = 30;
          break label118;
        }
        if (!bool1)
        {
          i1 = 2131168002;
          break label118;
        }
        i1 = 2131168001;
      }
      i3 = 2131168001;
      label118:
      this.l.b(i2);
      this.l.a(i3, i4, i1);
    }
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("onAttach.  mCurrentTabPos:");
      paramContext.append(this.h);
      paramContext.append(" isBackground_Stop:");
      paramContext.append(e().isBackgroundStop);
      paramContext.append(" isBackground_Pause:");
      paramContext.append(e().isBackgroundPause);
      QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, paramContext.toString());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131435291) {
      QQToast.makeText(getContext(), 0, "点击搜索按钮", 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate.  mCurrentTabPos:");
      paramBundle.append(this.h);
      paramBundle.append(" isBackground_Stop:");
      paramBundle.append(e().isBackgroundStop);
      paramBundle.append(" isBackground_Pause:");
      paramBundle.append(e().isBackgroundPause);
      QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, paramBundle.toString());
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.e = paramLayoutInflater.inflate(2131625004, paramViewGroup, false);
    a(this.e);
    if (QLog.isColorLevel())
    {
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append("onCreateView.  mCurrentTabPos:");
      paramLayoutInflater.append(this.h);
      paramLayoutInflater.append(" isBackground_Stop:");
      paramLayoutInflater.append(e().isBackgroundStop);
      paramLayoutInflater.append(" isBackground_Pause:");
      paramLayoutInflater.append(e().isBackgroundPause);
      QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, paramLayoutInflater.toString());
    }
    paramLayoutInflater = this.e;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.q;
    if (localObject != null) {
      ((GuildDiscoverViewPagerAdapter)localObject).c();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy. mCurrentTabPos:");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append(" isBackground_Stop:");
      ((StringBuilder)localObject).append(e().isBackgroundStop);
      ((StringBuilder)localObject).append(" isBackground_Pause:");
      ((StringBuilder)localObject).append(e().isBackgroundPause);
      QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroyView. mCurrentTabPos:");
      localStringBuilder.append(this.h);
      localStringBuilder.append(" isBackground_Stop:");
      localStringBuilder.append(e().isBackgroundStop);
      localStringBuilder.append(" isBackground_Pause:");
      localStringBuilder.append(e().isBackgroundPause);
      QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDetach. mCurrentTabPos:");
      localStringBuilder.append(this.h);
      localStringBuilder.append(" isBackground_Stop:");
      localStringBuilder.append(e().isBackgroundStop);
      localStringBuilder.append(" isBackground_Pause:");
      localStringBuilder.append(e().isBackgroundPause);
      QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (e() != null) {
      e().removeObserver(this.A);
    }
    Object localObject = this.q;
    if (localObject != null)
    {
      GuildDiscoverViewPager localGuildDiscoverViewPager = this.p;
      if (localGuildDiscoverViewPager != null) {
        ((GuildDiscoverViewPagerAdapter)localObject).h(localGuildDiscoverViewPager.getCurrentItem());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPause. mCurrentTabPos:");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append(" isBackground_Stop:");
      ((StringBuilder)localObject).append(e().isBackgroundStop);
      ((StringBuilder)localObject).append(" isBackground_Pause:");
      ((StringBuilder)localObject).append(e().isBackgroundPause);
      QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, ((StringBuilder)localObject).toString());
    }
    this.u = false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.u = true;
    if (e() != null)
    {
      e().addObserver(this.A);
      ((QQGuildDiscoverHandler)e().getBusinessHandler(QQGuildDiscoverHandler.class.getName())).a(0);
    }
    Object localObject = this.l;
    if (localObject != null) {
      ((GuildDiscoverSlidingIndicator)localObject).setAccessibilityMsg();
    }
    if ((this.q != null) && (this.p != null)) {
      if (!this.j)
      {
        if (QLog.isColorLevel()) {
          QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, "mContactsViewPagerAdapter.doOnResume");
        }
        this.q.b(this.p.getCurrentItem(), false);
      }
      else
      {
        this.j = false;
      }
    }
    int i1 = this.h;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume. oldPos:");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" mCurrentTabPos:");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append(" isBackground_Stop:");
      ((StringBuilder)localObject).append(e().isBackgroundStop);
      ((StringBuilder)localObject).append(" isBackground_Pause:");
      ((StringBuilder)localObject).append(e().isBackgroundPause);
      QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.QQGuildDiscoverFragment
 * JD-Core Version:    0.7.0.1
 */