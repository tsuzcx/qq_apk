package com.tencent.mobileqq.guild.privatechannel.ext;

import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout.ISelectMemberCallback;
import com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateDeleteViewModel;
import com.tencent.widget.AbsListView;

class GuildSelectDeleteMemberLayout$1
  implements GuildSelectMemberLayout.ISelectMemberCallback
{
  GuildSelectDeleteMemberLayout$1(GuildSelectDeleteMemberLayout paramGuildSelectDeleteMemberLayout) {}
  
  public void a()
  {
    GuildSelectDeleteMemberLayout localGuildSelectDeleteMemberLayout = this.a;
    localGuildSelectDeleteMemberLayout.setSelectData(GuildSelectDeleteMemberLayout.b(localGuildSelectDeleteMemberLayout));
    localGuildSelectDeleteMemberLayout = this.a;
    localGuildSelectDeleteMemberLayout.a(localGuildSelectDeleteMemberLayout.a);
    GuildSelectDeleteMemberLayout.a(this.a).a();
  }
  
  public void a(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData)
  {
    GuildSelectDeleteMemberLayout.a(this.a).a(paramUserInfoUIData);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((!GuildSelectDeleteMemberLayout.c(this.a).c()) && (GuildSelectDeleteMemberLayout.c(this.a).f()))
    {
      GuildSelectDeleteMemberLayout.c(this.a).b();
      this.a.a();
    }
    GuildSelectDeleteMemberLayout.a(this.a).a(paramAbsListView, paramInt);
  }
  
  public void a(String paramString)
  {
    GuildSelectDeleteMemberLayout.a(this.a).a(paramString);
  }
  
  public boolean a(GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData, boolean paramBoolean)
  {
    return GuildSelectDeleteMemberLayout.a(this.a).a(paramArrayOfUserInfoUIData, paramBoolean);
  }
  
  public void b(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData)
  {
    GuildSelectDeleteMemberLayout.a(this.a).b(paramUserInfoUIData);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    GuildSelectDeleteMemberLayout.a(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    GuildSelectDeleteMemberLayout.a(this.a).onScrollStateChanged(paramAbsListView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.ext.GuildSelectDeleteMemberLayout.1
 * JD-Core Version:    0.7.0.1
 */