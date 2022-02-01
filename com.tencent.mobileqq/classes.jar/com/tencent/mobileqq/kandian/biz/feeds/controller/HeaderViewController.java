package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class HeaderViewController
{
  protected abstract void a();
  
  public abstract void a(ListView paramListView);
  
  protected void a(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      paramJSONObject.put("kandian_mode", RIJAppSetting.a());
      paramJSONObject = paramJSONObject.toString();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, "", "", "", paramJSONObject, false);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report: T - ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" r5 - ");
      localStringBuilder.append(paramJSONObject);
      QLog.d("HeaderViewController", 2, localStringBuilder.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("report failed due to JSONException: ");
      paramJSONObject.append(paramString.getMessage());
      QLog.d("HeaderViewController", 2, paramJSONObject.toString());
      throw new IllegalArgumentException("fail to construct r5 json");
    }
  }
  
  public abstract void b();
  
  public void c()
  {
    a();
  }
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.HeaderViewController
 * JD-Core Version:    0.7.0.1
 */