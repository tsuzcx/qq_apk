package cooperation.qzone;

import android.os.Bundle;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import feedcloud.FeedCloudTagcategorysvr.StTagCategoryRecomRsp;

class QzoneIPCModule$3
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudTagcategorysvr.StTagCategoryRecomRsp>
{
  QzoneIPCModule$3(QzoneIPCModule paramQzoneIPCModule, int paramInt) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudTagcategorysvr.StTagCategoryRecomRsp paramStTagCategoryRecomRsp)
  {
    QLog.i("[QzoneIPCModule_upload2]QCircle", 1, "QCircleGetRecommendTagRequest onReceive isSuccess:" + paramBoolean + " retCode:" + paramLong + " errMsg:" + paramString);
    if ((paramBoolean) && (paramLong == 0L) && (paramStTagCategoryRecomRsp != null))
    {
      paramVSBaseRequest = new Bundle();
      paramVSBaseRequest.putLong("key_return_code", paramLong);
      paramVSBaseRequest.putString("key_error_msg", paramString);
      paramVSBaseRequest.putByteArray("key_qcircle_tag_list_rsp", paramStTagCategoryRecomRsp.toByteArray());
      this.this$0.callbackResult(this.val$callbackId, EIPCResult.createResult(0, paramVSBaseRequest));
      return;
    }
    paramVSBaseRequest = new Bundle();
    paramVSBaseRequest.putLong("key_return_code", paramLong);
    paramVSBaseRequest.putString("key_error_msg", paramString);
    this.this$0.callbackResult(this.val$callbackId, EIPCResult.createResult(-102, paramVSBaseRequest));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule.3
 * JD-Core Version:    0.7.0.1
 */