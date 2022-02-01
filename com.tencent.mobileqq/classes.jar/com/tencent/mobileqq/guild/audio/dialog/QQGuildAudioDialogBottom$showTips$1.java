package com.tencent.mobileqq.guild.audio.dialog;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class QQGuildAudioDialogBottom$showTips$1
  implements Runnable
{
  QQGuildAudioDialogBottom$showTips$1(QQGuildAudioDialogBottom paramQQGuildAudioDialogBottom, String paramString) {}
  
  public final void run()
  {
    QQGuildAudioDialogBottom.f(this.this$0).setText((CharSequence)this.a);
    QQGuildAudioDialogBottom.g(this.this$0).setVisibility(0);
    ThreadManager.getUIHandler().removeCallbacks(QQGuildAudioDialogBottom.h(this.this$0));
    ThreadManager.getUIHandler().postDelayed(QQGuildAudioDialogBottom.h(this.this$0), 2000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogBottom.showTips.1
 * JD-Core Version:    0.7.0.1
 */