package com.tencent.mobileqq.vas.api.impl;

import android.os.RemoteException;
import com.tencent.mobileqq.app.BusinessObserver;
import eipc.EIPCCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "isSuccess", "", "data", "", "kotlin.jvm.PlatformType", "onUpdate"}, k=3, mv={1, 1, 16})
final class JceSSoImpl$request$observer$1
  implements BusinessObserver
{
  JceSSoImpl$request$observer$1(JceSSoImpl paramJceSSoImpl, EIPCCallback paramEIPCCallback) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    try
    {
      this.b.callback(this.a.a(paramInt, paramBoolean, paramObject));
      return;
    }
    catch (RemoteException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.JceSSoImpl.request.observer.1
 * JD-Core Version:    0.7.0.1
 */