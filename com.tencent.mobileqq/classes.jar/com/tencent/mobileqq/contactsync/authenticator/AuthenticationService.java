package com.tencent.mobileqq.contactsync.authenticator;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import mqq.app.MobileQQ;

public class AuthenticationService
  extends Service
{
  private Authenticator a;
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.a.getIBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    Intent localIntent = new Intent();
    localIntent.putExtra("k_start_mode", 2);
    localMobileQQ.onActivityCreate(this, localIntent);
    this.a = new Authenticator(this);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.authenticator.AuthenticationService
 * JD-Core Version:    0.7.0.1
 */