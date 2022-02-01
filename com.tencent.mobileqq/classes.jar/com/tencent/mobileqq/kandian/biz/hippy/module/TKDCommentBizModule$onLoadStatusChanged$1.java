package com.tencent.mobileqq.kandian.biz.hippy.module;

import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDCommentBizModule$onLoadStatusChanged$1
  implements Runnable
{
  TKDCommentBizModule$onLoadStatusChanged$1(TKDCommentBizModule paramTKDCommentBizModule, HippyMap paramHippyMap) {}
  
  public final void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLoadStatusChanged() --> params:");
    ((StringBuilder)localObject).append(this.$params);
    QLog.d("TKDCommentBizModule", 1, ((StringBuilder)localObject).toString());
    if (TKDCommentBizModule.access$getActivity(this.this$0) == null)
    {
      QLog.e("TKDCommentBizModule", 1, "onLoadStatusChanged() --> activity is null");
      return;
    }
    int i = this.$params.getInt("status");
    localObject = TKDCommentBizModule.access$getHippyEventDispatcher$p(this.this$0);
    if (localObject != null) {
      ((ITKDHippyEventDispatcher)localObject).onHippyLoadStatusChanged(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDCommentBizModule.onLoadStatusChanged.1
 * JD-Core Version:    0.7.0.1
 */