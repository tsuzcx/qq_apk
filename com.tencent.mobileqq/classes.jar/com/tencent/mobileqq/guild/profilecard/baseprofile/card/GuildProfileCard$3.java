package com.tencent.mobileqq.guild.profilecard.baseprofile.card;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller.IGuildComponentController;

class GuildProfileCard$3
  implements DialogInterface.OnDismissListener
{
  GuildProfileCard$3(GuildProfileCard paramGuildProfileCard) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    GuildProfileCard.b(this.a).onDestroy();
    this.a.getActivity().getSupportFragmentManager().beginTransaction().remove(this.a).commitAllowingStateLoss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.baseprofile.card.GuildProfileCard.3
 * JD-Core Version:    0.7.0.1
 */