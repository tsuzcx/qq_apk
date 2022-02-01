package com.tencent.mobileqq.kandian.biz.common.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.common.ReadinjoyJumpUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/ReadInJoyJumpUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoyJumpUtils;", "()V", "configLockScreenJumpInfo", "", "intent", "Landroid/content/Intent;", "getJumpArticleDetailPageIntent", "context", "Landroid/content/Context;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyJumpUtilsImpl
  implements IReadInJoyJumpUtils
{
  public void configLockScreenJumpInfo(@Nullable Intent paramIntent)
  {
    ReadinjoyJumpUtils.a(paramIntent);
  }
  
  @Nullable
  public Intent getJumpArticleDetailPageIntent(@Nullable Context paramContext, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadinjoyJumpUtils.b(paramContext, paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.ReadInJoyJumpUtilsImpl
 * JD-Core Version:    0.7.0.1
 */