import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AttachedAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusInteractiveItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.3;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.4;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.5;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.6;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.7;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class rac
{
  public static String a;
  public static String b = "https://kandian.qq.com/kandian_article/get_article_recomm?from=native";
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://c.mp.qq.com/cgi-bin/ad/get_mp_ads?";
  }
  
  private static long a(String paramString)
  {
    try
    {
      long l = Long.parseLong(Uri.parse(paramString).getQueryParameter("article_id"));
      return l;
    }
    catch (Exception localException)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("which", "3");
      localHashMap.put("article_url", "" + paramString);
      localHashMap.put("error", "" + localException.toString());
      localHashMap.put("param_uin", obz.a());
      awrn.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebCost", false, 0L, 0L, localHashMap, null);
    }
    return -1L;
  }
  
  private static AdData a(JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (paramJSONObject == null) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return localObject1;
                          if (paramInt == 2) {
                            return new ProteusInnerData();
                          }
                        } while (paramInt != 1);
                        if ((paramJSONObject.has("type")) && (paramJSONObject.optInt("type") == 100)) {
                          return new AttachedAdData();
                        }
                        if (!paramBoolean) {
                          break label384;
                        }
                        if (TextUtils.isEmpty(paramJSONObject.optString("video"))) {
                          break;
                        }
                        localObject2 = new ProteusBannerVideoItemData();
                        localObject1 = localObject2;
                      } while (!paramJSONObject.has("video_file_size"));
                      ((ProteusBannerVideoItemData)localObject2).a = paramJSONObject.optLong("video_file_size");
                      return localObject2;
                      if (paramJSONObject.optInt("img_type") == 3) {
                        return new ProteusBannerTriplePicItemData();
                      }
                      localObject2 = new ProteusBannerBigPicItemData();
                      localObject1 = localObject2;
                    } while (!paramJSONObject.has("local_info"));
                    paramJSONObject = paramJSONObject.optJSONObject("local_info");
                    if (QLog.isColorLevel()) {
                      QLog.d("FastWebRequestUtil", 2, "has local info ->" + paramJSONObject);
                    }
                    localObject1 = localObject2;
                  } while (paramJSONObject == null);
                  ((ProteusBannerBigPicItemData)localObject2).jdField_a_of_type_JavaLangString = paramJSONObject.optString("store_name");
                  ((ProteusBannerBigPicItemData)localObject2).b = paramJSONObject.optString("store_addr");
                  ((ProteusBannerBigPicItemData)localObject2).c = paramJSONObject.optString("store_url");
                  ((ProteusBannerBigPicItemData)localObject2).e = paramJSONObject.optString("store_long");
                  ((ProteusBannerBigPicItemData)localObject2).d = paramJSONObject.optString("store_lat");
                  ((ProteusBannerBigPicItemData)localObject2).f = paramJSONObject.optString("dist_desc");
                  ((ProteusBannerBigPicItemData)localObject2).g = paramJSONObject.optString("corporate_image_name");
                  ((ProteusBannerBigPicItemData)localObject2).h = paramJSONObject.optString("distance_limit");
                  localObject1 = localObject2;
                } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).jdField_a_of_type_JavaLangString));
                localObject1 = localObject2;
              } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).b));
              localObject1 = localObject2;
            } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).c));
            localObject1 = localObject2;
          } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).e));
          localObject1 = localObject2;
        } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).d));
        localObject1 = localObject2;
      } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).f));
      localObject1 = localObject2;
    } while (TextUtils.isEmpty(((ProteusBannerBigPicItemData)localObject2).h));
    ((ProteusBannerBigPicItemData)localObject2).jdField_a_of_type_Boolean = true;
    return localObject2;
    label384:
    return new RecommendAdData();
  }
  
  private static AdData a(JSONObject paramJSONObject, int paramInt1, boolean paramBoolean, String paramString, int paramInt2)
  {
    AdData localAdData = a(paramJSONObject, paramInt1, paramBoolean);
    if (localAdData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FastWebRequestUtil", 1, "parseAdItem failed");
      }
      return null;
    }
    localAdData.a(paramJSONObject, paramString);
    if (localAdData.a(paramJSONObject, paramInt2))
    {
      localAdData.a();
      return localAdData;
    }
    localAdData.a();
    return null;
  }
  
  private static ProteusItemData a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      return new ProteusRecommendItemData();
    }
    return new ProteusInteractiveItemData();
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString;
        } while (paramString.startsWith("http:"));
        str = paramString;
      } while (paramString.startsWith("https"));
      str = paramString;
    } while (paramString.startsWith("mqqapi:"));
    if (paramBoolean) {
      return "https:" + paramString;
    }
    return "http:" + paramString;
  }
  
  public static List<BaseData> a(int paramInt, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = localArrayList;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      localObject = localArrayList;
      if (paramList.hasNext()) {
        localObject = b(paramInt, (String)paramList.next());
      }
    }
    return localObject;
  }
  
  public static void a(ArticleInfo paramArticleInfo, ProteusItemData paramProteusItemData, int paramInt, SparseArray<Float> paramSparseArray)
  {
    if ((paramArticleInfo == null) || (paramProteusItemData == null) || (paramProteusItemData.jdField_b_of_type_OrgJsonJSONObject == null)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = paramProteusItemData.jdField_b_of_type_OrgJsonJSONObject.optJSONObject("card_info");
      if (localJSONObject != null)
      {
        localJSONObject.put("channelID", paramArticleInfo.mChannelID);
        localJSONObject.put("strategyId", paramArticleInfo.mStrategyId);
        localJSONObject.put("algorithmID", paramArticleInfo.mAlgorithmID);
        localJSONObject.put("articleTitle", paramArticleInfo.mTitle);
        localJSONObject.put("articleRowKey", paramArticleInfo.innerUniqueID);
      }
      for (;;)
      {
        Object localObject;
        paramProteusItemData.jdField_b_of_type_Float = localObject;
        paramProteusItemData.t = paramInt;
        return;
        float f1 = qzy.b(paramSparseArray);
        continue;
        f1 = qzy.c(paramSparseArray);
        continue;
        float f2 = -1000.0F;
        f1 = f2;
        switch (paramInt)
        {
        }
        f1 = f2;
      }
      return;
    }
    catch (Exception paramArticleInfo) {}
  }
  
  public static void a(ArticleInfo paramArticleInfo, rgc paramrgc)
  {
    if (paramArticleInfo == null) {
      return;
    }
    QLog.d("FastWebRequestUtil", 2, "deleteFeeds.");
    ThreadManager.excute(new FastWebRequestUtil.6(paramArticleInfo, paramrgc), 128, null, true);
  }
  
  public static void a(String paramString, FastWebArticleInfo paramFastWebArticleInfo)
  {
    QLog.d("Q.readinjoy.fast_web", 2, "" + paramString);
    try
    {
      l = a(paramString);
      if (l == -1L) {
        return;
      }
      paramString = new Bundle();
      paramString.putString("articleId", String.valueOf(l));
      QLog.d("Q.readinjoy.fast_web", 2, "" + "https://c.mp.qq.com/review/img-txt-comment/list?source=1" + "  articleId " + l);
      Bundle localBundle = new Bundle();
      mpl.a(localBundle);
      paramString = new String(mpl.a(BaseApplicationImpl.getContext(), "https://c.mp.qq.com/review/img-txt-comment/list?source=1", "POST", paramString, localBundle));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        long l;
        int i;
        paramFastWebArticleInfo = null;
      }
    }
    try
    {
      QLog.d("Q.readinjoy.fast_web", 2, "https://c.mp.qq.com/review/img-txt-comment/list?source=1" + "  articleId " + l + " " + paramString);
      i = new JSONObject(paramString).getInt("readCount");
      if (i > paramFastWebArticleInfo.a)
      {
        paramFastWebArticleInfo.a = i;
        ThreadManager.getUIHandler().post(new FastWebRequestUtil.5());
        return;
      }
    }
    catch (Exception localException)
    {
      paramFastWebArticleInfo = paramString;
      paramString = localException;
      QLog.e("Q.readinjoy.fast_web", 2, paramString, new Object[] { "" + paramFastWebArticleInfo });
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7, int paramInt, rah paramrah)
  {
    ThreadManager.executeOnNetWorkThread(new FastWebRequestUtil.4(paramString1, paramString2, paramString3, paramString4, paramString6, paramString7, paramBoolean, paramInt, paramString5, paramrah));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7, rag paramrag, int paramInt)
  {
    paramrag = new raf(paramString1, paramrag);
    a(paramString1, paramString2, paramString3, new rad(paramrag));
    a(paramString1, paramString2, paramString3, paramString4, paramBoolean, paramString5, paramString6, paramString7, paramInt, new rae(paramrag));
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, rah paramrah)
  {
    ThreadManager.executeOnNetWorkThread(new FastWebRequestUtil.3(paramString3, paramString1, paramString2, paramrah));
  }
  
  private static String b(Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("ext=" + URLEncoder.encode(paramJSONObject.toString(), "utf-8"));
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        paramJSONObject = (Map.Entry)paramMap.next();
        localStringBuilder.append("&" + (String)paramJSONObject.getKey() + "=" + URLEncoder.encode((String)paramJSONObject.getValue(), "utf-8"));
      }
      paramMap = ((QQAppInterface)obz.a()).getAccount();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.fast_web", 2, "requestAdData:" + localStringBuilder + "    uin : " + paramMap);
      }
      paramMap = new Bundle();
      mpl.a(paramMap);
      paramJSONObject = localStringBuilder.toString();
      paramMap = mpl.a(BaseApplicationImpl.getContext(), paramJSONObject, "GET", null, paramMap);
      if (paramMap == null)
      {
        QLog.e("Q.readinjoy.fast_web", 2, "requestAdData bytes null");
        return null;
      }
      paramJSONObject = new String(paramMap);
      paramMap = paramJSONObject;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.readinjoy.fast_web", 2, "requestAdData result:" + paramJSONObject);
        return paramJSONObject;
      }
    }
    catch (Exception paramMap)
    {
      paramMap = null;
    }
    return paramMap;
  }
  
  private static List<BaseData> b(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("data");
        int i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
          if ((paramInt != 6) || (i == 0)) {}
          try
          {
            localJSONObject.put("label_separator_line_top_bg_color", localJSONObject.optString("label_separator_line_top_bg_color", "#E5E5E5"));
            Object localObject1 = rdg.a("native_article", true);
            if (localObject1 != null)
            {
              localObject1 = ((rdg)localObject1).getTemplateBean(localJSONObject);
              if (localObject1 != null)
              {
                ProteusItemData localProteusItemData = a(paramInt);
                if (localProteusItemData != null)
                {
                  localProteusItemData.a = ((TemplateBean)localObject1);
                  localProteusItemData.jdField_b_of_type_OrgJsonJSONObject = localJSONObject;
                  localArrayList.add(localProteusItemData);
                }
              }
              i += 1;
              continue;
              if (i != localJSONArray.length() - 1) {
                continue;
              }
              localJSONObject.put("label_separator_line_bottom_bg_color", localJSONObject.optString("label_separator_line_bottom_bg_color", "#E5E5E5"));
              continue;
            }
          }
          catch (Exception localException1)
          {
            QLog.d("FastWebRequestUtil", 1, "parseProteusItem msg=" + localException1);
            continue;
          }
        }
        else
        {
          Object localObject2 = null;
        }
      }
      catch (Exception localException2)
      {
        QLog.e("FastWebRequestUtil", 1, new Object[] { "parseProteusData error:", localException2.toString(), " item:" + paramString });
        QLog.d("FastWebRequestUtil", 1, "parseProteusItem,type=" + paramInt + " item=" + paramString + " datasSize=" + localArrayList.size());
        return localArrayList;
      }
    }
  }
  
  private static Map<String, String> b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = (QQAppInterface)obz.a();
    String str = ((QQAppInterface)localObject).getAccount();
    str = ((TicketManager)((QQAppInterface)localObject).getManager(2)).getSkey(str);
    localObject = new HashMap();
    if (paramBoolean) {
      paramString3 = "0";
    }
    ((Map)localObject).put("puin", paramString3);
    ((Map)localObject).put("id", paramString1);
    ((Map)localObject).put("tag", paramString4);
    if (str == null) {}
    for (paramString1 = "";; paramString1 = pye.a(str))
    {
      ((Map)localObject).put("token", paramString1);
      ((Map)localObject).put("cookie", nbe.a());
      ((Map)localObject).put("scene", String.valueOf(3));
      ((Map)localObject).put("rowkey", paramString2);
      if (paramInt2 > 0) {
        ((Map)localObject).put("contentCount", String.valueOf(paramInt2));
      }
      if (!TextUtils.isEmpty(paramString5)) {
        ((Map)localObject).put("nlpCashTag", paramString5);
      }
      if (!TextUtils.isEmpty(paramString6)) {
        ((Map)localObject).put("unionChann", paramString6);
      }
      return localObject;
    }
  }
  
  private static JSONObject b(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      String str;
      try
      {
        localObject1 = new yoz();
        ((yoz)localObject1).jdField_a_of_type_JavaLangString = "ce2d9f";
        localObject1 = yoy.a(BaseApplication.getContext(), (yoz)localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((ypa)localObject1).a;
          localJSONObject.put("muidtype", 1);
          str = nox.b();
          if (!TextUtils.isEmpty(str)) {
            break label566;
          }
          localObject2 = "0000000000000000";
          localJSONObject.put("muid", localObject2);
          localJSONObject.put("carrier", ypb.a(BaseApplicationImpl.getContext()));
          localJSONObject.put("c_os", "android");
          localJSONObject.put("appid", String.valueOf(AppSetting.a()));
          localJSONObject.put("app_version_id", AppSetting.a());
          localJSONObject.put("imei", str);
          if (localObject1 != null)
          {
            localJSONObject.put("conn", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).conn.get());
            localJSONObject.put("hostver", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qq_ver.get());
            localJSONObject.put("c_osver", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver.get());
            localJSONObject.put("qadid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.get());
            localJSONObject.put("oaid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
            localJSONObject.put("taid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
            localJSONObject.put("androidid", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
            localJSONObject.put("mac_addr", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
            if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.has()) {
              localJSONObject.put("ipv4", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
            }
            localJSONObject.put("muid_from_gdt", "1");
            localJSONObject.put("muidtype", ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid_type.get());
            if (!TextUtils.isEmpty(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid.get())) {
              continue;
            }
            localObject2 = "";
            localJSONObject.put("muid", localObject2);
            if (QLog.isColorLevel()) {
              QLog.i("FastWebRequestUtil", 2, "makePhoneInfo0x6cf: deviceInfo: oa=" + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).oaid.get() + ", ta=" + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
            }
          }
          localObject1 = Build.BRAND;
          localObject2 = Build.MODEL;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localJSONObject.put("c_mf", localObject1);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localJSONObject.put("c_device", localObject2);
          }
          if (!TextUtils.isEmpty(paramString))
          {
            paramString = new JSONArray(paramString);
            localObject1 = new JSONArray();
            int i = 0;
            if (i < paramString.length())
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("qie_context", paramString.getJSONObject(i).toString());
              ((JSONArray)localObject1).put(localObject2);
              i += 1;
              continue;
              localObject2 = ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid.get();
              continue;
            }
            if (((JSONArray)localObject1).length() > 0) {
              localJSONObject.put("pos", localObject1);
            }
          }
          return localJSONObject;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return localJSONObject;
      }
      Object localObject1 = null;
      continue;
      label566:
      Object localObject2 = str;
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, rgc paramrgc)
  {
    if (paramArticleInfo == null) {
      return;
    }
    QLog.d("FastWebRequestUtil", 2, "shieldFeedSource");
    ThreadManager.excute(new FastWebRequestUtil.7(paramArticleInfo, paramrgc), 128, null, true);
  }
  
  private static boolean b(String paramString1, String paramString2, List<BaseData> paramList, JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString1)) || (paramList == null))
    {
      bool1 = false;
      return bool1;
    }
    for (;;)
    {
      String str;
      int i;
      Object localObject2;
      int j;
      try
      {
        Object localObject1 = new JSONObject(paramString1);
        nbe.a(((JSONObject)localObject1).optString("cookie"));
        str = ((JSONObject)localObject1).optString("ad_switchs");
        localObject1 = ((JSONObject)localObject1).getJSONArray("result");
        i = 0;
        bool1 = bool2;
        if (i >= ((JSONArray)localObject1).length()) {
          break;
        }
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        if (((JSONObject)localObject2).isNull("ad_pos_type"))
        {
          ((JSONObject)localObject2).put("rowkey", paramString2);
          j = ((JSONObject)localObject2).getInt("ad_pos");
          localObject2 = a(nph.a((JSONObject)localObject2, paramJSONObject), 1, false, str, j);
          npj.a((AdData)localObject2);
          if (localObject2 != null)
          {
            ((AdData)localObject2).e = false;
            paramList.add(localObject2);
          }
        }
        else
        {
          j = ((JSONObject)localObject2).getInt("ad_pos_type");
          if (j == 1)
          {
            ((JSONObject)localObject2).put("rowkey", paramString2);
            localObject2 = a(nph.a((JSONObject)localObject2, paramJSONObject), 1, true, str, -1);
            npj.a((AdData)localObject2);
            if (localObject2 == null) {
              break label322;
            }
            ((AdData)localObject2).e = false;
            paramList.add(localObject2);
          }
        }
      }
      catch (Exception paramString2)
      {
        QLog.e("Q.readinjoy.fast_web", 2, paramString2, new Object[] { "" + paramString1 });
        return false;
      }
      if (j == 2)
      {
        ((JSONObject)localObject2).put("rowkey", paramString2);
        localObject2 = a(nph.a((JSONObject)localObject2, paramJSONObject), 2, false, str, -1);
        if (localObject2 != null)
        {
          ((AdData)localObject2).e = true;
          paramList.add(localObject2);
        }
      }
      label322:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rac
 * JD-Core Version:    0.7.0.1
 */