package com.tencent.mobileqq.qqgamepub.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl.ResourcePermitReq;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class QQGameFlowControlServiceImpl$1
  implements Runnable
{
  QQGameFlowControlServiceImpl$1(QQGameFlowControlServiceImpl paramQQGameFlowControlServiceImpl, String paramString1, WadlTrpcListener paramWadlTrpcListener, String paramString2) {}
  
  public void run()
  {
    int i = QQGameFlowControlServiceImpl.getFileLength(this.a);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkResFlowControl...resSize:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(",resUrl:");
      ((StringBuilder)localObject1).append(this.a);
      QLog.i("QQGamePub_QQGameFlowControlServiceImpl", 1, ((StringBuilder)localObject1).toString());
    }
    if ((i > 0) && (!TextUtils.isEmpty(this.a)))
    {
      if (this.b == null) {
        return;
      }
      localObject1 = new QQGameResFlowControl.ResourcePermitReq();
      ((QQGameResFlowControl.ResourcePermitReq)localObject1).resSize.set(i);
      ((QQGameResFlowControl.ResourcePermitReq)localObject1).resUrl.set(this.a);
      Object localObject2 = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/63", false, ((QQGameResFlowControl.ResourcePermitReq)localObject1).toByteArray());
      localObject1 = new TrpcProxy.TrpcListReq();
      ((TrpcProxy.TrpcListReq)localObject1).list.add((MessageMicro)localObject2);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.b);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("resUrl", this.a);
      if (!TextUtils.isEmpty(this.c)) {
        ((Bundle)localObject2).putString("appName", this.c);
      }
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject1, (Bundle)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameFlowControlServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */