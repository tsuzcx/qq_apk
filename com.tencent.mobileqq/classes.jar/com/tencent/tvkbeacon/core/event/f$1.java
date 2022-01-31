package com.tencent.tvkbeacon.core.event;

import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

final class f$1
  implements Runnable
{
  f$1(long paramLong1, String paramString, long paramLong2) {}
  
  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("A110", String.valueOf(this.a));
    localHashMap.put("A111", this.b);
    localHashMap.put("A112", String.valueOf(this.c));
    UserAction.onUserAction("rqd_page_fgt", true, 0L, 0L, localHashMap, false);
    if (this.c >= 30000L)
    {
      c.b("[page] force flush page_fgt events in db.", new Object[0]);
      UserAction.flushObjectsToDB(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.f.1
 * JD-Core Version:    0.7.0.1
 */