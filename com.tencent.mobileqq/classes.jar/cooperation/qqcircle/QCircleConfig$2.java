package cooperation.qqcircle;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import qqcircle.QQCircleSwitch.SetCircleSwitchRsp;

class QCircleConfig$2
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.SetCircleSwitchRsp>
{
  QCircleConfig$2(QCircleConfig paramQCircleConfig) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.SetCircleSwitchRsp paramSetCircleSwitchRsp)
  {
    QLog.i("QCircleFolderSplashPart", 1, "setSplashNotShowAgain isSuccess=" + paramBoolean + ",retCode=" + paramLong + ",errMsg=" + paramString);
    if ((paramBoolean) && (paramLong == 0L)) {
      QzoneConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_splash_enable", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.QCircleConfig.2
 * JD-Core Version:    0.7.0.1
 */