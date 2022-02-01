package com.tencent.mobileqq.listentogether.lyrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class LyricsController$7
  extends BroadcastReceiver
{
  LyricsController$7(LyricsController paramLyricsController) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("process_name");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive action: ");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("  process_name:");
      localStringBuilder.append(paramIntent);
      QLog.d("LyricsController", 2, localStringBuilder.toString());
    }
    int i;
    if ((paramIntent != null) && (paramIntent.contains("openSdk"))) {
      i = 1;
    } else {
      i = 0;
    }
    if ("mqq.intent.action.QQ_BACKGROUND".equals(paramContext))
    {
      if ((this.a.e) && (this.a.j != null) && (this.a.i != null) && (this.a.d.u))
      {
        this.a.j.o.setAlign(this.a.d.t);
        this.a.j.a(this.a.d.r, this.a.j.getCurrentY());
        this.a.i.a(this.a.d.s, this.a.i.getCurrentY());
        this.a.d.u = false;
      }
      this.a.a(false);
      paramContext = this.a;
      paramContext.c = false;
      LyricsController.a(paramContext, false);
      return;
    }
    if ("mqq.intent.action.QQ_FOREGROUND".equals(paramContext))
    {
      if (i == 0)
      {
        paramContext = this.a;
        paramContext.c = true;
        paramContext.a(true);
        LyricsController.a(this.a, false);
        return;
      }
      if (this.a.e)
      {
        LyricsController.a(this.a, true);
        return;
      }
      paramContext = this.a;
      paramContext.c = true;
      paramContext.d.k = true;
      LyricsController.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.7
 * JD-Core Version:    0.7.0.1
 */