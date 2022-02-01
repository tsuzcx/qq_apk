package com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/longcontentinfoupdater/LongContentInfoUpdaterVideoSmallPic;", "Lcom/tencent/mobileqq/kandian/repo/feeds/longcontentinfoupdater/LongContentInfoUpdater;", "()V", "process", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class LongContentInfoUpdaterVideoSmallPic
  extends LongContentInfoUpdater
{
  protected void e()
  {
    Object localObject1 = b();
    if (localObject1 != null) {
      ((SocializeFeedsInfo)localObject1).b = 1;
    }
    Object localObject2 = a();
    localObject1 = c();
    LongContentInfo localLongContentInfo1 = null;
    if (localObject1 != null)
    {
      localObject1 = ((LongContentInfo)localObject1).c;
      if (localObject1 != null)
      {
        localObject1 = ((PGCVideoInfo)localObject1).k;
        break label49;
      }
    }
    localObject1 = null;
    label49:
    ((AbsBaseArticleInfo)localObject2).mTitle = ((String)localObject1);
    localObject2 = d();
    if (localObject2 != null)
    {
      ((PGCFeedsInfo)localObject2).f = true;
      LongContentInfo localLongContentInfo2 = c();
      localObject1 = localLongContentInfo1;
      if (localLongContentInfo2 != null) {
        localObject1 = localLongContentInfo2.c;
      }
      ((PGCFeedsInfo)localObject2).b = new ArrayList();
      ((PGCFeedsInfo)localObject2).b.add(localObject1);
      try
      {
        localObject1 = a();
        localLongContentInfo1 = c();
        if (localLongContentInfo1 == null) {
          Intrinsics.throwNpe();
        }
        ((AbsBaseArticleInfo)localObject1).mSinglePicture = new URL(localLongContentInfo1.c.d);
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater.LongContentInfoUpdaterVideoSmallPic
 * JD-Core Version:    0.7.0.1
 */