package com.tencent.mobileqq.emosm;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.web.IPCConstants;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class Client
  implements IPCConstants
{
  public static final String TAG = "Q.emoji.web.Client";
  private ServiceConnection mConnection = new Client.1(this);
  boolean mIsBound;
  final Messenger mMessenger = new Messenger(new Client.IncomingHandler(this, Looper.getMainLooper()));
  Messenger mService = null;
  
  public void doBindService(Context paramContext)
  {
    try
    {
      paramContext.bindService(new Intent(paramContext, ((IEmosmService)QRoute.api(IEmosmService.class)).getMessengerServiceClass()), this.mConnection, 1);
      this.mIsBound = true;
    }
    catch (SecurityException paramContext)
    {
      this.mIsBound = false;
      if (QLog.isColorLevel()) {
        QLog.e("Q.emoji.web.Client", 2, paramContext.getMessage());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.Client", 2, "Binding...");
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
    }
    catch (RemoteException localRemoteException)
    {
      try
      {
        for (;;)
        {
          paramContext.unbindService(this.mConnection);
          label44:
          this.mService = null;
          this.mIsBound = false;
          if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.Client", 2, "Unbinding.");
          }
          return;
          localRemoteException = localRemoteException;
        }
      }
      catch (IllegalArgumentException paramContext)
      {
        break label44;
      }
    }
  }
  
  public boolean isClientBinded()
  {
    return this.mService != null;
  }
  
  void onDisconnectWithService()
  {
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).onDisconnectWithService();
  }
  
  void onPushMsgFromServer(Bundle paramBundle)
  {
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).onPushMsgFromServer(paramBundle);
  }
  
  public boolean onReqToServer(Bundle paramBundle)
  {
    Object localObject = this.mService;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if (localObject != null) {
      bool2 = bool3;
    }
    try
    {
      localObject = Message.obtain(null, 3, 0, 0);
      bool2 = bool3;
      ((Message)localObject).replyTo = this.mMessenger;
      bool2 = bool3;
      ((Message)localObject).setData(paramBundle);
      bool2 = bool3;
      this.mService.send((Message)localObject);
      bool3 = true;
      bool1 = true;
      bool2 = bool3;
      if (!QLog.isColorLevel()) {
        break label95;
      }
      bool2 = bool3;
      QLog.i("Q.emoji.web.Client", 2, "req to server");
      return true;
    }
    catch (RemoteException paramBundle)
    {
      label88:
      break label88;
    }
    this.mService = null;
    bool1 = bool2;
    label95:
    return bool1;
  }
  
  void onRespFromServer(Bundle paramBundle)
  {
    try
    {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).onRespFromClient(paramBundle);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label15:
      StringBuilder localStringBuilder;
      label47:
      break label15;
    }
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRespFromServer bundle error:");
      localStringBuilder.append(paramBundle);
      QLog.e("Q.emoji.web.Client", 2, localStringBuilder.toString());
      return;
    }
    catch (Throwable paramBundle)
    {
      break label47;
    }
    QLog.e("Q.emoji.web.Client", 2, "print error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.Client
 * JD-Core Version:    0.7.0.1
 */