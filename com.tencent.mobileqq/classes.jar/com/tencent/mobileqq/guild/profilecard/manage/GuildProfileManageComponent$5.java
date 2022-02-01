package com.tencent.mobileqq.guild.profilecard.manage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.utils.QQCustomDialog;

class GuildProfileManageComponent$5
  implements DialogInterface.OnClickListener
{
  GuildProfileManageComponent$5(GuildProfileManageComponent paramGuildProfileManageComponent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (CheckBox)GuildProfileManageComponent.access$400(this.a).findViewById(2131447782);
    GuildProfileManageComponent.access$500(this.a).b(paramDialogInterface.isChecked());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileManageComponent.5
 * JD-Core Version:    0.7.0.1
 */