package com.tencent.tgpa.vendorpd.a;

import android.content.Context;
import android.os.Build;
import com.tencent.tgpa.vendorpd.GameCallback;
import com.tencent.tgpa.vendorpd.b.c;
import com.tencent.tgpa.vendorpd.b.f;
import com.tencent.tgpa.vendorpd.gradish.GradishWrapper;
import java.util.ArrayList;
import java.util.HashMap;

class b$1
  implements b.c
{
  b$1(b paramb, Context paramContext, ArrayList paramArrayList) {}
  
  public HashMap<String, String> a()
  {
    return b.a(this.c);
  }
  
  public void a(String paramString)
  {
    paramString = b.a(this.c, paramString);
    f.a("onResponse: callback data has been prepared, data: %s", new Object[] { paramString });
    if (b.g(this.c) != null)
    {
      b.g(this.c).getPreDownloadVersionInfo(paramString);
      return;
    }
    f.d("onResponse: no callback is found!");
  }
  
  public HashMap<String, String> b()
  {
    String str1 = b.a(this.c, this.a, this.b);
    String str2 = String.valueOf(System.currentTimeMillis());
    String str3 = String.format("app_data=%s&time_stamp=%s&api_key=%s&api_secret=%s", new Object[] { str1, str2, b.b(this.c), b.c(this.c) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("time_stamp", str2);
    localHashMap.put("app_data", str1);
    localHashMap.put("api_sign", String.valueOf(c.a(str3)));
    localHashMap.put("api_key", b.b(this.c));
    localHashMap.put("model", Build.MODEL);
    localHashMap.put("manufacturer", Build.MANUFACTURER);
    localHashMap.put("channel", b.d(this.c));
    localHashMap.put("app_name", b.e(this.c));
    localHashMap.put("sdk_code", String.valueOf(17));
    localHashMap.put("sdk_version", "1.1.7");
    localHashMap.put("xid", GradishWrapper.getXID());
    if (b.f(this.c) == null) {
      str1 = "";
    } else {
      str1 = b.f(this.c);
    }
    localHashMap.put("oaid", str1);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.b.1
 * JD-Core Version:    0.7.0.1
 */