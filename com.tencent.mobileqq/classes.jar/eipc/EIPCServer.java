package eipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
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
    if (sServer == null) {}
    try
    {
      if (sServer == null) {
        sServer = new EIPCServer(MobileQQ.sMobileQQ);
      }
      return sServer;
    }
    finally {}
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
    catch (RemoteException paramString1)
    {
      paramString1.printStackTrace();
      return EIPCResult.createExceptionResult(paramString1);
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return EIPCResult.createExceptionResult(paramString1);
  }
  
  public void callClient(String paramString1, int paramInt, String paramString2, String paramString3, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    EIPCResult localEIPCResult = EIPCResult.UNKNOW_RESULT;
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
        paramString1 = getClientConnection(paramString1, paramInt);
        if (paramString1 != null) {
          continue;
        }
        paramString1 = EIPCResult.createResult(-1, null);
      }
      catch (RemoteException paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = EIPCResult.createExceptionResult(paramString1);
        continue;
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = EIPCResult.createExceptionResult(paramString1);
        continue;
      }
      if ((paramString1 != null) && (paramEIPCResultCallback != null)) {
        paramEIPCResultCallback.onCallback(paramString1);
      }
      return;
      if (paramString1.isAvailable()) {
        continue;
      }
      paramString1 = EIPCResult.createResult(-2, null);
    }
    paramString1.callModuleAsync(paramString2, paramString3, paramBundle, paramEIPCResultCallback);
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    synchronized (this.channelSparseArr)
    {
      try
      {
        int i = paramInt / 1000000;
        paramInt %= 1000000;
        if (QLog.isColorLevel()) {
          QLog.i("EIPCConst", 2, "callbackResult " + i + ", " + paramInt);
        }
        ((EIPCChannel)this.channelSparseArr.get(i)).callback(paramInt, paramEIPCResult);
      }
      catch (Exception paramEIPCResult)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("EIPCConst", 2, "callbackResult error", paramEIPCResult);
          }
        }
      }
      return;
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
    for (;;)
    {
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
      i -= 1;
    }
  }
  
  public void sendMsgToRemoteModule(int paramInt, Bundle paramBundle)
  {
    synchronized (this.clients)
    {
      Iterator localIterator = this.clients.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
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
      }
    }
  }
  
  /* Error */
  public int setClient(String paramString, int paramInt1, EIPCChannel paramEIPCChannel, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 32	eipc/EIPCServer:clients	Ljava/util/ArrayList;
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: aload_3
    //   10: ifnonnull +102 -> 112
    //   13: aload_0
    //   14: getfield 32	eipc/EIPCServer:clients	Ljava/util/ArrayList;
    //   17: invokevirtual 209	java/util/ArrayList:size	()I
    //   20: iconst_1
    //   21: isub
    //   22: istore_2
    //   23: iload_2
    //   24: iflt +258 -> 282
    //   27: aload_0
    //   28: getfield 32	eipc/EIPCServer:clients	Ljava/util/ArrayList;
    //   31: iload_2
    //   32: invokevirtual 210	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   35: checkcast 81	eipc/EIPCConnection
    //   38: astore_3
    //   39: aload_3
    //   40: getfield 211	eipc/EIPCConnection:channel	Leipc/EIPCChannel;
    //   43: invokeinterface 215 1 0
    //   48: astore 6
    //   50: aload 6
    //   52: invokeinterface 218 1 0
    //   57: ifne +13 -> 70
    //   60: aload 6
    //   62: invokeinterface 221 1 0
    //   67: ifeq +23 -> 90
    //   70: aload_1
    //   71: aload_3
    //   72: getfield 174	eipc/EIPCConnection:procName	Ljava/lang/String;
    //   75: invokestatic 180	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   78: ifeq +197 -> 275
    //   81: iload 4
    //   83: aload_3
    //   84: getfield 184	eipc/EIPCConnection:clientId	I
    //   87: if_icmpne +188 -> 275
    //   90: aload_0
    //   91: getfield 32	eipc/EIPCServer:clients	Ljava/util/ArrayList;
    //   94: iload_2
    //   95: invokevirtual 224	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   98: pop
    //   99: aload_0
    //   100: aload_3
    //   101: invokevirtual 228	eipc/EIPCServer:notifyUnbind	(Leipc/EIPCConnection;)V
    //   104: goto +171 -> 275
    //   107: aload 5
    //   109: monitorexit
    //   110: iload_2
    //   111: ireturn
    //   112: new 81	eipc/EIPCConnection
    //   115: dup
    //   116: aload_3
    //   117: aload_1
    //   118: invokespecial 240	eipc/EIPCConnection:<init>	(Leipc/EIPCChannel;Ljava/lang/String;)V
    //   121: astore_1
    //   122: aload_1
    //   123: aload_0
    //   124: putfield 244	eipc/EIPCConnection:callbackManager	Leipc/EIPCModuleManager;
    //   127: aload_1
    //   128: iload 4
    //   130: putfield 184	eipc/EIPCConnection:clientId	I
    //   133: aload_1
    //   134: ldc 246
    //   136: putfield 249	eipc/EIPCConnection:logMark	Ljava/lang/String;
    //   139: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +28 -> 170
    //   145: ldc 120
    //   147: iconst_2
    //   148: new 122	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   155: ldc 251
    //   157: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_1
    //   161: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 142	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_0
    //   171: getfield 32	eipc/EIPCServer:clients	Ljava/util/ArrayList;
    //   174: aload_1
    //   175: invokevirtual 258	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   178: pop
    //   179: aload_0
    //   180: aload_1
    //   181: invokevirtual 261	eipc/EIPCServer:notifyBind	(Leipc/EIPCConnection;)V
    //   184: aload_0
    //   185: getfield 25	eipc/EIPCServer:instanceCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   188: iconst_1
    //   189: invokevirtual 265	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   192: istore_2
    //   193: aload_0
    //   194: getfield 37	eipc/EIPCServer:channelSparseArr	Landroid/util/SparseArray;
    //   197: astore 6
    //   199: aload 6
    //   201: monitorenter
    //   202: aload_0
    //   203: getfield 37	eipc/EIPCServer:channelSparseArr	Landroid/util/SparseArray;
    //   206: iload_2
    //   207: aload_3
    //   208: invokevirtual 269	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   211: aload 6
    //   213: monitorexit
    //   214: new 271	eipc/EIPCServer$ServerRecipient
    //   217: dup
    //   218: invokespecial 272	eipc/EIPCServer$ServerRecipient:<init>	()V
    //   221: astore 6
    //   223: aload 6
    //   225: aload_0
    //   226: putfield 275	eipc/EIPCServer$ServerRecipient:eipcServer	Leipc/EIPCServer;
    //   229: aload 6
    //   231: aload_1
    //   232: putfield 279	eipc/EIPCServer$ServerRecipient:connection	Leipc/EIPCConnection;
    //   235: aload 6
    //   237: aload_3
    //   238: invokeinterface 215 1 0
    //   243: putfield 283	eipc/EIPCServer$ServerRecipient:binder	Landroid/os/IBinder;
    //   246: aload_3
    //   247: invokeinterface 215 1 0
    //   252: aload 6
    //   254: iconst_0
    //   255: invokeinterface 287 3 0
    //   260: goto -153 -> 107
    //   263: astore_1
    //   264: aload 5
    //   266: monitorexit
    //   267: aload_1
    //   268: athrow
    //   269: astore_1
    //   270: aload 6
    //   272: monitorexit
    //   273: aload_1
    //   274: athrow
    //   275: iload_2
    //   276: iconst_1
    //   277: isub
    //   278: istore_2
    //   279: goto -256 -> 23
    //   282: iconst_m1
    //   283: istore_2
    //   284: goto -177 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	EIPCServer
    //   0	287	1	paramString	String
    //   0	287	2	paramInt1	int
    //   0	287	3	paramEIPCChannel	EIPCChannel
    //   0	287	4	paramInt2	int
    //   4	261	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   13	23	263	finally
    //   27	70	263	finally
    //   70	90	263	finally
    //   90	104	263	finally
    //   107	110	263	finally
    //   112	170	263	finally
    //   170	202	263	finally
    //   214	260	263	finally
    //   264	267	263	finally
    //   273	275	263	finally
    //   202	214	269	finally
    //   270	273	269	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCServer
 * JD-Core Version:    0.7.0.1
 */