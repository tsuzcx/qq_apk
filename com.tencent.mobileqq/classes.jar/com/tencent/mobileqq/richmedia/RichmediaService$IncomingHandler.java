package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.operator.CompressPicOperator;
import com.tencent.util.BinderWarpper;
import java.lang.ref.WeakReference;

class RichmediaService$IncomingHandler
  extends Handler
{
  final WeakReference<RichmediaService> a;
  
  public RichmediaService$IncomingHandler(Looper paramLooper, RichmediaService paramRichmediaService)
  {
    super(paramLooper);
    this.a = new WeakReference(paramRichmediaService);
  }
  
  public void handleMessage(Message paramMessage)
  {
    RichmediaService localRichmediaService = (RichmediaService)this.a.get();
    if (localRichmediaService == null) {}
    do
    {
      do
      {
        return;
        localObject = paramMessage.getData();
        if (localObject != null)
        {
          ((Bundle)localObject).setClassLoader(getClass().getClassLoader());
          ((Bundle)localObject).getInt("msg_sub_cmd");
        }
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1: 
          LOG.a("RichmediaService", "handleMessage MSG_C2S_REGISTER_CLIENT");
          localRichmediaService.b = paramMessage.replyTo;
        }
      } while (localObject == null);
      paramMessage = (BinderWarpper)((Bundle)localObject).getParcelable("ICallBack_BinderWrapper");
    } while (paramMessage == null);
    localRichmediaService.a = ICallBack.Stub.a(paramMessage.a);
    paramMessage = new Bundle();
    Object localObject = CompressPicOperator.a((QQAppInterface)RichmediaService.a(localRichmediaService));
    try
    {
      paramMessage.putIntArray("key_compress_config", (int[])localObject);
      localRichmediaService.a.a(6, paramMessage);
      return;
    }
    catch (RemoteException paramMessage)
    {
      LOG.a("RichmediaService", "ICALLBACK_CMD_INIT_COMPRESS_CONFIG remote error:" + paramMessage);
      paramMessage.printStackTrace();
      return;
    }
    LOG.a("RichmediaService", "handleMessage MSG_C2S_UNREGISTER_CLIENT");
    localRichmediaService.b = null;
    localRichmediaService.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */