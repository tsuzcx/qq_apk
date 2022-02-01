import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;

public class psu
{
  public static String a(VideoInfo paramVideoInfo, int paramInt)
  {
    suu localsuu = new suu(null, null, null, null);
    localsuu.S(ReadinjoyTabFrame.jdField_a_of_type_Int).T(paramInt);
    if (paramVideoInfo != null) {
      if (paramVideoInfo.h) {
        if (paramVideoInfo.jdField_g_of_type_Boolean)
        {
          paramInt = 3;
          localsuu.a("status", Integer.valueOf(paramInt)).i(paramVideoInfo.jdField_g_of_type_JavaLangString).e(paramVideoInfo.f).e(paramVideoInfo.jdField_a_of_type_JavaLangString).U(0).a(0);
        }
      }
    }
    for (;;)
    {
      return localsuu.a().a();
      paramInt = 2;
      break;
      paramInt = 4;
      break;
      localsuu.a("status", Integer.valueOf(1));
    }
  }
  
  public static String a(rot paramrot, String paramString, spg paramspg)
  {
    paramString = pqf.a(paramString, paramspg.b(), omx.jdField_a_of_type_Int);
    if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
      return paramString;
    }
    if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
      paramString = new suu(paramString).c(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).a().a();
    }
    for (;;)
    {
      if (((ppe.a((ArticleInfo)paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) == 46) || (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isTwoItem)) && (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo != null) && (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo != null) && (qxl.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (qxl.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail))) {
        six.a(qxl.b(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + qxl.b(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail));
      }
      return paramString;
    }
  }
  
  private static void a(ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, Map<String, Object> paramMap, pne parampne, spk paramspk)
  {
    if ((parampne.a().b() == 0) || (parampne.a().b() == 56))
    {
      if (six.a((Activity)parampne.a().a(), paramArticleInfo1))
      {
        a(paramspk, paramArticleInfo1, parampne);
        if ((parampne.a().b() == 56) && (paramArticleInfo1.mVideoDownloadBarInfo != null) && (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo != null) && (qxl.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (qxl.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail))) {
          six.a(qxl.b(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + qxl.b(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail));
        }
        return;
      }
      if ((parampne.a().b() == 56) && (paramArticleInfo1.mVideoDownloadBarInfo != null) && (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo != null) && (qxl.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (qxl.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail))) {
        six.a(qxl.b(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + qxl.b(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail));
      }
    }
    if (paramArticleInfo1.videoJumpChannelID > 0)
    {
      if (paramArticleInfo1.videoJumpChannelID == 56) {
        osg.a(parampne.a().a(), paramArticleInfo2, paramArticleInfo1, true);
      }
      for (;;)
      {
        a(paramspk, paramArticleInfo1, parampne);
        return;
        paramArticleInfo2 = new HashMap();
        paramArticleInfo2.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo1.mArticleID));
        osg.b(parampne.a().a(), paramArticleInfo1.videoJumpChannelID, paramArticleInfo1.videoJumpChannelName, paramArticleInfo1.videoJumpChannelType, 5, paramArticleInfo2);
      }
    }
    if (bmhv.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
    {
      osg.a(parampne.a().a(), paramArticleInfo2, paramArticleInfo1, true);
      a(paramspk, paramArticleInfo1, parampne);
      return;
    }
    paramspk.a = paramMap;
    parampne.a().a().a(paramspk, paramArticleInfo1);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, Context paramContext, int paramInt)
  {
    if ((paramBaseArticleInfo.isAccountShown) && (paramInt == 0) && (!TextUtils.isEmpty(qxl.b(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url)))) {
      pqx.a(paramContext, qxl.b(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url));
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, rot paramrot)
  {
    if ((paramBaseArticleInfo == null) || (!pqw.q(paramBaseArticleInfo))) {
      return;
    }
    paramrot = new suu(null, null, null, null).V(Integer.valueOf("2007").intValue());
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
    paramrot.p(paramBaseArticleInfo.mKdLiveInfo.jdField_g_of_type_JavaLangString);
    olh.a(null, paramBaseArticleInfo.mSubscribeID, "0X8007626", "0X8007626", 0, 0, "", "", "", paramrot.a().a(), false);
    paramrot.p(localBaseArticleInfo.mKdLiveInfo.jdField_g_of_type_JavaLangString);
    olh.a(null, localBaseArticleInfo.mSubscribeID, "0X8007626", "0X8007626", 0, 0, "", "", "", paramrot.a().a(), false);
  }
  
  public static void a(Map<Long, rot> paramMap, int paramInt, spz paramspz)
  {
    if ((paramInt == 56) && (paramspz != null))
    {
      paramMap = paramMap.values().iterator();
      while (paramMap.hasNext())
      {
        rot localrot = (rot)paramMap.next();
        localrot.h = paramspz.a();
        if (paramspz.a(localrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID)) {
          localrot.jdField_f_of_type_Boolean = true;
        }
      }
    }
  }
  
  public static void a(rot paramrot, long paramLong, int paramInt1, String paramString1, String paramString2, Context paramContext, int paramInt2, int paramInt3, oqu paramoqu, boolean paramBoolean)
  {
    Object localObject1 = new suu(paramString1);
    ((suu)localObject1).a(Boolean.valueOf(pqw.f(paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).b(paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if (paramInt2 == 40677)
    {
      ((suu)localObject1).b(paramrot.j);
      olh.a(null, "CliOper", "", paramrot.jdField_d_of_type_JavaLangString, "0X8009292", "0X8009292", 0, 0, Long.toString(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramrot.jdField_b_of_type_Int), ((suu)localObject1).a().a(), false);
      olh.a("0X8009292", paramrot.jdField_d_of_type_JavaLangString, Long.toString(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramrot.jdField_b_of_type_Int), pqf.a(paramrot.jdField_a_of_type_Long, paramrot.jdField_c_of_type_Int, paramInt2, paramrot.jdField_d_of_type_Int, paramrot.jdField_e_of_type_Int, NetworkUtil.isWifiConnected(paramContext), paramrot.jdField_a_of_type_JavaLangString, paramrot.jdField_c_of_type_JavaLangString, paramrot.jdField_e_of_type_JavaLangString, pqw.d(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramLong, paramInt1, paramrot.jdField_f_of_type_Int, paramrot.g, paramrot.h, paramrot.jdField_f_of_type_Boolean, paramrot.j, paramrot.i, paramrot.m));
      return;
    }
    if (paramInt3 == 3)
    {
      paramInt3 = -1;
      if ((paramoqu instanceof oqv)) {
        paramInt3 = ((oqv)paramoqu).a();
      }
      ((suu)localObject1).N(paramInt3);
    }
    ((suu)localObject1).a(paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    Object localObject2;
    if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean != null)
    {
      localObject2 = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getDataAttribute(null);
      if ((localObject2 != null) && (((Map)localObject2).entrySet() != null))
      {
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while ((localObject2 != null) && (((Iterator)localObject2).hasNext()))
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          ((suu)localObject1).a((String)localEntry.getKey(), localEntry.getValue().toString());
        }
      }
    }
    rai.a((suu)localObject1, paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    pqe.a(paramString2, paramrot, (suu)localObject1);
    if ((paramoqu instanceof orj))
    {
      if (paramBoolean)
      {
        paramInt3 = 1;
        label426:
        ((suu)localObject1).a("from_aio", Integer.valueOf(paramInt3));
      }
    }
    else
    {
      olh.a(null, "CliOper", "", paramrot.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramrot.jdField_b_of_type_Int), ((suu)localObject1).a().a(), false);
      localObject1 = usp.a(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean);
      paramoqu = paramString1;
      if (localObject1 == null) {
        break label688;
      }
      localObject2 = ((List)localObject1).iterator();
      label526:
      paramoqu = paramString1;
      if (!((Iterator)localObject2).hasNext()) {
        break label688;
      }
      localObject1 = (String)((Iterator)localObject2).next();
    }
    label688:
    label960:
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramoqu = new JSONObject(paramString1);
          localObject1 = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getDataAttribute((String)localObject1);
          if (localObject1 == null) {
            break label960;
          }
          usp.a(paramoqu, (Map)localObject1);
          paramoqu = paramoqu.toString();
          paramString1 = paramoqu;
        }
        catch (JSONException localJSONException1)
        {
          paramoqu = paramString1;
          paramString1 = localJSONException1;
        }
        try
        {
          olh.a(null, "CliOper", "", paramrot.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramrot.jdField_b_of_type_Int), paramString1, false);
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            paramoqu = paramString1;
            paramString1 = localJSONException2;
          }
        }
      }
      paramInt3 = 0;
      break label426;
      QLog.d("RIJVideoReportManager", 1, "extra_expose", paramString1);
      paramString1 = paramoqu;
      break label526;
      olh.a(paramString2, paramrot.jdField_d_of_type_JavaLangString, Long.toString(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramrot.jdField_b_of_type_Int), pqf.a(paramrot.jdField_a_of_type_Long, paramrot.jdField_c_of_type_Int, paramInt2, paramrot.jdField_d_of_type_Int, paramrot.jdField_e_of_type_Int, NetworkUtil.isWifiConnected(paramContext), paramrot.jdField_a_of_type_JavaLangString, paramrot.jdField_c_of_type_JavaLangString, paramrot.jdField_e_of_type_JavaLangString, pqw.d(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramLong, paramInt1, paramrot.jdField_f_of_type_Int, paramrot.g, paramrot.h, paramrot.jdField_f_of_type_Boolean, paramrot.j, paramrot.i, paramrot.m));
      for (;;)
      {
        try
        {
          if ((Aladdin.get(250).getIntegerFromString("pj_enable", 0) != 1) || (plm.c(paramInt2))) {
            break;
          }
          paramString1 = new pqg(new JSONObject(paramoqu));
          if (uvs.b() <= 0) {
            break label942;
          }
          paramInt1 = 0;
          paramString1.b("behavior_type", paramInt1);
          olh.a(null, "CliOper", "", paramrot.jdField_d_of_type_JavaLangString, "0X800A9AF", "0X800A9AF", 0, 0, Long.toString(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramrot.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramrot.jdField_b_of_type_Int), paramString1.a(), false);
          return;
        }
        catch (Exception paramrot) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RIJVideoReportManager", 2, QLog.getStackTraceString(paramrot));
        return;
        paramInt1 = 1;
      }
    }
  }
  
  public static void a(spk paramspk, BaseArticleInfo paramBaseArticleInfo, pne parampne)
  {
    String str1 = pqw.b(paramBaseArticleInfo);
    int i;
    int j;
    label34:
    suu localsuu;
    if (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo())
    {
      i = paramBaseArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label571;
      }
      j = 0;
      olh.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), pqf.b(paramBaseArticleInfo.mAlgorithmID, pqw.a(paramBaseArticleInfo), parampne.a().b(), i), false);
      olh.a("0X80066FA", "", "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), pqf.b(paramBaseArticleInfo.mAlgorithmID, pqw.a(paramBaseArticleInfo), parampne.a().b(), i));
      localsuu = new suu(pqf.a(paramBaseArticleInfo.mAlgorithmID, pqw.a(paramBaseArticleInfo), parampne.a().b(), i, j, NetworkUtil.isWifiConnected(parampne.a().a()), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, pqw.d(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      localsuu.a(parampne.a().a(), paramBaseArticleInfo.mArticleID).a(parampne.a().a()).g(omx.jdField_a_of_type_Int).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(pqw.f(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo);
      if (parampne.a().b() != 0) {
        break label577;
      }
      paramspk.l = omx.b();
      localsuu.b(paramspk.l);
      if (paramBaseArticleInfo.mVideoColumnInfo != null) {
        localsuu.X(paramBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
      }
      if (ppe.a((ArticleInfo)paramBaseArticleInfo) == 6) {
        localsuu.Z(six.f());
      }
    }
    for (;;)
    {
      if ((parampne.a().a() != null) && (parampne.a().a().a() == paramspk))
      {
        long l = parampne.a().a().a();
        if (l != 0L) {
          localsuu.f(l);
        }
      }
      if (parampne.a().b() != 40677) {
        break label642;
      }
      localsuu.b(paramBaseArticleInfo.mVideoAdsJumpType).a(zfn.a(parampne.a().a()));
      localsuu.i(2);
      olh.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, "0X8009293", "0X8009293", 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), localsuu.a().a(), false);
      olh.a("0X8009293", paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), pqf.a(paramBaseArticleInfo.mAlgorithmID, pqw.a(paramBaseArticleInfo), parampne.a().b(), i, j, NetworkUtil.isWifiConnected(parampne.a().a()), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, pqw.d(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      return;
      i = 0;
      break;
      label571:
      j = 1;
      break label34;
      label577:
      if ((parampne.a().b() == 56) && (parampne.a().a() != null) && (!TextUtils.isEmpty(parampne.a().a().b())))
      {
        paramspk.m = parampne.a().a().b();
        localsuu.c(paramspk.m);
      }
    }
    label642:
    localsuu.a(paramBaseArticleInfo).N((int)parampne.a().a()).c(paramBaseArticleInfo).a(paramBaseArticleInfo, true).d(paramBaseArticleInfo).f(paramBaseArticleInfo);
    if ((pqw.l(paramBaseArticleInfo)) && (paramBaseArticleInfo.mPolymericInfo != null)) {
      localsuu.w(paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Int + 1);
    }
    String str2 = uvs.b(parampne.a().b());
    olh.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), pnl.a(localsuu.a().a(), paramspk.a), false);
    olh.a(str2, paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), pqf.a(paramBaseArticleInfo.mAlgorithmID, pqw.a(paramBaseArticleInfo), parampne.a().b(), i, j, NetworkUtil.isWifiConnected(parampne.a().a()), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, pqw.d(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
  }
  
  public static void a(boolean paramBoolean, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, String paramString, Map<String, Object> paramMap, pne parampne)
  {
    spk localspk = prt.a(paramArticleInfo1);
    localspk.n = paramString;
    localspk.l = omx.b();
    if ((parampne.a().a() != null) && (!TextUtils.isEmpty(parampne.a().a().b()))) {
      localspk.m = parampne.a().a().b();
    }
    paramString = new suu(null, null, null, null);
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      olh.a(null, "", "0X8008D33", "0X8008D33", 0, 0, "", "", "", paramString.Y(i).b(localspk.l).c(localspk.m).a(parampne.a().b()).k(paramArticleInfo1.mVideoAdsSource).j(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).N((int)parampne.a().a()).a().a(), false);
      if (!six.a(paramArticleInfo1, parampne.a().a())) {
        break;
      }
      a(localspk, paramArticleInfo1, parampne);
      return;
    }
    if ((paramArticleInfo1.isAccountShown) && (parampne.a().b() == 0) && (!TextUtils.isEmpty(paramArticleInfo1.mArticleContentUrl)))
    {
      pqx.a(parampne.a().a(), paramArticleInfo1.mArticleContentUrl);
      paramString = new suu(null, null, paramArticleInfo1.mVideoVid, paramArticleInfo1.innerUniqueID);
      if (paramBoolean)
      {
        i = 0;
        paramArticleInfo2 = paramString.Y(i).b(localspk.l).c(localspk.m).a(parampne.a().b()).k(paramArticleInfo1.mVideoAdsSource).j(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).N((int)parampne.a().a()).V(pqw.a(paramArticleInfo1)).e(paramArticleInfo1).Q(7).f(paramArticleInfo2);
        if ((paramArticleInfo1.columnEntrances != null) && (paramArticleInfo1.columnEntrances.size() > 0))
        {
          paramArticleInfo1 = (VideoColumnInfo)paramArticleInfo1.columnEntrances.get(0);
          if (paramArticleInfo1.jdField_a_of_type_Int == 0) {
            break label511;
          }
          paramArticleInfo2.a("is_column", "1");
          paramArticleInfo2.a("column_id", String.valueOf(paramArticleInfo1.jdField_a_of_type_Int));
          if (!paramArticleInfo1.jdField_a_of_type_Boolean) {
            break label504;
          }
          paramArticleInfo1 = "1";
          label451:
          paramArticleInfo2.a("subscribe_flag", paramArticleInfo1);
        }
      }
      for (;;)
      {
        olh.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", pnl.a(paramArticleInfo2.a().a(), paramMap), false);
        return;
        i = 1;
        break;
        label504:
        paramArticleInfo1 = "2";
        break label451;
        label511:
        paramArticleInfo2.a("is_column", "0");
      }
    }
    if (paramArticleInfo1.isVideoItemForAdJump())
    {
      paramArticleInfo2 = (Activity)parampne.a().a();
      if (paramArticleInfo2 != null)
      {
        paramString = new Intent(paramArticleInfo2, QQBrowserActivity.class);
        paramString.putExtra("url", paramArticleInfo1.mVideoAdsJumpUrl);
        paramString.putExtra("big_brother_source_key", pqx.a(parampne.a().b()));
        paramArticleInfo2.startActivity(paramString);
      }
      a(localspk, paramArticleInfo1, parampne);
      return;
    }
    a(paramArticleInfo1, paramArticleInfo2, paramMap, parampne, localspk);
  }
  
  public static void a(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo, Context paramContext, int paramInt, long paramLong)
  {
    if ((paramBaseArticleInfo.isAccountShown) && (paramInt == 0) && (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)))
    {
      pqx.a(paramContext, paramBaseArticleInfo.mArticleContentUrl);
      paramContext = new suu(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID);
      if (!paramBoolean) {
        break label134;
      }
    }
    label134:
    for (int i = 0;; i = 1)
    {
      olh.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", paramContext.Y(i).a(paramInt).a(paramBaseArticleInfo.videoReportInfo).a(paramBaseArticleInfo).N((int)paramLong).V(pqw.a(paramBaseArticleInfo)).e(paramBaseArticleInfo).Q(6).f(paramBaseArticleInfo).a().a(), false);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject, rot paramrot)
  {
    if ((paramJSONObject == null) || (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {}
    for (;;)
    {
      return;
      Object localObject = new suu(null, null, null, null).V(Integer.valueOf("1031").intValue()).q(paramJSONObject.optString("double_videocard_jump_page")).r(paramJSONObject.optString("double_videocard_jump_src")).a((int)paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID);
      if (uvs.b() > 0) {}
      for (int i = 0;; i = 1)
      {
        paramrot = ((suu)localObject).af(i).f(paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
        if (!paramBoolean) {
          break;
        }
        localObject = paramJSONObject.optString("column_id");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramrot.a("columnId", localObject);
        }
        paramrot.i(paramJSONObject.optString("all_rowkey"));
        paramrot.s(paramJSONObject.optString("subscript"));
        olh.a(null, null, "0X800A5A8", "0X800A5A8", 0, 0, "", "", "", paramrot.a().a(), false);
        return;
      }
      i = 0;
      while (i < 2)
      {
        localObject = paramJSONObject.optString("columnId_" + (i + 1));
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramrot.a("columnId", localObject);
        }
        paramrot.i(paramJSONObject.optString("rowKey_" + (i + 1)));
        paramrot.s(paramJSONObject.optString("subscript_" + (i + 1)));
        paramrot.Y(i);
        olh.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramrot.a().a(), false);
        i += 1;
      }
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, BaseArticleInfo paramBaseArticleInfo, Activity paramActivity, int paramInt, spz paramspz, spg paramspg)
  {
    if (paramspg.b()) {
      paramspg.a();
    }
    if (paramspz != null) {
      paramspz.a(1, paramBaseArticleInfo, 0L, 0L);
    }
    paramspz = new Intent(paramActivity, ReadInJoyDeliverBiuActivity.class);
    paramspz.putExtra("arg_article_info", (ArticleInfo)paramBaseArticleInfo);
    paramspz.putExtra("biu_src", 2);
    paramspz.putExtra("arg_from_type", 7);
    paramspz.putExtra("fast_biu_type", paramBoolean2);
    paramActivity.startActivityForResult(paramspz, 2);
    paramActivity.overridePendingTransition(0, 0);
    paramspz = paramspg.a();
    if ((paramspz != null) && (paramspz.jdField_c_of_type_JavaLangString.equals(paramBaseArticleInfo.mVideoVid))) {}
    for (long l1 = paramspg.a();; l1 = 0L)
    {
      paramspg = new suu(null, paramBaseArticleInfo.mSubscribeID, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID).a(l1).c(paramBaseArticleInfo.mVideoDuration * 1000).e(paramBaseArticleInfo.mAlgorithmID).c(paramBaseArticleInfo.mStrategyId).a(paramInt).g(paramBoolean1).h(paramBoolean2).a().a();
      String str = paramBaseArticleInfo.mSubscribeID;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID))
      {
        paramspz = paramBaseArticleInfo.innerUniqueID;
        olh.a(null, str, "0X8007B89", "0X8007B89", 0, 0, "1", "", paramspz, paramspg, false);
        long l2 = paramActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
        paramActivity = new rqg();
        paramActivity.jdField_d_of_type_Int = ((int)l1);
        paramActivity.jdField_e_of_type_Int = (paramBaseArticleInfo.mVideoDuration * 1000);
        if (l2 != 0L) {
          break label327;
        }
      }
      label327:
      for (int i = 1;; i = 2)
      {
        paramActivity.jdField_c_of_type_Int = i;
        omx.a(paramBaseArticleInfo, paramInt, 25, -1L, paramActivity);
        return;
        paramspz = "0";
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psu
 * JD-Core Version:    0.7.0.1
 */