package com.tencent.mobileqq.guild.profilecard.baseprofile.card;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.qphone.base.util.QLog;

class GuildProfileCardViewModel$2
  extends BroadcastReceiver
{
  GuildProfileCardViewModel$2(GuildProfileCardViewModel paramGuildProfileCardViewModel) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("qqAccountReceiver onReceive= ");
    paramIntent.append(paramContext);
    QLog.i("GuildProfileCardViewModel", 1, paramIntent.toString());
    GuildProfileCardViewModel.a(this.a).setValue(Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.baseprofile.card.GuildProfileCardViewModel.2
 * JD-Core Version:    0.7.0.1
 */