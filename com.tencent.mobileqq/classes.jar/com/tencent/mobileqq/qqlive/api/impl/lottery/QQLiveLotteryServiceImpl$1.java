package com.tencent.mobileqq.qqlive.api.impl.lottery;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveLotteryCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveConfigBean;
import com.tencent.mobileqq.qqlive.config.QQLiveConfigProcessor;
import com.tencent.mobileqq.qqlive.data.lottery.QQLiveLotteryData;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano.GetLotteryPendantRsp;
import com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano.GetLotteryPendantRsp.Pendant;
import java.util.ArrayList;
import java.util.Map;

class QQLiveLotteryServiceImpl$1
  extends QQLiveBusinessObserver
{
  QQLiveLotteryServiceImpl$1(QQLiveLotteryServiceImpl paramQQLiveLotteryServiceImpl, IQQLiveLotteryCallback paramIQQLiveLotteryCallback, long paramLong, String paramString, Map paramMap) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (paramBoolean)
    {
      if (QQLiveLotteryServiceImpl.access$000(this.this$0, this.val$callback, paramQQLiveRspData)) {
        QLog.e("IQQLiveLotteryModule", 4, "onReceive fail");
      }
      Object localObject = new ArrayList();
      try
      {
        paramQQLiveRspData = GetLotteryPendantRsp.a(paramQQLiveRspData.a()).a;
        int i = paramQQLiveRspData.length;
        paramInt = 0;
        while (paramInt < i)
        {
          QQLiveConfigBean localQQLiveConfigBean = paramQQLiveRspData[paramInt];
          QQLiveLotteryData localQQLiveLotteryData = new QQLiveLotteryData();
          localQQLiveLotteryData.countDown = localQQLiveConfigBean.a;
          localQQLiveLotteryData.isParticipate = Boolean.valueOf(localQQLiveConfigBean.c);
          localQQLiveLotteryData.lotteryId = localQQLiveConfigBean.d;
          if (localQQLiveConfigBean.b == 0) {
            localQQLiveLotteryData.lotteryType = 0;
          } else if (localQQLiveConfigBean.b == 1) {
            localQQLiveLotteryData.lotteryType = 1;
          }
          localQQLiveLotteryData.title = localQQLiveConfigBean.f;
          localQQLiveLotteryData.popText = localQQLiveConfigBean.g;
          localQQLiveLotteryData.jumpUrl = QQLiveLotteryServiceImpl.access$200(this.this$0, localQQLiveLotteryData.lotteryId, this.val$roomId, this.val$programId, QQLiveLotteryServiceImpl.access$100(this.this$0).getAppId(), this.val$extMap);
          localQQLiveConfigBean = QQLiveConfigProcessor.a();
          localQQLiveLotteryData.iconUrl = localQQLiveConfigBean.b;
          localQQLiveLotteryData.effectUrl = localQQLiveConfigBean.c;
          ((ArrayList)localObject).add(localQQLiveLotteryData);
          paramInt += 1;
        }
        this.val$callback.a((ArrayList)localObject);
        return;
      }
      catch (InvalidProtocolBufferNanoException paramQQLiveRspData)
      {
        this.val$callback.a(-1L, "GetLotteryPendantRsp parse fail");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GetLotteryPendantRsp error:");
        ((StringBuilder)localObject).append(paramQQLiveRspData.getMessage());
        QLog.e("IQQLiveLotteryModule", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.lottery.QQLiveLotteryServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */