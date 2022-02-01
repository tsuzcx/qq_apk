package com.tencent.tkd.topicsdk.common;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/KeyBoardChangeListener$Companion;", "", "()V", "MIN_KEYBOARD_HEIGHT", "", "TAG", "", "create", "Lcom/tencent/tkd/topicsdk/common/KeyBoardChangeListener;", "activity", "Landroid/app/Activity;", "dialog", "Landroid/app/Dialog;", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class KeyBoardChangeListener$Companion
{
  @NotNull
  public final KeyBoardChangeListener a(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    return new KeyBoardChangeListener(paramActivity, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.Companion
 * JD-Core Version:    0.7.0.1
 */