package com.tencent.mobileqq.richmedia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import azlg;
import bbfo;
import bbfr;
import bbfw;
import bkys;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import mqq.app.AppService;

public class RichmediaService
  extends AppService
  implements Handler.Callback
{
  static volatile bkys jdField_a_of_type_Bkys;
  static volatile RichmediaService jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
  Messenger jdField_a_of_type_AndroidOsMessenger;
  public volatile bbfo a;
  bbfw jdField_a_of_type_Bbfw;
  public Messenger b;
  
  public static RichmediaService a()
  {
    return jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
  }
  
  static void a(int paramInt, Bundle paramBundle)
  {
    bbfr.a("RichmediaService", "sendICallBackRequest start . cmd = " + paramInt + ",data = " + paramBundle);
    bkys localbkys = jdField_a_of_type_Bkys;
    if (localbkys != null)
    {
      localbkys.post(new RichmediaService.1(paramInt, paramBundle));
      return;
    }
    bbfr.a("RichmediaService", "sendICallBackRequest subHandler is null");
  }
  
  public static void a(Bundle paramBundle)
  {
    bbfr.a("RichmediaService", "initPresend. ");
    a(2, paramBundle);
  }
  
  public static boolean a(Intent paramIntent)
  {
    bbfr.a("RichmediaService", "addPresendMgrHandlerToIntent start .");
    Object localObject = jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
    if (localObject != null)
    {
      localObject = ((RichmediaService)localObject).jdField_a_of_type_Bbfo;
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        bbfr.a("RichmediaService", "addPresendMgrHandlerToIntent cb.getData start . ");
        localObject = ((bbfo)localObject).a(16, null);
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
        bbfr.a("RichmediaService", "addPresendMgrHandlerToIntent cb.getData finish. ");
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
        bbfr.a("RichmediaService", "presend req count = " + i + ", send count = " + j);
        if (i == j) {
          break label273;
        }
        paramIntent = new Bundle();
        paramIntent.putInt("key_presend_cancel_type", 1022);
        if (jdField_a_of_type_Bkys != null) {
          jdField_a_of_type_Bkys.removeCallbacksAndMessages(null);
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
      bbfr.a("RichmediaService", "addPresendMgrHandlerToIntent.result = " + bool);
      return bool;
      label213:
      bbfr.a("RichmediaService", "addPresendMgrHandlerToIntent cb.getData ipc fail, RemoteException : " + localRemoteException1.getMessage());
      continue;
      bbfr.a("RichmediaService", "addPresendMgrHandlerToIntent service.mClientCallBack is null");
      localObject = null;
      continue;
      bbfr.a("RichmediaService", "addPresendMgrHandlerToIntent Richmedia Service is null");
      localObject = null;
      continue;
      label273:
      paramIntent.putExtra("presend_handler", localRemoteException1);
      bool = true;
    }
  }
  
  public static boolean a(CompressInfo paramCompressInfo)
  {
    bbfr.a("RichmediaService", "startCompress start . compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.srcPath = " + paramCompressInfo.c);
    Object localObject = jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
    boolean bool = false;
    if (localObject != null)
    {
      localObject = ((RichmediaService)localObject).jdField_a_of_type_Bbfo;
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        bbfr.a("RichmediaService", "startCompress cb.compress start . compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.srcPath = " + paramCompressInfo.c);
        ((bbfo)localObject).a(paramCompressInfo);
        bbfr.a("RichmediaService", "startCompress cb.compress finish. compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.dstPath = " + paramCompressInfo.e);
        if (bool)
        {
          bbfr.a("RichmediaService", "startCompress compressInMainProcess start . compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.srcPath = " + paramCompressInfo.c);
          azlg.a(paramCompressInfo);
          bbfr.a("RichmediaService", "startCompress compressInMainProcess finish. compressInfo.localUUID = " + paramCompressInfo.a + ",compressInfo.dstPath = " + paramCompressInfo.e);
        }
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        bbfr.a("RichmediaService", "startCompress cb.compress ipc fail,compressInfo.localUUID = " + paramCompressInfo.a + ",compress in main process, RemoteException : " + localRemoteException.getMessage());
        bool = true;
        continue;
      }
      bbfr.a("RichmediaService", "startCompress service.mClientCallBack is null,compressInfo.localUUID = " + paramCompressInfo.a + ",compress in main process");
      bool = true;
      continue;
      bbfr.a("RichmediaService", "startCompress Richmedia Service is null,compressInfo.localUUID = " + paramCompressInfo.a + ",compress in main process");
      bool = true;
    }
  }
  
  public static void b(Bundle paramBundle)
  {
    bbfr.a("RichmediaService", "presendPic. ");
    a(3, paramBundle);
  }
  
  public static void c(Bundle paramBundle)
  {
    bbfr.a("RichmediaService", "cancelPresendPic. ");
    a(4, paramBundle);
  }
  
  public static void d(Bundle paramBundle)
  {
    bbfr.a("RichmediaService", "cancelAllPresendPic. ");
    a(5, paramBundle);
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    bbfr.a("RichmediaService", "sendToClient,msgCode = " + paramInt1 + ",subCmd = " + paramInt2 + ",data = " + paramBundle);
    if (this.b == null)
    {
      bbfr.b("RichmediaService", "sendToClient failed. mClient is null");
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
    catch (Exception paramBundle)
    {
      bbfr.b("RichmediaService", "sendToClient failed. e = " + paramBundle);
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
    this.jdField_a_of_type_Bbfw = new bbfw(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Bbfw);
    jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService = this;
    jdField_a_of_type_Bkys = new bkys(ThreadManager.getSubThreadLooper(), this);
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[onCreate]");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Bbfw = null;
    jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService = null;
    jdField_a_of_type_Bkys = null;
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[onDestroy]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService
 * JD-Core Version:    0.7.0.1
 */