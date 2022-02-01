package com.tencent.mobileqq.kandian.repo.feeds.pts;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.IForeBackGroundCallback;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleViewModel;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.AdInfo;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.FeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PosAdInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabFeeds;

public class ReadInJoyProteusFamilyUtil
  implements IForeBackGroundCallback
{
  private static int jdField_a_of_type_Int = 0;
  private static ReadInJoyProteusFamilyUtil jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPtsReadInJoyProteusFamilyUtil;
  public static String a = "https://oa.m.tencent.com/an:kandiandata/api/kd_proteus_card?version=0&is_update=1";
  private static JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private static boolean jdField_a_of_type_Boolean = false;
  private static int jdField_b_of_type_Int = 0;
  private static String jdField_b_of_type_JavaLangString = "ReadInJoyProteusFamilyUtil";
  private static List<AbsBaseArticleInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private static Map<Pair<Long, AbsBaseArticleInfo>, String> jdField_b_of_type_JavaUtilMap;
  private static JSONObject jdField_b_of_type_OrgJsonJSONObject;
  private static String jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
  private static JSONObject jdField_c_of_type_OrgJsonJSONObject;
  private static String d;
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  private static String i;
  private static String j;
  private static String k;
  private static String l;
  private static String n;
  private ReadInJoyProteusFamilyUtil.OnProteusFamilyDataLoaded jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPtsReadInJoyProteusFamilyUtil$OnProteusFamilyDataLoaded;
  private List<View> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Pair<Long, Pair<View, AbsBaseArticleInfo>>, Long> jdField_a_of_type_JavaUtilMap = new TreeMap(new ReadInJoyProteusFamilyUtil.1(this));
  private List<Long> jdField_c_of_type_JavaUtilList = new ArrayList();
  private Map<String, Long> jdField_c_of_type_JavaUtilMap = new HashMap();
  private String m;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 86400000;
    d = "version";
    e = "local_data";
    f = "local_update_time";
    g = "remote_update_time";
    h = "family_data";
    i = "proteus_card_list";
    j = "card_id";
    k = "card_value";
    l = "utime";
    jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    jdField_b_of_type_OrgJsonJSONObject = new JSONObject();
    jdField_c_of_type_OrgJsonJSONObject = new JSONObject();
    jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPtsReadInJoyProteusFamilyUtil = null;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_JavaUtilMap = new TreeMap(new ReadInJoyProteusFamilyUtil.2());
  }
  
  private ReadInJoyProteusFamilyUtil()
  {
    f();
    String str = jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init mPskey ");
    localStringBuilder.append(n);
    QLog.d(str, 2, localStringBuilder.toString());
    e();
    ReadinjoySPEventReport.ForeBackGround.a(this);
  }
  
  private static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    return RIJBaseItemViewType.a(paramAbsBaseArticleInfo, paramInt);
  }
  
  private static Bundle a()
  {
    Bundle localBundle = new Bundle();
    Object localObject1 = (QQAppInterface)RIJQQAppInterfaceUtil.a();
    String str = RIJQQAppInterfaceUtil.a();
    Object localObject2 = (TicketManager)((QQAppInterface)localObject1).getManager(2);
    localObject1 = ((TicketManager)localObject2).getSkey(str);
    ((TicketManager)localObject2).getPskey(str, "oa.m.tencent.com");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("p_skey=");
    ((StringBuilder)localObject2).append(n);
    ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("uin=o");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(";p_skey=");
    ((StringBuilder)localObject2).append(n);
    ((StringBuilder)localObject2).append(";p_uin=o");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(";skey=");
    ((StringBuilder)localObject2).append((String)localObject1);
    localBundle.putString("cookie", ((StringBuilder)localObject2).toString());
    str = jdField_b_of_type_JavaLangString;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("cgi req  header : ");
    ((StringBuilder)localObject1).append(localBundle);
    QLog.d(str, 2, ((StringBuilder)localObject1).toString());
    return localBundle;
  }
  
  public static ReadInJoyProteusFamilyUtil a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPtsReadInJoyProteusFamilyUtil == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPtsReadInJoyProteusFamilyUtil == null) {
          jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPtsReadInJoyProteusFamilyUtil = new ReadInJoyProteusFamilyUtil();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPtsReadInJoyProteusFamilyUtil;
  }
  
  private static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo.proteusItemsData)) {
        return "";
      }
      try
      {
        paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData).optString("style_ID");
        return paramAbsBaseArticleInfo;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
      }
    }
    return "";
  }
  
  private static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    int i1 = a(paramAbsBaseArticleInfo, paramInt);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdProteusView(i1)) {
      return String.valueOf(i1);
    }
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 29)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((!ProteusSupportUtil.a(i1)) && (paramInt == 0)) {
      return "";
    }
    if (paramInt == 0) {
      paramAbsBaseArticleInfo = String.valueOf(i1);
    } else {
      paramAbsBaseArticleInfo = a(paramAbsBaseArticleInfo);
    }
    String str = jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPTSCardViewType ");
    localStringBuilder.append(paramAbsBaseArticleInfo);
    QLog.d(str, 2, localStringBuilder.toString());
    return paramAbsBaseArticleInfo;
  }
  
  public static List<AbsBaseArticleInfo> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        Object localObject3 = new HashMap();
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = ((JSONObject)localObject2).keys();
        int i1 = 0;
        Object localObject1;
        if ((localIterator != null) && (localIterator.hasNext()))
        {
          String str = (String)localIterator.next();
          paramString = ((JSONObject)localObject2).getString(str);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(",");
          localStringBuilder.append(((StringBuilder)localObject1).toString());
          if (!((Map)localObject3).containsKey(str)) {
            ((Map)localObject3).put(str, Integer.valueOf(1));
          } else {
            ((Map)localObject3).put(str, Integer.valueOf(((Integer)((Map)localObject3).get(str)).intValue() + 1));
          }
          paramString = Base64Util.decode(paramString.getBytes(), 0);
          int i2 = paramString[0];
          if (i2 == 0)
          {
            localObject1 = new articlesummary.ArticleSummary();
            ((articlesummary.ArticleSummary)localObject1).mergeFrom(Arrays.copyOfRange(paramString, 1, paramString.length));
            paramString = ReadInJoyMSFHandlerUtils.a((articlesummary.ArticleSummary)localObject1, 0, 0, null);
          }
          else
          {
            Object localObject4;
            if (i2 == 1)
            {
              localObject4 = new oidb_cmd0x68b.RspGetFollowTabFeeds();
              ((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject4).mergeFrom(Arrays.copyOfRange(paramString, 1, paramString.length));
              if ((!((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject4).msg_article_summary.has()) || (!((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject4).uint32_feeds_type.has())) {
                break label898;
              }
              localObject1 = ReadInJoyMSFHandlerUtils.a((articlesummary.ArticleSummary)((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject4).msg_article_summary.get(), 70, 0, null);
              paramString = (String)localObject1;
              if (localObject1 != null)
              {
                paramString = (String)localObject1;
                if (((AbsBaseArticleInfo)localObject1).mArticleID != -1L)
                {
                  paramString = (String)localObject1;
                  if (((AbsBaseArticleInfo)localObject1).mRecommendSeq != -1L)
                  {
                    if (((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject4).uint64_follow_recommend_id.has()) {
                      ((AbsBaseArticleInfo)localObject1).mRecommendFollowId = ((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject4).uint64_follow_recommend_id.get();
                    }
                    ((AbsBaseArticleInfo)localObject1).mFeedType = ((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject4).uint32_feeds_type.get();
                    paramString = (String)localObject1;
                  }
                }
              }
            }
            else
            {
              if (i2 != 2) {
                break label903;
              }
              localObject1 = new articlesummary.ArticleSummary();
              ((articlesummary.ArticleSummary)localObject1).mergeFrom(Arrays.copyOfRange(paramString, 1, paramString.length));
              if ((!((articlesummary.ArticleSummary)localObject1).msg_feeds_info.has()) || (((articlesummary.ArticleSummary)localObject1).msg_feeds_info.get() == null) || (!((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject1).msg_feeds_info.get()).msg_pos_ad_info.has())) {
                break label903;
              }
              paramString = (articlesummary.PosAdInfo)((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject1).msg_feeds_info.get()).msg_pos_ad_info.get();
              if ((paramString == null) || (paramString.int32_ret.get() != 0)) {
                break label903;
              }
              i2 = paramString.enum_pos_layout.get();
              long l1 = paramString.uint64_pos_id.get();
              long l2 = paramString.is_auto_play.get();
              paramString = new AdvertisementInfo((articlesummary.AdInfo)paramString.msg_ad_info.get());
              ReadInJoyMSFHandlerUtils.a((articlesummary.ArticleSummary)localObject1, 0, 0, paramString);
              ((AdvertisementInfo)paramString).mAdPosLayout = i2;
              ((AdvertisementInfo)paramString).mAdPosID = l1;
              ((AdvertisementInfo)paramString).mADVideoAutoPlay = l2;
              if ((paramString == null) || (TextUtils.isEmpty(b(paramString, 8888)))) {
                continue;
              }
              localArrayList.add(paramString);
              localObject1 = jdField_b_of_type_JavaLangString;
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("convert2ArticleInfoList  | position : ");
              ((StringBuilder)localObject4).append(i1);
              ((StringBuilder)localObject4).append(" key : ");
              ((StringBuilder)localObject4).append(str);
              ((StringBuilder)localObject4).append(" itemtype :");
              ((StringBuilder)localObject4).append(a(paramString, 8888));
              ((StringBuilder)localObject4).append(" article_title: ");
              ((StringBuilder)localObject4).append(paramString.mTitle);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject4).toString());
              i1 += 1;
            }
          }
        }
        else
        {
          paramString = ((Map)localObject3).entrySet().iterator();
          if (paramString.hasNext())
          {
            localObject1 = (Map.Entry)paramString.next();
            localObject2 = jdField_b_of_type_JavaLangString;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("convert2ArticleInfoList  | cnt key : ");
            ((StringBuilder)localObject3).append((String)((Map.Entry)localObject1).getKey());
            ((StringBuilder)localObject3).append(" count ");
            ((StringBuilder)localObject3).append(((Map.Entry)localObject1).getValue());
            QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
            continue;
          }
          paramString = jdField_b_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("convert2ArticleInfoList  | family num :");
          ((StringBuilder)localObject1).append(localArrayList.size());
          ((StringBuilder)localObject1).append(" ;card view type list : ");
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
          QLog.d(paramString, 2, ((StringBuilder)localObject1).toString());
          return localArrayList;
        }
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        paramString.printStackTrace();
        return localArrayList;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return localArrayList;
      }
      for (;;)
      {
        break;
        label898:
        paramString = null;
      }
      label903:
      paramString = null;
    }
  }
  
  private void a(List<AbsBaseArticleInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = jdField_b_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      jdField_b_of_type_JavaUtilList.clear();
    }
    paramList = paramList.listIterator();
    while (paramList.hasNext())
    {
      localObject = (AbsBaseArticleInfo)paramList.next();
      if (localObject != null)
      {
        ((AbsBaseArticleInfo)localObject).articleViewModel = ArticleViewModel.a((AbsBaseArticleInfo)localObject);
        jdField_b_of_type_JavaUtilList.add(localObject);
      }
    }
  }
  
  public static boolean a()
  {
    return false;
  }
  
  private static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    int i1 = a(paramAbsBaseArticleInfo, paramInt);
    boolean bool = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdProteusView(i1);
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 29)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((ProteusSupportUtil.a(i1)) || (paramInt != 0)) {
      bool = true;
    }
    paramAbsBaseArticleInfo = jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isPtsCard | viewType : ");
    localStringBuilder.append(i1);
    localStringBuilder.append(" isPts ");
    localStringBuilder.append(bool);
    QLog.d(paramAbsBaseArticleInfo, 2, localStringBuilder.toString());
    return bool;
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) || (b(String.valueOf(paramString)));
  }
  
  private static String b(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    paramAbsBaseArticleInfo = ReadInJoyBaseAdapter.a(paramAbsBaseArticleInfo, paramInt);
    String str = jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPtsFamilyCardViewType | viewType : ");
    localStringBuilder.append(paramAbsBaseArticleInfo);
    QLog.d(str, 2, localStringBuilder.toString());
    return paramAbsBaseArticleInfo;
  }
  
  private List<AbsBaseArticleInfo> b()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = jdField_b_of_type_JavaUtilList;
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    return localArrayList;
  }
  
  private static boolean b(String paramString)
  {
    JSONObject localJSONObject = jdField_c_of_type_OrgJsonJSONObject;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localJSONObject != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(localJSONObject.optString(paramString)))
      {
        localJSONObject = jdField_a_of_type_OrgJsonJSONObject;
        bool1 = bool2;
        if (localJSONObject != null)
        {
          if (localJSONObject.optLong(paramString) == 0L) {
            return true;
          }
          long l1 = jdField_a_of_type_OrgJsonJSONObject.optLong(paramString);
          if (System.currentTimeMillis() - l1 > jdField_b_of_type_Int) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  private static String c(String paramString)
  {
    try
    {
      String str = jdField_a_of_type_JavaLangString;
      Object localObject = new Bundle();
      if (!TextUtils.isEmpty(paramString))
      {
        ((Bundle)localObject).putString("card_id_list", paramString);
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(jdField_a_of_type_Int);
        paramString.append("");
        ((Bundle)localObject).putString("version", paramString.toString());
      }
      paramString = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cgi req  url: ");
      localStringBuilder.append(str);
      localStringBuilder.append("; req params ");
      localStringBuilder.append(((Bundle)localObject).toString());
      QLog.d(paramString, 2, localStringBuilder.toString());
      paramString = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), str, "GET", (Bundle)localObject, a());
      if (paramString == null) {
        return "";
      }
      paramString = new String(paramString);
      str = jdField_b_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cgi resp : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
      paramString = new JSONObject(paramString);
      if (Integer.parseInt(paramString.getString(d)) > 0)
      {
        int i1 = Integer.parseInt(paramString.getString(d));
        if (i1 > jdField_a_of_type_Int)
        {
          jdField_a_of_type_Int = i1;
          f();
          jdField_b_of_type_JavaUtilList.clear();
        }
        RIJSPUtils.a(d, Integer.valueOf(jdField_a_of_type_Int));
        str = jdField_b_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update version ");
        ((StringBuilder)localObject).append(jdField_a_of_type_Int);
        QLog.d(str, 2, ((StringBuilder)localObject).toString());
      }
      paramString = paramString.optString(i);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private void e()
  {
    jdField_a_of_type_Int = ((Integer)RIJSPUtils.a(d, Integer.valueOf(0))).intValue();
    String str = jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("local version ");
    localStringBuilder.append(jdField_a_of_type_Int);
    QLog.d(str, 2, localStringBuilder.toString());
    try
    {
      jdField_a_of_type_OrgJsonJSONObject = new JSONObject((String)RIJSPUtils.a(f, ""));
      jdField_b_of_type_OrgJsonJSONObject = new JSONObject((String)RIJSPUtils.a(g, ""));
      jdField_c_of_type_OrgJsonJSONObject = new JSONObject((String)RIJSPUtils.a(e, ""));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static String f()
  {
    Object localObject3 = RIJQQAppInterfaceUtil.b();
    if (localObject3 == null)
    {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "getPskeyFromServer | mApp is null");
      return "";
    }
    Object localObject1 = (TicketManager)((QQAppInterface)localObject3).getManager(2);
    String str = null;
    if (localObject1 != null)
    {
      localObject2 = ((QQAppInterface)localObject3).getCurrentAccountUin();
      localObject3 = new ReadInJoyProteusFamilyUtil.3((TicketManager)localObject1, (QQAppInterface)localObject3);
      localObject1 = ((TicketManager)localObject1).getPskey((String)localObject2, 16L, new String[] { "m.tencent.com" }, (WtTicketPromise)localObject3);
      if ((localObject1 != null) && (((Ticket)localObject1)._pskey_map != null) && (((Ticket)localObject1)._pskey_map.get("m.tencent.com") != null))
      {
        QLog.i(jdField_b_of_type_JavaLangString, 1, "getPskeyFromServerAndRetry get pskey with promise success! isImediately Resend: ");
        str = new String((byte[])((Ticket)localObject1)._pskey_map.get("m.tencent.com"));
      }
      else
      {
        QLog.i(jdField_b_of_type_JavaLangString, 1, "getPskeyFromServerAndRetry get pskey from server now!");
      }
    }
    else
    {
      QLog.e(jdField_b_of_type_JavaLangString, 1, "getPskeyFromServerAndRetry,ticketmanager is null");
    }
    n = str;
    localObject1 = jdField_b_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getPskeyFromServer mPskey : ");
    ((StringBuilder)localObject2).append(n);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    return str;
  }
  
  private static void f()
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_JavaUtilList.clear();
    jdField_b_of_type_JavaUtilMap.clear();
  }
  
  private static void g()
  {
    JSONObject localJSONObject = jdField_a_of_type_OrgJsonJSONObject;
    if (localJSONObject != null)
    {
      if (localJSONObject.length() == 0) {
        return;
      }
      RIJSPUtils.a(f, jdField_a_of_type_OrgJsonJSONObject.toString());
      localJSONObject = jdField_c_of_type_OrgJsonJSONObject;
      if (localJSONObject != null)
      {
        if (localJSONObject.length() == 0) {
          return;
        }
        RIJSPUtils.a(e, jdField_c_of_type_OrgJsonJSONObject.toString());
      }
    }
  }
  
  public void a() {}
  
  public void a(int paramInt, List<oidb_cmd0x68b.RspGetFollowTabFeeds> paramList, List<AbsBaseArticleInfo> paramList1)
  {
    if ((paramList != null) && (paramList1 != null) && (paramList.size() == paramList1.size())) {
      if (jdField_c_of_type_OrgJsonJSONObject == null) {
        return;
      }
    }
    for (;;)
    {
      int i1;
      try
      {
        int i2 = paramList1.size();
        i1 = 0;
        if (i1 < i2)
        {
          String str = b((AbsBaseArticleInfo)paramList1.get(i1), paramInt);
          a((AbsBaseArticleInfo)paramList1.get(i1), paramInt);
          if (!a(str)) {
            break label218;
          }
          Object localObject = ((oidb_cmd0x68b.RspGetFollowTabFeeds)paramList.get(i1)).toByteArray();
          byte[] arrayOfByte = new byte[localObject.length + 1];
          arrayOfByte[0] = 1;
          System.arraycopy(localObject, 0, arrayOfByte, 1, localObject.length);
          localObject = new String(Base64Util.encode(arrayOfByte, 0));
          if (jdField_c_of_type_OrgJsonJSONObject != null)
          {
            jdField_c_of_type_OrgJsonJSONObject.put(str, localObject);
            this.m = jdField_c_of_type_OrgJsonJSONObject.toString();
          }
          if (jdField_a_of_type_OrgJsonJSONObject == null) {
            break label218;
          }
          jdField_a_of_type_OrgJsonJSONObject.put(str, System.currentTimeMillis());
          break label218;
        }
        g();
        QLog.d(jdField_b_of_type_JavaLangString, 2, "collect social card articleinfo ");
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
      return;
      label218:
      i1 += 1;
    }
  }
  
  public void a(ReadInJoyProteusFamilyUtil.OnProteusFamilyDataLoaded paramOnProteusFamilyDataLoaded)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPtsReadInJoyProteusFamilyUtil$OnProteusFamilyDataLoaded = paramOnProteusFamilyDataLoaded;
  }
  
  public void a(List<articlesummary.ArticleSummary> paramList, List<AbsBaseArticleInfo> paramList1, int paramInt)
  {
    if ((paramList != null) && (paramList1 != null) && (paramList.size() == paramList1.size())) {
      if (jdField_c_of_type_OrgJsonJSONObject == null) {
        return;
      }
    }
    for (;;)
    {
      int i1;
      try
      {
        int i2 = paramList1.size();
        i1 = 0;
        if (i1 < i2)
        {
          String str = b((AbsBaseArticleInfo)paramList1.get(i1), paramInt);
          a((AbsBaseArticleInfo)paramList1.get(i1), 0);
          if (!a(str)) {
            break label218;
          }
          Object localObject = ((articlesummary.ArticleSummary)paramList.get(i1)).toByteArray();
          byte[] arrayOfByte = new byte[localObject.length + 1];
          arrayOfByte[0] = 0;
          System.arraycopy(localObject, 0, arrayOfByte, 1, localObject.length);
          localObject = new String(Base64Util.encode(arrayOfByte, 0));
          if (jdField_c_of_type_OrgJsonJSONObject != null)
          {
            jdField_c_of_type_OrgJsonJSONObject.put(str, localObject);
            this.m = jdField_c_of_type_OrgJsonJSONObject.toString();
          }
          if (jdField_a_of_type_OrgJsonJSONObject == null) {
            break label218;
          }
          jdField_a_of_type_OrgJsonJSONObject.put(str, System.currentTimeMillis());
          break label218;
        }
        g();
        QLog.d(jdField_b_of_type_JavaLangString, 2, "collect normal card articleinfo ");
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
      return;
      label218:
      i1 += 1;
    }
  }
  
  public void a(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramArticleSummary == null) {
      return;
    }
    try
    {
      String str = b(paramAbsBaseArticleInfo, 0);
      a(paramAbsBaseArticleInfo, 0);
      if (!a(str)) {
        return;
      }
      paramArticleSummary = paramArticleSummary.toByteArray();
      paramAbsBaseArticleInfo = new byte[paramArticleSummary.length + 1];
      paramAbsBaseArticleInfo[0] = 2;
      System.arraycopy(paramArticleSummary, 0, paramAbsBaseArticleInfo, 1, paramArticleSummary.length);
      paramArticleSummary = new String(Base64Util.encode(paramAbsBaseArticleInfo, 0));
      if (jdField_c_of_type_OrgJsonJSONObject != null)
      {
        jdField_c_of_type_OrgJsonJSONObject.put(str, paramArticleSummary);
        this.m = jdField_c_of_type_OrgJsonJSONObject.toString();
      }
      if (jdField_a_of_type_OrgJsonJSONObject != null) {
        jdField_a_of_type_OrgJsonJSONObject.put(str, System.currentTimeMillis());
      }
      g();
      QLog.d(jdField_b_of_type_JavaLangString, 2, "collect ad card articleinfo ");
      return;
    }
    catch (JSONException paramArticleSummary) {}
  }
  
  public void ax_() {}
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPtsReadInJoyProteusFamilyUtil$OnProteusFamilyDataLoaded == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyProteusFamilyUtil.4(this));
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsPtsReadInJoyProteusFamilyUtil$OnProteusFamilyDataLoaded = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.pts.ReadInJoyProteusFamilyUtil
 * JD-Core Version:    0.7.0.1
 */