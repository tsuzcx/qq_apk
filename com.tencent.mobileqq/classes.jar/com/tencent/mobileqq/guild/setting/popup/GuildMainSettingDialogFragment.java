package com.tencent.mobileqq.guild.setting.popup;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.api.IQQGuildJubaoApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.mobileqq.guild.data.QQGuildDTConstant;
import com.tencent.mobileqq.guild.setting.QQGuildMemberFragment;
import com.tencent.mobileqq.guild.share.GuildShareActionSheet;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GuildMainSettingDialogFragment
  extends BottomSheetDialogFragment
  implements View.OnClickListener
{
  private boolean A;
  private String B;
  private String C;
  private String D = "";
  private String E;
  private String F = "";
  private View G;
  private AppRuntime H;
  private IGProGuildInfo I;
  private GuildMainSettingViewModel J;
  private PopupWindow K;
  private GuildMedalBubbleLayout L;
  private Observer M = new GuildMainSettingDialogFragment.1(this);
  private final Runnable N = new GuildMainSettingDialogFragment.6(this);
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private ImageView g;
  private TextView h;
  private RelativeLayout i;
  private RelativeLayout j;
  private RelativeLayout k;
  private RelativeLayout l;
  private RelativeLayout m;
  private RelativeLayout n;
  private RelativeLayout o;
  private RelativeLayout p;
  private ActionSheet q;
  private RoundImageView r;
  private ImageView s;
  private FrameLayout t;
  private View u;
  private View v;
  private View w;
  private ViewGroup x;
  private ViewGroup y;
  private NestedScrollView z;
  
  public GuildMainSettingDialogFragment(AppRuntime paramAppRuntime, IGProGuildInfo paramIGProGuildInfo)
  {
    this.H = paramAppRuntime;
    this.I = paramIGProGuildInfo;
  }
  
  private void A()
  {
    VideoReport.setElementId(this.b, "em_sgrp_member");
    VideoReport.setElementExposePolicy(this.b, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this.b, ClickPolicy.REPORT_ALL);
    VideoReport.reportEvent("clck", this.b, null);
    VideoReport.setElementId(this.k, "em_sgrp_set_profile");
    VideoReport.setElementExposePolicy(this.k, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this.k, ClickPolicy.REPORT_ALL);
    VideoReport.reportEvent("clck", this.k, null);
    VideoReport.setElementId(this.c, "em_sgrp_set_share");
    VideoReport.setElementExposePolicy(this.c, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this.c, ClickPolicy.REPORT_ALL);
    VideoReport.reportEvent("clck", this.c, null);
    VideoReport.setElementId(this.a, "em_sgrp_set_copy_group_num");
    VideoReport.setElementExposePolicy(this.a, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this.a, ClickPolicy.REPORT_ALL);
    VideoReport.reportEvent("clck", this.a, null);
    VideoReport.setElementId(this.u, "em_sgrp_set_quit");
    VideoReport.setElementExposePolicy(this.u, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(this.u, ClickPolicy.REPORT_ALL);
    VideoReport.reportEvent("clck", this.u, null);
    VideoReport.setElementId(this.m, "em_sgrp_set_bots");
    VideoReport.setElementExposePolicy(this.m, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this.m, ClickPolicy.REPORT_ALL);
    VideoReport.reportEvent("clck", this.m, null);
    VideoReport.setElementId(this.n, "em_sgrp_databorad");
    VideoReport.setElementExposePolicy(this.n, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this.n, ClickPolicy.REPORT_ALL);
    VideoReport.reportEvent("clck", this.n, null);
    VideoReport.setElementId(this.o, "em_sgrp_show_otherapp_identity");
    VideoReport.setElementExposePolicy(this.o, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(this.o, ClickPolicy.REPORT_ALL);
  }
  
  private void B()
  {
    if (QQGuildUtil.b())
    {
      this.m.setVisibility(0);
      return;
    }
    this.m.setVisibility(8);
    this.l.setBackgroundDrawable(this.m.getBackground());
  }
  
  private static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 0) {
      return 3;
    }
    if (paramInt == 2) {
      return 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IGuildUserType is in invalid value: ");
      localStringBuilder.append(paramInt);
      QLog.e("GuildMainSettingDialogFragment", 2, localStringBuilder.toString());
    }
    return 4;
  }
  
  private PopupWindow a(Context paramContext, boolean paramBoolean)
  {
    PopupWindow localPopupWindow = new PopupWindow(-2, -2);
    this.L = new GuildMedalBubbleLayout(paramContext, paramBoolean);
    localPopupWindow.setContentView(this.L);
    return localPopupWindow;
  }
  
  private void a()
  {
    this.v = this.G.findViewById(2131434604);
    this.w = this.G.findViewById(2131434620);
    this.r = ((RoundImageView)this.G.findViewById(2131434614));
    this.s = ((ImageView)this.G.findViewById(2131434616));
    this.t = ((FrameLayout)this.G.findViewById(2131434603));
    this.z = ((NestedScrollView)this.G.findViewById(2131434731));
    this.x = ((ViewGroup)this.G.findViewById(2131434679));
    this.y = ((ViewGroup)this.G.findViewById(2131434687));
    if (getContext() == null)
    {
      QLog.w("GuildMainSettingDialogFragment", 2, "context is null");
      dismiss();
      return;
    }
    if (this.I == null)
    {
      QLog.w("GuildMainSettingDialogFragment", 2, "IGProGuildInfo is null");
      dismiss();
      return;
    }
    int i1 = f();
    Object localObject = this.I;
    this.E = ((IGProGuildInfo)localObject).getAvatarUrl(140);
    this.F = QQGuildUtil.a(this.I.getMedalLevel());
    a(this.s, this.E, i1, i1, null);
    g();
    this.f = ((TextView)this.G.findViewById(2131434747));
    a(this.f, ((IGProGuildInfo)localObject).getGuildName());
    int i2;
    if (this.I.getMedalLevel() != 0)
    {
      i1 = ImmersiveUtils.getScreenWidth();
      i2 = Utils.a(68.0F, getResources());
      this.f.setMaxWidth(i1 - i2);
    }
    else
    {
      i1 = ImmersiveUtils.getScreenWidth();
      i2 = Utils.a(40.0F, getResources());
      this.f.setMaxWidth(i1 - i2);
    }
    this.g = ((ImageView)this.G.findViewById(2131434692));
    this.g.setOnClickListener(this);
    QQGuildUtil.a(this.g, this.F);
    this.a = ((TextView)this.G.findViewById(2131434748));
    this.a.setOnClickListener(this);
    a(this.a, getResources().getString(2131890586, new Object[] { ((IGProGuildInfo)localObject).getShowNumber() }));
    this.i = ((RelativeLayout)this.G.findViewById(2131434717));
    this.e = ((TextView)this.G.findViewById(2131434755));
    this.i.setOnClickListener(this);
    this.j = ((RelativeLayout)this.G.findViewById(2131434695));
    this.j.setOnClickListener(this);
    this.h = ((TextView)this.G.findViewById(2131434749));
    if (!TextUtils.isEmpty(((IGProGuildInfo)localObject).getProfile())) {
      this.h.setText(((IGuildEmotionCodecApi)QRoute.api(IGuildEmotionCodecApi.class)).toQQText(((IGProGuildInfo)localObject).getProfile(), 20));
    } else {
      this.h.setVisibility(8);
    }
    this.b = ((TextView)this.G.findViewById(2131434752));
    this.b.setOnClickListener(this);
    this.c = ((TextView)this.G.findViewById(2131434761));
    this.c.setOnClickListener(this);
    this.k = ((RelativeLayout)this.G.findViewById(2131434718));
    this.k.setOnClickListener(this);
    this.l = ((RelativeLayout)this.G.findViewById(2131434715));
    this.l.setOnClickListener(this);
    this.m = ((RelativeLayout)this.G.findViewById(2131434721));
    this.m.setOnClickListener(this);
    this.n = ((RelativeLayout)this.G.findViewById(2131434730));
    this.n.setOnClickListener(this);
    this.o = ((RelativeLayout)this.G.findViewById(2131430788));
    this.o.setOnClickListener(this);
    this.p = ((RelativeLayout)this.G.findViewById(2131434714));
    this.p.setOnClickListener(this);
    this.d = ((TextView)this.G.findViewById(2131434760));
    this.d.setOnClickListener(this);
    View localView = this.G.findViewById(2131434682);
    this.u = this.G.findViewById(2131434678);
    TextView localTextView = (TextView)this.G.findViewById(2131434742);
    this.u.setOnClickListener(this);
    i1 = ((IGProGuildInfo)localObject).getUserType();
    if (2 == i1)
    {
      localTextView.setText(getResources().getString(2131890576));
      this.d.setVisibility(8);
      this.n.setVisibility(0);
      B();
      this.p.setVisibility(0);
    }
    else if (1 == i1)
    {
      localTextView.setText(getResources().getString(2131890577));
      this.d.setVisibility(0);
      this.n.setVisibility(0);
      B();
      this.p.setVisibility(0);
    }
    else
    {
      localTextView.setText(getResources().getString(2131890577));
      this.d.setVisibility(0);
      this.n.setVisibility(8);
      localView.setVisibility(8);
    }
    localObject = ((IGuildAdapterService)this.H.getRuntimeService(IGuildAdapterService.class, "")).getChannelList(this.I.getGuildID(), true);
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      this.d.setVisibility(8);
    }
    QQGuildUIUtil.a(2130841028, 2130841018, 2130841004, 2130841021, (ViewGroup)localView);
  }
  
  private void a(Context paramContext, Intent paramIntent, String paramString)
  {
    paramContext = new ActivityURIRequest(paramContext, paramString);
    paramContext.extra().putAll(paramIntent.getExtras());
    paramContext.setFlags(paramIntent.getFlags());
    QRoute.startUri(paramContext, null);
  }
  
  private void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramImageView.setVisibility(8);
      return;
    }
    paramImageView.setVisibility(0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = BaseImageUtil.j();
    }
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mRequestWidth = paramInt1;
    localURLDrawableOptions.mRequestHeight = paramInt2;
    paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
    paramTextView.setHint(null);
    paramTextView.setText(paramString);
  }
  
  private void a(String paramString)
  {
    this.C = paramString;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bgUrl is ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("GuildMainSettingDialogFragment", 1, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.C))
    {
      QLog.d("GuildMainSettingDialogFragment", 2, "bgUrl is null.");
      this.r.setVisibility(8);
      this.v.setVisibility(0);
      this.w.setVisibility(8);
      i();
      return;
    }
    this.v.setVisibility(8);
    this.w.setVisibility(0);
    paramString = (ViewGroup.MarginLayoutParams)this.r.getLayoutParams();
    paramString.topMargin = 0;
    this.r.setLayoutParams(paramString);
    paramString = (ViewGroup.MarginLayoutParams)this.z.getLayoutParams();
    paramString.topMargin = 0;
    this.z.setLayoutParams(paramString);
    this.y.setBackgroundDrawable(this.x.getBackground());
    paramString = new GradientDrawable();
    paramString.setColor(getResources().getColor(2131168376));
    Object localObject = this.r;
    a((ImageView)localObject, this.C, ((RoundImageView)localObject).getMeasuredWidth(), this.r.getMeasuredHeight(), paramString);
  }
  
  private void b()
  {
    z();
    A();
    d(((IGPSService)this.H.getRuntimeService(IGPSService.class, "")).getSelfGuildMemberName(this.I.getGuildID()));
  }
  
  private boolean b(String paramString)
  {
    Iterator localIterator = ((IGPSService)this.H.getRuntimeService(IGPSService.class, "")).getGuildList().iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(((IGProGuildInfo)localIterator.next()).getGuildID(), paramString)) {
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    this.J = ((GuildMainSettingViewModel)GuildMainSettingViewModel.a.create(GuildMainSettingViewModel.class));
    this.J.a(this.H, this.I);
    this.J.c().observe(this, new GuildMainSettingDialogFragment.3(this));
    this.J.e().observe(this, new GuildMainSettingDialogFragment.4(this));
    this.J.d().observe(this, new GuildMainSettingDialogFragment.5(this));
  }
  
  private void c(String paramString)
  {
    if (paramString == null)
    {
      QLog.w("GuildMainSettingDialogFragment", 2, "strContent is null.");
      return;
    }
    try
    {
      MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
      if (localMobileQQ == null)
      {
        QLog.w("GuildMainSettingDialogFragment", 2, "context is null.");
        return;
      }
      ClipboardManager localClipboardManager = (ClipboardManager)localMobileQQ.getSystemService("clipboard");
      paramString = ClipData.newPlainText(null, paramString);
      ClipboardMonitor.setPrimaryClip(localClipboardManager, paramString);
      localClipboardManager.setPrimaryClip(paramString);
      QQToast.makeText(localMobileQQ, 2131911997, 0).show();
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("GuildMainSettingDialogFragment", 2, "copyContent fail.", paramString);
    }
  }
  
  private void d()
  {
    this.K.getContentView().measure(0, 0);
    int i1 = this.g.getWidth() / 2;
    int i2 = this.K.getContentView().getMeasuredWidth() / 2;
    int i3 = this.g.getHeight();
    int i4 = this.K.getContentView().getMeasuredHeight();
    int i5 = Utils.a(4.0F, getResources());
    this.K.showAsDropDown(this.g, i1 - i2, -(i3 + i4 - i5));
  }
  
  private void d(String paramString)
  {
    this.D = paramString;
    if (TextUtils.isEmpty(this.D))
    {
      this.e.setText(2131890573);
      return;
    }
    this.e.setText(this.D);
  }
  
  private void e()
  {
    PopupWindow localPopupWindow = this.K;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
  }
  
  private int f()
  {
    return Utils.a(70.0F, getResources());
  }
  
  private void g()
  {
    a(h());
  }
  
  private String h()
  {
    return this.I.getCoverUrl(ImmersiveUtils.getScreenWidth(), Utils.a(213.5F, getResources()));
  }
  
  private void i()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.t.getLayoutParams();
    localMarginLayoutParams.topMargin = 0;
    this.t.setLayoutParams(localMarginLayoutParams);
    this.z.bringToFront();
  }
  
  private void j()
  {
    if (this.I == null)
    {
      QLog.w("GuildMainSettingDialogFragment", 2, "mGuildInfo is null.");
      return;
    }
    this.J.a();
  }
  
  private void k()
  {
    if (this.I == null)
    {
      QLog.w("GuildMainSettingDialogFragment", 2, "mGuildInfo is null.");
      return;
    }
    this.J.b();
  }
  
  private void l()
  {
    List localList = ((IGuildAdapterService)this.H.getRuntimeService(IGuildAdapterService.class, "")).getChannelList(this.I.getGuildID(), true);
    if ((TextUtils.isEmpty(this.B)) && (localList != null))
    {
      if (localList.isEmpty()) {
        return;
      }
      this.B = ((IGProChannelInfo)localList.get(0)).getChannelUin();
    }
  }
  
  private void m()
  {
    if (this.I == null)
    {
      QLog.w("GuildMainSettingDialogFragment", 2, "mGuildInfo is null.");
      return;
    }
    l();
    ((IQQGuildJubaoApi)QRoute.api(IQQGuildJubaoApi.class)).reportGuild((QBaseActivity)getContext(), this.I.getGuildID(), this.B, 25086, true);
  }
  
  private void n()
  {
    if (this.I == null)
    {
      QLog.w("GuildMainSettingDialogFragment", 2, "mGuildInfo is null.");
      return;
    }
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildInfoSetting(getContext(), this.I);
  }
  
  private void o()
  {
    if (this.I == null)
    {
      QLog.e("GuildMainSettingDialogFragment", 2, "error guildInfo is null");
      QQToast.makeText(getContext(), 1, getResources().getString(2131889041), 1).show();
      return;
    }
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildChannelListSetting(getContext(), String.valueOf(this.I.getGuildID()));
  }
  
  private void p()
  {
    if (this.I == null)
    {
      QLog.w("GuildMainSettingDialogFragment", 2, "mGuildInfo is null.");
      return;
    }
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openRobotList(getActivity(), this.I.getGuildID());
  }
  
  private void q()
  {
    if (this.I == null)
    {
      QLog.w("GuildMainSettingDialogFragment", 2, "mGuildInfo is null.");
      return;
    }
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null)
    {
      QLog.w("GuildMainSettingDialogFragment", 2, "activity is null");
      return;
    }
    for (;;)
    {
      try
      {
        if (b(this.I.getGuildID()))
        {
          i1 = a(this.I.getUserType());
          localObject1 = URLEncoder.encode(this.I.getGuildID(), "utf-8");
          Object localObject2 = URLEncoder.encode(this.I.getGuildName(), "utf-8");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("https://qun.qq.com/qqweb/manager/qunpro/activedata/active?_wv=3&_wwv=128&channel=");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("&channelName=");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("&userType=");
          localStringBuilder.append(i1);
          localObject1 = localStringBuilder.toString();
          if (QLog.isColorLevel()) {
            QLog.i("GuildMainSettingDialogFragment", 2, (String)localObject1);
          }
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("finish_animation_up_down_guild", true);
          a(getActivity(), (Intent)localObject2, "/base/browser");
          localFragmentActivity.overridePendingTransition(2130772133, 2130772007);
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("encode not support:");
          ((StringBuilder)localObject1).append(localUnsupportedEncodingException);
          QLog.e("GuildMainSettingDialogFragment", 1, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      int i1 = 4;
    }
  }
  
  private void r()
  {
    if (this.I == null)
    {
      QLog.w("GuildMainSettingDialogFragment", 2, "mGuildInfo is null.");
      return;
    }
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildNicknameSetting(getContext(), this.I.getGuildID(), this.D);
  }
  
  private void s()
  {
    if (this.I == null)
    {
      QLog.w("GuildMainSettingDialogFragment", 2, "mGuildInfo is null.");
      return;
    }
    if (QQGuildUIUtil.a()) {
      return;
    }
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildThirdAppSetting(getContext(), this.I.getGuildID());
  }
  
  private void t()
  {
    if (this.I == null)
    {
      QLog.i("GuildMainSettingDialogFragment", 2, "mGuildInfo is null.");
      return;
    }
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildMsgNotifySetting(getContext(), this.I.getGuildID());
  }
  
  private void u()
  {
    Intent localIntent = QQGuildMemberFragment.a(this.I);
    localIntent.putExtra("extra_channel_id", "");
    QPublicFragmentActivity.Launcher.a(getContext(), localIntent, QPublicFragmentActivity.class, QQGuildMemberFragment.class);
  }
  
  private void v()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null)
    {
      QLog.w("GuildMainSettingDialogFragment", 2, "activity is null.");
      return;
    }
    new GuildShareActionSheet(localFragmentActivity, this.I, null).a();
  }
  
  private void w()
  {
    if (this.I == null)
    {
      QLog.i("GuildMainSettingDialogFragment", 2, "mData is null.");
      return;
    }
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildJoinSetting(getContext(), this.I.getGuildID());
  }
  
  private void x()
  {
    if (this.q == null)
    {
      boolean bool;
      if (this.I.getUserType() == 2) {
        bool = true;
      } else {
        bool = false;
      }
      int i1;
      if (bool) {
        i1 = 2131888468;
      } else {
        i1 = 2131889063;
      }
      int i2;
      if (bool) {
        i2 = 2131888767;
      } else {
        i2 = 2131889053;
      }
      this.q = ActionSheet.create(getContext());
      this.q.setMainTitle(i1);
      this.q.addButton(i2, 3, 2131434725);
      this.q.setOnButtonClickListener(new GuildMainSettingDialogFragment.7(this, bool));
      this.q.addCancelButton(getResources().getString(2131887648));
    }
    this.q.show();
    if (!this.A)
    {
      y();
      this.A = true;
    }
  }
  
  private void y()
  {
    Object localObject2 = getActivity();
    Object localObject1 = Integer.valueOf(2);
    if (localObject2 == null)
    {
      QLog.w("GuildMainSettingDialogFragment", 2, "activity is null.");
      return;
    }
    VideoReport.addToDetectionWhitelist((Activity)localObject2);
    VideoReport.setPageId(this.q.getRootView(), "pg_sgrp_set");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.q.getRootView(), this.I.getGuildID(), null);
    localObject2 = this.q.findViewById(2131427548);
    VideoReport.setElementId(localObject2, "em_sgrp_set_confirm");
    VideoReport.setElementExposePolicy(localObject2, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(localObject2, ClickPolicy.REPORT_ALL);
    HashMap localHashMap = new HashMap();
    localHashMap.put("quit_result", localObject1);
    localHashMap.put("pgid", "pg_sgrp_set");
    VideoReport.setElementParam(localObject2, "quit_result", localObject1);
    VideoReport.reportEvent("clck", localObject2, localHashMap);
    localObject1 = this.q.findViewById(2131434725);
    VideoReport.setElementId(localObject1, "em_sgrp_set_confirm");
    VideoReport.setElementExposePolicy(localObject1, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(localObject1, ClickPolicy.REPORT_ALL);
    VideoReport.setElementParam(localObject1, "quit_result", Integer.valueOf(1));
    localObject2 = new HashMap();
    ((Map)localObject2).put("quit_result", Integer.valueOf(1));
    ((Map)localObject2).put("pgid", "pg_sgrp_set");
    VideoReport.reportEvent("clck", localObject1, (Map)localObject2);
  }
  
  private void z()
  {
    VideoReport.setPageId(this.G, "pg_sgrp_set");
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "0S200MNJT807V3GE");
    localHashMap.put("sgrp_channel_id", this.I.getGuildID());
    localHashMap.put("sgrp_user_type", Integer.valueOf(QQGuildDTConstant.a(this.I.getUserType())));
    VideoReport.reportEvent("pgin", this.G, localHashMap);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131434752)
    {
      dismiss();
      u();
    }
    else if (i1 == 2131434761)
    {
      dismiss();
      v();
    }
    else if (i1 == 2131434718)
    {
      dismiss();
      n();
    }
    else if (i1 == 2131434715)
    {
      dismiss();
      o();
    }
    else if (i1 == 2131434678)
    {
      x();
    }
    else if (i1 == 2131434760)
    {
      m();
      dismiss();
    }
    else if (i1 == 2131434721)
    {
      dismiss();
      p();
    }
    else if (i1 == 2131434730)
    {
      dismiss();
      q();
    }
    else if (i1 == 2131434748)
    {
      c(this.I.getShowNumber());
    }
    else if (i1 == 2131434717)
    {
      dismiss();
      r();
    }
    else if (i1 == 2131434714)
    {
      dismiss();
      w();
    }
    else if (i1 == 2131434695)
    {
      dismiss();
      t();
    }
    else if (i1 == 2131430788)
    {
      dismiss();
      s();
    }
    else if (i1 == 2131434692)
    {
      if (this.K == null) {
        this.K = a(getContext(), false);
      }
      if (!this.K.isShowing())
      {
        d();
        paramView.postDelayed(this.N, 3000L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.G = paramLayoutInflater.inflate(2131625125, paramViewGroup);
    a();
    AudioRoomLiveData.a.a().observe(getViewLifecycleOwner(), this.M);
    paramLayoutInflater = this.G;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    e();
    this.H = null;
    this.G = null;
  }
  
  public void onDismiss(@NonNull DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    AudioRoomLiveData.a.a().removeObserver(this.M);
  }
  
  public void onResume()
  {
    super.onResume();
    ((ViewGroup)this.G.getParent()).setBackgroundColor(0);
    ((BottomSheetDialog)getDialog()).a().b(new GuildMainSettingDialogFragment.2(this));
  }
  
  public void onStart()
  {
    super.onStart();
    b();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.popup.GuildMainSettingDialogFragment
 * JD-Core Version:    0.7.0.1
 */