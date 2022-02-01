package com.tencent.xweb.xwalk.updater;

import com.tencent.xweb.ad;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.c;
import org.xwalk.core.XWalkEnvironment;

final class g$1
  implements b
{
  public void a()
  {
    XWebCoreScheduler.z().o();
    h.x();
  }
  
  public void a(j.b paramb) {}
  
  public void a(j.c paramc)
  {
    Object localObject = a.a(paramc.b);
    if (localObject == null)
    {
      h.a(35L, 1);
      h.y();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0,201201,");
      ((StringBuilder)localObject).append(paramc.c);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramc.d);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramc.f);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramc.g);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramc.h);
      h.a(15123, ((StringBuilder)localObject).toString());
      XWalkEnvironment.addXWalkInitializeLog("ConfigParser failed ");
      paramc = ad.a();
      if (paramc != null) {
        paramc.b(1);
      }
      return;
    }
    new g.1.1(this, (a.b)localObject, paramc).execute(new Void[0]);
  }
  
  public void b(j.c paramc)
  {
    Object localObject = ad.a();
    if (localObject != null) {
      ((c)localObject).b(1);
    }
    h.a(35L, 1);
    h.y();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("0,201201,");
    ((StringBuilder)localObject).append(paramc.c);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramc.d);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramc.f);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramc.g);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramc.h);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(g.g());
    h.a(15123, ((StringBuilder)localObject).toString());
    XWalkEnvironment.addXWalkInitializeLog("get config onTaskFailed ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.g.1
 * JD-Core Version:    0.7.0.1
 */