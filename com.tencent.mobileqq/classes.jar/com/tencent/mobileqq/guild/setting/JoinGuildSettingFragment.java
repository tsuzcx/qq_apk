package com.tencent.mobileqq.guild.setting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class JoinGuildSettingFragment
  extends QQGuildTitleBarFragment
  implements View.OnClickListener
{
  private ImageView o;
  private ImageView p;
  private ImageView q;
  private ImageView r;
  private ImageView s;
  private FrameLayout t;
  private FrameLayout u;
  private FrameLayout v;
  private CharacterCountEditText w;
  private CharacterCountEditText x;
  private CharacterCountEditText y;
  private JoinGuildSettingViewModel z;
  
  public static Intent a(String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_id", paramString);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.o;
    int j = 0;
    int i;
    if (paramInt == 1) {
      i = 0;
    } else {
      i = 8;
    }
    ((ImageView)localObject).setVisibility(i);
    localObject = this.p;
    if (paramInt == 2) {
      i = 0;
    } else {
      i = 8;
    }
    ((ImageView)localObject).setVisibility(i);
    localObject = this.q;
    if (paramInt == 5) {
      i = 0;
    } else {
      i = 8;
    }
    ((ImageView)localObject).setVisibility(i);
    localObject = this.r;
    if (paramInt == 4) {
      i = 0;
    } else {
      i = 8;
    }
    ((ImageView)localObject).setVisibility(i);
    localObject = this.s;
    if (paramInt == 3) {
      i = 0;
    } else {
      i = 8;
    }
    ((ImageView)localObject).setVisibility(i);
    localObject = this.t;
    if (paramInt == 5) {
      i = 0;
    } else {
      i = 8;
    }
    ((FrameLayout)localObject).setVisibility(i);
    localObject = this.u;
    if (paramInt == 4) {
      i = 0;
    } else {
      i = 8;
    }
    ((FrameLayout)localObject).setVisibility(i);
    localObject = this.v;
    if (paramInt == 4) {
      i = j;
    } else {
      i = 8;
    }
    ((FrameLayout)localObject).setVisibility(i);
    c(paramInt);
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 5)
    {
      InputMethodUtil.a(this.t);
      return;
    }
    if (paramInt == 4) {
      InputMethodUtil.a(this.u);
    }
  }
  
  private void d(int paramInt)
  {
    if (paramInt == 5)
    {
      this.w.setFocusable(true);
      this.w.setFocusableInTouchMode(true);
      this.w.requestFocus();
      InputMethodUtil.a(this.w);
      return;
    }
    if (paramInt == 4)
    {
      this.x.setFocusable(true);
      this.x.setFocusableInTouchMode(true);
      this.x.requestFocus();
      InputMethodUtil.a(this.x);
    }
  }
  
  private void i()
  {
    this.c.setText(getString(2131890580));
    this.d.setText(2131890588);
    this.d.setTextColor(getResources().getColorStateList(2131166263));
    this.d.setVisibility(0);
    this.d.setOnClickListener(this);
    this.d.setEnabled(false);
  }
  
  @SuppressLint({"NewApi"})
  private void j()
  {
    k();
    this.t = ((FrameLayout)this.l.findViewById(2131428400));
    this.u = ((FrameLayout)this.l.findViewById(2131428931));
    this.v = ((FrameLayout)this.l.findViewById(2131428929));
    this.o = ((ImageView)this.l.findViewById(2131436255));
    this.p = ((ImageView)this.l.findViewById(2131436649));
    this.q = ((ImageView)this.l.findViewById(2131436256));
    this.r = ((ImageView)this.l.findViewById(2131436257));
    this.s = ((ImageView)this.l.findViewById(2131436477));
    this.w = ((CharacterCountEditText)this.l.findViewById(2131428399));
    this.w.setLimitCount(30);
    this.x = ((CharacterCountEditText)this.l.findViewById(2131428930));
    this.x.setLimitCount(30);
    this.y = ((CharacterCountEditText)this.l.findViewById(2131428928));
    this.y.setLimitCount(30);
    this.w.addTextChangedListener(new JoinGuildSettingFragment.1(this));
    this.x.addTextChangedListener(new JoinGuildSettingFragment.2(this));
    this.y.addTextChangedListener(new JoinGuildSettingFragment.3(this));
  }
  
  private void k()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.l.findViewById(2131434712);
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setTag(Integer.valueOf(1));
    localRelativeLayout = (RelativeLayout)this.l.findViewById(2131434720);
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setTag(Integer.valueOf(2));
    localRelativeLayout = (RelativeLayout)this.l.findViewById(2131428401);
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setTag(Integer.valueOf(5));
    localRelativeLayout = (RelativeLayout)this.l.findViewById(2131428398);
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setTag(Integer.valueOf(4));
    localRelativeLayout = (RelativeLayout)this.l.findViewById(2131434719);
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setTag(Integer.valueOf(3));
  }
  
  private void m()
  {
    String str = getActivity().getIntent().getStringExtra("extra_guild_id");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initViewModel get guildId is ");
      localStringBuilder.append(str);
      QLog.d("QQGuildCustomTitleBarFragment", 1, localStringBuilder.toString());
    }
    this.z = ((JoinGuildSettingViewModel)ViewModelProviderHelper.a(this, JoinGuildSettingViewModel.a).get(JoinGuildSettingViewModel.class));
    this.z.a(l(), str);
    n();
  }
  
  private void n()
  {
    this.z.c().observe(this, new JoinGuildSettingFragment.4(this));
    this.z.d().observe(this, new JoinGuildSettingFragment.5(this));
    this.z.b().observe(this, new JoinGuildSettingFragment.6(this));
    this.z.e().observe(this, new JoinGuildSettingFragment.7(this));
    this.z.a().observe(this, new JoinGuildSettingFragment.8(this));
  }
  
  private void o()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(this.l.getWindowToken(), 0);
    }
  }
  
  private void p()
  {
    String str = getActivity().getIntent().getStringExtra("extra_guild_id");
    ((IGPSService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).getGuildInfo(str);
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.l.getRootView(), "pg_sgrp_auditset");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.l.getRootView(), str, null);
  }
  
  private void q()
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.g, "em_sgrp_auditset_back", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.d, "em_sgrp_auditset_done", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.l.findViewById(2131434712), "em_sgrp_auditset_everyone", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.l.findViewById(2131434720), "em_sgrp_auditset_sendmessageandaudit", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.l.findViewById(2131428401), "em_sgrp_auditset_answerquestionandaudit", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.l.findViewById(2131428398), "em_sgrp_auditset_correctanswerandpass", null);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.l.findViewById(2131434719), "em_sgrp_auditset_refuse", null);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    i();
    j();
    m();
    p();
    q();
  }
  
  protected int b()
  {
    return 2131625047;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.d)
    {
      if (this.z.b().getValue() != null)
      {
        int i = ((Integer)this.z.b().getValue()).intValue();
        if (i == 4) {
          this.z.a(4, this.x.getText().toString(), this.y.getText().toString());
        } else if (i == 5) {
          this.z.a(5, this.w.getText().toString(), "");
        } else {
          this.z.a(i, "", "");
        }
      }
    }
    else
    {
      this.z.a(((Integer)paramView.getTag()).intValue(), this.w.getText().toString(), this.x.getText().toString(), this.y.getText().toString());
      d(((Integer)paramView.getTag()).intValue());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.JoinGuildSettingFragment
 * JD-Core Version:    0.7.0.1
 */