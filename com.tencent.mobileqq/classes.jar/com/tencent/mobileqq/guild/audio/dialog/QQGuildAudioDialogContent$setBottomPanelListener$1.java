package com.tencent.mobileqq.guild.audio.dialog;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/guild/audio/data/DIALOG_STATUS;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class QQGuildAudioDialogContent$setBottomPanelListener$1<T>
  implements Observer<DIALOG_STATUS>
{
  QQGuildAudioDialogContent$setBottomPanelListener$1(QQGuildAudioDialogContent paramQQGuildAudioDialogContent) {}
  
  public final void a(DIALOG_STATUS paramDIALOG_STATUS)
  {
    if (paramDIALOG_STATUS == DIALOG_STATUS.HIDE)
    {
      QQGuildAudioDialogContent.a(this.a).setVisibility(8);
      return;
    }
    if (paramDIALOG_STATUS == DIALOG_STATUS.REOPEN) {
      QQGuildAudioDialogContent.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogContent.setBottomPanelListener.1
 * JD-Core Version:    0.7.0.1
 */