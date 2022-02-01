package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import junit.framework.AssertionFailedError;
import kotlin.Metadata;

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
      ReadInJoyCommentEntrance.a(TKDCommentBizModule.access$getActivity(this.this$0), (Intent)localObject, 117);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDCommentBizModule.openCommentPublisher.1
 * JD-Core Version:    0.7.0.1
 */