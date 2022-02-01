package com.tencent.mobileqq.guild.privatechannel.dialog;

import com.tencent.mobileqq.guild.privatechannel.GuildSelectGuildMemberLayout;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.ArrayList;
import java.util.List;

class GuildPrivateSubSelectMemberFragment$3
  implements IGetUserInfoCallback
{
  GuildPrivateSubSelectMemberFragment$3(GuildPrivateSubSelectMemberFragment paramGuildPrivateSubSelectMemberFragment) {}
  
  public void onGetUserInfo(int paramInt, String paramString, List<IGProUserInfo> paramList, List<String> paramList1)
  {
    paramString = new ArrayList();
    this.a.e.a(paramList, paramString);
    this.a.e.a(paramString);
    this.a.e.setSelectItems(GuildPrivateSubSelectMemberFragment.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.dialog.GuildPrivateSubSelectMemberFragment.3
 * JD-Core Version:    0.7.0.1
 */