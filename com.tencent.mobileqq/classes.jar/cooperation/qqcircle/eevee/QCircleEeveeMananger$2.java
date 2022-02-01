package cooperation.qqcircle.eevee;

import android.os.Looper;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsRsp;
import mqq.os.MqqHandler;

class QCircleEeveeMananger$2
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudEeveeUndealmsg.FcUndealMsgsRsp>
{
  QCircleEeveeMananger$2(QCircleEeveeMananger paramQCircleEeveeMananger, int paramInt, String paramString) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudEeveeUndealmsg.FcUndealMsgsRsp paramFcUndealMsgsRsp)
  {
    if ((paramBoolean) && (QCircleEeveeMananger.access$000() != null))
    {
      if (Looper.myLooper().equals(Looper.getMainLooper()))
      {
        QCircleEeveeMananger.access$200(this.this$0).post(new QCircleEeveeMananger.2.1(this, paramFcUndealMsgsRsp));
        return;
      }
      QCircleEeveeMananger.access$100(this.this$0, paramFcUndealMsgsRsp, this.val$visitScene);
      return;
    }
    int i = RFLog.USR;
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("onReceive retCode= ");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append("errMsg= ");
    paramBaseRequest.append(paramString);
    paramBaseRequest.append(" mInstance =");
    paramBaseRequest.append(QCircleEeveeMananger.access$000());
    RFLog.e("QCircleEeveeMananger", i, paramBaseRequest.toString());
    i = this.val$visitScene;
    if (i == 1000) {
      QCircleLpReportDc010001.report(500, 15, 2, null, null, null, this.val$msgId, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.eevee.QCircleEeveeMananger.2
 * JD-Core Version:    0.7.0.1
 */