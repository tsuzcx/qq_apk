package com.tencent.upload.network.route;

import com.tencent.upload.common.Const.a;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e
  implements c
{
  protected final String a = getClass().getSimpleName() + hashCode();
  protected List<UploadRoute> b;
  protected List<Integer> c;
  protected Iterator<UploadRoute> d;
  protected Iterator<Integer> e;
  protected String f;
  protected RecentRouteSet g;
  protected List<a> h = new ArrayList();
  protected boolean i = false;
  private RouteFactory.ServerCategory j = RouteFactory.ServerCategory.OTHER;
  
  public e(RouteFactory.ServerCategory paramServerCategory)
  {
    this.j = paramServerCategory;
  }
  
  private UploadRoute b(UploadRoute paramUploadRoute)
  {
    UploadRoute localUploadRoute1 = null;
    UploadRoute localUploadRoute2 = null;
    if (paramUploadRoute == null)
    {
      paramUploadRoute = localUploadRoute2;
      if (this.d.hasNext()) {
        paramUploadRoute = (UploadRoute)this.d.next();
      }
      b.b(this.a, " doChangeRoute: lastRoute == null now = " + paramUploadRoute);
      localUploadRoute1 = paramUploadRoute;
      return localUploadRoute1;
    }
    paramUploadRoute = paramUploadRoute.clone();
    b.b(this.a, " doChangeRoute: currentRoute:" + paramUploadRoute);
    if (this.e.hasNext())
    {
      paramUploadRoute.setPort(((Integer)this.e.next()).intValue());
      b.b(this.a, " doChangeRoute:, to next port" + paramUploadRoute);
    }
    for (;;)
    {
      localUploadRoute2 = d();
      localUploadRoute1 = paramUploadRoute;
      if (localUploadRoute2 == null) {
        break;
      }
      localUploadRoute1 = paramUploadRoute;
      if (!localUploadRoute2.isDuplicate(paramUploadRoute)) {
        break;
      }
      b.b(this.a, " isDuplicate with recent, doChangeRoute:" + paramUploadRoute.toString());
      return b(paramUploadRoute);
      if (this.d.hasNext())
      {
        this.e = this.c.iterator();
        if (this.e.hasNext())
        {
          paramUploadRoute = ((UploadRoute)this.d.next()).clone();
          paramUploadRoute.setPort(((Integer)this.e.next()).intValue());
          b.b(this.a, " doChangeRoute: to next ip" + paramUploadRoute);
        }
        else
        {
          b.d(this.a, " doChangeRoute: to next ip, but no port. exception");
          paramUploadRoute = localUploadRoute1;
        }
      }
      else
      {
        b.b(this.a, " doChangeRoute: finish, return null");
        paramUploadRoute = localUploadRoute1;
      }
    }
  }
  
  private void c()
  {
    this.b = RouteFactory.a(b());
    if ((this.b == null) || (this.b.size() == 0)) {
      throw new RuntimeException(this.a + " doInitParams, getUploadRoutes illegal");
    }
    this.c = UploadConfiguration.getUploadRoutePorts();
    if ((this.c == null) || (this.c.size() == 0)) {
      throw new RuntimeException(this.a + " doInitParams, getUploadRoutePorts illegal");
    }
    this.d = this.b.iterator();
    this.e = this.c.iterator();
    StringBuffer localStringBuffer = new StringBuffer(this.b.size());
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      UploadRoute localUploadRoute = (UploadRoute)localIterator.next();
      localStringBuffer.append(localUploadRoute.toString() + " ");
    }
    b.b("[iplist] " + this.a, " doInitParams, all Route List:" + localStringBuffer.toString() + ", all Port List:" + this.c.toString());
  }
  
  private UploadRoute d()
  {
    if (this.g == null) {}
    UploadRoute localUploadRoute;
    do
    {
      return null;
      localUploadRoute = this.g.getRecentRoute();
    } while (localUploadRoute == null);
    b.b(this.a, " doRetrieveRecentRoute: " + localUploadRoute.toString());
    return localUploadRoute;
  }
  
  private void e()
  {
    String str = UploadConfiguration.getRecentRouteApnKey();
    if (str == null)
    {
      b.b(this.a, " doLoadRecentRouteSet, unknown key");
      return;
    }
    this.g = new d(b()).a(str);
  }
  
  private UploadRoute f()
  {
    if ((!this.d.hasNext()) || (!this.e.hasNext()))
    {
      b.b(this.a, " doRetrieveFirstRoute return null");
      return null;
    }
    UploadRoute localUploadRoute1 = (UploadRoute)this.d.next();
    localUploadRoute1.setPort(((Integer)this.e.next()).intValue());
    UploadRoute localUploadRoute2 = d();
    if ((localUploadRoute2 != null) && (localUploadRoute2.isDuplicate(localUploadRoute1)))
    {
      b.b(this.a, " doRetrieveFirstRoute isDuplicate with recent, doChangeRoute:" + localUploadRoute1.toString());
      return b(localUploadRoute1);
    }
    b.b(this.a, " doRetrieveFirstRoute return:" + localUploadRoute1.toString());
    return localUploadRoute1;
  }
  
  public UploadRoute a()
  {
    int k = 0;
    this.i = false;
    c();
    if ((this.f == null) || (this.f.compareToIgnoreCase(UploadConfiguration.getCurrentApn()) != 0)) {
      k = 1;
    }
    if (k != 0)
    {
      this.f = UploadConfiguration.getCurrentApn();
      e();
    }
    UploadRoute localUploadRoute = d();
    if (localUploadRoute != null)
    {
      b.b(this.a, " RouteStrategy reset, return recentRoute: " + localUploadRoute.toString());
      return localUploadRoute;
    }
    localUploadRoute = f();
    if (localUploadRoute != null)
    {
      b.b(this.a, " RouteStrategy reset, return firstRoute:" + localUploadRoute);
      return localUploadRoute;
    }
    b.b(this.a, " RouteStrategy reset, return null");
    return null;
  }
  
  public UploadRoute a(UploadRoute paramUploadRoute, int paramInt)
  {
    boolean bool2 = true;
    if (paramUploadRoute == null)
    {
      b.b(this.a, " next: null, route == null");
      return null;
    }
    this.h.add(new a(paramUploadRoute.clone(), paramInt));
    boolean bool3 = UploadConfiguration.isNetworkAvailable();
    if (!bool3) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.i = bool1;
      if (bool3) {
        break;
      }
      b.b(this.a, " next: null, !isNetworkAvailable");
      return null;
    }
    if ((this.f == null) || (this.f.compareToIgnoreCase(UploadConfiguration.getCurrentApn()) != 0)) {}
    for (bool1 = true;; bool1 = false)
    {
      this.i = bool1;
      if (!bool1) {
        break;
      }
      b.b(this.a, " next: null, isApnChanged:" + bool1);
      return null;
    }
    Object localObject1;
    if ((paramInt != 4) && (paramUploadRoute.getRouteCategory() == c.a.c))
    {
      localObject1 = f();
      if (localObject1 != null)
      {
        b.b(this.a, " next: return" + localObject1);
        return localObject1;
      }
    }
    label323:
    Object localObject2;
    StringBuilder localStringBuilder;
    if (paramUploadRoute.getProxyIp() != null)
    {
      bool1 = bool2;
      bool2 = UploadConfiguration.isWapSetting();
      b.b(this.a, " next start: " + Const.a.a(paramInt) + " failureCode:" + paramInt + " wap:" + bool2 + " proxy:" + bool1);
      switch (paramInt)
      {
      case 5: 
      default: 
        localObject1 = null;
        localObject2 = this.a;
        localStringBuilder = new StringBuilder().append(" next return: ");
        if (localObject1 != null) {
          break;
        }
      }
    }
    for (paramUploadRoute = "null";; paramUploadRoute = ((UploadRoute)localObject1).toString())
    {
      b.b((String)localObject2, paramUploadRoute);
      return localObject1;
      bool1 = false;
      break;
      paramUploadRoute.clearProxy();
      localObject1 = b(paramUploadRoute);
      break label323;
      while (this.e.hasNext()) {
        this.e.next();
      }
      localObject2 = b(paramUploadRoute);
      localObject1 = localObject2;
      if (localObject2 == null) {
        break label323;
      }
      ((UploadRoute)localObject2).setProxy(paramUploadRoute.getProxyIp(), paramUploadRoute.getPorxyPort());
      ((UploadRoute)localObject2).setRouteCategory(paramUploadRoute.getRouteCategory());
      localObject1 = localObject2;
      break label323;
    }
  }
  
  public boolean a(UploadRoute paramUploadRoute)
  {
    boolean bool = true;
    String str = UploadConfiguration.getRecentRouteApnKey();
    if (str == null)
    {
      b.b(this.a, "save, unknown key");
      bool = false;
    }
    do
    {
      return bool;
      if ((str == null) || (str.length() <= 0)) {
        break;
      }
    } while (paramUploadRoute.getIp().endsWith(".com"));
    this.g = UploadConfiguration.saveAsRecentIp(b(), str, paramUploadRoute);
    b.b(this.a, " save: as recent:" + paramUploadRoute + " recentApnKey:" + str);
    return true;
    b.b(this.a, " save: apnKey isNullOrEmpty");
    return true;
  }
  
  public RouteFactory.ServerCategory b()
  {
    return this.j;
  }
  
  private static final class a
  {
    public final UploadRoute a;
    public final int b;
    
    public a(UploadRoute paramUploadRoute, int paramInt)
    {
      this.a = paramUploadRoute;
      this.b = paramInt;
    }
    
    public String toString()
    {
      return String.format("[%1$s, %2$s]", new Object[] { this.a.toString(), Const.a.a(this.b) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.route.e
 * JD-Core Version:    0.7.0.1
 */