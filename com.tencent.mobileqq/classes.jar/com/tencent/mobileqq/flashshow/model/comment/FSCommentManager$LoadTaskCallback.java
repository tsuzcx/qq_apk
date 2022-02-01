package com.tencent.mobileqq.flashshow.model.comment;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSLoadCommentListBean;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetCommentListRsp;
import java.lang.ref.WeakReference;

class FSCommentManager$LoadTaskCallback
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetCommentListRsp>, OnTaskListener<Object>
{
  private final WeakReference<FSCommentManager> a;
  @NonNull
  private final FSLoadCommentListBean b;
  
  public FSCommentManager$LoadTaskCallback(@NonNull FSLoadCommentListBean paramFSLoadCommentListBean, FSCommentManager paramFSCommentManager)
  {
    this.a = new WeakReference(paramFSCommentManager);
    this.b = paramFSLoadCommentListBean;
  }
  
  private void a(Object... paramVarArgs)
  {
    FSCommentManager localFSCommentManager = (FSCommentManager)this.a.get();
    if (localFSCommentManager == null)
    {
      QLog.d("FSC-FSCommentManager", 1, "[onComplete] manager should not be null.");
      return;
    }
    FSCommentManager.a(localFSCommentManager, this.b, paramVarArgs);
  }
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    Object localObject = "null";
    String str;
    if (paramBaseRequest == null) {
      str = "null";
    } else {
      str = paramBaseRequest.getCmdName();
    }
    if (paramBaseRequest == null) {
      paramBaseRequest = (BaseRequest)localObject;
    } else {
      paramBaseRequest = paramBaseRequest.getTraceId();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onReceive] request load task, cmdName");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(" | trace id: ");
    QLog.d("FSC-FSCommentManager", 1, new Object[] { ((StringBuilder)localObject).toString(), paramBaseRequest, " | retCode: ", Long.valueOf(paramLong), " | errMsg: ", paramString });
    a(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetCommentListRsp });
  }
  
  public void onComplete(Object... paramVarArgs)
  {
    a(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.model.comment.FSCommentManager.LoadTaskCallback
 * JD-Core Version:    0.7.0.1
 */