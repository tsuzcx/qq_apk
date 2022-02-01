package com.tencent.mobileqq.kandian.biz.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;
import java.util.ArrayList;

public class FeedsChannelDataHelper
{
  public static VideoInfo a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.g = paramAbsBaseArticleInfo.getInnerUniqueID();
    localVideoInfo.jdField_b_of_type_Boolean = RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo);
    localVideoInfo.jdField_d_of_type_Long = paramAbsBaseArticleInfo.mFeedId;
    localVideoInfo.jdField_h_of_type_Int = paramAbsBaseArticleInfo.mFeedType;
    return localVideoInfo;
  }
  
  public static AbsBaseArticleInfo a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_Int != 0))
    {
      BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
      try
      {
        localBaseArticleInfo.rawkey = paramVideoInfo.g;
        localBaseArticleInfo.mArticleID = paramVideoInfo.jdField_c_of_type_Long;
        localBaseArticleInfo.innerUniqueID = paramVideoInfo.g;
        localBaseArticleInfo.mTitle = paramVideoInfo.jdField_c_of_type_JavaLangString;
        localBaseArticleInfo.mSubscribeName = paramVideoInfo.k;
        localBaseArticleInfo.mSubscribeID = paramVideoInfo.j;
        localBaseArticleInfo.mFirstPagePicUrl = paramVideoInfo.jdField_b_of_type_JavaLangString;
        localBaseArticleInfo.mVideoDuration = paramVideoInfo.jdField_d_of_type_Int;
        localBaseArticleInfo.mVideoCoverUrl = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramVideoInfo.jdField_b_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_Int);
        localBaseArticleInfo.mVideoVid = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localBaseArticleInfo.mFeedType = paramVideoInfo.jdField_h_of_type_Int;
        localBaseArticleInfo.mFeedId = paramVideoInfo.jdField_d_of_type_Long;
        localBaseArticleInfo.mXGFileSize = paramVideoInfo.jdField_b_of_type_Long;
        localBaseArticleInfo.busiType = paramVideoInfo.jdField_a_of_type_Int;
        localBaseArticleInfo.mJsonVideoList = paramVideoInfo.l;
        localBaseArticleInfo.mVideoCommentCount = paramVideoInfo.jdField_e_of_type_Int;
        localBaseArticleInfo.mVideoJsonWidth = paramVideoInfo.jdField_b_of_type_Int;
        localBaseArticleInfo.mVideoJsonHeight = paramVideoInfo.jdField_c_of_type_Int;
        localBaseArticleInfo.mArticleContentUrl = paramVideoInfo.jdField_f_of_type_JavaLangString;
        localBaseArticleInfo.aioShareUrl = paramVideoInfo.m;
        localBaseArticleInfo.thirdIcon = paramVideoInfo.p;
        localBaseArticleInfo.thirdName = paramVideoInfo.k;
        localBaseArticleInfo.thirdAction = paramVideoInfo.o;
        localBaseArticleInfo.thirdUin = paramVideoInfo.j;
        localBaseArticleInfo.thirdUinName = paramVideoInfo.jdField_q_of_type_JavaLangString;
        localBaseArticleInfo.mVideoPlayCount = paramVideoInfo.jdField_q_of_type_Int;
        localBaseArticleInfo.mRecommentdReason = paramVideoInfo.jdField_h_of_type_JavaLangString;
        localBaseArticleInfo.videoReportInfo = paramVideoInfo.w;
        localBaseArticleInfo.mSummary = paramVideoInfo.jdField_d_of_type_JavaLangString;
        localBaseArticleInfo.mTime = paramVideoInfo.jdField_a_of_type_Long;
        localBaseArticleInfo.mAlgorithmID = paramVideoInfo.jdField_f_of_type_Long;
        localBaseArticleInfo.mDiskLikeInfoString = DislikeInfo.a(paramVideoInfo.jdField_b_of_type_JavaUtilArrayList);
        localBaseArticleInfo.mRecommendSeq = paramVideoInfo.jdField_e_of_type_Long;
        localBaseArticleInfo.mVideoLogoUrl = paramVideoInfo.u;
        if (paramVideoInfo.jdField_b_of_type_Boolean)
        {
          paramVideoInfo.jdField_a_of_type_Int = 6;
          localBaseArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
          localBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo = new UGCFeedsInfo();
          if (!TextUtils.isEmpty(paramVideoInfo.j)) {
            localBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long = Long.valueOf(paramVideoInfo.j).longValue();
          }
          localBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Int = paramVideoInfo.jdField_h_of_type_Int;
          localBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaLangString = paramVideoInfo.k;
          localBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int = paramVideoInfo.jdField_e_of_type_Int;
          localBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          UGCVideoInfo localUGCVideoInfo = new UGCVideoInfo();
          localUGCVideoInfo.jdField_d_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
          localUGCVideoInfo.jdField_e_of_type_JavaLangString = paramVideoInfo.jdField_c_of_type_JavaLangString;
          localUGCVideoInfo.jdField_a_of_type_Long = (paramVideoInfo.jdField_d_of_type_Int * 1000);
          localUGCVideoInfo.jdField_a_of_type_Int = paramVideoInfo.jdField_b_of_type_Int;
          localUGCVideoInfo.jdField_b_of_type_Int = paramVideoInfo.jdField_c_of_type_Int;
          localUGCVideoInfo.g = paramVideoInfo.g;
          if (paramVideoInfo.jdField_e_of_type_JavaLangString != null) {
            localUGCVideoInfo.jdField_e_of_type_Int = Integer.parseInt(paramVideoInfo.jdField_e_of_type_JavaLangString);
          }
          localUGCVideoInfo.jdField_h_of_type_JavaLangString = paramVideoInfo.jdField_f_of_type_JavaLangString;
          localUGCVideoInfo.f = paramVideoInfo.jdField_a_of_type_Int;
          localUGCVideoInfo.i = paramVideoInfo.jdField_a_of_type_JavaLangString;
          localBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.add(localUGCVideoInfo);
          localBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long = Long.parseLong(paramVideoInfo.j);
          paramVideoInfo = new BiuInfo();
          paramVideoInfo.a = Long.valueOf(localBaseArticleInfo.mFeedId);
          paramVideoInfo.b = Long.valueOf(localBaseArticleInfo.mFeedType);
          localBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo = paramVideoInfo;
          return localBaseArticleInfo;
        }
      }
      catch (Throwable paramVideoInfo)
      {
        paramVideoInfo.printStackTrace();
      }
      return localBaseArticleInfo;
    }
    return null;
  }
  
  public static String a(URL paramURL)
  {
    if (paramURL != null)
    {
      if (TextUtils.isEmpty(paramURL.toString())) {
        return "";
      }
      return paramURL.toString().replace("pubaccountimage:", "");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.FeedsChannelDataHelper
 * JD-Core Version:    0.7.0.1
 */