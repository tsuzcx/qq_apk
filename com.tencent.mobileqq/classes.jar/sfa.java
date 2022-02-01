import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.util.ArrayList;

public class sfa
{
  public static VideoInfo a(BaseArticleInfo paramBaseArticleInfo)
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.g = paramBaseArticleInfo.getInnerUniqueID();
    localVideoInfo.jdField_b_of_type_Boolean = ppe.g(paramBaseArticleInfo);
    localVideoInfo.jdField_d_of_type_Long = paramBaseArticleInfo.mFeedId;
    localVideoInfo.jdField_h_of_type_Int = paramBaseArticleInfo.mFeedType;
    return localVideoInfo;
  }
  
  public static BaseArticleInfo a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_Int != 0))
    {
      ArticleInfo localArticleInfo = new ArticleInfo();
      try
      {
        localArticleInfo.mArticleID = paramVideoInfo.jdField_c_of_type_Long;
        localArticleInfo.innerUniqueID = paramVideoInfo.g;
        localArticleInfo.mTitle = paramVideoInfo.jdField_c_of_type_JavaLangString;
        localArticleInfo.mSubscribeName = paramVideoInfo.k;
        localArticleInfo.mSubscribeID = paramVideoInfo.j;
        localArticleInfo.mFirstPagePicUrl = paramVideoInfo.jdField_b_of_type_JavaLangString;
        localArticleInfo.mVideoDuration = paramVideoInfo.jdField_d_of_type_Int;
        localArticleInfo.mVideoCoverUrl = usq.a(paramVideoInfo.jdField_b_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_Int);
        localArticleInfo.mVideoVid = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localArticleInfo.mFeedType = paramVideoInfo.jdField_h_of_type_Int;
        localArticleInfo.mFeedId = paramVideoInfo.jdField_d_of_type_Long;
        localArticleInfo.mXGFileSize = paramVideoInfo.jdField_b_of_type_Long;
        localArticleInfo.busiType = paramVideoInfo.jdField_a_of_type_Int;
        localArticleInfo.mJsonVideoList = paramVideoInfo.l;
        localArticleInfo.mVideoCommentCount = paramVideoInfo.jdField_e_of_type_Int;
        localArticleInfo.mVideoJsonWidth = paramVideoInfo.jdField_b_of_type_Int;
        localArticleInfo.mVideoJsonHeight = paramVideoInfo.jdField_c_of_type_Int;
        localArticleInfo.mArticleContentUrl = paramVideoInfo.jdField_f_of_type_JavaLangString;
        localArticleInfo.thirdIcon = paramVideoInfo.p;
        localArticleInfo.thirdName = paramVideoInfo.k;
        localArticleInfo.thirdAction = paramVideoInfo.o;
        localArticleInfo.thirdUin = paramVideoInfo.j;
        localArticleInfo.thirdUinName = paramVideoInfo.q;
        localArticleInfo.mVideoPlayCount = paramVideoInfo.r;
        localArticleInfo.mRecommentdReason = paramVideoInfo.jdField_h_of_type_JavaLangString;
        localArticleInfo.videoReportInfo = paramVideoInfo.w;
        localArticleInfo.mSummary = paramVideoInfo.jdField_d_of_type_JavaLangString;
        localArticleInfo.mTime = paramVideoInfo.jdField_a_of_type_Long;
        localArticleInfo.mAlgorithmID = paramVideoInfo.jdField_f_of_type_Long;
        localArticleInfo.mDiskLikeInfoString = DislikeInfo.a(paramVideoInfo.jdField_a_of_type_JavaUtilArrayList);
        localArticleInfo.mRecommendSeq = paramVideoInfo.jdField_e_of_type_Long;
        localArticleInfo.mVideoLogoUrl = paramVideoInfo.u;
        if (paramVideoInfo.jdField_b_of_type_Boolean)
        {
          paramVideoInfo.jdField_a_of_type_Int = 6;
          localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq = new rrq();
          if (!TextUtils.isEmpty(paramVideoInfo.j)) {
            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long = Long.valueOf(paramVideoInfo.j).longValue();
          }
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Int = paramVideoInfo.jdField_h_of_type_Int;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaLangString = paramVideoInfo.k;
          localArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int = paramVideoInfo.jdField_e_of_type_Int;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          rrs localrrs = new rrs();
          localrrs.jdField_d_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
          localrrs.jdField_e_of_type_JavaLangString = paramVideoInfo.jdField_c_of_type_JavaLangString;
          localrrs.jdField_a_of_type_Long = (paramVideoInfo.jdField_d_of_type_Int * 1000);
          localrrs.jdField_a_of_type_Int = paramVideoInfo.jdField_b_of_type_Int;
          localrrs.jdField_b_of_type_Int = paramVideoInfo.jdField_c_of_type_Int;
          localrrs.g = paramVideoInfo.g;
          if (paramVideoInfo.jdField_e_of_type_JavaLangString != null) {
            localrrs.jdField_e_of_type_Int = Integer.parseInt(paramVideoInfo.jdField_e_of_type_JavaLangString);
          }
          localrrs.jdField_h_of_type_JavaLangString = paramVideoInfo.jdField_f_of_type_JavaLangString;
          localrrs.f = paramVideoInfo.jdField_a_of_type_Int;
          localrrs.i = paramVideoInfo.jdField_a_of_type_JavaLangString;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_b_of_type_JavaUtilArrayList.add(localrrs);
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long = Long.parseLong(paramVideoInfo.j);
          paramVideoInfo = new rqw();
          paramVideoInfo.a = Long.valueOf(localArticleInfo.mFeedId);
          paramVideoInfo.b = Long.valueOf(localArticleInfo.mFeedType);
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw = paramVideoInfo;
        }
        return localArticleInfo;
      }
      catch (Throwable paramVideoInfo)
      {
        paramVideoInfo.printStackTrace();
        return localArticleInfo;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfa
 * JD-Core Version:    0.7.0.1
 */