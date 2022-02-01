package com.tencent.mobileqq.guild.audio.dialog;

import com.tencent.mobileqq.guild.audio.AudioRoomObserver;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfoList;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/audio/dialog/QQGuildAudioDialogTitleBar$mAudioRoomObserver$1", "Lcom/tencent/mobileqq/guild/audio/AudioRoomObserver;", "onUserDataUpdate", "", "from", "", "guildId", "roomId", "localUserInfo", "Lcom/tencent/mobileqq/guild/audio/data/LocalUserInfo;", "userInfoList", "Lcom/tencent/mobileqq/guild/audio/data/UserInfoList;", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGuildAudioDialogTitleBar$mAudioRoomObserver$1
  extends AudioRoomObserver
{
  public void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull LocalUserInfo paramLocalUserInfo, @NotNull UserInfoList paramUserInfoList)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "from");
    Intrinsics.checkParameterIsNotNull(paramString2, "guildId");
    Intrinsics.checkParameterIsNotNull(paramString3, "roomId");
    Intrinsics.checkParameterIsNotNull(paramLocalUserInfo, "localUserInfo");
    Intrinsics.checkParameterIsNotNull(paramUserInfoList, "userInfoList");
    if (!(Intrinsics.areEqual(paramString2, QQGuildAudioDialogTitleBar.a(this.a).getGuildId()) ^ true))
    {
      if ((Intrinsics.areEqual(paramString3, QQGuildAudioDialogTitleBar.a(this.a).getChannelUin()) ^ true)) {
        return;
      }
      if ((paramLocalUserInfo.c) && (paramUserInfoList.a.size() == 0)) {
        return;
      }
      this.a.a(paramLocalUserInfo, paramUserInfoList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogTitleBar.mAudioRoomObserver.1
 * JD-Core Version:    0.7.0.1
 */