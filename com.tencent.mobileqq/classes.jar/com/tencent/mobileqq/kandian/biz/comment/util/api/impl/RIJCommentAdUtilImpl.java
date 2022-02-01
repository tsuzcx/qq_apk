package com.tencent.mobileqq.kandian.biz.comment.util.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentAdUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/util/api/impl/RIJCommentAdUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentAdUtil;", "()V", "jumpToLandingPage", "", "context", "Landroid/content/Context;", "videoStartPosition", "", "advertisementInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentAdUtilImpl
  implements IRIJCommentAdUtil
{
  public static final RIJCommentAdUtilImpl.Companion Companion = new RIJCommentAdUtilImpl.Companion(null);
  private static final String TAG = "RIJCommentAdUtilImpl";
  
  public void jumpToLandingPage(@Nullable Context paramContext, long paramLong, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo))
    {
      RIJCommentAdUtils.a(paramContext, paramLong, (AdvertisementInfo)paramAbsBaseArticleInfo);
      return;
    }
    ReadInJoyHelper.a("RIJCommentAdUtilImpl", (Throwable)new IllegalArgumentException("advertisementInfo must be instance of AdvertisementInfo"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.api.impl.RIJCommentAdUtilImpl
 * JD-Core Version:    0.7.0.1
 */