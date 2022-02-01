package okhttp3;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.http.HttpHeaders;

public final class CacheControl
{
  public static final CacheControl FORCE_CACHE = new CacheControl.Builder().onlyIfCached().maxStale(2147483647, TimeUnit.SECONDS).build();
  public static final CacheControl FORCE_NETWORK = new CacheControl.Builder().noCache().build();
  @Nullable
  String headerValue;
  private final boolean immutable;
  private final boolean isPrivate;
  private final boolean isPublic;
  private final int maxAgeSeconds;
  private final int maxStaleSeconds;
  private final int minFreshSeconds;
  private final boolean mustRevalidate;
  private final boolean noCache;
  private final boolean noStore;
  private final boolean noTransform;
  private final boolean onlyIfCached;
  private final int sMaxAgeSeconds;
  
  CacheControl(CacheControl.Builder paramBuilder)
  {
    this.noCache = paramBuilder.noCache;
    this.noStore = paramBuilder.noStore;
    this.maxAgeSeconds = paramBuilder.maxAgeSeconds;
    this.sMaxAgeSeconds = -1;
    this.isPrivate = false;
    this.isPublic = false;
    this.mustRevalidate = false;
    this.maxStaleSeconds = paramBuilder.maxStaleSeconds;
    this.minFreshSeconds = paramBuilder.minFreshSeconds;
    this.onlyIfCached = paramBuilder.onlyIfCached;
    this.noTransform = paramBuilder.noTransform;
    this.immutable = paramBuilder.immutable;
  }
  
  private CacheControl(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, @Nullable String paramString)
  {
    this.noCache = paramBoolean1;
    this.noStore = paramBoolean2;
    this.maxAgeSeconds = paramInt1;
    this.sMaxAgeSeconds = paramInt2;
    this.isPrivate = paramBoolean3;
    this.isPublic = paramBoolean4;
    this.mustRevalidate = paramBoolean5;
    this.maxStaleSeconds = paramInt3;
    this.minFreshSeconds = paramInt4;
    this.onlyIfCached = paramBoolean6;
    this.noTransform = paramBoolean7;
    this.immutable = paramBoolean8;
    this.headerValue = paramString;
  }
  
