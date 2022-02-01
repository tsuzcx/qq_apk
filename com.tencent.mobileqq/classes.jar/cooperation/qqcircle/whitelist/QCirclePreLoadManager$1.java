package cooperation.qqcircle.whitelist;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import qqcircle.QQCircleConfig.GetMooncakeRsp;

class QCirclePreLoadManager$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleConfig.GetMooncakeRsp>
{
  QCirclePreLoadManager$1(QCirclePreLoadManager paramQCirclePreLoadManager, long paramLong) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleConfig.GetMooncakeRsp paramGetMooncakeRsp)
  {
    QLog.d("[QcirclePublish]QCirclePreLoadManager", 1, new Object[] { "requestWhiteList... onReceive... isSuccess:", Boolean.valueOf(paramBoolean), " retCode:", Long.valueOf(paramLong) });
    if ((!paramBoolean) || (paramGetMooncakeRsp == null) || (paramLong != 0L)) {
      return;
    }
    QLog.d("[QcirclePublish]QCirclePreLoadManager", 1, new Object[] { "requestWhiteList... onReceive... mAllowLongVideoSwitch:", Integer.valueOf(paramGetMooncakeRsp.allowLongVideo.get()), " mMaxLimitVideo:", Integer.valueOf(paramGetMooncakeRsp.videoLength.get()), " nextRequestTime:", Long.valueOf(System.currentTimeMillis() + paramGetMooncakeRsp.nextTimeInterval.get() * 1000) });
    LocalMultiProcConfig.putInt4Uin("sp_key_allow_long_video_switch", paramGetMooncakeRsp.allowLongVideo.get(), this.val$uin);
    LocalMultiProcConfig.putInt4Uin("sp_key_max_limit_video_length", paramGetMooncakeRsp.videoLength.get(), this.val$uin);
    LocalMultiProcConfig.putLong4Uin("sp_key_last_request_time", System.currentTimeMillis() + paramGetMooncakeRsp.nextTimeInterval.get() * 1000, this.val$uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.whitelist.QCirclePreLoadManager.1
 * JD-Core Version:    0.7.0.1
 */