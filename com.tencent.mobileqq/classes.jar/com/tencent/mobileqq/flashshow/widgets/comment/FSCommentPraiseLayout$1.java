package com.tencent.mobileqq.flashshow.widgets.comment;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flashshow.events.FSCommentPraiseUpdateEvent;
import com.tencent.mobileqq.flashshow.utils.FSToastUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudWrite.StDoLikeRsp;

class FSCommentPraiseLayout$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoLikeRsp>
{
  FSCommentPraiseLayout$1(FSCommentPraiseLayout paramFSCommentPraiseLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    paramStDoLikeRsp = new StringBuilder();
    paramStDoLikeRsp.append("request cmd name:");
    paramStDoLikeRsp.append(paramBaseRequest.getCmdName());
    paramStDoLikeRsp.append(" | trace id: ");
    paramStDoLikeRsp.append(paramBaseRequest.getTraceId());
    paramStDoLikeRsp.append(" | error code: ");
    paramStDoLikeRsp.append(paramLong);
    paramStDoLikeRsp.append(" | error message: ");
    paramStDoLikeRsp.append(paramString);
    QLog.d("FSC-FSCommentPraiseLayout", 4, new Object[] { "[onReceive] update praise view fail, log: ", paramStDoLikeRsp.toString() });
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramBaseRequest = FSCommentPraiseLayout.a(this.e);
      paramString = "";
      if (paramBaseRequest != null) {
        paramBaseRequest = FSCommentPraiseLayout.a(this.e).id.get();
      } else {
        paramBaseRequest = "";
      }
      if (FSCommentPraiseLayout.b(this.e) != null) {
        paramString = FSCommentPraiseLayout.b(this.e).id.get();
      }
      if ((FSCommentPraiseLayout.c(this.e) == 1) && (FSCommentPraiseLayout.a(this.e) != null))
      {
        FSCommentPraiseLayout.a(this.e).likeInfo.status.set(this.a);
        FSCommentPraiseLayout.a(this.e).likeInfo.count.set(this.b);
      }
      else if ((FSCommentPraiseLayout.c(this.e) == 2) && (FSCommentPraiseLayout.b(this.e) != null))
      {
        FSCommentPraiseLayout.b(this.e).likeInfo.status.set(this.a);
        FSCommentPraiseLayout.b(this.e).likeInfo.count.set(this.b);
      }
      SimpleEventBus.getInstance().dispatchEvent(new FSCommentPraiseUpdateEvent(FSCommentPraiseLayout.c(this.e), this.a, FSCommentPraiseLayout.d(this.e).id.get(), paramBaseRequest, paramString, this.b));
    }
    else
    {
      this.e.a(this.c, this.d);
      FSToastUtil.a(paramString, 0);
    }
    FSCommentPraiseLayout.a(this.e, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSCommentPraiseLayout.1
 * JD-Core Version:    0.7.0.1
 */