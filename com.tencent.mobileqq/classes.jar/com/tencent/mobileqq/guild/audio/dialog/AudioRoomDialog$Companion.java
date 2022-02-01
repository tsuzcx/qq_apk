package com.tencent.mobileqq.guild.audio.dialog;

import android.os.Bundle;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/audio/dialog/AudioRoomDialog$Companion;", "", "()V", "ACTION_QQ_BACKGROUND", "", "PROCESS_NAME", "TAG", "makeAudioEnterBundle", "Landroid/os/Bundle;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "channelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "enterRoom", "", "entranceType", "", "newInstance", "Lcom/tencent/mobileqq/guild/audio/dialog/AudioRoomDialog;", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioRoomDialog$Companion
{
  @NotNull
  public final AudioRoomDialog a(@NotNull IGProGuildInfo paramIGProGuildInfo, @NotNull IGProChannelInfo paramIGProChannelInfo, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramIGProGuildInfo, "guildInfo");
    Intrinsics.checkParameterIsNotNull(paramIGProChannelInfo, "channelInfo");
    AudioRoomDialog localAudioRoomDialog = new AudioRoomDialog();
    localAudioRoomDialog.setArguments(((Companion)this).b(paramIGProGuildInfo, paramIGProChannelInfo, paramBoolean, paramInt));
    return localAudioRoomDialog;
  }
  
  @NotNull
  public final Bundle b(@NotNull IGProGuildInfo paramIGProGuildInfo, @NotNull IGProChannelInfo paramIGProChannelInfo, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramIGProGuildInfo, "guildInfo");
    Intrinsics.checkParameterIsNotNull(paramIGProChannelInfo, "channelInfo");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", (Serializable)paramIGProGuildInfo);
    localBundle.putSerializable("extra_guild_channel_info", (Serializable)paramIGProChannelInfo);
    localBundle.putBoolean("EXTRA_KEY_ENTER_ROOM", paramBoolean);
    localBundle.putInt("extra_entrance_from", paramInt);
    localBundle.putInt("extra_load_type", 3);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.AudioRoomDialog.Companion
 * JD-Core Version:    0.7.0.1
 */