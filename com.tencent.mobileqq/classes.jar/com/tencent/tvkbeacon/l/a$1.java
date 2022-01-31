package com.tencent.tvkbeacon.l;

import com.tencent.tvkbeacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

final class a$1
  implements Runnable
{
  a$1(a parama, long paramLong1, String paramString, long paramLong2) {}
  
  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("A110", String.valueOf(this.a));
    localHashMap.put("A111", this.b);
    localHashMap.put("A112", String.valueOf(this.c));
    UserAction.onUserAction("rqd_page", true, 0L, 0L, localHashMap, false);
    a.a(this.d, a.a(this.d) + this.c);
    if (a.a(this.d) >= 15000L)
    {
      a.a(this.d, 0L);
      UserAction.flushObjectsToDB(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.l.a.1
 * JD-Core Version:    0.7.0.1
 */