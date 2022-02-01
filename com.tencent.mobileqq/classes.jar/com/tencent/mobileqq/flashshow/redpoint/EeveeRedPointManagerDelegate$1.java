package com.tencent.mobileqq.flashshow.redpoint;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flashshow.helper.FSEeveeRedPointHelper;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import qflash.QFlashBadge.ClearBadgeRsp;
import qflash.QFlashBadge.ClearBadgeRspInfo;

class EeveeRedPointManagerDelegate$1
  implements VSDispatchObserver.onVSRspCallBack<QFlashBadge.ClearBadgeRsp>
{
  EeveeRedPointManagerDelegate$1(EeveeRedPointManagerDelegate paramEeveeRedPointManagerDelegate) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QFlashBadge.ClearBadgeRsp paramClearBadgeRsp)
  {
    if ((paramBoolean) && (paramClearBadgeRsp != null) && (paramClearBadgeRsp.clearRspInfo.size() != 0))
    {
      long l = ((QFlashBadge.ClearBadgeRspInfo)paramClearBadgeRsp.clearRspInfo.get(0)).clearTime.get();
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("onReceive retCode= ");
      paramBaseRequest.append(paramLong);
      paramBaseRequest.append("errMsg= ");
      paramBaseRequest.append(paramString);
      paramBaseRequest.append("clearTime= ");
      paramBaseRequest.append(l);
      QLog.i("FSEeveeRedPoint", 1, paramBaseRequest.toString());
      FSEeveeRedPointHelper.getInstance().saveLastReadedBottomRedPointTimestamp(l);
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("onReceive retCode= ");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append("errMsg= ");
    paramBaseRequest.append(paramString);
    QLog.e("FSEeveeRedPoint", 1, paramBaseRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.redpoint.EeveeRedPointManagerDelegate.1
 * JD-Core Version:    0.7.0.1
 */