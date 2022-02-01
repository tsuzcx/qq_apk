package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
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
    Object localObject1 = (RichmediaService)this.a.get();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = paramMessage.getData();
    if (localObject2 != null)
    {
      ((Bundle)localObject2).setClassLoader(getClass().getClassLoader());
      ((Bundle)localObject2).getInt("msg_sub_cmd");
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      LOG.a("RichmediaService", "handleMessage MSG_C2S_UNREGISTER_CLIENT");
      ((RichmediaService)localObject1).b = null;
      ((RichmediaService)localObject1).a = null;
      return;
    }
    LOG.a("RichmediaService", "handleMessage MSG_C2S_REGISTER_CLIENT");
    ((RichmediaService)localObject1).b = paramMessage.replyTo;
    if (localObject2 != null)
    {
      paramMessage = (BinderWarpper)((Bundle)localObject2).getParcelable("ICallBack_BinderWrapper");
      if (paramMessage != null)
      {
        ((RichmediaService)localObject1).a = ICallBack.Stub.a(paramMessage.a);
        paramMessage = new Bundle();
        localObject2 = ((ICompressOperator)QRoute.api(ICompressOperator.class)).getCompressConfigFromServer((QQAppInterface)RichmediaService.a((RichmediaService)localObject1));
        try
        {
          paramMessage.putIntArray("key_compress_config", (int[])localObject2);
          ((RichmediaService)localObject1).a.a(6, paramMessage);
          return;
        }
        catch (RemoteException paramMessage)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("ICALLBACK_CMD_INIT_COMPRESS_CONFIG remote error:");
          ((StringBuilder)localObject1).append(paramMessage);
          LOG.a("RichmediaService", ((StringBuilder)localObject1).toString());
          paramMessage.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.RichmediaService.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */