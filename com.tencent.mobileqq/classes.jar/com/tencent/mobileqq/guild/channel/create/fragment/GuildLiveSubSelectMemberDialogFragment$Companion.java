package com.tencent.mobileqq.guild.channel.create.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.privatechannel.dialog.GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/channel/create/fragment/GuildLiveSubSelectMemberDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/tencent/mobileqq/guild/channel/create/fragment/GuildLiveSubSelectMemberDialogFragment;", "createSubChannelInfo", "Lcom/tencent/mobileqq/guild/channel/create/CreateSubChannelInfo;", "app", "Lcom/tencent/common/app/AppInterface;", "selectedTinyIdList", "", "", "cacheDataList", "Lcom/tencent/mobileqq/guild/privatechannel/GuildPrivateMemberListAdapter$UserInfoUIData;", "cb", "Lcom/tencent/mobileqq/guild/privatechannel/dialog/GuildPrivateAppSubSelectMemberDialogFragment$OnMemberSelectCallback;", "(Lcom/tencent/mobileqq/guild/channel/create/CreateSubChannelInfo;Lcom/tencent/common/app/AppInterface;[Ljava/lang/String;[Lcom/tencent/mobileqq/guild/privatechannel/GuildPrivateMemberListAdapter$UserInfoUIData;Lcom/tencent/mobileqq/guild/privatechannel/dialog/GuildPrivateAppSubSelectMemberDialogFragment$OnMemberSelectCallback;)Lcom/tencent/mobileqq/guild/channel/create/fragment/GuildLiveSubSelectMemberDialogFragment;", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildLiveSubSelectMemberDialogFragment$Companion
{
  @NotNull
  public final GuildLiveSubSelectMemberDialogFragment a(@NotNull CreateSubChannelInfo paramCreateSubChannelInfo, @NotNull AppInterface paramAppInterface, @Nullable String[] paramArrayOfString, @Nullable GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData, @Nullable GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback paramOnMemberSelectCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramCreateSubChannelInfo, "createSubChannelInfo");
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    GuildLiveSubSelectMemberDialogFragment localGuildLiveSubSelectMemberDialogFragment = new GuildLiveSubSelectMemberDialogFragment();
    Bundle localBundle = new Bundle();
    paramAppInterface = paramAppInterface.getRuntimeService(IGPSService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(paramAppInterface, "app.getRuntimeService(IG…va, ProcessConstant.MAIN)");
    localBundle.putSerializable("extra_guild_guild_info", (Serializable)((IGPSService)paramAppInterface).getGuildInfo(paramCreateSubChannelInfo.a));
    if (paramArrayOfString != null) {
      localBundle.putStringArray("selected_list", paramArrayOfString);
    }
    if (paramArrayOfUserInfoUIData != null) {
      localBundle.putSerializable("select_member_info_list", (Serializable)paramArrayOfUserInfoUIData);
    }
    localBundle.putParcelable("extra_key_subchannel_info", (Parcelable)paramCreateSubChannelInfo);
    localGuildLiveSubSelectMemberDialogFragment.setArguments(localBundle);
    localGuildLiveSubSelectMemberDialogFragment.a(paramOnMemberSelectCallback);
    return localGuildLiveSubSelectMemberDialogFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.GuildLiveSubSelectMemberDialogFragment.Companion
 * JD-Core Version:    0.7.0.1
 */