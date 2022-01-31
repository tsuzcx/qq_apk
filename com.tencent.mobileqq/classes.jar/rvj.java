import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;

public class rvj
{
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = obz.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
    localReportInfo.mChannelId = paramInt;
    localReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
    localReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
    localReportInfo.mOperation = 1;
    localReportInfo.mServerContext = paramArticleInfo.mServerContext;
    localReportInfo.mReadTimeLength = -1;
    localReportInfo.mInnerId = paramArticleInfo.innerUniqueID;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      localObject1 = new pqg();
      ((pqg)localObject1).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) {
        ((pqg)localObject1).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
      }
      ((pqg)localObject1).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((pqg)localObject1).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.d;
      Object localObject2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        ((pqg)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          pqo localpqo = (pqo)((Iterator)localObject2).next();
          if (localpqo != null) {
            ((pqg)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localpqo.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = ((pqg)localObject1);
    }
    if (odm.c((int)paramArticleInfo.mChannelID)) {
      localReportInfo.mSearchTagName = obz.f(paramArticleInfo);
    }
    Object localObject1 = obv.a().a();
    if (localObject1 != null) {
      localReportInfo.srtClickInfo = ((oidb_cmd0x64e.SRTClickInfo)localObject1);
    }
    if ((paramArticleInfo != null) && (!pol.a(paramArticleInfo)) && (!obv.a().a()) && (obz.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
      localReportInfo.noDifferenceJump = 1;
    }
    paramArticleInfo = new ArrayList();
    paramArticleInfo.add(localReportInfo);
    ogy.a().a(paramArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvj
 * JD-Core Version:    0.7.0.1
 */