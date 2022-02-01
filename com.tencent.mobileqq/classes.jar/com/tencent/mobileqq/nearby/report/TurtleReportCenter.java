package com.tencent.mobileqq.nearby.report;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import org.json.JSONArray;

public class TurtleReportCenter
{
  public static TurtleReportCenter a;
  private Callback a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqNearbyReportTurtleReportCenter = new TurtleReportCenter();
  }
  
  private TurtleReportCenter()
  {
    this.jdField_a_of_type_Okhttp3Callback = new TurtleReportCenter.1(this);
  }
  
  private String a(Bundle paramBundle)
  {
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = new JSONArray();
    Iterator localIterator = paramBundle.keySet().iterator();
    String str = "";
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      if ("tid".equals(localObject))
      {
        str = paramBundle.getString((String)localObject);
      }
      else if (!"bid".equals(localObject))
      {
        localJSONArray1.put(localObject);
        if (StringUtil.a(paramBundle.getString((String)localObject))) {
          localObject = "";
        } else {
          localObject = paramBundle.getString((String)localObject);
        }
        localJSONArray2.put(localObject);
      }
    }
    paramBundle = new JSONArray();
    paramBundle.put(localJSONArray2);
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("&table=");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("&fields=");
      ((StringBuilder)localObject).append(URLEncoder.encode(localJSONArray1.toString(), "UTF-8"));
      ((StringBuilder)localObject).append("&datas=");
      ((StringBuilder)localObject).append(URLEncoder.encode(paramBundle.toString(), "UTF-8"));
      paramBundle = ((StringBuilder)localObject).toString();
      return paramBundle;
    }
    catch (UnsupportedEncodingException paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return "";
  }
  
  private void b(Bundle paramBundle)
  {
    Headers localHeaders = new Headers.Builder().add("Content-Type", "application/x-www-form-urlencoded").add("Referer", "https://now.qq.com/").build();
    paramBundle = RequestBody.create(MediaType.get("application/x-www-form-urlencoded"), a(paramBundle));
    paramBundle = new Request.Builder().url("https://now.qq.com/cgi-bin/now/web/tdw/report").headers(localHeaders).post(paramBundle).build();
    ((IOkHttpClientFactory)QRoute.api(IOkHttpClientFactory.class)).getRequestClient().newCall(paramBundle).enqueue(this.jdField_a_of_type_Okhttp3Callback);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.d("TurtleReportCenter", 4, "send(): no data to report");
      return;
    }
    b(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.report.TurtleReportCenter
 * JD-Core Version:    0.7.0.1
 */