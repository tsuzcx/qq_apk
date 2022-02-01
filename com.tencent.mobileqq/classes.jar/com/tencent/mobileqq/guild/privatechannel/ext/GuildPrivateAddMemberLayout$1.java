package com.tencent.mobileqq.guild.privatechannel.ext;

import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout.ISelectMemberCallback;
import com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateAddViewModel;
import com.tencent.widget.AbsListView;

class GuildPrivateAddMemberLayout$1
  implements GuildSelectMemberLayout.ISelectMemberCallback
{
  GuildPrivateAddMemberLayout$1(GuildPrivateAddMemberLayout paramGuildPrivateAddMemberLayout) {}
  
  public void a()
  {
    GuildPrivateAddMemberLayout.a(this.a, false);
    GuildPrivateAddMemberLayout localGuildPrivateAddMemberLayout = this.a;
    localGuildPrivateAddMemberLayout.setSelectData(GuildPrivateAddMemberLayout.c(localGuildPrivateAddMemberLayout));
    localGuildPrivateAddMemberLayout = this.a;
    localGuildPrivateAddMemberLayout.a(localGuildPrivateAddMemberLayout.a);
    GuildPrivateAddMemberLayout.a(this.a).a();
  }
  
  public void a(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData)
  {
    GuildPrivateAddMemberLayout.a(this.a).a(paramUserInfoUIData);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((!GuildPrivateAddMemberLayout.b(this.a).c()) && (GuildPrivateAddMemberLayout.b(this.a).e()) && (!GuildPrivateAddMemberLayout.d(this.a)))
    {
      GuildPrivateAddMemberLayout.b(this.a).a();
      this.a.a();
    }
    GuildPrivateAddMemberLayout.a(this.a).a(paramAbsListView, paramInt);
  }
  
  public void a(String paramString)
  {
    GuildPrivateAddMemberLayout.b(this.a).a(paramString);
    GuildPrivateAddMemberLayout.a(this.a).a(paramString);
  }
  
  public boolean a(GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData, boolean paramBoolean)
  {
    return GuildPrivateAddMemberLayout.a(this.a).a(paramArrayOfUserInfoUIData, paramBoolean);
  }
  
  public void b(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData)
  {
    GuildPrivateAddMemberLayout.a(this.a).b(paramUserInfoUIData);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    GuildPrivateAddMemberLayout.a(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    GuildPrivateAddMemberLayout.a(this.a).onScrollStateChanged(paramAbsListView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.ext.GuildPrivateAddMemberLayout.1
 * JD-Core Version:    0.7.0.1
 */