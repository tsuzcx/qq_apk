package com.tencent.mobileqq.guild.audio.dialog;

import com.tencent.mobileqq.guild.audio.AudioRoom.IInitCallback;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfoList;
import com.tencent.mobileqq.guild.audio.widget.audiofaceview.AudioFacesView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "errMsg", "", "kotlin.jvm.PlatformType", "localUserInfo", "Lcom/tencent/mobileqq/guild/audio/data/LocalUserInfo;", "userInfoList", "Lcom/tencent/mobileqq/guild/audio/data/UserInfoList;", "onInit"}, k=3, mv={1, 1, 16})
final class QQGuildAudioDialogContent$mAudioRoomObserver$1$onExit$1
  implements AudioRoom.IInitCallback
{
  QQGuildAudioDialogContent$mAudioRoomObserver$1$onExit$1(QQGuildAudioDialogContent.mAudioRoomObserver.1 param1) {}
  
  public final void a(boolean paramBoolean, String paramString, LocalUserInfo paramLocalUserInfo, UserInfoList paramUserInfoList)
  {
    if (paramBoolean)
    {
      paramString = QQGuildAudioDialogContent.b(this.a.a);
      Intrinsics.checkExpressionValueIsNotNull(paramLocalUserInfo, "localUserInfo");
      Intrinsics.checkExpressionValueIsNotNull(paramUserInfoList, "userInfoList");
      paramString.a(paramLocalUserInfo, paramUserInfoList);
      QQGuildAudioDialogContent.a(this.a.a).a(paramLocalUserInfo);
      QQGuildAudioDialogContent.c(this.a.a).a(paramLocalUserInfo, paramUserInfoList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogContent.mAudioRoomObserver.1.onExit.1
 * JD-Core Version:    0.7.0.1
 */