package com.tencent.mobileqq.guild.notice;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildNoticeFrameController;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuildNoticeFragment
  extends QPublicBaseFragment
{
  public GuildNoticeAdapter a;
  private View b;
  private View c;
  private TextView d;
  private TextView e;
  private ImageView f;
  private URLImageView g;
  private LinearLayout h;
  private GuildMainViewContext i;
  private XListView j;
  private int k = 0;
  private GuildNoticeFrameController l;
  private GuildNoticeViewModel m;
  private final AbsListView.OnScrollListener n = new GuildNoticeFragment.1(this);
  private final OverScrollViewListener o = new GuildNoticeFragment.2(this);
  
  public static GuildNoticeFragment a(Intent paramIntent)
  {
    GuildNoticeFragment localGuildNoticeFragment = new GuildNoticeFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("data", paramIntent);
    localGuildNoticeFragment.setArguments(localBundle);
    return localGuildNoticeFragment;
  }
  
  private void a(List<GuildNotice> paramList)
  {
    this.a.a(paramList);
  }
  
  private void b()
  {
    int i1 = LiuHaiUtils.e(getActivity());
    this.b.setPadding(0, i1, 0, 0);
    this.d = ((TextView)this.b.findViewById(2131434740));
    this.d.getPaint().setFakeBoldText(true);
    this.f = ((ImageView)this.b.findViewById(2131434618));
    this.f.setOnClickListener(new GuildNoticeFragment.3(this));
    this.g = ((URLImageView)this.b.findViewById(2131434706));
    this.e = ((TextView)this.b.findViewById(2131434708));
    this.h = ((LinearLayout)this.b.findViewById(2131434707));
    this.h.setVisibility(8);
    this.j = ((XListView)this.b.findViewById(2131434581));
    this.j.setDivider(null);
    this.c = LayoutInflater.from(getActivity()).inflate(2131625031, null);
    this.j.setOverScrollFooter(this.c);
    this.j.setOnScrollListener(this.n);
    this.j.setOverScrollListener(this.o);
    this.j.setScrollingCacheEnabled(true);
    this.j.setKeepScreenOn(true);
  }
  
  private void c()
  {
    this.a = new GuildNoticeAdapter(this.i);
    this.j.setAdapter(this.a);
    this.m = ((GuildNoticeViewModel)ViewModelProviderHelper.a(this).get(GuildNoticeViewModel.class));
    this.m.a((AppInterface)getQBaseActivity().getAppRuntime(), 1);
    this.a.a(this.m);
    this.m.d().observe(getViewLifecycleOwner(), new GuildNoticeFragment.4(this));
    this.m.a().observe(getViewLifecycleOwner(), new GuildNoticeFragment.5(this));
    this.m.b().observe(getViewLifecycleOwner(), new GuildNoticeFragment.6(this));
  }
  
  private void d()
  {
    this.j.setVisibility(8);
    this.h.setVisibility(0);
    this.g.setBackgroundURL("http://down.qq.com/innovate/guild/guild_notice_empty_view.png");
    this.e.setText(2131890527);
  }
  
  private void e()
  {
    this.j.setVisibility(0);
    this.h.setVisibility(8);
  }
  
  private void f()
  {
    if (this.k == 1)
    {
      GuildMainViewContext localGuildMainViewContext = this.i;
      if (localGuildMainViewContext != null) {
        this.l = new GuildNoticeFrameController(localGuildMainViewContext);
      }
    }
  }
  
  private void g()
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.b, "pg_sgrp_auditnotification_set");
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "0S200MNJT807V3GE");
    VideoReport.setPageParams(this.b, new PageParams(localHashMap));
  }
  
  public void a()
  {
    GuildNoticeViewModel localGuildNoticeViewModel = this.m;
    if (localGuildNoticeViewModel != null) {
      localGuildNoticeViewModel.a(false);
    }
  }
  
  public void a(GuildMainViewContext paramGuildMainViewContext)
  {
    this.i = paramGuildMainViewContext;
  }
  
  public boolean onBackEvent()
  {
    this.i.a(true, true);
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = paramLayoutInflater.inflate(2131625013, paramViewGroup, false);
    b();
    c();
    f();
    g();
    paramLayoutInflater = this.b;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.m.a((AppInterface)this.i.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeFragment
 * JD-Core Version:    0.7.0.1
 */