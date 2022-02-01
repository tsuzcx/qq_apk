package com.tencent.mobileqq.guild.setting.popup;

import android.app.Dialog;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS;

class GuildMainSettingDialogFragment$1
  implements Observer<DIALOG_STATUS>
{
  GuildMainSettingDialogFragment$1(GuildMainSettingDialogFragment paramGuildMainSettingDialogFragment) {}
  
  public void a(DIALOG_STATUS paramDIALOG_STATUS)
  {
    if (paramDIALOG_STATUS != DIALOG_STATUS.OPEN) {
      return;
    }
    if ((this.a.getDialog() != null) && (this.a.getDialog().isShowing())) {
      this.a.dismissAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.popup.GuildMainSettingDialogFragment.1
 * JD-Core Version:    0.7.0.1
 */