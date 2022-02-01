package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.content.Context;
import android.graphics.Paint.FontMetricsInt;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.base.utils.KandianUGStatisticUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.detail.web.RecommendAndAdCallback;
import com.tencent.mobileqq.kandian.biz.fastweb.ResponseCallback;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter;
import com.tencent.mobileqq.kandian.biz.fastweb.data.ProteusInteractiveItemData;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.repo.fastweb.FeedbackCallback;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ProteusRecommendItemData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FastWebRequestUtil
{
  private static Map<String, String> a;
  
  public static int a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localObject = (JSONObject)localJSONObject.opt("author_hot_article_datas");
      if (localObject != null) {
        ((JSONObject)localObject).optBoolean("should_have_ad");
      }
      int i = localJSONObject.optInt("recommend_type");
      return i;
    }
    catch (JSONException localJSONException)
    {
      String str = localJSONException.toString();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" item:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("FastWebRequestUtil", 1, new Object[] { "parseProteusDataShouldHaveAd error:", str, ((StringBuilder)localObject).toString() });
    }
    return 0;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString);
      localHashMap.put("article_url", localStringBuilder.toString());
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(localException.toString());
      localHashMap.put("error", paramString.toString());
      localHashMap.put("param_uin", RIJQQAppInterfaceUtil.a());
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebCost", false, 0L, 0L, localHashMap, null);
    }
    return -1L;
  }
  
  public static BaseData a()
  {
    ProteusRecommendItemData localProteusRecommendItemData = new ProteusRecommendItemData();
    localProteusRecommendItemData.w = 2;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("style_ID", "ReadInjoy_native_author_article_bottom");
        Object localObject1 = TemplateFactory.a("native_article", true);
        if (localObject1 == null) {
          break label91;
        }
        localObject1 = ((TemplateFactory)localObject1).getTemplateBean(localJSONObject);
        if (localObject1 != null)
        {
          localProteusRecommendItemData.a = ((TemplateBean)localObject1);
          localProteusRecommendItemData.c = localJSONObject;
          return localProteusRecommendItemData;
        }
      }
      catch (Exception localException)
      {
        QLog.e("FastWebRequestUtil", 1, new Object[] { "parserProteusRecommendBottom error:", localException.toString() });
      }
      return localProteusRecommendItemData;
      label91:
      Object localObject2 = null;
    }
  }
  
  public static BaseData a(AuthorData paramAuthorData)
  {
    ProteusRecommendItemData localProteusRecommendItemData = new ProteusRecommendItemData();
    localProteusRecommendItemData.w = 1;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        a(paramAuthorData, localJSONObject);
        paramAuthorData = TemplateFactory.a("native_article", true);
        if (paramAuthorData == null) {
          break label87;
        }
        paramAuthorData = paramAuthorData.getTemplateBean(localJSONObject);
        if (paramAuthorData != null)
        {
          localProteusRecommendItemData.a = paramAuthorData;
          localProteusRecommendItemData.c = localJSONObject;
          return localProteusRecommendItemData;
        }
      }
      catch (Exception paramAuthorData)
      {
        QLog.e("FastWebRequestUtil", 1, new Object[] { "parserProteusRecommendHeader error:", paramAuthorData.toString() });
      }
      return localProteusRecommendItemData;
      label87:
      paramAuthorData = null;
    }
  }
  
  private static ProteusItemData a(int paramInt)
  {
    if (paramInt != 6)
    {
      if (paramInt != 23) {
        return null;
      }
      return new ProteusInteractiveItemData();
    }
    return new ProteusRecommendItemData();
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = paramString;
    if (!paramString.startsWith("http:"))
    {
      localObject = paramString;
      if (!paramString.startsWith("https"))
      {
        if (paramString.startsWith("mqqapi:")) {
          return paramString;
        }
        if (paramBoolean)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("https:");
          ((StringBuilder)localObject).append(paramString);
          return ((StringBuilder)localObject).toString();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("http:");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  private static String a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("card_info");
    if (paramJSONObject == null) {
      return "null";
    }
    return paramJSONObject.optString("rowKey", "null");
  }
  
  @RequiresApi(api=19)
  public static List<BaseData> a(String paramString, int paramInt, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = localArrayList;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      localObject = localArrayList;
      if (paramList.hasNext()) {
        localObject = b(paramString, paramInt, (String)paramList.next(), 0);
      }
    }
    return localObject;
  }
  
  public static Map<String, String> a(Context paramContext)
  {
    if (a != null)
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("getDisplayParams : ");
        paramContext.append(a);
        QLog.d("FastWebRequestUtil", 2, paramContext.toString());
      }
      return a;
    }
    HashMap localHashMap = new HashMap();
    Object localObject1 = TemplateFactory.a("native_article", true);
    if (localObject1 == null) {
      return localHashMap;
    }
    localObject1 = ((TemplateFactory)localObject1).getTemplate("ReadInjoy_article_text_cell");
    if (localObject1 == null) {
      return localHashMap;
    }
    Object localObject2 = ((TemplateBean)localObject1).getViewBean().findViewById("id_article_paragraph");
    if (localObject2 != null)
    {
      localObject1 = (String)((ViewBean)localObject2).valueBean.normalValue.get("margin_left");
      String str1 = (String)((ViewBean)localObject2).valueBean.normalValue.get("margin_top");
      String str2 = (String)((ViewBean)localObject2).valueBean.normalValue.get("setLineSpace:");
      localObject2 = (String)((ViewBean)localObject2).valueBean.normalValue.get("setFontSizeString:");
      try
      {
        int i = (int)FastWebPTSUtils.a();
        int i1 = Utils.dp2px(Integer.valueOf(str2).intValue());
        int j = Utils.dp2px(Integer.valueOf((String)localObject1).intValue());
        int k = Utils.dp2px(Integer.valueOf(str1).intValue());
        int m = ScreenUtil.getInstantScreenHeight(paramContext);
        int n = ScreenUtil.getInstantScreenWidth(paramContext);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          i = Utils.dp2px(Integer.valueOf((String)localObject2).intValue());
        }
        paramContext = new TextPaint();
        paramContext.setTextSize(Utils.dp2px(i));
        i = paramContext.getFontMetricsInt(new Paint.FontMetricsInt());
        double d = i1 * 2;
        Double.isNaN(d);
        i1 = (int)(d / 3.0D);
        int i2 = (int)paramContext.measureText("我");
        localHashMap.put("screenWidth", String.valueOf(n));
        localHashMap.put("screenHeight", String.valueOf(m));
        localHashMap.put("lineHeight", String.valueOf(i + i1));
        localHashMap.put("contentPadding", String.valueOf(j));
        localHashMap.put("paragraphSpace", String.valueOf(k));
        localHashMap.put("fontSize", String.valueOf(i2));
        a = localHashMap;
      }
      catch (Exception paramContext)
      {
        QLog.e("FastWebRequestUtil", 2, paramContext, new Object[0]);
        localHashMap.clear();
      }
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getDisplayParams : ");
      paramContext.append(localHashMap.toString());
      QLog.d("FastWebRequestUtil", 2, paramContext.toString());
    }
    return localHashMap;
  }
  
  @RequiresApi(api=19)
  public static void a(int paramInt1, int paramInt2, JSONObject paramJSONObject)
  {
    if (paramInt1 == 0) {}
    try
    {
      paramJSONObject.put("corner_radius_array", new JSONArray(new String[] { "6", "6", "0", "0" }));
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      break label161;
    }
    if ((paramInt1 == paramInt2 - 1) && (paramInt2 >= ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).getHotArticleRecommendGap()))
    {
      paramJSONObject.put("corner_radius_array", new JSONArray(new String[] { "0", "0", "6", "6" }));
      return;
    }
    paramJSONObject.put("corner_radius_array", new JSONArray(new String[] { "0", "0", "0", "0" }));
    return;
    label161:
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("configHotRecommendFeedsCorner msg=");
    paramJSONObject.append(localObject);
    QLog.d("FastWebRequestUtil", 1, paramJSONObject.toString());
  }
  
  public static void a(AuthorData paramAuthorData, List<BaseData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (BaseData)paramList.next();
      if ((localObject instanceof ProteusItemData))
      {
        localObject = (ProteusItemData)localObject;
        if (((ProteusItemData)localObject).w == 1) {
          try
          {
            a(paramAuthorData, ((ProteusItemData)localObject).c);
          }
          catch (JSONException localJSONException)
          {
            QLog.e("FastWebRequestUtil", 1, new Object[] { "refreshProteusRecommendHeader error:", localJSONException.toString() });
          }
        }
      }
    }
  }
  
  private static void a(AuthorData paramAuthorData, JSONObject paramJSONObject)
  {
    paramJSONObject.put("style_ID", "ReadInjoy_native_author_article_header");
    paramJSONObject.put("info_avator_uin", paramAuthorData.c);
    paramJSONObject.put("nickname_text", paramAuthorData.b);
    paramJSONObject.put("timestamp_text", paramAuthorData.d);
    paramJSONObject.put("author_data", paramAuthorData);
    FastWebPTSDataConverter.b(paramAuthorData.a, paramJSONObject);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FeedbackCallback paramFeedbackCallback)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    QLog.d("FastWebRequestUtil", 2, "deleteFeeds.");
    ThreadManager.excute(new FastWebRequestUtil.5(paramAbsBaseArticleInfo, paramFeedbackCallback), 128, null, true);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, ProteusItemData paramProteusItemData, int paramInt, SparseArray<Float> paramSparseArray)
  {
    float f;
    if ((paramAbsBaseArticleInfo != null) && (paramProteusItemData != null))
    {
      if (paramProteusItemData.c == null) {
        return;
      }
      try
      {
        localJSONObject = paramProteusItemData.c.optJSONObject("card_info");
        if (localJSONObject == null) {
          break label185;
        }
        localJSONObject.put("strategyId", paramAbsBaseArticleInfo.mStrategyId);
        localJSONObject.put("algorithmID", paramAbsBaseArticleInfo.mAlgorithmID);
        localJSONObject.put("articleTitle", paramAbsBaseArticleInfo.mTitle);
        localJSONObject.put("articleRowKey", paramAbsBaseArticleInfo.innerUniqueID);
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        JSONObject localJSONObject;
        paramProteusItemData = new StringBuilder();
        paramProteusItemData.append("addExtraInfo error! msg=");
        paramProteusItemData.append(paramAbsBaseArticleInfo);
        QLog.d("FastWebRequestUtil", 1, paramProteusItemData.toString());
      }
      f = FastWebPTSDataConverter.c(paramSparseArray);
      break label120;
      label96:
      if (localJSONObject != null) {
        localJSONObject.put("channelID", paramAbsBaseArticleInfo.mChannelID);
      }
      f = FastWebPTSDataConverter.b(paramSparseArray);
    }
    for (;;)
    {
      label120:
      paramProteusItemData.b = f;
      paramProteusItemData.A = paramInt;
      paramProteusItemData.c.put("dt_rowkey", paramAbsBaseArticleInfo.innerUniqueID);
      a(paramProteusItemData);
      return;
      return;
      label185:
      f = -1000.0F;
      if (paramInt == 3) {
        break label96;
      }
      if (paramInt == 5) {
        break;
      }
    }
  }
  
  private static void a(ProteusItemData paramProteusItemData)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramProteusItemData.c.keys();
    String str;
    Object localObject;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localObject = paramProteusItemData.c.optJSONObject(str);
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dt_");
        localStringBuilder.append(str);
        localHashMap.put(localStringBuilder.toString(), ((JSONObject)localObject).optString("text"));
      }
    }
    localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localObject = (String)localHashMap.get(str);
      paramProteusItemData.c.put(str, localObject);
    }
  }
  
  public static void a(String paramString, FastWebArticleInfo paramFastWebArticleInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramString);
    QLog.d("Q.readinjoy.fast_web", 2, localStringBuilder.toString());
    localStringBuilder = null;
    try
    {
      long l = a(paramString);
      if (l == -1L) {
        return;
      }
      paramString = new Bundle();
      paramString.putString("articleId", String.valueOf(l));
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append("https://c.mp.qq.com/review/img-txt-comment/list?source=1");
      ((StringBuilder)localObject).append("  articleId ");
      ((StringBuilder)localObject).append(l);
      QLog.d("Q.readinjoy.fast_web", 2, ((StringBuilder)localObject).toString());
      localObject = new Bundle();
      HttpUtil.addCookie((Bundle)localObject);
      paramString = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), "https://c.mp.qq.com/review/img-txt-comment/list?source=1", "POST", paramString, (Bundle)localObject);
      if (paramString != null) {
        try
        {
          paramString = new String(paramString);
        }
        catch (Throwable paramFastWebArticleInfo)
        {
          paramString = "";
          break label297;
        }
      } else {
        paramString = "";
      }
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://c.mp.qq.com/review/img-txt-comment/list?source=1");
        localStringBuilder.append("  articleId ");
        localStringBuilder.append(l);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramString);
        QLog.d("Q.readinjoy.fast_web", 2, localStringBuilder.toString());
        l = new JSONObject(paramString).getInt("readCount");
        if (l <= paramFastWebArticleInfo.a) {
          return;
        }
        paramFastWebArticleInfo.a = l;
        ThreadManager.getUIHandler().post(new FastWebRequestUtil.4());
        return;
      }
      catch (Throwable paramFastWebArticleInfo) {}
      localStringBuilder = new StringBuilder();
    }
    catch (Throwable paramFastWebArticleInfo)
    {
      paramString = localStringBuilder;
    }
    label297:
    localStringBuilder.append("");
    localStringBuilder.append(paramString);
    QLog.e("Q.readinjoy.fast_web", 2, paramFastWebArticleInfo, new Object[] { localStringBuilder.toString() });
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, ResponseCallback paramResponseCallback, int paramInt, AuthorData paramAuthorData)
  {
    ThreadManager.executeOnNetWorkThread(new FastWebRequestUtil.3(paramString1, paramString2, paramInt, paramAuthorData, paramResponseCallback));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7, RecommendAndAdCallback paramRecommendAndAdCallback, int paramInt1, int paramInt2, long paramLong, AuthorData paramAuthorData)
  {
    paramRecommendAndAdCallback = new FastWebRequestUtil.RecommendAndAd(paramString1, paramRecommendAndAdCallback);
    a(paramString1, paramString2, paramString3, new FastWebRequestUtil.1(paramRecommendAndAdCallback), paramInt2, paramAuthorData);
    ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).getAdData(paramString1, paramString2, paramString3, paramString4, paramBoolean, paramString5, paramString6, paramString7, paramInt1, paramLong, new FastWebRequestUtil.2(paramRecommendAndAdCallback), paramInt2);
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    Object localObject1 = paramJSONObject.optString("kd_ug_rsp_info");
    if ((localObject1 != null) && (paramJSONObject.opt("id_recommend_category_txt") != null) && (paramJSONObject.opt("kd_ug_download_url") != null))
    {
      localObject1 = new FastWebRecommendUGInfo((String)localObject1, WebFastAdapter.a(paramJSONObject));
      a(paramJSONObject, (FastWebRecommendUGInfo)localObject1);
      Object localObject2 = ((FastWebRecommendUGInfo)localObject1).b;
      paramJSONObject = paramJSONObject.getJSONObject("id_recommend_category_txt");
      paramJSONObject.put("text_color", "#FF4A2D");
      paramJSONObject.put("label_ug_progress_bgcolor", "#FFE9E9");
      paramJSONObject.put("label_ug_progress_fgcolor", "#FFCECE");
      if (!PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0"))
      {
        if ((((FastWebRecommendUGInfo)localObject1).b()) && (!TextUtils.isEmpty(((FastWebRecommendUGInfo)localObject1).c)))
        {
          paramJSONObject.put("text", ((FastWebRecommendUGInfo)localObject1).e);
          paramJSONObject.put("label_ug_progress_progress", 100);
          return;
        }
        paramJSONObject.put("text", "");
        return;
      }
      if ((((FastWebRecommendUGInfo)localObject1).a()) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        localObject2 = DownloadManagerV2.a().b((String)localObject2);
        if (localObject2 == null)
        {
          paramJSONObject.put("text", ((FastWebRecommendUGInfo)localObject1).f);
          paramJSONObject.put("label_ug_progress_progress", 0);
          return;
        }
        if (((DownloadInfo)localObject2).a() == 4)
        {
          paramJSONObject.put("text", ((FastWebRecommendUGInfo)localObject1).g);
          paramJSONObject.put("label_ug_progress_progress", 100);
          return;
        }
        if ((((DownloadInfo)localObject2).a() != 20) && (((DownloadInfo)localObject2).a() != 1) && (((DownloadInfo)localObject2).a() != 2))
        {
          paramJSONObject.put("text", ((FastWebRecommendUGInfo)localObject1).j);
          paramJSONObject.put("label_ug_progress_progress", ((DownloadInfo)localObject2).f);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((FastWebRecommendUGInfo)localObject1).h);
        localStringBuilder.append(((DownloadInfo)localObject2).f);
        localStringBuilder.append("%");
        paramJSONObject.put("text", localStringBuilder.toString());
        paramJSONObject.put("label_ug_progress_progress", ((DownloadInfo)localObject2).f);
        return;
      }
      paramJSONObject.put("text", "");
    }
  }
  
  private static void a(JSONObject paramJSONObject, FastWebRecommendUGInfo paramFastWebRecommendUGInfo)
  {
    Object localObject = paramJSONObject.opt("card_info");
    String str2 = "";
    String str1 = str2;
    if (localObject != null) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("card_info");
        str1 = str2;
        if (paramJSONObject.opt("rowKey") != null) {
          str1 = paramJSONObject.getString("rowKey");
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        str1 = str2;
      }
    }
    KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(paramFastWebRecommendUGInfo.a, str1, "1"));
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = (JSONObject)new JSONObject(paramString).opt("author_hot_article_datas");
      if (localJSONObject != null)
      {
        boolean bool = localJSONObject.optBoolean("should_have_ad");
        return bool;
      }
    }
    catch (JSONException localJSONException)
    {
      String str = localJSONException.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" item:");
      localStringBuilder.append(paramString);
      QLog.e("FastWebRequestUtil", 1, new Object[] { "parseProteusDataShouldHaveAd error:", str, localStringBuilder.toString() });
    }
    return true;
  }
  
  @RequiresApi(api=19)
  private static List<BaseData> b(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    label323:
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString2).getJSONArray("data");
        int i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
          if (paramInt1 == 6)
          {
            localJSONObject.put("dt_parent_rowkey", paramString1);
            localJSONObject.put("dt_rowkey", a(localJSONObject));
            localJSONObject.put("recommend_type", paramInt2);
            a(i, localJSONArray.length(), localJSONObject);
            b(i, localJSONArray.length(), localJSONObject);
            if (paramInt2 == 0) {
              a(localJSONObject);
            }
          }
          localObject = TemplateFactory.a("native_article", true);
          if (localObject == null) {
            break label323;
          }
          localObject = ((TemplateFactory)localObject).getTemplateBean(localJSONObject);
          if (localObject != null)
          {
            ProteusItemData localProteusItemData = a(paramInt1);
            if (localProteusItemData != null)
            {
              localProteusItemData.a = ((TemplateBean)localObject);
              localProteusItemData.c = localJSONObject;
              localArrayList.add(localProteusItemData);
            }
          }
          i += 1;
        }
        Object localObject = null;
      }
      catch (Exception paramString1)
      {
        paramString1 = paramString1.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" item:");
        ((StringBuilder)localObject).append(paramString2);
        QLog.e("FastWebRequestUtil", 1, new Object[] { "parseProteusData error:", paramString1, ((StringBuilder)localObject).toString() });
        paramString1 = new StringBuilder();
        paramString1.append("parseProteusItem,type=");
        paramString1.append(paramInt1);
        paramString1.append(" item=");
        paramString1.append(paramString2);
        paramString1.append(" datasSize=");
        paramString1.append(localArrayList.size());
        QLog.d("FastWebRequestUtil", 1, paramString1.toString());
        return localArrayList;
      }
    }
  }
  
  private static void b(int paramInt1, int paramInt2, JSONObject paramJSONObject)
  {
    if (paramInt1 == 0) {}
    try
    {
      paramJSONObject.put("label_separator_line_top_bg_color", paramJSONObject.optString("label_separator_line_top_bg_color", "#E5E5E5"));
      return;
    }
    catch (Exception localException)
    {
      label49:
      Object localObject;
      break label49;
    }
    if (paramInt1 == paramInt2 - 1)
    {
      paramJSONObject.put("label_separator_line_bottom_bg_color", paramJSONObject.optString("label_separator_line_bottom_bg_color", "#E5E5E5"));
      return;
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("parseProteusItem msg=");
      paramJSONObject.append(localObject);
      QLog.d("FastWebRequestUtil", 1, paramJSONObject.toString());
    }
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, FeedbackCallback paramFeedbackCallback)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    QLog.d("FastWebRequestUtil", 2, "shieldFeedSource");
    ThreadManager.excute(new FastWebRequestUtil.6(paramAbsBaseArticleInfo, paramFeedbackCallback), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil
 * JD-Core Version:    0.7.0.1
 */