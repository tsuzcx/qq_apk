package com.tencent.mobileqq.guild.mainframe.container.inbox;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuildInboxFragment
  extends QPublicBaseFragment
{
  private ViewGroup a;
  private TextView b;
  private GuildMainViewContext c;
  private XListView d;
  private GuildInboxAdapter e;
  private DragFrameLayout f;
  private GuildInboxViewModel g;
  private HashMap<Integer, GuildNoticeRedPoint> h;
  
  public static GuildInboxFragment a(Intent paramIntent)
  {
    GuildInboxFragment localGuildInboxFragment = new GuildInboxFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("data", paramIntent);
    localGuildInboxFragment.setArguments(localBundle);
    return localGuildInboxFragment;
  }
  
  private void a(List<GuildNoticeRedPoint> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (this.h.containsKey(Integer.valueOf(((GuildNoticeRedPoint)paramList.get(i)).a)))
      {
        this.h.put(Integer.valueOf(((GuildNoticeRedPoint)paramList.get(i)).a), paramList.get(i));
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("update redpoint=");
          localStringBuilder.append(this.h.get(Integer.valueOf(((GuildNoticeRedPoint)paramList.get(i)).a)));
          QLog.d("QQGuildNoticeFragment", 4, localStringBuilder.toString());
        }
      }
      i += 1;
    }
  }
  
  private void e()
  {
    this.b = ((TextView)this.a.findViewById(2131434758));
    this.b.getPaint().setFakeBoldText(true);
    this.d = ((XListView)this.a.findViewById(2131434705));
    this.d.setDivider(null);
    this.d.setSelector(2131168376);
    this.f = ((DragFrameLayout)this.a.findViewById(2131434704));
    this.e = new GuildInboxAdapter(this.c);
    this.e.a(this.f);
    this.d.setAdapter(this.e);
  }
  
  private void f()
  {
    this.h = new HashMap();
    GuildNoticeRedPoint localGuildNoticeRedPoint = new GuildNoticeRedPoint();
    localGuildNoticeRedPoint.a = 1;
    this.h.put(Integer.valueOf(1), localGuildNoticeRedPoint);
    this.g = ((GuildInboxViewModel)ViewModelProviderHelper.a(getQBaseActivity()).get(GuildInboxViewModel.class));
    this.g.a((AppInterface)getQBaseActivity().getAppRuntime());
    this.g.a().observe(getQBaseActivity(), new GuildInboxFragment.1(this));
  }
  
  private List<GuildNoticeRedPoint> g()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.h.values());
    return localArrayList;
  }
  
  private void h()
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.a, "pg_sgrp_notificationbox");
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "0S200MNJT807V3GE");
    VideoReport.setPageParams(this.a, new PageParams(localHashMap));
  }
  
  public void a()
  {
    ViewGroup localViewGroup = this.a;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(0);
    }
  }
  
  public void a(GuildMainViewContext paramGuildMainViewContext)
  {
    this.c = paramGuildMainViewContext;
  }
  
  public void b()
  {
    ViewGroup localViewGroup = this.a;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
  }
  
  public void c()
  {
    this.g.b((AppInterface)getQBaseActivity().getAppRuntime());
  }
  
  public void d()
  {
    this.g.c((AppInterface)getQBaseActivity().getAppRuntime());
  }
  
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.a = ((ViewGroup)paramLayoutInflater.inflate(2131625100, paramViewGroup, false));
    e();
    f();
    h();
    paramLayoutInflater = this.a;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.inbox.GuildInboxFragment
 * JD-Core Version:    0.7.0.1
 */