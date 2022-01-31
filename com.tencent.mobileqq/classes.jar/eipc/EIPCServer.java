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
  AtomicInteger a = new AtomicInteger(1);
  ArrayList b = new ArrayList();
  SparseArray c = new SparseArray();
  
  public EIPCServer(Context paramContext)
  {
    super(paramContext);
  }
  
  IBinder a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EIPCConst", 2, "EIPCServer onServiceBind");
    }
    return (IBinder)this.channel;
  }
  
  boolean b(Intent arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EIPCConst", 2, "EIPCServer onServiceUnbind");
    }
    for (;;)
    {
      int i;
      synchronized (this.b)
      {
        i = this.b.size() - 1;
        if (i >= 0)
        {
          EIPCConnection localEIPCConnection = (EIPCConnection)this.b.get(i);
          IBinder localIBinder = localEIPCConnection.d.asBinder();
          if ((!localIBinder.isBinderAlive()) || (!localIBinder.pingBinder()))
          {
            this.b.remove(i);
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
    synchronized (this.c)
    {
      try
      {
        int i = paramInt / 1000000;
        paramInt %= 1000000;
        if (QLog.isColorLevel()) {
          QLog.i("EIPCConst", 2, "callbackResult " + i + ", " + paramInt);
        }
        ((EIPCChannel)this.c.get(i)).callback(paramInt, paramEIPCResult);
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
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
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
  
  public ArrayList getClientConnectionList()
  {
    return new ArrayList(this.b);
  }
  
  public void sendMsgToRemoteModule(int paramInt, Bundle paramBundle)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
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
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	eipc/EIPCServer:b	Ljava/util/ArrayList;
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: aload_3
    //   10: ifnonnull +102 -> 112
    //   13: aload_0
    //   14: getfield 31	eipc/EIPCServer:b	Ljava/util/ArrayList;
    //   17: invokevirtual 69	java/util/ArrayList:size	()I
    //   20: iconst_1
    //   21: isub
    //   22: istore_2
    //   23: iload_2
    //   24: iflt +260 -> 284
    //   27: aload_0
    //   28: getfield 31	eipc/EIPCServer:b	Ljava/util/ArrayList;
    //   31: iload_2
    //   32: invokevirtual 73	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   35: checkcast 75	eipc/EIPCConnection
    //   38: astore_3
    //   39: aload_3
    //   40: getfield 78	eipc/EIPCConnection:d	Leipc/EIPCChannel;
    //   43: invokeinterface 84 1 0
    //   48: astore 6
    //   50: aload 6
    //   52: invokeinterface 87 1 0
    //   57: ifne +13 -> 70
    //   60: aload 6
    //   62: invokeinterface 90 1 0
    //   67: ifeq +23 -> 90
    //   70: aload_1
    //   71: aload_3
    //   72: getfield 212	eipc/EIPCConnection:procName	Ljava/lang/String;
    //   75: invokestatic 218	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   78: ifeq +199 -> 277
    //   81: iload 4
    //   83: aload_3
    //   84: getfield 222	eipc/EIPCConnection:clientId	I
    //   87: if_icmpne +190 -> 277
    //   90: aload_0
    //   91: getfield 31	eipc/EIPCServer:b	Ljava/util/ArrayList;
    //   94: iload_2
    //   95: invokevirtual 93	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   98: pop
    //   99: aload_0
    //   100: aload_3
    //   101: invokevirtual 97	eipc/EIPCServer:notifyUnbind	(Leipc/EIPCConnection;)V
    //   104: goto +173 -> 277
    //   107: aload 5
    //   109: monitorexit
    //   110: iload_2
    //   111: ireturn
    //   112: new 75	eipc/EIPCConnection
    //   115: dup
    //   116: aload_3
    //   117: aload_1
    //   118: invokespecial 261	eipc/EIPCConnection:<init>	(Leipc/EIPCChannel;Ljava/lang/String;)V
    //   121: astore_1
    //   122: aload_1
    //   123: aload_0
    //   124: putfield 264	eipc/EIPCConnection:c	Leipc/EIPCModuleManager;
    //   127: aload_1
    //   128: iload 4
    //   130: putfield 222	eipc/EIPCConnection:clientId	I
    //   133: aload_1
    //   134: ldc_w 266
    //   137: putfield 268	eipc/EIPCConnection:a	Ljava/lang/String;
    //   140: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +29 -> 172
    //   146: ldc 46
    //   148: iconst_2
    //   149: new 166	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 270
    //   159: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 52	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: getfield 31	eipc/EIPCServer:b	Ljava/util/ArrayList;
    //   176: aload_1
    //   177: invokevirtual 277	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   180: pop
    //   181: aload_0
    //   182: aload_1
    //   183: invokevirtual 278	eipc/EIPCServer:notifyBind	(Leipc/EIPCConnection;)V
    //   186: aload_0
    //   187: getfield 24	eipc/EIPCServer:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   190: iconst_1
    //   191: invokevirtual 282	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   194: istore_2
    //   195: aload_0
    //   196: getfield 36	eipc/EIPCServer:c	Landroid/util/SparseArray;
    //   199: astore 6
    //   201: aload 6
    //   203: monitorenter
    //   204: aload_0
    //   205: getfield 36	eipc/EIPCServer:c	Landroid/util/SparseArray;
    //   208: iload_2
    //   209: aload_3
    //   210: invokevirtual 286	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   213: aload 6
    //   215: monitorexit
    //   216: new 6	eipc/EIPCServer$ServerRecipient
    //   219: dup
    //   220: invokespecial 287	eipc/EIPCServer$ServerRecipient:<init>	()V
    //   223: astore 6
    //   225: aload 6
    //   227: aload_0
    //   228: putfield 291	eipc/EIPCServer$ServerRecipient:eipcServer	Leipc/EIPCServer;
    //   231: aload 6
    //   233: aload_1
    //   234: putfield 295	eipc/EIPCServer$ServerRecipient:connection	Leipc/EIPCConnection;
    //   237: aload 6
    //   239: aload_3
    //   240: invokeinterface 84 1 0
    //   245: putfield 299	eipc/EIPCServer$ServerRecipient:binder	Landroid/os/IBinder;
    //   248: aload_3
    //   249: invokeinterface 84 1 0
    //   254: aload 6
    //   256: iconst_0
    //   257: invokeinterface 303 3 0
    //   262: goto -155 -> 107
    //   265: astore_1
    //   266: aload 5
    //   268: monitorexit
    //   269: aload_1
    //   270: athrow
    //   271: astore_1
    //   272: aload 6
    //   274: monitorexit
    //   275: aload_1
    //   276: athrow
    //   277: iload_2
    //   278: iconst_1
    //   279: isub
    //   280: istore_2
    //   281: goto -258 -> 23
    //   284: iconst_m1
    //   285: istore_2
    //   286: goto -179 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	EIPCServer
    //   0	289	1	paramString	String
    //   0	289	2	paramInt1	int
    //   0	289	3	paramEIPCChannel	EIPCChannel
    //   0	289	4	paramInt2	int
    //   4	263	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   13	23	265	finally
    //   27	70	265	finally
    //   70	90	265	finally
    //   90	104	265	finally
    //   107	110	265	finally
    //   112	172	265	finally
    //   172	204	265	finally
    //   216	262	265	finally
    //   266	269	265	finally
    //   275	277	265	finally
    //   204	216	271	finally
    //   272	275	271	finally
  }
  
  public static class ServerRecipient
    implements IBinder.DeathRecipient
  {
    public IBinder binder;
    public EIPCConnection connection;
    public EIPCServer eipcServer;
    
    public void binderDied()
    {
      synchronized (this.eipcServer.b)
      {
        if (this.eipcServer.b.remove(this.connection)) {
          this.eipcServer.notifyUnbind(this.connection);
        }
        this.binder.unlinkToDeath(this, 0);
        if (QLog.isColorLevel()) {
          QLog.d("EIPCConst", 2, "ServerRecipient " + this.connection);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCServer
 * JD-Core Version:    0.7.0.1
 */