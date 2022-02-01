package com.tencent.mobileqq.kandian.biz.fastweb.util;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class FastWebRecommendUGInfo
{
  public JSONObject a;
  public int b = 0;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g = "前往快报阅读";
  public String h = "下载快报阅读";
  public String i = "安装快报阅读";
  public String j = "下载中...";
  public String k = "下载已暂停";
  public String l = "下载快报阅读";
  private String m;
  
  public FastWebRecommendUGInfo(@NonNull String paramString)
  {
    a(paramString);
  }
  
  public FastWebRecommendUGInfo(@NonNull String paramString1, String paramString2)
  {
    this.m = paramString2;
    a(paramString1);
  }
  
  public void a(@NonNull String paramString)
  {
    try
    {
      this.a = new JSONObject(paramString).getJSONObject("sRspJsonData");
      paramString = this.a.getJSONArray("items");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = (JSONObject)paramString.get(0);
        this.b = paramString.optInt("useUg");
        localObject = paramString.getJSONObject("statInfo").getJSONArray("999");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
          this.c = ((String)((JSONArray)localObject).get(0));
        }
        if (!this.m.isEmpty())
        {
          paramString = paramString.getJSONObject("privateInfo").getJSONObject(this.m);
          this.e = paramString.optString("deepLink");
          this.d = paramString.optString("h5Link");
          this.f = paramString.optString("clipboardData");
        }
      }
      paramString = this.a.getJSONObject("rsp_ext").getJSONArray("extitems");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = (JSONObject)paramString.get(0);
        if (paramString != null)
        {
          this.g = paramString.optString("state_installed", "前往快报阅读");
          this.h = paramString.optString("state_unInstalled", "下载快报阅读");
          this.i = paramString.optString("state_download_complete", "安装快报阅读");
          this.j = paramString.optString("state_downloading", "下载中...");
          this.k = paramString.optString("state_download_interrupt", "下载已暂停");
          this.l = paramString.optString("state_download_interrupt_next", "下载快报阅读");
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseProteusItem msg=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("FastWebRecommendUGInfo", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean b()
  {
    return this.b == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRecommendUGInfo
 * JD-Core Version:    0.7.0.1
 */