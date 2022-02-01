package com.tencent.mobileqq.flashshow.part;

import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flashshow.events.FSFeedEvent;
import com.tencent.mobileqq.flashshow.utils.FSToastUtil;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleFeedbackhit.StSetFeedbackHitRsp;

class FSDebugPart$6
  implements VSDispatchObserver.onVSRspCallBack<QQCircleFeedbackhit.StSetFeedbackHitRsp>
{
  FSDebugPart$6(FSDebugPart paramFSDebugPart, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleFeedbackhit.StSetFeedbackHitRsp paramStSetFeedbackHitRsp)
  {
    if (paramLong != 0L)
    {
      FSToastUtil.a(paramString, 0);
      return;
    }
    paramBaseRequest = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramBaseRequest = "不推荐该视频，操作成功！";
    }
    paramString = new FSFeedEvent(1).setFeedId(this.a.id.get());
    SimpleEventBus.getInstance().dispatchEvent(paramString);
    FSToastUtil.a(paramBaseRequest, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSDebugPart.6
 * JD-Core Version:    0.7.0.1
 */