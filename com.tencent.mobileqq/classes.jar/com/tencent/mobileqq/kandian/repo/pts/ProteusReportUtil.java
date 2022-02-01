package com.tencent.mobileqq.kandian.repo.pts;

import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class ProteusReportUtil
{
  private static Set<String> a = ;
  
  public static int a(TemplateBean paramTemplateBean)
  {
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {
      try
      {
        Object localObject = paramTemplateBean.getDataAttribute(null, "feeds_type");
        if (localObject != null) {
          localObject = localObject.toString();
        } else {
          localObject = (String)paramTemplateBean.getViewBean().getDynamicValue("report_feeds_type");
        }
        if (localObject == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getReportType: ");
          ((StringBuilder)localObject).append(paramTemplateBean);
          QLog.d("ProteusReportUtil", 1, ((StringBuilder)localObject).toString());
          return -1024;
        }
        int i = Integer.valueOf((String)localObject).intValue();
        return i;
      }
      catch (Exception paramTemplateBean)
      {
        QLog.d("ProteusReportUtil", 1, paramTemplateBean, new Object[] { "getReportType" });
      }
    }
    return -1024;
  }
  
  public static List<String> a(TemplateBean paramTemplateBean)
  {
    if (paramTemplateBean == null) {
      return null;
    }
    Object localObject = paramTemplateBean.getDataAttribute(null).get("extra_expose");
    if (localObject != null)
    {
      paramTemplateBean = new ArrayList();
      try
      {
        localObject = (JSONArray)localObject;
        if (((JSONArray)localObject).length() > 0)
        {
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            paramTemplateBean.add(((JSONArray)localObject).getJSONObject(i).getString("view_id"));
            i += 1;
          }
          return paramTemplateBean;
        }
      }
      catch (Exception paramTemplateBean)
      {
        QLog.d("ProteusReportUtil", 1, "getReportMultViewId", paramTemplateBean);
      }
    }
    return null;
  }
  
  private static Set<String> a()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("ReadInjoy_double_video_cell");
    localHashSet.add("ReadInjoy_zhitiao_view");
    return localHashSet;
  }
  
  public static void a(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(1);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("action");
    Object localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ((PBStringField)localObject2).set(localStringBuilder.toString());
    localArrayList.add(localObject1);
    localObject1 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(2);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("bid");
    localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("");
    ((PBStringField)localObject2).set(localStringBuilder.toString());
    localArrayList.add(localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(HtmlOffline.a(paramString));
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (paramInt != 1)
    {
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(3);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("version");
      ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1);
      localArrayList.add(localObject2);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append((String)localObject1);
    paramString = ((StringBuilder)localObject2).toString();
    if (3 == paramInt)
    {
      if (((Boolean)RIJSPUtils.a(paramString, Boolean.valueOf(false))).booleanValue()) {
        return;
      }
      RIJSPUtils.a(paramString, Boolean.valueOf(true));
    }
    ReadinjoyReportUtils.a(200, localArrayList);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mProteusTemplateBean != null) && (paramAbsBaseArticleInfo.mProteusTemplateBean.getData() != null))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mProteusTemplateBean;
      if (paramAbsBaseArticleInfo == null) {
        return;
      }
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.getDataAttribute(null).get("ug_expose_report_url");
      if ((paramAbsBaseArticleInfo instanceof JSONArray)) {
        a((JSONArray)paramAbsBaseArticleInfo);
      }
      return;
    }
    QLog.d("ProteusReportUtil", 1, "ExposeReport UG is null");
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2, int paramInt, Map<String, Object> paramMap)
  {
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      String str = RIJFeedsType.c(paramAbsBaseArticleInfo);
      try
      {
        int i = RIJFeedsType.a(paramAbsBaseArticleInfo);
        JSONObject localJSONObject = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, i, paramInt, NetworkUtil.isWifiConnected(null), str, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), 0, RIJTransMergeKanDianReport.a(), paramAbsBaseArticleInfo);
        if ((paramMap != null) && (paramMap.entrySet() != null))
        {
          paramMap = paramMap.entrySet().iterator();
          while ((paramMap != null) && (paramMap.hasNext()))
          {
            Map.Entry localEntry = (Map.Entry)paramMap.next();
            localJSONObject.put((String)localEntry.getKey(), localEntry.getValue().toString());
          }
        }
        paramMap = localJSONObject.toString();
      }
      catch (Exception paramMap)
      {
        AIOUtils.a("ProteusReportUtil", "reportClickEvent", new IllegalArgumentException(paramMap));
        paramMap = null;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, str, paramString1, paramString2, 0, 0, RIJStringUtils.a(paramAbsBaseArticleInfo.mFeedId), String.valueOf(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), paramMap, false);
      ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).doArticleClickEvent64Report(paramAbsBaseArticleInfo, paramInt);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (a.contains(paramString3)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("bid", paramString1);
    localHashMap.put("business_name", paramString2);
    localHashMap.put("style_id", paramString3);
    localHashMap.put("uin", RIJQQAppInterfaceUtil.a());
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianProteusShowFail", false, 0L, 0L, localHashMap, null);
  }
  
  public static void a(Map<String, Object> paramMap)
  {
    if (paramMap == null)
    {
      QLog.d("ProteusReportUtil", 1, "handleUgClickReport UG is null");
      return;
    }
    if (a()) {
      paramMap = paramMap.get("ug_click_schema_url");
    } else {
      paramMap = paramMap.get("ug_click_default_url");
    }
    if ((paramMap instanceof JSONArray)) {
      a((JSONArray)paramMap);
    }
  }
  
  private static void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
    {
      QLog.d("ProteusReportUtil", 1, "handleHttpRequest jsarray is null");
      return;
    }
    ThreadManager.executeOnNetWorkThread(new ProteusReportUtil.1(paramJSONArray));
  }
  
  public static void a(JSONObject paramJSONObject, Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (paramMap.entrySet() != null))
    {
      paramMap = paramMap.entrySet().iterator();
      for (;;)
      {
        if (paramMap != null) {
          try
          {
            if (paramMap.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)paramMap.next();
              paramJSONObject.put((String)localEntry.getKey(), localEntry.getValue().toString());
            }
          }
          catch (JSONException paramJSONObject)
          {
            QLog.d("ProteusReportUtil", 1, "", paramJSONObject);
          }
        }
      }
    }
  }
  
  private static boolean a()
  {
    return PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.weishi");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.ProteusReportUtil
 * JD-Core Version:    0.7.0.1
 */