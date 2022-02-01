package com.tencent.mobileqq.guild.profilecard.baseprofile.card;

import android.app.Dialog;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS;

class GuildProfileCard$1
  implements Observer<DIALOG_STATUS>
{
  GuildProfileCard$1(GuildProfileCard paramGuildProfileCard) {}
  
  public void a(DIALOG_STATUS paramDIALOG_STATUS)
  {
    if (paramDIALOG_STATUS != DIALOG_STATUS.OPEN) {
      return;
    }
    if ((this.a.getDialog() != null) && (this.a.getDialog().isShowing()))
    {
      GuildProfileCard.a(this.a, false);
      this.a.dismissAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.baseprofile.card.GuildProfileCard.1
 * JD-Core Version:    0.7.0.1
 */