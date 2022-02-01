package com.tencent.mobileqq.guild.audio.dialog;

import com.tencent.mobileqq.banner.TipsBar;
import cooperation.qzone.util.NetworkState.NetworkStateListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "connected", "", "onNetworkConnect"}, k=3, mv={1, 1, 16})
final class QQGuildAudioDialogContent$mNetworkListener$1
  implements NetworkState.NetworkStateListener
{
  QQGuildAudioDialogContent$mNetworkListener$1(QQGuildAudioDialogContent paramQQGuildAudioDialogContent) {}
  
  public final void onNetworkConnect(boolean paramBoolean)
  {
    QQGuildAudioDialogContent.d(this.a).post((Runnable)new QQGuildAudioDialogContent.mNetworkListener.1.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogContent.mNetworkListener.1
 * JD-Core Version:    0.7.0.1
 */