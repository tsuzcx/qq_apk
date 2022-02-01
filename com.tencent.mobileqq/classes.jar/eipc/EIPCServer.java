package eipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;

public class EIPCServer
  extends EIPCModuleManager
{
  static volatile EIPCServer sServer;
  SparseArray<EIPCChannel> channelSparseArr = new SparseArray();
  ArrayList<EIPCConnection> clients = new ArrayList();
  AtomicInteger instanceCount = new AtomicInteger(1);
  
  public EIPCServer(Context paramContext)
  {
    super(paramContext);
  }
  
  public static EIPCServer getServer()
  {
    if (sServer == null) {
      try
      {
        if (sServer == null) {
          sServer = new EIPCServer(MobileQQ.sMobileQQ);
        }
      }
      finally {}
    }
    return sServer;
  }
  
  public EIPCResult callClient(String paramString1, int paramInt, String paramString2, String paramString3, Bundle paramBundle)
  {
    EIPCResult localEIPCResult = EIPCResult.UNKNOW_RESULT;
    if (paramBundle != null) {}
    try
    {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
      paramString1 = getClientConnection(paramString1, paramInt);
      if (paramString1 == null) {
        return EIPCResult.createResult(-1, null);
      }
      if (!paramString1.isAvailable()) {
        return EIPCResult.createResult(-2, null);
      }
      paramString1 = paramString1.callModule(paramString2, paramString3, paramBundle);
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
  
  public void callClient(String paramString1, int paramInt, String paramString2, String paramString3, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    EIPCResult localEIPCResult = EIPCResult.UNKNOW_RESULT;
    if (paramBundle != null) {}
    try
    {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
      paramString1 = getClientConnection(paramString1, paramInt);
      if (paramString1 == null)
      {
        paramString1 = EIPCResult.createResult(-1, null);
      }
      else if (!paramString1.isAvailable())
      {
        paramString1 = EIPCResult.createResult(-2, null);
      }
      else
      {
        paramString1.callModuleAsync(paramString2, paramString3, paramBundle, paramEIPCResultCallback);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = EIPCResult.createExceptionResult(paramString1);
    }
    catch (RemoteException paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = EIPCResult.createExceptionResult(paramString1);
    }
    if ((paramString1 != null) && (paramEIPCResultCallback != null)) {
      paramEIPCResultCallback.onCallback(paramString1);
    }
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    try
    {
      int i = paramInt / 1000000;
      paramInt %= 1000000;
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("callbackResult ");
        ((StringBuilder)???).append(i);
        ((StringBuilder)???).append(", ");
        ((StringBuilder)???).append(paramInt);
        QLog.i("EIPCConst", 2, ((StringBuilder)???).toString());
      }
      synchronized (this.channelSparseArr)
      {
        EIPCChannel localEIPCChannel = (EIPCChannel)this.channelSparseArr.get(i);
        if (localEIPCChannel != null)
        {
          localEIPCChannel.callback(paramInt, paramEIPCResult);
          return;
        }
      }
      return;
    }
    catch (Exception paramEIPCResult)
    {
      if (QLog.isColorLevel()) {
        QLog.w("EIPCConst", 2, "callbackResult error", paramEIPCResult);
      }
    }
  }
  
  public EIPCConnection getClientConnection(String paramString, int paramInt)
  {
    synchronized (this.clients)
    {
      Iterator localIterator = this.clients.iterator();
      while (localIterator.hasNext())
      {
        EIPCConnection localEIPCConnection = (EIPCConnection)localIterator.next();
        if ((TextUtils.equals(paramString, localEIPCConnection.procName)) && (paramInt == localEIPCConnection.clientId)) {
          return localEIPCConnection;
        }
      }
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public ArrayList<EIPCConnection> getClientConnectionList()
  {
    return new ArrayList(this.clients);
  }
  
  IBinder onServiceBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EIPCConst", 2, "EIPCServer onServiceBind");
    }
    return (IBinder)this.channel;
  }
  
  boolean onServiceUnbind(Intent arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EIPCConst", 2, "EIPCServer onServiceUnbind");
    }
    int i;
    synchronized (this.clients)
    {
      i = this.clients.size() - 1;
      if (i >= 0)
      {
        EIPCConnection localEIPCConnection = (EIPCConnection)this.clients.get(i);
        IBinder localIBinder = localEIPCConnection.channel.asBinder();
        if ((!localIBinder.isBinderAlive()) || (!localIBinder.pingBinder()))
        {
          this.clients.remove(i);
          notifyUnbind(localEIPCConnection);
        }
      }
      else
      {
        return true;
      }
    }
  }
  
  public void sendMsgToRemoteModule(int paramInt, Bundle paramBundle)
  {
    synchronized (this.clients)
    {
      Iterator localIterator = this.clients.iterator();
      while (localIterator.hasNext())
      {
        EIPCConnection localEIPCConnection = (EIPCConnection)localIterator.next();
        try
        {
          localEIPCConnection.callModule("__event_module", null, paramBundle, paramInt);
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramBundle;
    }
  }
  
  public int setClient(String paramString, int paramInt1, EIPCChannel paramEIPCChannel, int paramInt2)
  {
    ArrayList localArrayList = this.clients;
    if (paramEIPCChannel == null) {}
    try
    {
      paramInt1 = this.clients.size() - 1;
      if (paramInt1 >= 0)
      {
        paramEIPCChannel = (EIPCConnection)this.clients.get(paramInt1);
        ??? = paramEIPCChannel.channel.asBinder();
        if (((!((IBinder)???).isBinderAlive()) && (!((IBinder)???).pingBinder())) || ((TextUtils.equals(paramString, paramEIPCChannel.procName)) && (paramInt2 == paramEIPCChannel.clientId)))
        {
          this.clients.remove(paramInt1);
          notifyUnbind(paramEIPCChannel);
          break label288;
          paramString = new EIPCConnection(paramEIPCChannel, paramString);
          paramString.callbackManager = this;
          paramString.clientId = paramInt2;
          paramString.logMark = "EIPCClient";
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("EIPCServer setClient, ");
            ((StringBuilder)???).append(paramString);
            QLog.i("EIPCConst", 2, ((StringBuilder)???).toString());
          }
          this.clients.add(paramString);
          notifyBind(paramString);
          paramInt1 = this.instanceCount.addAndGet(1);
          synchronized (this.channelSparseArr)
          {
            this.channelSparseArr.put(paramInt1, paramEIPCChannel);
            ??? = new EIPCServer.ServerRecipient();
            ((EIPCServer.ServerRecipient)???).eipcServer = this;
            ((EIPCServer.ServerRecipient)???).connection = paramString;
            ((EIPCServer.ServerRecipient)???).binder = paramEIPCChannel.asBinder();
            paramEIPCChannel.asBinder().linkToDeath((IBinder.DeathRecipient)???, 0);
            return paramInt1;
          }
        }
      }
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw paramString;
        }
        label288:
        paramInt1 -= 1;
        continue;
        paramInt1 = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     eipc.EIPCServer
 * JD-Core Version:    0.7.0.1
 */