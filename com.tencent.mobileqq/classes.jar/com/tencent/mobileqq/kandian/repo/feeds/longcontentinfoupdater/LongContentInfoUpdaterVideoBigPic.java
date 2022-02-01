package com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater;

import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/longcontentinfoupdater/LongContentInfoUpdaterVideoBigPic;", "Lcom/tencent/mobileqq/kandian/repo/feeds/longcontentinfoupdater/LongContentInfoUpdater;", "()V", "process", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class LongContentInfoUpdaterVideoBigPic
  extends LongContentInfoUpdater
{
  protected void e()
  {
    Object localObject = b();
    if (localObject != null) {
      ((SocializeFeedsInfo)localObject).b = 6;
    }
    localObject = d();
    if (localObject != null) {
      ((PGCFeedsInfo)localObject).f = true;
    }
    localObject = c();
    if (localObject != null)
    {
      localObject = ((LongContentInfo)localObject).c;
      if (localObject != null)
      {
        a().mTitle = ((PGCVideoInfo)localObject).k;
        a().mVideoVid = ((PGCVideoInfo)localObject).e;
      }
    }
    try
    {
      localObject = c();
      if (localObject != null)
      {
        localObject = ((LongContentInfo)localObject).c;
        if (localObject != null)
        {
          localObject = ((PGCVideoInfo)localObject).d;
          if (localObject != null)
          {
            a().mVideoCoverUrl = new URL((String)localObject);
            return;
          }
        }
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater.LongContentInfoUpdaterVideoBigPic
 * JD-Core Version:    0.7.0.1
 */