  private String headerValue()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.noCache) {
      localStringBuilder.append("no-cache, ");
    }
    if (this.noStore) {
      localStringBuilder.append("no-store, ");
    }
    if (this.maxAgeSeconds != -1) {
      localStringBuilder.append("max-age=").append(this.maxAgeSeconds).append(", ");
    }
    if (this.sMaxAgeSeconds != -1) {
      localStringBuilder.append("s-maxage=").append(this.sMaxAgeSeconds).append(", ");
    }
    if (this.isPrivate) {
      localStringBuilder.append("private, ");
    }
    if (this.isPublic) {
      localStringBuilder.append("public, ");
    }
    if (this.mustRevalidate) {
      localStringBuilder.append("must-revalidate, ");
    }
    if (this.maxStaleSeconds != -1) {
      localStringBuilder.append("max-stale=").append(this.maxStaleSeconds).append(", ");
    }
    if (this.minFreshSeconds != -1) {
      localStringBuilder.append("min-fresh=").append(this.minFreshSeconds).append(", ");
    }
    if (this.onlyIfCached) {
      localStringBuilder.append("only-if-cached, ");
    }
    if (this.noTransform) {
      localStringBuilder.append("no-transform, ");
    }
    if (this.immutable) {
      localStringBuilder.append("immutable, ");
    }
    if (localStringBuilder.length() == 0) {
      return "";
    }
    localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
    return localStringBuilder.toString();
  }
  
  public static CacheControl parse(Headers paramHeaders)
  {
    boolean bool6 = false;
    int i1 = -1;
    int n = -1;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool5 = false;
    int m = -1;
    int k = -1;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    int i = 1;
    int i8 = paramHeaders.size();
    int i2 = 0;
    Object localObject1 = null;
    boolean bool1 = false;
    while (i2 < i8)
    {
      Object localObject2 = paramHeaders.name(i2);
      String str1 = paramHeaders.value(i2);
      int i3;
      if (((String)localObject2).equalsIgnoreCase("Cache-Control")) {
        if (localObject1 != null)
        {
          i = 0;
          i3 = 0;
        }
      }
      for (;;)
      {
        label92:
        localObject2 = localObject1;
        bool16 = bool6;
        i7 = i1;
        i6 = n;
        bool15 = bool8;
        bool14 = bool7;
        bool13 = bool5;
        i5 = m;
        i4 = k;
        bool12 = bool4;
        bool11 = bool3;
        bool10 = bool2;
        j = i;
        bool9 = bool1;
        if (i3 >= str1.length()) {
          break label633;
        }
        j = HttpHeaders.skipUntil(str1, i3, "=,;");
        String str2 = str1.substring(i3, j).trim();
        if ((j == str1.length()) || (str1.charAt(j) == ',') || (str1.charAt(j) == ';'))
        {
          j += 1;
          localObject2 = null;
        }
        for (;;)
        {
          if (!"no-cache".equalsIgnoreCase(str2)) {
            break label348;
          }
          bool1 = true;
          i3 = j;
          break label92;
          localObject1 = str1;
          break;
          if (!((String)localObject2).equalsIgnoreCase("Pragma")) {
            break label580;
          }
          i = 0;
          break;
          i3 = HttpHeaders.skipWhitespace(str1, j + 1);
          if ((i3 < str1.length()) && (str1.charAt(i3) == '"'))
          {
            j = i3 + 1;
            i3 = HttpHeaders.skipUntil(str1, j, "\"");
            localObject2 = str1.substring(j, i3);
            j = i3 + 1;
          }
          else
          {
            j = HttpHeaders.skipUntil(str1, i3, ",;");
            localObject2 = str1.substring(i3, j).trim();
          }
        }
        label348:
        if ("no-store".equalsIgnoreCase(str2))
        {
          bool6 = true;
          i3 = j;
        }
        else if ("max-age".equalsIgnoreCase(str2))
        {
          i1 = HttpHeaders.parseSeconds((String)localObject2, -1);
          i3 = j;
        }
        else if ("s-maxage".equalsIgnoreCase(str2))
        {
          n = HttpHeaders.parseSeconds((String)localObject2, -1);
          i3 = j;
        }
        else if ("private".equalsIgnoreCase(str2))
        {
          bool8 = true;
          i3 = j;
        }
        else if ("public".equalsIgnoreCase(str2))
        {
          bool7 = true;
          i3 = j;
        }
        else if ("must-revalidate".equalsIgnoreCase(str2))
        {
          bool5 = true;
          i3 = j;
        }
        else if ("max-stale".equalsIgnoreCase(str2))
        {
          m = HttpHeaders.parseSeconds((String)localObject2, 2147483647);
          i3 = j;
        }
        else if ("min-fresh".equalsIgnoreCase(str2))
        {
          k = HttpHeaders.parseSeconds((String)localObject2, -1);
          i3 = j;
        }
        else if ("only-if-cached".equalsIgnoreCase(str2))
        {
          bool4 = true;
          i3 = j;
        }
        else if ("no-transform".equalsIgnoreCase(str2))
        {
          bool3 = true;
          i3 = j;
        }
        else
        {
          i3 = j;
          if ("immutable".equalsIgnoreCase(str2))
          {
            bool2 = true;
            i3 = j;
          }
        }
      }
      label580:
      boolean bool9 = bool1;
      int j = i;
      boolean bool10 = bool2;
      boolean bool11 = bool3;
      boolean bool12 = bool4;
      int i4 = k;
      int i5 = m;
      boolean bool13 = bool5;
      boolean bool14 = bool7;
      boolean bool15 = bool8;
      int i6 = n;
      int i7 = i1;
      boolean bool16 = bool6;
      localObject2 = localObject1;
      label633:
      i2 += 1;
      bool1 = bool9;
      localObject1 = localObject2;
      bool6 = bool16;
      i1 = i7;
      n = i6;
      bool8 = bool15;
      bool7 = bool14;
      bool5 = bool13;
      m = i5;
      k = i4;
      bool4 = bool12;
      bool3 = bool11;
      bool2 = bool10;
      i = j;
    }
    if (i == 0) {}
    for (paramHeaders = null;; paramHeaders = localObject1) {
      return new CacheControl(bool1, bool6, i1, n, bool8, bool7, bool5, m, k, bool4, bool3, bool2, paramHeaders);
    }
  }
  
  public boolean immutable()
  {
    return this.immutable;
  }
  
  public boolean isPrivate()
  {
    return this.isPrivate;
  }
  
  public boolean isPublic()
  {
    return this.isPublic;
  }
  
  public int maxAgeSeconds()
  {
    return this.maxAgeSeconds;
  }
  
  public int maxStaleSeconds()
  {
    return this.maxStaleSeconds;
  }
  
  public int minFreshSeconds()
  {
    return this.minFreshSeconds;
  }
  
  public boolean mustRevalidate()
  {
    return this.mustRevalidate;
  }
  
  public boolean noCache()
  {
    return this.noCache;
  }
  
  public boolean noStore()
  {
    return this.noStore;
  }
  
  public boolean noTransform()
  {
    return this.noTransform;
  }
  
  public boolean onlyIfCached()
  {
    return this.onlyIfCached;
  }
  
  public int sMaxAgeSeconds()
  {
    return this.sMaxAgeSeconds;
  }
  
  public String toString()
  {
    String str = this.headerValue;
    if (str != null) {
      return str;
    }
    str = headerValue();
    this.headerValue = str;
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.CacheControl
 * JD-Core Version:    0.7.0.1
 */