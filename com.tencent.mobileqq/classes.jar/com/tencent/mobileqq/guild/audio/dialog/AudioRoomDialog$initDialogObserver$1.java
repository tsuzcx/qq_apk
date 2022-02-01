package com.tencent.mobileqq.guild.audio.dialog;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/guild/audio/data/DIALOG_STATUS;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class AudioRoomDialog$initDialogObserver$1<T>
  implements Observer<DIALOG_STATUS>
{
  AudioRoomDialog$initDialogObserver$1(AudioRoomDialog paramAudioRoomDialog) {}
  
  public final void a(DIALOG_STATUS paramDIALOG_STATUS)
  {
    if (paramDIALOG_STATUS == null) {
      return;
    }
    int i = AudioRoomDialog.WhenMappings.$EnumSwitchMapping$0[paramDIALOG_STATUS.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        if (Intrinsics.areEqual((Boolean)AudioRoomLiveData.a.b().getValue(), Boolean.valueOf(true)))
        {
          AudioRoomDialog.c(this.a).d(3);
          return;
        }
        AudioRoomDialog.c(this.a).d(6);
        AudioRoomDialog.a(this.a, true);
        return;
      }
      AudioRoomDialog.c(this.a).d(4);
      AudioRoomDialog.a(this.a, false);
      return;
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.AudioRoomDialog.initDialogObserver.1
 * JD-Core Version:    0.7.0.1
 */