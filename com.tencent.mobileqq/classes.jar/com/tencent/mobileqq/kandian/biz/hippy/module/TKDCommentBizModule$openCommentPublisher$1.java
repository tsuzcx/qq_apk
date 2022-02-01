package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentEntranceUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import junit.framework.AssertionFailedError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDCommentBizModule$openCommentPublisher$1
  implements Runnable
{
  TKDCommentBizModule$openCommentPublisher$1(TKDCommentBizModule paramTKDCommentBizModule, HippyMap paramHippyMap, Promise paramPromise) {}
  
  public final void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openCommentPublisher() --> params:");
    ((StringBuilder)localObject).append(this.$params);
    QLog.d("TKDCommentBizModule", 1, ((StringBuilder)localObject).toString());
    if (TKDCommentBizModule.access$getActivity(this.this$0) == null)
    {
      QLog.e("TKDCommentBizModule", 1, "openCommentPublisher() --> activity is null");
      return;
    }
    TKDCommentBizModule.access$setCommentPublisherPromise$p(this.this$0, this.$promise);
    TKDCommentBizModule.access$setExtraParams$p(this.this$0, this.$params.getString("extraParam"));
    try
    {
      localObject = TKDCommentBizModule.access$buildCommentEditorIntent(this.this$0, this.$params);
      IRIJCommentEntranceUtils localIRIJCommentEntranceUtils = (IRIJCommentEntranceUtils)QRoute.api(IRIJCommentEntranceUtils.class);
      Activity localActivity = TKDCommentBizModule.access$getActivity(this.this$0);
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity");
      localIRIJCommentEntranceUtils.startForResult(localActivity, (Intent)localObject, 117);
      return;
    }
    catch (AssertionFailedError localAssertionFailedError)
    {
      TKDCommentBizModule.access$handleError(this.this$0, "buildCommentEditorIntent() failed!", (Throwable)localAssertionFailedError);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      TKDCommentBizModule.access$handleError(this.this$0, "buildCommentEditorIntent() failed!", (Throwable)localClassCastException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDCommentBizModule.openCommentPublisher.1
 * JD-Core Version:    0.7.0.1
 */