package com.tencent.mobileqq.richmedia;

import ahgo;
import ahgp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.util.WeakReferenceHandler;
import mqq.app.AppService;

public class RichmediaService
  extends AppService
  implements Handler.Callback, RichmediaIPCConstants
{
  public static volatile RichmediaService a;
  static volatile WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  ahgp jdField_a_of_type_Ahgp;
  Messenger jdField_a_of_type_AndroidOsMessenger;
  public volatile ICallBack a;
  public Messenger b;
  
  public static RichmediaService a()
  {
    return jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
  }
  
  static void a(int paramInt, Bundle paramBundle)
  {
    LOG.a("RichmediaService", "sendICallBackRequest start . cmd = " + paramInt + ",data = " + paramBundle);
    WeakReferenceHandler localWeakReferenceHandler = jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localWeakReferenceHandler != null)
    {
      localWeakReferenceHandler.post(new ahgo(paramInt, paramBundle));
      return;
    }
    LOG.a("RichmediaService", "sendICallBackRequest subHandler is null");
  }
  
  public static void a(Bundle paramBundle)
  {
    LOG.a("RichmediaService", "initPresend. ");
    a(2, paramBundle);
  }
  
  public static void a(CompressInfo paramCompressInfo)
  {
    LOG.a("RichmediaService", "startCompress start . compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.srcPath = " + paramCompressInfo.c);
    Object localObject = jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
    int i = 0;
    if (localObject != null)
    {
      localObject = ((RichmediaService)localObject).jdField_a_of_type_ComTencentMobileqqRichmediaICallBack;
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        LOG.a("RichmediaService", "startCompress cb.compress start . compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.srcPath = " + paramCompressInfo.c);
        ((ICallBack)localObject).a(paramCompressInfo);
        LOG.a("RichmediaService", "startCompress cb.compress finish. compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.dstPath = " + paramCompressInfo.e);
        if (i != 0)
        {
          LOG.a("RichmediaService", "startCompress compressInMainProcess start . compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.srcPath = " + paramCompressInfo.c);
          CompressOperator.a(paramCompressInfo);
          LOG.a("RichmediaService", "startCompress compressInMainProcess finish. compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.dstPath = " + paramCompressInfo.e);
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        LOG.a("RichmediaService", "startCompress cb.compress ipc fail,compressInfo.localUUID = " + paramCompressInfo.a + ",compress in main process, RemoteException : " + localRemoteException.getMessage());
        i = 1;
        continue;
      }
      LOG.a("RichmediaService", "startCompress service.mClientCallBack is null,compressInfo.localUUID = " + paramCompressInfo.a + ",compress in main process");
      i = 1;
      continue;
      LOG.a("RichmediaService", "startCompress Richmedia Service is null,compressInfo.localUUID = " + paramCompressInfo.a + ",compress in main process");
      i = 1;
    }
  }
  
  public static boolean a(Intent paramIntent)
  {
    LOG.a("RichmediaService", "addPresendMgrHandlerToIntent start .");
    Object localObject = jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
    if (localObject != null)
    {
      localObject = ((RichmediaService)localObject).jdField_a_of_type_ComTencentMobileqqRichmediaICallBack;
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        LOG.a("RichmediaService", "addPresendMgrHandlerToIntent cb.getData start . ");
        localObject = ((ICallBack)localObject).a(16, null);
      }
      catch (RemoteException localRemoteException1)
      {
        BinderWarpper localBinderWarpper;
        int i;
        int j;
        localObject = null;
      }
      try
      {
        LOG.a("RichmediaService", "addPresendMgrHandlerToIntent cb.getData finish. ");
        if (localObject == null) {
          break;
        }
        ((Bundle)localObject).setClassLoader(RichmediaService.class.getClassLoader());
        localBinderWarpper = (BinderWarpper)((Bundle)localObject).getParcelable("key_presend_mgr_handler");
        if (localBinderWarpper == null) {
          break;
        }
        i = ((Bundle)localObject).getInt("PhotoConst.PHOTO_COUNT");
        j = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", -1);
        LOG.a("RichmediaService", "presend req count = " + i + ", send count = " + j);
        if (i == j) {
          break label273;
        }
        paramIntent = new Bundle();
        paramIntent.putInt("key_presend_cancel_type", 1022);
        if (jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
          jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
        }
        d(paramIntent);
        bool = false;
      }
      catch (RemoteException localRemoteException2)
      {
        break label213;
        bool = false;
        continue;
      }
      LOG.a("RichmediaService", "addPresendMgrHandlerToIntent.result = " + bool);
      return bool;
      label213:
      LOG.a("RichmediaService", "addPresendMgrHandlerToIntent cb.getData ipc fail, RemoteException : " + localRemoteException1.getMessage());
      continue;
      LOG.a("RichmediaService", "addPresendMgrHandlerToIntent service.mClientCallBack is null");
      localObject = null;
      continue;
      LOG.a("RichmediaService", "addPresendMgrHandlerToIntent Richmedia Service is null");
      localObject = null;
      continue;
      label273:
      paramIntent.putExtra("presend_handler", localRemoteException1);
      bool = true;
    }
  }
  
  public static void b(Bundle paramBundle)
  {
    LOG.a("RichmediaService", "presendPic. ");
    a(3, paramBundle);
  }
  
  public static void c(Bundle paramBundle)
  {
    LOG.a("RichmediaService", "cancelPresendPic. ");
    a(4, paramBundle);
  }
  
  public static void d(Bundle paramBundle)
  {
    LOG.a("RichmediaService", "cancelAllPresendPic. ");
    a(5, paramBundle);
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
    this.jdField_a_of_type_Ahgp = new ahgp(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Ahgp);
    jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService = this;
    jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[onCreate]");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Ahgp = null;
    jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService = null;
    jdField_a_of_type_ComTencentUtilWeakReferenceHandler = null;
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[onDestroy]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService
 * JD-Core Version:    0.7.0.1
 */