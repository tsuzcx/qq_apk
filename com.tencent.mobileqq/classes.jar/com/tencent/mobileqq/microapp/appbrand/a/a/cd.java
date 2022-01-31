package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.widget.l.a;
import org.json.JSONException;
import org.json.JSONObject;

final class cd
  implements l.a
{
  cd(cc paramcc) {}
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", paramString1 + ":" + paramString2);
      this.a.e.a.a(this.a.b, this.a.c, localJSONObject, this.a.d);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.cd
 * JD-Core Version:    0.7.0.1
 */