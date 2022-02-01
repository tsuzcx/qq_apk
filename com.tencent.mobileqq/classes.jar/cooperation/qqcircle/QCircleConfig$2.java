package cooperation.qqcircle;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import qqcircle.QQCircleSwitch.SetCircleSwitchRsp;

class QCircleConfig$2
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.SetCircleSwitchRsp>
{
  QCircleConfig$2(QCircleConfig paramQCircleConfig) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.SetCircleSwitchRsp paramSetCircleSwitchRsp)
  {
    int i = RFLog.USR;
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("setSplashNotShowAgain isSuccess=");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append(",retCode=");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(",errMsg=");
    paramBaseRequest.append(paramString);
    RFLog.i("QCircleFolderSplashPart", i, paramBaseRequest.toString());
    if ((paramBoolean) && (paramLong == 0L)) {
      this.this$0.updateOneConfig("qqcircle", "qqcircle_splash_enable", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.QCircleConfig.2
 * JD-Core Version:    0.7.0.1
 */