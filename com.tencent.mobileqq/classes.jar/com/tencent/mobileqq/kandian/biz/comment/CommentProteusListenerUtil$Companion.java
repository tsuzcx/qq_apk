package com.tencent.mobileqq.kandian.biz.comment;

import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/CommentProteusListenerUtil$Companion;", "", "()V", "TAG", "", "doReplyClick", "", "cmdStrId", "", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/comment/ReadinjoyCommentListBaseAdapter;", "commentViewItem", "Lcom/tencent/mobileqq/kandian/biz/comment/data/CommentViewItem;", "viewBase", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "getOnClickListener", "Lcom/tencent/mobileqq/kandian/biz/comment/CommentProteusListenerUtil$CommentProteusOnClickListener;", "onClickListenerSparseArray", "Landroid/util/SparseArray;", "initChooseCommentTypeClickListener", "initCommentActivityClickListener", "initCommentBannerClickListener", "initCommentContentClickListener", "initCommentDotClickListener", "initCommentFlowGuideClickListener", "initCommentFollowOnClickListener", "initCommentHideButtonClickListener", "initCommentMediaClickListener", "initCommentReplyClickListener", "initDefaultClickListener", "initDeleteCommentClickListener", "initExposeCommentClickListener", "initExposeSubCommentOneClickListener", "initExposeSubCommentTwoClickListener", "initHeadMedalClickListener", "initLikeClickListener", "initOnClickListener", "initSecondPageReplyCommentClickListener", "initSocialAvatarOnClickListener", "putOnClickListenerIntoSparseArray", "onClickListener", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CommentProteusListenerUtil$Companion
{
  private final CommentProteusListenerUtil.CommentProteusOnClickListener a()
  {
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initDefaultClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener a(int paramInt)
  {
    if (paramInt != 1023) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initSocialAvatarOnClickListener.1();
  }
  
  private final void a(int paramInt, Container paramContainer, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem, ViewBase paramViewBase)
  {
    if (paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      paramContainer = new CommentReportR5Builder(paramCommentViewItem).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "0X8009010", "0X8009010", 0, 0, String.valueOf(paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId), paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, paramContainer, false);
    }
    if ((paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof CommentData))
    {
      paramContainer = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
      if (paramContainer != null)
      {
        if (((CommentData)paramContainer).subCommentNum > 0)
        {
          if (!(paramReadinjoyCommentListBaseAdapter instanceof ReadInJoyCommentListAdapter)) {
            return;
          }
          ((ReadInJoyCommentListAdapter)paramReadinjoyCommentListBaseAdapter).a(paramCommentViewItem, CommentProteusUtil.a(paramCommentViewItem, -1), 1);
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.comment.entity.CommentData");
      }
    }
    paramReadinjoyCommentListBaseAdapter.a(paramCommentViewItem);
  }
  
  private final void a(int paramInt, CommentProteusListenerUtil.CommentProteusOnClickListener paramCommentProteusOnClickListener, SparseArray<CommentProteusListenerUtil.CommentProteusOnClickListener> paramSparseArray)
  {
    if (paramCommentProteusOnClickListener != null) {
      paramSparseArray.put(paramInt, paramCommentProteusOnClickListener);
    }
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener b(int paramInt)
  {
    if (paramInt != 1024) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentFollowOnClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener c(int paramInt)
  {
    if (paramInt != 1002) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initLikeClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener d(int paramInt)
  {
    if (paramInt != 1063) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentActivityClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener e(int paramInt)
  {
    if (paramInt != 1056) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentReplyClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener f(int paramInt)
  {
    if (paramInt != 1060) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initDeleteCommentClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener g(int paramInt)
  {
    if (paramInt != 1057) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentDotClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener h(int paramInt)
  {
    if (paramInt != 1061) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initExposeCommentClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener i(int paramInt)
  {
    if (paramInt != 1062) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentContentClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener j(int paramInt)
  {
    if (paramInt != 1065) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initHeadMedalClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener k(int paramInt)
  {
    if (paramInt != 1073) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentBannerClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener l(int paramInt)
  {
    if (paramInt != 1074) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initChooseCommentTypeClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener m(int paramInt)
  {
    if (paramInt != 1094) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentFlowGuideClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener n(int paramInt)
  {
    if (paramInt != 1095) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentMediaClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener o(int paramInt)
  {
    if (paramInt != 1080) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initExposeSubCommentOneClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener p(int paramInt)
  {
    if (paramInt != 1130) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initSecondPageReplyCommentClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener q(int paramInt)
  {
    if (paramInt != 1081) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initExposeSubCommentTwoClickListener.1();
  }
  
  private final CommentProteusListenerUtil.CommentProteusOnClickListener r(int paramInt)
  {
    if (paramInt != 1163) {
      return null;
    }
    return (CommentProteusListenerUtil.CommentProteusOnClickListener)new CommentProteusListenerUtil.Companion.initCommentHideButtonClickListener.1();
  }
  
  @NotNull
  public final CommentProteusListenerUtil.CommentProteusOnClickListener a(int paramInt, @NotNull SparseArray<CommentProteusListenerUtil.CommentProteusOnClickListener> paramSparseArray)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseArray, "onClickListenerSparseArray");
    paramSparseArray = (CommentProteusListenerUtil.CommentProteusOnClickListener)paramSparseArray.get(paramInt);
    if (paramSparseArray != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[getOnClickListener] succeed, cmdStrId = ");
        localStringBuilder.append(paramInt);
        QLog.i("CommentProteusListenerUtil", 2, localStringBuilder.toString());
      }
      return paramSparseArray;
    }
    if (QLog.isColorLevel())
    {
      paramSparseArray = new StringBuilder();
      paramSparseArray.append("[getOnClickListener] use default clickListener, cmdStrId = ");
      paramSparseArray.append(paramInt);
      QLog.i("CommentProteusListenerUtil", 2, paramSparseArray.toString());
    }
    return ((Companion)this).a();
  }
  
  @NotNull
  public final Companion a(int paramInt, @NotNull SparseArray<CommentProteusListenerUtil.CommentProteusOnClickListener> paramSparseArray)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseArray, "onClickListenerSparseArray");
    Companion localCompanion = (Companion)this;
    localCompanion.a(paramInt, localCompanion.a(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.c(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.d(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.e(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.f(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.g(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.h(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.i(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.j(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.k(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.l(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.m(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.n(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.o(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.q(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.p(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.r(paramInt), paramSparseArray);
    localCompanion.a(paramInt, localCompanion.b(paramInt), paramSparseArray);
    return localCompanion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusListenerUtil.Companion
 * JD-Core Version:    0.7.0.1
 */