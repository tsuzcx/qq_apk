package com.tencent.mobileqq.flashshow.model.comment;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSDeleteCommentReplyBean;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite.StDoReplyRsp;
import java.lang.ref.WeakReference;

class FSCommentManager$DeleteReplyCommentCallback
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoReplyRsp>
{
  private final WeakReference<FSCommentManager> a;
  private final FSDeleteCommentReplyBean b;
  
  public FSCommentManager$DeleteReplyCommentCallback(FSCommentManager paramFSCommentManager, FSDeleteCommentReplyBean paramFSDeleteCommentReplyBean)
  {
    this.a = new WeakReference(paramFSCommentManager);
    this.b = paramFSDeleteCommentReplyBean;
  }
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoReplyRsp paramStDoReplyRsp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onReceive] isSuccess: ");
    ((StringBuilder)localObject).append(paramBoolean);
    String str2 = ((StringBuilder)localObject).toString();
    String str1 = "null";
    if (paramBaseRequest == null) {
      localObject = "null";
    } else {
      localObject = paramBaseRequest.getTraceId();
    }
    if (paramBaseRequest == null) {
      paramBaseRequest = str1;
    } else {
      paramBaseRequest = paramBaseRequest.getCmdName();
    }
    QLog.d("FSC-DeleteReplyCommentCallback", 1, new Object[] { str2, " | retCode: ", Long.valueOf(paramLong), " | errMsg: ", paramString, " | trace id: ", localObject, " | cmd name: ", paramBaseRequest });
    paramBaseRequest = (FSCommentManager)this.a.get();
    if (paramBaseRequest == null) {
      return;
    }
    FSCommentManager.a(paramBaseRequest, paramBoolean, paramLong, paramString, paramStDoReplyRsp, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.model.comment.FSCommentManager.DeleteReplyCommentCallback
 * JD-Core Version:    0.7.0.1
 */