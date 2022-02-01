package okhttp3.internal.tls;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

public final class OkHostnameVerifier
  implements HostnameVerifier
{
  private static final int ALT_DNS_NAME = 2;
  private static final int ALT_IPA_NAME = 7;
  public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();
  
  public static List<String> allSubjectAltNames(X509Certificate paramX509Certificate)
  {
    List localList = getSubjectAltNames(paramX509Certificate, 7);
    paramX509Certificate = getSubjectAltNames(paramX509Certificate, 2);
    ArrayList localArrayList = new ArrayList(localList.size() + paramX509Certificate.size());
    localArrayList.addAll(localList);
    localArrayList.addAll(paramX509Certificate);
    return localArrayList;
  }
  
  private static List<String> getSubjectAltNames(X509Certificate paramX509Certificate, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
      if (paramX509Certificate == null) {
        return Collections.emptyList();
      }
      paramX509Certificate = paramX509Certificate.iterator();
      while (paramX509Certificate.hasNext())
      {
        Object localObject = (List)paramX509Certificate.next();
        if ((localObject != null) && (((List)localObject).size() >= 2))
        {
          Integer localInteger = (Integer)((List)localObject).get(0);
          if ((localInteger != null) && (localInteger.intValue() == paramInt))
          {
            localObject = (String)((List)localObject).get(1);
            if (localObject != null) {
              localArrayList.add(localObject);
            }
          }
        }
      }
      return localArrayList;
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      label121:
      break label121;
    }
    return Collections.emptyList();
  }
  
  private boolean verifyHostname(String paramString, X509Certificate paramX509Certificate)
  {
    paramString = paramString.toLowerCase(Locale.US);
    paramX509Certificate = getSubjectAltNames(paramX509Certificate, 2).iterator();
    while (paramX509Certificate.hasNext()) {
      if (verifyHostname(paramString, (String)paramX509Certificate.next())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean verifyIpAddress(String paramString, X509Certificate paramX509Certificate)
  {
    paramX509Certificate = getSubjectAltNames(paramX509Certificate, 7);
    int j = paramX509Certificate.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equalsIgnoreCase((String)paramX509Certificate.get(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean verify(String paramString, X509Certificate paramX509Certificate)
  {
    if (Util.verifyAsIpAddress(paramString)) {
      return verifyIpAddress(paramString, paramX509Certificate);
    }
    return verifyHostname(paramString, paramX509Certificate);
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      boolean bool = verify(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      return bool;
    }
    catch (SSLException paramString) {}
    return false;
  }
  
  public boolean verifyHostname(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (!paramString1.startsWith(".")))
    {
      if (paramString1.endsWith("..")) {
        return false;
      }
      if ((paramString2 != null) && (paramString2.length() != 0) && (!paramString2.startsWith(".")))
      {
        if (paramString2.endsWith("..")) {
          return false;
        }
        Object localObject = paramString1;
        if (!paramString1.endsWith("."))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append('.');
          localObject = ((StringBuilder)localObject).toString();
        }
        paramString1 = paramString2;
        if (!paramString2.endsWith("."))
        {
          paramString1 = new StringBuilder();
          paramString1.append(paramString2);
          paramString1.append('.');
          paramString1 = paramString1.toString();
        }
        paramString1 = paramString1.toLowerCase(Locale.US);
        if (!paramString1.contains("*")) {
          return ((String)localObject).equals(paramString1);
        }
        if (paramString1.startsWith("*."))
        {
          if (paramString1.indexOf('*', 1) != -1) {
            return false;
          }
          if (((String)localObject).length() < paramString1.length()) {
            return false;
          }
          if ("*.".equals(paramString1)) {
            return false;
          }
          paramString1 = paramString1.substring(1);
          if (!((String)localObject).endsWith(paramString1)) {
            return false;
          }
          int i = ((String)localObject).length() - paramString1.length();
          return (i <= 0) || (((String)localObject).lastIndexOf('.', i - 1) == -1);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.tls.OkHostnameVerifier
 * JD-Core Version:    0.7.0.1
 */