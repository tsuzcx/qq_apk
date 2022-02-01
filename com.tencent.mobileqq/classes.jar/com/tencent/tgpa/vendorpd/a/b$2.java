package com.tencent.tgpa.vendorpd.a;

import android.os.Build;
import com.tencent.tgpa.vendorpd.b.f;
import com.tencent.tgpa.vendorpd.gradish.GradishWrapper;
import java.util.HashMap;

class b$2
  implements b.c
{
  b$2(b paramb) {}
  
  public HashMap<String, String> a()
  {
    return b.a(this.a);
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      f.a("Channel download result report success. data: %s", new Object[] { paramString });
      return;
    }
    f.b("Channel download result report failed. ");
  }
  
  public HashMap<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("api_key", b.b(this.a));
    localHashMap.put("model", Build.MODEL);
    localHashMap.put("manufacturer", Build.MANUFACTURER);
    localHashMap.put("channel", b.d(this.a));
    localHashMap.put("app_name", b.e(this.a));
    localHashMap.put("sdk_code", String.valueOf(17));
    localHashMap.put("sdk_version", "1.1.7");
    localHashMap.put("xid", GradishWrapper.getXID());
    String str;
    if (b.f(this.a) == null) {
      str = "";
    } else {
      str = b.f(this.a);
    }
    localHashMap.put("oaid", str);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.b.2
 * JD-Core Version:    0.7.0.1
 */