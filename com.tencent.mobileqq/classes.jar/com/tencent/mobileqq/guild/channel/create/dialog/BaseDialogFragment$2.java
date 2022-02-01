package com.tencent.mobileqq.guild.channel.create.dialog;

import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback;
import com.tencent.qphone.base.util.QLog;

class BaseDialogFragment$2
  extends BottomSheetBehavior.BottomSheetCallback
{
  BaseDialogFragment$2(BaseDialogFragment paramBaseDialogFragment) {}
  
  public void onSlide(@NonNull View paramView, float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onSlide：slideOffset=");
      paramView.append(paramFloat);
      QLog.i("BaseDialogFragment", 2, paramView.toString());
    }
  }
  
  public void onStateChanged(@NonNull View paramView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onStateChanged：newState=");
      paramView.append(paramInt);
      QLog.i("BaseDialogFragment", 2, paramView.toString());
    }
    if (paramInt == 4) {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment.2
 * JD-Core Version:    0.7.0.1
 */