package com.tencent.viola.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

class EventModule$1
  extends BroadcastReceiver
{
  EventModule$1(EventModule paramEventModule) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Iterator localIterator = EventModule.access$000().iterator();
    while (localIterator.hasNext())
    {
      EventModule localEventModule = (EventModule)((WeakReference)localIterator.next()).get();
      if (localEventModule != null) {
        EventModule.access$100(localEventModule, paramContext, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.module.EventModule.1
 * JD-Core Version:    0.7.0.1
 */