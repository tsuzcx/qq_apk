package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class HWReciteItem$3
  extends BroadcastReceiver
{
  HWReciteItem$3(HWReciteItem paramHWReciteItem) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tnecnet.mobileqq.homework.recite.stopAudio".equals(paramIntent.getAction())) && (HWReciteItem.a(this.a)) && (this.a.a != null) && (this.a.a.a != null))
    {
      this.a.b();
      this.a.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.3
 * JD-Core Version:    0.7.0.1
 */