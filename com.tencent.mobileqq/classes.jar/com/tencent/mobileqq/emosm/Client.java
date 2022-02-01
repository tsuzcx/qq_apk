package com.tencent.mobileqq.emosm;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import ascx;
import ascy;
import asgs;
import ashz;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;

public class Client
  implements asgs
{
  public static final String TAG = "Q.emoji.web.Client";
  private ServiceConnection mConnection = new ascx(this);
  public boolean mIsBound;
  public final Messenger mMessenger = new Messenger(new ascy(this, Looper.getMainLooper()));
  public Messenger mService = null;
  
  public void doBindService(Context paramContext)
  {
    try
    {
      paramContext.bindService(new Intent(paramContext, MessengerService.class), this.mConnection, 1);
      this.mIsBound = true;
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.Client", 2, "Binding...");
      }
      return;
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        this.mIsBound = false;
        if (QLog.isColorLevel()) {
          QLog.e("Q.emoji.web.Client", 2, paramContext.getMessage());
        }
      }
    }
  }
  
  public void doUnbindService(Context paramContext)
  {
    if ((!this.mIsBound) || (this.mService != null)) {}
    try
    {
      Message localMessage = Message.obtain(null, 2);
      localMessage.replyTo = this.mMessenger;
      this.mService.send(localMessage);
      try
      {
        label36:
        paramContext.unbindService(this.mConnection);
        label44:
        this.mService = null;
        this.mIsBound = false;
        if (QLog.isColorLevel()) {
          QLog.i("Q.emoji.web.Client", 2, "Unbinding.");
        }
        return;
      }
      catch (IllegalArgumentException paramContext)
      {
        break label44;
      }
    }
    catch (RemoteException localRemoteException)
    {
      break label36;
    }
  }
  
  public boolean isClientBinded()
  {
    return this.mService != null;
  }
  
  public void onDisconnectWithService()
  {
    ashz.a().b();
  }
  
  public void onPushMsgFromServer(Bundle paramBundle)
  {
    ashz.a().d(paramBundle);
  }
  
  public boolean onReqToServer(Bundle paramBundle)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if (this.mService != null) {
      bool2 = bool3;
    }
    try
    {
      Message localMessage = Message.obtain(null, 3, 0, 0);
      bool2 = bool3;
      localMessage.replyTo = this.mMessenger;
      bool2 = bool3;
      localMessage.setData(paramBundle);
      bool2 = bool3;
      this.mService.send(localMessage);
      boolean bool4 = true;
      bool3 = true;
      bool1 = bool3;
      bool2 = bool4;
      if (QLog.isColorLevel())
      {
        bool2 = bool4;
        QLog.i("Q.emoji.web.Client", 2, "req to server");
        bool1 = bool3;
      }
      return bool1;
    }
    catch (RemoteException paramBundle)
    {
      this.mService = null;
    }
    return bool2;
  }
  
  public void onRespFromServer(Bundle paramBundle)
  {
    try
    {
      ashz.a().c(paramBundle);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      try
      {
        QLog.e("Q.emoji.web.Client", 2, "onRespFromServer bundle error:" + paramBundle);
        return;
      }
      catch (Throwable paramBundle)
      {
        QLog.e("Q.emoji.web.Client", 2, "print error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.Client
 * JD-Core Version:    0.7.0.1
 */