package com.tencent.mobileqq.jsp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class UiApiPlugin$32
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.msg.newmessage".equals(paramIntent.getAction())) && (UiApiPlugin.O != null) && (UiApiPlugin.O.size() > 0))
    {
      Iterator localIterator = UiApiPlugin.O.iterator();
      while (localIterator.hasNext())
      {
        UiApiPlugin localUiApiPlugin = (UiApiPlugin)((WeakReference)localIterator.next()).get();
        if (localUiApiPlugin != null) {
          localUiApiPlugin.a(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.32
 * JD-Core Version:    0.7.0.1
 */