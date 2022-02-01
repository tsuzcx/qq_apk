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
    if (this.maxAgeSeconds != -1)
    {
      localStringBuilder.append("max-age=");
      localStringBuilder.append(this.maxAgeSeconds);
      localStringBuilder.append(", ");
    }
    if (this.sMaxAgeSeconds != -1)
    {
      localStringBuilder.append("s-maxage=");
      localStringBuilder.append(this.sMaxAgeSeconds);
      localStringBuilder.append(", ");
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
    if (this.maxStaleSeconds != -1)
    {
      localStringBuilder.append("max-stale=");
      localStringBuilder.append(this.maxStaleSeconds);
      localStringBuilder.append(", ");
    }
    if (this.minFreshSeconds != -1)
    {
      localStringBuilder.append("min-fresh=");
      localStringBuilder.append(this.minFreshSeconds);
      localStringBuilder.append(", ");
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
    int i8 = paramHeaders.size();
    int i2 = 0;
    int j = 1;
    Object localObject1 = null;
    boolean bool8 = false;
    boolean bool7 = false;
    int i1 = -1;
    int n = -1;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    int m = -1;
    int k = -1;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool16;
    for (boolean bool2 = false;; bool2 = bool16)
    {
      Object localObject2 = paramHeaders;
      if (i2 >= i8) {
        break;
      }
      String str2 = ((Headers)localObject2).name(i2);
      String str1 = ((Headers)localObject2).value(i2);
      int i7;
      boolean bool9;
      boolean bool10;
      int i;
      int i3;
      boolean bool11;
      boolean bool12;
      boolean bool13;
      int i4;
      int i5;
      boolean bool14;
      boolean bool15;
      if (str2.equalsIgnoreCase("Cache-Control"))
      {
        if (localObject1 == null)
        {
          localObject1 = str1;
          break label167;
        }
      }
      else
      {
        i7 = j;
        localObject2 = localObject1;
        bool9 = bool8;
        bool10 = bool7;
        i = i1;
        i3 = n;
        bool11 = bool6;
        bool12 = bool5;
        bool13 = bool4;
        i4 = m;
        i5 = k;
        bool14 = bool3;
        bool15 = bool1;
        bool16 = bool2;
        if (!str2.equalsIgnoreCase("Pragma")) {
          break label1163;
        }
      }
      j = 0;
      label167:
      int i6 = 0;
      for (;;)
      {
        i7 = j;
        localObject2 = localObject1;
        bool9 = bool8;
        bool10 = bool7;
        i = i1;
        i3 = n;
        bool11 = bool6;
        bool12 = bool5;
        bool13 = bool4;
        i4 = m;
        i5 = k;
        bool14 = bool3;
        bool15 = bool1;
        bool16 = bool2;
        if (i6 >= str1.length()) {
          break;
        }
        i = HttpHeaders.skipUntil(str1, i6, "=,;");
        str2 = str1.substring(i6, i).trim();
        if ((i != str1.length()) && (str1.charAt(i) != ',') && (str1.charAt(i) != ';'))
        {
          i3 = HttpHeaders.skipWhitespace(str1, i + 1);
          if ((i3 < str1.length()) && (str1.charAt(i3) == '"'))
          {
            i = i3 + 1;
            i3 = HttpHeaders.skipUntil(str1, i, "\"");
            localObject2 = str1.substring(i, i3);
            i = i3 + 1;
          }
          else
          {
            i = HttpHeaders.skipUntil(str1, i3, ",;");
            localObject2 = str1.substring(i3, i).trim();
          }
        }
        else
        {
          i += 1;
          localObject2 = null;
        }
        if ("no-cache".equalsIgnoreCase(str2))
        {
          bool9 = true;
          bool10 = bool7;
          i3 = i1;
          i4 = n;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i5 = m;
          i7 = k;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("no-store".equalsIgnoreCase(str2))
        {
          bool10 = true;
          bool9 = bool8;
          i3 = i1;
          i4 = n;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i5 = m;
          i7 = k;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("max-age".equalsIgnoreCase(str2))
        {
          i3 = HttpHeaders.parseSeconds((String)localObject2, -1);
          bool9 = bool8;
          bool10 = bool7;
          i4 = n;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i5 = m;
          i7 = k;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("s-maxage".equalsIgnoreCase(str2))
        {
          i4 = HttpHeaders.parseSeconds((String)localObject2, -1);
          bool9 = bool8;
          bool10 = bool7;
          i3 = i1;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i5 = m;
          i7 = k;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("private".equalsIgnoreCase(str2))
        {
          bool11 = true;
          bool9 = bool8;
          bool10 = bool7;
          i3 = i1;
          i4 = n;
          bool12 = bool5;
          bool13 = bool4;
          i5 = m;
          i7 = k;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("public".equalsIgnoreCase(str2))
        {
          bool12 = true;
          bool9 = bool8;
          bool10 = bool7;
          i3 = i1;
          i4 = n;
          bool11 = bool6;
          bool13 = bool4;
          i5 = m;
          i7 = k;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("must-revalidate".equalsIgnoreCase(str2))
        {
          bool13 = true;
          bool9 = bool8;
          bool10 = bool7;
          i3 = i1;
          i4 = n;
          bool11 = bool6;
          bool12 = bool5;
          i5 = m;
          i7 = k;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("max-stale".equalsIgnoreCase(str2))
        {
          i5 = HttpHeaders.parseSeconds((String)localObject2, 2147483647);
          bool9 = bool8;
          bool10 = bool7;
          i3 = i1;
          i4 = n;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i7 = k;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("min-fresh".equalsIgnoreCase(str2))
        {
          i7 = HttpHeaders.parseSeconds((String)localObject2, -1);
          bool9 = bool8;
          bool10 = bool7;
          i3 = i1;
          i4 = n;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i5 = m;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("only-if-cached".equalsIgnoreCase(str2))
        {
          bool14 = true;
          bool9 = bool8;
          bool10 = bool7;
          i3 = i1;
          i4 = n;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i5 = m;
          i7 = k;
          bool15 = bool1;
        }
        else if ("no-transform".equalsIgnoreCase(str2))
        {
          bool15 = true;
          bool9 = bool8;
          bool10 = bool7;
          i3 = i1;
          i4 = n;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i5 = m;
          i7 = k;
          bool14 = bool3;
        }
        else
        {
          bool9 = bool8;
          bool10 = bool7;
          i3 = i1;
          i4 = n;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i5 = m;
          i7 = k;
          bool14 = bool3;
          bool15 = bool1;
          if ("immutable".equalsIgnoreCase(str2))
          {
            bool2 = true;
            bool15 = bool1;
            bool14 = bool3;
            i7 = k;
            i5 = m;
            bool13 = bool4;
            bool12 = bool5;
            bool11 = bool6;
            i4 = n;
            i3 = i1;
            bool10 = bool7;
            bool9 = bool8;
          }
        }
        i6 = i;
        bool8 = bool9;
        bool7 = bool10;
        i1 = i3;
        n = i4;
        bool6 = bool11;
        bool5 = bool12;
        bool4 = bool13;
        m = i5;
        k = i7;
        bool3 = bool14;
        bool1 = bool15;
      }
      label1163:
      i2 += 1;
      j = i7;
      localObject1 = localObject2;
      bool8 = bool9;
      bool7 = bool10;
      i1 = i;
      n = i3;
      bool6 = bool11;
      bool5 = bool12;
      bool4 = bool13;
      m = i4;
      k = i5;
      bool3 = bool14;
      bool1 = bool15;
    }
    if (j == 0) {
      localObject1 = null;
    }
    return new CacheControl(bool8, bool7, i1, n, bool6, bool5, bool4, m, k, bool3, bool1, bool2, localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.CacheControl
 * JD-Core Version:    0.7.0.1
 */