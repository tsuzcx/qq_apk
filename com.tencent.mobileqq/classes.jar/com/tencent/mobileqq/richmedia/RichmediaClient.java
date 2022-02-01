package com.tencent.mobileqq.richmedia;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicBoolean;

public class RichmediaClient
  implements RichmediaIPCConstants
{
  static volatile RichmediaClient jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaClient;
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  Messenger jdField_a_of_type_AndroidOsMessenger;
  ICallBack jdField_a_of_type_ComTencentMobileqqRichmediaICallBack;
  RichmediaClient.IncomingHandler jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaClient$IncomingHandler;
  VideoCompoundController jdField_a_of_type_ComTencentMobileqqRichmediaVideoCompoundController;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  Messenger b;
  
  private RichmediaClient()
  {
    LOG.a("PTV.RichmediaClient", "RichmediaClient");
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("RichmediaClientWorkerThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaClient$IncomingHandler = new RichmediaClient.IncomingHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaClient$IncomingHandler);
    this.jdField_a_of_type_AndroidContentServiceConnection = new RichmediaClient.1(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaICallBack = new RichmediaClient.2(this);
  }
  
  public static RichmediaClient a()
  {
    LOG.a("PTV.RichmediaClient", "getInstance");
    if (jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaClient == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaClient == null) {
          jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaClient = new RichmediaClient();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaClient;
  }
  
  public VideoCompoundController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaVideoCompoundController == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaVideoCompoundController = new VideoCompoundController();
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaVideoCompoundController;
  }
  
  public void a(Context paramContext)
  {
    LOG.a("PTV.RichmediaClient", "bindService");
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      try
      {
        paramContext.bindService(new Intent(paramContext, RichmediaService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      }
      catch (SecurityException paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("bindService failed. e = ");
        localStringBuilder.append(paramContext);
        LOG.b("PTV.RichmediaClient", localStringBuilder.toString());
      }
      LOG.a("PTV.RichmediaClient", "bindService,bingding");
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendToService,msgCode = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",subCmd = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(",data = ");
    ((StringBuilder)localObject).append(paramBundle);
    LOG.a("PTV.RichmediaClient", ((StringBuilder)localObject).toString());
    if (this.b == null)
    {
      LOG.b("PTV.RichmediaClient", "sendToService failed. mService is null ");
      return false;
    }
    localObject = Message.obtain(null, paramInt1);
    if (paramBundle != null) {
      paramBundle.putInt("msg_sub_cmd", paramInt2);
    }
    ((Message)localObject).setData(paramBundle);
    try
    {
      this.b.send((Message)localObject);
      return true;
    }
    catch (RemoteException paramBundle)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendToService failed. e = ");
      ((StringBuilder)localObject).append(paramBundle);
      LOG.b("PTV.RichmediaClient", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  /* Error */
  public void b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 29
    //   2: ldc 176
    //   4: invokestatic 36	com/tencent/mobileqq/richmedia/LOG:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   7: pop
    //   8: aload_0
    //   9: getfield 27	com/tencent/mobileqq/richmedia/RichmediaClient:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   12: iconst_1
    //   13: iconst_0
    //   14: invokevirtual 100	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   17: ifeq +49 -> 66
    //   20: aload_0
    //   21: iconst_2
    //   22: iconst_m1
    //   23: aconst_null
    //   24: invokevirtual 178	com/tencent/mobileqq/richmedia/RichmediaClient:a	(IILandroid/os/Bundle;)Z
    //   27: pop
    //   28: aload_1
    //   29: aload_0
    //   30: getfield 73	com/tencent/mobileqq/richmedia/RichmediaClient:jdField_a_of_type_AndroidContentServiceConnection	Landroid/content/ServiceConnection;
    //   33: invokevirtual 181	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 146	com/tencent/mobileqq/richmedia/RichmediaClient:b	Landroid/os/Messenger;
    //   41: return
    //   42: astore_1
    //   43: goto +16 -> 59
    //   46: astore_1
    //   47: ldc 29
    //   49: iconst_1
    //   50: ldc 183
    //   52: aload_1
    //   53: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   56: goto -20 -> 36
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 146	com/tencent/mobileqq/richmedia/RichmediaClient:b	Landroid/os/Messenger;
    //   64: aload_1
    //   65: athrow
    //   66: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	RichmediaClient
    //   0	67	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   20	36	42	finally
    //   47	56	42	finally
    //   20	36	46	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaClient
 * JD-Core Version:    0.7.0.1
 */