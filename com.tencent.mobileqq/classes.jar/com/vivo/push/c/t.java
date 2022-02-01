package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.b.q;
import com.vivo.push.util.o;
import com.vivo.push.util.z;
import java.util.HashMap;

final class t
  implements r.a
{
  t(s params) {}
  
  public final void a()
  {
    long l = com.vivo.push.e.a().l();
    if ((l < 1400L) && (l != 1340L))
    {
      o.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(l)));
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("srt", "1");
    localHashMap.put("message_id", String.valueOf(this.a.b.f()));
    String str = z.b(r.h(this.a.c), r.i(this.a.c).getPackageName());
    if (!TextUtils.isEmpty(str)) {
      localHashMap.put("app_id", str);
    }
    localHashMap.put("type", "1");
    localHashMap.put("dtp", "1");
    com.vivo.push.util.e.a(6L, localHashMap);
  }
  
  public final void b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("messageID", String.valueOf(this.a.b.f()));
    String str = z.b(r.j(this.a.c), r.k(this.a.c).getPackageName());
    if (!TextUtils.isEmpty(str)) {
      localHashMap.put("remoteAppId", str);
    }
    com.vivo.push.util.e.a(2122L, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.t
 * JD-Core Version:    0.7.0.1
 */