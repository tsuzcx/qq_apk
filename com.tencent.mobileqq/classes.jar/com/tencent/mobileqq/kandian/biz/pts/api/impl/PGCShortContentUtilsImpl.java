package com.tencent.mobileqq.kandian.biz.pts.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.pts.api.IPGCShortContentUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.PGCShortContentUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/impl/PGCShortContentUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/pts/api/IPGCShortContentUtils;", "()V", "redirectToOtherPage", "", "context", "Landroid/content/Context;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PGCShortContentUtilsImpl
  implements IPGCShortContentUtils
{
  public void redirectToOtherPage(@Nullable Context paramContext, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    PGCShortContentUtils.a(paramContext, paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.impl.PGCShortContentUtilsImpl
 * JD-Core Version:    0.7.0.1
 */