package com.tencent.mobileqq.richmedia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import awga;
import axja;
import axjd;
import axji;
import bhow;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import mqq.app.AppService;

public class RichmediaService
  extends AppService
  implements Handler.Callback
{
  static volatile bhow jdField_a_of_type_Bhow;
  static volatile RichmediaService jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
  Messenger jdField_a_of_type_AndroidOsMessenger;
  public volatile axja a;
  axji jdField_a_of_type_Axji;
  public Messenger b;
  
  public static RichmediaService a()
  {
    return jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
  }
  
  static void a(int paramInt, Bundle paramBundle)
  {
    axjd.a("RichmediaService", "sendICallBackRequest start . cmd = " + paramInt + ",data = " + paramBundle);
    bhow localbhow = jdField_a_of_type_Bhow;
    if (localbhow != null)
    {
      localbhow.post(new RichmediaService.1(paramInt, paramBundle));
      return;
    }
    axjd.a("RichmediaService", "sendICallBackRequest subHandler is null");
  }
  
  public static void a(Bundle paramBundle)
  {
    axjd.a("RichmediaService", "initPresend. ");
    a(2, paramBundle);
  }
  
  public static void a(CompressInfo paramCompressInfo)
  {
    axjd.a("RichmediaService", "startCompress start . compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.srcPath = " + paramCompressInfo.c);
    Object localObject = jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
    int i = 0;
    if (localObject != null)
    {
      localObject = ((RichmediaService)localObject).jdField_a_of_type_Axja;
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        axjd.a("RichmediaService", "startCompress cb.compress start . compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.srcPath = " + paramCompressInfo.c);
        ((axja)localObject).a(paramCompressInfo);
        axjd.a("RichmediaService", "startCompress cb.compress finish. compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.dstPath = " + paramCompressInfo.e);
        if (i != 0)
        {
          axjd.a("RichmediaService", "startCompress compressInMainProcess start . compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.srcPath = " + paramCompressInfo.c);
          awga.a(paramCompressInfo);
          axjd.a("RichmediaService", "startCompress compressInMainProcess finish. compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.dstPath = " + paramCompressInfo.e);
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        axjd.a("RichmediaService", "startCompress cb.compress ipc fail,compressInfo.localUUID = " + paramCompressInfo.a + ",compress in main process, RemoteException : " + localRemoteException.getMessage());
        i = 1;
        continue;
      }
      axjd.a("RichmediaService", "startCompress service.mClientCallBack is null,compressInfo.localUUID = " + paramCompressInfo.a + ",compress in main process");
      i = 1;
      continue;
      axjd.a("RichmediaService", "startCompress Richmedia Service is null,compressInfo.localUUID = " + paramCompressInfo.a + ",compress in main process");
      i = 1;
    }
  }
  
  public static boolean a(Intent paramIntent)
  {
    axjd.a("RichmediaService", "addPresendMgrHandlerToIntent start .");
    Object localObject = jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
    if (localObject != null)
    {
      localObject = ((RichmediaService)localObject).jdField_a_of_type_Axja;
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        axjd.a("RichmediaService", "addPresendMgrHandlerToIntent cb.getData start . ");
        localObject = ((axja)localObject).a(16, null);
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
        axjd.a("RichmediaService", "addPresendMgrHandlerToIntent cb.getData finish. ");
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
        axjd.a("RichmediaService", "presend req count = " + i + ", send count = " + j);
        if (i == j) {
          break label273;
        }
        paramIntent = new Bundle();
        paramIntent.putInt("key_presend_cancel_type", 1022);
        if (jdField_a_of_type_Bhow != null) {
          jdField_a_of_type_Bhow.removeCallbacksAndMessages(null);
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
      axjd.a("RichmediaService", "addPresendMgrHandlerToIntent.result = " + bool);
      return bool;
      label213:
      axjd.a("RichmediaService", "addPresendMgrHandlerToIntent cb.getData ipc fail, RemoteException : " + localRemoteException1.getMessage());
      continue;
      axjd.a("RichmediaService", "addPresendMgrHandlerToIntent service.mClientCallBack is null");
      localObject = null;
      continue;
      axjd.a("RichmediaService", "addPresendMgrHandlerToIntent Richmedia Service is null");
      localObject = null;
      continue;
      label273:
      paramIntent.putExtra("presend_handler", localRemoteException1);
      bool = true;
    }
  }
  
  public static void b(Bundle paramBundle)
  {
    axjd.a("RichmediaService", "presendPic. ");
    a(3, paramBundle);
  }
  
  public static void c(Bundle paramBundle)
  {
    axjd.a("RichmediaService", "cancelPresendPic. ");
    a(4, paramBundle);
  }
  
  public static void d(Bundle paramBundle)
  {
    axjd.a("RichmediaService", "cancelAllPresendPic. ");
    a(5, paramBundle);
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    axjd.a("RichmediaService", "sendToClient,msgCode = " + paramInt1 + ",subCmd = " + paramInt2 + ",data = " + paramBundle);
    if (this.b == null)
    {
      axjd.b("RichmediaService", "sendToClient failed. mClient is null");
      return false;
    }
    Message localMessage = Message.obtain(null, paramInt1);
    if (paramBundle != null) {
      paramBundle.putInt("msg_sub_cmd", paramInt2);
    }
    localMessage.setData(paramBundle);
    try
    {
      this.b.send(localMessage);
      return true;
    }
    catch (RemoteException paramBundle)
    {
      axjd.b("RichmediaService", "sendToClient failed. e = " + paramBundle);
    }
    return false;
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
    this.jdField_a_of_type_Axji = new axji(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Axji);
    jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService = this;
    jdField_a_of_type_Bhow = new bhow(ThreadManager.getSubThreadLooper(), this);
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[onCreate]");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Axji = null;
    jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService = null;
    jdField_a_of_type_Bhow = null;
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[onDestroy]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService
 * JD-Core Version:    0.7.0.1
 */