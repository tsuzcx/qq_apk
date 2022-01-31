import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.util.ArrayList;

public class qjl
{
  public static VideoInfo a(BaseArticleInfo paramBaseArticleInfo)
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.g = paramBaseArticleInfo.getInnerUniqueID();
    localVideoInfo.jdField_b_of_type_Boolean = ram.a(paramBaseArticleInfo);
    localVideoInfo.jdField_d_of_type_Long = paramBaseArticleInfo.mFeedId;
    localVideoInfo.jdField_k_of_type_Int = paramBaseArticleInfo.mFeedType;
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
        localArticleInfo.mSubscribeName = paramVideoInfo.jdField_k_of_type_JavaLangString;
        localArticleInfo.mSubscribeID = paramVideoInfo.j;
        localArticleInfo.mFirstPagePicUrl = paramVideoInfo.jdField_b_of_type_JavaLangString;
        localArticleInfo.mVideoDuration = paramVideoInfo.jdField_d_of_type_Int;
        localArticleInfo.mVideoCoverUrl = sfa.a(paramVideoInfo.jdField_b_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_Int);
        localArticleInfo.mVideoVid = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localArticleInfo.mFeedType = paramVideoInfo.jdField_k_of_type_Int;
        localArticleInfo.mFeedId = paramVideoInfo.jdField_d_of_type_Long;
        localArticleInfo.mXGFileSize = paramVideoInfo.jdField_b_of_type_Long;
        localArticleInfo.busiType = paramVideoInfo.jdField_a_of_type_Int;
        localArticleInfo.mJsonVideoList = paramVideoInfo.l;
        localArticleInfo.mVideoCommentCount = paramVideoInfo.jdField_e_of_type_Int;
        localArticleInfo.mVideoJsonWidth = paramVideoInfo.jdField_b_of_type_Int;
        localArticleInfo.mVideoJsonHeight = paramVideoInfo.jdField_c_of_type_Int;
        localArticleInfo.mArticleContentUrl = paramVideoInfo.jdField_f_of_type_JavaLangString;
        localArticleInfo.thirdIcon = paramVideoInfo.E;
        localArticleInfo.thirdName = paramVideoInfo.jdField_k_of_type_JavaLangString;
        localArticleInfo.thirdAction = paramVideoInfo.D;
        localArticleInfo.thirdUin = paramVideoInfo.j;
        localArticleInfo.thirdUinName = paramVideoInfo.F;
        localArticleInfo.mVideoPlayCount = paramVideoInfo.s;
        localArticleInfo.mRecommentdReason = paramVideoInfo.h;
        localArticleInfo.videoReportInfo = paramVideoInfo.N;
        localArticleInfo.mSummary = paramVideoInfo.jdField_d_of_type_JavaLangString;
        localArticleInfo.mTime = paramVideoInfo.jdField_a_of_type_Long;
        localArticleInfo.mAlgorithmID = paramVideoInfo.jdField_f_of_type_Long;
        localArticleInfo.mDiskLikeInfoString = DislikeInfo.a(paramVideoInfo.jdField_b_of_type_JavaUtilArrayList);
        localArticleInfo.mArticleSubscriptText = paramVideoInfo.L;
        localArticleInfo.mArticleSubscriptColor = paramVideoInfo.M;
        localArticleInfo.mRecommendSeq = paramVideoInfo.jdField_e_of_type_Long;
        localArticleInfo.mVideoLogoUrl = paramVideoInfo.J;
        if (paramVideoInfo.jdField_b_of_type_Boolean)
        {
          paramVideoInfo.jdField_a_of_type_Int = 6;
          localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda = new qda();
          if (!TextUtils.isEmpty(paramVideoInfo.j)) {
            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long = Long.valueOf(paramVideoInfo.j).longValue();
          }
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int = paramVideoInfo.jdField_k_of_type_Int;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_k_of_type_JavaLangString;
          localArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int = paramVideoInfo.jdField_e_of_type_Int;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          qdc localqdc = new qdc();
          localqdc.jdField_d_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
          localqdc.jdField_e_of_type_JavaLangString = paramVideoInfo.jdField_c_of_type_JavaLangString;
          localqdc.jdField_a_of_type_Long = (paramVideoInfo.jdField_d_of_type_Int * 1000);
          localqdc.jdField_a_of_type_Int = paramVideoInfo.jdField_b_of_type_Int;
          localqdc.jdField_b_of_type_Int = paramVideoInfo.jdField_c_of_type_Int;
          localqdc.g = paramVideoInfo.g;
          if (paramVideoInfo.jdField_e_of_type_JavaLangString != null) {
            localqdc.jdField_e_of_type_Int = Integer.parseInt(paramVideoInfo.jdField_e_of_type_JavaLangString);
          }
          localqdc.h = paramVideoInfo.jdField_f_of_type_JavaLangString;
          localqdc.f = paramVideoInfo.jdField_a_of_type_Int;
          localqdc.i = paramVideoInfo.jdField_a_of_type_JavaLangString;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.add(localqdc);
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long = Long.parseLong(paramVideoInfo.j);
          paramVideoInfo = new qcg();
          paramVideoInfo.a = Long.valueOf(localArticleInfo.mFeedId);
          paramVideoInfo.b = Long.valueOf(localArticleInfo.mFeedType);
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg = paramVideoInfo;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qjl
 * JD-Core Version:    0.7.0.1
 */