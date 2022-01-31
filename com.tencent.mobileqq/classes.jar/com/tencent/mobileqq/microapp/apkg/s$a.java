package com.tencent.mobileqq.microapp.apkg;

import android.graphics.Bitmap;
import org.json.JSONObject;

public final class s$a
  implements Cloneable
{
  public String a;
  public String b;
  public String c;
  public String d;
  public Bitmap e;
  public Bitmap f;
  
  public static a a(JSONObject paramJSONObject)
  {
    a locala = new a();
    if (paramJSONObject != null)
    {
      locala.a = paramJSONObject.optString("pagePath");
      locala.b = paramJSONObject.optString("text");
      locala.c = paramJSONObject.optString("iconData");
      locala.d = paramJSONObject.optString("selectedIconData");
      locala.e = s.a(locala.c);
      locala.f = s.a(locala.d);
    }
    return locala;
  }
  
  public a a()
  {
    try
    {
      a locala = (a)super.clone();
      return locala;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.s.a
 * JD-Core Version:    0.7.0.1
 */