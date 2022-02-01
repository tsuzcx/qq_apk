package com.tencent.mobileqq.guild.audio.dialog;

import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class AudioRoomDialog$initDialogObserver$2<T>
  implements Observer<Boolean>
{
  AudioRoomDialog$initDialogObserver$2(AudioRoomDialog paramAudioRoomDialog) {}
  
  public final void a(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    if (paramBoolean.booleanValue())
    {
      AudioRoomDialog.c(this.a).b(AudioRoomDialog.d(this.a));
      AudioRoomDialog.c(this.a).d(3);
      return;
    }
    if (AudioRoomDialog.c(this.a).a() == AudioRoomDialog.e(this.a))
    {
      AudioRoomDialog.c(this.a).b(AudioRoomDialog.f(this.a));
      AudioRoomDialog.c(this.a).a(0.6047517F);
      AudioRoomDialog.c(this.a).d(6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.AudioRoomDialog.initDialogObserver.2
 * JD-Core Version:    0.7.0.1
 */