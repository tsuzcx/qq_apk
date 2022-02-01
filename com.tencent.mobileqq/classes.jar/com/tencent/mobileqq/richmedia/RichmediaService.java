package com.tencent.mobileqq.richmedia;

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
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.util.WeakReferenceHandler;
import mqq.app.AppService;

public class RichmediaService
  extends AppService
  implements Handler.Callback, RichmediaIPCConstants
{
  static volatile RichmediaService jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
  static volatile WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  Messenger jdField_a_of_type_AndroidOsMessenger;
  volatile ICallBack jdField_a_of_type_ComTencentMobileqqRichmediaICallBack;
  RichmediaService.IncomingHandler jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService$IncomingHandler;
  Messenger b;
  
  public static RichmediaService a()
  {
    return jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
  }
  
  static void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendICallBackRequest start . cmd = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",data = ");
    ((StringBuilder)localObject).append(paramBundle);
    LOG.a("RichmediaService", ((StringBuilder)localObject).toString());
    localObject = jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localObject != null)
    {
      ((Handler)localObject).post(new RichmediaService.1(paramInt, paramBundle));
      return;
    }
    LOG.a("RichmediaService", "sendICallBackRequest subHandler is null");
  }
  
  public static void a(Bundle paramBundle)
  {
    LOG.a("RichmediaService", "initPresend. ");
    a(2, paramBundle);
  }
  
  public static boolean a(Intent paramIntent)
  {
    LOG.a("RichmediaService", "addPresendMgrHandlerToIntent start .");
    Object localObject = jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
    if (localObject != null)
    {
      localObject = ((RichmediaService)localObject).jdField_a_of_type_ComTencentMobileqqRichmediaICallBack;
      if (localObject != null)
      {
        try
        {
          LOG.a("RichmediaService", "addPresendMgrHandlerToIntent cb.getData start . ");
          localObject = ((ICallBack)localObject).a(16, null);
          try
          {
            LOG.a("RichmediaService", "addPresendMgrHandlerToIntent cb.getData finish. ");
          }
          catch (RemoteException localRemoteException1) {}
          localStringBuilder = new StringBuilder();
        }
        catch (RemoteException localRemoteException2)
        {
          localObject = null;
        }
        StringBuilder localStringBuilder;
        localStringBuilder.append("addPresendMgrHandlerToIntent cb.getData ipc fail, RemoteException : ");
        localStringBuilder.append(localRemoteException2.getMessage());
        LOG.a("RichmediaService", localStringBuilder.toString());
        break label135;
      }
      LOG.a("RichmediaService", "addPresendMgrHandlerToIntent service.mClientCallBack is null");
    }
    else
    {
      LOG.a("RichmediaService", "addPresendMgrHandlerToIntent Richmedia Service is null");
    }
    localObject = null;
    label135:
    if (localObject != null)
    {
      ((Bundle)localObject).setClassLoader(RichmediaService.class.getClassLoader());
      BinderWarpper localBinderWarpper = (BinderWarpper)((Bundle)localObject).getParcelable("key_presend_mgr_handler");
      if (localBinderWarpper != null)
      {
        int i = ((Bundle)localObject).getInt("PhotoConst.PHOTO_COUNT");
        int j = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", -1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("presend req count = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", send count = ");
        ((StringBuilder)localObject).append(j);
        LOG.a("RichmediaService", ((StringBuilder)localObject).toString());
        if (i != j)
        {
          paramIntent = new Bundle();
          paramIntent.putInt("key_presend_cancel_type", 1022);
          if (jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
            jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
          }
          d(paramIntent);
        }
        else
        {
          paramIntent.putExtra("presend_handler", localBinderWarpper);
          bool = true;
          break label291;
        }
      }
    }
    boolean bool = false;
    label291:
    paramIntent = new StringBuilder();
    paramIntent.append("addPresendMgrHandlerToIntent.result = ");
    paramIntent.append(bool);
    LOG.a("RichmediaService", paramIntent.toString());
    return bool;
  }
  
  public static boolean a(CompressInfo paramCompressInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startCompress start . compressInfo.localUUID = ");
    ((StringBuilder)localObject).append(paramCompressInfo.a);
    ((StringBuilder)localObject).append(",compressInfo.srcPath = ");
    ((StringBuilder)localObject).append(paramCompressInfo.c);
    LOG.a("RichmediaService", ((StringBuilder)localObject).toString());
    localObject = jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService;
    boolean bool = true;
    StringBuilder localStringBuilder1;
    if (localObject != null)
    {
      localObject = ((RichmediaService)localObject).jdField_a_of_type_ComTencentMobileqqRichmediaICallBack;
      if (localObject != null)
      {
        try
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startCompress cb.compress start . compressInfo.localUUID = ");
          localStringBuilder2.append(paramCompressInfo.a);
          localStringBuilder2.append(",compressInfo.srcPath = ");
          localStringBuilder2.append(paramCompressInfo.c);
          LOG.a("RichmediaService", localStringBuilder2.toString());
          ((ICallBack)localObject).a(paramCompressInfo);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("startCompress cb.compress finish. compressInfo.localUUID = ");
          ((StringBuilder)localObject).append(paramCompressInfo.a);
          ((StringBuilder)localObject).append(",compressInfo.dstPath = ");
          ((StringBuilder)localObject).append(paramCompressInfo.e);
          LOG.a("RichmediaService", ((StringBuilder)localObject).toString());
          bool = false;
        }
        catch (RemoteException localRemoteException)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startCompress cb.compress ipc fail,compressInfo.localUUID = ");
          localStringBuilder2.append(paramCompressInfo.a);
          localStringBuilder2.append(",compress in main process, RemoteException : ");
          localStringBuilder2.append(localRemoteException.getMessage());
          LOG.a("RichmediaService", localStringBuilder2.toString());
        }
      }
      else
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("startCompress service.mClientCallBack is null,compressInfo.localUUID = ");
        localStringBuilder1.append(paramCompressInfo.a);
        localStringBuilder1.append(",compress in main process");
        LOG.a("RichmediaService", localStringBuilder1.toString());
      }
    }
    else
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("startCompress Richmedia Service is null,compressInfo.localUUID = ");
      localStringBuilder1.append(paramCompressInfo.a);
      localStringBuilder1.append(",compress in main process");
      LOG.a("RichmediaService", localStringBuilder1.toString());
    }
    if (bool)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("startCompress compressInMainProcess start . compressInfo.localUUID = ");
      localStringBuilder1.append(paramCompressInfo.a);
      localStringBuilder1.append(",compressInfo.srcPath = ");
      localStringBuilder1.append(paramCompressInfo.c);
      LOG.a("RichmediaService", localStringBuilder1.toString());
      ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(paramCompressInfo);
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("startCompress compressInMainProcess finish. compressInfo.localUUID = ");
      localStringBuilder1.append(paramCompressInfo.a);
      localStringBuilder1.append(",compressInfo.dstPath = ");
      localStringBuilder1.append(paramCompressInfo.e);
      LOG.a("RichmediaService", localStringBuilder1.toString());
    }
    return bool;
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
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendToClient,msgCode = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",subCmd = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(",data = ");
    ((StringBuilder)localObject).append(paramBundle);
    LOG.a("RichmediaService", ((StringBuilder)localObject).toString());
    if (this.b == null)
    {
      LOG.b("RichmediaService", "sendToClient failed. mClient is null");
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
    catch (Exception paramBundle)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendToClient failed. e = ");
      ((StringBuilder)localObject).append(paramBundle);
      LOG.b("RichmediaService", ((StringBuilder)localObject).toString());
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
    this.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService$IncomingHandler = new RichmediaService.IncomingHandler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService$IncomingHandler);
    jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService = this;
    jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[onCreate]");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService$IncomingHandler = null;
    jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService = null;
    jdField_a_of_type_ComTencentUtilWeakReferenceHandler = null;
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[onDestroy]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService
 * JD-Core Version:    0.7.0.1
 */