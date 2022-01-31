import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.util.ArrayList;

public class qys
{
  public static VideoInfo a(BaseArticleInfo paramBaseArticleInfo)
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.jdField_g_of_type_JavaLangString = paramBaseArticleInfo.getInnerUniqueID();
    localVideoInfo.jdField_b_of_type_Boolean = rqj.b(paramBaseArticleInfo);
    localVideoInfo.jdField_d_of_type_Long = paramBaseArticleInfo.mFeedId;
    localVideoInfo.jdField_g_of_type_Int = paramBaseArticleInfo.mFeedType;
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
        localArticleInfo.innerUniqueID = paramVideoInfo.jdField_g_of_type_JavaLangString;
        localArticleInfo.mTitle = paramVideoInfo.jdField_c_of_type_JavaLangString;
        localArticleInfo.mSubscribeName = paramVideoInfo.k;
        localArticleInfo.mSubscribeID = paramVideoInfo.j;
        localArticleInfo.mFirstPagePicUrl = paramVideoInfo.jdField_b_of_type_JavaLangString;
        localArticleInfo.mVideoDuration = paramVideoInfo.jdField_d_of_type_Int;
        localArticleInfo.mVideoCoverUrl = swu.a(paramVideoInfo.jdField_b_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_Int);
        localArticleInfo.mVideoVid = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localArticleInfo.mFeedType = paramVideoInfo.jdField_g_of_type_Int;
        localArticleInfo.mFeedId = paramVideoInfo.jdField_d_of_type_Long;
        localArticleInfo.mXGFileSize = paramVideoInfo.jdField_b_of_type_Long;
        localArticleInfo.busiType = paramVideoInfo.jdField_a_of_type_Int;
        localArticleInfo.mJsonVideoList = paramVideoInfo.l;
        localArticleInfo.mVideoCommentCount = paramVideoInfo.jdField_e_of_type_Int;
        localArticleInfo.mVideoJsonWidth = paramVideoInfo.jdField_b_of_type_Int;
        localArticleInfo.mVideoJsonHeight = paramVideoInfo.jdField_c_of_type_Int;
        localArticleInfo.mArticleContentUrl = paramVideoInfo.jdField_f_of_type_JavaLangString;
        localArticleInfo.thirdIcon = paramVideoInfo.n;
        localArticleInfo.thirdName = paramVideoInfo.k;
        localArticleInfo.thirdAction = paramVideoInfo.m;
        localArticleInfo.thirdUin = paramVideoInfo.j;
        localArticleInfo.thirdUinName = paramVideoInfo.o;
        localArticleInfo.mVideoPlayCount = paramVideoInfo.p;
        localArticleInfo.mRecommentdReason = paramVideoInfo.h;
        localArticleInfo.videoReportInfo = paramVideoInfo.y;
        localArticleInfo.mSummary = paramVideoInfo.jdField_d_of_type_JavaLangString;
        localArticleInfo.mTime = paramVideoInfo.jdField_a_of_type_Long;
        localArticleInfo.mAlgorithmID = paramVideoInfo.jdField_f_of_type_Long;
        localArticleInfo.mDiskLikeInfoString = DislikeInfo.a(paramVideoInfo.jdField_b_of_type_JavaUtilArrayList);
        localArticleInfo.mArticleSubscriptText = paramVideoInfo.w;
        localArticleInfo.mArticleSubscriptColor = paramVideoInfo.x;
        localArticleInfo.mRecommendSeq = paramVideoInfo.jdField_e_of_type_Long;
        localArticleInfo.mVideoLogoUrl = paramVideoInfo.s;
        if (paramVideoInfo.jdField_b_of_type_Boolean)
        {
          paramVideoInfo.jdField_a_of_type_Int = 6;
          localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw = new qmw();
          if (!TextUtils.isEmpty(paramVideoInfo.j)) {
            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Long = Long.valueOf(paramVideoInfo.j).longValue();
          }
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Int = paramVideoInfo.jdField_g_of_type_Int;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaLangString = paramVideoInfo.k;
          localArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int = paramVideoInfo.jdField_e_of_type_Int;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          qmy localqmy = new qmy();
          localqmy.jdField_d_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
          localqmy.jdField_e_of_type_JavaLangString = paramVideoInfo.jdField_c_of_type_JavaLangString;
          localqmy.jdField_a_of_type_Long = (paramVideoInfo.jdField_d_of_type_Int * 1000);
          localqmy.jdField_a_of_type_Int = paramVideoInfo.jdField_b_of_type_Int;
          localqmy.jdField_b_of_type_Int = paramVideoInfo.jdField_c_of_type_Int;
          localqmy.jdField_g_of_type_JavaLangString = paramVideoInfo.jdField_g_of_type_JavaLangString;
          if (paramVideoInfo.jdField_e_of_type_JavaLangString != null) {
            localqmy.jdField_e_of_type_Int = Integer.parseInt(paramVideoInfo.jdField_e_of_type_JavaLangString);
          }
          localqmy.h = paramVideoInfo.jdField_f_of_type_JavaLangString;
          localqmy.f = paramVideoInfo.jdField_a_of_type_Int;
          localqmy.i = paramVideoInfo.jdField_a_of_type_JavaLangString;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList.add(localqmy);
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Long = Long.parseLong(paramVideoInfo.j);
          paramVideoInfo = new qmc();
          paramVideoInfo.a = Long.valueOf(localArticleInfo.mFeedId);
          paramVideoInfo.b = Long.valueOf(localArticleInfo.mFeedType);
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc = paramVideoInfo;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qys
 * JD-Core Version:    0.7.0.1
 */