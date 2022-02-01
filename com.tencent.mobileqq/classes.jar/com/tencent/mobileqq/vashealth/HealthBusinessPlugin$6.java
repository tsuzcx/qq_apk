package com.tencent.mobileqq.vashealth;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class HealthBusinessPlugin$6
  implements Runnable
{
  HealthBusinessPlugin$6(HealthBusinessPlugin paramHealthBusinessPlugin, List paramList) {}
  
  public void run()
  {
    String str1;
    String str2;
    JSONObject localJSONObject;
    synchronized (HealthBusinessPlugin.a)
    {
      Iterator localIterator = this.a.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str1 = (String)localIterator.next();
      } while ((TextUtils.isEmpty(str1)) || (HealthBusinessPlugin.a.containsKey(str1)));
      str2 = HealthBusinessPlugin.a(str1, 0);
      localJSONObject = new JSONObject();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.6
 * JD-Core Version:    0.7.0.1
 */