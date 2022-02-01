package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import qqcircle.QQCircleCountergroup.GetGroupCountRsp;

class QCircleMsgProcessor$1
  implements VSDispatchObserver.onVSRspCallBack
{
  QCircleMsgProcessor$1(QCircleMsgProcessor paramQCircleMsgProcessor) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof QQCircleCountergroup.GetGroupCountRsp)))
    {
      paramBaseRequest = (QQCircleCountergroup.GetGroupCountRsp)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("QCircleMsgProcessor", 2, String.format(Locale.getDefault(), "rsp.content=%s,rsp.count=%d, rsp.hasMore=%d, rsp.iconUrl=%s, rsp.latestFeedTime=%s, rsp.timeInterval=%s", new Object[] { paramBaseRequest.content.get(), Integer.valueOf(paramBaseRequest.count.get()), Integer.valueOf(paramBaseRequest.hasMore.get()), paramBaseRequest.iconUrl.get(), Integer.valueOf(paramBaseRequest.latestFeedTime.get()), Integer.valueOf(paramBaseRequest.timeInterval.get()) }));
      }
      if ((paramBaseRequest.count.get() < 1) || (TextUtils.isEmpty(paramBaseRequest.content.get())))
      {
        QLog.d("QCircleMsgProcessor", 2, "rsp.count.get() < 1 || TextUtils.isEmpty(rsp.content.get())");
        return;
      }
      QCircleMsgProcessor.a(this.a, paramBaseRequest);
      QCircleMsgProcessor.a(this.a, NetConnInfoCenter.getServerTimeMillis() / 1000L);
      QCircleMsgProcessor.b(this.a, paramBaseRequest.timeInterval.get());
      ReportController.b(null, "dc00898", "", String.valueOf(QCircleMsgProcessor.a(this.a)), "0X800B24E", "0X800B24E", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("QCircleMsgProcessor", 2, "retCode:" + paramLong + ", errMsg:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.QCircleMsgProcessor.1
 * JD-Core Version:    0.7.0.1
 */