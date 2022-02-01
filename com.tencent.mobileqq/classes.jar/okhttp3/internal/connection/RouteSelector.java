package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

public final class RouteSelector
{
  private final Address address;
  private final Call call;
  private final EventListener eventListener;
  private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
  private int nextProxyIndex;
  private final List<Route> postponedRoutes = new ArrayList();
  private List<Proxy> proxies = Collections.emptyList();
  private final RouteDatabase routeDatabase;
  
  public RouteSelector(Address paramAddress, RouteDatabase paramRouteDatabase, Call paramCall, EventListener paramEventListener)
  {
    this.address = paramAddress;
    this.routeDatabase = paramRouteDatabase;
    this.call = paramCall;
    this.eventListener = paramEventListener;
    resetNextProxy(paramAddress.url(), paramAddress.proxy());
  }
  
  static String getHostString(InetSocketAddress paramInetSocketAddress)
  {
    InetAddress localInetAddress = paramInetSocketAddress.getAddress();
    if (localInetAddress == null) {
      return paramInetSocketAddress.getHostName();
    }
    return localInetAddress.getHostAddress();
  }
  
  private boolean hasNextProxy()
  {
    return this.nextProxyIndex < this.proxies.size();
  }
  
  private Proxy nextProxy()
  {
    if (hasNextProxy())
    {
      localObject = this.proxies;
      int i = this.nextProxyIndex;
      this.nextProxyIndex = (i + 1);
      localObject = (Proxy)((List)localObject).get(i);
      resetNextInetSocketAddress((Proxy)localObject);
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No route to ");
    ((StringBuilder)localObject).append(this.address.url().host());
    ((StringBuilder)localObject).append("; exhausted proxy configurations: ");
    ((StringBuilder)localObject).append(this.proxies);
    throw new SocketException(((StringBuilder)localObject).toString());
  }
  
  private void resetNextInetSocketAddress(Proxy paramProxy)
  {
    this.inetSocketAddresses = new ArrayList();
    Object localObject;
    int i;
    if ((paramProxy.type() != Proxy.Type.DIRECT) && (paramProxy.type() != Proxy.Type.SOCKS))
    {
      localObject = paramProxy.address();
      if ((localObject instanceof InetSocketAddress))
      {
        InetSocketAddress localInetSocketAddress = (InetSocketAddress)localObject;
        localObject = getHostString(localInetSocketAddress);
        i = localInetSocketAddress.getPort();
      }
      else
      {
        paramProxy = new StringBuilder();
        paramProxy.append("Proxy.address() is not an InetSocketAddress: ");
        paramProxy.append(localObject.getClass());
        throw new IllegalArgumentException(paramProxy.toString());
      }
    }
    else
    {
      localObject = this.address.url().host();
      i = this.address.url().port();
    }
    if ((i >= 1) && (i <= 65535))
    {
      if (paramProxy.type() == Proxy.Type.SOCKS)
      {
        this.inetSocketAddresses.add(InetSocketAddress.createUnresolved((String)localObject, i));
        return;
      }
      this.eventListener.dnsStart(this.call, (String)localObject);
      paramProxy = this.address.dns().lookup((String)localObject);
      if (!paramProxy.isEmpty())
      {
        this.eventListener.dnsEnd(this.call, (String)localObject, paramProxy);
        int j = 0;
        int k = paramProxy.size();
        while (j < k)
        {
          localObject = (InetAddress)paramProxy.get(j);
          this.inetSocketAddresses.add(new InetSocketAddress((InetAddress)localObject, i));
          j += 1;
        }
        return;
      }
      paramProxy = new StringBuilder();
      paramProxy.append(this.address.dns());
      paramProxy.append(" returned no addresses for ");
      paramProxy.append((String)localObject);
      throw new UnknownHostException(paramProxy.toString());
    }
    paramProxy = new StringBuilder();
    paramProxy.append("No route to ");
    paramProxy.append((String)localObject);
    paramProxy.append(":");
    paramProxy.append(i);
    paramProxy.append("; port is out of range");
    paramProxy = new SocketException(paramProxy.toString());
    for (;;)
    {
      throw paramProxy;
    }
  }
  
  private void resetNextProxy(HttpUrl paramHttpUrl, Proxy paramProxy)
  {
    if (paramProxy != null)
    {
      this.proxies = Collections.singletonList(paramProxy);
    }
    else
    {
      paramHttpUrl = this.address.proxySelector().select(paramHttpUrl.uri());
      if ((paramHttpUrl != null) && (!paramHttpUrl.isEmpty())) {
        paramHttpUrl = Util.immutableList(paramHttpUrl);
      } else {
        paramHttpUrl = Util.immutableList(new Proxy[] { Proxy.NO_PROXY });
      }
      this.proxies = paramHttpUrl;
    }
    this.nextProxyIndex = 0;
  }
  
  public void connectFailed(Route paramRoute, IOException paramIOException)
  {
    if ((paramRoute.proxy().type() != Proxy.Type.DIRECT) && (this.address.proxySelector() != null)) {
      this.address.proxySelector().connectFailed(this.address.url().uri(), paramRoute.proxy().address(), paramIOException);
    }
    this.routeDatabase.failed(paramRoute);
  }
  
  public boolean hasNext()
  {
    return (hasNextProxy()) || (!this.postponedRoutes.isEmpty());
  }
  
  public RouteSelector.Selection next()
  {
    if (hasNext())
    {
      localObject = new ArrayList();
      do
      {
        if (!hasNextProxy()) {
          break;
        }
        Proxy localProxy = nextProxy();
        int i = 0;
        int j = this.inetSocketAddresses.size();
        while (i < j)
        {
          Route localRoute = new Route(this.address, localProxy, (InetSocketAddress)this.inetSocketAddresses.get(i));
          if (this.routeDatabase.shouldPostpone(localRoute)) {
            this.postponedRoutes.add(localRoute);
          } else {
            ((List)localObject).add(localRoute);
          }
          i += 1;
        }
      } while (((List)localObject).isEmpty());
      if (((List)localObject).isEmpty())
      {
        ((List)localObject).addAll(this.postponedRoutes);
        this.postponedRoutes.clear();
      }
      return new RouteSelector.Selection((List)localObject);
    }
    Object localObject = new NoSuchElementException();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.connection.RouteSelector
 * JD-Core Version:    0.7.0.1
 */