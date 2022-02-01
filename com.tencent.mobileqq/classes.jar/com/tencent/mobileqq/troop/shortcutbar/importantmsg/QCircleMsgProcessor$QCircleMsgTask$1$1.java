package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import qqcircle.QQCircleCountergroup.GetGroupCountRsp;

class QCircleMsgProcessor$QCircleMsgTask$1$1
  implements Runnable
{
  QCircleMsgProcessor$QCircleMsgTask$1$1(QCircleMsgProcessor.QCircleMsgTask.1 param1, boolean paramBoolean, Object paramObject, long paramLong, String paramString) {}
  
  public void run()
  {
    if (this.a)
    {
      localObject = this.b;
      if ((localObject instanceof QQCircleCountergroup.GetGroupCountRsp))
      {
        localObject = (QQCircleCountergroup.GetGroupCountRsp)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("QCircleMsgProcessor", 2, String.format(Locale.getDefault(), "rsp.content=%s,rsp.count=%d, rsp.hasMore=%d, rsp.iconUrl=%s, rsp.latestFeedTime=%s, rsp.timeInterval=%s", new Object[] { ((QQCircleCountergroup.GetGroupCountRsp)localObject).content.get(), Integer.valueOf(((QQCircleCountergroup.GetGroupCountRsp)localObject).count.get()), Integer.valueOf(((QQCircleCountergroup.GetGroupCountRsp)localObject).hasMore.get()), ((QQCircleCountergroup.GetGroupCountRsp)localObject).iconUrl.get(), Integer.valueOf(((QQCircleCountergroup.GetGroupCountRsp)localObject).latestFeedTime.get()), Integer.valueOf(((QQCircleCountergroup.GetGroupCountRsp)localObject).timeInterval.get()) }));
        }
        if ((((QQCircleCountergroup.GetGroupCountRsp)localObject).count.get() >= 1) && (!TextUtils.isEmpty(((QQCircleCountergroup.GetGroupCountRsp)localObject).content.get())))
        {
          QCircleMsgProcessor.a(this.e.a.this$0, (QQCircleCountergroup.GetGroupCountRsp)localObject);
          QCircleMsgProcessor.a(this.e.a.this$0, NetConnInfoCenter.getServerTimeMillis() / 1000L);
          QCircleMsgProcessor.b(this.e.a.this$0, ((QQCircleCountergroup.GetGroupCountRsp)localObject).timeInterval.get());
          ReportController.b(null, "dc00898", "", String.valueOf(QCircleMsgProcessor.QCircleMsgTask.a(this.e.a)), "0X800B24E", "0X800B24E", 0, 0, "", "", "", "");
          return;
        }
        QLog.d("QCircleMsgProcessor", 2, "rsp.count.get() < 1 || TextUtils.isEmpty(rsp.content.get())");
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("retCode:");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", errMsg:");
    ((StringBuilder)localObject).append(this.d);
    QLog.e("QCircleMsgProcessor", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.QCircleMsgProcessor.QCircleMsgTask.1.1
 * JD-Core Version:    0.7.0.1
 */