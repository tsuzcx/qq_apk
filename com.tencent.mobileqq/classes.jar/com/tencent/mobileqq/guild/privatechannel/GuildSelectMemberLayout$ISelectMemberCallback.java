package com.tencent.mobileqq.guild.privatechannel;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public abstract interface GuildSelectMemberLayout$ISelectMemberCallback
  extends AbsListView.OnScrollListener
{
  public abstract void a();
  
  public abstract void a(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData);
  
  public abstract void a(AbsListView paramAbsListView, int paramInt);
  
  public abstract void a(String paramString);
  
  public abstract boolean a(GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData, boolean paramBoolean);
  
  public abstract void b(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout.ISelectMemberCallback
 * JD-Core Version:    0.7.0.1
 */