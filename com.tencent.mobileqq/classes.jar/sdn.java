import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusBookData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.3;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class sdn
{
  private static Map<String, sdo> jdField_a_of_type_JavaUtilMap = new HashMap();
  public static final float[] a;
  public static final int[] a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static final String[] b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "article_", "interactive_", "recommend_", "comment_" };
    b = new String[] { "_area_body", "_area_interactive", "_area_recommend", "_area_comment" };
    jdField_a_of_type_ArrayOfFloat = new float[] { 4.0F, 4.1F, 8.0F, 2.147484E+009F };
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (paramInt2 == 1) {
        return 1;
      }
      return 0;
    }
    if (paramInt1 == 70)
    {
      if (paramInt2 == 1) {
        return 2;
      }
      return 3;
    }
    return 0;
  }
  
  private static int a(long paramLong)
  {
    switch ((int)paramLong)
    {
    default: 
      return 8;
    case 0: 
      return 1;
    case 56: 
      return 2;
    }
    return 3;
  }
  
  public static long a(boolean paramBoolean, long paramLong)
  {
    long l;
    if (!paramBoolean)
    {
      l = paramLong;
      if (paramLong >= 0L) {}
    }
    else
    {
      l = -1024L;
    }
    return l;
  }
  
  public static String a(ArticleInfo paramArticleInfo, int paramInt)
  {
    return paramArticleInfo.innerUniqueID + b[paramInt];
  }
  
  public static JSONObject a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("card_info");
        localJSONObject.put("source", a(paramArticleInfo.mChannelID));
        localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
        localJSONObject.put("rowkey", paramJSONObject.optString("rowKey"));
        localJSONObject.put("rec_articleid", paramJSONObject.optString("articleID"));
        localJSONObject.put("rec_puin", paramJSONObject.optString("subscribeID"));
        localJSONObject.put("mp_article_id", "" + paramArticleInfo.mArticleID);
        localJSONObject.put("kandian_mode", "" + ors.e());
        if (NetworkState.isWifiConn())
        {
          i = 1;
          localJSONObject.put("network_type", i);
          localJSONObject.put("os", "1");
          localJSONObject.put("version", "8.3.3".replace(".", ""));
          localJSONObject.put("imei", ors.f());
          localJSONObject.put("imsi", ors.g());
          localJSONObject.put("rcmInfo", paramJSONObject.optString("rcmInfo"));
          localJSONObject.put("content_type", paramJSONObject.optString("type"));
          localJSONObject.put("net_type", ndd.a() + "");
          paramArticleInfo = paramJSONObject.optJSONObject("reportInfo").getJSONObject("info");
          if (paramArticleInfo != null)
          {
            paramJSONObject = paramArticleInfo.keys();
            if (paramJSONObject.hasNext())
            {
              String str = (String)paramJSONObject.next();
              localJSONObject.put(str, paramArticleInfo.getString(str));
              continue;
            }
          }
          return localJSONObject;
        }
      }
      catch (Exception paramArticleInfo) {}
      int i = 2;
    }
  }
  
  public static JSONObject a(TemplateBean paramTemplateBean, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramTemplateBean = new JSONObject(String.valueOf(paramTemplateBean.findViewById(paramString).getDynamicValue("setProteusReportInfo:"))).getJSONObject("info");
      return paramTemplateBean;
    }
    catch (Exception paramTemplateBean) {}
    return localJSONObject;
  }
  
  public static orz a(ArticleInfo paramArticleInfo)
  {
    orz localorz = new orz();
    localorz.b("folder_status", ors.d);
    localorz.b("feeds_source", paramArticleInfo.mSubscribeID);
    localorz.b("feeds_type", paramArticleInfo.mFeedType);
    localorz.b("kandian_mode", ors.e());
    localorz.b("tab_source", ors.d());
    localorz.b("rowkey", paramArticleInfo.innerUniqueID);
    localorz.a("channel_id", paramArticleInfo.mChannelID);
    return localorz;
  }
  
  public static orz a(ArticleInfo paramArticleInfo, boolean paramBoolean, long paramLong, int paramInt)
  {
    orz localorz = ors.a();
    localorz.b("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
    localorz.b("strategy_id", "" + paramArticleInfo.mStrategyId);
    if (paramBoolean) {}
    for (String str = "2";; str = "1")
    {
      localorz.b("feeds_channel_entrance", str);
      localorz.b("mp_article_id", "" + paramArticleInfo.mArticleID);
      localorz.b("rowkey", paramArticleInfo.innerUniqueID);
      localorz.b("channel_id", "" + a(paramBoolean, paramLong));
      if (paramInt != -1) {
        localorz.b("source_extratype", paramInt);
      }
      return localorz;
    }
  }
  
  private static sdo a(String paramString)
  {
    sdo localsdo2 = (sdo)jdField_a_of_type_JavaUtilMap.get(paramString);
    sdo localsdo1 = localsdo2;
    if (localsdo2 == null)
    {
      localsdo1 = new sdo(osk.a(paramString));
      jdField_a_of_type_JavaUtilMap.put(paramString, localsdo1);
    }
    return localsdo1;
  }
  
  public static void a(long paramLong, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, Context paramContext)
  {
    if ((paramArticleInfo == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReportUtil.3(paramContext, paramArticleInfo, paramFastWebArticleInfo, paramLong));
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramContext, paramAppInterface, paramArticleInfo, paramInt1, paramInt2, paramBoolean, false);
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramArticleInfo == null) || (paramAppInterface == null)) {
      return;
    }
    int i = a((int)paramArticleInfo.mChannelID, paramArticleInfo.mFeedType);
    paramContext = opn.a(paramContext, paramAppInterface.getCurrentAccountUin(), i, paramArticleInfo.mArticleID, paramArticleInfo.innerUniqueID, paramInt1, paramInt2, paramBoolean1, null);
    if (paramBoolean2) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        paramContext.put("is_redpack", paramInt1);
        nrt.a(null, "", "0X8009544", "0X8009544", 0, 0, "", String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mAlgorithmID), paramContext.toString(), false);
        return;
        paramInt1 = 0;
      }
    }
    catch (JSONException paramAppInterface)
    {
      for (;;)
      {
        QLog.e("ReportUtil", 1, paramAppInterface.toString());
      }
    }
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramArticleInfo == null) || (paramAppInterface == null)) {
      return;
    }
    int i = a((int)paramArticleInfo.mChannelID, paramArticleInfo.mFeedType);
    paramContext = opn.a(paramContext, paramAppInterface.getCurrentAccountUin(), i, paramArticleInfo.mArticleID, paramArticleInfo.innerUniqueID, paramInt1, paramInt2, paramBoolean1, Boolean.valueOf(paramBoolean2));
    if (paramBoolean3) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        paramContext.put("is_redpack", paramInt1);
        nrt.a(null, "", "0X800979D", "0X800979D", 0, 0, "", String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mAlgorithmID), paramContext.toString(), false);
        return;
        paramInt1 = 0;
      }
    }
    catch (JSONException paramAppInterface)
    {
      for (;;)
      {
        QLog.e("ReportUtil", 1, paramAppInterface.toString());
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, orz paramorz)
  {
    int j = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    int i = Utils.px2dp(paramInt1);
    j = Utils.px2dp(j);
    paramorz.b("read_area", "" + j * i);
    paramorz.b("article_page", "" + Utils.px2dp(paramInt2));
    paramorz.b("read_page", "" + Utils.px2dp(paramInt1));
    nrt.a(null, "CliOper", "", "", "0X8009782", "0X8009782", 0, 0, "" + paramArticleInfo.mArticleID, "", "", paramorz.a(), false);
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean, long paramLong, int paramInt3)
  {
    if (paramArticleInfo == null) {
      return;
    }
    orz localorz = a(paramArticleInfo, paramBoolean, paramLong, paramInt3);
    a(paramArticleInfo, paramInt2, localorz);
    a(paramArticleInfo, localorz);
    a(paramArticleInfo, paramInt1, paramInt2, localorz);
    b(paramArticleInfo, localorz);
    c(paramArticleInfo, a(paramArticleInfo, paramBoolean, paramLong, paramInt3));
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt, orz paramorz)
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("body_show_time");
    long l3 = osk.b(a(paramArticleInfo, 0));
    localAttributeList.att_value.set(String.valueOf(l3));
    localArrayList.add(localAttributeList);
    Object localObject1 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(2);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("body_height");
    paramInt = Utils.px2dp(paramInt);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(paramInt));
    localArrayList.add(localObject1);
    Object localObject2 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(3);
    ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("scroll_time");
    paramArticleInfo = a(paramArticleInfo.innerUniqueID);
    long l1;
    if (!paramArticleInfo.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      localObject3 = paramArticleInfo.jdField_b_of_type_JavaUtilList.iterator();
      for (l1 = 0L;; l1 = ((Long)((Pair)((Iterator)localObject3).next()).first).longValue() + l1)
      {
        l2 = l1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
      }
    }
    long l2 = 0L;
    ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(String.valueOf(l2));
    localArrayList.add(localObject2);
    Object localObject3 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(4);
    ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("scroll_list");
    StringBuilder localStringBuilder = new StringBuilder();
    if (!paramArticleInfo.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      paramArticleInfo = paramArticleInfo.jdField_b_of_type_JavaUtilList.iterator();
      while (paramArticleInfo.hasNext())
      {
        Pair localPair = (Pair)paramArticleInfo.next();
        l1 = Utils.px2dp((float)((Long)localPair.second).longValue());
        localStringBuilder.append(((Long)localPair.first).longValue() / 100L).append("_").append(l1).append(";");
      }
    }
    ((oidb_cmd0x80a.AttributeList)localObject3).att_value.set(localStringBuilder.toString());
    localArrayList.add(localObject3);
    if (QLog.isColorLevel())
    {
      if (localAttributeList.att_value.get() == null) {
        break label666;
      }
      paramArticleInfo = localAttributeList.att_value.get();
    }
    for (;;)
    {
      if (((oidb_cmd0x80a.AttributeList)localObject1).att_value.get() != null)
      {
        localObject1 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value.get();
        label461:
        if (((oidb_cmd0x80a.AttributeList)localObject2).att_value.get() == null) {
          break label681;
        }
        localObject2 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value.get();
        label482:
        if (((oidb_cmd0x80a.AttributeList)localObject3).att_value.get() == null) {
          break label689;
        }
        localObject3 = ((oidb_cmd0x80a.AttributeList)localObject3).att_value.get();
        QLog.d("Q.readinjoy.fast_web", 2, new Object[] { "reportRealTime, body_show_time = ", paramArticleInfo, " ms", ", body_height = ", localObject1, " dp", ", scroll_time = ", localObject2, " ms", ", scroll_list = ", localObject3 });
        syb.a(201, localArrayList);
      }
      try
      {
        paramorz.a("body_show_time", String.valueOf(l3));
        paramorz.a("body_height", String.valueOf(paramInt));
        paramorz.a("scroll_time", String.valueOf(l2));
        paramorz.a("scroll_list", localStringBuilder.toString());
        nrt.a(null, "", "0X800A467", "0X800A467", 0, 0, "", "", "", paramorz.a(), false);
        return;
        label666:
        paramArticleInfo = "null";
        continue;
        localObject1 = "null";
        break label461;
        label681:
        localObject2 = "null";
        break label482;
        label689:
        localObject3 = "null";
      }
      catch (JSONException paramArticleInfo)
      {
        for (;;)
        {
          QLog.e("Q.readinjoy.fast_web", 1, "reportRealTime, e = ", paramArticleInfo);
        }
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, long paramLong1, long paramLong2, orz paramorz)
  {
    if (paramArticleInfo == null) {
      return;
    }
    paramorz.b("read_duration", "" + paramLong1 / 1000L);
    paramorz.b("read_begin_timestamp", "" + paramLong2 / 1000L);
    paramorz.b("read_end_timestamp", "" + NetConnInfoCenter.getServerTime());
    nrt.a(null, "CliOper", "", "" + paramArticleInfo.mSubscribeID, "0X8009781", "0X8009781", 0, 0, "" + paramArticleInfo.mArticleID, "", "", paramorz.a(), false);
  }
  
  public static void a(ArticleInfo paramArticleInfo, BaseData paramBaseData)
  {
    switch (paramBaseData.s)
    {
    default: 
      return;
    }
    try
    {
      paramBaseData = (ProteusRecommendItemData)paramBaseData;
      JSONObject localJSONObject = a(paramArticleInfo, paramBaseData.c);
      String str = paramBaseData.c.optJSONObject("card_info").optJSONObject("reportInfo").getString("article_exposure_T");
      localJSONObject.put("rec_location", "" + paramBaseData.a);
      localJSONObject.put("rec_total", "" + paramBaseData.jdField_b_of_type_Int);
      localJSONObject.put("ad", "0");
      a(paramArticleInfo, str, localJSONObject.toString());
      return;
    }
    catch (Exception paramArticleInfo) {}
  }
  
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, Context paramContext)
  {
    if ((paramArticleInfo == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReportUtil.2(paramContext, paramArticleInfo, paramFastWebArticleInfo));
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    nrt.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, paramString1, paramString1, 0, 0, paramArticleInfo.mArticleID + "", paramArticleInfo.mAlgorithmID + "", paramArticleInfo.innerUniqueID, paramString2, false);
  }
  
  public static void a(ArticleInfo paramArticleInfo, List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    int j = 0;
    int i = 0;
    if (paramList.hasNext())
    {
      Object localObject = (BaseData)paramList.next();
      if ((localObject instanceof ProteusItemData))
      {
        localObject = (ProteusItemData)localObject;
        if (((ProteusItemData)localObject).w != 1) {}
      }
      int k;
      switch (((ProteusItemData)localObject).v)
      {
      default: 
        k = j;
        j = i;
        i = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = i + 1;
        i = j;
        j = k;
        continue;
        k = j + 1;
        j = i;
        i = k;
      }
    }
    paramList = new HashMap();
    paramList.put("rowkey", paramArticleInfo.innerUniqueID);
    paramList.put("url", paramArticleInfo.mArticleContentUrl);
    paramList.put("imgCount", "" + i);
    paramList.put("videoCount", "" + j);
    paramList.put("textCount", "-1");
    paramList.put("param_uin", ors.a());
    azmz.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebItemCount", true, 0L, 0L, paramList, null);
  }
  
  public static void a(ArticleInfo paramArticleInfo, orz paramorz)
  {
    if (paramArticleInfo != null)
    {
      a(paramArticleInfo, osk.b(paramArticleInfo.innerUniqueID), osk.a(paramArticleInfo.innerUniqueID), paramorz);
      osk.a(paramArticleInfo.innerUniqueID);
    }
  }
  
  public static void a(BaseData paramBaseData)
  {
    if (paramBaseData == null) {}
    do
    {
      return;
      if (paramBaseData.s == 18) {
        a(paramBaseData, "0X800974A");
      }
    } while (!(paramBaseData instanceof ProteusItemData));
    paramBaseData = (ProteusItemData)paramBaseData;
    a(paramBaseData.c);
    b(paramBaseData.c);
  }
  
  public static void a(BaseData paramBaseData, String paramString)
  {
    if ((paramBaseData == null) || (paramBaseData.a == null) || (paramBaseData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {}
    while (!(paramBaseData instanceof ProteusBookData)) {
      return;
    }
    ProteusBookData localProteusBookData = (ProteusBookData)paramBaseData;
    FastWebArticleInfo localFastWebArticleInfo = paramBaseData.a;
    paramBaseData = paramBaseData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    orz localorz = new orz();
    localorz.b("card_source", localProteusBookData.c);
    localorz.b("topic_id", localProteusBookData.d);
    localorz.b("source_id", localProteusBookData.e);
    nrt.a(null, "CliOper", "", "" + localFastWebArticleInfo.d, paramString, paramString, 0, 0, localFastWebArticleInfo.o + "", paramBaseData.mAlgorithmID + "", paramBaseData.innerUniqueID, localorz.a(), false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    if ((paramQQAppInterface != null) && (paramAdData != null))
    {
      noy.a(paramQQAppInterface, paramAdData);
      QLog.d("Q.readinjoy.fast_web", 2, " doReportAdShow " + paramAdData.j + "  : " + paramAdData.k);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, float paramFloat, long paramLong)
  {
    if ((paramQQAppInterface != null) && (paramAdData != null))
    {
      if ((!(paramAdData instanceof ProteusInnerData)) || (!((ProteusInnerData)paramAdData).d())) {
        break label103;
      }
      odp.a(paramQQAppInterface.getApp(), paramAdData, noy.jdField_b_of_type_Int, 0, -1, 2);
    }
    for (;;)
    {
      QLog.d("Q.readinjoy.fast_web", 2, " doReportAdShowExtra " + paramAdData.j + "  : " + paramAdData.k + " exposureArea = " + paramFloat + " exposureTime = " + paramLong);
      return;
      label103:
      noy.a(paramQQAppInterface, paramAdData, paramFloat, paramLong);
    }
  }
  
  public static void a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {}
    byte[] arrayOfByte;
    do
    {
      do
      {
        return;
      } while (paramColorNote.getServiceType() != 16908290);
      arrayOfByte = paramColorNote.getReserve();
    } while (arrayOfByte == null);
    long l = paramColorNote.mTime;
    ThreadManager.getSubThreadHandler().post(new ReportUtil.1(arrayOfByte, l));
  }
  
  public static void a(AbsListView paramAbsListView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    paramAbsListView = a(paramString);
    if (paramInt1 == 0)
    {
      paramAbsListView.b(paramInt2, paramBoolean);
      return;
    }
    paramAbsListView.a(paramInt2, paramBoolean);
  }
  
  private static void a(String paramString)
  {
    jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public static void a(String paramString, ProteusRecommendItemData paramProteusRecommendItemData, JSONObject paramJSONObject)
  {
    if ((paramProteusRecommendItemData == null) || (paramProteusRecommendItemData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = paramProteusRecommendItemData.c;
        String str = localJSONObject.optJSONObject("card_info").optJSONObject("reportInfo").getString("click_T");
        if (!TextUtils.isEmpty(str))
        {
          localJSONObject = a(paramProteusRecommendItemData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localJSONObject);
          b(localJSONObject, paramJSONObject);
          localJSONObject.put("rec_location", "" + paramProteusRecommendItemData.a);
          localJSONObject.put("rec_total", "" + paramProteusRecommendItemData.jdField_b_of_type_Int);
          localJSONObject.put("ad", "0");
          localJSONObject.put("click_area", paramString);
          a(paramProteusRecommendItemData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, str, localJSONObject.toString());
          return;
        }
      }
      catch (Exception paramString) {}
    }
  }
  
  public static void a(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    int i = 0;
    if (paramJSONObject1 == null) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject1 = paramJSONObject1.optJSONObject("card_info");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("reportInfo");
        String str = localJSONObject2.getString("click_T");
        localJSONObject2 = new JSONObject(localJSONObject2.getString("info"));
        a(localJSONObject1, localJSONObject2);
        localJSONObject2.put("click_area", paramString);
        b(localJSONObject2, paramJSONObject2);
        if (ors.o()) {
          i = 1;
        }
        localJSONObject2.put("ad_relative_pos", i);
        paramString = new orz(localJSONObject2);
        paramString.e();
        nrt.a(null, "", str, str, 0, 0, "", "", "", paramString.a(), false);
        boolean bool = "0X800983F".equals(str);
        if (!bool) {
          continue;
        }
        try
        {
          if (!paramJSONObject1.has("kdschSessionId")) {
            paramJSONObject1.put("kdschSessionId", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin() + System.currentTimeMillis());
          }
          aynt.a(null, new ReportModelDC02528().module("all_search").action("clk_jingtan_list").obj1("2049").ver2("kandian").ver4(paramJSONObject2.getString("searchWord")).ver6(localJSONObject1.getString("articleRowKey")).ver7("{\"scroe\":\"" + paramJSONObject2.getString("score") + "\",\"title\":\"" + localJSONObject1.getString("articleTitle") + "\",\"position\":\"" + paramJSONObject2.getString("position") + "\"}").session_id(paramJSONObject1.getString("kdschSessionId")));
          return;
        }
        catch (Exception paramString) {}
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public static void a(List<ColorNote> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ColorNote localColorNote = (ColorNote)paramList.next();
        if (localColorNote.getServiceType() == 16908290) {
          a(localColorNote);
        }
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject("card_info");
        Object localObject1 = localJSONObject.optJSONObject("reportInfo");
        String str = ((JSONObject)localObject1).getString("exposure_T");
        localObject1 = new JSONObject(((JSONObject)localObject1).getString("info"));
        if (TextUtils.isEmpty(str)) {
          break;
        }
        a(localJSONObject, (JSONObject)localObject1);
        if (!ors.o()) {
          break label390;
        }
        i = 1;
        ((JSONObject)localObject1).put("ad_relative_pos", i);
        Object localObject2 = new orz((JSONObject)localObject1);
        ((orz)localObject2).e();
        nrt.a(null, "", str, str, 0, 0, "", "", "", ((orz)localObject2).a(), false);
        boolean bool = "0X8009857".equals(str);
        if (!bool) {
          break;
        }
        try
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("searchWords");
          i = 0;
          str = "";
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            if (TextUtils.isEmpty(str)) {
              str = str + ((JSONObject)localObject2).getString("searchWord");
            } else {
              str = str + "::" + ((JSONObject)localObject2).getString("searchWord");
            }
          }
          else
          {
            if (!paramJSONObject.has("kdschSessionId")) {
              paramJSONObject.put("kdschSessionId", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin() + System.currentTimeMillis());
            }
            aynt.a(null, new ReportModelDC02528().module("all_search").action("exp_jingtan_list").obj1("2049").ver2("kandian").ver4(str).ver6(localJSONObject.getString("articleRowKey")).ver7("{\"title\":\"" + localJSONObject.getString("articleTitle") + "\"}").session_id(paramJSONObject.getString("kdschSessionId")));
            return;
          }
        }
        catch (Exception paramJSONObject)
        {
          return;
        }
        i += 1;
      }
      catch (Exception paramJSONObject)
      {
        return;
      }
      continue;
      label390:
      int i = 0;
    }
  }
  
  public static void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    try
    {
      paramJSONObject2.put("articleRowKey", paramJSONObject1.optString("articleRowKey"));
      paramJSONObject2.put("channel_id", paramJSONObject1.get("channelID"));
      paramJSONObject2.put("articleTitle", paramJSONObject1.get("articleTitle"));
      return;
    }
    catch (Exception paramJSONObject1) {}
  }
  
  public static boolean a(BaseData paramBaseData)
  {
    switch (paramBaseData.s)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static void b(Context paramContext, AppInterface paramAppInterface, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramAppInterface, paramArticleInfo, paramInt1, paramInt2, paramBoolean1, paramBoolean2, false);
  }
  
  public static void b(ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if (paramArticleInfo == null) {
      return;
    }
    str = "";
    for (;;)
    {
      try
      {
        orz localorz = a(paramArticleInfo);
        localorz.b("source_from", paramString2);
        if (!ors.n()) {
          continue;
        }
        i = 1;
        localorz.b("artical_interact_area", i);
        localorz.b("artical_interact_type", ors.h());
        paramString2 = localorz.a();
      }
      catch (Exception paramString2)
      {
        int i;
        paramString2.printStackTrace();
        paramString2 = str;
        continue;
      }
      nrt.a(null, paramArticleInfo.mSubscribeID, paramString1, paramString1, 0, 0, String.valueOf(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "", paramString2, false);
      return;
      i = 0;
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, orz paramorz)
  {
    sdo localsdo = a(paramArticleInfo.innerUniqueID);
    if (localsdo.a.isEmpty()) {
      return;
    }
    paramorz.i();
    paramorz.b("read_begin_timestamp", "" + localsdo.jdField_b_of_type_Long / 1000L);
    paramorz.b("read_end_timestamp", "" + localsdo.c / 1000L);
    String str1 = "";
    Iterator localIterator = localsdo.a.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      String str2 = str1;
      if (!TextUtils.isEmpty(str1)) {
        str2 = str1 + ",";
      }
      l += Math.abs(((Long)localPair.first).longValue());
      str1 = str2 + localPair.first + "_" + localPair.second;
    }
    paramorz.b("read_speed_array", str1);
    paramorz.b("avg_speed", "" + l / localsdo.a.size());
    nrt.a(null, "CliOper", "", "", "0X8009783", "0X8009783", 0, 0, "" + paramArticleInfo.mArticleID, "", "", paramorz.a(), false);
    a(paramArticleInfo.innerUniqueID);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    if ((paramQQAppInterface != null) && (paramAdData != null))
    {
      noy.b(paramQQAppInterface, paramAdData);
      QLog.d("Q.readinjoy.fast_web", 2, " doReportAdInvalidShow " + paramAdData.j + "  : " + paramAdData.k);
    }
  }
  
  public static void b(ColorNote paramColorNote) {}
  
  public static void b(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("card_info");
      JSONObject localJSONObject = new JSONObject(paramJSONObject.optJSONObject("reportInfo").getString("info"));
      a(paramJSONObject, localJSONObject);
      if (ors.o()) {
        i = 1;
      }
      localJSONObject.put("ad_relative_pos", i);
      paramJSONObject = new orz(localJSONObject);
      paramJSONObject.e();
      nrt.a(null, "", "0X8009A7D", "0X8009A7D", 0, 0, "", "", "", paramJSONObject.a(), false);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public static void b(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null)) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = paramJSONObject2.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramJSONObject1.put(str, paramJSONObject2.getString(str));
        }
        return;
      }
      catch (Exception paramJSONObject1) {}
    }
  }
  
  private static void c(ArticleInfo paramArticleInfo, orz paramorz)
  {
    paramorz.b().e();
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      Integer localInteger = Integer.valueOf(arrayOfInt[i]);
      String str = a(paramArticleInfo, localInteger.intValue());
      long l = osk.b(str);
      paramorz.a(jdField_a_of_type_ArrayOfJavaLangString[localInteger.intValue()] + "_duration_millis", l);
      osk.a(str);
      i += 1;
    }
    nrt.a(null, "CliOper", "", "" + paramArticleInfo.mSubscribeID, "0X80099D2", "0X80099D2", 0, 0, "", "" + paramArticleInfo.mArticleID, "", paramorz.a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sdn
 * JD-Core Version:    0.7.0.1
 */