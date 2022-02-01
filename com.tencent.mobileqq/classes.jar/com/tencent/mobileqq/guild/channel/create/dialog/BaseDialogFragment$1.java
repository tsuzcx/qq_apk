package com.tencent.mobileqq.guild.channel.create.dialog;

import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS;

class BaseDialogFragment$1
  implements Observer<DIALOG_STATUS>
{
  BaseDialogFragment$1(BaseDialogFragment paramBaseDialogFragment) {}
  
  public void a(DIALOG_STATUS paramDIALOG_STATUS)
  {
    BottomSheetDialog localBottomSheetDialog = (BottomSheetDialog)this.a.getDialog();
    if (paramDIALOG_STATUS == DIALOG_STATUS.OPEN)
    {
      if (localBottomSheetDialog != null) {
        this.a.a();
      }
    }
    else if ((paramDIALOG_STATUS == DIALOG_STATUS.UNKNOWN) && (localBottomSheetDialog != null) && (this.a.b.booleanValue())) {
      BaseDialogFragment.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment.1
 * JD-Core Version:    0.7.0.1
 */