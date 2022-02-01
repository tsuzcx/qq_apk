package com.tencent.mobileqq.vas.api.impl;

import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.UpdateListenerParams;
import eipc.EIPCCallback;

class VasUpdateManagerImpl$1
  implements IUpdateListener
{
  VasUpdateManagerImpl$1(VasUpdateManagerImpl paramVasUpdateManagerImpl, EIPCCallback paramEIPCCallback) {}
  
  public void onLoadFail(UpdateListenerParams paramUpdateListenerParams)
  {
    this.b.a(paramUpdateListenerParams, this.a, false, false);
  }
  
  public void onLoadSuccess(UpdateListenerParams paramUpdateListenerParams)
  {
    this.b.a(paramUpdateListenerParams, this.a, true, false);
  }
  
  public void onProgress(UpdateListenerParams paramUpdateListenerParams)
  {
    this.b.a(paramUpdateListenerParams, this.a, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasUpdateManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */