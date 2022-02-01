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
    if (paramString1.startsWith("*."))
    {
      paramString1 = HttpUrl.get("http://" + paramString1.substring("*.".length())).host();
      this.canonicalHostname = paramString1;
      if (!paramString2.startsWith("sha1/")) {
        break label151;
      }
      this.hashAlgorithm = "sha1/";
      this.hash = ByteString.decodeBase64(paramString2.substring("sha1/".length()));
    }
    for (;;)
    {
      if (this.hash == null)
      {
        throw new IllegalArgumentException("pins must be base64: " + paramString2);
        paramString1 = HttpUrl.get("http://" + paramString1).host();
        break;
        label151:
        if (paramString2.startsWith("sha256/"))
        {
          this.hashAlgorithm = "sha256/";
          this.hash = ByteString.decodeBase64(paramString2.substring("sha256/".length()));
        }
        else
        {
          throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + paramString2);
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Pin)) && (this.pattern.equals(((Pin)paramObject).pattern)) && (this.hashAlgorithm.equals(((Pin)paramObject).hashAlgorithm)) && (this.hash.equals(((Pin)paramObject).hash));
  }
  
  public int hashCode()
  {
    return ((this.pattern.hashCode() + 527) * 31 + this.hashAlgorithm.hashCode()) * 31 + this.hash.hashCode();
  }
  
  boolean matches(String paramString)
  {
    boolean bool2 = false;
    if (this.pattern.startsWith("*."))
    {
      int i = paramString.indexOf('.');
      boolean bool1 = bool2;
      if (paramString.length() - i - 1 == this.canonicalHostname.length())
      {
        bool1 = bool2;
        if (paramString.regionMatches(false, i + 1, this.canonicalHostname, 0, this.canonicalHostname.length())) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return paramString.equals(this.canonicalHostname);
  }
  
  public String toString()
  {
    return this.hashAlgorithm + this.hash.base64();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.CertificatePinner.Pin
 * JD-Core Version:    0.7.0.1
 */