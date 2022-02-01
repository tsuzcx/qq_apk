package cooperation.qzone;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite.StDoFollowRsp;
import java.util.concurrent.CountDownLatch;

class QzoneIPCModule$2
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoFollowRsp>
{
  QzoneIPCModule$2(QzoneIPCModule paramQzoneIPCModule, boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    QLog.i("QzoneIPCModule", 1, "flow qq circle resp " + paramBoolean + " " + paramLong + " " + paramString);
    this.val$isSuccessHolder[0] = paramBoolean;
    this.val$latch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule.2
 * JD-Core Version:    0.7.0.1
 */