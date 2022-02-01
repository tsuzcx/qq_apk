package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.os.Bundle;
import com.tencent.mobileqq.guild.mainframe.helper.JoinGuildParam;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/mainframe/helper/jump/JoinGuildVoiceChannelFrag$Companion;", "", "()V", "newInstance", "Lcom/tencent/mobileqq/guild/mainframe/helper/jump/JoinGuildVoiceChannelFrag;", "joinGuildParam", "Lcom/tencent/mobileqq/guild/mainframe/helper/JoinGuildParam;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "channelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "isNeedJoinGuild", "", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class JoinGuildVoiceChannelFrag$Companion
{
  @NotNull
  public final JoinGuildVoiceChannelFrag a(@NotNull JoinGuildParam paramJoinGuildParam, @NotNull IGProGuildInfo paramIGProGuildInfo, @NotNull IGProChannelInfo paramIGProChannelInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramJoinGuildParam, "joinGuildParam");
    Intrinsics.checkParameterIsNotNull(paramIGProGuildInfo, "guildInfo");
    Intrinsics.checkParameterIsNotNull(paramIGProChannelInfo, "channelInfo");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", (Serializable)paramIGProGuildInfo);
    localBundle.putSerializable("extra_guild_channel_info", (Serializable)paramIGProChannelInfo);
    localBundle.putSerializable("extra_key_join_guild_params", (Serializable)paramJoinGuildParam);
    localBundle.putBoolean("extra_key_is_need_join_guild", paramBoolean);
    paramJoinGuildParam = new JoinGuildVoiceChannelFrag();
    paramJoinGuildParam.setArguments(localBundle);
    return paramJoinGuildParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildVoiceChannelFrag.Companion
 * JD-Core Version:    0.7.0.1
 */