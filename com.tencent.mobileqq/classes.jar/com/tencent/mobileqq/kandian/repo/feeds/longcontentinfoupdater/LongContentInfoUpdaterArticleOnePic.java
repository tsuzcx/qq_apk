package com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleBasicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import kotlin.Metadata;
import tencent.im.oidb.articlesummary.articlesummary.PGCPicInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/longcontentinfoupdater/LongContentInfoUpdaterArticleOnePic;", "Lcom/tencent/mobileqq/kandian/repo/feeds/longcontentinfoupdater/LongContentInfoUpdater;", "()V", "process", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class LongContentInfoUpdaterArticleOnePic
  extends LongContentInfoUpdater
{
  protected void e()
  {
    Object localObject1 = b();
    if (localObject1 != null) {
      ((SocializeFeedsInfo)localObject1).b = 1;
    }
    Object localObject3 = a();
    localObject1 = c();
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject1 = ((LongContentInfo)localObject1).b;
      if (localObject1 != null)
      {
        localObject1 = ((ArticleBasicInfo)localObject1).b;
        break label49;
      }
    }
    localObject1 = null;
    label49:
    ((AbsBaseArticleInfo)localObject3).mTitle = ((String)localObject1);
    localObject1 = d();
    if (localObject1 != null) {
      ((PGCFeedsInfo)localObject1).f = true;
    }
    try
    {
      localObject3 = c();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((LongContentInfo)localObject3).b;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((ArticleBasicInfo)localObject3).c;
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject3 = (articlesummary.PGCPicInfo)((ArrayList)localObject3).get(0);
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject3 = ((articlesummary.PGCPicInfo)localObject3).bytes_pic_url;
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject3 = ((PBBytesField)localObject3).get();
                localObject1 = localObject2;
                if (localObject3 != null) {
                  localObject1 = ((ByteStringMicro)localObject3).toStringUtf8();
                }
              }
            }
          }
        }
      }
      if (localObject1 != null)
      {
        a().mSinglePicture = new URL((String)localObject1);
        return;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      localIndexOutOfBoundsException.printStackTrace();
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater.LongContentInfoUpdaterArticleOnePic
 * JD-Core Version:    0.7.0.1
 */