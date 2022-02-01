package com.tencent.mobileqq.kandian.biz.channel.banner;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.BaseItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.ImgItem;
import org.json.JSONException;
import org.json.JSONObject;

public class BannerReportHelper
{
  public static RIJTransMergeKanDianReport.ReportR5Builder a(int paramInt)
  {
    return new RIJTransMergeKanDianReport.ReportR5Builder().addFolderStatus().addChannelId(paramInt);
  }
  
  public static RIJTransMergeKanDianReport.ReportR5Builder a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = a(paramInt);
    for (;;)
    {
      try
      {
        paramString1 = localReportR5Builder.addRowkey(paramString1).addString("URL", paramString2);
        if (paramBoolean)
        {
          paramInt = 1;
          paramString1 = paramString1.addInt("ad_page", paramInt);
          return paramString1;
        }
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return localReportR5Builder;
      }
      paramInt = 0;
    }
  }
  
  public static String a(int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", paramString);
      localJSONObject.put("num", paramInt);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, TopBannerInfo.BaseItem paramBaseItem)
  {
    String str;
    if ((paramBaseItem instanceof TopBannerInfo.ImgItem)) {
      str = ((TopBannerInfo.ImgItem)paramBaseItem).k;
    } else {
      str = "0";
    }
    PublicAccountReportUtils.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt3), String.valueOf(paramInt1), String.valueOf(paramBaseItem.a), a(paramInt2, paramBaseItem.g, str, paramBaseItem.h).build(), false);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = a(paramInt1);
    if (paramBoolean) {
      paramInt1 = 1;
    }
    for (;;)
    {
      try
      {
        localReportR5Builder.addInt("ad_page_include", paramInt1);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      PublicAccountReportUtils.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt2), "", "", localReportR5Builder.build(), false);
      return;
      paramInt1 = 0;
    }
  }
  
  public static void a(String paramString, int paramInt, TopBannerInfo.BaseItem paramBaseItem)
  {
    if ((paramBaseItem instanceof TopBannerInfo.ImgItem)) {
      paramBaseItem = ((TopBannerInfo.ImgItem)paramBaseItem).k;
    } else {
      paramBaseItem = "0";
    }
    PublicAccountReportUtils.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt), "", "", a(paramInt, paramBaseItem), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.banner.BannerReportHelper
 * JD-Core Version:    0.7.0.1
 */