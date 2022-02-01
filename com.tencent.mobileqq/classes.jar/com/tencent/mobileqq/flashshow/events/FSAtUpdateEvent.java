package com.tencent.mobileqq.flashshow.events;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class FSAtUpdateEvent
  extends SimpleBaseEvent
{
  public Intent mData;
  
  public FSAtUpdateEvent(Context paramContext, Intent paramIntent)
  {
    this.mData = paramIntent;
    int i;
    if (paramContext != null) {
      i = paramContext.hashCode();
    } else {
      i = 0;
    }
    this.mHashCode = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.events.FSAtUpdateEvent
 * JD-Core Version:    0.7.0.1
 */