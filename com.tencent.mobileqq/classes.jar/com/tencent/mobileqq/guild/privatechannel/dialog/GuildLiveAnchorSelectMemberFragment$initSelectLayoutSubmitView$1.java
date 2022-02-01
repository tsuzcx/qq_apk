package com.tencent.mobileqq.guild.privatechannel.dialog;

import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout.ISelectMemberCallback;
import com.tencent.widget.AbsListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/privatechannel/dialog/GuildLiveAnchorSelectMemberFragment$initSelectLayoutSubmitView$1", "Lcom/tencent/mobileqq/guild/privatechannel/GuildSelectMemberLayout$ISelectMemberCallback;", "onCheckedChanged", "", "selectList", "", "Lcom/tencent/mobileqq/guild/privatechannel/GuildPrivateMemberListAdapter$UserInfoUIData;", "isChecked", "([Lcom/tencent/mobileqq/guild/privatechannel/GuildPrivateMemberListAdapter$UserInfoUIData;Z)Z", "onCloseSearch", "", "onDeleteClick", "userInfoUIData", "onScroll", "view", "Lcom/tencent/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollFooter", "scrollState", "onScrollStateChanged", "onSearchKeyWord", "keywords", "", "onSingleSelect", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildLiveAnchorSelectMemberFragment$initSelectLayoutSubmitView$1
  implements GuildSelectMemberLayout.ISelectMemberCallback
{
  public void a() {}
  
  public void a(@NotNull GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData)
  {
    Intrinsics.checkParameterIsNotNull(paramUserInfoUIData, "userInfoUIData");
  }
  
  public void a(@NotNull AbsListView paramAbsListView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsListView, "view");
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "keywords");
  }
  
  public boolean a(@NotNull GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfUserInfoUIData, "selectList");
    paramArrayOfUserInfoUIData = this.a;
    paramArrayOfUserInfoUIData.a(paramArrayOfUserInfoUIData.h, -16777216);
    return true;
  }
  
  public void b(@NotNull GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData)
  {
    Intrinsics.checkParameterIsNotNull(paramUserInfoUIData, "userInfoUIData");
  }
  
  public void onScroll(@NotNull AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsListView, "view");
  }
  
  public void onScrollStateChanged(@NotNull AbsListView paramAbsListView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsListView, "view");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.dialog.GuildLiveAnchorSelectMemberFragment.initSelectLayoutSubmitView.1
 * JD-Core Version:    0.7.0.1
 */