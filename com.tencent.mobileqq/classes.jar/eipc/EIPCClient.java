package eipc;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class EIPCClient
  extends EIPCModuleManager
{
  public ArrayList<String> guardServerProcList = new ArrayList();
  String mAction;
  int mClientId;
  EIPCConnection mServerConnection = null;
  ArrayList<EIPClientConnectListener> sListener = new ArrayList();
  
  public EIPCClient(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mClientId = paramInt;
  }
  
  public EIPCResult callServer(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callServerLock module=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", action=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", params=");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("");
      QLog.d("EIPCConst", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = EIPCResult.UNKNOW_RESULT;
    connect(null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callServerLock nolockmodule=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", action=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", params=");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("");
      QLog.d("EIPCConst", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBundle != null) {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    }
    try
    {
      localObject = this.mServerConnection;
      if (localObject == null) {
        return EIPCResult.createResult(-1, null);
      }
      if (!((EIPCConnection)localObject).isAvailable()) {
        return EIPCResult.createResult(-2, null);
      }
      paramString1 = ((EIPCConnection)localObject).callModule(paramString1, paramString2, paramBundle, -99999);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
      return EIPCResult.createExceptionResult(paramString1);
    }
    catch (RemoteException paramString1)
    {
      paramString1.printStackTrace();
    }
    return EIPCResult.createExceptionResult(paramString1);
  }
  
  public void callServer(String paramString1, String paramString2, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    connect(new EIPCClient.1(this, paramBundle, paramString1, paramString2, paramEIPCResultCallback));
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    try
    {
      this.mServerConnection.channel.callback(paramInt % 1000000, paramEIPCResult);
      return;
    }
    catch (Exception paramEIPCResult)
    {
      if (QLog.isColorLevel()) {
        QLog.w("EIPCConst", 2, "callbackResult error", paramEIPCResult);
      }
    }
  }
  
  public void connect(EIPClientConnectListener paramEIPClientConnectListener)
  {
    EIPCConnection localEIPCConnection = this.mServerConnection;
    if ((localEIPCConnection == null) || (!localEIPCConnection.channel.asBinder().isBinderAlive()) || (!localEIPCConnection.channel.asBinder().pingBinder())) {
      connectProvider();
    }
    localEIPCConnection = this.mServerConnection;
    if ((localEIPCConnection != null) && (localEIPCConnection.channel.asBinder().isBinderAlive()) && (localEIPCConnection.channel.asBinder().pingBinder()))
    {
      if (paramEIPClientConnectListener != null) {
        paramEIPClientConnectListener.connectSuccess(this.mServerConnection);
      }
    }
    else if (paramEIPClientConnectListener != null) {
      paramEIPClientConnectListener.connectFailed();
    }
  }
  
  public void connectProvider()
  {
    try
    {
      IBinder localIBinder = EIPCContentProvider.queryBinder(this.mContext);
      Object localObject2 = EIPCChannel.Stub.asInterface(localIBinder);
      int i = ((EIPCChannel)localObject2).setClient(MobileQQ.processName, Process.myPid(), this.channel, this.mClientId);
      Object localObject1 = ((EIPCChannel)localObject2).getProcName();
      this.mServerConnection = new EIPCConnection((EIPCChannel)localObject2, ((EIPCChannel)localObject2).getProcName());
      this.mServerConnection.remoteIndex = i;
      this.mServerConnection.callbackManager = this;
      this.mServerConnection.logMark = "EIPCServer";
      localObject2 = this.guardServerProcList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (TextUtils.equals((CharSequence)localObject1, (String)((Iterator)localObject2).next()))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(MobileQQ.processName);
            ((StringBuilder)localObject2).append(" guard ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("EIPCConst", 2, ((StringBuilder)localObject2).toString());
          }
          localObject1 = new EIPCClient.ClientDeathRecipient();
          ((EIPCClient.ClientDeathRecipient)localObject1).eipcClient = this;
          ((EIPCClient.ClientDeathRecipient)localObject1).binder = localIBinder;
          ((EIPCClient.ClientDeathRecipient)localObject1).connection = this.mServerConnection;
          localIBinder.linkToDeath((IBinder.DeathRecipient)localObject1, 0);
        }
      }
      QLog.d("EIPCConst", 1, "connectProvider success");
      return;
    }
    catch (Exception localException)
    {
      QLog.d("EIPCConst", 1, "connectProvider ", localException);
    }
  }
  
  public void disConnect()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, "EIPCClient.disConnect,");
    }
  }
  
  public void sendMessageToRemote(int paramInt, Bundle paramBundle)
  {
    EIPCConnection localEIPCConnection = this.mServerConnection;
    if (localEIPCConnection != null) {
      try
      {
        localEIPCConnection.callModule("__event_module", null, paramBundle, paramInt);
        return;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     eipc.EIPCClient
 * JD-Core Version:    0.7.0.1
 */