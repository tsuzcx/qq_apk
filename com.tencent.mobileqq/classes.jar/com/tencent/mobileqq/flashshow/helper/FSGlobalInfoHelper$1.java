package com.tencent.mobileqq.flashshow.helper;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleSwitch.SetCircleSwitchRsp;

final class FSGlobalInfoHelper$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.SetCircleSwitchRsp>
{
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.SetCircleSwitchRsp paramSetCircleSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("onReceive success isBarrageOpen = ");
      paramBaseRequest.append(FSGlobalInfoHelper.b());
      QLog.i("FSGlobalInfoHelper", 1, paramBaseRequest.toString());
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("onReceive setBarrageClosed error retcode = ");
    paramBaseRequest.append(paramLong);
    QLog.e("FSGlobalInfoHelper", 1, paramBaseRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSGlobalInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */