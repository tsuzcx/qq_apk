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
    if (this.cipherSuites != null)
    {
      arrayOfString1 = Util.intersect(CipherSuite.ORDER_BY_NAME, paramSSLSocket.getEnabledCipherSuites(), this.cipherSuites);
      if (this.tlsVersions == null) {
        break label118;
      }
    }
    label118:
    for (String[] arrayOfString2 = Util.intersect(Util.NATURAL_ORDER, paramSSLSocket.getEnabledProtocols(), this.tlsVersions);; arrayOfString2 = paramSSLSocket.getEnabledProtocols())
    {
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
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
      break;
    }
  }
  
  void apply(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    ConnectionSpec localConnectionSpec = supportedSpec(paramSSLSocket, paramBoolean);
    if (localConnectionSpec.tlsVersions != null) {
      paramSSLSocket.setEnabledProtocols(localConnectionSpec.tlsVersions);
    }
    if (localConnectionSpec.cipherSuites != null) {
      paramSSLSocket.setEnabledCipherSuites(localConnectionSpec.cipherSuites);
    }
  }
  
  @Nullable
  public List<CipherSuite> cipherSuites()
  {
    if (this.cipherSuites != null) {
      return CipherSuite.forJavaNames(this.cipherSuites);
    }
    return null;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof ConnectionSpec)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (ConnectionSpec)paramObject;
    } while ((this.tls != paramObject.tls) || ((this.tls) && ((!Arrays.equals(this.cipherSuites, paramObject.cipherSuites)) || (!Arrays.equals(this.tlsVersions, paramObject.tlsVersions)) || (this.supportsTlsExtensions != paramObject.supportsTlsExtensions))));
    return true;
  }
  
  public int hashCode()
  {
    int i = 17;
    int j;
    int k;
    if (this.tls)
    {
      j = Arrays.hashCode(this.cipherSuites);
      k = Arrays.hashCode(this.tlsVersions);
      if (!this.supportsTlsExtensions) {
        break label53;
      }
    }
    label53:
    for (i = 0;; i = 1)
    {
      i += ((j + 527) * 31 + k) * 31;
      return i;
    }
  }
  
  public boolean isCompatible(SSLSocket paramSSLSocket)
  {
    if (!this.tls) {}
    while (((this.tlsVersions != null) && (!Util.nonEmptyIntersection(Util.NATURAL_ORDER, this.tlsVersions, paramSSLSocket.getEnabledProtocols()))) || ((this.cipherSuites != null) && (!Util.nonEmptyIntersection(CipherSuite.ORDER_BY_NAME, this.cipherSuites, paramSSLSocket.getEnabledCipherSuites())))) {
      return false;
    }
    return true;
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
    if (this.tlsVersions != null) {
      return TlsVersion.forJavaNames(this.tlsVersions);
    }
    return null;
  }
  
  public String toString()
  {
    if (!this.tls) {
      return "ConnectionSpec()";
    }
    String str1;
    if (this.cipherSuites != null)
    {
      str1 = cipherSuites().toString();
      if (this.tlsVersions == null) {
        break label93;
      }
    }
    label93:
    for (String str2 = tlsVersions().toString();; str2 = "[all enabled]")
    {
      return "ConnectionSpec(cipherSuites=" + str1 + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
      str1 = "[all enabled]";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.ConnectionSpec
 * JD-Core Version:    0.7.0.1
 */