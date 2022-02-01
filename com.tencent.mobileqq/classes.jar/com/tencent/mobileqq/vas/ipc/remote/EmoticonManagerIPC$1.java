package com.tencent.mobileqq.vas.ipc.remote;

import android.os.Bundle;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import eipc.EIPCModule;
import eipc.EIPCResult;

class EmoticonManagerIPC$1
  implements IUpdateListener
{
  EmoticonManagerIPC$1(EmoticonManagerIPC paramEmoticonManagerIPC, EIPCModule paramEIPCModule, int paramInt) {}
  
  public void onLoadFail(UpdateListenerParams paramUpdateListenerParams)
  {
    paramUpdateListenerParams = new EIPCResult();
    paramUpdateListenerParams.data = new Bundle();
    paramUpdateListenerParams.data.putBoolean("status", false);
    this.val$moudle.callbackResult(this.val$callbackId, paramUpdateListenerParams);
  }
  
  public void onLoadSuccess(UpdateListenerParams paramUpdateListenerParams)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.data = new Bundle();
    localEIPCResult.data.putBoolean("status", true);
    localEIPCResult.data.putString("filepath", ((TroopNickNameBusiness)QQVasUpdateBusiness.a(TroopNickNameBusiness.class)).a(paramUpdateListenerParams.mBusinessUpdateParams.mScid));
    this.val$moudle.callbackResult(this.val$callbackId, localEIPCResult);
  }
  
  public void onProgress(UpdateListenerParams paramUpdateListenerParams) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.EmoticonManagerIPC.1
 * JD-Core Version:    0.7.0.1
 */