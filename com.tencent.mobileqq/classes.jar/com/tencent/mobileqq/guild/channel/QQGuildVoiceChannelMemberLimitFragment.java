package com.tencent.mobileqq.guild.channel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.config.QQGuildConfigBean;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;

public class QQGuildVoiceChannelMemberLimitFragment
  extends QQGuildTitleBarFragment
{
  private IGProChannelInfo o;
  private EditText p;
  private View q;
  private TextView r;
  private int s;
  private String t = "99";
  private GPServiceObserver u = new QQGuildVoiceChannelMemberLimitFragment.6(this);
  
  public static void a(Context paramContext, IGProChannelInfo paramIGProChannelInfo)
  {
    if ((paramContext != null) && (paramIGProChannelInfo != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_guild_channel_info", paramIGProChannelInfo);
      QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, QQGuildVoiceChannelMemberLimitFragment.class);
      return;
    }
    QLog.e("QQGuildVoiceChannelMemberLimitFragment", 1, "open, invalid param");
  }
  
  private void a(String paramString)
  {
    QBaseActivity localQBaseActivity;
    if (!TextUtils.isEmpty(paramString)) {
      localQBaseActivity = getQBaseActivity();
    }
    try
    {
      int i = Integer.parseInt(paramString);
      if (i > 0)
      {
        ((IGPSService)l().getRuntimeService(IGPSService.class, "")).setAudioChannelUserLimit(this.o.getGuildId(), this.o.getChannelUin(), i, new QQGuildVoiceChannelMemberLimitFragment.5(this, localQBaseActivity));
        return;
      }
      this.p.setText(this.t);
      QQToast.makeText(localQBaseActivity, 1, "人数上限不可少于1人", 0).show();
      return;
    }
    catch (Exception paramString)
    {
      label93:
      break label93;
    }
    QQToast.makeText(localQBaseActivity, 1, "人数上限不符合规范", 0).show();
  }
  
  private int i()
  {
    return QQGuildUtil.c().h;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.o = ((IGProChannelInfo)getActivity().getIntent().getSerializableExtra("extra_guild_channel_info"));
    this.p = ((EditText)this.l.findViewById(2131435824));
    this.q = this.l.findViewById(2131434734);
    this.r = ((TextView)this.l.findViewById(2131447419));
    int j = i();
    int i = 1;
    if (j > 0)
    {
      this.t = String.valueOf(j);
      this.r.setVisibility(0);
      this.r.setText(getString(2131890497, new Object[] { this.t }));
    }
    else
    {
      this.r.setVisibility(8);
    }
    this.q.setOnClickListener(new QQGuildVoiceChannelMemberLimitFragment.1(this));
    a(2131887648, new QQGuildVoiceChannelMemberLimitFragment.2(this));
    a(getResources().getString(2131890632));
    b(2131888784, new QQGuildVoiceChannelMemberLimitFragment.3(this));
    this.p.setFocusable(true);
    this.p.setFocusableInTouchMode(true);
    this.p.requestFocus();
    paramLayoutInflater = String.valueOf(this.o.getChannelMemberMax());
    this.p.setText(paramLayoutInflater);
    this.p.setSelection(paramLayoutInflater.length());
    this.p.postDelayed(new QQGuildVoiceChannelMemberLimitFragment.4(this), 200L);
    if (this.o != null)
    {
      paramLayoutInflater = (IGPSService)l().getRuntimeService(IGPSService.class, "");
      paramViewGroup = paramLayoutInflater.getAudioChannelSimpleInfo(this.o.getChannelUin());
      if (paramViewGroup != null) {
        this.s = paramViewGroup.c();
      }
      paramLayoutInflater.tryRrefreshAllAudioChannelSimpleInfo(this.o.getGuildId(), true);
    }
    VideoReport.setPageId(this.l, "pg_sgrp_channel_set");
    paramLayoutInflater = new HashMap();
    if (this.o.getType() == 2) {
      i = 2;
    }
    paramLayoutInflater.put("sgrp_sub_channel_type", Integer.valueOf(i));
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(this.l, this.o, paramLayoutInflater);
    VideoReport.setElementId(this.p, "em_sgrp_voicechannel_set_maxmember");
    VideoReport.setElementExposePolicy(this.p, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(this.p, ClickPolicy.REPORT_NONE);
  }
  
  protected int b()
  {
    return 2131625019;
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).addObserver(this.u);
  }
  
  public void onDetach()
  {
    super.onDetach();
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).deleteObserver(this.u);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildVoiceChannelMemberLimitFragment
 * JD-Core Version:    0.7.0.1
 */