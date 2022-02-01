package com.tencent.mobileqq.guild.privatechannel.dialog;

import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectGuildMemberLayout;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout.ISelectMemberCallback;
import com.tencent.widget.AbsListView;
import java.util.HashMap;

class GuildPrivateSubSelectMemberFragment$5
  implements GuildSelectMemberLayout.ISelectMemberCallback
{
  GuildPrivateSubSelectMemberFragment$5(GuildPrivateSubSelectMemberFragment paramGuildPrivateSubSelectMemberFragment) {}
  
  public void a() {}
  
  public void a(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData) {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(String paramString) {}
  
  public boolean a(GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData, boolean paramBoolean)
  {
    if (this.a.e.getSelectedPositionList().size() == 0)
    {
      this.a.a(false);
      paramArrayOfUserInfoUIData = this.a;
      paramArrayOfUserInfoUIData.a(paramArrayOfUserInfoUIData.h, -2130706433);
      return true;
    }
    this.a.a(true);
    paramArrayOfUserInfoUIData = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.h);
    localStringBuilder.append("(");
    localStringBuilder.append(this.a.e.getSelectedPositionList().size());
    localStringBuilder.append(")");
    paramArrayOfUserInfoUIData.a(localStringBuilder.toString(), -16777216);
    return true;
  }
  
  public void b(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.dialog.GuildPrivateSubSelectMemberFragment.5
 * JD-Core Version:    0.7.0.1
 */