package com.tencent.mobileqq.flashshow.part;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flashshow.helper.FSEeveeRedPointHelper;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import qflash.QFlashBadge.ClearBadgeRsp;
import qflash.QFlashBadge.ClearBadgeRspInfo;

class FSRedPointTipsPart$2
  implements VSDispatchObserver.onVSRspCallBack<QFlashBadge.ClearBadgeRsp>
{
  FSRedPointTipsPart$2(FSRedPointTipsPart paramFSRedPointTipsPart, int paramInt) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QFlashBadge.ClearBadgeRsp paramClearBadgeRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("onReceive retCode= ");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append("errMsg= ");
    paramBaseRequest.append(paramString);
    QLog.i("FSRedPointTipsPart", 1, paramBaseRequest.toString());
    if ((paramBoolean) && (paramClearBadgeRsp != null) && (paramClearBadgeRsp.clearRspInfo.size() != 0)) {
      FSEeveeRedPointHelper.getInstance().saveLastReadedTabRedPointTimestamp(this.a, ((QFlashBadge.ClearBadgeRspInfo)paramClearBadgeRsp.clearRspInfo.get(0)).clearTime.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSRedPointTipsPart.2
 * JD-Core Version:    0.7.0.1
 */