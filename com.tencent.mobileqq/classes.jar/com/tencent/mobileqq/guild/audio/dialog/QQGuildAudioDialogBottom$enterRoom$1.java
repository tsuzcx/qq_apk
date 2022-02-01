package com.tencent.mobileqq.guild.audio.dialog;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.animation.RotateAnimation;
import com.tencent.mobileqq.guild.audio.AudioRoom;
import com.tencent.mobileqq.guild.audio.AudioRoom.IEnterRoomCallback;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "errMsg", "", "kotlin.jvm.PlatformType", "onEnterRoom"}, k=3, mv={1, 1, 16})
final class QQGuildAudioDialogBottom$enterRoom$1
  implements AudioRoom.IEnterRoomCallback
{
  QQGuildAudioDialogBottom$enterRoom$1(QQGuildAudioDialogBottom paramQQGuildAudioDialogBottom) {}
  
  public final void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      QQGuildAudioDialogBottom.e(this.a).cancel();
      AudioRoom.b().g();
      return;
    }
    QQGuildAudioDialogBottom.d(this.a);
    if (paramString != null) {}
    try
    {
      DialogUtil.a(this.a.getContext(), 230, null, (CharSequence)paramString, null, this.a.getContext().getString(2131890251), (DialogInterface.OnClickListener)QQGuildAudioDialogBottom.enterRoom.1.1.a, (DialogInterface.OnClickListener)null).show();
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogBottom.enterRoom.1
 * JD-Core Version:    0.7.0.1
 */