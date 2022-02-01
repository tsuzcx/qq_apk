package com.tencent.mobileqq.guild.audio.dialog;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/audio/dialog/AudioRoomDialog$initDialogBehavior$1", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioRoomDialog$initDialogBehavior$1
  extends BottomSheetBehavior.BottomSheetCallback
{
  public void onSlide(@NotNull View paramView, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "bottomSheet");
  }
  
  public void onStateChanged(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "bottomSheet");
    paramView = new StringBuilder();
    paramView.append("newState");
    paramView.append(paramInt);
    QLog.d("AudioRoomDialog", 4, paramView.toString());
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6) {
            return;
          }
          if (Intrinsics.areEqual((Boolean)AudioRoomLiveData.a.b().getValue(), Boolean.valueOf(true))) {
            this.a.dismissAllowingStateLoss();
          }
        }
      }
      else if (AudioRoomDialog.a(this.a)) {
        this.a.dismissAllowingStateLoss();
      }
    }
    else if (Intrinsics.areEqual((Boolean)AudioRoomLiveData.a.b().getValue(), Boolean.valueOf(false))) {
      AudioRoomDialog.b(this.a).a(AudioRoomDialog.c(this.a).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.AudioRoomDialog.initDialogBehavior.1
 * JD-Core Version:    0.7.0.1
 */