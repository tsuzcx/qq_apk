package com.tencent.mobileqq.kandian.biz.hippy.module;

import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDCommentBizModule$onDeleteComment$1
  implements Runnable
{
  TKDCommentBizModule$onDeleteComment$1(TKDCommentBizModule paramTKDCommentBizModule, HippyMap paramHippyMap, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDeleteComment() --> params:");
    ((StringBuilder)localObject).append(this.$params);
    QLog.d("TKDCommentBizModule", 1, ((StringBuilder)localObject).toString());
    localObject = TKDCommentBizModule.access$getHippyEventDispatcher$p(this.this$0);
    if (localObject != null) {
      ((ITKDHippyEventDispatcher)localObject).onDeleteComment(this.$rowkey, this.$commentId, this.$seq, this.$totalDeleteCount);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDCommentBizModule.onDeleteComment.1
 * JD-Core Version:    0.7.0.1
 */