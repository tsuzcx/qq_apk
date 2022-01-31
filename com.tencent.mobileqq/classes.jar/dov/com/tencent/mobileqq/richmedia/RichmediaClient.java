package dov.com.tencent.mobileqq.richmedia;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import aotn;
import aoto;
import aotp;
import java.util.concurrent.atomic.AtomicBoolean;

public class RichmediaClient
  implements RichmediaIPCConstants
{
  static volatile RichmediaClient jdField_a_of_type_DovComTencentMobileqqRichmediaRichmediaClient;
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  aotp jdField_a_of_type_Aotp;
  public ICallBack a;
  VideoCompoundController jdField_a_of_type_DovComTencentMobileqqRichmediaVideoCompoundController;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public Messenger b;
  
  private RichmediaClient()
  {
    LOG.a("PTV.RichmediaClient", "RichmediaClient");
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("RichmediaClientWorkerThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Aotp = new aotp(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Aotp);
    this.jdField_a_of_type_AndroidContentServiceConnection = new aotn(this);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaICallBack = new aoto(this);
  }
  
  public static RichmediaClient a()
  {
    LOG.a("PTV.RichmediaClient", "getInstance");
    if (jdField_a_of_type_DovComTencentMobileqqRichmediaRichmediaClient == null) {}
    try
    {
      if (jdField_a_of_type_DovComTencentMobileqqRichmediaRichmediaClient == null) {
        jdField_a_of_type_DovComTencentMobileqqRichmediaRichmediaClient = new RichmediaClient();
      }
      return jdField_a_of_type_DovComTencentMobileqqRichmediaRichmediaClient;
    }
    finally {}
  }
  
  public VideoCompoundController a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaVideoCompoundController == null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaVideoCompoundController = new VideoCompoundController();
    }
    return this.jdField_a_of_type_DovComTencentMobileqqRichmediaVideoCompoundController;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.RichmediaClient
 * JD-Core Version:    0.7.0.1
 */