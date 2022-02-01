package com.tencent.mobileqq.vas.api.impl;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.vas.api.IVasUpdateManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.entity.UpdateListenerParams;
import eipc.EIPCCallback;
import eipc.EIPCResult;

public class VasUpdateManagerImpl
  implements IVasUpdateManager
{
  public void a(UpdateListenerParams paramUpdateListenerParams, EIPCCallback paramEIPCCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.data = new Bundle();
    paramUpdateListenerParams = QQVasUpdateBusinessUtil.a(paramUpdateListenerParams);
    if (paramUpdateListenerParams != null)
    {
      paramUpdateListenerParams.a = paramBoolean1;
      paramUpdateListenerParams.b = paramBoolean2;
      localEIPCResult.data.putParcelable("data", paramUpdateListenerParams);
    }
    try
    {
      paramEIPCCallback.callback(localEIPCResult);
      return;
    }
    catch (RemoteException paramUpdateListenerParams)
    {
      paramUpdateListenerParams.printStackTrace();
    }
  }
  
  public <T extends QQVasUpdateBusiness> void startRemoteDownload(Class<T> paramClass, String paramString, EIPCCallback paramEIPCCallback)
  {
    paramClass = QQVasUpdateBusinessUtil.a(paramClass);
    paramClass.addUpdateListener(new VasUpdateManagerImpl.1(this, paramEIPCCallback));
    paramClass.startDownload(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasUpdateManagerImpl
 * JD-Core Version:    0.7.0.1
 */