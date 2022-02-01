package okhttp3.internal.platform;

import android.os.Build.VERSION;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

class AndroidPlatform
  extends Platform
{
  private static final int MAX_LOG_LENGTH = 4000;
  private final AndroidPlatform.CloseGuard closeGuard = AndroidPlatform.CloseGuard.get();
  private final OptionalMethod<Socket> getAlpnSelectedProtocol;
  private final OptionalMethod<Socket> setAlpnProtocols;
  private final OptionalMethod<Socket> setHostname;
  private final OptionalMethod<Socket> setUseSessionTickets;
  private final Class<?> sslParametersClass;
  
  AndroidPlatform(Class<?> paramClass, OptionalMethod<Socket> paramOptionalMethod1, OptionalMethod<Socket> paramOptionalMethod2, OptionalMethod<Socket> paramOptionalMethod3, OptionalMethod<Socket> paramOptionalMethod4)
  {
    this.sslParametersClass = paramClass;
    this.setUseSessionTickets = paramOptionalMethod1;
    this.setHostname = paramOptionalMethod2;
    this.getAlpnSelectedProtocol = paramOptionalMethod3;
    this.setAlpnProtocols = paramOptionalMethod4;
  }
  
  private boolean api23IsCleartextTrafficPermitted(String paramString, Class<?> paramClass, Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException paramClass)
    {
      label29:
      break label29;
    }
    return super.isCleartextTrafficPermitted(paramString);
  }
  
  private boolean api24IsCleartextTrafficPermitted(String paramString, Class<?> paramClass, Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[] { String.class }).invoke(paramObject, new Object[] { paramString })).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label38:
      break label38;
    }
    return api23IsCleartextTrafficPermitted(paramString, paramClass, paramObject);
  }
  
  public static Platform buildIfSupported()
  {
    if (getSdkInt() == 0) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        Object localObject;
        OptionalMethod localOptionalMethod3;
        OptionalMethod localOptionalMethod4;
        continue;
      }
      try
      {
        localObject = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        return null;
      }
    }
    localOptionalMethod3 = new OptionalMethod(null, "setUseSessionTickets", new Class[] { Boolean.TYPE });
    localOptionalMethod4 = new OptionalMethod(null, "setHostname", new Class[] { String.class });
    OptionalMethod localOptionalMethod1;
    OptionalMethod localOptionalMethod2;
    if (supportsAlpn())
    {
      localOptionalMethod1 = new OptionalMethod([B.class, "getAlpnSelectedProtocol", new Class[0]);
      localOptionalMethod2 = new OptionalMethod(null, "setAlpnProtocols", new Class[] { [B.class });
    }
    for (;;)
    {
      localObject = new AndroidPlatform((Class)localObject, localOptionalMethod3, localOptionalMethod4, localOptionalMethod1, localOptionalMethod2);
      return localObject;
      localOptionalMethod1 = null;
      localOptionalMethod2 = localOptionalMethod1;
    }
  }
  
  static int getSdkInt()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      label6:
      break label6;
    }
    return 0;
  }
  
  private static boolean supportsAlpn()
  {
    if (Security.getProvider("GMSCore_OpenSSL") != null) {
      return true;
    }
    try
    {
      Class.forName("android.net.Network");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label18:
      break label18;
    }
    return false;
  }
  
  public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Object localObject = Class.forName("android.net.http.X509TrustManagerExtensions");
      localObject = new AndroidPlatform.AndroidCertificateChainCleaner(((Class)localObject).getConstructor(new Class[] { X509TrustManager.class }).newInstance(new Object[] { paramX509TrustManager }), ((Class)localObject).getMethod("checkServerTrusted", new Class[] { [Ljava.security.cert.X509Certificate.class, String.class, String.class }));
      return localObject;
    }
    catch (Exception localException)
    {
      label65:
      break label65;
    }
    return super.buildCertificateChainCleaner(paramX509TrustManager);
  }
  
  public TrustRootIndex buildTrustRootIndex(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Object localObject = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      ((Method)localObject).setAccessible(true);
      localObject = new AndroidPlatform.AndroidTrustRootIndex(paramX509TrustManager, (Method)localObject);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label36:
      break label36;
    }
    return super.buildTrustRootIndex(paramX509TrustManager);
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    if (paramString != null)
    {
      this.setUseSessionTickets.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
      this.setHostname.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
    }
    paramString = this.setAlpnProtocols;
    if ((paramString != null) && (paramString.isSupported(paramSSLSocket)))
    {
      paramString = concatLengthPrefixed(paramList);
      this.setAlpnProtocols.invokeWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
    }
  }
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    try
    {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
    }
    catch (ClassCastException paramSocket)
    {
      if (Build.VERSION.SDK_INT == 26)
      {
        paramInetSocketAddress = new IOException("Exception in connect");
        paramInetSocketAddress.initCause(paramSocket);
        throw paramInetSocketAddress;
      }
      throw paramSocket;
    }
    catch (SecurityException paramSocket)
    {
      paramInetSocketAddress = new IOException("Exception in connect");
      paramInetSocketAddress.initCause(paramSocket);
      throw paramInetSocketAddress;
    }
    catch (AssertionError paramSocket)
    {
      if (Util.isAndroidGetsocknameError(paramSocket)) {
        throw new IOException(paramSocket);
      }
      throw paramSocket;
    }
  }
  
  public SSLContext getSSLContext()
  {
    int i = 1;
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        int j = Build.VERSION.SDK_INT;
        if (j < 22) {}
      }
      else
      {
        i = 0;
      }
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      label25:
      break label25;
    }
    if (i != 0) {}
    for (;;)
    {
      try
      {
        localSSLContext = SSLContext.getInstance("TLSv1.2");
        return localSSLContext;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
      {
        SSLContext localSSLContext;
        continue;
      }
      try
      {
        localSSLContext = SSLContext.getInstance("TLS");
        return localSSLContext;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
      {
        throw new IllegalStateException("No TLS provider", localNoSuchAlgorithmException1);
      }
    }
  }
  
  @Nullable
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    Object localObject2 = this.getAlpnSelectedProtocol;
    Object localObject1 = null;
    if (localObject2 == null) {
      return null;
    }
    if (!((OptionalMethod)localObject2).isSupported(paramSSLSocket)) {
      return null;
    }
    localObject2 = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(paramSSLSocket, new Object[0]);
    paramSSLSocket = localObject1;
    if (localObject2 != null) {
      paramSSLSocket = new String((byte[])localObject2, Util.UTF_8);
    }
    return paramSSLSocket;
  }
  
  public Object getStackTraceForCloseable(String paramString)
  {
    return this.closeGuard.createAndOpen(paramString);
  }
  
  public boolean isCleartextTrafficPermitted(String paramString)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return super.isCleartextTrafficPermitted(paramString);
    }
    try
    {
      try
      {
        Class localClass = Class.forName("android.security.NetworkSecurityPolicy");
        boolean bool = api24IsCleartextTrafficPermitted(paramString, localClass, localClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        return bool;
      }
      catch (InvocationTargetException paramString) {}catch (IllegalArgumentException paramString) {}catch (IllegalAccessException paramString) {}
      throw Util.assertionError("unable to determine cleartext support", paramString);
    }
    catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException)
    {
      label66:
      break label66;
    }
    return super.isCleartextTrafficPermitted(paramString);
  }
  
  public void log(int paramInt, String paramString, @Nullable Throwable paramThrowable)
  {
    int i = 5;
    if (paramInt != 5) {
      i = 3;
    }
    Object localObject = paramString;
    if (paramThrowable != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append('\n');
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramThrowable));
      localObject = ((StringBuilder)localObject).toString();
    }
    paramInt = 0;
    int k = ((String)localObject).length();
    if (paramInt < k)
    {
      int j = ((String)localObject).indexOf('\n', paramInt);
      if (j == -1) {
        j = k;
      }
      for (;;)
      {
        int m = Math.min(j, paramInt + 4000);
        Log.println(i, "OkHttp", ((String)localObject).substring(paramInt, m));
        if (m >= j)
        {
          paramInt = m + 1;
          break;
        }
        paramInt = m;
      }
    }
  }
  
  public void logCloseableLeak(String paramString, Object paramObject)
  {
    if (!this.closeGuard.warnIfOpen(paramObject)) {
      log(5, paramString, null);
    }
  }
  
  @Nullable
  protected X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    Object localObject2 = readFieldOrNull(paramSSLSocketFactory, this.sslParametersClass, "sslParameters");
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    try
    {
      localObject1 = readFieldOrNull(paramSSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, paramSSLSocketFactory.getClass().getClassLoader()), "sslParameters");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label43:
      break label43;
    }
    return super.trustManager(paramSSLSocketFactory);
    paramSSLSocketFactory = (X509TrustManager)readFieldOrNull(localObject1, X509TrustManager.class, "x509TrustManager");
    if (paramSSLSocketFactory != null) {
      return paramSSLSocketFactory;
    }
    return (X509TrustManager)readFieldOrNull(localObject1, X509TrustManager.class, "trustManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.platform.AndroidPlatform
 * JD-Core Version:    0.7.0.1
 */