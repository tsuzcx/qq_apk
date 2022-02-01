package com.tencent.tbs.one.impl.e;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.tbs.one.impl.a.d;
import com.tencent.tbs.one.impl.c.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class i$1
  implements Runnable
{
  i$1(i parami) {}
  
  public final void run()
  {
    String str1 = this.a.b;
    int i;
    if (this.a.r != null)
    {
      if (this.a.r.a != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        com.tencent.tbs.one.impl.a.f.a("[%s] %s in updating", new Object[] { str1, "Early out for idle task," });
        this.a.k();
        return;
      }
    }
    Object localObject1 = this.a.n.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (b)((Iterator)localObject1).next();
      if ((((b)localObject2).e) && (((b)localObject2).k == null)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        com.tencent.tbs.one.impl.a.f.a("[%s] %s in loading component", new Object[] { str1, "Early out for idle task," });
        this.a.k();
        return;
      }
    }
    f.a(this.a.a);
    f.d(this.a.c);
    if (!this.a.e)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] %s disabled", new Object[] { str1, "Early out for auto update," });
      return;
    }
    if (!this.a.b())
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] %s not use online service", new Object[] { str1, "Early out for auto update," });
      return;
    }
    long l1 = this.a.q.getLong("last_update_time", 0L);
    long l2 = System.currentTimeMillis();
    localObject1 = this.a;
    Object localObject2 = ((i)localObject1).q.getString("last_version_name", "");
    String str2 = d.c(((h)localObject1).a);
    ((i)localObject1).q.edit().putString("last_version_name", str2).apply();
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals(str2))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((l2 - l1 < this.a.f) && (i == 0))
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the interval is not reached, last update time: %s,is new version: %s", new Object[] { str1, "Early out for auto update,", d.a(l1), "false" });
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.i.1
 * JD-Core Version:    0.7.0.1
 */