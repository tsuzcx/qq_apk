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
    if (paramString == null) {
      throw new NullPointerException("domain == null");
    }
    String str = Util.canonicalizeHost(paramString);
    if (str == null) {
      throw new IllegalArgumentException("unexpected domain: " + paramString);
    }
    this.domain = str;
    this.hostOnly = paramBoolean;
    return this;
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
    long l = 253402300799999L;
    if (paramLong <= 0L) {
      paramLong = -9223372036854775808L;
    }
    for (;;)
    {
      if (paramLong > 253402300799999L) {
        paramLong = l;
      }
      for (;;)
      {
        this.expiresAt = paramLong;
        this.persistent = true;
        return this;
      }
    }
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
    if (paramString == null) {
      throw new NullPointerException("name == null");
    }
    if (!paramString.trim().equals(paramString)) {
      throw new IllegalArgumentException("name is not trimmed");
    }
    this.name = paramString;
    return this;
  }
  
  public Builder path(String paramString)
  {
    if (!paramString.startsWith("/")) {
      throw new IllegalArgumentException("path must start with '/'");
    }
    this.path = paramString;
    return this;
  }
  
  public Builder secure()
  {
    this.secure = true;
    return this;
  }
  
  public Builder value(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("value == null");
    }
    if (!paramString.trim().equals(paramString)) {
      throw new IllegalArgumentException("value is not trimmed");
    }
    this.value = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.Cookie.Builder
 * JD-Core Version:    0.7.0.1
 */