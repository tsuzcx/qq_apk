package com.tencent.mobileqq.flashshow.part;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flashshow.events.FSFeedEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite.StDelFeedRsp;

class FSSharePart$12$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDelFeedRsp>
{
  FSSharePart$12$1(FSSharePart.12 param12, String paramString) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      QLog.d("FSSharePart", 1, "deleteFeed  success");
      SimpleEventBus.getInstance().dispatchEvent(new FSFeedEvent(1, this.a));
      return;
    }
    QLog.e("FSSharePart", 1, "deleteFeed  error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSSharePart.12.1
 * JD-Core Version:    0.7.0.1
 */