package dov.com.tencent.mobileqq.richmedia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import aokx;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import mqq.app.AppService;

public class RichmediaService
  extends AppService
  implements Handler.Callback, RichmediaIPCConstants
{
  static volatile WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  static volatile RichmediaService jdField_a_of_type_DovComTencentMobileqqRichmediaRichmediaService;
  Messenger jdField_a_of_type_AndroidOsMessenger;
  aokx jdField_a_of_type_Aokx;
  public volatile ICallBack a;
  public Messenger b;
  
  public static RichmediaService a()
  {
    return jdField_a_of_type_DovComTencentMobileqqRichmediaRichmediaService;
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    LOG.a("RichmediaService", "sendToClient,msgCode = " + paramInt1 + ",subCmd = " + paramInt2 + ",data = " + paramBundle);
    if (this.b == null)
    {
      LOG.b("RichmediaService", "sendToClient failed. mClient is null");
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
      LOG.b("RichmediaService", "sendToClient failed. e = " + paramBundle);
    }
  }
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[onBind]");
    }
    return this.jdField_a_of_type_AndroidOsMessenger.getBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Aokx = new aokx(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Aokx);
    jdField_a_of_type_DovComTencentMobileqqRichmediaRichmediaService = this;
    jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[onCreate]");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Aokx = null;
    jdField_a_of_type_DovComTencentMobileqqRichmediaRichmediaService = null;
    jdField_a_of_type_ComTencentUtilWeakReferenceHandler = null;
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[onDestroy]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.RichmediaService
 * JD-Core Version:    0.7.0.1
 */