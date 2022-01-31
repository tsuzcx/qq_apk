package com.tencent.qapmsdk.socket.handler;

import com.tencent.qapmsdk.socket.model.SocketInfo;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TrafficIOStreamHandlerManager
{
  private static final Set<ITrafficInputStreamHandlerFactory> sInputStreamHandlersFactories = Collections.newSetFromMap(new ConcurrentHashMap());
  private static final Set<ITrafficOutputStreamHandlerFactory> sOutputStreamHandlersFactories = Collections.newSetFromMap(new ConcurrentHashMap());
  
  static
  {
    sInputStreamHandlersFactories.add(new TrafficIOStreamHandlerManager.DefaultTrafficInputStreamHandlerFactory(null));
    sOutputStreamHandlersFactories.add(new TrafficIOStreamHandlerManager.DefaultTrafficOutputStreamHandlerFactory(null));
  }
  
  public static void addInputStreamHandlerFactory(ITrafficInputStreamHandlerFactory paramITrafficInputStreamHandlerFactory)
  {
    if (paramITrafficInputStreamHandlerFactory == null) {
      return;
    }
    sInputStreamHandlersFactories.add(paramITrafficInputStreamHandlerFactory);
  }
  
  public static void addOutputStreamHandlerFactory(ITrafficOutputStreamHandlerFactory paramITrafficOutputStreamHandlerFactory)
  {
    if (paramITrafficOutputStreamHandlerFactory == null) {
      return;
    }
    sOutputStreamHandlersFactories.add(paramITrafficOutputStreamHandlerFactory);
  }
  
  public static void clearInputStreamHandlerFactories()
  {
    sInputStreamHandlersFactories.clear();
  }
  
  public static void clearOutputStreamHandlerFactories()
  {
    sOutputStreamHandlersFactories.clear();
  }
  
  public static Set<ITrafficInputStreamHandlerFactory> getInputStreamHandlersFactories()
  {
    return sInputStreamHandlersFactories;
  }
  
  public static Set<ITrafficOutputStreamHandlerFactory> getOutputStreamHandlersFactories()
  {
    return sOutputStreamHandlersFactories;
  }
  
  private static String makeTag(SocketInfo paramSocketInfo)
  {
    Object localObject = PathResolver.getPathResolver();
    if (paramSocketInfo.version != null) {
      if (paramSocketInfo.ssl)
      {
        str = "https";
        paramSocketInfo.protocol = str;
        StringBuilder localStringBuilder = new StringBuilder().append(paramSocketInfo.host).append("/").append(paramSocketInfo.ip).append(":").append(paramSocketInfo.port).append(", ");
        if (localObject == null) {
          break label237;
        }
        localObject = ((IPathResolver)localObject).resolve(paramSocketInfo.path);
        label85:
        localObject = localStringBuilder.append((String)localObject).append(", ").append(paramSocketInfo.version).append(", ").append(paramSocketInfo.method).append(", ").append(str).append(", ").append(paramSocketInfo.networkType);
        if (!paramSocketInfo.gzip) {
          break label245;
        }
        str = ", gzip";
        label146:
        localObject = ((StringBuilder)localObject).append(str);
        if (!paramSocketInfo.chunked) {
          break label251;
        }
      }
    }
    label237:
    label245:
    label251:
    for (String str = ", chunked";; str = "")
    {
      return str + ", " + paramSocketInfo.fd + ", impl[@" + paramSocketInfo.implHashCode + "], tid[" + paramSocketInfo.threadId + "]";
      str = "http";
      break;
      if (paramSocketInfo.ssl)
      {
        str = "ssl";
        break;
      }
      str = "tcp";
      break;
      localObject = paramSocketInfo.path;
      break label85;
      str = "";
      break label146;
    }
  }
  
  public static void removeInputStreamHandlerFactory(ITrafficInputStreamHandlerFactory paramITrafficInputStreamHandlerFactory)
  {
    if (paramITrafficInputStreamHandlerFactory == null) {
      return;
    }
    sInputStreamHandlersFactories.remove(paramITrafficInputStreamHandlerFactory);
  }
  
  public static void removeOutputStreamHandlerFactory(ITrafficOutputStreamHandlerFactory paramITrafficOutputStreamHandlerFactory)
  {
    if (paramITrafficOutputStreamHandlerFactory == null) {
      return;
    }
    sOutputStreamHandlersFactories.remove(paramITrafficOutputStreamHandlerFactory);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.TrafficIOStreamHandlerManager
 * JD-Core Version:    0.7.0.1
 */