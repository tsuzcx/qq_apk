package com.tencent.mobileqq.guild.mainframe.container.facade;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.main.QQGuildChannelView.OnListViewScroll;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.setting.popup.GuildMainSettingDialogFragment;
import com.tencent.mobileqq.guild.setting.popup.GuildMedalBubbleLayout;
import com.tencent.mobileqq.guild.source.QQGuildJumpSource;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.widget.BannerLayout;
import com.tencent.mobileqq.guild.widget.ChannelTitleLayout;
import com.tencent.mobileqq.guild.widget.ChannelTitleLayout.LayoutParamBuilder;
import com.tencent.mobileqq.guild.widget.ChannelTitleLayout.Param;
import com.tencent.mobileqq.guild.widget.GuildChannelListHeadView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class GuildFacadeTopFrameController
  extends GuildFacadeFrameBaseController
  implements View.OnClickListener, QQGuildChannelView.OnListViewScroll
{
  public static final int a = ViewUtils.dpToPx(11.0F);
  private final GPServiceObserver d = o();
  private final ViewGroup e;
  private final BannerLayout f;
  private GuildMainSettingDialogFragment g;
  private GuildChannelListHeadView h;
  private ChannelTitleLayout i;
  private GuildMedalBubbleLayout j;
  private PopupWindow k;
  private final Runnable l = new GuildFacadeTopFrameController.1(this);
  
  public GuildFacadeTopFrameController(GuildMainViewContext paramGuildMainViewContext, FacadeArgsData paramFacadeArgsData, ViewGroup paramViewGroup, BannerLayout paramBannerLayout)
  {
    super(paramGuildMainViewContext, paramFacadeArgsData);
    this.e = paramViewGroup;
    this.f = paramBannerLayout;
    a();
  }
  
  private PopupWindow a(Context paramContext, boolean paramBoolean)
  {
    PopupWindow localPopupWindow = new PopupWindow(-2, -2);
    this.j = new GuildMedalBubbleLayout(paramContext, paramBoolean);
    localPopupWindow.setContentView(this.j);
    return localPopupWindow;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    int n = this.e.getChildCount();
    int m = 0;
    while (m < n)
    {
      if (this.e.getChildAt(m) == paramView) {
        return;
      }
      m += 1;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt1, paramInt2);
    this.e.addView(paramView, localLayoutParams);
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = QLog.isDevelopLevel();
    boolean bool1 = true;
    if (bool2) {
      QLog.d("GuildFacadeTopFrameController", 2, String.format("scrollImp firstVisibleItem:%d, offset:%d, itemHeight:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    if (paramInt1 != 0) {
      bool1 = false;
    }
    e();
    this.i.a(bool1, paramInt2, ChannelTitleLayout.b + ChannelTitleLayout.a);
    this.f.a(bool1, paramInt2, ChannelTitleLayout.b);
    a(this.i, -1, -2);
  }
  
  private void f()
  {
    Object localObject2 = i();
    boolean bool2 = false;
    if (localObject2 == null)
    {
      g();
      QLog.d("GuildFacadeTopFrameController", 1, new Object[] { "updateTopFrameView guildId = ", this.b.b, ", guildInfo is null!" });
      return;
    }
    Object localObject1 = l();
    String str1 = k();
    String str2 = ((IGProGuildInfo)localObject2).getGuildID();
    int m = ((IGProGuildInfo)localObject2).getMedalLevel();
    localObject2 = QQGuildUtil.a(m);
    QLog.d("GuildFacadeTopFrameController", 1, new Object[] { "updateTopFrameView guildId = ", this.b.b, ", guildInfo, name: ", localObject1, " url: ", str1 });
    boolean bool1;
    if (this.b.a == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (this.b.a == 1) {
      bool2 = true;
    }
    localObject1 = new ChannelTitleLayout.LayoutParamBuilder().a(str1).b((String)localObject1).c(str2).b(bool1).a(bool2).a(m).a();
    this.i.a((ChannelTitleLayout.Param)localObject1);
    this.h.setShowJoinButton(bool1);
    this.f.setOnClickListener(this);
    this.f.a(str1, str2, (String)localObject2);
    this.h.setTopPadding(Math.max(this.f.a() - a, ChannelTitleLayout.a - a));
    e();
    s();
    t();
  }
  
  private void g()
  {
    this.i.a(new ChannelTitleLayout.LayoutParamBuilder().a());
    this.h.setShowJoinButton(false);
    this.f.a("", "", "");
    this.h.setTopPadding(0);
  }
  
  private IGProGuildInfo i()
  {
    return ((IGuildAdapterService)QQGuildUtil.b(IGuildAdapterService.class)).getGuildInfo(this.b.b, this.b.a);
  }
  
  private void j()
  {
    this.k.getContentView().measure(0, 0);
    int m = this.i.getMedalView().getWidth() / 2;
    int n = this.k.getContentView().getMeasuredWidth() / 2;
    int i1 = Utils.a(3.0F, this.k.getContentView().getResources());
    this.k.showAsDropDown(this.i.getMedalView(), m - n, i1);
  }
  
  private String k()
  {
    String str;
    if (i() != null) {
      str = i().getCoverUrl(500, 300);
    } else {
      str = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("top bg view，url = ");
      localStringBuilder.append(str);
      QLog.i("GuildDiscover", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  private String l()
  {
    if (i() != null) {
      return i().getGuildName();
    }
    return "未知频道";
  }
  
  private void m()
  {
    ((IGPSService)QQGuildUtil.b(IGPSService.class)).addObserver(this.d);
  }
  
  private void n()
  {
    ((IGPSService)QQGuildUtil.b(IGPSService.class)).deleteObserver(this.d);
  }
  
  private GPServiceObserver o()
  {
    return new GuildFacadeTopFrameController.2(this);
  }
  
  private void p()
  {
    q();
  }
  
  private void q()
  {
    GuildMainSettingDialogFragment localGuildMainSettingDialogFragment = this.g;
    if (localGuildMainSettingDialogFragment != null) {
      localGuildMainSettingDialogFragment.dismiss();
    }
    this.g = new GuildMainSettingDialogFragment(this.c.a(), i());
    this.g.show(this.c.g(), "GuildMainSettingDialogFragment");
  }
  
  private void r()
  {
    QQGuildJumpSource.a(1);
    ((IQQGuildService)this.c.a().getRuntimeService(IQQGuildService.class, "")).addGuildAndJump2AIO(this.c.b(), this.b.b, this.b.c.b, this.b.c.a, this.b.c.c, this.b.c.d);
  }
  
  private void s()
  {
    if (i() == null) {
      return;
    }
    VideoReport.addToDetectionWhitelist(this.c.b());
    VideoReport.setPageId(this.e, "pg_sgrp_channel");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.e, i().getGuildID(), null);
  }
  
  private void t()
  {
    QQGuildUtil.a(this.i.findViewById(2131435696), "em_sgrp_setting", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    QQGuildUtil.a(this.h.findViewById(2131430163), "em_sgrp_cover_join", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    QQGuildUtil.a(this.f, "em_sgrp_cover", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    HashMap localHashMap = new HashMap();
    int m;
    if (TextUtils.isEmpty(k())) {
      m = 1;
    } else {
      m = 2;
    }
    localHashMap.put("sgrp_cover", Integer.valueOf(m));
    VideoReport.reportEvent("imp", this.f, localHashMap);
  }
  
  public void a()
  {
    super.a();
    this.i = new ChannelTitleLayout(this.c.b(), this);
    this.h = new GuildChannelListHeadView(this.c.b());
    this.h.findViewById(2131430163).setOnClickListener(this);
    this.h.setSiblingLayout(this.f);
    f();
    m();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOverScroll offset:");
      localStringBuilder.append(paramInt2);
      QLog.d("GuildFacadeTopFrameController", 2, localStringBuilder.toString());
    }
    b(paramInt1, paramInt2, c().getHeight());
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("GuildFacadeTopFrameController", 2, String.format("listView scroll firstVisibleItem:%d, offset:%d, itemHeight:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(FacadeArgsData paramFacadeArgsData)
  {
    super.a(paramFacadeArgsData);
    f();
  }
  
  public void b()
  {
    super.b();
    n();
  }
  
  public ViewGroup c()
  {
    return this.h;
  }
  
  public void d()
  {
    e();
  }
  
  public void e()
  {
    PopupWindow localPopupWindow = this.k;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
  }
  
  public boolean h()
  {
    GuildMainSettingDialogFragment localGuildMainSettingDialogFragment = this.g;
    if (localGuildMainSettingDialogFragment != null)
    {
      localGuildMainSettingDialogFragment.dismiss();
      this.g = null;
      return true;
    }
    return super.h();
  }
  
  public void onClick(View paramView)
  {
    if (!QQGuildUIUtil.a())
    {
      int m = paramView.getId();
      if (m == 2131435696)
      {
        p();
        VideoReport.reportEvent("clck", paramView, null);
      }
      else if (m == 2131430163)
      {
        r();
        VideoReport.reportEvent("clck", paramView, null);
      }
      else if (m == 2131434692)
      {
        if (this.k == null) {
          this.k = a(paramView.getContext(), true);
        }
        if (!this.k.isShowing())
        {
          j();
          paramView.postDelayed(this.l, 3000L);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.facade.GuildFacadeTopFrameController
 * JD-Core Version:    0.7.0.1
 */