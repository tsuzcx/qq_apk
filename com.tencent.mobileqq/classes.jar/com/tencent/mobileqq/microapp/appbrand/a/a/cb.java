package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.widget.b.a;
import org.json.JSONException;
import org.json.JSONObject;

final class cb
  implements b.a
{
  cb(ca paramca) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", paramInt + "-" + paramString1 + "-" + paramString2);
      this.a.f.a.a(this.a.b, this.a.c, localJSONObject, this.a.d);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.cb
 * JD-Core Version:    0.7.0.1
 */