package com.tencent.mobileqq.qqlive.api.impl.common;

import com.tencent.mobileqq.qqlive.callback.common.IQQLiveUserCardInfoCallback;
import com.tencent.mobileqq.qqlive.data.user.UserCardInfo;
import com.tencent.mobileqq.qqlive.sso.BaseSsoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.ilive.personalCardInfo.personalCardInfo.nano.GetUserinfoCardInfoRsp;
import com.tencent.trpcprotocol.ilive.personalCardInfo.personalCardInfo.nano.UserInfo;
import com.tencent.trpcprotocol.ilive.personalCardInfo.personalCardInfo.nano.UserInfoExt;

class QQLiveUserCardImpl$1
  extends BaseSsoCallback
{
  QQLiveUserCardImpl$1(QQLiveUserCardImpl paramQQLiveUserCardImpl, IQQLiveUserCardInfoCallback paramIQQLiveUserCardInfoCallback) {}
  
  public void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData)
  {
    paramQQLiveRspData = GetUserinfoCardInfoRsp.a(paramQQLiveRspData.a());
    UserCardInfo localUserCardInfo = new UserCardInfo();
    if (paramQQLiveRspData.c != null)
    {
      try
      {
        localUserCardInfo.uid = Long.parseLong(paramQQLiveRspData.c.e);
      }
      catch (Exception localException)
      {
        QLog.e("QQLiveUserCardImpl", 1, localException.getMessage());
      }
      localUserCardInfo.nick = paramQQLiveRspData.c.a;
      localUserCardInfo.headUrl = paramQQLiveRspData.c.b;
      localUserCardInfo.clientType = paramQQLiveRspData.c.d;
      localUserCardInfo.explicitUid = paramQQLiveRspData.c.c;
    }
    if (paramQQLiveRspData.d != null) {
      localUserCardInfo.fromAppName = paramQQLiveRspData.d.a;
    }
    this.val$cardInfoCallback.a(localUserCardInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.common.QQLiveUserCardImpl.1
 * JD-Core Version:    0.7.0.1
 */