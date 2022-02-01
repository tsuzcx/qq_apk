package com.tencent.mobileqq.guild.audio.dialog;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.audio.AudioRoomObserver;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfoList;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/audio/dialog/QQGuildAudioDialogBottom$mAudioRoomObserver$1", "Lcom/tencent/mobileqq/guild/audio/AudioRoomObserver;", "onExit", "", "guildId", "", "roomId", "reason", "onUserDataUpdate", "from", "localUserInfo", "Lcom/tencent/mobileqq/guild/audio/data/LocalUserInfo;", "userInfoList", "Lcom/tencent/mobileqq/guild/audio/data/UserInfoList;", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGuildAudioDialogBottom$mAudioRoomObserver$1
  extends AudioRoomObserver
{
  public void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "guildId");
    Intrinsics.checkParameterIsNotNull(paramString2, "roomId");
    Intrinsics.checkParameterIsNotNull(paramString3, "reason");
    if ((Intrinsics.areEqual(paramString3, "") ^ true)) {
      DialogUtil.a((Context)QBaseActivity.sTopActivity, 230, null, (CharSequence)paramString3, null, QBaseActivity.sTopActivity.getString(2131890251), (DialogInterface.OnClickListener)QQGuildAudioDialogBottom.mAudioRoomObserver.1.onExit.dialog.1.a, (DialogInterface.OnClickListener)null).show();
    }
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull LocalUserInfo paramLocalUserInfo, @NotNull UserInfoList paramUserInfoList)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "from");
    Intrinsics.checkParameterIsNotNull(paramString2, "guildId");
    Intrinsics.checkParameterIsNotNull(paramString3, "roomId");
    Intrinsics.checkParameterIsNotNull(paramLocalUserInfo, "localUserInfo");
    Intrinsics.checkParameterIsNotNull(paramUserInfoList, "userInfoList");
    if (!(Intrinsics.areEqual(paramString2, QQGuildAudioDialogBottom.i(this.a).getGuildId()) ^ true))
    {
      if ((Intrinsics.areEqual(paramString3, QQGuildAudioDialogBottom.i(this.a).getChannelUin()) ^ true)) {
        return;
      }
      this.a.a(paramLocalUserInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogBottom.mAudioRoomObserver.1
 * JD-Core Version:    0.7.0.1
 */