package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class ProtoReqManager$CheckConErroObserverImp
  extends CheckConErroObserver
{
  ProtoReqManager.ProtoReq mReq;
  ProtoReqManager.ProtoResp mResp;
  
  public ProtoReqManager$CheckConErroObserverImp(ProtoReqManager paramProtoReqManager, ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
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
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "CheckConErroObserverImp.onReceive -> msfConErro: " + paramBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoReqManager.CheckConErroObserverImp
 * JD-Core Version:    0.7.0.1
 */