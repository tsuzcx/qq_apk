package com.tencent.mobileqq.kandian.biz.hippy.module;

import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDCommentBizModule$openCommentDetail$1
  implements Runnable
{
  TKDCommentBizModule$openCommentDetail$1(TKDCommentBizModule paramTKDCommentBizModule, HippyMap paramHippyMap) {}
  
  public final void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openCommentDetail() --> params:");
    ((StringBuilder)localObject).append(this.$params);
    QLog.d("TKDCommentBizModule", 1, ((StringBuilder)localObject).toString());
    if (TKDCommentBizModule.access$getActivity(this.this$0) == null)
    {
      QLog.e("TKDCommentBizModule", 1, "openCommentDetail() --> activity is null");
      return;
    }
    localObject = this.$params.getString("commentId");
    String str = this.$params.getString("anchorId");
    ITKDHippyEventDispatcher localITKDHippyEventDispatcher = TKDCommentBizModule.access$getHippyEventDispatcher$p(this.this$0);
    if (localITKDHippyEventDispatcher != null) {
      localITKDHippyEventDispatcher.openSubCommentPage((String)localObject, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDCommentBizModule.openCommentDetail.1
 * JD-Core Version:    0.7.0.1
 */