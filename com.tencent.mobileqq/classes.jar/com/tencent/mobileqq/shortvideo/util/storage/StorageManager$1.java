package com.tencent.mobileqq.shortvideo.util.storage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class StorageManager$1
  extends BroadcastReceiver
{
  StorageManager$1(StorageManager paramStorageManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == null) {
      return;
    }
    paramContext = this.a.d;
    this.a.d();
    if ((this.a.j != null) && (!paramContext.equals(this.a.d)))
    {
      if (paramIntent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED"))
      {
        this.a.c();
        this.a.j.a(0, this.a.d);
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.MEDIA_MOUNTED")) {
        this.a.j.a(1, this.a.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.storage.StorageManager.1
 * JD-Core Version:    0.7.0.1
 */