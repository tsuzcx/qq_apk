package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class FastWebProteusReportUtils
{
  public static void a(TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if (paramTemplateBean != null)
    {
      if (paramViewBase == null) {
        return;
      }
      String str1 = (String)paramTemplateBean.getDataAttribute(paramViewBase.getName(), "click_T");
      if (TextUtils.isEmpty(str1))
      {
        QLog.d("FastWebProteusReportUtils", 2, "customClickReport bigT is null");
        return;
      }
      paramViewBase = paramTemplateBean.getDataAttribute(paramViewBase.getName());
      paramTemplateBean = new RIJTransMergeKanDianReport.ReportR5Builder();
      if (paramViewBase != null)
      {
        paramViewBase = paramViewBase.entrySet().iterator();
        while (paramViewBase.hasNext())
        {
          Object localObject = (Map.Entry)paramViewBase.next();
          String str2 = (String)((Map.Entry)localObject).getKey();
          localObject = ((Map.Entry)localObject).getValue();
          if (!TextUtils.equals(str2, "click_T")) {
            paramTemplateBean.addStringNotThrow(str2, localObject.toString());
          }
        }
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", str1, str1, 0, 0, "", "", "", paramTemplateBean.build(), false);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, ProteusItemData paramProteusItemData)
  {
    paramAbsBaseArticleInfo = paramProteusItemData.a;
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.d("FastWebProteusReportUtils", 2, "data is null!");
      return;
    }
    if (a(paramProteusItemData))
    {
      a(paramFastWebArticleInfo);
      return;
    }
    paramFastWebArticleInfo = paramAbsBaseArticleInfo.getDataAttribute(null);
    if ((paramFastWebArticleInfo != null) && (!paramFastWebArticleInfo.isEmpty()))
    {
      paramAbsBaseArticleInfo = new RIJTransMergeKanDianReport.ReportR5Builder();
      paramProteusItemData = paramFastWebArticleInfo.entrySet().iterator();
      while (paramProteusItemData.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramProteusItemData.next();
        paramAbsBaseArticleInfo.addStringNotThrow((String)localEntry.getKey(), localEntry.getValue().toString());
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B303", "0X800B303", 0, 0, "", "", "", paramAbsBaseArticleInfo.build(), false);
      if (paramFastWebArticleInfo.get("expose_T") != null)
      {
        paramFastWebArticleInfo = paramFastWebArticleInfo.get("expose_T").toString();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramFastWebArticleInfo, paramFastWebArticleInfo, 0, 0, "", "", "", paramAbsBaseArticleInfo.build(), false);
      }
      return;
    }
    QLog.d("FastWebProteusReportUtils", 2, "cellDataAttr null or empty!");
  }
  
  private static void a(FastWebArticleInfo paramFastWebArticleInfo)
  {
    ThreadManager.getSubThreadHandler().post(new FastWebProteusReportUtils.1(paramFastWebArticleInfo));
  }
  
  private static boolean a(ProteusItemData paramProteusItemData)
  {
    if (paramProteusItemData == null) {
      return false;
    }
    if (paramProteusItemData.c == null) {
      return false;
    }
    return TextUtils.equals(paramProteusItemData.c.optString("style_ID", ""), "readinjoy_native_tag");
  }
  
  public static void b(TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if (paramTemplateBean != null)
    {
      if (paramViewBase == null) {
        return;
      }
      Object localObject = new HashMap();
      Map localMap = paramTemplateBean.getDataAttribute(null);
      paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId());
      if (localMap != null) {
        ((Map)localObject).putAll(localMap);
      }
      if (paramTemplateBean != null) {
        ((Map)localObject).putAll(paramTemplateBean);
      }
      paramTemplateBean = new RIJTransMergeKanDianReport.ReportR5Builder();
      paramViewBase = ((Map)localObject).entrySet().iterator();
      while (paramViewBase.hasNext())
      {
        localObject = (Map.Entry)paramViewBase.next();
        paramTemplateBean.addStringNotThrow((String)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue().toString());
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B304", "0X800B304", 0, 0, "", "", "", paramTemplateBean.build(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebProteusReportUtils
 * JD-Core Version:    0.7.0.1
 */