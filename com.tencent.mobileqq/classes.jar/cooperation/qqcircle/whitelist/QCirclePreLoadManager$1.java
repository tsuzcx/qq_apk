package cooperation.qqcircle.whitelist;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.List;
import qqcircle.QQCircleConfig.GetMooncakeRsp;

class QCirclePreLoadManager$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleConfig.GetMooncakeRsp>
{
  QCirclePreLoadManager$1(QCirclePreLoadManager paramQCirclePreLoadManager, long paramLong) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleConfig.GetMooncakeRsp paramGetMooncakeRsp)
  {
    RFLog.d("[QcirclePublish]QCirclePreLoadManager", RFLog.USR, new Object[] { "requestWhiteList... onReceive... isSuccess:", Boolean.valueOf(paramBoolean), " retCode:", Long.valueOf(paramLong) });
    if ((!paramBoolean) || (paramGetMooncakeRsp == null) || (paramLong != 0L)) {}
    do
    {
      return;
      RFLog.d("[QcirclePublish]QCirclePreLoadManager", RFLog.USR, new Object[] { "requestWhiteList... onReceive... mAllowLongVideoSwitch:", Integer.valueOf(paramGetMooncakeRsp.allowLongVideo.get()), " mMaxLimitVideo:", Integer.valueOf(paramGetMooncakeRsp.videoLength.get()), " nextRequestTime:", Long.valueOf(System.currentTimeMillis() + paramGetMooncakeRsp.nextTimeInterval.get() * 1000) });
      LocalMultiProcConfig.putInt4Uin("sp_key_allow_long_video_switch", paramGetMooncakeRsp.allowLongVideo.get(), this.val$uin);
      LocalMultiProcConfig.putInt4Uin("sp_key_max_limit_video_length", paramGetMooncakeRsp.videoLength.get(), this.val$uin);
      LocalMultiProcConfig.putLong4Uin("sp_key_last_request_time", System.currentTimeMillis() + paramGetMooncakeRsp.nextTimeInterval.get() * 1000, this.val$uin);
      paramBaseRequest = paramGetMooncakeRsp.needClientReportSuccessRateCmd.get();
    } while ((paramBaseRequest == null) || (paramBaseRequest.size() == 0));
    try
    {
      paramString = QCircleAlphaUserReporter.convertListToStr(paramBaseRequest);
      QCircleConfig.getInstance().saveNeedClientReportSuccessRateCmd(paramString);
      QCircleAlphaUserReporter.updateCmdList(paramBaseRequest);
      return;
    }
    catch (Throwable paramBaseRequest)
    {
      RFLog.e("[QcirclePublish]QCirclePreLoadManager", RFLog.USR, "requestWhiteList... " + paramBaseRequest.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.whitelist.QCirclePreLoadManager.1
 * JD-Core Version:    0.7.0.1
 */