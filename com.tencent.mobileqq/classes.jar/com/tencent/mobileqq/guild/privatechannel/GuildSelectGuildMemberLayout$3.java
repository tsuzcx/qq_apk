package com.tencent.mobileqq.guild.privatechannel;

import android.content.res.Resources;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

class GuildSelectGuildMemberLayout$3
  implements Observer<List<IGProUserInfo>>
{
  GuildSelectGuildMemberLayout$3(GuildSelectGuildMemberLayout paramGuildSelectGuildMemberLayout) {}
  
  public void a(List<IGProUserInfo> paramList)
  {
    if (paramList != null)
    {
      GuildSelectGuildMemberLayout localGuildSelectGuildMemberLayout = this.a;
      localGuildSelectGuildMemberLayout.a(paramList, localGuildSelectGuildMemberLayout.a);
      paramList = this.a;
      paramList.a(paramList.a);
    }
    else
    {
      QQGuildUtil.a(BaseApplication.getContext(), 2, this.a.getResources().getString(2131890505));
      this.a.a(new ArrayList());
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildSelectGuildMemberLayout.3
 * JD-Core Version:    0.7.0.1
 */