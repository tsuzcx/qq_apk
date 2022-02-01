package okhttp3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public final class Cookie
{
  private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
  private static final Pattern MONTH_PATTERN;
  private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
  private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
  private final String domain;
  private final long expiresAt;
  private final boolean hostOnly;
  private final boolean httpOnly;
  private final String name;
  private final String path;
  private final boolean persistent;
  private final boolean secure;
  private final String value;
  
  static
  {
    MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
  }
  
  private Cookie(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.name = paramString1;
    this.value = paramString2;
    this.expiresAt = paramLong;
    this.domain = paramString3;
    this.path = paramString4;
    this.secure = paramBoolean1;
    this.httpOnly = paramBoolean2;
    this.hostOnly = paramBoolean3;
    this.persistent = paramBoolean4;
  }
  
  Cookie(Cookie.Builder paramBuilder)
  {
    if (paramBuilder.name != null)
    {
      if (paramBuilder.value != null)
      {
        if (paramBuilder.domain != null)
        {
          this.name = paramBuilder.name;
          this.value = paramBuilder.value;
          this.expiresAt = paramBuilder.expiresAt;
          this.domain = paramBuilder.domain;
          this.path = paramBuilder.path;
          this.secure = paramBuilder.secure;
          this.httpOnly = paramBuilder.httpOnly;
          this.persistent = paramBuilder.persistent;
          this.hostOnly = paramBuilder.hostOnly;
          return;
        }
        throw new NullPointerException("builder.domain == null");
      }
      throw new NullPointerException("builder.value == null");
    }
    throw new NullPointerException("builder.name == null");
  }
  
  private static int dateCharacterOffset(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    while (paramInt1 < paramInt2)
    {
      int i = paramString.charAt(paramInt1);
      if (((i >= 32) || (i == 9)) && (i < 127) && ((i < 48) || (i > 57)) && ((i < 97) || (i > 122)) && ((i < 65) || (i > 90)) && (i != 58)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == (paramBoolean ^ true)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  private static boolean domainMatch(String paramString1, String paramString2)
  {
    if (paramString1.equals(paramString2)) {
      return true;
    }
    return (paramString1.endsWith(paramString2)) && (paramString1.charAt(paramString1.length() - paramString2.length() - 1) == '.') && (!Util.verifyAsIpAddress(paramString1));
  }
  
  @Nullable
  static Cookie parse(long paramLong, HttpUrl paramHttpUrl, String paramString)
  {
    int j = paramString.length();
    int i = Util.delimiterOffset(paramString, 0, j, ';');
    int k = Util.delimiterOffset(paramString, 0, i, '=');
    if (k == i) {
      return null;
    }
    String str1 = Util.trimSubstring(paramString, 0, k);
    if ((!str1.isEmpty()) && (Util.indexOfControlOrNonAscii(str1) == -1))
    {
      String str2 = Util.trimSubstring(paramString, k + 1, i);
      if (Util.indexOfControlOrNonAscii(str2) != -1) {
        return null;
      }
      i += 1;
      localObject2 = null;
      localObject1 = localObject2;
      l2 = -1L;
      l1 = 253402300799999L;
      bool3 = false;
      boolean bool4 = false;
      bool2 = true;
      for (bool1 = false; i < j; bool1 = bool7)
      {
        k = Util.delimiterOffset(paramString, i, j, ';');
        int m = Util.delimiterOffset(paramString, i, k, '=');
        String str3 = Util.trimSubstring(paramString, i, m);
        if (m < k) {
          localObject3 = Util.trimSubstring(paramString, m + 1, k);
        } else {
          localObject3 = "";
        }
        if (str3.equalsIgnoreCase("expires")) {}
        try
        {
          l3 = parseExpires((String)localObject3, 0, ((String)localObject3).length());
          l1 = l3;
          if (str3.equalsIgnoreCase("max-age"))
          {
            l3 = parseMaxAge((String)localObject3);
            l2 = l3;
            bool7 = true;
            localObject3 = localObject2;
            l3 = l2;
            l4 = l1;
            localObject5 = localObject1;
            bool5 = bool3;
            bool6 = bool2;
          }
          else if (str3.equalsIgnoreCase("domain"))
          {
            localObject3 = parseDomain((String)localObject3);
            bool6 = false;
            l3 = l2;
            l4 = l1;
            localObject5 = localObject1;
            bool5 = bool3;
            bool7 = bool1;
          }
          else if (str3.equalsIgnoreCase("path"))
          {
            localObject5 = localObject3;
            localObject3 = localObject2;
            l3 = l2;
            l4 = l1;
            bool5 = bool3;
            bool6 = bool2;
            bool7 = bool1;
          }
          else if (str3.equalsIgnoreCase("secure"))
          {
            bool5 = true;
            localObject3 = localObject2;
            l3 = l2;
            l4 = l1;
            localObject5 = localObject1;
            bool6 = bool2;
            bool7 = bool1;
          }
          else
          {
            localObject3 = localObject2;
            l3 = l2;
            l4 = l1;
            localObject5 = localObject1;
            bool5 = bool3;
            bool6 = bool2;
            bool7 = bool1;
            if (str3.equalsIgnoreCase("httponly"))
            {
              bool4 = true;
              bool7 = bool1;
              bool6 = bool2;
              bool5 = bool3;
              localObject5 = localObject1;
              l4 = l1;
              l3 = l2;
              localObject3 = localObject2;
            }
          }
        }
        catch (IllegalArgumentException|NumberFormatException localIllegalArgumentException)
        {
          for (;;)
          {
            Object localObject4 = localObject2;
            long l3 = l2;
            long l4 = l1;
            Object localObject5 = localObject1;
            boolean bool5 = bool3;
            boolean bool6 = bool2;
            boolean bool7 = bool1;
          }
        }
        i = k + 1;
        localObject2 = localObject3;
        l2 = l3;
        l1 = l4;
        localObject1 = localObject5;
        bool3 = bool5;
        bool2 = bool6;
      }
      l3 = -9223372036854775808L;
      if (l2 == -9223372036854775808L) {
        paramLong = l3;
      }
      for (;;)
      {
        break;
        if (l2 != -1L)
        {
          if (l2 <= 9223372036854775L) {
            l1 = l2 * 1000L;
          } else {
            l1 = 9223372036854775807L;
          }
          l1 = paramLong + l1;
          if (l1 >= paramLong)
          {
            paramLong = l1;
            if (l1 <= 253402300799999L) {
              break;
            }
          }
          else
          {
            paramLong = 253402300799999L;
          }
        }
        else
        {
          paramLong = l1;
        }
      }
      Object localObject3 = paramHttpUrl.host();
      if (localObject2 == null)
      {
        paramString = (String)localObject3;
      }
      else
      {
        if (!domainMatch((String)localObject3, (String)localObject2)) {
          return null;
        }
        paramString = (String)localObject2;
      }
      if ((((String)localObject3).length() != paramString.length()) && (PublicSuffixDatabase.get().getEffectiveTldPlusOne(paramString) == null)) {
        return null;
      }
      localObject2 = "/";
      if ((localObject1 != null) && (((String)localObject1).startsWith("/")))
      {
        paramHttpUrl = (HttpUrl)localObject1;
      }
      else
      {
        localObject1 = paramHttpUrl.encodedPath();
        i = ((String)localObject1).lastIndexOf('/');
        paramHttpUrl = (HttpUrl)localObject2;
        if (i != 0) {
          paramHttpUrl = ((String)localObject1).substring(0, i);
        }
      }
      return new Cookie(str1, str2, paramLong, paramString, paramHttpUrl, bool3, bool4, bool2, bool1);
    }
    else
    {
      return null;
    }
  }
  
  @Nullable
  public static Cookie parse(HttpUrl paramHttpUrl, String paramString)
  {
    return parse(System.currentTimeMillis(), paramHttpUrl, paramString);
  }
  
  public static List<Cookie> parseAll(HttpUrl paramHttpUrl, Headers paramHeaders)
  {
    List localList = paramHeaders.values("Set-Cookie");
    int j = localList.size();
    paramHeaders = null;
    int i = 0;
    while (i < j)
    {
      Cookie localCookie = parse(paramHttpUrl, (String)localList.get(i));
      if (localCookie != null)
      {
        Object localObject = paramHeaders;
        if (paramHeaders == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(localCookie);
        paramHeaders = (Headers)localObject;
      }
      i += 1;
    }
    if (paramHeaders != null) {
      return Collections.unmodifiableList(paramHeaders);
    }
    return Collections.emptyList();
  }
  
  private static String parseDomain(String paramString)
  {
    if (!paramString.endsWith("."))
    {
      String str = paramString;
      if (paramString.startsWith(".")) {
        str = paramString.substring(1);
      }
      paramString = Util.canonicalizeHost(str);
      if (paramString != null) {
        return paramString;
      }
      throw new IllegalArgumentException();
    }
    throw new IllegalArgumentException();
  }
  
  private static long parseExpires(String paramString, int paramInt1, int paramInt2)
  {
    int i1 = dateCharacterOffset(paramString, paramInt1, paramInt2, false);
    Matcher localMatcher = TIME_PATTERN.matcher(paramString);
    paramInt1 = -1;
    int n = -1;
    int j = -1;
    int i = -1;
    int m = -1;
    int k = -1;
    while (i1 < paramInt2)
    {
      int i7 = dateCharacterOffset(paramString, i1 + 1, paramInt2, true);
      localMatcher.region(i1, i7);
      int i2;
      int i5;
      int i6;
      int i3;
      int i4;
      if ((n == -1) && (localMatcher.usePattern(TIME_PATTERN).matches()))
      {
        i2 = Integer.parseInt(localMatcher.group(1));
        i5 = Integer.parseInt(localMatcher.group(2));
        i6 = Integer.parseInt(localMatcher.group(3));
        i1 = paramInt1;
        i3 = j;
        i4 = i;
      }
      else if ((j == -1) && (localMatcher.usePattern(DAY_OF_MONTH_PATTERN).matches()))
      {
        i3 = Integer.parseInt(localMatcher.group(1));
        i1 = paramInt1;
        i2 = n;
        i4 = i;
        i5 = m;
        i6 = k;
      }
      else if ((i == -1) && (localMatcher.usePattern(MONTH_PATTERN).matches()))
      {
        String str = localMatcher.group(1).toLowerCase(Locale.US);
        i4 = MONTH_PATTERN.pattern().indexOf(str) / 4;
        i1 = paramInt1;
        i2 = n;
        i3 = j;
        i5 = m;
        i6 = k;
      }
      else
      {
        i1 = paramInt1;
        i2 = n;
        i3 = j;
        i4 = i;
        i5 = m;
        i6 = k;
        if (paramInt1 == -1)
        {
          i1 = paramInt1;
          i2 = n;
          i3 = j;
          i4 = i;
          i5 = m;
          i6 = k;
          if (localMatcher.usePattern(YEAR_PATTERN).matches())
          {
            i1 = Integer.parseInt(localMatcher.group(1));
            i6 = k;
            i5 = m;
            i4 = i;
            i3 = j;
            i2 = n;
          }
        }
      }
      i7 = dateCharacterOffset(paramString, i7 + 1, paramInt2, false);
      paramInt1 = i1;
      n = i2;
      j = i3;
      i = i4;
      m = i5;
      k = i6;
      i1 = i7;
    }
    paramInt2 = paramInt1;
    if (paramInt1 >= 70)
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 99) {
        paramInt2 = paramInt1 + 1900;
      }
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 <= 69) {
        paramInt1 = paramInt2 + 2000;
      }
    }
    if (paramInt1 >= 1601)
    {
      if (i != -1)
      {
        if ((j >= 1) && (j <= 31))
        {
          if ((n >= 0) && (n <= 23))
          {
            if ((m >= 0) && (m <= 59))
            {
              if ((k >= 0) && (k <= 59))
              {
                paramString = new GregorianCalendar(Util.UTC);
                paramString.setLenient(false);
                paramString.set(1, paramInt1);
                paramString.set(2, i - 1);
                paramString.set(5, j);
                paramString.set(11, n);
                paramString.set(12, m);
                paramString.set(13, k);
                paramString.set(14, 0);
                return paramString.getTimeInMillis();
              }
              throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
          }
          throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
      }
      throw new IllegalArgumentException();
    }
    paramString = new IllegalArgumentException();
    for (;;)
    {
      throw paramString;
    }
  }
  
  private static long parseMaxAge(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if (l <= 0L) {
        return -9223372036854775808L;
      }
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (paramString.matches("-?\\d+"))
      {
        if (paramString.startsWith("-")) {
          return -9223372036854775808L;
        }
        return 9223372036854775807L;
      }
      throw localNumberFormatException;
    }
  }
  
  private static boolean pathMatch(HttpUrl paramHttpUrl, String paramString)
  {
    paramHttpUrl = paramHttpUrl.encodedPath();
    if (paramHttpUrl.equals(paramString)) {
      return true;
    }
    if (paramHttpUrl.startsWith(paramString))
    {
      if (paramString.endsWith("/")) {
        return true;
      }
      if (paramHttpUrl.charAt(paramString.length()) == '/') {
        return true;
      }
    }
    return false;
  }
  
  public String domain()
  {
    return this.domain;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool1 = paramObject instanceof Cookie;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (Cookie)paramObject;
    bool1 = bool2;
    if (paramObject.name.equals(this.name))
    {
      bool1 = bool2;
      if (paramObject.value.equals(this.value))
      {
        bool1 = bool2;
        if (paramObject.domain.equals(this.domain))
        {
          bool1 = bool2;
          if (paramObject.path.equals(this.path))
          {
            bool1 = bool2;
            if (paramObject.expiresAt == this.expiresAt)
            {
              bool1 = bool2;
              if (paramObject.secure == this.secure)
              {
                bool1 = bool2;
                if (paramObject.httpOnly == this.httpOnly)
                {
                  bool1 = bool2;
                  if (paramObject.persistent == this.persistent)
                  {
                    bool1 = bool2;
                    if (paramObject.hostOnly == this.hostOnly) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public long expiresAt()
  {
    return this.expiresAt;
  }
  
  public int hashCode()
  {
    int i = this.name.hashCode();
    int j = this.value.hashCode();
    int k = this.domain.hashCode();
    int m = this.path.hashCode();
    long l = this.expiresAt;
    return ((((((((527 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + (int)(l ^ l >>> 32)) * 31 + (this.secure ^ true)) * 31 + (this.httpOnly ^ true)) * 31 + (this.persistent ^ true)) * 31 + (this.hostOnly ^ true);
  }
  
  public boolean hostOnly()
  {
    return this.hostOnly;
  }
  
  public boolean httpOnly()
  {
    return this.httpOnly;
  }
  
  public boolean matches(HttpUrl paramHttpUrl)
  {
    boolean bool;
    if (this.hostOnly) {
      bool = paramHttpUrl.host().equals(this.domain);
    } else {
      bool = domainMatch(paramHttpUrl.host(), this.domain);
    }
    if (!bool) {
      return false;
    }
    if (!pathMatch(paramHttpUrl, this.path)) {
      return false;
    }
    return (!this.secure) || (paramHttpUrl.isHttps());
  }
  
  public String name()
  {
    return this.name;
  }
  
  public String path()
  {
    return this.path;
  }
  
  public boolean persistent()
  {
    return this.persistent;
  }
  
  public boolean secure()
  {
    return this.secure;
  }
  
  public String toString()
  {
    return toString(false);
  }
  
  String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append('=');
    localStringBuilder.append(this.value);
    if (this.persistent) {
      if (this.expiresAt == -9223372036854775808L)
      {
        localStringBuilder.append("; max-age=0");
      }
      else
      {
        localStringBuilder.append("; expires=");
        localStringBuilder.append(HttpDate.format(new Date(this.expiresAt)));
      }
    }
    if (!this.hostOnly)
    {
      localStringBuilder.append("; domain=");
      if (paramBoolean) {
        localStringBuilder.append(".");
      }
      localStringBuilder.append(this.domain);
    }
    localStringBuilder.append("; path=");
    localStringBuilder.append(this.path);
    if (this.secure) {
      localStringBuilder.append("; secure");
    }
    if (this.httpOnly) {
      localStringBuilder.append("; httponly");
    }
    return localStringBuilder.toString();
  }
  
  public String value()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.Cookie
 * JD-Core Version:    0.7.0.1
 */