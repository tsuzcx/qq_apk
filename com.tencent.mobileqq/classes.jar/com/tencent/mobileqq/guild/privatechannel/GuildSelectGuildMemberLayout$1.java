package com.tencent.mobileqq.guild.privatechannel;

import com.tencent.mobileqq.guild.setting.QQGuildMemberListViewModel;
import com.tencent.widget.AbsListView;

class GuildSelectGuildMemberLayout$1
  implements GuildSelectMemberLayout.ISelectMemberCallback
{
  GuildSelectGuildMemberLayout$1(GuildSelectGuildMemberLayout paramGuildSelectGuildMemberLayout) {}
  
  public void a()
  {
    GuildSelectGuildMemberLayout.a(this.a, false);
    GuildSelectGuildMemberLayout localGuildSelectGuildMemberLayout = this.a;
    localGuildSelectGuildMemberLayout.setSelectData(GuildSelectGuildMemberLayout.c(localGuildSelectGuildMemberLayout));
    localGuildSelectGuildMemberLayout = this.a;
    localGuildSelectGuildMemberLayout.a(localGuildSelectGuildMemberLayout.a);
    GuildSelectGuildMemberLayout.a(this.a).a();
  }
  
  public void a(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData)
  {
    GuildSelectGuildMemberLayout.a(this.a).a(paramUserInfoUIData);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((!GuildSelectGuildMemberLayout.b(this.a).p()) && (!GuildSelectGuildMemberLayout.d(this.a)) && (!GuildSelectGuildMemberLayout.e(this.a)))
    {
      GuildSelectGuildMemberLayout.b(this.a).s();
      this.a.a();
    }
    GuildSelectGuildMemberLayout.a(this.a).a(paramAbsListView, paramInt);
  }
  
  public void a(String paramString)
  {
    GuildSelectGuildMemberLayout.b(this.a).a(paramString);
    GuildSelectGuildMemberLayout.a(this.a).a(paramString);
  }
  
  public boolean a(GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData, boolean paramBoolean)
  {
    return GuildSelectGuildMemberLayout.a(this.a).a(paramArrayOfUserInfoUIData, paramBoolean);
  }
  
  public void b(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData)
  {
    GuildSelectGuildMemberLayout.a(this.a).b(paramUserInfoUIData);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    GuildSelectGuildMemberLayout.a(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      GuildSelectGuildMemberLayout.b(this.a).b(false);
    }
    GuildSelectGuildMemberLayout.a(this.a).onScrollStateChanged(paramAbsListView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildSelectGuildMemberLayout.1
 * JD-Core Version:    0.7.0.1
 */