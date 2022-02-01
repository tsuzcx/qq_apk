package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Internal;

public final class ConnectionSpecSelector
{
  private final List<ConnectionSpec> connectionSpecs;
  private boolean isFallback;
  private boolean isFallbackPossible;
  private int nextModeIndex = 0;
  
  public ConnectionSpecSelector(List<ConnectionSpec> paramList)
  {
    this.connectionSpecs = paramList;
  }
  
  private boolean isFallbackPossible(SSLSocket paramSSLSocket)
  {
    int i = this.nextModeIndex;
    while (i < this.connectionSpecs.size())
    {
      if (((ConnectionSpec)this.connectionSpecs.get(i)).isCompatible(paramSSLSocket)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public ConnectionSpec configureSecureSocket(SSLSocket paramSSLSocket)
  {
    int i = this.nextModeIndex;
    int j = this.connectionSpecs.size();
    while (i < j)
    {
      localObject = (ConnectionSpec)this.connectionSpecs.get(i);
      if (((ConnectionSpec)localObject).isCompatible(paramSSLSocket))
      {
        this.nextModeIndex = (i + 1);
        break label64;
      }
      i += 1;
    }
    Object localObject = null;
    label64:
    if (localObject != null)
    {
      this.isFallbackPossible = isFallbackPossible(paramSSLSocket);
      Internal.instance.apply((ConnectionSpec)localObject, paramSSLSocket, this.isFallback);
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unable to find acceptable protocols. isFallback=");
    ((StringBuilder)localObject).append(this.isFallback);
    ((StringBuilder)localObject).append(", modes=");
    ((StringBuilder)localObject).append(this.connectionSpecs);
    ((StringBuilder)localObject).append(", supported protocols=");
    ((StringBuilder)localObject).append(Arrays.toString(paramSSLSocket.getEnabledProtocols()));
    paramSSLSocket = new UnknownServiceException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramSSLSocket;
    }
  }
  
  public boolean connectionFailed(IOException paramIOException)
  {
    boolean bool2 = true;
    this.isFallback = true;
    if (!this.isFallbackPossible) {
      return false;
    }
    if ((paramIOException instanceof ProtocolException)) {
      return false;
    }
    if ((paramIOException instanceof InterruptedIOException)) {
      return false;
    }
    boolean bool3 = paramIOException instanceof SSLHandshakeException;
    if ((bool3) && ((paramIOException.getCause() instanceof CertificateException))) {
      return false;
    }
    if ((paramIOException instanceof SSLPeerUnverifiedException)) {
      return false;
    }
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!(paramIOException instanceof SSLProtocolException))
      {
        if ((paramIOException instanceof SSLException)) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.connection.ConnectionSpecSelector
 * JD-Core Version:    0.7.0.1
 */