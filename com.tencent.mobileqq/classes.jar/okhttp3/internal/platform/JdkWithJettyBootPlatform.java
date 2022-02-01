package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.Util;

class JdkWithJettyBootPlatform
  extends Platform
{
  private final Class<?> clientProviderClass;
  private final Method getMethod;
  private final Method putMethod;
  private final Method removeMethod;
  private final Class<?> serverProviderClass;
  
  JdkWithJettyBootPlatform(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
  {
    this.putMethod = paramMethod1;
    this.getMethod = paramMethod2;
    this.removeMethod = paramMethod3;
    this.clientProviderClass = paramClass1;
    this.serverProviderClass = paramClass2;
  }
  
  public static Platform buildIfSupported()
  {
    try
    {
      Object localObject1 = Class.forName("org.eclipse.jetty.alpn.ALPN");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("org.eclipse.jetty.alpn.ALPN");
      ((StringBuilder)localObject2).append("$Provider");
      localObject2 = Class.forName(((StringBuilder)localObject2).toString());
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("org.eclipse.jetty.alpn.ALPN");
      ((StringBuilder)localObject3).append("$ClientProvider");
      localObject3 = Class.forName(((StringBuilder)localObject3).toString());
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("org.eclipse.jetty.alpn.ALPN");
      ((StringBuilder)localObject4).append("$ServerProvider");
      localObject4 = Class.forName(((StringBuilder)localObject4).toString());
      localObject1 = new JdkWithJettyBootPlatform(((Class)localObject1).getMethod("put", new Class[] { SSLSocket.class, localObject2 }), ((Class)localObject1).getMethod("get", new Class[] { SSLSocket.class }), ((Class)localObject1).getMethod("remove", new Class[] { SSLSocket.class }), (Class)localObject3, (Class)localObject4);
      return localObject1;
    }
    catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException)
    {
      label157:
      break label157;
    }
    return null;
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket)
  {
    try
    {
      this.removeMethod.invoke(null, new Object[] { paramSSLSocket });
      return;
    }
    catch (InvocationTargetException paramSSLSocket) {}catch (IllegalAccessException paramSSLSocket) {}
    throw Util.assertionError("unable to remove alpn", paramSSLSocket);
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    Object localObject = alpnProtocolNames(paramList);
    try
    {
      paramString = Platform.class.getClassLoader();
      paramList = this.clientProviderClass;
      Class localClass = this.serverProviderClass;
      localObject = new JdkWithJettyBootPlatform.JettyNegoProvider((List)localObject);
      paramString = Proxy.newProxyInstance(paramString, new Class[] { paramList, localClass }, (InvocationHandler)localObject);
      this.putMethod.invoke(null, new Object[] { paramSSLSocket, paramString });
      return;
    }
    catch (IllegalAccessException paramSSLSocket) {}catch (InvocationTargetException paramSSLSocket) {}
    throw Util.assertionError("unable to set alpn", paramSSLSocket);
  }
  
  @Nullable
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    try
    {
      paramSSLSocket = (JdkWithJettyBootPlatform.JettyNegoProvider)Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[] { paramSSLSocket }));
      if ((!paramSSLSocket.unsupported) && (paramSSLSocket.selected == null))
      {
        Platform.get().log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
        return null;
      }
      if (paramSSLSocket.unsupported) {
        return null;
      }
      paramSSLSocket = paramSSLSocket.selected;
      return paramSSLSocket;
    }
    catch (IllegalAccessException paramSSLSocket) {}catch (InvocationTargetException paramSSLSocket) {}
    throw Util.assertionError("unable to get selected protocol", paramSSLSocket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.platform.JdkWithJettyBootPlatform
 * JD-Core Version:    0.7.0.1
 */