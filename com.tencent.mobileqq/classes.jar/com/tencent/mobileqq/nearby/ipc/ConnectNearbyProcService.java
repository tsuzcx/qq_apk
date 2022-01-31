package com.tencent.mobileqq.nearby.ipc;

import aezq;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class ConnectNearbyProcService
  extends AppService
{
  private static NearbyProcessInterface jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcessInterface;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private NearbyProxy jdField_a_of_type_ComTencentMobileqqNearbyNearbyProxy;
  private MainProcessInterface jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface = new aezq(this);
  
  public static Message a(Message paramMessage)
  {
    if ((jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcessInterface == null) || (paramMessage == null)) {
      return null;
    }
    try
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcessInterface == null) {
          return null;
        }
      }
      paramMessage = jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcessInterface.a(paramMessage);
    }
    catch (RemoteException paramMessage)
    {
      paramMessage.printStackTrace();
      return null;
    }
    return paramMessage;
  }
  
  private void a()
  {
    if ((this.app == null) || (!(this.app instanceof QQAppInterface))) {
      throw new IllegalArgumentException("not QQAppInterface. wrong.");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyProxy = ((QQAppInterface)this.app).a();
  }
  
  public static boolean a()
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcessInterface != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public static Object[] a(int paramInt)
  {
    return a(paramInt, new Object[0]);
  }
  
  public static Object[] a(int paramInt, Object... paramVarArgs)
  {
    if (jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcessInterface == null) {
      return null;
    }
    try
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcessInterface == null) {
          return null;
        }
      }
      paramVarArgs = jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcessInterface.a(new BasicTypeDataParcel(paramInt, paramVarArgs));
    }
    catch (RemoteException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
      return null;
    }
    if (paramVarArgs == null) {
      return null;
    }
    paramVarArgs = paramVarArgs.a;
    return paramVarArgs;
  }
  
  private Message b(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyProxy != null) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyProxy.a(this, paramMessage);
    }
    return null;
  }
  
  private Object[] b(int paramInt, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyProxy != null) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyProxy.a(this, paramInt, paramVarArgs);
    }
    return null;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    a();
    return this.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface.asBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcessInterface = null;
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, "ConnectNearbyProcService onUnbind.");
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyProxy = null;
      return super.onUnbind(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService
 * JD-Core Version:    0.7.0.1
 */