package com.tencent.mobileqq.flashshow.model.barrage;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.flashshow.model.barrage.bean.FSLoadBarrageListBean;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetCommentListRsp;
import java.lang.ref.WeakReference;

class FSBarrageModel$LoadTaskCallback
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetCommentListRsp>, OnTaskListener<Object>
{
  private WeakReference<FSBarrageModel> a = null;
  @NonNull
  private final FSLoadBarrageListBean b;
  
  public FSBarrageModel$LoadTaskCallback(@NonNull FSLoadBarrageListBean paramFSLoadBarrageListBean, FSBarrageModel paramFSBarrageModel)
  {
    this.a = new WeakReference(paramFSBarrageModel);
    this.b = paramFSLoadBarrageListBean;
  }
  
  private void a(Object... paramVarArgs)
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (FSBarrageModel)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("DM-FSBarrageModel", 1, "[onComplete] manager should not be null.");
      return;
    }
    FSBarrageModel.a((FSBarrageModel)localObject, this.b, paramVarArgs);
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
    QLog.d("DM-FSBarrageModel", 1, new Object[] { ((StringBuilder)localObject).toString(), paramBaseRequest, " | retCode: ", Long.valueOf(paramLong), " | errMsg: ", paramString });
    a(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetCommentListRsp });
  }
  
  public void onComplete(Object... paramVarArgs)
  {
    a(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.model.barrage.FSBarrageModel.LoadTaskCallback
 * JD-Core Version:    0.7.0.1
 */