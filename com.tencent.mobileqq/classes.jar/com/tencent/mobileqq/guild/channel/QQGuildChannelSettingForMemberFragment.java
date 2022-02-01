package com.tencent.mobileqq.guild.channel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton.OnCheckedChangeListener;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;

public class QQGuildChannelSettingForMemberFragment
  extends QQGuildTitleBarFragment
  implements GuildSwitchButton.OnCheckedChangeListener
{
  private String o;
  private String p;
  private GuildSwitchButton q;
  private IGProChannelInfo r;
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (l() == null)
    {
      QLog.e("QQGuildChannelSettingForMemberFragment", 1, "updateNotifyLevel appInterface null");
      return;
    }
    ((QQGuildHandler)l().getBusinessHandler(QQGuildHandler.class.getName())).a(this.r, paramInt, new QQGuildChannelSettingForMemberFragment.1(this));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("guild_id", paramString1);
    localBundle.putString("channel_uin", paramString2);
    localIntent.putExtras(localBundle);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, QQGuildChannelSettingForMemberFragment.class);
  }
  
  private void a(LayoutInflater paramLayoutInflater)
  {
    this.c.setText(getResources().getString(2131890351));
    i();
  }
  
  private void b(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    a(i, paramBoolean);
  }
  
  private void i()
  {
    this.q = ((GuildSwitchButton)this.l.findViewById(2131439103));
    Object localObject = this.q;
    boolean bool = true;
    ((GuildSwitchButton)localObject).setTag(Integer.valueOf(1));
    this.q.setOnCheckedChangeListener(null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initMyMsgNotifyView. channelId: ");
      ((StringBuilder)localObject).append(this.r.getChannelUin());
      ((StringBuilder)localObject).append(", getFinalMsgNotify: ");
      ((StringBuilder)localObject).append(this.r.getFinalMsgNotify());
      QLog.d("QQGuildChannelSettingForMemberFragment", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.q;
    if (this.r.getFinalMsgNotify() != 1) {
      bool = false;
    }
    ((GuildSwitchButton)localObject).setChecked(bool);
    this.q.setOnCheckedChangeListener(this);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((!TextUtils.isEmpty(this.o)) && (!TextUtils.isEmpty(this.p)))
    {
      this.r = ((IGPSService)l().getRuntimeService(IGPSService.class, "")).getChannelInfo(this.p);
      if (this.r == null)
      {
        paramLayoutInflater = new StringBuilder();
        paramLayoutInflater.append("doOnCreateView can not find channelInfo channelUin = ");
        paramLayoutInflater.append(this.p);
        QLog.e("QQGuildChannelSettingForMemberFragment", 1, paramLayoutInflater.toString());
        return;
      }
      a(paramLayoutInflater);
      return;
    }
    QLog.e("QQGuildChannelSettingForMemberFragment", 1, "doOnCreateView args error!");
  }
  
  protected int b()
  {
    return 2131625015;
  }
  
  public void onCheckedChanged(GuildSwitchButton paramGuildSwitchButton, boolean paramBoolean)
  {
    if (((Integer)paramGuildSwitchButton.getTag()).intValue() != 1) {
      return;
    }
    b(paramBoolean);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.o = paramBundle.getString("guild_id");
      this.p = paramBundle.getString("channel_uin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelSettingForMemberFragment
 * JD-Core Version:    0.7.0.1
 */