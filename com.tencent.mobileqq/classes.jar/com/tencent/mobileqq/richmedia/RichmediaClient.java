package com.tencent.mobileqq.richmedia;

import ahlc;
import ahld;
import ahle;
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
  ahle jdField_a_of_type_Ahle;
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  public ICallBack a;
  VideoCompoundController jdField_a_of_type_ComTencentMobileqqRichmediaVideoCompoundController;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public Messenger b;
  
  private RichmediaClient()
  {
    LOG.a("PTV.RichmediaClient", "RichmediaClient");
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("RichmediaClientWorkerThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Ahle = new ahle(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Ahle);
    this.jdField_a_of_type_AndroidContentServiceConnection = new ahlc(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaICallBack = new ahld(this);
  }
  
  public static RichmediaClient a()
  {
    LOG.a("PTV.RichmediaClient", "getInstance");
    if (jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaClient == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaClient == null) {
        jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaClient = new RichmediaClient();
      }
      return jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaClient;
    }
    finally {}
  }
  
  public VideoCompoundController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaVideoCompoundController == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaVideoCompoundController = new VideoCompoundController();
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaVideoCompoundController;
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    LOG.a("PTV.RichmediaClient", "sendToService,msgCode = " + paramInt1 + ",subCmd = " + paramInt2 + ",data = " + paramBundle);
    if (this.b == null)
    {
      LOG.b("PTV.RichmediaClient", "sendToService failed. mService is null ");
      return;
    }
    Message localMessage = Message.obtain(null, paramInt1);
    if (paramBundle != null) {
      paramBundle.putInt("msg_sub_cmd", paramInt2);
    }
    localMessage.setData(paramBundle);
    try
    {
      this.b.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      LOG.b("PTV.RichmediaClient", "sendToService failed. e = " + paramBundle);
    }
  }
  
  public void a(Context paramContext)
  {
    LOG.a("PTV.RichmediaClient", "bindService");
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {}
    try
    {
      paramContext.bindService(new Intent(paramContext, RichmediaService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      LOG.a("PTV.RichmediaClient", "bindService,bingding");
      return;
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        LOG.b("PTV.RichmediaClient", "bindService failed. e = " + paramContext);
      }
    }
  }
  
  public void b(Context paramContext)
  {
    LOG.a("PTV.RichmediaClient", "unbindService");
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      a(2, -1, null);
      paramContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaClient
 * JD-Core Version:    0.7.0.1
 */