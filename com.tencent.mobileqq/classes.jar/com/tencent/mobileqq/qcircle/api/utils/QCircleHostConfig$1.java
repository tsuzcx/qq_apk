package com.tencent.mobileqq.qcircle.api.utils;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleSwitch.SetMultiCircleSwitchRsp;

final class QCircleHostConfig$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.SetMultiCircleSwitchRsp>
{
  QCircleHostConfig$1(String paramString1, String paramString2) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.SetMultiCircleSwitchRsp paramSetMultiCircleSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("updateGuideWnsConfig");
      paramBaseRequest.append(this.val$secondkey);
      paramBaseRequest.append(" ");
      paramBaseRequest.append(this.val$value);
      paramBaseRequest.append("  succ");
      QLog.w("QCircleHostConfig", 1, paramBaseRequest.toString());
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("updateGuideWnsConfig");
    paramBaseRequest.append(this.val$secondkey);
    paramBaseRequest.append(" ");
    paramBaseRequest.append(this.val$value);
    paramBaseRequest.append("  error retcode= ");
    paramBaseRequest.append(paramLong);
    QLog.w("QCircleHostConfig", 1, paramBaseRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig.1
 * JD-Core Version:    0.7.0.1
 */