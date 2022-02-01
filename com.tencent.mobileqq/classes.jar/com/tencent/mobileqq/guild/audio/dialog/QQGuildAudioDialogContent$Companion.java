package com.tencent.mobileqq.guild.audio.dialog;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/audio/dialog/QQGuildAudioDialogContent$Companion;", "", "()V", "CLICK_INTERVAL_TIME", "", "newInstance", "Lcom/tencent/mobileqq/guild/audio/dialog/QQGuildAudioDialogContent;", "bundle", "Landroid/os/Bundle;", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGuildAudioDialogContent$Companion
{
  @NotNull
  public final QQGuildAudioDialogContent a(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    QQGuildAudioDialogContent localQQGuildAudioDialogContent = new QQGuildAudioDialogContent();
    localQQGuildAudioDialogContent.setArguments(paramBundle);
    return localQQGuildAudioDialogContent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogContent.Companion
 * JD-Core Version:    0.7.0.1
 */