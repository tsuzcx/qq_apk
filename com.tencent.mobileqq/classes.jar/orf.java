import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyProteusFamilyUtil.4;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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

public class orf
  implements oxx
{
  private static int jdField_a_of_type_Int;
  public static String a;
  private static orf jdField_a_of_type_Orf;
  private static JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private static boolean jdField_a_of_type_Boolean;
  private static int jdField_b_of_type_Int;
  private static String jdField_b_of_type_JavaLangString = "ReadInJoyProteusFamilyUtil";
  private static List<BaseArticleInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private static Map<Pair<Long, BaseArticleInfo>, String> jdField_b_of_type_JavaUtilMap;
  private static JSONObject jdField_b_of_type_OrgJsonJSONObject;
  private static String jdField_c_of_type_JavaLangString;
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
  private List<View> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Pair<Long, Pair<View, BaseArticleInfo>>, Long> jdField_a_of_type_JavaUtilMap = new TreeMap(new org(this));
  private orj jdField_a_of_type_Orj;
  private List<Long> jdField_c_of_type_JavaUtilList = new ArrayList();
  private Map<String, Long> jdField_c_of_type_JavaUtilMap = new HashMap();
  private String m;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://oa.m.tencent.com/an:kandiandata/api/kd_proteus_card?version=0&is_update=1";
    jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
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
    jdField_b_of_type_JavaUtilMap = new TreeMap(new orh());
  }
  
  private orf()
  {
    f();
    QLog.d(jdField_b_of_type_JavaLangString, 2, "init mPskey " + n);
    c();
    oxs.a(this);
  }
  
  private static int a(ArticleInfo paramArticleInfo, int paramInt)
  {
    return rqj.a(paramArticleInfo, paramInt);
  }
  
  private static Bundle a()
  {
    Bundle localBundle = new Bundle();
    Object localObject = (QQAppInterface)ors.a();
    String str1 = ors.a();
    localObject = (TicketManager)((QQAppInterface)localObject).getManager(2);
    String str2 = ((TicketManager)localObject).getSkey(str1);
    ((TicketManager)localObject).getPskey(str1, "oa.m.tencent.com");
    new StringBuilder().append("p_skey=").append(n).toString();
    localBundle.putString("cookie", "uin=o" + str1 + ";p_skey=" + n + ";p_uin=o" + str1 + ";skey=" + str2);
    QLog.d(jdField_b_of_type_JavaLangString, 2, "cgi req  header : " + localBundle);
    return localBundle;
  }
  
  private static String a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramArticleInfo.proteusItemsData))) {
      return "";
    }
    try
    {
      paramArticleInfo = new JSONObject(paramArticleInfo.proteusItemsData).optString("style_ID");
      return paramArticleInfo;
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
    return "";
  }
  
  private static String a(ArticleInfo paramArticleInfo, int paramInt)
  {
    int i1 = 0;
    int i2 = a(paramArticleInfo, paramInt);
    if (odx.a(i2)) {
      return String.valueOf(i2);
    }
    paramInt = i1;
    if (paramArticleInfo != null)
    {
      paramInt = i1;
      if (paramArticleInfo.mFeedType == 29) {
        paramInt = 1;
      }
    }
    if ((!opy.a(i2)) && (paramInt == 0)) {
      return "";
    }
    if (paramInt == 0) {}
    for (paramArticleInfo = String.valueOf(i2);; paramArticleInfo = a(paramArticleInfo))
    {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "getPTSCardViewType " + paramArticleInfo);
      return paramArticleInfo;
    }
  }
  
  public static List<BaseArticleInfo> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    localArrayList = new ArrayList();
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (localJSONObject == null) {
        return null;
      }
      i1 = 0;
      localHashMap = new HashMap();
      localStringBuilder = new StringBuilder();
      localIterator = localJSONObject.keys();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        int i1;
        Iterator localIterator;
        String str;
        Object localObject2;
        int i2;
        paramString.printStackTrace();
        return localArrayList;
        Object localObject3;
        if (i2 == 1)
        {
          localObject3 = new oidb_cmd0x68b.RspGetFollowTabFeeds();
          ((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject3).mergeFrom(Arrays.copyOfRange((byte[])localObject2, 1, localObject2.length));
          if ((!((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject3).msg_article_summary.has()) || (!((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject3).uint32_feeds_type.has())) {
            break;
          }
          localObject1 = puy.a((articlesummary.ArticleSummary)((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject3).msg_article_summary.get(), 70, 0, null);
          paramString = (String)localObject1;
          if (localObject1 == null) {
            break label863;
          }
          paramString = (String)localObject1;
          if (((ArticleInfo)localObject1).mArticleID == -1L) {
            break label863;
          }
          paramString = (String)localObject1;
          if (((ArticleInfo)localObject1).mRecommendSeq == -1L) {
            break label863;
          }
          if (((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject3).uint64_follow_recommend_id.has()) {
            ((ArticleInfo)localObject1).mRecommendFollowId = ((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject3).uint64_follow_recommend_id.get();
          }
          ((ArticleInfo)localObject1).mFeedType = ((oidb_cmd0x68b.RspGetFollowTabFeeds)localObject3).uint32_feeds_type.get();
          paramString = (String)localObject1;
          break label863;
        }
        paramString = (String)localObject1;
        if (i2 == 2)
        {
          localObject3 = new articlesummary.ArticleSummary();
          ((articlesummary.ArticleSummary)localObject3).mergeFrom(Arrays.copyOfRange((byte[])localObject2, 1, localObject2.length));
          paramString = (String)localObject1;
          if (((articlesummary.ArticleSummary)localObject3).msg_feeds_info.has())
          {
            paramString = (String)localObject1;
            if (((articlesummary.ArticleSummary)localObject3).msg_feeds_info.get() != null)
            {
              paramString = (String)localObject1;
              if (((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject3).msg_feeds_info.get()).msg_pos_ad_info.has())
              {
                localObject2 = (articlesummary.PosAdInfo)((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject3).msg_feeds_info.get()).msg_pos_ad_info.get();
                paramString = (String)localObject1;
                if (localObject2 != null)
                {
                  paramString = (String)localObject1;
                  if (((articlesummary.PosAdInfo)localObject2).int32_ret.get() == 0)
                  {
                    i2 = ((articlesummary.PosAdInfo)localObject2).enum_pos_layout.get();
                    long l1 = ((articlesummary.PosAdInfo)localObject2).uint64_pos_id.get();
                    long l2 = ((articlesummary.PosAdInfo)localObject2).is_auto_play.get();
                    paramString = new AdvertisementInfo((articlesummary.AdInfo)((articlesummary.PosAdInfo)localObject2).msg_ad_info.get());
                    puy.a((articlesummary.ArticleSummary)localObject3, 0, 0, paramString);
                    ((AdvertisementInfo)paramString).mAdPosLayout = i2;
                    ((AdvertisementInfo)paramString).mAdPosID = l1;
                    ((AdvertisementInfo)paramString).mADVideoAutoPlay = l2;
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramString)
    {
      for (;;)
      {
        HashMap localHashMap;
        StringBuilder localStringBuilder;
        Object localObject1;
        paramString.printStackTrace();
        continue;
        paramString = localHashMap.entrySet().iterator();
        while (paramString.hasNext())
        {
          localObject1 = (Map.Entry)paramString.next();
          QLog.d(jdField_b_of_type_JavaLangString, 2, "convert2ArticleInfoList  | cnt key : " + (String)((Map.Entry)localObject1).getKey() + " count " + ((Map.Entry)localObject1).getValue());
        }
        QLog.d(jdField_b_of_type_JavaLangString, 2, "convert2ArticleInfoList  | family num :" + localArrayList.size() + " ;card view type list : " + localStringBuilder.toString());
        continue;
        break label860;
        paramString = null;
        break label863;
      }
    }
    if ((localIterator != null) && (localIterator.hasNext()))
    {
      str = (String)localIterator.next();
      paramString = localJSONObject.getString(str);
      localStringBuilder.append(str + ",");
      if (!localHashMap.containsKey(str)) {
        localHashMap.put(str, Integer.valueOf(1));
      }
      for (;;)
      {
        localObject2 = bdfr.decode(paramString.getBytes(), 0);
        i2 = localObject2[0];
        localObject1 = null;
        if (i2 != 0) {
          break;
        }
        paramString = new articlesummary.ArticleSummary();
        paramString.mergeFrom(Arrays.copyOfRange((byte[])localObject2, 1, localObject2.length));
        paramString = puy.a(paramString, 0, 0, null);
        if ((paramString == null) || (TextUtils.isEmpty(b(paramString, 8888)))) {
          break label852;
        }
        localArrayList.add(paramString);
        QLog.d(jdField_b_of_type_JavaLangString, 2, "convert2ArticleInfoList  | position : " + i1 + " key : " + str + " itemtype :" + a(paramString, 8888) + " article_title: " + paramString.mTitle);
        i1 += 1;
        break label860;
        localHashMap.put(str, Integer.valueOf(((Integer)localHashMap.get(str)).intValue() + 1));
      }
    }
  }
  
  public static orf a()
  {
    if (jdField_a_of_type_Orf == null) {}
    try
    {
      if (jdField_a_of_type_Orf == null) {
        jdField_a_of_type_Orf = new orf();
      }
      return jdField_a_of_type_Orf;
    }
    finally {}
  }
  
  private void a(List<BaseArticleInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      if ((jdField_b_of_type_JavaUtilList != null) && (jdField_b_of_type_JavaUtilList.size() > 0)) {
        jdField_b_of_type_JavaUtilList.clear();
      }
      paramList = paramList.listIterator();
      while (paramList.hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramList.next();
        if (localBaseArticleInfo != null)
        {
          localBaseArticleInfo.articleViewModel = slx.a(localBaseArticleInfo);
          jdField_b_of_type_JavaUtilList.add(localBaseArticleInfo);
        }
      }
    }
  }
  
  public static boolean a()
  {
    return false;
  }
  
  private static boolean a(ArticleInfo paramArticleInfo, int paramInt)
  {
    boolean bool3 = true;
    int i1 = 0;
    int i2 = a(paramArticleInfo, paramInt);
    if (odx.a(i2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramInt = i1;
      if (paramArticleInfo != null)
      {
        paramInt = i1;
        if (paramArticleInfo.mFeedType == 29) {
          paramInt = 1;
        }
      }
      boolean bool2 = bool3;
      if (!opy.a(i2)) {
        if (paramInt == 0) {
          break label100;
        }
      }
      label100:
      for (bool2 = bool3;; bool2 = bool1)
      {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "isPtsCard | viewType : " + i2 + " isPts " + bool2);
        return bool2;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) || (b(String.valueOf(paramString)));
  }
  
  private static String b(ArticleInfo paramArticleInfo, int paramInt)
  {
    paramArticleInfo = rqj.a(paramArticleInfo, paramInt);
    QLog.d(jdField_b_of_type_JavaLangString, 2, "getPtsFamilyCardViewType | viewType : " + paramArticleInfo);
    return paramArticleInfo;
  }
  
  private List<BaseArticleInfo> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (jdField_b_of_type_JavaUtilList != null) {
      localArrayList.addAll(jdField_b_of_type_JavaUtilList);
    }
    return localArrayList;
  }
  
  private static boolean b(String paramString)
  {
    if ((jdField_c_of_type_OrgJsonJSONObject == null) || (TextUtils.isEmpty(jdField_c_of_type_OrgJsonJSONObject.optString(paramString))) || (jdField_a_of_type_OrgJsonJSONObject == null) || (jdField_a_of_type_OrgJsonJSONObject.optLong(paramString) == 0L)) {}
    long l1;
    do
    {
      return true;
      l1 = jdField_a_of_type_OrgJsonJSONObject.optLong(paramString);
    } while (System.currentTimeMillis() - l1 > jdField_b_of_type_Int);
    return false;
  }
  
  private static String c(String paramString)
  {
    try
    {
      String str = jdField_a_of_type_JavaLangString;
      Bundle localBundle = new Bundle();
      if (!TextUtils.isEmpty(paramString)) {
        localBundle.putString("card_id_list", paramString);
      }
      for (;;)
      {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "cgi req  url: " + str + "; req params " + localBundle.toString());
        paramString = ndd.a(BaseApplicationImpl.getContext(), str, "GET", localBundle, a());
        if (paramString != null) {
          break;
        }
        return "";
        localBundle.putString("version", jdField_a_of_type_Int + "");
      }
      paramString = new String(paramString);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return "";
    }
    QLog.d(jdField_b_of_type_JavaLangString, 2, "cgi resp : " + paramString);
    paramString = new JSONObject(paramString);
    if ((paramString != null) && (Integer.parseInt(paramString.getString(d)) > 0))
    {
      int i1 = Integer.parseInt(paramString.getString(d));
      if (i1 > jdField_a_of_type_Int)
      {
        jdField_a_of_type_Int = i1;
        d();
        jdField_b_of_type_JavaUtilList.clear();
      }
      bkbq.a(d, Integer.valueOf(jdField_a_of_type_Int));
      QLog.d(jdField_b_of_type_JavaLangString, 2, "update version " + jdField_a_of_type_Int);
    }
    paramString = paramString.optString(i);
    return paramString;
  }
  
  private void c()
  {
    jdField_a_of_type_Int = ((Integer)bkbq.a(d, Integer.valueOf(0))).intValue();
    QLog.d(jdField_b_of_type_JavaLangString, 2, "local version " + jdField_a_of_type_Int);
    try
    {
      jdField_a_of_type_OrgJsonJSONObject = new JSONObject((String)bkbq.a(f, ""));
      jdField_b_of_type_OrgJsonJSONObject = new JSONObject((String)bkbq.a(g, ""));
      jdField_c_of_type_OrgJsonJSONObject = new JSONObject((String)bkbq.a(e, ""));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void d()
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_JavaUtilList.clear();
    jdField_b_of_type_JavaUtilMap.clear();
  }
  
  private static void e()
  {
    if ((jdField_a_of_type_OrgJsonJSONObject == null) || (jdField_a_of_type_OrgJsonJSONObject.length() == 0)) {}
    do
    {
      return;
      bkbq.a(f, jdField_a_of_type_OrgJsonJSONObject.toString());
    } while ((jdField_c_of_type_OrgJsonJSONObject == null) || (jdField_c_of_type_OrgJsonJSONObject.length() == 0));
    bkbq.a(e, jdField_c_of_type_OrgJsonJSONObject.toString());
  }
  
  private static String f()
  {
    Object localObject2 = rqj.a();
    if (localObject2 == null)
    {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "getPskeyFromServer | mApp is null");
      return "";
    }
    Object localObject1 = (TicketManager)((QQAppInterface)localObject2).getManager(2);
    if (localObject1 != null)
    {
      String str = ((QQAppInterface)localObject2).getCurrentAccountUin();
      localObject2 = new ori((TicketManager)localObject1, (QQAppInterface)localObject2);
      localObject1 = ((TicketManager)localObject1).GetPskey(str, 16L, new String[] { "m.tencent.com" }, (WtTicketPromise)localObject2);
      if ((localObject1 != null) && (((Ticket)localObject1)._pskey_map != null) && (((Ticket)localObject1)._pskey_map.get("m.tencent.com") != null))
      {
        QLog.i(jdField_b_of_type_JavaLangString, 1, "getPskeyFromServerAndRetry get pskey with promise success! isImediately Resend: ");
        localObject1 = new String((byte[])((Ticket)localObject1)._pskey_map.get("m.tencent.com"));
        n = (String)localObject1;
        QLog.d(jdField_b_of_type_JavaLangString, 2, "getPskeyFromServer mPskey : " + n);
        return localObject1;
      }
      QLog.i(jdField_b_of_type_JavaLangString, 1, "getPskeyFromServerAndRetry get pskey from server now!");
    }
    for (;;)
    {
      localObject1 = null;
      break;
      QLog.e(jdField_b_of_type_JavaLangString, 1, "getPskeyFromServerAndRetry,ticketmanager is null");
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Orj == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyProteusFamilyUtil.4(this));
  }
  
  public void a(int paramInt, List<oidb_cmd0x68b.RspGetFollowTabFeeds> paramList, List<ArticleInfo> paramList1)
  {
    if ((paramList == null) || (paramList1 == null) || (paramList.size() != paramList1.size()) || (jdField_c_of_type_OrgJsonJSONObject == null)) {
      return;
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
          String str = b((ArticleInfo)paramList1.get(i1), paramInt);
          a((ArticleInfo)paramList1.get(i1), paramInt);
          if (!a(str)) {
            break label218;
          }
          Object localObject = ((oidb_cmd0x68b.RspGetFollowTabFeeds)paramList.get(i1)).toByteArray();
          byte[] arrayOfByte = new byte[localObject.length + 1];
          arrayOfByte[0] = 1;
          System.arraycopy(localObject, 0, arrayOfByte, 1, localObject.length);
          localObject = new String(bdfr.encode(arrayOfByte, 0));
          if (jdField_c_of_type_OrgJsonJSONObject != null)
          {
            jdField_c_of_type_OrgJsonJSONObject.put(str, localObject);
            this.m = jdField_c_of_type_OrgJsonJSONObject.toString();
          }
          if (jdField_a_of_type_OrgJsonJSONObject == null) {
            break label218;
          }
          jdField_a_of_type_OrgJsonJSONObject.put(str, System.currentTimeMillis());
        }
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
        return;
      }
      e();
      QLog.d(jdField_b_of_type_JavaLangString, 2, "collect social card articleinfo ");
      return;
      label218:
      i1 += 1;
    }
  }
  
  public void a(List<articlesummary.ArticleSummary> paramList, List<ArticleInfo> paramList1, int paramInt)
  {
    if ((paramList == null) || (paramList1 == null) || (paramList.size() != paramList1.size()) || (jdField_c_of_type_OrgJsonJSONObject == null)) {
      return;
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
          String str = b((ArticleInfo)paramList1.get(i1), paramInt);
          a((ArticleInfo)paramList1.get(i1), 0);
          if (!a(str)) {
            break label218;
          }
          Object localObject = ((articlesummary.ArticleSummary)paramList.get(i1)).toByteArray();
          byte[] arrayOfByte = new byte[localObject.length + 1];
          arrayOfByte[0] = 0;
          System.arraycopy(localObject, 0, arrayOfByte, 1, localObject.length);
          localObject = new String(bdfr.encode(arrayOfByte, 0));
          if (jdField_c_of_type_OrgJsonJSONObject != null)
          {
            jdField_c_of_type_OrgJsonJSONObject.put(str, localObject);
            this.m = jdField_c_of_type_OrgJsonJSONObject.toString();
          }
          if (jdField_a_of_type_OrgJsonJSONObject == null) {
            break label218;
          }
          jdField_a_of_type_OrgJsonJSONObject.put(str, System.currentTimeMillis());
        }
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
        return;
      }
      e();
      QLog.d(jdField_b_of_type_JavaLangString, 2, "collect normal card articleinfo ");
      return;
      label218:
      i1 += 1;
    }
  }
  
  public void a(orj paramorj)
  {
    this.jdField_a_of_type_Orj = paramorj;
  }
  
  public void a(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    if (paramArticleSummary == null) {}
    for (;;)
    {
      return;
      try
      {
        String str = b(paramArticleInfo, 0);
        a(paramArticleInfo, 0);
        if (a(str))
        {
          paramArticleSummary = paramArticleSummary.toByteArray();
          paramArticleInfo = new byte[paramArticleSummary.length + 1];
          paramArticleInfo[0] = 2;
          System.arraycopy(paramArticleSummary, 0, paramArticleInfo, 1, paramArticleSummary.length);
          paramArticleSummary = new String(bdfr.encode(paramArticleInfo, 0));
          if (jdField_c_of_type_OrgJsonJSONObject != null)
          {
            jdField_c_of_type_OrgJsonJSONObject.put(str, paramArticleSummary);
            this.m = jdField_c_of_type_OrgJsonJSONObject.toString();
          }
          if (jdField_a_of_type_OrgJsonJSONObject != null) {
            jdField_a_of_type_OrgJsonJSONObject.put(str, System.currentTimeMillis());
          }
          e();
          QLog.d(jdField_b_of_type_JavaLangString, 2, "collect ad card articleinfo ");
          return;
        }
      }
      catch (JSONException paramArticleSummary) {}
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Orj = null;
  }
  
  public void l() {}
  
  public void m() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     orf
 * JD-Core Version:    0.7.0.1
 */