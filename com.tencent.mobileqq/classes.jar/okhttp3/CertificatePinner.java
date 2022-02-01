package okhttp3;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.security.cert.Certificate;>;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

public final class CertificatePinner
{
  public static final CertificatePinner DEFAULT = new CertificatePinner.Builder().build();
  @Nullable
  private final CertificateChainCleaner certificateChainCleaner;
  private final Set<CertificatePinner.Pin> pins;
  
  CertificatePinner(Set<CertificatePinner.Pin> paramSet, @Nullable CertificateChainCleaner paramCertificateChainCleaner)
  {
    this.pins = paramSet;
    this.certificateChainCleaner = paramCertificateChainCleaner;
  }
  
  public static String pin(Certificate paramCertificate)
  {
    if ((paramCertificate instanceof X509Certificate))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sha256/");
      localStringBuilder.append(sha256((X509Certificate)paramCertificate).base64());
      return localStringBuilder.toString();
    }
    throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
  }
  
  static ByteString sha1(X509Certificate paramX509Certificate)
  {
    return ByteString.of(paramX509Certificate.getPublicKey().getEncoded()).sha1();
  }
  
  static ByteString sha256(X509Certificate paramX509Certificate)
  {
    return ByteString.of(paramX509Certificate.getPublicKey().getEncoded()).sha256();
  }
  
  public void check(String paramString, List<Certificate> paramList)
  {
    List localList = findMatchingPins(paramString);
    if (localList.isEmpty()) {
      return;
    }
    Object localObject1 = this.certificateChainCleaner;
    Object localObject3 = paramList;
    if (localObject1 != null) {
      localObject3 = ((CertificateChainCleaner)localObject1).clean(paramList, paramString);
    }
    int m = ((List)localObject3).size();
    int k = 0;
    int i = 0;
    while (i < m)
    {
      X509Certificate localX509Certificate = (X509Certificate)((List)localObject3).get(i);
      int n = localList.size();
      localObject1 = null;
      paramList = (List<Certificate>)localObject1;
      j = 0;
      while (j < n)
      {
        CertificatePinner.Pin localPin = (CertificatePinner.Pin)localList.get(j);
        Object localObject2;
        if (localPin.hashAlgorithm.equals("sha256/"))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = sha256(localX509Certificate);
          }
          localObject1 = localObject2;
          if (!localPin.hash.equals(localObject2)) {}
        }
        else
        {
          if (!localPin.hashAlgorithm.equals("sha1/")) {
            break label213;
          }
          localObject2 = paramList;
          if (paramList == null) {
            localObject2 = sha1(localX509Certificate);
          }
          paramList = (List<Certificate>)localObject2;
          if (localPin.hash.equals(localObject2)) {
            return;
          }
        }
        j += 1;
        continue;
        label213:
        paramString = new StringBuilder();
        paramString.append("unsupported hashAlgorithm: ");
        paramString.append(localPin.hashAlgorithm);
        throw new AssertionError(paramString.toString());
      }
      i += 1;
    }
    paramList = new StringBuilder();
    paramList.append("Certificate pinning failure!");
    paramList.append("\n  Peer certificate chain:");
    int j = ((List)localObject3).size();
    i = 0;
    while (i < j)
    {
      localObject1 = (X509Certificate)((List)localObject3).get(i);
      paramList.append("\n    ");
      paramList.append(pin((Certificate)localObject1));
      paramList.append(": ");
      paramList.append(((X509Certificate)localObject1).getSubjectDN().getName());
      i += 1;
    }
    paramList.append("\n  Pinned certificates for ");
    paramList.append(paramString);
    paramList.append(":");
    j = localList.size();
    i = k;
    while (i < j)
    {
      paramString = (CertificatePinner.Pin)localList.get(i);
      paramList.append("\n    ");
      paramList.append(paramString);
      i += 1;
    }
    paramString = new SSLPeerUnverifiedException(paramList.toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void check(String paramString, Certificate... paramVarArgs)
  {
    check(paramString, Arrays.asList(paramVarArgs));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CertificatePinner))
    {
      CertificateChainCleaner localCertificateChainCleaner = this.certificateChainCleaner;
      paramObject = (CertificatePinner)paramObject;
      if ((Util.equal(localCertificateChainCleaner, paramObject.certificateChainCleaner)) && (this.pins.equals(paramObject.pins))) {
        return true;
      }
    }
    return false;
  }
  
  List<CertificatePinner.Pin> findMatchingPins(String paramString)
  {
    Object localObject1 = Collections.emptyList();
    Iterator localIterator = this.pins.iterator();
    while (localIterator.hasNext())
    {
      CertificatePinner.Pin localPin = (CertificatePinner.Pin)localIterator.next();
      if (localPin.matches(paramString))
      {
        Object localObject2 = localObject1;
        if (((List)localObject1).isEmpty()) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).add(localPin);
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  public int hashCode()
  {
    CertificateChainCleaner localCertificateChainCleaner = this.certificateChainCleaner;
    int i;
    if (localCertificateChainCleaner != null) {
      i = localCertificateChainCleaner.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + this.pins.hashCode();
  }
  
  CertificatePinner withCertificateChainCleaner(@Nullable CertificateChainCleaner paramCertificateChainCleaner)
  {
    if (Util.equal(this.certificateChainCleaner, paramCertificateChainCleaner)) {
      return this;
    }
    return new CertificatePinner(this.pins, paramCertificateChainCleaner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.CertificatePinner
 * JD-Core Version:    0.7.0.1
 */