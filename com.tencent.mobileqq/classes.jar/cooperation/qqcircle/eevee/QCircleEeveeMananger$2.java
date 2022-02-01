package cooperation.qqcircle.eevee;

import android.os.Looper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsRsp;
import mqq.os.MqqHandler;

class QCircleEeveeMananger$2
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudEeveeUndealmsg.FcUndealMsgsRsp>
{
  QCircleEeveeMananger$2(QCircleEeveeMananger paramQCircleEeveeMananger, int paramInt, String paramString) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudEeveeUndealmsg.FcUndealMsgsRsp paramFcUndealMsgsRsp)
  {
    if (paramBoolean) {
      if (Looper.myLooper().equals(Looper.getMainLooper())) {
        QCircleEeveeMananger.access$100(this.this$0).post(new QCircleEeveeMananger.2.1(this, paramFcUndealMsgsRsp));
      }
    }
    do
    {
      return;
      QCircleEeveeMananger.access$000(this.this$0, paramFcUndealMsgsRsp, this.val$visitScene);
      return;
      QLog.e("QCircleEeveeMananger", 1, "onReceive retCode= " + paramLong + "errMsg= " + paramString);
    } while (this.val$visitScene != 1000);
    QCircleLpReportDc010001.report(500, 15, 2, null, null, null, this.val$msgId, this.val$visitScene);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.eevee.QCircleEeveeMananger.2
 * JD-Core Version:    0.7.0.1
 */