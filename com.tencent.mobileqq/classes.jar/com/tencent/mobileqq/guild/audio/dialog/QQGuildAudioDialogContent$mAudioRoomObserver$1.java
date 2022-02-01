package com.tencent.mobileqq.guild.audio.dialog;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.audio.AudioRoom;
import com.tencent.mobileqq.guild.audio.AudioRoom.IInitCallback;
import com.tencent.mobileqq.guild.audio.AudioRoomObserver;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfoList;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/audio/dialog/QQGuildAudioDialogContent$mAudioRoomObserver$1", "Lcom/tencent/mobileqq/guild/audio/AudioRoomObserver;", "onExit", "", "guildId", "", "roomId", "reason", "onUserDataUpdate", "from", "localUserInfo", "Lcom/tencent/mobileqq/guild/audio/data/LocalUserInfo;", "userInfoList", "Lcom/tencent/mobileqq/guild/audio/data/UserInfoList;", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGuildAudioDialogContent$mAudioRoomObserver$1
  extends AudioRoomObserver
{
  public void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "guildId");
    Intrinsics.checkParameterIsNotNull(paramString2, "roomId");
    Intrinsics.checkParameterIsNotNull(paramString3, "reason");
    if (this.a.getActivity() != null)
    {
      paramString3 = this.a.getActivity();
      if (paramString3 == null) {
        Intrinsics.throwNpe();
      }
      Intrinsics.checkExpressionValueIsNotNull(paramString3, "activity!!");
      if (paramString3.isFinishing()) {
        return;
      }
      if (!(Intrinsics.areEqual(paramString1, QQGuildAudioDialogContent.e(this.a).getGuildId()) ^ true))
      {
        if ((Intrinsics.areEqual(paramString2, QQGuildAudioDialogContent.e(this.a).getChannelUin()) ^ true)) {
          return;
        }
        if (QQGuildAudioDialogContent.f(this.a)) {
          return;
        }
        QQGuildAudioDialogContent.a(this.a, true);
        if ((Intrinsics.areEqual(paramString1, QQGuildAudioDialogContent.e(this.a).getGuildId())) && (Intrinsics.areEqual(paramString2, QQGuildAudioDialogContent.e(this.a).getChannelUin())))
        {
          AudioRoom.b().a(QQGuildAudioDialogContent.e(this.a), (AudioRoom.IInitCallback)new QQGuildAudioDialogContent.mAudioRoomObserver.1.onExit.1(this), false);
          QQGuildAudioDialogContent.a(this.a, false);
        }
        AudioRoomLiveData.a.a().postValue(DIALOG_STATUS.DISMISS);
      }
    }
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull LocalUserInfo paramLocalUserInfo, @NotNull UserInfoList paramUserInfoList)
  {
    Intrinsics.checkParameterIsNotNull(paramLocalUserInfo, "localUserInfo");
    Intrinsics.checkParameterIsNotNull(paramUserInfoList, "userInfoList");
    super.a(paramString1, paramString2, paramString3, paramLocalUserInfo, paramUserInfoList);
    if (!(Intrinsics.areEqual(paramString2, QQGuildAudioDialogContent.e(this.a).getGuildId()) ^ true))
    {
      if ((Intrinsics.areEqual(paramString3, QQGuildAudioDialogContent.e(this.a).getChannelUin()) ^ true)) {
        return;
      }
      if ((paramUserInfoList.a.size() == 0) && (QQGuildAudioDialogContent.a(this.a, paramString1)))
      {
        AudioRoomLiveData.a.b().postValue(Boolean.valueOf(true));
        return;
      }
      AudioRoomLiveData.a.b().postValue(Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogContent.mAudioRoomObserver.1
 * JD-Core Version:    0.7.0.1
 */