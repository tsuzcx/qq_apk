package com.tencent.mobileqq.guild.privatechannel.ext;

import android.content.res.Resources;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

class GuildSelectDeleteMemberLayout$2
  implements Observer<List<IGProUserInfo>>
{
  GuildSelectDeleteMemberLayout$2(GuildSelectDeleteMemberLayout paramGuildSelectDeleteMemberLayout) {}
  
  public void a(List<IGProUserInfo> paramList)
  {
    if (paramList != null)
    {
      GuildSelectDeleteMemberLayout localGuildSelectDeleteMemberLayout = this.a;
      localGuildSelectDeleteMemberLayout.a(paramList, localGuildSelectDeleteMemberLayout.a);
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
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.ext.GuildSelectDeleteMemberLayout.2
 * JD-Core Version:    0.7.0.1
 */