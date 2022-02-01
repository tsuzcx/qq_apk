package com.tencent.mobileqq.guild.client;

import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqguildsdk.data.IClientInfo;
import java.util.List;

class GuildClientTitleDisplaySettingFragment$2
  implements Observer<IClientInfo>
{
  GuildClientTitleDisplaySettingFragment$2(GuildClientTitleDisplaySettingFragment paramGuildClientTitleDisplaySettingFragment) {}
  
  public void a(IClientInfo paramIClientInfo)
  {
    if (paramIClientInfo != null)
    {
      GuildClientTitleDisplaySettingFragment.b(this.a).a(paramIClientInfo);
      GuildClientTitleDisplaySettingFragment.c(this.a).setText(this.a.getString(2131890233));
      GuildClientTitleDisplaySettingFragment.d(this.a).setText(this.a.getString(2131890235));
      GuildClientTitleDisplaySettingFragment.a(this.a, paramIClientInfo.c());
      return;
    }
    GuildClientTitleDisplaySettingFragment.b(this.a).a();
    paramIClientInfo = (List)this.a.o.c().getValue();
    if ((paramIClientInfo != null) && (!paramIClientInfo.isEmpty()))
    {
      GuildClientTitleDisplaySettingFragment.c(this.a).setText(String.format(this.a.getString(2131890234), new Object[] { ((IClientInfo)paramIClientInfo.get(0)).b() }));
      GuildClientTitleDisplaySettingFragment.d(this.a).setText(String.format(this.a.getString(2131890236), new Object[] { ((IClientInfo)paramIClientInfo.get(0)).b() }));
      GuildClientTitleDisplaySettingFragment.a(this.a, ((IClientInfo)paramIClientInfo.get(0)).c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientTitleDisplaySettingFragment.2
 * JD-Core Version:    0.7.0.1
 */