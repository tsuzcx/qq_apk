package com.tencent.mobileqq.transfile.api.impl;

import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class ProtoReqManagerImpl$CheckConErroObserverImp
  extends CheckConErroObserver
{
  ProtoReqManagerImpl.ProtoReq mReq;
  ProtoReqManagerImpl.ProtoResp mResp;
  
  public ProtoReqManagerImpl$CheckConErroObserverImp(ProtoReqManagerImpl paramProtoReqManagerImpl, ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    this.mResp = paramProtoResp;
    this.mReq = paramProtoReq;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Object localObject = paramBundle.getString("msf_con_erro");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CheckConErroObserverImp.onReceive -> msfConErro: ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.d("Q.richmedia.ProtoReqManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.mResp.resp;
      if (localObject != null) {
        ((FromServiceMsg)localObject).addAttribute("_tag_socket_connerror", paramBundle);
      }
    }
    if (this.mReq.callback != null) {
      this.mReq.callback.onProtoResp(this.mResp, this.mReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.CheckConErroObserverImp
 * JD-Core Version:    0.7.0.1
 */