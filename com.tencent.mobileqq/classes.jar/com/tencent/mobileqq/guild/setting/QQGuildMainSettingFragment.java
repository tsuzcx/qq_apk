package com.tencent.mobileqq.guild.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildJubaoApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.share.GuildShareActionSheet;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import java.util.List;

public class QQGuildMainSettingFragment
  extends QQGuildTitleBarFragment
  implements Handler.Callback, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static long o;
  private ActionSheet A;
  private IGProGuildInfo B;
  private String C = "";
  private WeakReferenceHandler D = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private TextView E;
  private boolean F;
  private String G;
  private String H;
  private String I = "";
  private GPServiceObserver J = new QQGuildMainSettingFragment.1(this);
  private Button p;
  private LinearLayout q;
  private RelativeLayout r;
  private RelativeLayout s;
  private RelativeLayout t;
  private RelativeLayout u;
  private FormSwitchItem v;
  private RelativeLayout w;
  private RelativeLayout x;
  private RelativeLayout y;
  private TextView z;
  
  public static Intent a(IGProGuildInfo paramIGProGuildInfo)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", paramIGProGuildInfo);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void a(int paramInt, @Nullable Intent paramIntent)
  {
    if (paramInt == -1) {
      a(paramIntent.getStringExtra("guild_nickname"));
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (l() != null)
    {
      if (this.B == null) {
        return;
      }
      if (paramInt == 0)
      {
        RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)l().getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        RecentUser localRecentUser2 = localRecentUserProxy.b(this.B.getGuildID(), 10014);
        RecentUser localRecentUser1 = localRecentUser2;
        if (localRecentUser2 == null) {
          localRecentUser1 = new RecentUser(this.B.getGuildID(), 10014);
        }
        if (paramBoolean) {
          localRecentUser1.showUpTime = (System.currentTimeMillis() / 1000L);
        } else {
          localRecentUser1.showUpTime = 0L;
        }
        localRecentUserProxy.b(localRecentUser1);
      }
    }
  }
  
  private void a(String paramString)
  {
    this.I = paramString;
    if (TextUtils.isEmpty(this.I))
    {
      this.z.setText("未设置");
      return;
    }
    this.z.setText(this.I);
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      this.v.setOnCheckedChangeListener(null);
      this.v.setChecked(paramBoolean ^ true);
      this.v.setOnCheckedChangeListener(this);
    }
  }
  
  private void i()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.b.setText("");
    this.c.setText(2131916340);
    this.p = ((Button)this.l.findViewById(2131432655));
    this.p.setOnClickListener(this);
    this.q = ((LinearLayout)this.l.findViewById(2131434690));
    this.r = ((RelativeLayout)this.l.findViewById(2131434606));
    this.r.setOnClickListener(this);
    this.s = ((RelativeLayout)this.l.findViewById(2131434551));
    this.s.setOnClickListener(this);
    this.t = ((RelativeLayout)this.l.findViewById(2131444962));
    this.t.setOnClickListener(this);
    this.u = ((RelativeLayout)this.l.findViewById(2131444963));
    this.u.setOnClickListener(this);
    this.v = ((FormSwitchItem)this.l.findViewById(2131430656));
    this.v.setBackgroundColor(getContext().getResources().getColor(2131166273));
    this.w = ((RelativeLayout)this.l.findViewById(2131434694));
    this.w.setOnClickListener(this);
    this.x = ((RelativeLayout)this.l.findViewById(2131434721));
    this.x.setOnClickListener(this);
    this.E = ((TextView)this.l.findViewById(2131436690));
    this.E.setOnClickListener(this);
    this.y = ((RelativeLayout)this.l.findViewById(2131434703));
    this.z = ((TextView)this.l.findViewById(2131434702));
    this.y.setOnClickListener(this);
  }
  
  private void j()
  {
    Object localObject = getActivity().getIntent();
    this.B = ((IGProGuildInfo)((Intent)localObject).getExtras().getSerializable("extra_guild_guild_info"));
    this.C = ((Intent)localObject).getExtras().getString("extra_channel_id");
    localObject = this.B;
    if (localObject == null)
    {
      QLog.e("QQGuildCustomTitleBarFragment", 1, "initData guildInfo is null");
      QQGuildUtil.b("initData guildInfo is null");
      return;
    }
    this.v.setChecked(((IGProGuildInfo)localObject).isTop());
    this.v.setOnCheckedChangeListener(this);
    if (QQGuildUtil.a(this.B)) {
      this.q.setVisibility(0);
    } else {
      this.q.setVisibility(8);
    }
    if (QQGuildUtil.b(this.B))
    {
      this.p.setVisibility(8);
      this.E.setVisibility(8);
    }
    else
    {
      this.p.setVisibility(0);
      this.E.setVisibility(0);
    }
    if (QQGuildUtil.b()) {
      this.x.setVisibility(0);
    } else {
      this.x.setVisibility(8);
    }
    this.H = this.B.getGuildID();
    this.G = ((IGPSService)l().getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).addObserver(this.J);
    a(((IGPSService)l().getRuntimeService(IGPSService.class, "")).getSelfGuildMemberName(this.B.getGuildID()));
  }
  
  private void k()
  {
    if (this.B != null) {
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openRobotList(getQBaseActivity(), this.B.getGuildID());
    }
  }
  
  private void m()
  {
    if (this.B != null)
    {
      List localList = ((IGuildAdapterService)l().getRuntimeService(IGuildAdapterService.class, "")).getChannelList(this.B.getGuildID(), true);
      if ("".equals(this.C)) {
        if (localList != null)
        {
          if (localList.size() == 0) {
            return;
          }
          this.C = ((IGProChannelInfo)localList.get(0)).toString();
        }
        else
        {
          return;
        }
      }
      ((IQQGuildJubaoApi)QRoute.api(IQQGuildJubaoApi.class)).reportGuild(getQBaseActivity(), this.B.getGuildID(), this.C, 25086, true);
    }
  }
  
  private void n()
  {
    if (this.B != null) {
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildNicknameSetting(getActivity(), this.B.getGuildID(), this.I);
    }
  }
  
  private void o()
  {
    if (this.B != null) {
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openChannelNotifySetting(getActivity(), this.B);
    }
  }
  
  private void p()
  {
    if (this.A == null)
    {
      this.A = ActionSheet.create(getActivity());
      this.A.setMainTitle(2131889063);
      this.A.addButton(2131889053, 3, 2131434725);
      this.A.setOnButtonClickListener(new QQGuildMainSettingFragment.2(this));
      this.A.addCancelButton(getString(2131887648));
    }
    this.A.show();
    if (!this.F)
    {
      y();
      this.F = true;
    }
  }
  
  private void q()
  {
    if (this.B != null) {
      ((IGPSService)l().getRuntimeService(IGPSService.class, "")).removeGuild(this.B.getGuildID(), new QQGuildMainSettingFragment.3(this));
    }
  }
  
  private void r()
  {
    if (this.B != null) {
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildInfoSetting(getContext(), this.B);
    }
  }
  
  private void s()
  {
    getActivity().finish();
  }
  
  private void t()
  {
    if (this.B == null)
    {
      QLog.e("QQGuildCustomTitleBarFragment", 1, "error guildInfo is null");
      QQToast.makeText(getContext(), 1, getResources().getString(2131889041), 1).show();
      return;
    }
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildChannelListSetting(getContext(), String.valueOf(this.B.getGuildID()));
  }
  
  private void u()
  {
    Intent localIntent = QQGuildMemberFragment.a(this.B);
    localIntent.putExtra("extra_channel_id", this.C);
    QPublicFragmentActivity.Launcher.a(getContext(), localIntent, QPublicFragmentActivity.class, QQGuildMemberFragment.class);
  }
  
  private void v()
  {
    new GuildShareActionSheet(getQBaseActivity(), this.B, null).a();
  }
  
  private void w()
  {
    if (this.B == null) {
      return;
    }
    VideoReport.addToDetectionWhitelist(getQBaseActivity());
    VideoReport.setPageId(this.k, "pg_sgrp_set");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.k, this.B.getGuildID(), null);
  }
  
  private void x()
  {
    VideoReport.setElementId(this.r, "em_sgrp_set_profile");
    VideoReport.setElementExposePolicy(this.r, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this.r, ClickPolicy.REPORT_ALL);
    VideoReport.setElementId(this.s, "em_sgrp_set_channel_mange");
    VideoReport.setElementExposePolicy(this.s, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this.s, ClickPolicy.REPORT_ALL);
    VideoReport.setElementId(this.x, "em_sgrp_set_bots");
    VideoReport.setElementExposePolicy(this.x, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this.x, ClickPolicy.REPORT_ALL);
    VideoReport.setElementId(this.v.getSwitch(), "em_sgrp_set_message_top");
    VideoReport.setElementExposePolicy(this.v.getSwitch(), ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this.v.getSwitch(), ClickPolicy.REPORT_ALL);
    VideoReport.setElementDynamicParams(this.v.getSwitch(), new QQGuildMainSettingFragment.5(this));
    VideoReport.setElementId(this.p, "em_sgrp_set_quit");
    VideoReport.setElementExposePolicy(this.p, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(this.p, ClickPolicy.REPORT_ALL);
    VideoReport.setElementId(this.w, "em_sgrp_set_notice");
    VideoReport.setElementExposePolicy(this.w, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this.w, ClickPolicy.REPORT_ALL);
  }
  
  private void y()
  {
    VideoReport.addToDetectionWhitelist(getQBaseActivity());
    VideoReport.setPageId(this.A.getRootView(), "pg_sgrp_set");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.A.getRootView(), this.B.getGuildID(), null);
    View localView = this.A.findViewById(2131427548);
    VideoReport.setElementId(localView, "em_sgrp_set_confirm");
    VideoReport.setElementExposePolicy(localView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(localView, ClickPolicy.REPORT_ALL);
    VideoReport.setElementParam(localView, "quit_result", Integer.valueOf(2));
    localView = this.A.findViewById(2131434725);
    VideoReport.setElementId(localView, "em_sgrp_set_confirm");
    VideoReport.setElementExposePolicy(localView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(localView, ClickPolicy.REPORT_ALL);
    VideoReport.setElementParam(localView, "quit_result", Integer.valueOf(1));
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    i();
    j();
    w();
    x();
  }
  
  protected int b()
  {
    return 2131625079;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 255) {
      return false;
    }
    int i = paramMessage.arg1;
    boolean bool;
    if (paramMessage.arg2 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    b(i, bool);
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 255) {
      a(paramInt2, paramIntent);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((this.B != null) && (paramCompoundButton == this.v.getSwitch())) {
      ((IGPSService)l().getRuntimeService(IGPSService.class, "")).setGuildTop(this.B.getGuildID(), paramBoolean, new QQGuildMainSettingFragment.4(this, paramBoolean));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - o >= 300L)
    {
      o = System.currentTimeMillis();
      if ((paramView != this.a) && (paramView != this.b))
      {
        if (paramView == this.s) {
          t();
        } else if (paramView == this.r) {
          r();
        } else if (paramView == this.p) {
          p();
        } else if (paramView == this.w) {
          o();
        } else if (paramView == this.x) {
          k();
        } else if (paramView == this.E) {
          m();
        } else if (paramView == this.t) {
          u();
        } else if (paramView == this.u) {
          v();
        } else if (paramView == this.y) {
          n();
        }
      }
      else {
        s();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ActionSheet localActionSheet = this.A;
    if (localActionSheet != null) {
      localActionSheet.dismiss();
    }
    this.D.removeCallbacksAndMessages(null);
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).deleteObserver(this.J);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMainSettingFragment
 * JD-Core Version:    0.7.0.1
 */