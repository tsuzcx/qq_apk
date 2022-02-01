package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

public class MiniAppApiReportBean
{
  private List<String> a = new ArrayList(Arrays.asList(new String[] { "requestPayment", "updateHTMLWebView", "insertHTMLWebView", "removeHTMLWebView", "insertMap", "wnsRequest", "getQua", "openUrl", "notifyNative", "launchApplication", "getUserInfoExtra", "updateShareMenu", "showShareMenu", "hideShareMenu", "getShareInfo", "shareAppMessage" }));
  
  public static MiniAppApiReportBean a(QConfItem[] paramArrayOfQConfItem)
  {
    MiniAppApiReportBean localMiniAppApiReportBean = new MiniAppApiReportBean();
    int i = 0;
    try
    {
      while (i < paramArrayOfQConfItem.length)
      {
        localMiniAppApiReportBean.a.clear();
        Object localObject = paramArrayOfQConfItem[i].a;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new JSONArray((String)localObject);
          int j = 0;
          while (j < ((JSONArray)localObject).length())
          {
            localMiniAppApiReportBean.a.add(((JSONArray)localObject).getString(j));
            j += 1;
          }
        }
        i += 1;
      }
      return localMiniAppApiReportBean;
    }
    catch (Throwable paramArrayOfQConfItem)
    {
      QLog.d("MiniAppApiReportProcessor", 2, "parse, failed!", paramArrayOfQConfItem);
    }
    return null;
  }
  
  public List<String> a()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getApiReportList:");
    localStringBuilder.append(TextUtils.join(",", a()));
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MiniAppApiReportBean
 * JD-Core Version:    0.7.0.1
 */