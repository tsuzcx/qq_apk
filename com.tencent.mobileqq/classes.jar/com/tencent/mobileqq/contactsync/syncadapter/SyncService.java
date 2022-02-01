package com.tencent.mobileqq.contactsync.syncadapter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.common.AccountDPCHelper;
import com.tencent.mobileqq.phonecontact.adapter.SyncAdapter;
import mqq.app.MobileQQ;

public class SyncService
  extends Service
{
  private static final Object a = new Object();
  private static SyncAdapter b = null;
  
  public IBinder onBind(Intent paramIntent)
  {
    return b.getSyncAdapterBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    ??? = MobileQQ.sMobileQQ;
    if ((AccountDPCHelper.a(this, false)) && (AccountDPCHelper.c(this, false)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("k_start_mode", 1);
      ((MobileQQ)???).onActivityCreate(this, localIntent);
    }
    synchronized (a)
    {
      if (b == null) {
        b = new SyncAdapter(getApplicationContext(), true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.syncadapter.SyncService
 * JD-Core Version:    0.7.0.1
 */