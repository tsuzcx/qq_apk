package com.tencent.mobileqq.guild.window;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/window/IGuildFloatWindowWrapper;", "", "getGuildChannelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "setGuildChannelInfo", "", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "channelInfo", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IGuildFloatWindowWrapper
{
  public abstract void a(@NotNull IGProGuildInfo paramIGProGuildInfo, @NotNull IGProChannelInfo paramIGProChannelInfo);
  
  @Nullable
  public abstract IGProChannelInfo b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.window.IGuildFloatWindowWrapper
 * JD-Core Version:    0.7.0.1
 */