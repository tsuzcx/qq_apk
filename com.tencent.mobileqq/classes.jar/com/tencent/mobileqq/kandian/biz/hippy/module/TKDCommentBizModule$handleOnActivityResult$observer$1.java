package com.tencent.mobileqq.kandian.biz.hippy.module;

import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/hippy/module/TKDCommentBizModule$handleOnActivityResult$observer$1", "Lcom/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentForHippyObserver;", "onCreateCommentResult", "", "success", "", "errorCode", "", "comment", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TKDCommentBizModule$handleOnActivityResult$observer$1
  implements RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver
{
  public void onCreateCommentResult(boolean paramBoolean, int paramInt, @Nullable String paramString)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = -1;
    }
    Object localObject = TKDCommentBizModule.access$getCommentPublisherPromise$p(this.this$0);
    if (localObject != null) {
      ((Promise)localObject).resolve(TKDCommentBizModule.access$buildCallbackInfo(this.this$0, i, Integer.valueOf(paramInt), paramString));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreateCommentResult() --> retCode:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" errorCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" comment:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("TKDCommentBizModule", 1, ((StringBuilder)localObject).toString());
    paramString = TKDCommentBizModule.access$getHippyEventDispatcher$p(this.this$0);
    if (paramString != null) {
      paramString.scrollToNew();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDCommentBizModule.handleOnActivityResult.observer.1
 * JD-Core Version:    0.7.0.1
 */