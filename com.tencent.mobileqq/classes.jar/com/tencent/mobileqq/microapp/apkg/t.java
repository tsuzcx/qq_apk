package com.tencent.mobileqq.microapp.apkg;

import android.text.TextUtils;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import org.json.JSONObject;

public final class t
  implements Cloneable
{
  public p a;
  public int b;
  public String c;
  public boolean d;
  public int e;
  
  public static t a()
  {
    t localt = new t();
    localt.a = p.a();
    localt.b = DisplayUtil.parseColor("#ffffff");
    localt.c = "dark";
    localt.d = false;
    localt.e = 50;
    return localt;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str;
    if (paramJSONObject != null)
    {
      this.a.a(paramJSONObject);
      str = paramJSONObject.optString("backgroundColor");
      if (!TextUtils.isEmpty(str)) {
        break label79;
      }
    }
    label79:
    for (int i = this.b;; i = DisplayUtil.parseColor(str))
    {
      this.b = i;
      this.c = paramJSONObject.optString("backgroundTextStyle", this.c);
      this.d = paramJSONObject.optBoolean("enablePullDownRefresh", this.d);
      this.e = paramJSONObject.optInt("onReachBottomDistance", this.e);
      return;
    }
  }
  
  public t b()
  {
    try
    {
      localt = (t)super.clone();
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localt.a = this.a.b();
        return localt;
      }
      catch (Throwable localThrowable2)
      {
        t localt;
        break label24;
      }
      localThrowable1 = localThrowable1;
      localt = null;
    }
    label24:
    return localt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.t
 * JD-Core Version:    0.7.0.1
 */