package com.tencent.mobileqq.guild.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.util.QQGuildTextUtils.CharacterCountInfo;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText.ITextEditEventListener;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.InputMethodUtil;
import java.util.Locale;

public class QQGuildNicknameSettingFragment
  extends QQGuildTitleBarFragment
  implements CharacterCountEditText.ITextEditEventListener
{
  protected CharacterCountEditText o;
  protected TextView p;
  private ImageView q;
  private String r;
  private String s;
  
  private void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      QQGuildUtil.c(getContext(), "修改成功");
      paramString = new Intent();
      paramString.putExtra("guild_nickname", this.s);
      getActivity().setResult(-1, paramString);
      getActivity().finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildNicknameSettingFragment", 2, String.format("set guildMemberName failed: %s", new Object[] { paramString }));
    }
    QQGuildUtil.a(getContext(), paramInt, "提交失败，请稍后重试", paramIGProSecurityResult);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("guild_id", paramString1);
    localBundle.putString("guild_nickname", paramString2);
    localIntent.putExtras(localBundle);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, QQGuildNicknameSettingFragment.class, 255);
  }
  
  private void a(String paramString)
  {
    this.s = paramString;
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).setGuildMemberName(this.r, paramString, new QQGuildNicknameSettingFragment.3(this));
  }
  
  @RequiresApi(api=21)
  private void i()
  {
    this.o = ((CharacterCountEditText)this.l.findViewById(2131434699));
    this.p = ((TextView)this.l.findViewById(2131434698));
    this.q = ((ImageView)this.l.findViewById(2131434734));
    this.o.setLimitCount(15);
    this.o.setCountChangeListener(this);
    this.o.setText(this.s);
    this.o.setSelection(this.s.length());
    this.q.setContentDescription(getResources().getString(2131888434));
    this.q.setOnClickListener(new QQGuildNicknameSettingFragment.1(this));
    a("我的频道昵称");
    b(2131888784, new QQGuildNicknameSettingFragment.2(this));
  }
  
  private void j()
  {
    Bundle localBundle = getActivity().getIntent().getExtras();
    if (localBundle == null)
    {
      QLog.e("QQGuildNicknameSettingFragment", 1, "initIntentData failed: bundle is null");
      getActivity().finish();
      return;
    }
    this.r = localBundle.getString("guild_id");
    this.s = localBundle.getString("guild_nickname");
    if (this.s == null) {
      this.s = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildNicknameSettingFragment", 2, String.format("initIntentData guildId: %s, remark: %s", new Object[] { this.r, this.s }));
    }
  }
  
  private void k()
  {
    VideoReport.addToDetectionWhitelist(getQBaseActivity());
    VideoReport.setPageId(this.k, "pg_sgrp_name_edit");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.k, this.r, null);
  }
  
  private void m()
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.d, "em_sgrp_name_edit", null);
  }
  
  @RequiresApi(api=21)
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    j();
    i();
    k();
    m();
  }
  
  public void a(QQGuildTextUtils.CharacterCountInfo paramCharacterCountInfo)
  {
    this.p.setText(String.format(Locale.getDefault(), "%d/%d", new Object[] { Integer.valueOf(15 - paramCharacterCountInfo.a()), Integer.valueOf(15) }));
  }
  
  protected int b()
  {
    return 2131625098;
  }
  
  public void b(QQGuildTextUtils.CharacterCountInfo paramCharacterCountInfo) {}
  
  public boolean onBackEvent()
  {
    CharacterCountEditText localCharacterCountEditText = this.o;
    if (localCharacterCountEditText != null) {
      InputMethodUtil.b(localCharacterCountEditText);
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildNicknameSettingFragment
 * JD-Core Version:    0.7.0.1
 */