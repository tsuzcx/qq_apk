package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.app.Activity;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDBiuModule$openCommentPublisher$1
  implements Runnable
{
  TKDBiuModule$openCommentPublisher$1(TKDBiuModule paramTKDBiuModule, HippyMap paramHippyMap) {}
  
  public final void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("openBiuPublisher() --> params:");
    ((StringBuilder)localObject1).append(this.$params);
    QLog.d("TKDBiuModule", 1, ((StringBuilder)localObject1).toString());
    if (TKDBiuModule.access$getActivity(this.this$0) == null)
    {
      QLog.e("TKDBiuModule", 1, "openCommentPublisher() --> activity is null");
      return;
    }
    try
    {
      localObject1 = this.this$0;
      localObject2 = this.$params;
      Activity localActivity = TKDBiuModule.access$getActivity(this.this$0);
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity");
      TKDBiuModule.access$openBiuEditor((TKDBiuModule)localObject1, (HippyMap)localObject2, localActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("buildBiuEditorIntent() failed! ");
      ((StringBuilder)localObject2).append(localClassCastException.getMessage());
      QLog.e("TKDBiuModule", 1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDBiuModule.openCommentPublisher.1
 * JD-Core Version:    0.7.0.1
 */