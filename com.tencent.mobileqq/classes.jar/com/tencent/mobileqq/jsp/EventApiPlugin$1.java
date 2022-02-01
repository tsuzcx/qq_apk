package com.tencent.mobileqq.jsp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class EventApiPlugin$1
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((EventApiPlugin.d != null) && (EventApiPlugin.d.size() > 0))
    {
      Iterator localIterator = EventApiPlugin.d.iterator();
      while (localIterator.hasNext())
      {
        EventApiPlugin localEventApiPlugin = (EventApiPlugin)((WeakReference)localIterator.next()).get();
        if (localEventApiPlugin != null) {
          localEventApiPlugin.a(paramContext, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.EventApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */