package com.tencent.mobileqq.flashshow.redpoint;

import android.os.Looper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsRsp;
import mqq.os.MqqHandler;

class FSEeveeManager$2
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudEeveeUndealmsg.FcUndealMsgsRsp>
{
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudEeveeUndealmsg.FcUndealMsgsRsp paramFcUndealMsgsRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("onReceive retCode= ");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append("errMsg= ");
    paramBaseRequest.append(paramString);
    paramBaseRequest.append(" mInstance =");
    paramBaseRequest.append(FSEeveeManager.d());
    paramBaseRequest.append("msgs size = ");
    int i;
    if (paramFcUndealMsgsRsp == null) {
      i = -1;
    } else {
      i = paramFcUndealMsgsRsp.msgs.size();
    }
    paramBaseRequest.append(i);
    QLog.d("FSEeveeRedPoint", 1, paramBaseRequest.toString());
    if (FSEeveeManager.d() != null)
    {
      if (!paramBoolean) {
        return;
      }
      if (Looper.myLooper().equals(Looper.getMainLooper()))
      {
        FSEeveeManager.a(this.b).post(new FSEeveeManager.2.1(this, paramFcUndealMsgsRsp));
        return;
      }
      FSEeveeManager.a(this.b, paramFcUndealMsgsRsp, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.redpoint.FSEeveeManager.2
 * JD-Core Version:    0.7.0.1
 */