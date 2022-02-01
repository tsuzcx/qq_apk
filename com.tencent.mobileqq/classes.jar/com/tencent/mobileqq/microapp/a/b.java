package com.tencent.mobileqq.microapp.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.StringUtil;

final class b
  extends BroadcastReceiver
{
  b(a parama) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (StringUtil.isEmpty(paramIntent.getAction())) {}
    while (a.a(this.a) == null) {
      return;
    }
    a.a(this.a).a(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.a.b
 * JD-Core Version:    0.7.0.1
 */