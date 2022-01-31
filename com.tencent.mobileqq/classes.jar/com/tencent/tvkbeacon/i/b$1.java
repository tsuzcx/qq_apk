package com.tencent.tvkbeacon.i;

import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

final class b$1
  implements Runnable
{
  b$1(b paramb, String paramString, long paramLong1, long paramLong2) {}
  
  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("A145", this.a);
    localHashMap.put("A146", String.valueOf(this.b));
    localHashMap.put("A147", String.valueOf(this.c));
    boolean bool = UserAction.onUserAction("rqd_logidtrace", true, 0L, 0L, localHashMap, true);
    c.b("[stat] upload last day logid Date: %s, realtimeesn: %d, normalesn: %d, upload success: %s", new Object[] { this.a, Long.valueOf(this.b), Long.valueOf(this.c), Boolean.valueOf(bool) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.i.b.1
 * JD-Core Version:    0.7.0.1
 */