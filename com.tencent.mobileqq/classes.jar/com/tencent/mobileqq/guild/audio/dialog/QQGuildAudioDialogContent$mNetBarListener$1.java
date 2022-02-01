package com.tencent.mobileqq.guild.audio.dialog;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class QQGuildAudioDialogContent$mNetBarListener$1
  implements View.OnClickListener
{
  QQGuildAudioDialogContent$mNetBarListener$1(QQGuildAudioDialogContent paramQQGuildAudioDialogContent) {}
  
  public final void onClick(View paramView)
  {
    Context localContext;
    if (VersionUtils.e())
    {
      localContext = this.a.getContext();
      if (localContext != null) {
        localContext.startActivity(new Intent("android.settings.SETTINGS"));
      }
    }
    else
    {
      localContext = this.a.getContext();
      if (localContext != null) {
        localContext.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogContent.mNetBarListener.1
 * JD-Core Version:    0.7.0.1
 */