package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

public final class ConnectionSpec
{
  private static final CipherSuite[] APPROVED_CIPHER_SUITES;
  public static final ConnectionSpec CLEARTEXT = new ConnectionSpec.Builder(false).build();
  public static final ConnectionSpec COMPATIBLE_TLS;
  public static final ConnectionSpec MODERN_TLS;
  private static final CipherSuite[] RESTRICTED_CIPHER_SUITES = { CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_AES_128_CCM_SHA256, CipherSuite.TLS_AES_256_CCM_8_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 };
  public static final ConnectionSpec RESTRICTED_TLS;
  @Nullable
  final String[] cipherSuites;
  final boolean supportsTlsExtensions;
  final boolean tls;
  @Nullable
  final String[] tlsVersions;
  
  static
  {
    APPROVED_CIPHER_SUITES = new CipherSuite[] { CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_AES_128_CCM_SHA256, CipherSuite.TLS_AES_256_CCM_8_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA };
    RESTRICTED_TLS = new ConnectionSpec.Builder(true).cipherSuites(RESTRICTED_CIPHER_SUITES).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_3, TlsVersion.TLS_1_2 }).supportsTlsExtensions(true).build();
    MODERN_TLS = new ConnectionSpec.Builder(true).cipherSuites(APPROVED_CIPHER_SUITES).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
    COMPATIBLE_TLS = new ConnectionSpec.Builder(true).cipherSuites(APPROVED_CIPHER_SUITES).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
  }
  
  ConnectionSpec(ConnectionSpec.Builder paramBuilder)
  {
    this.tls = paramBuilder.tls;
    this.cipherSuites = paramBuilder.cipherSuites;
    this.tlsVersions = paramBuilder.tlsVersions;
    this.supportsTlsExtensions = paramBuilder.supportsTlsExtensions;
  }
  
  private ConnectionSpec supportedSpec(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    String[] arrayOfString1;
    if (this.cipherSuites != null) {
      arrayOfString1 = Util.intersect(CipherSuite.ORDER_BY_NAME, paramSSLSocket.getEnabledCipherSuites(), this.cipherSuites);
    } else {
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
    }
    String[] arrayOfString2;
    if (this.tlsVersions != null) {
      arrayOfString2 = Util.intersect(Util.NATURAL_ORDER, paramSSLSocket.getEnabledProtocols(), this.tlsVersions);
    } else {
      arrayOfString2 = paramSSLSocket.getEnabledProtocols();
    }
    String[] arrayOfString3 = paramSSLSocket.getSupportedCipherSuites();
    int i = Util.indexOf(CipherSuite.ORDER_BY_NAME, arrayOfString3, "TLS_FALLBACK_SCSV");
    paramSSLSocket = arrayOfString1;
    if (paramBoolean)
    {
      paramSSLSocket = arrayOfString1;
      if (i != -1) {
        paramSSLSocket = Util.concat(arrayOfString1, arrayOfString3[i]);
      }
    }
    return new ConnectionSpec.Builder(this).cipherSuites(paramSSLSocket).tlsVersions(arrayOfString2).build();
  }
  
  void apply(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    Object localObject = supportedSpec(paramSSLSocket, paramBoolean);
    String[] arrayOfString = ((ConnectionSpec)localObject).tlsVersions;
    if (arrayOfString != null) {
      paramSSLSocket.setEnabledProtocols(arrayOfString);
    }
    localObject = ((ConnectionSpec)localObject).cipherSuites;
    if (localObject != null) {
      paramSSLSocket.setEnabledCipherSuites((String[])localObject);
    }
  }
  
  @Nullable
  public List<CipherSuite> cipherSuites()
  {
    String[] arrayOfString = this.cipherSuites;
    if (arrayOfString != null) {
      return CipherSuite.forJavaNames(arrayOfString);
    }
    return null;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof ConnectionSpec)) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    paramObject = (ConnectionSpec)paramObject;
    boolean bool = this.tls;
    if (bool != paramObject.tls) {
      return false;
    }
    if (bool)
    {
      if (!Arrays.equals(this.cipherSuites, paramObject.cipherSuites)) {
        return false;
      }
      if (!Arrays.equals(this.tlsVersions, paramObject.tlsVersions)) {
        return false;
      }
      if (this.supportsTlsExtensions != paramObject.supportsTlsExtensions) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    if (this.tls) {
      return ((527 + Arrays.hashCode(this.cipherSuites)) * 31 + Arrays.hashCode(this.tlsVersions)) * 31 + (this.supportsTlsExtensions ^ true);
    }
    return 17;
  }
  
  public boolean isCompatible(SSLSocket paramSSLSocket)
  {
    if (!this.tls) {
      return false;
    }
    if ((this.tlsVersions != null) && (!Util.nonEmptyIntersection(Util.NATURAL_ORDER, this.tlsVersions, paramSSLSocket.getEnabledProtocols()))) {
      return false;
    }
    return (this.cipherSuites == null) || (Util.nonEmptyIntersection(CipherSuite.ORDER_BY_NAME, this.cipherSuites, paramSSLSocket.getEnabledCipherSuites()));
  }
  
  public boolean isTls()
  {
    return this.tls;
  }
  
  public boolean supportsTlsExtensions()
  {
    return this.supportsTlsExtensions;
  }
  
  @Nullable
  public List<TlsVersion> tlsVersions()
  {
    String[] arrayOfString = this.tlsVersions;
    if (arrayOfString != null) {
      return TlsVersion.forJavaNames(arrayOfString);
    }
    return null;
  }
  
  public String toString()
  {
    if (!this.tls) {
      return "ConnectionSpec()";
    }
    Object localObject = this.cipherSuites;
    String str = "[all enabled]";
    if (localObject != null) {
      localObject = cipherSuites().toString();
    } else {
      localObject = "[all enabled]";
    }
    if (this.tlsVersions != null) {
      str = tlsVersions().toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConnectionSpec(cipherSuites=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", tlsVersions=");
    localStringBuilder.append(str);
    localStringBuilder.append(", supportsTlsExtensions=");
    localStringBuilder.append(this.supportsTlsExtensions);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.ConnectionSpec
 * JD-Core Version:    0.7.0.1
 */