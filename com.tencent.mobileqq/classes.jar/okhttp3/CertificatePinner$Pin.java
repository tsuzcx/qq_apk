package okhttp3;

import okio.ByteString;

final class CertificatePinner$Pin
{
  private static final String WILDCARD = "*.";
  final String canonicalHostname;
  final ByteString hash;
  final String hashAlgorithm;
  final String pattern;
  
  CertificatePinner$Pin(String paramString1, String paramString2)
  {
    this.pattern = paramString1;
    StringBuilder localStringBuilder;
    if (paramString1.startsWith("*."))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://");
      localStringBuilder.append(paramString1.substring(2));
      paramString1 = HttpUrl.get(localStringBuilder.toString()).host();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://");
      localStringBuilder.append(paramString1);
      paramString1 = HttpUrl.get(localStringBuilder.toString()).host();
    }
    this.canonicalHostname = paramString1;
    if (paramString2.startsWith("sha1/"))
    {
      this.hashAlgorithm = "sha1/";
      this.hash = ByteString.decodeBase64(paramString2.substring(5));
    }
    else
    {
      if (!paramString2.startsWith("sha256/")) {
        break label193;
      }
      this.hashAlgorithm = "sha256/";
      this.hash = ByteString.decodeBase64(paramString2.substring(7));
    }
    if (this.hash != null) {
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("pins must be base64: ");
    paramString1.append(paramString2);
    throw new IllegalArgumentException(paramString1.toString());
    label193:
    paramString1 = new StringBuilder();
    paramString1.append("pins must start with 'sha256/' or 'sha1/': ");
    paramString1.append(paramString2);
    throw new IllegalArgumentException(paramString1.toString());
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Pin))
    {
      String str = this.pattern;
      paramObject = (Pin)paramObject;
      if ((str.equals(paramObject.pattern)) && (this.hashAlgorithm.equals(paramObject.hashAlgorithm)) && (this.hash.equals(paramObject.hash))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((527 + this.pattern.hashCode()) * 31 + this.hashAlgorithm.hashCode()) * 31 + this.hash.hashCode();
  }
  
  boolean matches(String paramString)
  {
    if (this.pattern.startsWith("*."))
    {
      int i = paramString.indexOf('.');
      if (paramString.length() - i - 1 == this.canonicalHostname.length())
      {
        String str = this.canonicalHostname;
        if (paramString.regionMatches(false, i + 1, str, 0, str.length())) {
          return true;
        }
      }
      return false;
    }
    return paramString.equals(this.canonicalHostname);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.hashAlgorithm);
    localStringBuilder.append(this.hash.base64());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.CertificatePinner.Pin
 * JD-Core Version:    0.7.0.1
 */