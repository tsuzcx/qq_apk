package com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.OutsideLinkInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/longcontentinfoupdater/LongContentInfoUpdaterOutsideLink;", "Lcom/tencent/mobileqq/kandian/repo/feeds/longcontentinfoupdater/LongContentInfoUpdater;", "()V", "process", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class LongContentInfoUpdaterOutsideLink
  extends LongContentInfoUpdater
{
  protected void e()
  {
    Object localObject = b();
    if (localObject != null) {
      ((SocializeFeedsInfo)localObject).b = 19191924;
    }
    localObject = d();
    if (localObject != null) {
      ((PGCFeedsInfo)localObject).f = true;
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo = a();
    localObject = c();
    if (localObject != null)
    {
      localObject = ((LongContentInfo)localObject).d;
      if (localObject != null)
      {
        localObject = ((OutsideLinkInfo)localObject).a;
        break label62;
      }
    }
    localObject = null;
    label62:
    localAbsBaseArticleInfo.mTitle = ((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater.LongContentInfoUpdaterOutsideLink
 * JD-Core Version:    0.7.0.1
 */