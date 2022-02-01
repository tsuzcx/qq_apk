import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager.1;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager.2;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.Long;Lrcn;>;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class pgw
{
  private Pair<Integer, Long> a(Context paramContext, int paramInt)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    long l;
    if ((paramContext instanceof ReadInJoyNewFeedsActivity)) {
      if (((ReadInJoyNewFeedsActivity)paramContext).a() > 0L)
      {
        l = ((ReadInJoyNewFeedsActivity)paramContext).a();
        if (!((ReadInJoyNewFeedsActivity)paramContext).b()) {
          break label81;
        }
        paramInt = i;
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt), Long.valueOf(l));
      l = System.currentTimeMillis() - ((ReadInJoyNewFeedsActivity)paramContext).b();
      break;
      label81:
      paramInt = 1;
      continue;
      if ((paramContext instanceof SplashActivity))
      {
        paramContext = pay.a(paramContext);
        if (paramContext != null)
        {
          if (paramContext.jdField_b_of_type_Int != 0) {}
          for (paramInt = j;; paramInt = 1)
          {
            l = paramContext.a();
            break;
          }
        }
      }
      else if (pcl.c(paramInt))
      {
        if (ozh.b() != 0) {}
        for (paramInt = k;; paramInt = 1)
        {
          l = 0L;
          break;
        }
      }
      paramInt = -1;
      l = 0L;
    }
  }
  
  private static String a(long paramLong)
  {
    if ((pcl.a((int)paramLong)) || (bkwm.a(paramLong))) {
      return "0X8009CCB";
    }
    if (uhv.a(paramLong)) {
      return "0X8009356";
    }
    return "0X8009332";
  }
  
  private String a(Map<Long, uia> paramMap, String paramString1, rcn paramrcn, String paramString2, int paramInt)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        localJSONObject = new JSONObject(paramString2);
        localJSONObject.put("folder_status", paramString1);
        localJSONObject.put("is_change", pcg.a(pay.a(), paramInt));
        if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
          return localJSONObject.toString();
        }
        bool = paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isPGCShortContent();
        if ((TextUtils.isEmpty(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.proteusItemsData)) || (!paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.proteusItemsData.contains("article_main_body_text"))) {
          continue;
        }
        paramInt = 1;
      }
      catch (Exception paramMap)
      {
        JSONObject localJSONObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("RIJFrameworkReportManager", 2, QLog.getStackTraceString(paramMap));
        return paramString2;
        paramInt = 0;
        break label171;
        return paramString2;
      }
      paramMap = (uia)paramMap.get(Long.valueOf(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID));
      if ((paramMap != null) && (paramMap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        localJSONObject.put("main_text_read_time", paramMap.jdField_a_of_type_Long);
        continue;
        label171:
        if (!bool) {
          if (paramInt == 0) {}
        }
      }
    }
  }
  
  private String a(rcn paramrcn, String paramString)
  {
    int i = pgb.a((ArticleInfo)paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if ((i == 6) || (i == 66) || (i == 115) || (i == 28) || (i == 11) || (i == 26) || (i == 19)) {
      paramrcn = ofe.a(ofe.a((ArticleInfo)paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramString);
    }
    for (;;)
    {
      paramString = paramrcn;
      if (i == 6)
      {
        paramrcn = new sie(paramrcn);
        paramrcn.Z(rwv.f());
        paramString = paramrcn.a().a();
      }
      return paramString;
      if ((i == 46) || (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isTwoItem))
      {
        paramString = new sie(paramString);
        paramString.e(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid);
        paramString.V(pay.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
        paramString.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
        if (i == 46) {
          paramString.Y(0);
        }
        for (;;)
        {
          paramString.e(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
          paramrcn = paramString.a().a();
          break;
          paramString.Y(1);
        }
      }
      if (i == 118)
      {
        paramString = new sie(paramString);
        if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)
        {
          paramString.X(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
          if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
            paramString.p(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_e_of_type_JavaLangString);
          }
        }
        paramString.i(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
        paramrcn = paramString.a().a();
      }
      else if (i == 128)
      {
        paramString = new sie(paramString);
        if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo != null)
        {
          paramString.X(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.jdField_a_of_type_Int);
          if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.b != null) {
            paramString.p(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.b.jdField_e_of_type_JavaLangString);
          }
        }
        paramString.i(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
        paramrcn = paramString.a().a();
      }
      else
      {
        paramrcn = paramString;
      }
    }
  }
  
  public static void a(int paramInt)
  {
    ThreadManager.executeOnSubThread(new RIJFrameworkReportManager.2(paramInt));
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (paramInt1 == 40677)
    {
      odq.a(null, "CliOper", "", "", "0X8009294", "0X8009294", 0, 0, bkwm.a("default_feeds_proteus_offline_bid"), "", "", pay.a(paramInt1, paramString, paramInt2, paramInt3, false, -1).a(), false);
      odq.a("0X8009294", "", "", "", "", pay.b(paramInt1));
    }
    if (paramInt1 == 56) {
      odq.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "1", "", ofe.a(paramInt1, null), false);
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      return;
    }
    int i;
    label17:
    int j;
    label29:
    String str1;
    String str2;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label238;
      }
      j = 0;
      str1 = pay.d(paramArticleInfo);
      str2 = pay.a(paramArticleInfo.mAlgorithmID, pay.a(paramArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(null), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pay.f(paramArticleInfo), paramArticleInfo);
      if ((!pgb.g(paramArticleInfo)) && (!pgb.i(paramArticleInfo)) && (!pgb.j(paramArticleInfo)) && (!pgb.k(paramArticleInfo))) {
        break label243;
      }
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj == null)) {
        break label252;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long);
    }
    for (;;)
    {
      String str3 = uhv.b(paramInt);
      odq.a(null, "CliOper", "", str1, str3, str3, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), str2, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "reportGridClickEvent channelId: ", Integer.valueOf(paramInt), ", toUin: ", str1, ", r5: ", str2 });
      return;
      i = 0;
      break label17;
      label238:
      j = 1;
      break label29;
      label243:
      str1 = paramArticleInfo.mSubscribeID;
      continue;
      label252:
      str1 = "";
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    if (paramArticleInfo == null) {
      return;
    }
    long l2 = paramArticleInfo.mFeedId;
    paramInt1 += 1;
    String str1;
    long l1;
    if ((pgb.g(paramArticleInfo)) || (pgb.i(paramArticleInfo)) || (pgb.j(paramArticleInfo)) || (pgb.k(paramArticleInfo)))
    {
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj == null)) {
        break label273;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long);
      l1 = 0L;
    }
    for (;;)
    {
      label77:
      String str3 = pay.a(paramInt2, paramInt1, null, pay.a(paramArticleInfo), paramArticleInfo.innerUniqueID, pay.d(paramArticleInfo), paramArticleInfo);
      if (uhv.a(paramArticleInfo.mChannelID)) {}
      for (String str2 = "0X8009363";; str2 = "0X8008899")
      {
        odq.a(null, "CliOper", "", str1, str2, str2, 0, 0, Long.toString(l2), Long.toString(l1), "" + paramArticleInfo.mStrategyId, str3, false);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "reportGridImageClickEvent report click data, toUin: ", str1, ", r2(feedsId): ", Long.valueOf(l2), ", r3(articleId): ", Long.valueOf(l1), " r4(imagePos): ", Integer.valueOf(paramInt1), ", r5: ", str3 });
        return;
        str1 = paramArticleInfo.mSubscribeID;
        l1 = paramArticleInfo.mArticleID;
        break label77;
      }
      label273:
      l1 = 0L;
      str1 = "";
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, Activity paramActivity, int paramInt)
  {
    Object localObject1 = pay.d(paramArticleInfo);
    int i;
    int j;
    label31:
    int k;
    label44:
    Object localObject2;
    Object localObject3;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label740;
      }
      j = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label746;
      }
      k = paramArticleInfo.videoJumpChannelID;
      odq.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pay.b(paramArticleInfo.mAlgorithmID, pay.a(paramArticleInfo), paramInt, i), false);
      odq.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pay.b(paramArticleInfo.mAlgorithmID, pay.a(paramArticleInfo), paramInt, i));
      localObject2 = uhv.b(paramInt);
      if ((!pgb.i(paramArticleInfo)) && (!pgb.g(paramArticleInfo)) && (!pgb.j(paramArticleInfo)) && (!pgb.k(paramArticleInfo))) {
        break label753;
      }
      localObject3 = new sie(pay.a(paramArticleInfo.mAlgorithmID, pay.a(paramArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramActivity), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pay.f(paramArticleInfo), k, paramArticleInfo));
      if (paramInt == 0) {
        ((sie)localObject3).h(k).c((String)ofe.a.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(pay.w(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      odq.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long), (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), ((sie)localObject3).a().a(), false);
    }
    for (;;)
    {
      odq.a((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pay.a(paramArticleInfo.mAlgorithmID, pay.a(paramArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramActivity), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pay.f(paramArticleInfo), k, paramArticleInfo));
      paramActivity = new ArrayList();
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = pay.a();
      ((ReportInfo)localObject1).mSource = 0;
      ((ReportInfo)localObject1).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject1).mChannelId = paramInt;
      ((ReportInfo)localObject1).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject1).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject1).mOperation = 1;
      ((ReportInfo)localObject1).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject1).mReadTimeLength = -1;
      ((ReportInfo)localObject1).mInnerId = paramArticleInfo.innerUniqueID;
      if ((paramArticleInfo != null) && (!rbt.c(paramArticleInfo)) && (!pau.a().a()) && (pay.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        ((ReportInfo)localObject1).noDifferenceJump = 1;
      }
      if (paramArticleInfo.mVideoColumnInfo != null) {
        ((ReportInfo)localObject1).mColumnID = paramArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label902;
      }
      localObject2 = new rdy();
      ((rdy)localObject2).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null) {
        ((rdy)localObject2).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long;
      }
      ((rdy)localObject2).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((rdy)localObject2).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      localObject3 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
        break label895;
      }
      ((rdy)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        rer localrer = (rer)((Iterator)localObject3).next();
        if (localrer != null) {
          ((rdy)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrer.jdField_a_of_type_Long));
        }
      }
      i = 0;
      break;
      label740:
      j = 1;
      break label31;
      label746:
      k = 56;
      break label44;
      label753:
      localObject3 = new sie(pay.a(paramArticleInfo.mAlgorithmID, pay.a(paramArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramActivity), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pay.f(paramArticleInfo), k, paramArticleInfo));
      if (paramInt == 0) {
        ((sie)localObject3).h(k).c((String)ofe.a.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(pay.w(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      odq.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ((sie)localObject3).a().a(), false);
    }
    label895:
    ((ReportInfo)localObject1).mFeedsReportData = ((rdy)localObject2);
    label902:
    paramActivity.add(localObject1);
    pkm.a().a(paramActivity);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (!uhs.a((AdvertisementInfo)paramArticleInfo, paramInt)) {
        break label977;
      }
      paramInt = obb.T;
    }
    for (;;)
    {
      obb.a(new trn().a(BaseApplicationImpl.getContext()).a(obb.jdField_a_of_type_Int).b(paramInt).a((AdvertisementInfo)paramArticleInfo).a());
      return;
      label977:
      if (pay.a(paramArticleInfo)) {
        paramInt = obb.S;
      } else {
        paramInt = obb.N;
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString, int paramInt, Bundle paramBundle)
  {
    if (paramArticleInfo == null) {
      return;
    }
    String str2 = "";
    long l2 = 0L;
    int i = 0;
    long l3 = paramArticleInfo.mFeedId;
    int j = paramInt + 1;
    long l1;
    String str1;
    if ((pgb.g(paramArticleInfo)) || (pgb.i(paramArticleInfo)) || (pgb.j(paramArticleInfo)) || (pgb.k(paramArticleInfo)))
    {
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label376;
      }
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj == null) {
        break label376;
      }
      str2 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long);
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_JavaUtilArrayList == null) {
        break label376;
      }
      paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_JavaUtilArrayList.size();
      l1 = 0L;
      str1 = str2;
    }
    for (;;)
    {
      paramString = pay.a(paramInt, j, paramString, pay.a(paramArticleInfo), paramArticleInfo.innerUniqueID, paramArticleInfo);
      str2 = pay.a(paramInt, j, null, pay.a(paramArticleInfo), paramArticleInfo.innerUniqueID, pay.d(paramArticleInfo), paramArticleInfo);
      paramBundle.putString("to_uin", str1);
      paramBundle.putString("feeds_id", Long.toString(l3));
      paramBundle.putString("article_id", Long.toString(l1));
      paramBundle.putInt("position", j);
      paramBundle.putString("read_article_r5", paramString);
      paramBundle.putString("scroll_image_r5", str2);
      paramBundle.putLong("channel_id", paramArticleInfo.mChannelID);
      paramBundle.putString("strategy_id", "" + paramArticleInfo.mStrategyId);
      return;
      str2 = paramArticleInfo.mSubscribeID;
      l2 = paramArticleInfo.mArticleID;
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        l1 = l2;
        str1 = str2;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe != null)
        {
          l1 = l2;
          str1 = str2;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaUtilArrayList != null)
          {
            paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaUtilArrayList.size();
            l1 = l2;
            str1 = str2;
            continue;
          }
        }
      }
      label376:
      paramInt = i;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt)
  {
    a(paramArticleInfo, paramString1, paramString2, paramInt, null);
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt, Map<String, Object> paramMap)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Object localObject = pay.d(paramArticleInfo);
    if (paramArticleInfo.hasChannelInfo()) {
      int i = paramArticleInfo.mChannelInfoId;
    }
    if (TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {}
    try
    {
      localObject = pay.a(paramArticleInfo.mAlgorithmID, pay.a(paramArticleInfo), paramInt, NetworkUtil.isWifiConnected(null), (String)localObject, paramArticleInfo.innerUniqueID, pay.f(paramArticleInfo), 0, pay.d(), paramArticleInfo);
      if ((paramMap != null) && (paramMap.entrySet() != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while ((paramMap != null) && (paramMap.hasNext()))
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue().toString());
          continue;
          odq.a(null, pay.d(paramArticleInfo), paramString1, paramString2, 0, 0, phd.a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), paramMap, false);
        }
      }
    }
    catch (Exception paramMap)
    {
      AIOUtils.catchedExceptionInReleaseV2("ReadInJoyBaseAdapter", "reportClickEvent", new IllegalArgumentException(paramMap));
      paramMap = null;
    }
    for (;;)
    {
      uhz.a(paramArticleInfo, paramInt);
      return;
      paramMap = ((JSONObject)localObject).toString();
    }
  }
  
  private void a(Map<Long, rcn> paramMap, int paramInt, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (rcn)paramMap.next();
      if (!((rcn)localObject2).jdField_b_of_type_Boolean)
      {
        ((rcn)localObject2).jdField_b_of_type_Boolean = true;
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = pay.a();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = ((rcn)localObject2).jdField_a_of_type_JavaLangLong.longValue();
        localReportInfo.mChannelId = paramInt;
        localReportInfo.mAlgorithmId = ((int)((rcn)localObject2).jdField_a_of_type_Long);
        localReportInfo.mStrategyId = ((rcn)localObject2).jdField_b_of_type_Int;
        localReportInfo.mOperation = 7;
        localReportInfo.mServerContext = ((rcn)localObject2).jdField_a_of_type_ArrayOfByte;
        localReportInfo.mReadTimeLength = -1;
        localReportInfo.mInnerId = ((rcn)localObject2).jdField_e_of_type_JavaLangString;
        if (((rcn)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
          localReportInfo.mColumnID = ((rcn)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
        }
        Object localObject1;
        if (paramInt == 56)
        {
          localReportInfo.mOpSource = 11;
          localObject1 = new rdz();
          if (paramLong != 0L) {
            break label592;
          }
        }
        label592:
        for (int i = 1;; i = 0)
        {
          ((rdz)localObject1).jdField_c_of_type_Int = i;
          localObject1 = ((rdz)localObject1).toString();
          localReportInfo.mInnerId = ((rcn)localObject2).jdField_e_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("VideoReporter", 2, "reportVideoUserOperationByOidbOfFeed--mUin:" + localReportInfo.mUin + "; mSource:" + localReportInfo.mSource + "; mOpSource:" + localReportInfo.mOpSource + "; mInnerId:" + localReportInfo.mInnerId + "; mChannelId:" + localReportInfo.mChannelId + "; mAlgorithmId:" + localReportInfo.mAlgorithmId + "; mStrategyId:" + localReportInfo.mStrategyId + "; mOperation:" + localReportInfo.mOperation + "; mPlayTimeLength:" + localReportInfo.mPlayTimeLength + "; videoExtraRepoerData:" + (String)localObject1);
          }
          if (((rcn)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo == null) {
            break label605;
          }
          localObject1 = new rdy();
          ((rdy)localObject1).jdField_a_of_type_Long = ((rcn)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
          if (((rcn)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null) {
            ((rdy)localObject1).jdField_b_of_type_Long = ((rcn)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long;
          }
          ((rdy)localObject1).jdField_a_of_type_Int = ((rcn)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
          ((rdy)localObject1).jdField_b_of_type_Int = ((rcn)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
          localObject2 = ((rcn)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
          if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
            break;
          }
          ((rdy)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            rer localrer = (rer)((Iterator)localObject2).next();
            if (localrer != null) {
              ((rdy)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrer.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = ((rdy)localObject1);
        label605:
        localArrayList.add(localReportInfo);
      }
    }
    if (!localArrayList.isEmpty()) {
      pkm.a().a(localArrayList);
    }
  }
  
  private void a(Map<Long, uia> paramMap, boolean paramBoolean)
  {
    Iterator localIterator = paramMap.values().iterator();
    while (localIterator.hasNext())
    {
      uia localuia = (uia)localIterator.next();
      ArticleInfo localArticleInfo = (ArticleInfo)localuia.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((!pay.s(localArticleInfo)) || (!localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean))
      {
        String str1 = pay.d(localArticleInfo);
        paramMap = localArticleInfo.innerUniqueID;
        Object localObject = paramMap;
        if (pay.j(localArticleInfo))
        {
          localObject = paramMap;
          if (localArticleInfo.mGroupSubArticleList.size() >= 1) {
            localObject = ((BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0)).innerUniqueID;
          }
        }
        String str2 = pay.f(localArticleInfo);
        if (((pgb.g(localArticleInfo)) || (pgb.i(localArticleInfo)) || (pgb.j(localArticleInfo)) || (pgb.k(localArticleInfo))) && (!pgb.o(localArticleInfo))) {
          paramMap = String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long);
        }
        for (;;)
        {
          for (;;)
          {
            localObject = pay.a(localArticleInfo.mAlgorithmID, pay.a(localArticleInfo), (int)localArticleInfo.mChannelID, NetworkState.isWifiConn(), str1, (String)localObject, str2, 0, localuia.jdField_a_of_type_Int, localArticleInfo);
            str1 = a(localArticleInfo.mChannelID);
            try
            {
              ((JSONObject)localObject).put("exposure_time", "" + (float)localuia.jdField_a_of_type_Long / 1000.0F);
              if (pcl.c((int)localArticleInfo.mChannelID)) {
                ((JSONObject)localObject).put("cmd", bkwm.h());
              }
              odq.a(null, "CliOper", "", paramMap, str1, str1, 0, 0, Long.toString(localArticleInfo.mFeedId), localArticleInfo.mArticleID + "", localArticleInfo.mStrategyId + "", ((JSONObject)localObject).toString(), false);
            }
            catch (JSONException paramMap)
            {
              paramMap.printStackTrace();
            }
          }
          break;
          if ((pay.i(localArticleInfo)) && (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 6)) {
            paramMap = localArticleInfo.mPolymericInfo.jdField_b_of_type_Long + "";
          } else {
            paramMap = localArticleInfo.mSubscribeID;
          }
        }
      }
    }
  }
  
  private void a(rcn paramrcn)
  {
    if (pay.k(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      odq.a(null, null, "0X80097D6", "0X80097D6", 0, 0, "", "", "", "", false);
    }
  }
  
  private void a(rcn paramrcn, int paramInt)
  {
    if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 0) {
      ComponentContentRecommend.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramInt);
    }
    do
    {
      return;
      if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 1)
      {
        ComponentContentRecommendFollowList.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramInt);
        return;
      }
    } while (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int != 2);
    ComponentContentRecommendFollowGroup.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramInt);
  }
  
  private void a(rcn paramrcn, Context paramContext, int paramInt)
  {
    if (pay.j(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
    {
      Object localObject = (BaseArticleInfo)paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGroupSubArticleList.get(0);
      paramContext = uhv.a(paramContext, ((BaseArticleInfo)localObject).mArticleID, ((BaseArticleInfo)localObject).mAlgorithmID, 54, paramInt, ((BaseArticleInfo)localObject).getInnerUniqueID(), ((BaseArticleInfo)localObject).getVideoVid(), uhv.a((BaseArticleInfo)localObject), ((BaseArticleInfo)localObject).videoReportInfo);
      for (;;)
      {
        try
        {
          localObject = new JSONObject(paramContext);
          if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isShowGif)
          {
            ((JSONObject)localObject).put("short_content_gif", 1);
            localObject = ((JSONObject)localObject).toString();
            paramContext = (Context)localObject;
          }
        }
        catch (JSONException localJSONException1)
        {
          QLog.e("RIJFrameworkReportManager", 2, localJSONException1.getMessage());
          continue;
        }
        try
        {
          localObject = new JSONObject(paramContext);
          ((JSONObject)localObject).put("account_expose_card", pay.c(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          localObject = ((JSONObject)localObject).toString();
          paramContext = (Context)localObject;
        }
        catch (JSONException localJSONException2)
        {
          QLog.e("RIJFrameworkReportManager", 2, localJSONException2.getMessage());
          continue;
        }
        pay.c(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramContext);
        return;
        ((JSONObject)localObject).put("short_content_gif", 0);
      }
    }
    paramContext = uhv.a(paramContext, paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoAdsSource, paramrcn.k, paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), 54, uhv.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
    odq.a(null, "CliOper", "", paramrcn.jdField_d_of_type_JavaLangString, "0X80091A8", "0X80091A8", 0, 0, Long.toString(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID), Integer.toString(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId), paramContext, false);
    odq.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", new sie(null, null, null, null).V(54).i(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()).w(paramrcn.k + 1).f(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a().a(), false);
  }
  
  private void a(rcn paramrcn, String paramString1, String paramString2)
  {
    int i = 0;
    while (i < paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size())
    {
      odq.a(null, paramrcn.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), ((rgc)paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int + "", Integer.toString(paramrcn.jdField_b_of_type_Int), paramString1, false);
      i += 1;
    }
  }
  
  private void a(rcn paramrcn, String paramString1, String paramString2, Context paramContext, int paramInt, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    if (!paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)
    {
      localQQAppInterface = pem.a();
      if (localQQAppInterface == null) {
        break label427;
      }
    }
    label427:
    for (paramString1 = localQQAppInterface.getCurrentUin();; paramString1 = "0")
    {
      String str = pay.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID, pay.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramInt, 0, 0, NetworkUtil.isWifiConnected(paramContext), paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID, null, paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, null, (ArticleInfo)paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      odq.a(null, "CliOper", "", paramString1, paramString2, paramString2, 0, 0, paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId + "", paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID + "", paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId + "", str, false);
      paramString2 = uhv.a(paramInt);
      if (localQQAppInterface != null) {
        paramString1 = localQQAppInterface.getCurrentUin();
      }
      paramContext = pay.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID, pay.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramInt, NetworkUtil.isWifiConnected(paramContext), paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID, paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, null, 0, paramrcn.jdField_f_of_type_Int, (ArticleInfo)paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      if (paramBoolean) {
        paramInt = 1;
      }
      do
      {
        try
        {
          for (;;)
          {
            paramContext.put("from_aio", paramInt);
            paramContext = paramContext.toString();
            odq.a(null, "CliOper", "", paramString1, paramString2, paramString2, 0, 0, paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId + "", paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID + "", paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId + "", paramContext, false);
            return;
            paramInt = 0;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("RIJFrameworkReportManager", 2, localJSONException.getMessage());
          }
        }
      } while (!pay.n(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      odq.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramString1, false);
      return;
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, int paramInt)
  {
    String str = uhv.b(paramInt);
    a(paramArticleInfo, str, str, paramInt);
  }
  
  private void b(rcn paramrcn)
  {
    if ((paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null) && (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Oju != null)) {
      pay.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Oju, paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
  }
  
  private void b(rcn paramrcn, int paramInt)
  {
    if (paramrcn.jdField_c_of_type_Boolean) {
      try
      {
        if (paramrcn.jdField_d_of_type_Boolean)
        {
          JSONObject localJSONObject = pay.a();
          localJSONObject.put("feeds_source", paramrcn.jdField_a_of_type_JavaLangString);
          localJSONObject.put("kandian_mode", pay.e());
          if (uhv.a(paramInt)) {}
          for (String str = "0X8009358";; str = "0X800744E")
          {
            odq.a(null, "CliOper", "", "", str, str, 0, 0, pay.e(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), "", "", localJSONObject.toString(), false);
            return;
          }
        }
        return;
      }
      catch (JSONException paramrcn)
      {
        paramrcn.printStackTrace();
      }
    }
  }
  
  private void b(rcn paramrcn, Context paramContext, int paramInt)
  {
    long l3;
    int i;
    int j;
    int k;
    long l1;
    String str1;
    String str2;
    if ((paramrcn.jdField_c_of_type_Int == 48) || (paramrcn.jdField_c_of_type_Int == 49) || (paramrcn.jdField_c_of_type_Int == 50) || (paramrcn.jdField_c_of_type_Int == 51) || (paramrcn.jdField_c_of_type_Int == 52) || (paramrcn.jdField_c_of_type_Int == 53) || (paramrcn.jdField_c_of_type_Int == 78) || (paramrcn.jdField_c_of_type_Int == 79) || (paramrcn.jdField_c_of_type_Int == 80) || (paramrcn.jdField_c_of_type_Int == 1005) || (paramrcn.jdField_c_of_type_Int == 1006) || (paramrcn.jdField_c_of_type_Int == 1007))
    {
      l3 = paramrcn.jdField_b_of_type_Long;
      i = paramrcn.k;
      j = ozb.a(paramInt, paramrcn.jdField_c_of_type_Int);
      k = ozb.a(paramrcn.jdField_c_of_type_Int);
      l1 = 0L;
      str1 = null;
      str2 = null;
      if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
        break label302;
      }
      l1 = paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
      str1 = paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
      str2 = paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData;
    }
    label302:
    for (long l2 = paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID;; l2 = 0L)
    {
      paramContext = ozb.a(paramContext, pay.a(), j, l1, l3, i, str1, str2, k, paramInt);
      odq.a(null, paramrcn.jdField_d_of_type_JavaLangString, "0X8008E2E", "0X8008E2E", 0, 0, "", l1 + "", l2 + "", paramContext, false);
      ozb.a(7, pay.a(), (int)l2, j, l3, i, str1, str2);
      return;
    }
  }
  
  private void b(rcn paramrcn, String paramString1, String paramString2)
  {
    if ((paramrcn == null) || (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {}
    Object localObject1;
    for (;;)
    {
      return;
      try
      {
        if ((qks.a() != null) && (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo != null) && (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null))
        {
          paramString1 = new JSONObject(paramString1);
          if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean != null)
          {
            localObject1 = paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getDataAttribute(null);
            if ((localObject1 != null) && (((Map)localObject1).entrySet() != null))
            {
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while ((localObject1 != null) && (((Iterator)localObject1).hasNext()))
              {
                localObject2 = (Map.Entry)((Iterator)localObject1).next();
                paramString1.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue().toString());
              }
            }
          }
          localObject1 = paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList;
        }
      }
      catch (JSONException paramrcn)
      {
        QLog.e("RIJFrameworkReportManager", 2, paramrcn.getMessage());
        return;
      }
    }
    Object localObject2 = qks.a().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject2).next();
      if ((localInteger.intValue() < ((List)localObject1).size()) && (((List)localObject1).get(localInteger.intValue()) != null))
      {
        paramString1.put("rowkey", ((rdn)((List)localObject1).get(localInteger.intValue())).g);
        odq.a(null, "CliOper", "", paramrcn.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramrcn.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramrcn.jdField_b_of_type_Int), paramString1.toString(), false);
      }
    }
    qks.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (pcl.c(paramInt1))
    {
      if (Aladdin.getConfig(252).getIntegerFromString("fix_daily", 0) != 0) {
        break label28;
      }
      ozh.a(1);
    }
    label28:
    while (paramInt2 == 2) {
      return;
    }
    ozh.a(1);
  }
  
  public void a(Map<Integer, rcn> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      if (paramMap.hasNext())
      {
        rcn localrcn = (rcn)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
        int j = opq.jdField_b_of_type_Int;
        if ((localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null) && (localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint != null) && (localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {}
        for (int i = localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Int + 1;; i = 0)
        {
          opq.a("0X8009495", localTabChannelCoverInfo, j, i, -1);
          break;
        }
      }
    }
  }
  
  public void a(Map<Long, rcn> paramMap, boolean paramBoolean, Map<Long, uia> paramMap1, String paramString, Context paramContext, int paramInt)
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (!paramBoolean))
    {
      QLog.d("RIJFrameworkReportManager", 2, "report data is null ");
      return;
    }
    Iterator localIterator = paramMap.values().iterator();
    rcn localrcn;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localrcn = (rcn)localIterator.next();
        if (!localrcn.jdField_a_of_type_Boolean)
        {
          localrcn.jdField_a_of_type_Boolean = true;
          if ((localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo != null))
          {
            i = localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
            localrcn.jdField_c_of_type_Int = 1008;
            if (i == 5) {
              localrcn.jdField_c_of_type_Int = 1009;
            }
          }
          odq.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localrcn.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrcn.jdField_b_of_type_Int), pay.a(localrcn.jdField_a_of_type_Long, localrcn.jdField_c_of_type_Int, paramInt, localrcn.jdField_d_of_type_Int), false);
          odq.a("0X80066FC", "", "", Long.toString(localrcn.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrcn.jdField_b_of_type_Int), pay.a(localrcn.jdField_a_of_type_Long, localrcn.jdField_c_of_type_Int, paramInt, localrcn.jdField_d_of_type_Int));
          if (localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
          {
            paramMap = pay.a(localrcn.jdField_a_of_type_Long, localrcn.jdField_c_of_type_Int, paramInt, localrcn.jdField_d_of_type_Int, localrcn.jdField_e_of_type_Int, NetworkUtil.isWifiConnected(paramContext), localrcn.jdField_a_of_type_JavaLangString, localrcn.jdField_c_of_type_JavaLangString, localrcn.jdField_e_of_type_JavaLangString, pay.f(localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localrcn.jdField_f_of_type_Int, localrcn.g, localrcn.h, localrcn.jdField_f_of_type_Boolean, localrcn.j, localrcn.i, localrcn.m);
            try
            {
              localObject = new JSONObject(paramMap);
              ((JSONObject)localObject).put("feeds_type", localrcn.jdField_c_of_type_Int);
              ((JSONObject)localObject).put("folder_status", paramString);
              localObject = ((JSONObject)localObject).toString();
              paramMap = (Map<Long, rcn>)localObject;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                Object localObject;
                int j;
                long l3;
                long l1;
                QLog.e("RIJFrameworkReportManager", 2, localJSONException.getMessage());
                continue;
                str1 = "0X8007626";
              }
            }
            if (uhv.a(paramInt))
            {
              localObject = "0X8009354";
              paramMap = new sie(paramMap);
              paramMap.a(localrcn.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).f(localrcn.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
              odq.a(null, "CliOper", "", localrcn.jdField_d_of_type_JavaLangString, (String)localObject, (String)localObject, 0, 0, Long.toString(localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localrcn.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrcn.jdField_b_of_type_Int), paramMap.a().a(), false);
              odq.a((String)localObject, localrcn.jdField_d_of_type_JavaLangString, Long.toString(localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localrcn.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrcn.jdField_b_of_type_Int), pay.a(localrcn.jdField_a_of_type_Long, localrcn.jdField_c_of_type_Int, paramInt, localrcn.jdField_d_of_type_Int, localrcn.jdField_e_of_type_Int, NetworkUtil.isWifiConnected(paramContext), localrcn.jdField_a_of_type_JavaLangString, localrcn.jdField_c_of_type_JavaLangString, localrcn.jdField_e_of_type_JavaLangString, pay.f(localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localrcn.jdField_f_of_type_Int, localrcn.g, localrcn.h, localrcn.jdField_f_of_type_Boolean, localrcn.j, localrcn.i, localrcn.m));
              if ((localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo == null)) {
                continue;
              }
              j = localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
              i = 8;
              if (j == 5) {
                i = 12;
              }
              l3 = localrcn.jdField_b_of_type_Long;
              j = localrcn.k;
              l1 = 0L;
              paramMap = null;
              localObject = null;
              if (localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
                break label898;
              }
              l1 = localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
              paramMap = localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
              localObject = localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData;
            }
          }
        }
      }
    }
    label898:
    for (long l2 = localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID;; l2 = 0L)
    {
      String str2 = ozb.a(paramContext, pay.a(), 16, l1, l3, j, paramMap, (String)localObject, i, paramInt);
      odq.a(null, localrcn.jdField_d_of_type_JavaLangString, "0X8008E2E", "0X8008E2E", 0, 0, "", l1 + "", l2 + "", str2, false);
      ozb.a(7, pay.a(), (int)l2, 16, l3, j, paramMap, (String)localObject);
      break;
      String str1;
      b(paramMap1);
      return;
    }
  }
  
  public void a(Map<Long, rcn> paramMap, boolean paramBoolean1, Map<Long, uia> paramMap1, String paramString, Context paramContext, int paramInt1, int paramInt2, oiy paramoiy, boolean paramBoolean2, long paramLong)
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (!paramBoolean1))
    {
      QLog.d("RIJFrameworkReportManager", 2, "report data is null ");
      if ((paramMap1 != null) && (!paramMap1.isEmpty())) {
        a(paramMap1, paramBoolean2);
      }
      return;
    }
    phy.a(paramMap, paramInt1, paramoiy.a());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.values().iterator();
    label80:
    rcn localrcn;
    Object localObject;
    long l;
    int i;
    String str;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localrcn = (rcn)localIterator.next();
        if (!localrcn.jdField_a_of_type_Boolean)
        {
          localrcn.jdField_a_of_type_Boolean = true;
          localObject = a(paramContext, paramInt1);
          l = ((Long)((Pair)localObject).second).longValue();
          i = ((Integer)((Pair)localObject).first).intValue();
          odq.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localrcn.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrcn.jdField_b_of_type_Int), pay.a(localrcn.jdField_a_of_type_Long, localrcn.jdField_c_of_type_Int, paramInt1, localrcn.jdField_d_of_type_Int), false);
          odq.a("0X80066FC", "", "", Long.toString(localrcn.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrcn.jdField_b_of_type_Int), pay.a(localrcn.jdField_a_of_type_Long, localrcn.jdField_c_of_type_Int, paramInt1, localrcn.jdField_d_of_type_Int));
          if (localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
          {
            str = pay.a(localrcn.jdField_a_of_type_Long, localrcn.jdField_c_of_type_Int, paramInt1, localrcn.jdField_d_of_type_Int, localrcn.jdField_e_of_type_Int, NetworkUtil.isWifiConnected(paramContext), localrcn.jdField_a_of_type_JavaLangString, localrcn.jdField_c_of_type_JavaLangString, localrcn.jdField_e_of_type_JavaLangString, pay.f(localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l, i, localrcn.jdField_f_of_type_Int, localrcn.g, localrcn.h, localrcn.jdField_f_of_type_Boolean, localrcn.j, localrcn.i, localrcn.m);
            if (paramInt1 == 56)
            {
              localObject = phy.a(localrcn, str, paramoiy.a());
              label398:
              str = a(paramMap1, paramString, localrcn, (String)localObject, paramInt1);
              if (!uhv.a(paramInt1)) {
                break label525;
              }
              localObject = "0X8009354";
              label427:
              if ((!pcl.a(paramInt1)) && (!bkwm.a(paramInt1))) {
                break label918;
              }
              localObject = "0X8009CC8";
            }
          }
        }
      }
    }
    label525:
    label918:
    for (;;)
    {
      if (pgb.i(localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        a(localrcn, str, (String)localObject);
      }
      for (;;)
      {
        b(localrcn, paramContext, paramInt1);
        b(localrcn, paramInt1);
        a(localrcn);
        b(localrcn);
        break label80;
        localObject = str;
        if (paramInt1 != 0) {
          break label398;
        }
        localObject = a(localrcn, str);
        break label398;
        localObject = "0X8007626";
        break label427;
        if (pay.l(localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          a(localrcn, paramContext, paramInt1);
        }
        else if (pay.t(localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          b(localrcn, str, (String)localObject);
        }
        else if (pay.s(localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          a(localrcn, str, (String)localObject, paramContext, paramInt1, paramBoolean2);
        }
        else if (pay.u(localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          a(localrcn, paramInt1);
        }
        else
        {
          if (localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedType == 33)
          {
            localObject = localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getProteusItemData();
            if (localObject == null) {
              break;
            }
            phy.a(false, (JSONObject)localObject, localrcn);
            phy.a(true, (JSONObject)localObject, localrcn);
            continue;
          }
          if (pay.q(localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
          {
            phy.a(localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, localrcn);
          }
          else
          {
            if (pay.i(localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
            {
              BaseArticleInfo localBaseArticleInfo = localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
              JSONObject localJSONObject = pay.a(localBaseArticleInfo.mPolymericInfo);
              odq.a(null, "CliOper", "", localrcn.jdField_d_of_type_JavaLangString, "0X8008F57", "0X8008F57", 0, 0, localrcn.k + "", Long.toString(localrcn.jdField_a_of_type_JavaLangLong.longValue()), Long.toString(localBaseArticleInfo.mPolymericInfo.d), localJSONObject.toString(), false);
              if (localHashMap.containsKey(Long.valueOf(localBaseArticleInfo.mPolymericInfo.c))) {
                break label80;
              }
              localHashMap.put(Long.valueOf(localBaseArticleInfo.mPolymericInfo.c), Boolean.valueOf(true));
            }
            phy.a(localrcn, l, i, str, (String)localObject, paramContext, paramInt1, paramInt2, paramoiy, paramBoolean2);
          }
        }
      }
      if (paramInt1 != 40677) {
        a(paramMap, paramInt1, paramLong);
      }
      a(paramMap1, paramBoolean2);
      spi.a(((Integer)a(paramContext, paramInt1).first).intValue());
      return;
    }
  }
  
  public void a(Map<Long, rcn> paramMap, boolean paramBoolean1, Map<Long, uia> paramMap1, String paramString, boolean paramBoolean2, int paramInt1, Context paramContext, int paramInt2, oiy paramoiy, boolean paramBoolean3, long paramLong)
  {
    ThreadManager.post(new RIJFrameworkReportManager.1(this, paramBoolean2, paramMap, paramBoolean1, paramMap1, paramString, paramContext, paramInt1, paramInt2, paramoiy, paramBoolean3, paramLong), 5, null, false);
  }
  
  public void b(Map<Long, uia> paramMap)
  {
    a(paramMap, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgw
 * JD-Core Version:    0.7.0.1
 */