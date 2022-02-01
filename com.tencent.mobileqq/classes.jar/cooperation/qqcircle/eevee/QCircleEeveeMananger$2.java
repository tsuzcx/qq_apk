package cooperation.qqcircle.eevee;

import android.os.Looper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qqcircle.report.QCircleLpReportDc010001.DataBuilder;
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
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("onReceive retCode= ");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append("errMsg= ");
    paramBaseRequest.append(paramString);
    paramBaseRequest.append(" mInstance =");
    paramBaseRequest.append(QCircleEeveeMananger.access$000());
    QLog.e("QCircleEeveeMananger", 1, paramBaseRequest.toString());
    if (this.val$visitScene == 1000) {
      QCircleLpReportDc010001.report(new QCircleLpReportDc010001.DataBuilder().setActionType(500).setSubActionType(15).setThrActionType(2).setEeveeMsgId(this.val$msgId).setScene(this.val$visitScene));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.eevee.QCircleEeveeMananger.2
 * JD-Core Version:    0.7.0.1
 */