package com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleBasicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import tencent.im.oidb.articlesummary.articlesummary.PGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/longcontentinfoupdater/LongContentInfoUpdaterShortContent;", "Lcom/tencent/mobileqq/kandian/repo/feeds/longcontentinfoupdater/LongContentInfoUpdater;", "()V", "process", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class LongContentInfoUpdaterShortContent
  extends LongContentInfoUpdater
{
  protected void a()
  {
    Object localObject1 = a();
    if (localObject1 != null) {
      ((SocializeFeedsInfo)localObject1).jdField_a_of_type_Int = 3;
    }
    PGCFeedsInfo localPGCFeedsInfo = a();
    if (localPGCFeedsInfo != null)
    {
      localPGCFeedsInfo.jdField_a_of_type_Boolean = true;
      localObject1 = a();
      PGCPicInfo localPGCPicInfo = null;
      if (localObject1 != null) {
        localObject1 = ((LongContentInfo)localObject1).a;
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        localObject1 = a();
        if (localObject1 != null)
        {
          localObject1 = ((LongContentInfo)localObject1).a;
          if (localObject1 != null)
          {
            localObject1 = ((ArticleBasicInfo)localObject1).jdField_a_of_type_JavaUtilArrayList;
            break label81;
          }
        }
        localObject1 = null;
        label81:
        if (localObject1 != null)
        {
          Object localObject2 = a();
          Object localObject3 = a();
          localObject1 = localPGCPicInfo;
          if (localObject3 != null)
          {
            localObject3 = ((LongContentInfo)localObject3).a;
            localObject1 = localPGCPicInfo;
            if (localObject3 != null) {
              localObject1 = ((ArticleBasicInfo)localObject3).jdField_b_of_type_JavaLangString;
            }
          }
          ((AbsBaseArticleInfo)localObject2).mTitle = ((String)localObject1);
          localPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          localObject1 = a();
          if (localObject1 != null)
          {
            localObject1 = ((LongContentInfo)localObject1).a;
            if (localObject1 != null)
            {
              localObject1 = ((ArticleBasicInfo)localObject1).jdField_a_of_type_JavaUtilArrayList;
              if (localObject1 != null)
              {
                localObject1 = ((Iterable)localObject1).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (articlesummary.PGCPicInfo)((Iterator)localObject1).next();
                  localPGCPicInfo = new PGCPicInfo();
                  localPGCPicInfo.jdField_b_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_url.get().toStringUtf8();
                  localPGCPicInfo.jdField_c_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_thumbnail_url.get().toStringUtf8();
                  localPGCPicInfo.jdField_a_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).uint32_pic_width.get();
                  localPGCPicInfo.jdField_b_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).uint32_pic_height.get();
                  localPGCPicInfo.jdField_a_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_md5.get().toStringUtf8();
                  localPGCPicInfo.jdField_c_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).is_animation.get();
                  localPGCPicInfo.d = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_desc.get().toStringUtf8();
                  localPGCPicInfo.jdField_a_of_type_Long = ((articlesummary.PGCPicInfo)localObject2).uint64_gallery_index.get();
                  localPGCPicInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityPGCVideoInfo = new PGCVideoInfo((articlesummary.PGCVideoInfo)((articlesummary.PGCPicInfo)localObject2).msg_video_info.get());
                  localObject2 = localPGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList;
                  if (localObject2 != null) {
                    ((ArrayList)localObject2).add(localPGCPicInfo);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater.LongContentInfoUpdaterShortContent
 * JD-Core Version:    0.7.0.1
 */