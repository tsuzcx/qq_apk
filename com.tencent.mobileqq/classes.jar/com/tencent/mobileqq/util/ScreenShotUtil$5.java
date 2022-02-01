package com.tencent.mobileqq.util;

import android.animation.AnimatorSet;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class ScreenShotUtil$5
  implements DialogInterface.OnDismissListener
{
  ScreenShotUtil$5(AnimatorSet paramAnimatorSet) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.isRunning()) {
      this.a.end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ScreenShotUtil.5
 * JD-Core Version:    0.7.0.1
 */