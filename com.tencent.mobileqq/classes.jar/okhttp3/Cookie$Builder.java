package okhttp3;

import javax.annotation.Nullable;
import okhttp3.internal.Util;

public final class Cookie$Builder
{
  @Nullable
  String domain;
  long expiresAt = 253402300799999L;
  boolean hostOnly;
  boolean httpOnly;
  @Nullable
  String name;
  String path = "/";
  boolean persistent;
  boolean secure;
  @Nullable
  String value;
  
  private Builder domain(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      Object localObject = Util.canonicalizeHost(paramString);
      if (localObject != null)
      {
        this.domain = ((String)localObject);
        this.hostOnly = paramBoolean;
        return this;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unexpected domain: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new NullPointerException("domain == null");
  }
  
  public Cookie build()
  {
    return new Cookie(this);
  }
  
  public Builder domain(String paramString)
  {
    return domain(paramString, false);
  }
  
  public Builder expiresAt(long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = -9223372036854775808L;
    }
    paramLong = l;
    if (l > 253402300799999L) {
      paramLong = 253402300799999L;
    }
    this.expiresAt = paramLong;
    this.persistent = true;
    return this;
  }
  
  public Builder hostOnlyDomain(String paramString)
  {
    return domain(paramString, true);
  }
  
  public Builder httpOnly()
  {
    this.httpOnly = true;
    return this;
  }
  
  public Builder name(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.trim().equals(paramString))
      {
        this.name = paramString;
        return this;
      }
      throw new IllegalArgumentException("name is not trimmed");
    }
    throw new NullPointerException("name == null");
  }
  
  public Builder path(String paramString)
  {
    if (paramString.startsWith("/"))
    {
      this.path = paramString;
      return this;
    }
    throw new IllegalArgumentException("path must start with '/'");
  }
  
  public Builder secure()
  {
    this.secure = true;
    return this;
  }
  
  public Builder value(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.trim().equals(paramString))
      {
        this.value = paramString;
        return this;
      }
      throw new IllegalArgumentException("value is not trimmed");
    }
    throw new NullPointerException("value == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.Cookie.Builder
 * JD-Core Version:    0.7.0.1
 */