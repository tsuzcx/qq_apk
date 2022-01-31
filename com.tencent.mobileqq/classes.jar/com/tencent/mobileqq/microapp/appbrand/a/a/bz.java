package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.widget.g.a;
import org.json.JSONException;
import org.json.JSONObject;

final class bz
  implements g.a
{
  bz(by paramby) {}
  
  public void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", paramInt);
      this.a.e.a.a(this.a.b, this.a.c, localJSONObject, this.a.d);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.bz
 * JD-Core Version:    0.7.0.1
 */