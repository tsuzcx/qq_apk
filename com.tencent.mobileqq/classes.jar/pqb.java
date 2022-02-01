import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager.1;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager.2;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager.3;
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
import java.util.Map<Ljava.lang.Long;Lrot;>;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class pqb
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
        paramContext = pqx.a(paramContext);
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
      else if (plm.c(paramInt))
      {
        if (pin.b() != 0) {}
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
    if ((plm.a((int)paramLong)) || (bmhv.a(paramLong))) {
      return "0X8009CCB";
    }
    if (uvs.a(paramLong)) {
      return "0X8009356";
    }
    return "0X8009332";
  }
  
  public static String a(String paramString, String[] paramArrayOfString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfString == null)) {}
    label60:
    for (;;)
    {
      return null;
      int j = paramArrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label60;
        }
        String str = paramArrayOfString[i];
        if (str.contains(paramString))
        {
          paramString = str.split("=");
          if (paramString.length != 2) {
            break;
          }
          return paramString[1];
        }
        i += 1;
      }
    }
  }
  
  private String a(Map<Long, uvx> paramMap, String paramString1, rot paramrot, String paramString2, int paramInt)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        localJSONObject = new JSONObject(paramString2);
        localJSONObject.put("folder_status", paramString1);
        localJSONObject.put("is_change", plh.a(pkh.a(), paramInt));
        if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
          return localJSONObject.toString();
        }
        bool = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isPGCShortContent();
        if ((TextUtils.isEmpty(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.proteusItemsData)) || (!paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.proteusItemsData.contains("article_main_body_text"))) {
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
      paramMap = (uvx)paramMap.get(Long.valueOf(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID));
      if ((paramMap != null) && (paramMap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
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
  
  private String a(rot paramrot, String paramString)
  {
    int i = ppe.a((ArticleInfo)paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if ((i == 6) || (i == 66) || (i == 115) || (i == 28) || (i == 11) || (i == 26) || (i == 19)) {
      paramrot = omx.a(omx.a((ArticleInfo)paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramString);
    }
    for (;;)
    {
      paramString = paramrot;
      if (i == 6)
      {
        paramrot = new suu(paramrot);
        paramrot.Z(six.f());
        paramString = paramrot.a().a();
      }
      return paramString;
      if ((i == 46) || (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isTwoItem))
      {
        paramString = new suu(paramString);
        paramString.e(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid);
        paramString.V(pqw.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
        paramString.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
        if (i == 46) {
          paramString.Y(0);
        }
        for (;;)
        {
          paramString.e(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
          paramrot = paramString.a().a();
          break;
          paramString.Y(1);
        }
      }
      if (i == 118)
      {
        paramString = new suu(paramString);
        if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)
        {
          paramString.X(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
          if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
            paramString.p(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_e_of_type_JavaLangString);
          }
        }
        paramString.i(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
        paramrot = paramString.a().a();
      }
      else if (i == 128)
      {
        paramString = new suu(paramString);
        if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo != null)
        {
          paramString.X(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.jdField_a_of_type_Int);
          if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.b != null) {
            paramString.p(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.b.jdField_e_of_type_JavaLangString);
          }
        }
        paramString.i(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
        paramrot = paramString.a().a();
      }
      else
      {
        paramrot = paramString;
      }
    }
  }
  
  public static void a(int paramInt)
  {
    ThreadManager.executeOnSubThread(new RIJFrameworkReportManager.3(paramInt));
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (paramInt1 == 40677)
    {
      olh.a(null, "CliOper", "", "", "0X8009294", "0X8009294", 0, 0, bmhv.a("default_feeds_proteus_offline_bid"), "", "", pqf.a(paramInt1, paramString, paramInt2, paramInt3, false, -1).a(), false);
      olh.a("0X8009294", "", "", "", "", pqf.b(paramInt1));
    }
    if (paramInt1 == 56) {
      olh.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "1", "", omx.a(paramInt1, null), false);
    }
  }
  
  public static void a(int paramInt, long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    ThreadManager.executeOnSubThread(new RIJFrameworkReportManager.1(paramInt, System.currentTimeMillis() - paramLong));
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mOperation = paramInt1;
      localReportInfo.mSourceArticleId = Long.valueOf(paramString1).longValue();
      localReportInfo.mAlgorithmId = Integer.valueOf(paramString3).intValue();
      localReportInfo.mStrategyId = Integer.valueOf(paramString2).intValue();
      localReportInfo.mUin = pnn.a();
      if (TextUtils.isEmpty(paramString4)) {}
      for (long l = -1L;; l = Long.valueOf(paramString4).longValue())
      {
        localReportInfo.mPuin = l;
        paramInt1 = paramInt2;
        if (paramInt2 == -1) {
          paramInt1 = prp.jdField_a_of_type_Int;
        }
        localReportInfo.mFolderStatus = paramInt1;
        localArrayList.add(localReportInfo);
        new qia(null, null, qxn.a(), null).b(localArrayList);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("RIJFrameworkReportManager", 1, "reportRealTimeKandianAction error ", paramString1);
    }
  }
  
  public static void a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "0X800A189";; str = "0X800A18A")
    {
      olh.a(null, null, str, str, 0, 0, "", "", "", new suu(null, null, null, null).e(paramLong).a().a(), false);
      return;
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    int i;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label547;
      }
    }
    Object localObject1;
    Object localObject2;
    label547:
    for (int j = 0;; j = 1)
    {
      localObject1 = pqw.b(paramArticleInfo);
      olh.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pqf.b(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i), false);
      olh.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pqf.b(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i));
      localObject2 = uvs.b(paramInt);
      Object localObject3 = pqf.a(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramContext), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pqw.d(paramArticleInfo), paramArticleInfo);
      localObject3 = pqd.a.b((String)localObject3);
      olh.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), (String)localObject3, false);
      olh.a((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pqf.a(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramContext), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pqw.d(paramArticleInfo), paramArticleInfo));
      paramContext = new ArrayList();
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = pnn.a();
      ((ReportInfo)localObject1).mSource = 0;
      ((ReportInfo)localObject1).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject1).mChannelId = paramInt;
      ((ReportInfo)localObject1).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject1).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject1).mOperation = 1;
      ((ReportInfo)localObject1).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject1).mReadTimeLength = -1;
      ((ReportInfo)localObject1).mInnerId = paramArticleInfo.innerUniqueID;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label560;
      }
      localObject2 = new rqf();
      ((rqf)localObject2).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null) {
        ((rqf)localObject2).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long;
      }
      ((rqf)localObject2).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((rqf)localObject2).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramArticleInfo == null) || (paramArticleInfo.isEmpty())) {
        break label553;
      }
      ((rqf)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      paramArticleInfo = paramArticleInfo.iterator();
      while (paramArticleInfo.hasNext())
      {
        localObject3 = (rqy)paramArticleInfo.next();
        if (localObject3 != null) {
          ((rqf)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((rqy)localObject3).jdField_a_of_type_Long));
        }
      }
      i = 0;
      break;
    }
    label553:
    ((ReportInfo)localObject1).mFeedsReportData = ((rqf)localObject2);
    label560:
    paramContext.add(localObject1);
    pvj.a().a(paramContext);
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
      str1 = pqw.b(paramArticleInfo);
      str2 = pqf.a(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(null), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pqw.d(paramArticleInfo), paramArticleInfo);
      if ((!ppe.g(paramArticleInfo)) && (!ppe.i(paramArticleInfo)) && (!ppe.j(paramArticleInfo)) && (!ppe.k(paramArticleInfo))) {
        break label243;
      }
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq == null)) {
        break label252;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long);
    }
    for (;;)
    {
      String str3 = uvs.b(paramInt);
      olh.a(null, "CliOper", "", str1, str3, str3, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), str2, false);
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
    if ((ppe.g(paramArticleInfo)) || (ppe.i(paramArticleInfo)) || (ppe.j(paramArticleInfo)) || (ppe.k(paramArticleInfo)))
    {
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq == null)) {
        break label273;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long);
      l1 = 0L;
    }
    for (;;)
    {
      label77:
      String str3 = pqf.a(paramInt2, paramInt1, null, pqw.a(paramArticleInfo), paramArticleInfo.innerUniqueID, pqw.b(paramArticleInfo), paramArticleInfo);
      if (uvs.a(paramArticleInfo.mChannelID)) {}
      for (String str2 = "0X8009363";; str2 = "0X8008899")
      {
        olh.a(null, "CliOper", "", str1, str2, str2, 0, 0, Long.toString(l2), Long.toString(l1), "" + paramArticleInfo.mStrategyId, str3, false);
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
    a(paramArticleInfo, paramActivity, paramInt, JumpMode.UNKNOWN);
  }
  
  public static void a(ArticleInfo paramArticleInfo, Activity paramActivity, int paramInt, JumpMode paramJumpMode)
  {
    Object localObject1 = pqw.b(paramArticleInfo);
    int i;
    int j;
    label32:
    int k;
    label45:
    Object localObject2;
    Object localObject3;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label746;
      }
      j = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label752;
      }
      k = paramArticleInfo.videoJumpChannelID;
      olh.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pqf.b(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i), false);
      olh.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pqf.b(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i));
      localObject2 = uvs.b(paramInt);
      if ((!ppe.i(paramArticleInfo)) && (!ppe.g(paramArticleInfo)) && (!ppe.j(paramArticleInfo)) && (!ppe.k(paramArticleInfo))) {
        break label759;
      }
      localObject3 = new suu(pqf.a(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramActivity), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pqw.d(paramArticleInfo), k, paramArticleInfo));
      if (paramInt == 0) {
        ((suu)localObject3).h(k).c((String)omx.a.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(pqw.f(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      olh.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long), (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), ((suu)localObject3).a().a(), false);
    }
    for (;;)
    {
      olh.a((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pqf.a(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramActivity), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pqw.d(paramArticleInfo), k, paramArticleInfo));
      paramActivity = new ArrayList();
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = pkh.a();
      ((ReportInfo)localObject1).mSource = 0;
      ((ReportInfo)localObject1).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject1).mChannelId = paramInt;
      ((ReportInfo)localObject1).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject1).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject1).mOperation = 1;
      ((ReportInfo)localObject1).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject1).mReadTimeLength = -1;
      ((ReportInfo)localObject1).mInnerId = paramArticleInfo.innerUniqueID;
      if ((paramArticleInfo != null) && (!rnz.c(paramArticleInfo)) && (!pkd.a().a()) && (pqf.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        ((ReportInfo)localObject1).noDifferenceJump = 1;
      }
      if (paramArticleInfo.mVideoColumnInfo != null) {
        ((ReportInfo)localObject1).mColumnID = paramArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label909;
      }
      localObject2 = new rqf();
      ((rqf)localObject2).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null) {
        ((rqf)localObject2).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long;
      }
      ((rqf)localObject2).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((rqf)localObject2).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      localObject3 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
        break label902;
      }
      ((rqf)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        rqy localrqy = (rqy)((Iterator)localObject3).next();
        if (localrqy != null) {
          ((rqf)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrqy.jdField_a_of_type_Long));
        }
      }
      i = 0;
      break;
      label746:
      j = 1;
      break label32;
      label752:
      k = 56;
      break label45;
      label759:
      localObject3 = new suu(pqf.a(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramActivity), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pqw.d(paramArticleInfo), k, paramArticleInfo));
      if (paramInt == 0) {
        ((suu)localObject3).h(k).c((String)omx.a.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(pqw.f(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      olh.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ((suu)localObject3).a().a(), false);
    }
    label902:
    ((ReportInfo)localObject1).mFeedsReportData = ((rqf)localObject2);
    label909:
    paramActivity.add(localObject1);
    pvj.a().a(paramActivity);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (!uvp.a((AdvertisementInfo)paramArticleInfo, paramInt)) {
        break label985;
      }
      paramInt = 8;
    }
    for (;;)
    {
      ois.a(new ufy().a(BaseApplicationImpl.getContext()).a(1).b(paramInt).a(paramJumpMode).a((AdvertisementInfo)paramArticleInfo).a());
      return;
      label985:
      if (pqw.a(paramArticleInfo)) {
        paramInt = 11;
      } else {
        paramInt = 3;
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
    if ((ppe.g(paramArticleInfo)) || (ppe.i(paramArticleInfo)) || (ppe.j(paramArticleInfo)) || (ppe.k(paramArticleInfo)))
    {
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label376;
      }
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq == null) {
        break label376;
      }
      str2 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long);
      l1 = l2;
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_JavaUtilArrayList == null) {
        break label376;
      }
      paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_JavaUtilArrayList.size();
      l1 = 0L;
      str1 = str2;
    }
    for (;;)
    {
      paramString = pqf.a(paramInt, j, paramString, pqw.a(paramArticleInfo), paramArticleInfo.innerUniqueID, paramArticleInfo);
      str2 = pqf.a(paramInt, j, null, pqw.a(paramArticleInfo), paramArticleInfo.innerUniqueID, pqw.b(paramArticleInfo), paramArticleInfo);
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
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null)
        {
          l1 = l2;
          str1 = str2;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaUtilArrayList != null)
          {
            paramInt = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaUtilArrayList.size();
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
    Object localObject = pqw.b(paramArticleInfo);
    if (paramArticleInfo.hasChannelInfo()) {
      int i = paramArticleInfo.mChannelInfoId;
    }
    if (TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {}
    try
    {
      localObject = pqf.a(paramArticleInfo.mAlgorithmID, pqw.a(paramArticleInfo), paramInt, NetworkUtil.isWifiConnected(null), (String)localObject, paramArticleInfo.innerUniqueID, pqw.d(paramArticleInfo), 0, pqf.a(), paramArticleInfo);
      if ((paramMap != null) && (paramMap.entrySet() != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while ((paramMap != null) && (paramMap.hasNext()))
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue().toString());
          continue;
          olh.a(null, pqw.b(paramArticleInfo), paramString1, paramString2, 0, 0, prg.a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), paramMap, false);
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
      uvw.a(paramArticleInfo, paramInt);
      return;
      paramMap = ((JSONObject)localObject).toString();
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    olh.a(null, null, "0X800A5AB", "0X800A5AB", 0, 0, "", "", "", new suu(null, null, null, null).V(54).i(paramBaseArticleInfo.getInnerUniqueID()).w(paramInt + 1).a().a(), false);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mGroupSubArticleList == null) || (paramBaseArticleInfo.mGroupSubArticleList.isEmpty())) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[");
    int j = paramBaseArticleInfo.mGroupSubArticleList.size();
    int i = 0;
    while (i < j)
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(i);
      String str = localBaseArticleInfo.getInnerUniqueID();
      int k = localBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Int;
      if (localBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Boolean)
      {
        localStringBuilder.append(str);
        if (QLog.isColorLevel()) {
          QLog.d("RIJFrameworkReportManager", 2, "position：" + k + ", rowKey: " + str);
        }
      }
      if ((j != 1) && (i != j - 1)) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    olh.a(null, null, "0X800A5AA", "0X800A5AA", 0, 0, "", "", "", new suu(paramString, null, null, null, null).V(54).i(localStringBuilder.toString()).a().a(), false);
  }
  
  public static void a(String paramString)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      localJSONObject.put("tab_source", paramString);
      paramString = localJSONObject.toString();
      olh.a(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", paramString, false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        paramString = str;
        if (QLog.isColorLevel())
        {
          QLog.e("RIJFrameworkReportManager", 2, "firstClassDeliverOperationReport:" + localJSONException.toString());
          paramString = str;
        }
      }
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    while (!paramString.contains("dailyJumpSrc")) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("dailyJumpSrc", a("dailyJumpSrc", paramString.split("&")));
      localJSONObject.put("jumpSuccess", paramInt1);
      localJSONObject.put("fullScheme", paramString);
      localJSONObject.put("isCancelJump", paramInt2);
      olh.a(null, null, "0X8009CCD", "0X8009CCD", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("RIJFrameworkReportManager", 2, paramString.getMessage());
    }
  }
  
  private void a(Map<Long, rot> paramMap, int paramInt, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (rot)paramMap.next();
      if (!((rot)localObject2).jdField_b_of_type_Boolean)
      {
        ((rot)localObject2).jdField_b_of_type_Boolean = true;
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = pkh.a();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = ((rot)localObject2).jdField_a_of_type_JavaLangLong.longValue();
        localReportInfo.mChannelId = paramInt;
        localReportInfo.mAlgorithmId = ((int)((rot)localObject2).jdField_a_of_type_Long);
        localReportInfo.mStrategyId = ((rot)localObject2).jdField_b_of_type_Int;
        localReportInfo.mOperation = 7;
        localReportInfo.mServerContext = ((rot)localObject2).jdField_a_of_type_ArrayOfByte;
        localReportInfo.mReadTimeLength = -1;
        localReportInfo.mInnerId = ((rot)localObject2).jdField_e_of_type_JavaLangString;
        if (((rot)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
          localReportInfo.mColumnID = ((rot)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
        }
        Object localObject1;
        if (paramInt == 56)
        {
          localReportInfo.mOpSource = 11;
          localObject1 = new rqg();
          if (paramLong != 0L) {
            break label592;
          }
        }
        label592:
        for (int i = 1;; i = 0)
        {
          ((rqg)localObject1).jdField_c_of_type_Int = i;
          localObject1 = ((rqg)localObject1).toString();
          localReportInfo.mInnerId = ((rot)localObject2).jdField_e_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("VideoReporter", 2, "reportVideoUserOperationByOidbOfFeed--mUin:" + localReportInfo.mUin + "; mSource:" + localReportInfo.mSource + "; mOpSource:" + localReportInfo.mOpSource + "; mInnerId:" + localReportInfo.mInnerId + "; mChannelId:" + localReportInfo.mChannelId + "; mAlgorithmId:" + localReportInfo.mAlgorithmId + "; mStrategyId:" + localReportInfo.mStrategyId + "; mOperation:" + localReportInfo.mOperation + "; mPlayTimeLength:" + localReportInfo.mPlayTimeLength + "; videoExtraRepoerData:" + (String)localObject1);
          }
          if (((rot)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo == null) {
            break label605;
          }
          localObject1 = new rqf();
          ((rqf)localObject1).jdField_a_of_type_Long = ((rot)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
          if (((rot)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null) {
            ((rqf)localObject1).jdField_b_of_type_Long = ((rot)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long;
          }
          ((rqf)localObject1).jdField_a_of_type_Int = ((rot)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
          ((rqf)localObject1).jdField_b_of_type_Int = ((rot)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
          localObject2 = ((rot)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
          if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
            break;
          }
          ((rqf)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            rqy localrqy = (rqy)((Iterator)localObject2).next();
            if (localrqy != null) {
              ((rqf)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrqy.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = ((rqf)localObject1);
        label605:
        localArrayList.add(localReportInfo);
      }
    }
    if (!localArrayList.isEmpty()) {
      pvj.a().a(localArrayList);
    }
  }
  
  private void a(Map<Long, uvx> paramMap, boolean paramBoolean)
  {
    Iterator localIterator = paramMap.values().iterator();
    while (localIterator.hasNext())
    {
      uvx localuvx = (uvx)localIterator.next();
      ArticleInfo localArticleInfo = (ArticleInfo)localuvx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((!pqw.g(localArticleInfo)) || (!localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean))
      {
        String str1 = pqw.b(localArticleInfo);
        paramMap = localArticleInfo.innerUniqueID;
        Object localObject = paramMap;
        if (pqw.j(localArticleInfo))
        {
          localObject = paramMap;
          if (localArticleInfo.mGroupSubArticleList.size() >= 1) {
            localObject = ((BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0)).innerUniqueID;
          }
        }
        String str2 = pqw.d(localArticleInfo);
        if (((ppe.g(localArticleInfo)) || (ppe.i(localArticleInfo)) || (ppe.j(localArticleInfo)) || (ppe.k(localArticleInfo))) && (!ppe.o(localArticleInfo))) {
          paramMap = String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long);
        }
        for (;;)
        {
          for (;;)
          {
            localObject = pqf.a(localArticleInfo.mAlgorithmID, pqw.a(localArticleInfo), (int)localArticleInfo.mChannelID, NetworkState.isWifiConn(), str1, (String)localObject, str2, 0, localuvx.jdField_a_of_type_Int, localArticleInfo);
            str1 = a(localArticleInfo.mChannelID);
            try
            {
              ((JSONObject)localObject).put("exposure_time", "" + (float)localuvx.jdField_a_of_type_Long / 1000.0F);
              if (plm.c((int)localArticleInfo.mChannelID)) {
                ((JSONObject)localObject).put("cmd", bmhv.h());
              }
              olh.a(null, "CliOper", "", paramMap, str1, str1, 0, 0, Long.toString(localArticleInfo.mFeedId), localArticleInfo.mArticleID + "", localArticleInfo.mStrategyId + "", ((JSONObject)localObject).toString(), false);
            }
            catch (JSONException paramMap)
            {
              paramMap.printStackTrace();
            }
          }
          break;
          if ((pqw.i(localArticleInfo)) && (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 6)) {
            paramMap = localArticleInfo.mPolymericInfo.jdField_b_of_type_Long + "";
          } else {
            paramMap = localArticleInfo.mSubscribeID;
          }
        }
      }
    }
  }
  
  private void a(rot paramrot)
  {
    if (pqw.k(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      olh.a(null, null, "0X80097D6", "0X80097D6", 0, 0, "", "", "", "", false);
    }
  }
  
  private void a(rot paramrot, int paramInt)
  {
    if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 0) {
      ComponentContentRecommend.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramInt);
    }
    do
    {
      return;
      if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 1)
      {
        ComponentContentRecommendFollowList.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramInt);
        return;
      }
    } while (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int != 2);
    ComponentContentRecommendFollowGroup.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramInt);
  }
  
  private void a(rot paramrot, Context paramContext, int paramInt)
  {
    if (pqw.j(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
    {
      Object localObject = (BaseArticleInfo)paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGroupSubArticleList.get(0);
      paramContext = uvs.a(paramContext, ((BaseArticleInfo)localObject).mArticleID, ((BaseArticleInfo)localObject).mAlgorithmID, 54, paramInt, ((BaseArticleInfo)localObject).getInnerUniqueID(), ((BaseArticleInfo)localObject).getVideoVid(), uvs.a((BaseArticleInfo)localObject), ((BaseArticleInfo)localObject).videoReportInfo);
      for (;;)
      {
        try
        {
          localObject = new JSONObject(paramContext);
          if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isShowGif)
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
          ((JSONObject)localObject).put("account_expose_card", pqf.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          localObject = ((JSONObject)localObject).toString();
          paramContext = (Context)localObject;
        }
        catch (JSONException localJSONException2)
        {
          QLog.e("RIJFrameworkReportManager", 2, localJSONException2.getMessage());
          continue;
        }
        a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramContext);
        return;
        ((JSONObject)localObject).put("short_content_gif", 0);
      }
    }
    paramContext = uvs.a(paramContext, paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoAdsSource, paramrot.k, paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), 54, uvs.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
    olh.a(null, "CliOper", "", paramrot.jdField_d_of_type_JavaLangString, "0X80091A8", "0X80091A8", 0, 0, Long.toString(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID), Integer.toString(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId), paramContext, false);
    olh.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", new suu(null, null, null, null).V(54).i(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()).w(paramrot.k + 1).f(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a().a(), false);
  }
  
  private void a(rot paramrot, String paramString1, String paramString2)
  {
    int i = 0;
    while (i < paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size())
    {
      olh.a(null, paramrot.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), ((rsj)paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int + "", Integer.toString(paramrot.jdField_b_of_type_Int), paramString1, false);
      i += 1;
    }
  }
  
  private void a(rot paramrot, String paramString1, String paramString2, Context paramContext, int paramInt, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    if (!paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)
    {
      localQQAppInterface = pnn.b();
      if (localQQAppInterface == null) {
        break label427;
      }
    }
    label427:
    for (paramString1 = localQQAppInterface.getCurrentUin();; paramString1 = "0")
    {
      String str = pqf.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID, pqw.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramInt, 0, 0, NetworkUtil.isWifiConnected(paramContext), paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID, null, paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, null, (ArticleInfo)paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      olh.a(null, "CliOper", "", paramString1, paramString2, paramString2, 0, 0, paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId + "", paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID + "", paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId + "", str, false);
      paramString2 = uvs.a(paramInt);
      if (localQQAppInterface != null) {
        paramString1 = localQQAppInterface.getCurrentUin();
      }
      paramContext = pqf.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID, pqw.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramInt, NetworkUtil.isWifiConnected(paramContext), paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID, paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, null, 0, paramrot.jdField_f_of_type_Int, (ArticleInfo)paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
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
            olh.a(null, "CliOper", "", paramString1, paramString2, paramString2, 0, 0, paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId + "", paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID + "", paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId + "", paramContext, false);
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
      } while (!pqw.n(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      olh.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramString1, false);
      return;
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, int paramInt)
  {
    String str = uvs.b(paramInt);
    a(paramArticleInfo, str, str, paramInt);
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mVideoColumnInfo == null)) {
      return;
    }
    olh.a(null, null, "0X800A1C3", "0X800A1C3", 0, 0, "", "", "", new suu(null, null, null, null).i(paramBaseArticleInfo.innerUniqueID).c(paramBaseArticleInfo).d(paramBaseArticleInfo).Q(paramInt).a(paramBaseArticleInfo.videoReportInfo).a(paramBaseArticleInfo, false).a().a(), false);
  }
  
  private void b(rot paramrot)
  {
    if ((paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null) && (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Orr != null)) {
      pnp.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Orr, paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
  }
  
  private void b(rot paramrot, int paramInt)
  {
    if (paramrot.jdField_c_of_type_Boolean) {
      try
      {
        if (paramrot.jdField_d_of_type_Boolean)
        {
          JSONObject localJSONObject = pqf.a();
          localJSONObject.put("feeds_source", paramrot.jdField_a_of_type_JavaLangString);
          localJSONObject.put("kandian_mode", pqu.a());
          if (uvs.a(paramInt)) {}
          for (String str = "0X8009358";; str = "0X800744E")
          {
            olh.a(null, "CliOper", "", "", str, str, 0, 0, pqw.c(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), "", "", localJSONObject.toString(), false);
            return;
          }
        }
        return;
      }
      catch (JSONException paramrot)
      {
        paramrot.printStackTrace();
      }
    }
  }
  
  private void b(rot paramrot, Context paramContext, int paramInt)
  {
    long l3;
    int i;
    int j;
    int k;
    long l1;
    String str1;
    String str2;
    if ((paramrot.jdField_c_of_type_Int == 48) || (paramrot.jdField_c_of_type_Int == 49) || (paramrot.jdField_c_of_type_Int == 50) || (paramrot.jdField_c_of_type_Int == 51) || (paramrot.jdField_c_of_type_Int == 52) || (paramrot.jdField_c_of_type_Int == 53) || (paramrot.jdField_c_of_type_Int == 78) || (paramrot.jdField_c_of_type_Int == 79) || (paramrot.jdField_c_of_type_Int == 80) || (paramrot.jdField_c_of_type_Int == 1005) || (paramrot.jdField_c_of_type_Int == 1006) || (paramrot.jdField_c_of_type_Int == 1007))
    {
      l3 = paramrot.jdField_b_of_type_Long;
      i = paramrot.k;
      j = pih.a(paramInt, paramrot.jdField_c_of_type_Int);
      k = pih.a(paramrot.jdField_c_of_type_Int);
      l1 = 0L;
      str1 = null;
      str2 = null;
      if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
        break label302;
      }
      l1 = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
      str1 = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
      str2 = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData;
    }
    label302:
    for (long l2 = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID;; l2 = 0L)
    {
      paramContext = pih.a(paramContext, pkh.a(), j, l1, l3, i, str1, str2, k, paramInt);
      olh.a(null, paramrot.jdField_d_of_type_JavaLangString, "0X8008E2E", "0X8008E2E", 0, 0, "", l1 + "", l2 + "", paramContext, false);
      pih.a(7, pkh.a(), (int)l2, j, l3, i, str1, str2);
      return;
    }
  }
  
  private void b(rot paramrot, String paramString1, String paramString2)
  {
    if ((paramrot == null) || (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {}
    Object localObject1;
    for (;;)
    {
      return;
      try
      {
        if ((qwx.a() != null) && (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo != null) && (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null))
        {
          paramString1 = new JSONObject(paramString1);
          if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean != null)
          {
            localObject1 = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getDataAttribute(null);
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
          localObject1 = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList;
        }
      }
      catch (JSONException paramrot)
      {
        QLog.e("RIJFrameworkReportManager", 2, paramrot.getMessage());
        return;
      }
    }
    Object localObject2 = qwx.a().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject2).next();
      if ((localInteger.intValue() < ((List)localObject1).size()) && (((List)localObject1).get(localInteger.intValue()) != null))
      {
        paramString1.put("rowkey", ((rpt)((List)localObject1).get(localInteger.intValue())).g);
        olh.a(null, "CliOper", "", paramrot.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramrot.jdField_b_of_type_Int), paramString1.toString(), false);
      }
    }
    qwx.a();
  }
  
  public static void c(ArticleInfo paramArticleInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = pnn.a();
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
      rqf localrqf = new rqf();
      localrqf.jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null) {
        localrqf.jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long;
      }
      localrqf.jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localrqf.jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
      {
        localrqf.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramArticleInfo = paramArticleInfo.iterator();
        while (paramArticleInfo.hasNext())
        {
          rqy localrqy = (rqy)paramArticleInfo.next();
          if (localrqy != null) {
            localrqf.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrqy.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = localrqf;
    }
    localArrayList.add(localReportInfo);
    pvj.a().a(localArrayList);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (plm.c(paramInt1))
    {
      if (Aladdin.getConfig(252).getIntegerFromString("fix_daily", 0) != 0) {
        break label28;
      }
      pin.a(1);
    }
    label28:
    while (paramInt2 == 2) {
      return;
    }
    pin.a(1);
  }
  
  public void a(Map<Integer, rot> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      if (paramMap.hasNext())
      {
        rot localrot = (rot)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
        int j = oxo.jdField_b_of_type_Int;
        if ((localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null) && (localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint != null) && (localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {}
        for (int i = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Int + 1;; i = 0)
        {
          oxo.a("0X8009495", localTabChannelCoverInfo, j, i, -1);
          break;
        }
      }
    }
  }
  
  public void a(Map<Long, rot> paramMap, boolean paramBoolean, Map<Long, uvx> paramMap1, String paramString, Context paramContext, int paramInt)
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (!paramBoolean))
    {
      QLog.d("RIJFrameworkReportManager", 2, "report data is null ");
      return;
    }
    Iterator localIterator = paramMap.values().iterator();
    rot localrot;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localrot = (rot)localIterator.next();
        if (!localrot.jdField_a_of_type_Boolean)
        {
          localrot.jdField_a_of_type_Boolean = true;
          if ((localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo != null))
          {
            i = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
            localrot.jdField_c_of_type_Int = 1008;
            if (i == 5) {
              localrot.jdField_c_of_type_Int = 1009;
            }
          }
          olh.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrot.jdField_b_of_type_Int), pqf.a(localrot.jdField_a_of_type_Long, localrot.jdField_c_of_type_Int, paramInt, localrot.jdField_d_of_type_Int), false);
          olh.a("0X80066FC", "", "", Long.toString(localrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrot.jdField_b_of_type_Int), pqf.a(localrot.jdField_a_of_type_Long, localrot.jdField_c_of_type_Int, paramInt, localrot.jdField_d_of_type_Int));
          if (localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
          {
            paramMap = pqf.a(localrot.jdField_a_of_type_Long, localrot.jdField_c_of_type_Int, paramInt, localrot.jdField_d_of_type_Int, localrot.jdField_e_of_type_Int, NetworkUtil.isWifiConnected(paramContext), localrot.jdField_a_of_type_JavaLangString, localrot.jdField_c_of_type_JavaLangString, localrot.jdField_e_of_type_JavaLangString, pqw.d(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localrot.jdField_f_of_type_Int, localrot.g, localrot.h, localrot.jdField_f_of_type_Boolean, localrot.j, localrot.i, localrot.m);
            try
            {
              localObject = new JSONObject(paramMap);
              ((JSONObject)localObject).put("feeds_type", localrot.jdField_c_of_type_Int);
              ((JSONObject)localObject).put("folder_status", paramString);
              localObject = ((JSONObject)localObject).toString();
              paramMap = (Map<Long, rot>)localObject;
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
            if (uvs.a(paramInt))
            {
              localObject = "0X8009354";
              paramMap = new suu(paramMap);
              paramMap.a(localrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).f(localrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
              olh.a(null, "CliOper", "", localrot.jdField_d_of_type_JavaLangString, (String)localObject, (String)localObject, 0, 0, Long.toString(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrot.jdField_b_of_type_Int), paramMap.a().a(), false);
              olh.a((String)localObject, localrot.jdField_d_of_type_JavaLangString, Long.toString(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrot.jdField_b_of_type_Int), pqf.a(localrot.jdField_a_of_type_Long, localrot.jdField_c_of_type_Int, paramInt, localrot.jdField_d_of_type_Int, localrot.jdField_e_of_type_Int, NetworkUtil.isWifiConnected(paramContext), localrot.jdField_a_of_type_JavaLangString, localrot.jdField_c_of_type_JavaLangString, localrot.jdField_e_of_type_JavaLangString, pqw.d(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localrot.jdField_f_of_type_Int, localrot.g, localrot.h, localrot.jdField_f_of_type_Boolean, localrot.j, localrot.i, localrot.m));
              if ((localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo == null)) {
                continue;
              }
              j = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
              i = 8;
              if (j == 5) {
                i = 12;
              }
              l3 = localrot.jdField_b_of_type_Long;
              j = localrot.k;
              l1 = 0L;
              paramMap = null;
              localObject = null;
              if (localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
                break label898;
              }
              l1 = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
              paramMap = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
              localObject = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData;
            }
          }
        }
      }
    }
    label898:
    for (long l2 = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID;; l2 = 0L)
    {
      String str2 = pih.a(paramContext, pkh.a(), 16, l1, l3, j, paramMap, (String)localObject, i, paramInt);
      olh.a(null, localrot.jdField_d_of_type_JavaLangString, "0X8008E2E", "0X8008E2E", 0, 0, "", l1 + "", l2 + "", str2, false);
      pih.a(7, pkh.a(), (int)l2, 16, l3, j, paramMap, (String)localObject);
      break;
      String str1;
      b(paramMap1);
      return;
    }
  }
  
  public void a(Map<Long, rot> paramMap, boolean paramBoolean1, Map<Long, uvx> paramMap1, String paramString, Context paramContext, int paramInt1, int paramInt2, oqu paramoqu, boolean paramBoolean2, long paramLong)
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (!paramBoolean1))
    {
      QLog.d("RIJFrameworkReportManager", 2, "report data is null ");
      if ((paramMap1 != null) && (!paramMap1.isEmpty())) {
        a(paramMap1, paramBoolean2);
      }
      return;
    }
    psu.a(paramMap, paramInt1, paramoqu.a());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.values().iterator();
    label80:
    rot localrot;
    Object localObject;
    long l;
    int i;
    String str;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localrot = (rot)localIterator.next();
        if (!localrot.jdField_a_of_type_Boolean)
        {
          localrot.jdField_a_of_type_Boolean = true;
          localObject = a(paramContext, paramInt1);
          l = ((Long)((Pair)localObject).second).longValue();
          i = ((Integer)((Pair)localObject).first).intValue();
          olh.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrot.jdField_b_of_type_Int), pqf.a(localrot.jdField_a_of_type_Long, localrot.jdField_c_of_type_Int, paramInt1, localrot.jdField_d_of_type_Int), false);
          olh.a("0X80066FC", "", "", Long.toString(localrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrot.jdField_b_of_type_Int), pqf.a(localrot.jdField_a_of_type_Long, localrot.jdField_c_of_type_Int, paramInt1, localrot.jdField_d_of_type_Int));
          if (localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
          {
            str = pqf.a(localrot.jdField_a_of_type_Long, localrot.jdField_c_of_type_Int, paramInt1, localrot.jdField_d_of_type_Int, localrot.jdField_e_of_type_Int, NetworkUtil.isWifiConnected(paramContext), localrot.jdField_a_of_type_JavaLangString, localrot.jdField_c_of_type_JavaLangString, localrot.jdField_e_of_type_JavaLangString, pqw.d(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l, i, localrot.jdField_f_of_type_Int, localrot.g, localrot.h, localrot.jdField_f_of_type_Boolean, localrot.j, localrot.i, localrot.m);
            if (paramInt1 == 56)
            {
              localObject = psu.a(localrot, str, paramoqu.a());
              label398:
              localObject = a(paramMap1, paramString, localrot, (String)localObject, paramInt1);
              str = pqd.a.b((String)localObject);
              if (!uvs.a(paramInt1)) {
                break label535;
              }
              localObject = "0X8009354";
              label437:
              if ((!plm.a(paramInt1)) && (!bmhv.a(paramInt1))) {
                break label928;
              }
              localObject = "0X8009CC8";
            }
          }
        }
      }
    }
    label535:
    label928:
    for (;;)
    {
      if (ppe.i(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        a(localrot, str, (String)localObject);
      }
      for (;;)
      {
        b(localrot, paramContext, paramInt1);
        b(localrot, paramInt1);
        a(localrot);
        b(localrot);
        break label80;
        localObject = str;
        if (paramInt1 != 0) {
          break label398;
        }
        localObject = a(localrot, str);
        break label398;
        localObject = "0X8007626";
        break label437;
        if (pqw.l(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          a(localrot, paramContext, paramInt1);
        }
        else if (pqw.s(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          b(localrot, str, (String)localObject);
        }
        else if (pqw.g(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          a(localrot, str, (String)localObject, paramContext, paramInt1, paramBoolean2);
        }
        else if (pqw.t(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          a(localrot, paramInt1);
        }
        else
        {
          if (localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedType == 33)
          {
            localObject = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getProteusItemData();
            if (localObject == null) {
              break;
            }
            psu.a(false, (JSONObject)localObject, localrot);
            psu.a(true, (JSONObject)localObject, localrot);
            continue;
          }
          if (pqw.q(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
          {
            psu.a(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, localrot);
          }
          else
          {
            if (pqw.i(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
            {
              BaseArticleInfo localBaseArticleInfo = localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
              JSONObject localJSONObject = prp.a(localBaseArticleInfo.mPolymericInfo);
              olh.a(null, "CliOper", "", localrot.jdField_d_of_type_JavaLangString, "0X8008F57", "0X8008F57", 0, 0, localrot.k + "", Long.toString(localrot.jdField_a_of_type_JavaLangLong.longValue()), Long.toString(localBaseArticleInfo.mPolymericInfo.d), localJSONObject.toString(), false);
              if (localHashMap.containsKey(Long.valueOf(localBaseArticleInfo.mPolymericInfo.c))) {
                break label80;
              }
              localHashMap.put(Long.valueOf(localBaseArticleInfo.mPolymericInfo.c), Boolean.valueOf(true));
            }
            psu.a(localrot, l, i, str, (String)localObject, paramContext, paramInt1, paramInt2, paramoqu, paramBoolean2);
          }
        }
      }
      if (paramInt1 != 40677) {
        a(paramMap, paramInt1, paramLong);
      }
      a(paramMap1, paramBoolean2);
      tct.a(((Integer)a(paramContext, paramInt1).first).intValue());
      return;
    }
  }
  
  public void a(Map<Long, rot> paramMap, boolean paramBoolean1, Map<Long, uvx> paramMap1, String paramString, boolean paramBoolean2, int paramInt1, Context paramContext, int paramInt2, oqu paramoqu, boolean paramBoolean3, long paramLong)
  {
    ThreadManager.post(new RIJFrameworkReportManager.2(this, paramBoolean2, paramMap, paramBoolean1, paramMap1, paramString, paramContext, paramInt1, paramInt2, paramoqu, paramBoolean3, paramLong), 5, null, false);
  }
  
  public void b(Map<Long, uvx> paramMap)
  {
    a(paramMap, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqb
 * JD-Core Version:    0.7.0.1
 */