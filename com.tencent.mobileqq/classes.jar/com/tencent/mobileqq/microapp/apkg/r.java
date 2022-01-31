package com.tencent.mobileqq.microapp.apkg;

import org.json.JSONObject;

public final class r
  implements Cloneable
{
  public t a;
  
  public static r a()
  {
    r localr = new r();
    localr.a = t.a();
    return localr;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    t localt;
    if (this.a != null)
    {
      localt = this.a;
      if (paramJSONObject != null) {
        break label24;
      }
    }
    label24:
    for (paramJSONObject = null;; paramJSONObject = paramJSONObject.optJSONObject("window"))
    {
      localt.a(paramJSONObject);
      return;
    }
  }
  
  public r b()
  {
    try
    {
      localr = (r)super.clone();
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localr.a = this.a.b();
        return localr;
      }
      catch (Throwable localThrowable2)
      {
        r localr;
        break label24;
      }
      localThrowable1 = localThrowable1;
      localr = null;
    }
    label24:
    return localr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.r
 * JD-Core Version:    0.7.0.1
 */