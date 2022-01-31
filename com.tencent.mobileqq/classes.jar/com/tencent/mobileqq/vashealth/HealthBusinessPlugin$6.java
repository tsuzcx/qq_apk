package com.tencent.mobileqq.vashealth;

import android.text.TextUtils;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
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
    for (;;)
    {
      String str1;
      String str2;
      JSONObject localJSONObject;
      synchronized (HealthBusinessPlugin.a)
      {
        Iterator localIterator = this.a.iterator();
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          if ((TextUtils.isEmpty(str1)) || (HealthBusinessPlugin.a.containsKey(str1))) {
            continue;
          }
          str2 = MediaApiPlugin.a(str1, 0);
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("imageID", str1);
        localJSONObject.put("data", str2);
        label87:
        HealthBusinessPlugin.a.put(str1, localJSONObject);
        continue;
        localObject = finally;
        throw localObject;
        return;
      }
      catch (JSONException localJSONException)
      {
        break label87;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.6
 * JD-Core Version:    0.7.0.1
 */