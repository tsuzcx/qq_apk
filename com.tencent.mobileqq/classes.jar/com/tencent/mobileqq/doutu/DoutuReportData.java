package com.tencent.mobileqq.doutu;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class DoutuReportData
{
  public String a;
  public DoutuReportData.Data b;
  
  public JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("user_id", this.b.a);
      localJSONObject2.put("source_md5", this.b.b);
      localJSONObject2.put("source_url", this.b.c);
      localObject = new JSONArray();
      Iterator localIterator = this.b.d.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put((String)localIterator.next());
      }
      localJSONObject2.put("expose_md5s", localObject);
      localObject = new JSONArray();
      localIterator = this.b.e.iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject).put((String)localIterator.next());
      }
      localJSONObject2.put("expose_urls", localObject);
      localJSONObject2.put("click_md5", this.b.f);
      localJSONObject2.put("click_url", this.b.g);
      localJSONObject2.put("aio_type", this.b.h);
      localJSONObject2.put("mobile_type", this.b.i);
      localJSONObject2.put("to_user_id", this.b.j);
      localJSONObject1.put("dcId", this.a);
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("convert error:");
        ((StringBuilder)localObject).append(localException);
        QLog.e("DoutuReportData", 2, ((StringBuilder)localObject).toString());
      }
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuReportData
 * JD-Core Version:    0.7.0.1
 */