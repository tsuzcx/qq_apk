package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqguildsdk.data.IClientInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.List;

class GuildClientTitleDisplaySettingFragment$3
  implements Observer<List<IClientInfo>>
{
  GuildClientTitleDisplaySettingFragment$3(GuildClientTitleDisplaySettingFragment paramGuildClientTitleDisplaySettingFragment) {}
  
  public void a(List<IClientInfo> paramList)
  {
    if ((GuildClientTitleDisplaySettingFragment.a(this.a) != null) && (GuildClientTitleDisplaySettingFragment.a(this.a).isShowing())) {
      GuildClientTitleDisplaySettingFragment.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientTitleDisplaySettingFragment.3
 * JD-Core Version:    0.7.0.1
 */