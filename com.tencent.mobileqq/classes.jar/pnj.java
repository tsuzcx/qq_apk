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

public class pnj
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, pne parampne)
  {
    int i = 0;
    if (i < paramInt3)
    {
      int j = paramInt1 - paramInt2 + i;
      if ((j >= parampne.a().a().getCount()) || (j < 0)) {}
      for (;;)
      {
        i += 1;
        break;
        ArticleInfo localArticleInfo = (ArticleInfo)parampne.a().a().getItem(j);
        if (localArticleInfo != null) {
          a(localArticleInfo, new qhk(parampne.a().a(), localArticleInfo, parampne.a().a().getItemViewType(j), parampne.a().b(), parampne.a().a(), j, parampne.a().d(), parampne.a().a().getCount(), null, parampne.a().a()), System.currentTimeMillis(), j, parampne);
        }
      }
    }
  }
  
  public static void a(View paramView, int paramInt, BaseArticleInfo paramBaseArticleInfo, pne parampne)
  {
    if (paramInt == 46) {}
    while ((paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    VideoReport.setElementId(paramView, "card");
    pti localpti = new pti().a(Integer.valueOf(parampne.a().b())).a("14");
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)))
    {
      parampne = paramBaseArticleInfo.innerUniqueID;
      localpti = localpti.e(parampne).b("list").c("click_contentid");
      if (paramBaseArticleInfo == null) {
        break label158;
      }
      parampne = paramBaseArticleInfo.dtReportBackendInfo;
      label93:
      parampne = localpti.g(parampne);
      if (paramBaseArticleInfo == null) {
        break label164;
      }
      paramInt = paramBaseArticleInfo.dtReportContentType;
      label109:
      VideoReport.setElementParams(paramView, parampne.b(Integer.valueOf(paramInt)).a().a());
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
      parampne = "null";
      break;
      parampne = "";
      break label93;
      paramInt = 5;
      break label109;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, qfw paramqfw, long paramLong, int paramInt, pne parampne)
  {
    if ((paramBaseArticleInfo == null) || (parampne.a().a() == null) || (((paramBaseArticleInfo instanceof ArticleInfo)) && (parampne.a().a().b((ArticleInfo)paramBaseArticleInfo)) && (!qym.a(paramBaseArticleInfo)))) {
      break label47;
    }
    label47:
    while ((((paramBaseArticleInfo instanceof ArticleInfo)) && (qym.a((ArticleInfo)paramBaseArticleInfo))) || ((pqw.j(paramBaseArticleInfo)) && (!pqw.l(paramBaseArticleInfo)))) {
      return;
    }
    if ((paramBaseArticleInfo.hasOnlyTwoVideoFeeds()) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (paramBaseArticleInfo.mFeedType != 121))
    {
      Iterator localIterator = paramBaseArticleInfo.mSubArtilceList.iterator();
      while (localIterator.hasNext()) {
        a((ArticleInfo)localIterator.next(), new qhk(parampne.a().a(), (ArticleInfo)paramBaseArticleInfo, 46, parampne.a().b(), parampne.a().a(), paramInt, parampne.a().d(), parampne.a().a().getCount(), null, parampne.a().a()), paramLong, paramInt, parampne);
      }
    }
    qyh.a.a(paramBaseArticleInfo, paramLong, paramInt, parampne);
    int i;
    if ((pqw.g(paramBaseArticleInfo)) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)) {
      if (!parampne.a().a().containsKey(Long.valueOf(-paramBaseArticleInfo.mArticleID))) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        ThreadManager.post(new RIJReportDataCollectionManager.1(paramBaseArticleInfo, paramqfw, paramInt, parampne, paramLong, paramBaseArticleInfo), 5, null, true);
      }
      if (!pqt.h()) {
        break;
      }
      ThreadManager.executeOnSubThread(new RIJReportDataCollectionManager.2(parampne, paramBaseArticleInfo));
      return;
      i = 0;
      continue;
      if (!parampne.a().a().containsKey(Long.valueOf(paramBaseArticleInfo.mArticleID))) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(urn paramurn, int paramInt, pne parampne)
  {
    new ArrayList();
    int i = paramurn.jdField_a_of_type_Int;
    while (i <= paramurn.jdField_b_of_type_Int)
    {
      int j = i - paramInt;
      if (j >= 0)
      {
        BaseArticleInfo localBaseArticleInfo = parampne.a(j);
        if (localBaseArticleInfo != null)
        {
          QLog.d("FeedExposureHelper", 2, "onExposure : " + localBaseArticleInfo + " proteusItemsData : " + localBaseArticleInfo.proteusItemsData);
          uvs.a(localBaseArticleInfo, paramurn.jdField_a_of_type_Long);
        }
      }
      i += 1;
    }
  }
  
  private static void b(BaseArticleInfo paramBaseArticleInfo, pne parampne)
  {
    if (paramBaseArticleInfo.mFeedType == 3)
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = pkh.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramBaseArticleInfo.mArticleID;
      localReportInfo.mChannelId = parampne.a().b();
      localReportInfo.mAlgorithmId = ((int)paramBaseArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramBaseArticleInfo.mStrategyId;
      localReportInfo.mOperation = 7;
      localReportInfo.mServerContext = paramBaseArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)) {
        localReportInfo.mInnerId = paramBaseArticleInfo.innerUniqueID;
      }
      localArrayList.add(localReportInfo);
      pvj.a().a(localArrayList);
    }
  }
  
  private static void b(rot paramrot)
  {
    int i = 0;
    if (pqw.j(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      paramrot.jdField_b_of_type_Boolean = true;
    }
    while (paramrot.jdField_b_of_type_Boolean) {
      return;
    }
    paramrot.jdField_b_of_type_Boolean = true;
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = pkh.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramrot.jdField_a_of_type_JavaLangLong.longValue();
    if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
      i = (int)paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID;
    }
    localReportInfo.mChannelId = i;
    localReportInfo.mAlgorithmId = ((int)paramrot.jdField_a_of_type_Long);
    localReportInfo.mStrategyId = paramrot.jdField_b_of_type_Int;
    localReportInfo.mOperation = 7;
    localReportInfo.mServerContext = paramrot.jdField_a_of_type_ArrayOfByte;
    localReportInfo.mReadTimeLength = -1;
    localReportInfo.mInnerId = paramrot.jdField_e_of_type_JavaLangString;
    if ((paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)) {
      localReportInfo.mColumnID = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
    }
    if ((paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null) && (!pqw.l(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      rqf localrqf = new rqf();
      localrqf.jdField_a_of_type_Long = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null) {
        localrqf.jdField_b_of_type_Long = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long;
      }
      localrqf.jdField_a_of_type_Int = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localrqf.jdField_b_of_type_Int = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.d;
      Object localObject = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localrqf.jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          rqy localrqy = (rqy)((Iterator)localObject).next();
          if (localrqy != null) {
            localrqf.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrqy.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = localrqf;
    }
    if ((paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (plm.c((int)paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID)))
    {
      localReportInfo.mSearchTagName = paramrot.f;
      pin.a(localReportInfo);
      return;
    }
    localArrayList.add(localReportInfo);
    QLog.d("RIJReportDataManager", 2, "report0x64eExposureInfo: article " + localReportInfo.mSourceArticleId + " exposed!");
    pvj.a().a(localArrayList);
  }
  
  private static void b(rot paramrot, BaseArticleInfo paramBaseArticleInfo, int paramInt, qfw paramqfw)
  {
    if (((ppe.g(paramBaseArticleInfo)) || (ppe.i((ArticleInfo)paramBaseArticleInfo)) || (ppe.j((ArticleInfo)paramBaseArticleInfo)) || (ppe.k((ArticleInfo)paramBaseArticleInfo))) && (!ppe.o((ArticleInfo)paramBaseArticleInfo)))
    {
      paramrot.jdField_d_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long);
      paramrot.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.businessId);
      if (paramrot.jdField_e_of_type_Boolean)
      {
        if (!paramqfw.b()) {
          break label338;
        }
        paramInt = 2;
      }
    }
    for (;;)
    {
      paramrot.jdField_a_of_type_Int = paramInt;
      return;
      if ((pqw.i(paramBaseArticleInfo)) && (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 6))
      {
        paramrot.jdField_d_of_type_JavaLangString = (paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long + "");
        paramrot.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
        break;
      }
      if (pqw.l(paramBaseArticleInfo))
      {
        if (pqw.j(paramBaseArticleInfo)) {
          if (paramBaseArticleInfo.mGroupSubArticleList.size() >= 1)
          {
            if (!TextUtils.isEmpty(((BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0)).mVideoVid)) {
              paramrot.jdField_b_of_type_JavaLangString = ((BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0)).mVideoVid;
            }
            paramrot.jdField_e_of_type_JavaLangString = ((BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0)).innerUniqueID;
          }
        }
        for (;;)
        {
          paramrot.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
          break;
          paramrot.k = paramInt;
          if (paramBaseArticleInfo.mPolymericInfo != null) {
            paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Boolean = true;
          }
        }
      }
      if (pqw.g(paramBaseArticleInfo))
      {
        paramrot.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.mSubscribeID;
        paramrot.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
        break;
      }
      paramrot.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.mSubscribeID;
      paramrot.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      break;
      label338:
      if (paramqfw.d()) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  private static void b(rot paramrot, BaseArticleInfo paramBaseArticleInfo, pne parampne)
  {
    if ((pqw.g(paramBaseArticleInfo)) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean))
    {
      parampne.a().a().put(Long.valueOf(-paramBaseArticleInfo.mArticleID), paramrot);
      return;
    }
    parampne.a().a().put(Long.valueOf(paramBaseArticleInfo.mArticleID), paramrot);
  }
  
  private static void b(rot paramrot, BaseArticleInfo paramBaseArticleInfo, qfw paramqfw)
  {
    boolean bool2 = false;
    if ((paramBaseArticleInfo.mGroupId != -1L) || (paramBaseArticleInfo.isSubscriptFeed())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramrot.c = bool1;
      paramrot.jdField_d_of_type_Boolean = paramqfw.a();
      if (!paramqfw.b())
      {
        bool1 = bool2;
        if (!paramqfw.d()) {}
      }
      else
      {
        bool1 = true;
      }
      paramrot.jdField_e_of_type_Boolean = bool1;
      return;
    }
  }
  
  private static void b(rot paramrot, pne parampne)
  {
    if (plm.c(parampne.a().b())) {}
    try
    {
      parampne.a().a().add(paramrot);
      return;
    }
    catch (Exception paramrot)
    {
      QLog.d("RIJReportDataManager", 2, "mDailyReportDatas error!  msg=" + paramrot);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnj
 * JD-Core Version:    0.7.0.1
 */