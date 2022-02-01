package com.tencent.mobileqq.guild.audio.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class QQGuildAudioDialogBottom$initView$1
  implements View.OnClickListener
{
  QQGuildAudioDialogBottom$initView$1(QQGuildAudioDialogBottom paramQQGuildAudioDialogBottom) {}
  
  public final void onClick(View paramView)
  {
    QQGuildAudioDialogBottom.a(this.a).setEnabled(QQGuildAudioDialogBottom.b(this.a).isChecked());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogBottom.initView.1
 * JD-Core Version:    0.7.0.1
 */