package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo.LoginReportReq;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class QQGameAdServiceImpl$3
  implements Runnable
{
  QQGameAdServiceImpl$3(QQGameAdServiceImpl paramQQGameAdServiceImpl) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject3 = new QQGamePaAdInfo.LoginReportReq();
        Object localObject1 = new GdtDeviceInfoHelper.Params();
        ((GdtDeviceInfoHelper.Params)localObject1).a = "807825";
        localObject1 = GdtDeviceInfoHelper.a(MobileQQ.sMobileQQ.getApplicationContext(), (GdtDeviceInfoHelper.Params)localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((GdtDeviceInfoHelper.Result)localObject1).a;
          if (localObject1 != null)
          {
            localObject1 = GdtJsonPbUtil.a((PBField)localObject1);
            if (localObject1 != null) {
              ((QQGamePaAdInfo.LoginReportReq)localObject3).deviceInfo.set(localObject1.toString());
            } else {
              QLog.i("QQGamePub_QQGameAdServiceImpl", 2, "<<<<get device info fail because  deviceObj is null !!!!!<<<<");
            }
          }
          else
          {
            QLog.i("QQGamePub_QQGameAdServiceImpl", 2, "<<<<get device info fail !!!!!<<<<");
          }
          ((QQGamePaAdInfo.LoginReportReq)localObject3).uin.set(QQGameAdServiceImpl.access$300(this.this$0));
          localObject1 = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/62", false, ((QQGamePaAdInfo.LoginReportReq)localObject3).toByteArray());
          localObject3 = new TrpcProxy.TrpcListReq();
          ((TrpcProxy.TrpcListReq)localObject3).list.add((MessageMicro)localObject1);
          ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(QQGameAdServiceImpl.access$400(this.this$0));
          ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject3, null);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQGamePub_QQGameAdServiceImpl", 1, localThrowable, new Object[0]);
        return;
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameAdServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */