package com.tencent.mobileqq.contactsync.authenticator;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import aowc;

public class AuthenticationService
  extends Service
{
  private aowc a;
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.a.getIBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = new aowc(this);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.authenticator.AuthenticationService
 * JD-Core Version:    0.7.0.1
 */