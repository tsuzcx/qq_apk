package com.tencent.mobileqq.flashshow.api.hybird;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mqq.util.WeakReference;

class FSHybirdFragment$FSHybirdBroadcastReceiver
  extends BroadcastReceiver
{
  private final WeakReference<FSHybirdFragment> a;
  
  public FSHybirdFragment$FSHybirdBroadcastReceiver(FSHybirdFragment paramFSHybirdFragment)
  {
    this.a = new WeakReference(paramFSHybirdFragment);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (((FSHybirdFragment)this.a.get() != null) && (paramIntent != null)) {
      paramIntent.getAction();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.hybird.FSHybirdFragment.FSHybirdBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */