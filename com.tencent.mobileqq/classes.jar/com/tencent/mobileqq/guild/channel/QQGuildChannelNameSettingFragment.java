package com.tencent.mobileqq.guild.channel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class QQGuildChannelNameSettingFragment
  extends QQGuildTitleBarFragment
{
  public IGProChannelInfo o;
  private int p = 0;
  private int q = 20;
  private QQProgressDialog r;
  private CharacterCountEditText s;
  private ImageView t;
  
  private void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChannelUpdateResult errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    QLog.i("QQGuildCustomTitleBarFragment", 1, localStringBuilder.toString());
    paramString = this.r;
    if ((paramString != null) && (paramString.isShowing())) {
      this.r.dismiss();
    }
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      if (getActivity() != null) {
        getActivity().finish();
      }
    }
    else {
      QQGuildUtil.a(getContext(), 0, getResources().getString(2131890335), paramIGProSecurityResult);
    }
  }
  
  public static void a(Context paramContext, IGProChannelInfo paramIGProChannelInfo)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_channel_info", paramIGProChannelInfo);
    localIntent.putExtras(localBundle);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, QQGuildChannelNameSettingFragment.class);
  }
  
  private void a(String paramString)
  {
    b(paramString);
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.makeText(getContext(), 1, getResources().getString(2131890372), 1).show();
      return;
    }
    String str = paramString.trim();
    if (TextUtils.isEmpty(str))
    {
      QQToast.makeText(getContext(), 1, getResources().getString(2131890372), 1).show();
      return;
    }
    if (!TextUtils.isEmpty(str))
    {
      paramString = str;
      if (str.length() >= this.p) {}
    }
    else
    {
      paramString = getContext().getString(2131890342);
    }
    if (this.r == null) {
      this.r = new QQProgressDialog(getContext());
    }
    if (!this.r.isShowing()) {
      this.r.show();
    }
    ((QQGuildHandler)l().getBusinessHandler(QQGuildHandler.class.getName())).a(this.o, paramString, new QQGuildChannelNameSettingFragment.4(this));
  }
  
  private void i()
  {
    Bundle localBundle = getActivity().getIntent().getExtras();
    if (localBundle != null) {
      this.o = ((IGProChannelInfo)localBundle.getSerializable("extra_guild_channel_info"));
    }
  }
  
  private void j()
  {
    this.s = ((CharacterCountEditText)this.l.findViewById(2131434699));
    this.t = ((ImageView)this.l.findViewById(2131434734));
    this.s.setLimitCount(this.q);
    this.s.setText(this.o.getChannelName());
    this.s.setSelection(this.o.getChannelName().length());
    this.t.setContentDescription(getResources().getString(2131888434));
    this.t.setOnClickListener(new QQGuildChannelNameSettingFragment.1(this));
    if ((TextUtils.isEmpty(this.o.getChannelName())) || (TextUtils.isEmpty(this.o.getChannelName().trim()))) {
      this.d.setEnabled(false);
    }
    this.s.addTextChangedListener(new QQGuildChannelNameSettingFragment.2(this));
    a(getString(2131890323));
    b(2131888784, new QQGuildChannelNameSettingFragment.3(this));
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    i();
    if (this.o == null)
    {
      QLog.e("QQGuildCustomTitleBarFragment", 1, "error channel info");
      QQToast.makeText(getContext(), 1, getResources().getString(2131889041), 1).show();
      return;
    }
    j();
  }
  
  protected int b()
  {
    return 2131625012;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQProgressDialog localQQProgressDialog = this.r;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.r.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelNameSettingFragment
 * JD-Core Version:    0.7.0.1
 */