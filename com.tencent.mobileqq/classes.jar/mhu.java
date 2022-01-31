import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class mhu
  implements Runnable
{
  public mhu(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, BaseArticleInfo paramBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel, int paramInt, long paramLong) {}
  
  public void run()
  {
    int j = 1;
    ReportData localReportData = new ReportData();
    localReportData.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId;
    localReportData.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid)) {
      localReportData.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid;
    }
    localReportData.jdField_c_of_type_Int = ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    int i;
    label114:
    boolean bool;
    if (((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).hasChannelInfo())
    {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelInfoId;
      localReportData.jdField_d_of_type_Int = i;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleFriendLikeText)) {
        break label653;
      }
      i = 0;
      localReportData.jdField_e_of_type_Int = i;
      localReportData.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mServerContext;
      localReportData.jdField_a_of_type_JavaLangString = ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGroupId == -1L) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isSubscriptFeed())) {
        break label658;
      }
      bool = true;
      label184:
      localReportData.jdField_c_of_type_Boolean = bool;
      localReportData.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
      if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.b()) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.d())) {
        break label663;
      }
      bool = true;
      label230:
      localReportData.jdField_e_of_type_Boolean = bool;
      if (((!ReadInJoyBaseAdapter.f((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (!ReadInJoyBaseAdapter.g((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (!ReadInJoyBaseAdapter.h((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (!ReadInJoyBaseAdapter.i((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))) || (ReadInJoyBaseAdapter.m((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))) {
        break label668;
      }
      localReportData.jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Long);
      localReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.businessId);
      label337:
      if (localReportData.jdField_e_of_type_Boolean)
      {
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.b()) {
          break label914;
        }
        i = 2;
      }
    }
    for (;;)
    {
      localReportData.jdField_a_of_type_Int = i;
      localReportData.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrCircleId;
      localReportData.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
      localReportData.f = ReadInJoyUtils.d();
      localReportData.g = ReadInJoyUtils.e();
      localReportData.j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoAdsJumpType;
      localReportData.i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoAdsSource;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedType == 3)
      {
        ArrayList localArrayList = new ArrayList();
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = ReadInJoyUtils.a();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
        localReportInfo.mChannelId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_c_of_type_Int;
        localReportInfo.mAlgorithmId = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID);
        localReportInfo.mStrategyId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId;
        localReportInfo.mOperation = 7;
        localReportInfo.mServerContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mServerContext;
        localReportInfo.mReadTimeLength = -1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID)) {
          localReportInfo.mInnerId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
        }
        localArrayList.add(localReportInfo);
        ReadInJoyLogicEngine.a().a(localArrayList);
      }
      localReportData.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localReportData.k = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_c_of_type_Int == 0) {
        ReadInJoyBaseAdapter.a(localReportData);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a.put(Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID), localReportData);
      return;
      i = 0;
      break;
      label653:
      i = 1;
      break label114;
      label658:
      bool = false;
      break label184;
      label663:
      bool = false;
      break label230;
      label668:
      if ((ReadInJoyUtils.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 6))
      {
        localReportData.jdField_d_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long + "");
        localReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
        break label337;
      }
      if (ReadInJoyUtils.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        if (ReadInJoyUtils.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGroupSubArticleList.size() >= 1)
          {
            if (!TextUtils.isEmpty(((BaseArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGroupSubArticleList.get(0)).mVideoVid)) {
              localReportData.jdField_b_of_type_JavaLangString = ((BaseArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGroupSubArticleList.get(0)).mVideoVid;
            }
            localReportData.jdField_e_of_type_JavaLangString = ((BaseArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGroupSubArticleList.get(0)).innerUniqueID;
          }
        }
        for (;;)
        {
          localReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
          break;
          localReportData.k = this.jdField_a_of_type_Int;
        }
      }
      localReportData.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID;
      localReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      break label337;
      label914:
      i = j;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.d()) {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhu
 * JD-Core Version:    0.7.0.1
 */