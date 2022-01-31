package com.tencent.mobileqq.nearby.ipc;

import aeed;
import aeee;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class NearbyProcess
{
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new aeed(this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public MainProcessInterface a;
  private NearbyProcManager jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcManager;
  public NearbyProcessInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public NearbyProcess(AppInterface paramAppInterface, NearbyProcManager paramNearbyProcManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcessInterface = new aeee(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcManager = paramNearbyProcManager;
  }
  
  public Message a(Message paramMessage)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface == null) || (paramMessage == null)) {}
    for (;;)
    {
      return null;
      try
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface != null) {
            break label49;
          }
          return null;
        }
        if (!QLog.isDevelopLevel()) {}
      }
      catch (RemoteException paramMessage) {}
    }
    paramMessage.printStackTrace();
    return null;
    label49:
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface.a(paramMessage);
    return paramMessage;
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ConnectNearbyProcService.class);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
  }
  
  public Object[] a(int paramInt)
  {
    return a(paramInt, new Object[0]);
  }
  
  public Object[] a(int paramInt, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface == null) {}
    for (;;)
    {
      return null;
      try
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface != null) {
            break label45;
          }
          return null;
        }
        if (!QLog.isDevelopLevel()) {}
      }
      catch (RemoteException paramVarArgs) {}
    }
    paramVarArgs.printStackTrace();
    return null;
    label45:
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface.a(new BasicTypeDataParcel(paramInt, paramVarArgs));
    if (paramVarArgs == null) {
      return null;
    }
    paramVarArgs = paramVarArgs.a;
    return paramVarArgs;
  }
  
  public Message b(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcManager != null) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcManager.a(paramMessage);
    }
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
  }
  
  public Object[] b(int paramInt, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcManager != null) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcManager.a(paramInt, paramVarArgs);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.NearbyProcess
 * JD-Core Version:    0.7.0.1
 */