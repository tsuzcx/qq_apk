package com.tencent.mobileqq.kandian.biz.comment;

import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.hippy.api.ParamsFetcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.TKDHippy2NativeEventSimpleReceiver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/comment/TKDCommentFragment$commentEventListener$1", "Lcom/tencent/mobileqq/kandian/biz/hippy/interfaces/receiver/common/TKDHippy2NativeEventSimpleReceiver;", "biuComment", "", "fetcher", "Lcom/tencent/mobileqq/kandian/biz/hippy/api/ParamsFetcher;", "closeComment", "invokeScrollStateChangeForExposureReport", "onCommentViewLayout", "onSubCommentClose", "onSubCommentOpen", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TKDCommentFragment$commentEventListener$1
  extends TKDHippy2NativeEventSimpleReceiver
{
  private final void a()
  {
    Object localObject = this.a;
    localObject = ((TKDCommentFragment)localObject).a((ViewGroup)((TKDCommentFragment)localObject).a());
    if (localObject != null) {
      ((HippyListView)localObject).onScrollStateChanged(((HippyListView)localObject).getScrollState(), ((HippyListView)localObject).getScrollState());
    }
  }
  
  public void biuComment(@NotNull ParamsFetcher paramParamsFetcher)
  {
    Intrinsics.checkParameterIsNotNull(paramParamsFetcher, "fetcher");
    QLog.d(TKDCommentFragment.a.a(), 1, "biuComment");
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a();
    if (localAbsBaseArticleInfo != null) {
      paramParamsFetcher.onGetParams(localAbsBaseArticleInfo, this.a.b(), this.a.a(), "");
    }
  }
  
  public void closeComment()
  {
    QLog.d(TKDCommentFragment.a.a(), 1, "closeComment");
  }
  
  public void onCommentViewLayout()
  {
    QLog.d(TKDCommentFragment.a.a(), 1, "onCommentViewLayout");
    this.a.a();
    a();
  }
  
  public void onSubCommentClose()
  {
    QLog.d(TKDCommentFragment.a.a(), 1, "closeSubComment");
    this.a.b(TKDCommentFragment.a.a());
    this.a.a();
  }
  
  public void onSubCommentOpen()
  {
    QLog.d(TKDCommentFragment.a.a(), 1, "openSubComment");
    this.a.b(TKDCommentFragment.a.b());
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.TKDCommentFragment.commentEventListener.1
 * JD-Core Version:    0.7.0.1
 */