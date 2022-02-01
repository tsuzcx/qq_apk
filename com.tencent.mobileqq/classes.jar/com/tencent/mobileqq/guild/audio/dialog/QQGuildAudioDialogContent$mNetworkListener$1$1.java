package com.tencent.mobileqq.guild.audio.dialog;

import com.tencent.mobileqq.banner.TipsBar;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class QQGuildAudioDialogContent$mNetworkListener$1$1
  implements Runnable
{
  QQGuildAudioDialogContent$mNetworkListener$1$1(QQGuildAudioDialogContent.mNetworkListener.1 param1, boolean paramBoolean) {}
  
  public final void run()
  {
    TipsBar localTipsBar = QQGuildAudioDialogContent.d(this.this$0.a);
    int i;
    if (this.a) {
      i = 8;
    } else {
      i = 0;
    }
    localTipsBar.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogContent.mNetworkListener.1.1
 * JD-Core Version:    0.7.0.1
 */