package com.tencent.mobileqq.filemanager.api.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class TroopFileProtoReqMgrImpl$CheckConErroObserverImp
  extends CheckConErroObserver
{
  TroopFileProtoReqMgrImpl.ProtoResponse a;
  TroopFileProtoReqMgrImpl.ProtoRequest b;
  
  public TroopFileProtoReqMgrImpl$CheckConErroObserverImp(TroopFileProtoReqMgrImpl paramTroopFileProtoReqMgrImpl, TroopFileProtoReqMgrImpl.ProtoResponse paramProtoResponse, TroopFileProtoReqMgrImpl.ProtoRequest paramProtoRequest)
  {
    this.a = paramProtoResponse;
    this.b = paramProtoRequest;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = "";
    Object localObject1;
    Object localObject2;
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getString("msf_con_erro");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("CheckConErroObserverImp.onReceive -> msfConErro: ");
        ((StringBuilder)localObject1).append(paramBundle);
        QLog.d("TroopFileProtoReqMgr", 2, ((StringBuilder)localObject1).toString());
      }
      localObject2 = this.a;
      localObject1 = paramBundle;
      if (localObject2 != null)
      {
        localObject2 = ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject2).a;
        localObject1 = paramBundle;
        if (localObject2 != null)
        {
          ((FromServiceMsg)localObject2).addAttribute("_tag_socket_connerror", paramBundle);
          localObject1 = paramBundle;
        }
      }
    }
    else
    {
      localObject1 = "";
    }
    paramBundle = this.b;
    if ((paramBundle != null) && (paramBundle.l != null))
    {
      paramBundle = new Bundle();
      if (this.b.m != null) {
        paramBundle.putAll(this.b.m);
      }
      localObject2 = this.a;
      if ((localObject2 != null) && (((TroopFileProtoReqMgrImpl.ProtoResponse)localObject2).a != null))
      {
        paramBundle.putString("data_error_msg", this.a.a.getBusinessFailMsg());
        paramBundle.putInt("data_error_code", this.a.a.getBusinessFailCode());
        paramBundle = new StringBuilder();
        paramBundle.append("cookie<");
        paramBundle.append(this.a.b.o);
        paramBundle.append("> onProtoResponse fail end. failCode:");
        paramBundle.append(this.a.a.getBusinessFailCode());
        paramBundle.append(" retryCount:");
        paramBundle.append(this.a.f.c);
        paramBundle.append(" msfConErro:");
        paramBundle.append((String)localObject1);
        QLog.e("TroopFileProtoReqMgr", 1, paramBundle.toString());
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cookie<");
        TroopFileProtoReqMgrImpl.ProtoResponse localProtoResponse = this.a;
        paramBundle = str;
        if (localProtoResponse != null)
        {
          paramBundle = str;
          if (localProtoResponse.b != null) {
            paramBundle = Long.valueOf(this.a.b.o);
          }
        }
        ((StringBuilder)localObject2).append(paramBundle);
        ((StringBuilder)localObject2).append("> onProtoResponse fail end. msfConErro:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.e("TroopFileProtoReqMgr", 1, ((StringBuilder)localObject2).toString());
      }
      this.b.l.onResult(-1, null, this.b.m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.TroopFileProtoReqMgrImpl.CheckConErroObserverImp
 * JD-Core Version:    0.7.0.1
 */