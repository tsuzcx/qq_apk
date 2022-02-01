import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJReportDataCollectionManager.1;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJReportDataCollectionManager.2;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class pei
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, ped paramped)
  {
    int i = 0;
    if (i < paramInt3)
    {
      int j = paramInt1 - paramInt2 + i;
      if ((j >= paramped.a().a().getCount()) || (j < 0)) {}
      for (;;)
      {
        i += 1;
        break;
        ArticleInfo localArticleInfo = (ArticleInfo)paramped.a().a().getItem(j);
        if (localArticleInfo != null) {
          a(localArticleInfo, new pwe(paramped.a().a(), localArticleInfo, paramped.a().a().getItemViewType(j), paramped.a().b(), paramped.a().a(), j, paramped.a().d(), paramped.a().a().getCount(), null, paramped.a().a()), System.currentTimeMillis(), j, paramped);
        }
      }
    }
  }
  
  public static void a(View paramView, int paramInt, BaseArticleInfo paramBaseArticleInfo, ped paramped)
  {
    if (paramInt == 46) {}
    while ((paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    VideoReport.setElementId(paramView, "card");
    pil localpil = new pil().a(Integer.valueOf(paramped.a().b())).a("14");
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)))
    {
      paramped = paramBaseArticleInfo.innerUniqueID;
      localpil = localpil.e(paramped).b("list").c("click_contentid");
      if (paramBaseArticleInfo == null) {
        break label158;
      }
      paramped = paramBaseArticleInfo.dtReportBackendInfo;
      label93:
      paramped = localpil.g(paramped);
      if (paramBaseArticleInfo == null) {
        break label164;
      }
      paramInt = paramBaseArticleInfo.dtReportContentType;
      label109:
      VideoReport.setElementParams(paramView, paramped.b(Integer.valueOf(paramInt)).a().a());
      if ((paramBaseArticleInfo == null) || (TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID))) {
        break label169;
      }
    }
    label158:
    label164:
    label169:
    for (paramBaseArticleInfo = paramBaseArticleInfo.innerUniqueID;; paramBaseArticleInfo = "null")
    {
      VideoReport.setElementReuseIdentifier(paramView, paramBaseArticleInfo);
      return;
      paramped = "null";
      break;
      paramped = "";
      break label93;
      paramInt = 5;
      break label109;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, pvc parampvc, long paramLong, int paramInt, ped paramped)
  {
    if ((paramBaseArticleInfo == null) || (paramped.a().a() == null) || (((paramBaseArticleInfo instanceof ArticleInfo)) && (paramped.a().a().b((ArticleInfo)paramBaseArticleInfo)) && (!qmh.a(paramBaseArticleInfo)))) {
      break label47;
    }
    label47:
    while ((((paramBaseArticleInfo instanceof ArticleInfo)) && (qmh.a((ArticleInfo)paramBaseArticleInfo))) || ((pay.j(paramBaseArticleInfo)) && (!pay.l(paramBaseArticleInfo)))) {
      return;
    }
    if ((paramBaseArticleInfo.hasOnlyTwoVideoFeeds()) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (paramBaseArticleInfo.mFeedType != 121))
    {
      Iterator localIterator = paramBaseArticleInfo.mSubArtilceList.iterator();
      while (localIterator.hasNext()) {
        a((ArticleInfo)localIterator.next(), new pwe(paramped.a().a(), (ArticleInfo)paramBaseArticleInfo, 46, paramped.a().b(), paramped.a().a(), paramInt, paramped.a().d(), paramped.a().a().getCount(), null, paramped.a().a()), paramLong, paramInt, paramped);
      }
    }
    qmc.a.a(paramBaseArticleInfo, paramLong, paramInt, paramped);
    int i;
    if ((pay.s(paramBaseArticleInfo)) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)) {
      if (!paramped.a().a().containsKey(Long.valueOf(-paramBaseArticleInfo.mArticleID))) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        ThreadManager.post(new RIJReportDataCollectionManager.1(paramBaseArticleInfo, parampvc, paramInt, paramped, paramLong, paramBaseArticleInfo), 5, null, true);
      }
      if (!pay.s()) {
        break;
      }
      ThreadManager.executeOnSubThread(new RIJReportDataCollectionManager.2(paramped, paramBaseArticleInfo));
      return;
      i = 0;
      continue;
      if (!paramped.a().a().containsKey(Long.valueOf(paramBaseArticleInfo.mArticleID))) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(udq paramudq, int paramInt, ped paramped)
  {
    new ArrayList();
    int i = paramudq.jdField_a_of_type_Int;
    while (i <= paramudq.jdField_b_of_type_Int)
    {
      int j = i - paramInt;
      if (j >= 0)
      {
        BaseArticleInfo localBaseArticleInfo = paramped.a(j);
        if (localBaseArticleInfo != null)
        {
          QLog.d("FeedExposureHelper", 2, "onExposure : " + localBaseArticleInfo + " proteusItemsData : " + localBaseArticleInfo.proteusItemsData);
          uhv.a(localBaseArticleInfo, paramudq.jdField_a_of_type_Long);
        }
      }
      i += 1;
    }
  }
  
  private static void b(BaseArticleInfo paramBaseArticleInfo, ped paramped)
  {
    if (paramBaseArticleInfo.mFeedType == 3)
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = pay.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramBaseArticleInfo.mArticleID;
      localReportInfo.mChannelId = paramped.a().b();
      localReportInfo.mAlgorithmId = ((int)paramBaseArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramBaseArticleInfo.mStrategyId;
      localReportInfo.mOperation = 7;
      localReportInfo.mServerContext = paramBaseArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)) {
        localReportInfo.mInnerId = paramBaseArticleInfo.innerUniqueID;
      }
      localArrayList.add(localReportInfo);
      pkm.a().a(localArrayList);
    }
  }
  
  private static void b(rcn paramrcn)
  {
    int i = 0;
    if (pay.j(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      paramrcn.jdField_b_of_type_Boolean = true;
    }
    while (paramrcn.jdField_b_of_type_Boolean) {
      return;
    }
    paramrcn.jdField_b_of_type_Boolean = true;
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = pay.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramrcn.jdField_a_of_type_JavaLangLong.longValue();
    if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
      i = (int)paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID;
    }
    localReportInfo.mChannelId = i;
    localReportInfo.mAlgorithmId = ((int)paramrcn.jdField_a_of_type_Long);
    localReportInfo.mStrategyId = paramrcn.jdField_b_of_type_Int;
    localReportInfo.mOperation = 7;
    localReportInfo.mServerContext = paramrcn.jdField_a_of_type_ArrayOfByte;
    localReportInfo.mReadTimeLength = -1;
    localReportInfo.mInnerId = paramrcn.jdField_e_of_type_JavaLangString;
    if ((paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)) {
      localReportInfo.mColumnID = paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
    }
    if ((paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null) && (!pay.l(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      rdy localrdy = new rdy();
      localrdy.jdField_a_of_type_Long = paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null) {
        localrdy.jdField_b_of_type_Long = paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long;
      }
      localrdy.jdField_a_of_type_Int = paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localrdy.jdField_b_of_type_Int = paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.d;
      Object localObject = paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localrdy.jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          rer localrer = (rer)((Iterator)localObject).next();
          if (localrer != null) {
            localrdy.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrer.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = localrdy;
    }
    if ((paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (pcl.c((int)paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID)))
    {
      localReportInfo.mSearchTagName = paramrcn.f;
      ozh.a(localReportInfo);
      return;
    }
    localArrayList.add(localReportInfo);
    QLog.d("RIJReportDataManager", 2, "report0x64eExposureInfo: article " + localReportInfo.mSourceArticleId + " exposed!");
    pkm.a().a(localArrayList);
  }
  
  private static void b(rcn paramrcn, BaseArticleInfo paramBaseArticleInfo, int paramInt, pvc parampvc)
  {
    if (((pgb.g(paramBaseArticleInfo)) || (pgb.i((ArticleInfo)paramBaseArticleInfo)) || (pgb.j((ArticleInfo)paramBaseArticleInfo)) || (pgb.k((ArticleInfo)paramBaseArticleInfo))) && (!pgb.o((ArticleInfo)paramBaseArticleInfo)))
    {
      paramrcn.jdField_d_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long);
      paramrcn.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.businessId);
      if (paramrcn.jdField_e_of_type_Boolean)
      {
        if (!parampvc.b()) {
          break label338;
        }
        paramInt = 2;
      }
    }
    for (;;)
    {
      paramrcn.jdField_a_of_type_Int = paramInt;
      return;
      if ((pay.i(paramBaseArticleInfo)) && (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 6))
      {
        paramrcn.jdField_d_of_type_JavaLangString = (paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long + "");
        paramrcn.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
        break;
      }
      if (pay.l(paramBaseArticleInfo))
      {
        if (pay.j(paramBaseArticleInfo)) {
          if (paramBaseArticleInfo.mGroupSubArticleList.size() >= 1)
          {
            if (!TextUtils.isEmpty(((BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0)).mVideoVid)) {
              paramrcn.jdField_b_of_type_JavaLangString = ((BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0)).mVideoVid;
            }
            paramrcn.jdField_e_of_type_JavaLangString = ((BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0)).innerUniqueID;
          }
        }
        for (;;)
        {
          paramrcn.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
          break;
          paramrcn.k = paramInt;
          if (paramBaseArticleInfo.mPolymericInfo != null) {
            paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Boolean = true;
          }
        }
      }
      if (pay.s(paramBaseArticleInfo))
      {
        paramrcn.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.mSubscribeID;
        paramrcn.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
        break;
      }
      paramrcn.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.mSubscribeID;
      paramrcn.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      break;
      label338:
      if (parampvc.d()) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  private static void b(rcn paramrcn, BaseArticleInfo paramBaseArticleInfo, ped paramped)
  {
    if ((pay.s(paramBaseArticleInfo)) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean))
    {
      paramped.a().a().put(Long.valueOf(-paramBaseArticleInfo.mArticleID), paramrcn);
      return;
    }
    paramped.a().a().put(Long.valueOf(paramBaseArticleInfo.mArticleID), paramrcn);
  }
  
  private static void b(rcn paramrcn, BaseArticleInfo paramBaseArticleInfo, pvc parampvc)
  {
    boolean bool2 = false;
    if ((paramBaseArticleInfo.mGroupId != -1L) || (paramBaseArticleInfo.isSubscriptFeed())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramrcn.c = bool1;
      paramrcn.jdField_d_of_type_Boolean = parampvc.a();
      if (!parampvc.b())
      {
        bool1 = bool2;
        if (!parampvc.d()) {}
      }
      else
      {
        bool1 = true;
      }
      paramrcn.jdField_e_of_type_Boolean = bool1;
      return;
    }
  }
  
  private static void b(rcn paramrcn, ped paramped)
  {
    if (pcl.c(paramped.a().b())) {}
    try
    {
      paramped.a().a().add(paramrcn);
      return;
    }
    catch (Exception paramrcn)
    {
      QLog.d("RIJReportDataManager", 2, "mDailyReportDatas error!  msg=" + paramrcn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pei
 * JD-Core Version:    0.7.0.1
 */