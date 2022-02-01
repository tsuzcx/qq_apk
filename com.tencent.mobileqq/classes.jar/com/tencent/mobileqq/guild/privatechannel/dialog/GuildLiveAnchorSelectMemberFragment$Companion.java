package com.tencent.mobileqq.guild.privatechannel.dialog;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/privatechannel/dialog/GuildLiveAnchorSelectMemberFragment$Companion;", "", "()V", "newInstance", "Lcom/tencent/mobileqq/guild/privatechannel/dialog/GuildLiveAnchorSelectMemberFragment;", "createSubChannelInfo", "Lcom/tencent/mobileqq/guild/channel/create/CreateSubChannelInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "selectedTinyIdList", "", "", "cacheDataList", "Lcom/tencent/mobileqq/guild/privatechannel/GuildPrivateMemberListAdapter$UserInfoUIData;", "cb", "Lcom/tencent/mobileqq/guild/privatechannel/dialog/GuildPrivateAppSubSelectMemberDialogFragment$OnMemberSelectCallback;", "(Lcom/tencent/mobileqq/guild/channel/create/CreateSubChannelInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;[Ljava/lang/String;[Lcom/tencent/mobileqq/guild/privatechannel/GuildPrivateMemberListAdapter$UserInfoUIData;Lcom/tencent/mobileqq/guild/privatechannel/dialog/GuildPrivateAppSubSelectMemberDialogFragment$OnMemberSelectCallback;)Lcom/tencent/mobileqq/guild/privatechannel/dialog/GuildLiveAnchorSelectMemberFragment;", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildLiveAnchorSelectMemberFragment$Companion
{
  @NotNull
  public final GuildLiveAnchorSelectMemberFragment a(@NotNull CreateSubChannelInfo paramCreateSubChannelInfo, @NotNull IGProGuildInfo paramIGProGuildInfo, @Nullable String[] paramArrayOfString, @Nullable GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData, @NotNull GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback paramOnMemberSelectCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramCreateSubChannelInfo, "createSubChannelInfo");
    Intrinsics.checkParameterIsNotNull(paramIGProGuildInfo, "guildInfo");
    Intrinsics.checkParameterIsNotNull(paramOnMemberSelectCallback, "cb");
    GuildLiveAnchorSelectMemberFragment localGuildLiveAnchorSelectMemberFragment = new GuildLiveAnchorSelectMemberFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", (Serializable)paramIGProGuildInfo);
    if (paramArrayOfString != null) {
      localBundle.putStringArray("selected_list", paramArrayOfString);
    }
    if (paramArrayOfUserInfoUIData != null) {
      localBundle.putSerializable("select_member_info_list", (Serializable)paramArrayOfUserInfoUIData);
    }
    localBundle.putParcelable("extra_key_subchannel_info", (Parcelable)paramCreateSubChannelInfo);
    localGuildLiveAnchorSelectMemberFragment.setArguments(localBundle);
    localGuildLiveAnchorSelectMemberFragment.a(paramOnMemberSelectCallback);
    return localGuildLiveAnchorSelectMemberFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.dialog.GuildLiveAnchorSelectMemberFragment.Companion
 * JD-Core Version:    0.7.0.1
 */