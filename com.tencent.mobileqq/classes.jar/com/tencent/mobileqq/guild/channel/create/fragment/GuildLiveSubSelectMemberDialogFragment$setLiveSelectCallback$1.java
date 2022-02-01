package com.tencent.mobileqq.guild.channel.create.fragment;

import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.privatechannel.dialog.GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "selectedTinyIdList", "", "", "kotlin.jvm.PlatformType", "uiDataList", "Lcom/tencent/mobileqq/guild/privatechannel/GuildPrivateMemberListAdapter$UserInfoUIData;", "OnSelect", "([Ljava/lang/String;[Lcom/tencent/mobileqq/guild/privatechannel/GuildPrivateMemberListAdapter$UserInfoUIData;)V"}, k=3, mv={1, 1, 16})
final class GuildLiveSubSelectMemberDialogFragment$setLiveSelectCallback$1
  implements GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback
{
  GuildLiveSubSelectMemberDialogFragment$setLiveSelectCallback$1(GuildLiveSubSelectMemberDialogFragment paramGuildLiveSubSelectMemberDialogFragment) {}
  
  public final void a(String[] paramArrayOfString, GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData)
  {
    this.a.a(true);
    GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback localOnMemberSelectCallback = this.a.g();
    if (localOnMemberSelectCallback != null) {
      localOnMemberSelectCallback.a(paramArrayOfString, paramArrayOfUserInfoUIData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.GuildLiveSubSelectMemberDialogFragment.setLiveSelectCallback.1
 * JD-Core Version:    0.7.0.1
 */