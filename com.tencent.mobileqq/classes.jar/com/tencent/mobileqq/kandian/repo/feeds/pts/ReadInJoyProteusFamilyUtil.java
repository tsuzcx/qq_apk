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
  public static String a = "https://oa.m.tencent.com/an:kandiandata/api/kd_proteus_card?version=0&is_update=1";
  private static String b = "ReadInJoyProteusFamilyUtil";
  private static String c = a;
  private static int d = 0;
  private static int e = 86400000;
  private static String f = "version";
  private static String g = "local_data";
  private static String h = "local_update_time";
  private static String i = "remote_update_time";
  private static String j = "family_data";
  private static String k = "proteus_card_list";
  private static String l = "card_id";
  private static String m = "card_value";
  private static String n = "utime";
  private static JSONObject o = new JSONObject();
  private static JSONObject p = new JSONObject();
  private static JSONObject q = new JSONObject();
  private static ReadInJoyProteusFamilyUtil r = null;
  private static boolean t = false;
  private static String v;
  private static Map<Pair<Long, AbsBaseArticleInfo>, String> x = new TreeMap(new ReadInJoyProteusFamilyUtil.2());
  private static List<AbsBaseArticleInfo> z = new ArrayList();
  private List<Long> A = new ArrayList();
  private Map<String, Long> B = new HashMap();
  private ReadInJoyProteusFamilyUtil.OnProteusFamilyDataLoaded s;
  private String u;
  private Map<Pair<Long, Pair<View, AbsBaseArticleInfo>>, Long> w = new TreeMap(new ReadInJoyProteusFamilyUtil.1(this));
  private List<View> y = new ArrayList();
  
  private ReadInJoyProteusFamilyUtil()
  {
    n();
    String str = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init mPskey ");
    localStringBuilder.append(v);
    QLog.d(str, 2, localStringBuilder.toString());
    m();
    ReadinjoySPEventReport.ForeBackGround.a(this);
  }
  
  private static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    return RIJBaseItemViewType.a(paramAbsBaseArticleInfo, paramInt);
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
                break label897;
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
                break label902;
              }
              localObject1 = new articlesummary.ArticleSummary();
              ((articlesummary.ArticleSummary)localObject1).mergeFrom(Arrays.copyOfRange(paramString, 1, paramString.length));
              if ((!((articlesummary.ArticleSummary)localObject1).msg_feeds_info.has()) || (((articlesummary.ArticleSummary)localObject1).msg_feeds_info.get() == null) || (!((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject1).msg_feeds_info.get()).msg_pos_ad_info.has())) {
                break label902;
              }
              paramString = (articlesummary.PosAdInfo)((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject1).msg_feeds_info.get()).msg_pos_ad_info.get();
              if ((paramString == null) || (paramString.int32_ret.get() != 0)) {
                break label902;
              }
              i2 = paramString.enum_pos_layout.get();
              long l1 = paramString.uint64_pos_id.get();
              long l2 = paramString.is_auto_play.get();
              paramString = new AdvertisementInfo((articlesummary.AdInfo)paramString.msg_ad_info.get());
              ReadInJoyMSFHandlerUtils.a((articlesummary.ArticleSummary)localObject1, 0, 0, paramString);
              ((AdvertisementInfo)paramString).mAdPosLayout = i2;
              ((AdvertisementInfo)paramString).mAdPosID = l1;
              ((AdvertisementInfo)paramString).mADVideoAutoPlay = l2;
              if ((paramString == null) || (TextUtils.isEmpty(c(paramString, 8888)))) {
                continue;
              }
              localArrayList.add(paramString);
              localObject1 = b;
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("convert2ArticleInfoList  | position : ");
              ((StringBuilder)localObject4).append(i1);
              ((StringBuilder)localObject4).append(" key : ");
              ((StringBuilder)localObject4).append(str);
              ((StringBuilder)localObject4).append(" itemtype :");
              ((StringBuilder)localObject4).append(b(paramString, 8888));
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
            localObject2 = b;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("convert2ArticleInfoList  | cnt key : ");
            ((StringBuilder)localObject3).append((String)((Map.Entry)localObject1).getKey());
            ((StringBuilder)localObject3).append(" count ");
            ((StringBuilder)localObject3).append(((Map.Entry)localObject1).getValue());
            QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
            continue;
          }
          paramString = b;
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
        label897:
        paramString = null;
      }
      label902:
      paramString = null;
    }
  }
  
  private void a(List<AbsBaseArticleInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = z;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      z.clear();
    }
    paramList = paramList.listIterator();
    while (paramList.hasNext())
    {
      localObject = (AbsBaseArticleInfo)paramList.next();
      if (localObject != null)
      {
        ((AbsBaseArticleInfo)localObject).articleViewModel = ArticleViewModel.a((AbsBaseArticleInfo)localObject);
        z.add(localObject);
      }
    }
  }
  
  private static String b(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
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
    String str = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPTSCardViewType ");
    localStringBuilder.append(paramAbsBaseArticleInfo);
    QLog.d(str, 2, localStringBuilder.toString());
    return paramAbsBaseArticleInfo;
  }
  
  public static ReadInJoyProteusFamilyUtil c()
  {
    if (r == null) {
      try
      {
        if (r == null) {
          r = new ReadInJoyProteusFamilyUtil();
        }
      }
      finally {}
    }
    return r;
  }
  
  private static String c(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    paramAbsBaseArticleInfo = ReadInJoyBaseAdapter.a(paramAbsBaseArticleInfo, paramInt);
    String str = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPtsFamilyCardViewType | viewType : ");
    localStringBuilder.append(paramAbsBaseArticleInfo);
    QLog.d(str, 2, localStringBuilder.toString());
    return paramAbsBaseArticleInfo;
  }
  
  private static String d(String paramString)
  {
    try
    {
      String str = a;
      Object localObject = new Bundle();
      if (!TextUtils.isEmpty(paramString))
      {
        ((Bundle)localObject).putString("card_id_list", paramString);
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(d);
        paramString.append("");
        ((Bundle)localObject).putString("version", paramString.toString());
      }
      paramString = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cgi req  url: ");
      localStringBuilder.append(str);
      localStringBuilder.append("; req params ");
      localStringBuilder.append(((Bundle)localObject).toString());
      QLog.d(paramString, 2, localStringBuilder.toString());
      paramString = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), str, "GET", (Bundle)localObject, p());
      if (paramString == null) {
        return "";
      }
      paramString = new String(paramString);
      str = b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cgi resp : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
      paramString = new JSONObject(paramString);
      if (Integer.parseInt(paramString.getString(f)) > 0)
      {
        int i1 = Integer.parseInt(paramString.getString(f));
        if (i1 > d)
        {
          d = i1;
          o();
          z.clear();
        }
        RIJSPUtils.a(f, Integer.valueOf(d));
        str = b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update version ");
        ((StringBuilder)localObject).append(d);
        QLog.d(str, 2, ((StringBuilder)localObject).toString());
      }
      paramString = paramString.optString(k);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private static boolean d(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
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
    paramAbsBaseArticleInfo = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isPtsCard | viewType : ");
    localStringBuilder.append(i1);
    localStringBuilder.append(" isPts ");
    localStringBuilder.append(bool);
    QLog.d(paramAbsBaseArticleInfo, 2, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean e()
  {
    return false;
  }
  
  private boolean e(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) || (f(String.valueOf(paramString)));
  }
  
  private static boolean f(String paramString)
  {
    JSONObject localJSONObject = q;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localJSONObject != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(localJSONObject.optString(paramString)))
      {
        localJSONObject = o;
        bool1 = bool2;
        if (localJSONObject != null)
        {
          if (localJSONObject.optLong(paramString) == 0L) {
            return true;
          }
          long l1 = o.optLong(paramString);
          if (System.currentTimeMillis() - l1 > e) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  private void m()
  {
    d = ((Integer)RIJSPUtils.b(f, Integer.valueOf(0))).intValue();
    String str = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("local version ");
    localStringBuilder.append(d);
    QLog.d(str, 2, localStringBuilder.toString());
    try
    {
      o = new JSONObject((String)RIJSPUtils.b(h, ""));
      p = new JSONObject((String)RIJSPUtils.b(i, ""));
      q = new JSONObject((String)RIJSPUtils.b(g, ""));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static String n()
  {
    Object localObject3 = RIJQQAppInterfaceUtil.b();
    if (localObject3 == null)
    {
      QLog.d(b, 2, "getPskeyFromServer | mApp is null");
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
        QLog.i(b, 1, "getPskeyFromServerAndRetry get pskey with promise success! isImediately Resend: ");
        str = new String((byte[])((Ticket)localObject1)._pskey_map.get("m.tencent.com"));
      }
      else
      {
        QLog.i(b, 1, "getPskeyFromServerAndRetry get pskey from server now!");
      }
    }
    else
    {
      QLog.e(b, 1, "getPskeyFromServerAndRetry,ticketmanager is null");
    }
    v = str;
    localObject1 = b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getPskeyFromServer mPskey : ");
    ((StringBuilder)localObject2).append(v);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    return str;
  }
  
  private static void o()
  {
    t = false;
    z.clear();
    x.clear();
  }
  
  private static Bundle p()
  {
    Bundle localBundle = new Bundle();
    Object localObject1 = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    String str = RIJQQAppInterfaceUtil.d();
    Object localObject2 = (TicketManager)((QQAppInterface)localObject1).getManager(2);
    localObject1 = ((TicketManager)localObject2).getSkey(str);
    ((TicketManager)localObject2).getPskey(str, "oa.m.tencent.com");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("p_skey=");
    ((StringBuilder)localObject2).append(v);
    ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("uin=o");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(";p_skey=");
    ((StringBuilder)localObject2).append(v);
    ((StringBuilder)localObject2).append(";p_uin=o");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(";skey=");
    ((StringBuilder)localObject2).append((String)localObject1);
    localBundle.putString("cookie", ((StringBuilder)localObject2).toString());
    str = b;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("cgi req  header : ");
    ((StringBuilder)localObject1).append(localBundle);
    QLog.d(str, 2, ((StringBuilder)localObject1).toString());
    return localBundle;
  }
  
  private static void q()
  {
    JSONObject localJSONObject = o;
    if (localJSONObject != null)
    {
      if (localJSONObject.length() == 0) {
        return;
      }
      RIJSPUtils.a(h, o.toString());
      localJSONObject = q;
      if (localJSONObject != null)
      {
        if (localJSONObject.length() == 0) {
          return;
        }
        RIJSPUtils.a(g, q.toString());
      }
    }
  }
  
  private List<AbsBaseArticleInfo> r()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = z;
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(int paramInt, List<oidb_cmd0x68b.RspGetFollowTabFeeds> paramList, List<AbsBaseArticleInfo> paramList1)
  {
    if ((paramList != null) && (paramList1 != null) && (paramList.size() == paramList1.size())) {
      if (q == null) {
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
          String str = c((AbsBaseArticleInfo)paramList1.get(i1), paramInt);
          d((AbsBaseArticleInfo)paramList1.get(i1), paramInt);
          if (!e(str)) {
            break label218;
          }
          Object localObject = ((oidb_cmd0x68b.RspGetFollowTabFeeds)paramList.get(i1)).toByteArray();
          byte[] arrayOfByte = new byte[localObject.length + 1];
          arrayOfByte[0] = 1;
          System.arraycopy(localObject, 0, arrayOfByte, 1, localObject.length);
          localObject = new String(Base64Util.encode(arrayOfByte, 0));
          if (q != null)
          {
            q.put(str, localObject);
            this.u = q.toString();
          }
          if (o == null) {
            break label218;
          }
          o.put(str, System.currentTimeMillis());
          break label218;
        }
        q();
        QLog.d(b, 2, "collect social card articleinfo ");
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
    this.s = paramOnProteusFamilyDataLoaded;
  }
  
  public void a(List<articlesummary.ArticleSummary> paramList, List<AbsBaseArticleInfo> paramList1, int paramInt)
  {
    if ((paramList != null) && (paramList1 != null) && (paramList.size() == paramList1.size())) {
      if (q == null) {
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
          String str = c((AbsBaseArticleInfo)paramList1.get(i1), paramInt);
          d((AbsBaseArticleInfo)paramList1.get(i1), 0);
          if (!e(str)) {
            break label218;
          }
          Object localObject = ((articlesummary.ArticleSummary)paramList.get(i1)).toByteArray();
          byte[] arrayOfByte = new byte[localObject.length + 1];
          arrayOfByte[0] = 0;
          System.arraycopy(localObject, 0, arrayOfByte, 1, localObject.length);
          localObject = new String(Base64Util.encode(arrayOfByte, 0));
          if (q != null)
          {
            q.put(str, localObject);
            this.u = q.toString();
          }
          if (o == null) {
            break label218;
          }
          o.put(str, System.currentTimeMillis());
          break label218;
        }
        q();
        QLog.d(b, 2, "collect normal card articleinfo ");
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
      String str = c(paramAbsBaseArticleInfo, 0);
      d(paramAbsBaseArticleInfo, 0);
      if (!e(str)) {
        return;
      }
      paramArticleSummary = paramArticleSummary.toByteArray();
      paramAbsBaseArticleInfo = new byte[paramArticleSummary.length + 1];
      paramAbsBaseArticleInfo[0] = 2;
      System.arraycopy(paramArticleSummary, 0, paramAbsBaseArticleInfo, 1, paramArticleSummary.length);
      paramArticleSummary = new String(Base64Util.encode(paramAbsBaseArticleInfo, 0));
      if (q != null)
      {
        q.put(str, paramArticleSummary);
        this.u = q.toString();
      }
      if (o != null) {
        o.put(str, System.currentTimeMillis());
      }
      q();
      QLog.d(b, 2, "collect ad card articleinfo ");
      return;
    }
    catch (JSONException paramArticleSummary) {}
  }
  
  public void cU_() {}
  
  public void d()
  {
    if (this.s == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyProteusFamilyUtil.4(this));
  }
  
  public void f()
  {
    this.s = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.pts.ReadInJoyProteusFamilyUtil
 * JD-Core Version:    0.7.0.1
 */