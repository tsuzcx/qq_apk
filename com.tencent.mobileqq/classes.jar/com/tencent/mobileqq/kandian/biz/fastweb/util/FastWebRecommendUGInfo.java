package com.tencent.mobileqq.kandian.biz.fastweb.util;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class FastWebRecommendUGInfo
{
  public int a;
  public String a;
  public JSONObject a;
  public String b;
  public String c;
  public String d;
  public String e = "前往快报阅读";
  public String f = "下载快报阅读";
  public String g = "安装快报阅读";
  public String h = "下载中...";
  public String i = "下载已暂停";
  public String j = "下载快报阅读";
  private String k;
  
  public FastWebRecommendUGInfo(@NonNull String paramString)
  {
    this.jdField_a_of_type_Int = 0;
    a(paramString);
  }
  
  public FastWebRecommendUGInfo(@NonNull String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = 0;
    this.k = paramString2;
    a(paramString1);
  }
  
  public void a(@NonNull String paramString)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramString).getJSONObject("sRspJsonData");
      paramString = this.jdField_a_of_type_OrgJsonJSONObject.getJSONArray("items");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = (JSONObject)paramString.get(0);
        this.jdField_a_of_type_Int = paramString.optInt("useUg");
        localObject = paramString.getJSONObject("statInfo").getJSONArray("999");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
          this.jdField_a_of_type_JavaLangString = ((String)((JSONArray)localObject).get(0));
        }
        if (!this.k.isEmpty())
        {
          paramString = paramString.getJSONObject("privateInfo").getJSONObject(this.k);
          this.c = paramString.optString("deepLink");
          this.b = paramString.optString("h5Link");
          this.d = paramString.optString("clipboardData");
        }
      }
      paramString = this.jdField_a_of_type_OrgJsonJSONObject.getJSONObject("rsp_ext").getJSONArray("extitems");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = (JSONObject)paramString.get(0);
        if (paramString != null)
        {
          this.e = paramString.optString("state_installed", "前往快报阅读");
          this.f = paramString.optString("state_unInstalled", "下载快报阅读");
          this.g = paramString.optString("state_download_complete", "安装快报阅读");
          this.h = paramString.optString("state_downloading", "下载中...");
          this.i = paramString.optString("state_download_interrupt", "下载已暂停");
          this.j = paramString.optString("state_download_interrupt_next", "下载快报阅读");
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
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRecommendUGInfo
 * JD-Core Version:    0.7.0.1
 */