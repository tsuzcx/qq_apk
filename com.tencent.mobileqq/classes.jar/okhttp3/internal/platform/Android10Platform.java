package okhttp3.internal.platform;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@SuppressLint({"NewApi"})
class Android10Platform
  extends AndroidPlatform
{
  Android10Platform(Class<?> paramClass)
  {
    super(paramClass, null, null, null, null);
  }
  
  @Nullable
  public static Platform buildIfSupported()
  {
    try
    {
      if (getSdkInt() >= 29)
      {
        Android10Platform localAndroid10Platform = new Android10Platform(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
        return localAndroid10Platform;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  private void enableSessionTickets(SSLSocket paramSSLSocket)
  {
    if (SSLSockets.isSupportedSocket(paramSSLSocket)) {
      SSLSockets.setUseSessionTickets(paramSSLSocket, true);
    }
  }
  
  @SuppressLint({"NewApi"})
  @IgnoreJRERequirement
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    enableSessionTickets(paramSSLSocket);
    paramString = paramSSLSocket.getSSLParameters();
    paramString.setApplicationProtocols((String[])Platform.alpnProtocolNames(paramList).toArray(new String[0]));
    paramSSLSocket.setSSLParameters(paramString);
  }
  
  @Nullable
  @IgnoreJRERequirement
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    String str = paramSSLSocket.getApplicationProtocol();
    if (str != null)
    {
      paramSSLSocket = str;
      if (!str.isEmpty()) {}
    }
    else
    {
      paramSSLSocket = null;
    }
    return paramSSLSocket;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.platform.Android10Platform
 * JD-Core Version:    0.7.0.1
 */