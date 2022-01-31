package eipc;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class EIPCClient
  extends EIPCModuleManager
{
  Class a;
  String b;
  int c;
  EIPCConnection d = null;
  ArrayList e = new ArrayList();
  ServiceConnection f = new EIPCClient.1(this);
  public ArrayList guardServerProcList = new ArrayList();
  
  public EIPCClient(Context paramContext, Class paramClass, int paramInt)
  {
    super(paramContext);
    if (paramClass == null) {
      throw new IllegalArgumentException("EIPCClient Class null");
    }
    this.a = paramClass;
    this.c = paramInt;
  }
  
  public EIPCClient(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("EIPCClient action null");
    }
    this.b = paramString;
    this.c = paramInt;
  }
  
  public EIPCResult callServer(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    }
    Object localObject = EIPCResult.UNKNOW_RESULT;
    try
    {
      localObject = this.d;
      if (localObject == null) {
        return EIPCResult.createResult(-1, null);
      }
      if (!((EIPCConnection)localObject).isAvailable()) {
        return EIPCResult.createResult(-2, null);
      }
      paramString1 = ((EIPCConnection)localObject).callModule(paramString1, paramString2, paramBundle, -99999);
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
  
  public void callServer(String paramString1, String paramString2, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    connect(new EIPCClient.2(this, paramBundle, paramString1, paramString2, paramEIPCResultCallback));
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    try
    {
      this.d.d.callback(paramInt % 1000000, paramEIPCResult);
      return;
    }
    catch (Exception paramEIPCResult)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("EIPCConst", 2, "callbackResult error", paramEIPCResult);
    }
  }
  
  /* Error */
  public void connect(EIPClientConnectListener paramEIPClientConnectListener)
  {
    // Byte code:
    //   0: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 151
    //   8: iconst_2
    //   9: ldc 159
    //   11: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 27	eipc/EIPCClient:d	Leipc/EIPCConnection;
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull +37 -> 57
    //   23: aload_2
    //   24: getfield 138	eipc/EIPCConnection:d	Leipc/EIPCChannel;
    //   27: invokeinterface 166 1 0
    //   32: invokeinterface 171 1 0
    //   37: ifeq +20 -> 57
    //   40: aload_2
    //   41: getfield 138	eipc/EIPCConnection:d	Leipc/EIPCChannel;
    //   44: invokeinterface 166 1 0
    //   49: invokeinterface 174 1 0
    //   54: ifne +95 -> 149
    //   57: aload_1
    //   58: ifnull +12 -> 70
    //   61: aload_0
    //   62: getfield 34	eipc/EIPCClient:e	Ljava/util/ArrayList;
    //   65: aload_1
    //   66: invokevirtual 178	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   69: pop
    //   70: aload_0
    //   71: getfield 182	eipc/EIPCClient:mContext	Landroid/content/Context;
    //   74: astore_2
    //   75: aload_0
    //   76: getfield 52	eipc/EIPCClient:a	Ljava/lang/Class;
    //   79: ifnull +28 -> 107
    //   82: new 184	android/content/Intent
    //   85: dup
    //   86: aload_2
    //   87: aload_0
    //   88: getfield 52	eipc/EIPCClient:a	Ljava/lang/Class;
    //   91: invokespecial 187	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   94: astore_1
    //   95: aload_2
    //   96: aload_1
    //   97: aload_0
    //   98: getfield 43	eipc/EIPCClient:f	Landroid/content/ServiceConnection;
    //   101: iconst_1
    //   102: invokevirtual 193	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   105: pop
    //   106: return
    //   107: new 184	android/content/Intent
    //   110: dup
    //   111: aload_0
    //   112: getfield 66	eipc/EIPCClient:b	Ljava/lang/String;
    //   115: invokespecial 194	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   118: astore_1
    //   119: goto -24 -> 95
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 121	java/lang/Throwable:printStackTrace	()V
    //   127: return
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 195	java/lang/Exception:printStackTrace	()V
    //   133: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq -30 -> 106
    //   139: ldc 151
    //   141: iconst_2
    //   142: ldc 197
    //   144: aload_1
    //   145: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: return
    //   149: aload_1
    //   150: ifnull -44 -> 106
    //   153: aload_1
    //   154: aload_0
    //   155: getfield 27	eipc/EIPCClient:d	Leipc/EIPCConnection;
    //   158: invokeinterface 205 2 0
    //   163: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	EIPCClient
    //   0	164	1	paramEIPClientConnectListener	EIPClientConnectListener
    //   18	78	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	19	122	java/lang/Throwable
    //   23	57	122	java/lang/Throwable
    //   61	70	122	java/lang/Throwable
    //   70	95	122	java/lang/Throwable
    //   95	106	122	java/lang/Throwable
    //   107	119	122	java/lang/Throwable
    //   129	148	122	java/lang/Throwable
    //   153	163	122	java/lang/Throwable
    //   95	106	128	java/lang/Exception
  }
  
  public void disConnect()
  {
    ServiceConnection localServiceConnection = this.f;
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, "EIPCClient.disConnect," + localServiceConnection);
    }
    EIPCConnection localEIPCConnection = this.d;
    if ((localServiceConnection != null) && (localEIPCConnection != null)) {}
    try
    {
      localEIPCConnection.d.setClient(MobileQQ.processName, Process.myPid(), null, this.c);
      this.mContext.unbindService(localServiceConnection);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("EIPCConst", 2, "EIPCClient unbindService", localException);
    }
  }
  
  public void sendMessageToRemote(int paramInt, Bundle paramBundle)
  {
    EIPCConnection localEIPCConnection = this.d;
    if (localEIPCConnection != null) {}
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
  
  public static class ClientDeathRecipient
    implements IBinder.DeathRecipient
  {
    public IBinder binder;
    public EIPCConnection connection;
    public EIPCClient eipcClient;
    
    public void binderDied()
    {
      if (this.eipcClient != null) {
        this.eipcClient.connect(new EIPCClient.ClientDeathRecipient.1(this));
      }
      if (QLog.isColorLevel()) {
        QLog.d("EIPCConst", 2, "client binderDied, " + this.connection);
      }
      this.binder.unlinkToDeath(this, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCClient
 * JD-Core Version:    0.7.0.1
 */