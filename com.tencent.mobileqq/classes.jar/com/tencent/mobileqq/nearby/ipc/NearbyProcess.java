package com.tencent.mobileqq.nearby.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class NearbyProcess
{
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new NearbyProcess.1(this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private INearbyProcManager jdField_a_of_type_ComTencentMobileqqNearbyIpcINearbyProcManager;
  MainProcessInterface jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface;
  NearbyProcessInterface jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcessInterface = new NearbyProcess.2(this);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public NearbyProcess() {}
  
  public NearbyProcess(AppInterface paramAppInterface, INearbyProcManager paramINearbyProcManager)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyIpcINearbyProcManager = paramINearbyProcManager;
  }
  
  public Message a(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface != null)
    {
      if (paramMessage == null) {
        return null;
      }
      try
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface == null) {
            return null;
          }
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface.a(paramMessage);
          return paramMessage;
        }
        return null;
      }
      catch (RemoteException paramMessage)
      {
        if (QLog.isDevelopLevel()) {
          paramMessage.printStackTrace();
        }
      }
    }
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ConnectNearbyProcService.class);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "bindService");
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface != null;
  }
  
  public Object[] a(int paramInt)
  {
    return a(paramInt, new Object[0]);
  }
  
  public Object[] a(int paramInt, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface == null) {
      return null;
    }
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface == null) {
          return null;
        }
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface.a(new BasicTypeDataParcel(paramInt, paramVarArgs));
        if (paramVarArgs == null) {
          return null;
        }
        paramVarArgs = paramVarArgs.a;
        return paramVarArgs;
      }
      return null;
    }
    catch (RemoteException paramVarArgs)
    {
      if (QLog.isDevelopLevel()) {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  Message b(Message paramMessage)
  {
    INearbyProcManager localINearbyProcManager = this.jdField_a_of_type_ComTencentMobileqqNearbyIpcINearbyProcManager;
    if (localINearbyProcManager != null) {
      return localINearbyProcManager.a(paramMessage);
    }
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
  }
  
  Object[] b(int paramInt, Object... paramVarArgs)
  {
    INearbyProcManager localINearbyProcManager = this.jdField_a_of_type_ComTencentMobileqqNearbyIpcINearbyProcManager;
    if (localINearbyProcManager != null) {
      return localINearbyProcManager.a(paramInt, paramVarArgs);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.NearbyProcess
 * JD-Core Version:    0.7.0.1
 */