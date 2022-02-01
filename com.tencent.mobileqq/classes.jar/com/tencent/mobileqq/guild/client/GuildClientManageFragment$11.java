package com.tencent.mobileqq.guild.client;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.widget.QQProgressDialog;

class GuildClientManageFragment$11
  implements Observer<GuildClientManageViewModel.ClientInfo>
{
  GuildClientManageFragment$11(GuildClientManageFragment paramGuildClientManageFragment) {}
  
  public void a(GuildClientManageViewModel.ClientInfo paramClientInfo)
  {
    if (!TextUtils.isEmpty(paramClientInfo.b))
    {
      TextView localTextView = GuildClientManageFragment.g(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("绑定我的");
      localStringBuilder.append(paramClientInfo.b);
      localStringBuilder.append("帐号");
      localTextView.setText(localStringBuilder.toString());
      if (AppSetting.e) {
        GuildClientManageFragment.c(this.a).setContentDescription(paramClientInfo.b);
      }
    }
    if ((!TextUtils.isEmpty(paramClientInfo.a)) && (GuildClientManageFragment.b(this.a) != null) && (GuildClientManageFragment.b(this.a).isShowing())) {
      GuildClientManageFragment.b(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageFragment.11
 * JD-Core Version:    0.7.0.1
 */