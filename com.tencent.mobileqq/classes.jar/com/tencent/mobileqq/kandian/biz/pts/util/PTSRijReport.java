package com.tencent.mobileqq.kandian.biz.pts.util;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteItemViewBuilder;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class PTSRijReport
{
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, HashMap<String, String> paramHashMap)
  {
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    String str = RIJFeedsType.c(paramAbsBaseArticleInfo);
    return a(RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), (int)paramAbsBaseArticleInfo.mChannelID, NetworkUtil.isWifiConnected(null), str, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), 0, RIJTransMergeKanDianReport.a(), paramAbsBaseArticleInfo).toString(), paramHashMap);
  }
  
  public static String a(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject3 = new JSONObject();
    Object localObject1 = localObject3;
    Object localObject4;
    Object localObject2;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localObject1 = new JSONObject(paramString);
      }
    }
    catch (JSONException localJSONException1)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("[getR5Json] error, e = ");
      ((StringBuilder)localObject4).append(localJSONException1);
      ((StringBuilder)localObject4).append(", r5 = ");
      ((StringBuilder)localObject4).append(paramString);
      QLog.e("PTSRijReport", 1, ((StringBuilder)localObject4).toString());
      localObject2 = localObject3;
    }
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      localObject3 = paramHashMap.entrySet().iterator();
      if (((Iterator)localObject3).hasNext())
      {
        paramHashMap = (Map.Entry)((Iterator)localObject3).next();
        localObject4 = (String)paramHashMap.getKey();
        paramHashMap = (String)paramHashMap.getValue();
        if (PTSConstantUtil.a.a().contains(localObject4)) {}
      }
    }
    for (;;)
    {
      for (;;)
      {
        Object localObject5;
        try
        {
          if (TextUtils.isEmpty(paramHashMap)) {
            break label427;
          }
          localObject2.put((String)localObject4, paramHashMap);
        }
        catch (JSONException paramHashMap)
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("[getR5Json] error, e = ");
          ((StringBuilder)localObject5).append(paramHashMap);
          ((StringBuilder)localObject5).append(", key = ");
          ((StringBuilder)localObject5).append((String)localObject4);
          QLog.e("PTSRijReport", 1, ((StringBuilder)localObject5).toString());
        }
        break;
        if ((TextUtils.isEmpty((CharSequence)localObject4)) || (!((String)localObject4).equalsIgnoreCase("r5"))) {
          break;
        }
        try
        {
          localObject4 = new JSONObject(paramHashMap);
          localObject5 = ((JSONObject)localObject4).keys();
          while (((Iterator)localObject5).hasNext())
          {
            String str1 = (String)((Iterator)localObject5).next();
            String str2 = ((JSONObject)localObject4).optString(str1);
            if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
              localObject2.put(str1, str2);
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("[getR5Json] error, e = ");
          ((StringBuilder)localObject5).append(localJSONException2);
          ((StringBuilder)localObject5).append(", value = ");
          ((StringBuilder)localObject5).append(paramHashMap);
          QLog.e("PTSRijReport", 1, ((StringBuilder)localObject5).toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append("[getR5Json] r5 = ");
        paramHashMap.append(paramString);
        QLog.i("PTSRijReport", 1, paramHashMap.toString());
      }
      return localObject2.toString();
      label427:
      paramHashMap = "";
    }
  }
  
  public static void a(VideoR5.Builder paramBuilder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo instanceof BaseArticleInfo))
    {
      if (paramBuilder == null) {
        return;
      }
      if (paramAbsBaseArticleInfo.proteusItemsData == null) {
        return;
      }
      if (PTSLiteItemViewBuilder.b(paramAbsBaseArticleInfo)) {
        try
        {
          paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData);
          if (paramAbsBaseArticleInfo.optJSONObject("card_report_params") != null)
          {
            paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.getJSONObject("card_report_params");
            Iterator localIterator = paramAbsBaseArticleInfo.keys();
            while (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              String str2 = paramAbsBaseArticleInfo.optString(str1);
              if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
                paramBuilder.a(str1, str2);
              }
            }
          }
          return;
        }
        catch (JSONException paramBuilder)
        {
          paramAbsBaseArticleInfo = new StringBuilder();
          paramAbsBaseArticleInfo.append("[addPtsCardReportToR5], e = ");
          paramAbsBaseArticleInfo.append(paramBuilder);
          QLog.e("PTSRijReport", 1, paramAbsBaseArticleInfo.toString());
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    int j = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext());
    int i = 2;
    if (j != 1)
    {
      if ((j == 2) || (j == 3) || (j == 4)) {
        i = 0;
      }
    }
    else {
      i = 1;
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, localStringBuilder.toString(), RIJQQAppInterfaceUtil.a(), "0", null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSRijReport
 * JD-Core Version:    0.7.0.1
 */