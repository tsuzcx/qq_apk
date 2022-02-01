package okhttp3;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

public final class HttpUrl$Builder
{
  static final String INVALID_HOST = "Invalid URL host";
  @Nullable
  String encodedFragment;
  String encodedPassword = "";
  final List<String> encodedPathSegments = new ArrayList();
  @Nullable
  List<String> encodedQueryNamesAndValues;
  String encodedUsername = "";
  @Nullable
  String host;
  int port = -1;
  @Nullable
  String scheme;
  
  public HttpUrl$Builder()
  {
    this.encodedPathSegments.add("");
  }
  
  private Builder addPathSegments(String paramString, boolean paramBoolean)
  {
    int i = 0;
    int j;
    do
    {
      j = Util.delimiterOffset(paramString, i, paramString.length(), "/\\");
      boolean bool;
      if (j < paramString.length()) {
        bool = true;
      } else {
        bool = false;
      }
      push(paramString, i, j, bool, paramBoolean);
      j += 1;
      i = j;
    } while (j <= paramString.length());
    return this;
  }
  
  private static String canonicalizeHost(String paramString, int paramInt1, int paramInt2)
  {
    return Util.canonicalizeHost(HttpUrl.percentDecode(paramString, paramInt1, paramInt2, false));
  }
  
  private boolean isDot(String paramString)
  {
    return (paramString.equals(".")) || (paramString.equalsIgnoreCase("%2e"));
  }
  
  private boolean isDotDot(String paramString)
  {
    return (paramString.equals("..")) || (paramString.equalsIgnoreCase("%2e.")) || (paramString.equalsIgnoreCase(".%2e")) || (paramString.equalsIgnoreCase("%2e%2e"));
  }
  
  private static int parsePort(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = Integer.parseInt(HttpUrl.canonicalize(paramString, paramInt1, paramInt2, "", false, false, false, true, null));
      if ((paramInt1 > 0) && (paramInt1 <= 65535)) {
        return paramInt1;
      }
      return -1;
    }
    catch (NumberFormatException paramString) {}
    return -1;
  }
  
  private void pop()
  {
    List localList = this.encodedPathSegments;
    if ((((String)localList.remove(localList.size() - 1)).isEmpty()) && (!this.encodedPathSegments.isEmpty()))
    {
      localList = this.encodedPathSegments;
      localList.set(localList.size() - 1, "");
      return;
    }
    this.encodedPathSegments.add("");
  }
  
  private static int portColonOffset(String paramString, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      int j = paramString.charAt(paramInt1);
      if (j != 58)
      {
        int i = paramInt1;
        if (j != 91)
        {
          i = paramInt1;
        }
        else
        {
          do
          {
            paramInt1 = i + 1;
            i = paramInt1;
            if (paramInt1 >= paramInt2) {
              break;
            }
            i = paramInt1;
          } while (paramString.charAt(paramInt1) != ']');
          i = paramInt1;
        }
        paramInt1 = i + 1;
      }
      else
      {
        return paramInt1;
      }
    }
    return paramInt2;
  }
  
  private void push(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = HttpUrl.canonicalize(paramString, paramInt1, paramInt2, " \"<>^`{}|/\\?#", paramBoolean2, false, false, true, null);
    if (isDot(paramString)) {
      return;
    }
    if (isDotDot(paramString))
    {
      pop();
      return;
    }
    List localList = this.encodedPathSegments;
    if (((String)localList.get(localList.size() - 1)).isEmpty())
    {
      localList = this.encodedPathSegments;
      localList.set(localList.size() - 1, paramString);
    }
    else
    {
      this.encodedPathSegments.add(paramString);
    }
    if (paramBoolean1) {
      this.encodedPathSegments.add("");
    }
  }
  
  private void removeAllCanonicalQueryParameters(String paramString)
  {
    int i = this.encodedQueryNamesAndValues.size() - 2;
    while (i >= 0)
    {
      if (paramString.equals(this.encodedQueryNamesAndValues.get(i)))
      {
        this.encodedQueryNamesAndValues.remove(i + 1);
        this.encodedQueryNamesAndValues.remove(i);
        if (this.encodedQueryNamesAndValues.isEmpty())
        {
          this.encodedQueryNamesAndValues = null;
          return;
        }
      }
      i -= 2;
    }
  }
  
  private void resolvePath(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    int i = paramString.charAt(paramInt1);
    if ((i != 47) && (i != 92))
    {
      List localList = this.encodedPathSegments;
      localList.set(localList.size() - 1, "");
    }
    else
    {
      this.encodedPathSegments.clear();
      this.encodedPathSegments.add("");
      break label134;
    }
    while (paramInt1 < paramInt2)
    {
      i = Util.delimiterOffset(paramString, paramInt1, paramInt2, "/\\");
      boolean bool;
      if (i < paramInt2) {
        bool = true;
      } else {
        bool = false;
      }
      push(paramString, paramInt1, i, bool, true);
      paramInt1 = i;
      if (bool)
      {
        paramInt1 = i;
        label134:
        paramInt1 += 1;
      }
    }
  }
  
  private static int schemeDelimiterOffset(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 - paramInt1 < 2) {
      return -1;
    }
    int j = paramString.charAt(paramInt1);
    int i;
    if (j >= 97)
    {
      i = paramInt1;
      if (j <= 122) {}
    }
    else
    {
      if (j < 65) {
        break label153;
      }
      i = paramInt1;
      if (j > 90) {
        return -1;
      }
    }
    for (;;)
    {
      paramInt1 = i + 1;
      if (paramInt1 >= paramInt2) {
        break label153;
      }
      j = paramString.charAt(paramInt1);
      if (j >= 97)
      {
        i = paramInt1;
        if (j <= 122) {}
      }
      else if (j >= 65)
      {
        i = paramInt1;
        if (j <= 90) {}
      }
      else if (j >= 48)
      {
        i = paramInt1;
        if (j <= 57) {}
      }
      else
      {
        i = paramInt1;
        if (j != 43)
        {
          i = paramInt1;
          if (j != 45)
          {
            if (j != 46) {
              break;
            }
            i = paramInt1;
          }
        }
      }
    }
    if (j == 58) {
      return paramInt1;
    }
    label153:
    return -1;
  }
  
  private static int slashCount(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (paramInt1 < paramInt2)
    {
      int j = paramString.charAt(paramInt1);
      if ((j != 92) && (j != 47)) {
        break;
      }
      i += 1;
      paramInt1 += 1;
    }
    return i;
  }
  
  public Builder addEncodedPathSegment(String paramString)
  {
    if (paramString != null)
    {
      push(paramString, 0, paramString.length(), false, true);
      return this;
    }
    throw new NullPointerException("encodedPathSegment == null");
  }
  
  public Builder addEncodedPathSegments(String paramString)
  {
    if (paramString != null) {
      return addPathSegments(paramString, true);
    }
    throw new NullPointerException("encodedPathSegments == null");
  }
  
  public Builder addEncodedQueryParameter(String paramString1, @Nullable String paramString2)
  {
    if (paramString1 != null)
    {
      if (this.encodedQueryNamesAndValues == null) {
        this.encodedQueryNamesAndValues = new ArrayList();
      }
      this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(paramString1, " \"'<>#&=", true, false, true, true));
      List localList = this.encodedQueryNamesAndValues;
      if (paramString2 != null) {
        paramString1 = HttpUrl.canonicalize(paramString2, " \"'<>#&=", true, false, true, true);
      } else {
        paramString1 = null;
      }
      localList.add(paramString1);
      return this;
    }
    throw new NullPointerException("encodedName == null");
  }
  
  public Builder addPathSegment(String paramString)
  {
    if (paramString != null)
    {
      push(paramString, 0, paramString.length(), false, false);
      return this;
    }
    throw new NullPointerException("pathSegment == null");
  }
  
  public Builder addPathSegments(String paramString)
  {
    if (paramString != null) {
      return addPathSegments(paramString, false);
    }
    throw new NullPointerException("pathSegments == null");
  }
  
  public Builder addQueryParameter(String paramString1, @Nullable String paramString2)
  {
    if (paramString1 != null)
    {
      if (this.encodedQueryNamesAndValues == null) {
        this.encodedQueryNamesAndValues = new ArrayList();
      }
      this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(paramString1, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
      List localList = this.encodedQueryNamesAndValues;
      if (paramString2 != null) {
        paramString1 = HttpUrl.canonicalize(paramString2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true);
      } else {
        paramString1 = null;
      }
      localList.add(paramString1);
      return this;
    }
    throw new NullPointerException("name == null");
  }
  
  public HttpUrl build()
  {
    if (this.scheme != null)
    {
      if (this.host != null) {
        return new HttpUrl(this);
      }
      throw new IllegalStateException("host == null");
    }
    throw new IllegalStateException("scheme == null");
  }
  
  int effectivePort()
  {
    int i = this.port;
    if (i != -1) {
      return i;
    }
    return HttpUrl.defaultPort(this.scheme);
  }
  
  public Builder encodedFragment(@Nullable String paramString)
  {
    if (paramString != null) {
      paramString = HttpUrl.canonicalize(paramString, "", true, false, false, false);
    } else {
      paramString = null;
    }
    this.encodedFragment = paramString;
    return this;
  }
  
  public Builder encodedPassword(String paramString)
  {
    if (paramString != null)
    {
      this.encodedPassword = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
      return this;
    }
    throw new NullPointerException("encodedPassword == null");
  }
  
  public Builder encodedPath(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.startsWith("/"))
      {
        resolvePath(paramString, 0, paramString.length());
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unexpected encodedPath: ");
      localStringBuilder.append(paramString);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    throw new NullPointerException("encodedPath == null");
  }
  
  public Builder encodedQuery(@Nullable String paramString)
  {
    if (paramString != null) {
      paramString = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, " \"'<>#", true, false, true, true));
    } else {
      paramString = null;
    }
    this.encodedQueryNamesAndValues = paramString;
    return this;
  }
  
  public Builder encodedUsername(String paramString)
  {
    if (paramString != null)
    {
      this.encodedUsername = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
      return this;
    }
    throw new NullPointerException("encodedUsername == null");
  }
  
  public Builder fragment(@Nullable String paramString)
  {
    if (paramString != null) {
      paramString = HttpUrl.canonicalize(paramString, "", false, false, false, false);
    } else {
      paramString = null;
    }
    this.encodedFragment = paramString;
    return this;
  }
  
  public Builder host(String paramString)
  {
    if (paramString != null)
    {
      Object localObject = canonicalizeHost(paramString, 0, paramString.length());
      if (localObject != null)
      {
        this.host = ((String)localObject);
        return this;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unexpected host: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new NullPointerException("host == null");
  }
  
  Builder parse(@Nullable HttpUrl paramHttpUrl, String paramString)
  {
    int i = Util.skipLeadingAsciiWhitespace(paramString, 0, paramString.length());
    int i1 = Util.skipTrailingAsciiWhitespace(paramString, i, paramString.length());
    int j = schemeDelimiterOffset(paramString, i, i1);
    if (j != -1)
    {
      if (paramString.regionMatches(true, i, "https:", 0, 6))
      {
        this.scheme = "https";
        i += 6;
      }
      else if (paramString.regionMatches(true, i, "http:", 0, 5))
      {
        this.scheme = "http";
        i += 5;
      }
      else
      {
        paramHttpUrl = new StringBuilder();
        paramHttpUrl.append("Expected URL scheme 'http' or 'https' but was '");
        paramHttpUrl.append(paramString.substring(0, j));
        paramHttpUrl.append("'");
        throw new IllegalArgumentException(paramHttpUrl.toString());
      }
    }
    else
    {
      if (paramHttpUrl == null) {
        break label854;
      }
      this.scheme = paramHttpUrl.scheme;
    }
    j = slashCount(paramString, i, i1);
    int m;
    if ((j < 2) && (paramHttpUrl != null) && (paramHttpUrl.scheme.equals(this.scheme)))
    {
      this.encodedUsername = paramHttpUrl.encodedUsername();
      this.encodedPassword = paramHttpUrl.encodedPassword();
      this.host = paramHttpUrl.host;
      this.port = paramHttpUrl.port;
      this.encodedPathSegments.clear();
      this.encodedPathSegments.addAll(paramHttpUrl.encodedPathSegments());
      if (i != i1)
      {
        j = i;
        if (paramString.charAt(i) != '#') {}
      }
      else
      {
        encodedQuery(paramHttpUrl.encodedQuery());
        j = i;
      }
    }
    else
    {
      m = i + j;
      i = 0;
      j = 0;
      for (;;)
      {
        k = Util.delimiterOffset(paramString, m, i1, "@/\\?#");
        int n;
        if (k != i1) {
          n = paramString.charAt(k);
        } else {
          n = -1;
        }
        if ((n == -1) || (n == 35) || (n == 47) || (n == 92) || (n == 63)) {
          break;
        }
        if (n == 64)
        {
          if (i == 0)
          {
            int i2 = Util.delimiterOffset(paramString, m, k, ':');
            n = k;
            String str = HttpUrl.canonicalize(paramString, m, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
            paramHttpUrl = str;
            if (j != 0)
            {
              paramHttpUrl = new StringBuilder();
              paramHttpUrl.append(this.encodedUsername);
              paramHttpUrl.append("%40");
              paramHttpUrl.append(str);
              paramHttpUrl = paramHttpUrl.toString();
            }
            this.encodedUsername = paramHttpUrl;
            if (i2 != n)
            {
              this.encodedPassword = HttpUrl.canonicalize(paramString, i2 + 1, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
              i = 1;
            }
            j = 1;
          }
          else
          {
            paramHttpUrl = new StringBuilder();
            paramHttpUrl.append(this.encodedPassword);
            paramHttpUrl.append("%40");
            paramHttpUrl.append(HttpUrl.canonicalize(paramString, m, k, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
            this.encodedPassword = paramHttpUrl.toString();
          }
          m = k + 1;
        }
      }
      i = portColonOffset(paramString, m, k);
      j = i + 1;
      if (j < k)
      {
        this.host = canonicalizeHost(paramString, m, i);
        this.port = parsePort(paramString, j, k);
        if (this.port == -1)
        {
          paramHttpUrl = new StringBuilder();
          paramHttpUrl.append("Invalid URL port: \"");
          paramHttpUrl.append(paramString.substring(j, k));
          paramHttpUrl.append('"');
          throw new IllegalArgumentException(paramHttpUrl.toString());
        }
      }
      else
      {
        this.host = canonicalizeHost(paramString, m, i);
        this.port = HttpUrl.defaultPort(this.scheme);
      }
      if (this.host == null) {
        break label807;
      }
      j = k;
    }
    int k = Util.delimiterOffset(paramString, j, i1, "?#");
    resolvePath(paramString, j, k);
    i = k;
    if (k < i1)
    {
      i = k;
      if (paramString.charAt(k) == '?')
      {
        i = Util.delimiterOffset(paramString, k, i1, '#');
        this.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, k + 1, i, " \"'<>#", true, false, true, true, null));
      }
    }
    if ((i < i1) && (paramString.charAt(i) == '#')) {
      this.encodedFragment = HttpUrl.canonicalize(paramString, 1 + i, i1, "", true, false, false, false, null);
    }
    return this;
    label807:
    paramHttpUrl = new StringBuilder();
    paramHttpUrl.append("Invalid URL host: \"");
    paramHttpUrl.append(paramString.substring(m, i));
    paramHttpUrl.append('"');
    throw new IllegalArgumentException(paramHttpUrl.toString());
    label854:
    paramHttpUrl = new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
    for (;;)
    {
      throw paramHttpUrl;
    }
  }
  
  public Builder password(String paramString)
  {
    if (paramString != null)
    {
      this.encodedPassword = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
      return this;
    }
    throw new NullPointerException("password == null");
  }
  
  public Builder port(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 65535))
    {
      this.port = paramInt;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unexpected port: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public Builder query(@Nullable String paramString)
  {
    if (paramString != null) {
      paramString = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, " \"'<>#", false, false, true, true));
    } else {
      paramString = null;
    }
    this.encodedQueryNamesAndValues = paramString;
    return this;
  }
  
  Builder reencodeForUri()
  {
    int k = this.encodedPathSegments.size();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      localObject = (String)this.encodedPathSegments.get(i);
      this.encodedPathSegments.set(i, HttpUrl.canonicalize((String)localObject, "[]", true, true, false, true));
      i += 1;
    }
    Object localObject = this.encodedQueryNamesAndValues;
    if (localObject != null)
    {
      k = ((List)localObject).size();
      i = j;
      while (i < k)
      {
        localObject = (String)this.encodedQueryNamesAndValues.get(i);
        if (localObject != null) {
          this.encodedQueryNamesAndValues.set(i, HttpUrl.canonicalize((String)localObject, "\\^`{|}", true, true, true, true));
        }
        i += 1;
      }
    }
    localObject = this.encodedFragment;
    if (localObject != null) {
      this.encodedFragment = HttpUrl.canonicalize((String)localObject, " \"#<>\\^`{|}", true, true, false, false);
    }
    return this;
  }
  
  public Builder removeAllEncodedQueryParameters(String paramString)
  {
    if (paramString != null)
    {
      if (this.encodedQueryNamesAndValues == null) {
        return this;
      }
      removeAllCanonicalQueryParameters(HttpUrl.canonicalize(paramString, " \"'<>#&=", true, false, true, true));
      return this;
    }
    throw new NullPointerException("encodedName == null");
  }
  
  public Builder removeAllQueryParameters(String paramString)
  {
    if (paramString != null)
    {
      if (this.encodedQueryNamesAndValues == null) {
        return this;
      }
      removeAllCanonicalQueryParameters(HttpUrl.canonicalize(paramString, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
      return this;
    }
    throw new NullPointerException("name == null");
  }
  
  public Builder removePathSegment(int paramInt)
  {
    this.encodedPathSegments.remove(paramInt);
    if (this.encodedPathSegments.isEmpty()) {
      this.encodedPathSegments.add("");
    }
    return this;
  }
  
  public Builder scheme(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equalsIgnoreCase("http"))
      {
        this.scheme = "http";
        return this;
      }
      if (paramString.equalsIgnoreCase("https"))
      {
        this.scheme = "https";
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unexpected scheme: ");
      localStringBuilder.append(paramString);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    throw new NullPointerException("scheme == null");
  }
  
  public Builder setEncodedPathSegment(int paramInt, String paramString)
  {
    if (paramString != null)
    {
      Object localObject = HttpUrl.canonicalize(paramString, 0, paramString.length(), " \"<>^`{}|/\\?#", true, false, false, true, null);
      this.encodedPathSegments.set(paramInt, localObject);
      if ((!isDot((String)localObject)) && (!isDotDot((String)localObject))) {
        return this;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unexpected path segment: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new NullPointerException("encodedPathSegment == null");
  }
  
  public Builder setEncodedQueryParameter(String paramString1, @Nullable String paramString2)
  {
    removeAllEncodedQueryParameters(paramString1);
    addEncodedQueryParameter(paramString1, paramString2);
    return this;
  }
  
  public Builder setPathSegment(int paramInt, String paramString)
  {
    if (paramString != null)
    {
      Object localObject = HttpUrl.canonicalize(paramString, 0, paramString.length(), " \"<>^`{}|/\\?#", false, false, false, true, null);
      if ((!isDot((String)localObject)) && (!isDotDot((String)localObject)))
      {
        this.encodedPathSegments.set(paramInt, localObject);
        return this;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unexpected path segment: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new NullPointerException("pathSegment == null");
  }
  
  public Builder setQueryParameter(String paramString1, @Nullable String paramString2)
  {
    removeAllQueryParameters(paramString1);
    addQueryParameter(paramString1, paramString2);
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = this.scheme;
    if (str != null)
    {
      localStringBuilder.append(str);
      localStringBuilder.append("://");
    }
    else
    {
      localStringBuilder.append("//");
    }
    if ((!this.encodedUsername.isEmpty()) || (!this.encodedPassword.isEmpty()))
    {
      localStringBuilder.append(this.encodedUsername);
      if (!this.encodedPassword.isEmpty())
      {
        localStringBuilder.append(':');
        localStringBuilder.append(this.encodedPassword);
      }
      localStringBuilder.append('@');
    }
    str = this.host;
    if (str != null) {
      if (str.indexOf(':') != -1)
      {
        localStringBuilder.append('[');
        localStringBuilder.append(this.host);
        localStringBuilder.append(']');
      }
      else
      {
        localStringBuilder.append(this.host);
      }
    }
    if ((this.port != -1) || (this.scheme != null))
    {
      int i = effectivePort();
      str = this.scheme;
      if ((str == null) || (i != HttpUrl.defaultPort(str)))
      {
        localStringBuilder.append(':');
        localStringBuilder.append(i);
      }
    }
    HttpUrl.pathSegmentsToString(localStringBuilder, this.encodedPathSegments);
    if (this.encodedQueryNamesAndValues != null)
    {
      localStringBuilder.append('?');
      HttpUrl.namesAndValuesToQueryString(localStringBuilder, this.encodedQueryNamesAndValues);
    }
    if (this.encodedFragment != null)
    {
      localStringBuilder.append('#');
      localStringBuilder.append(this.encodedFragment);
    }
    return localStringBuilder.toString();
  }
  
  public Builder username(String paramString)
  {
    if (paramString != null)
    {
      this.encodedUsername = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
      return this;
    }
    throw new NullPointerException("username == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.HttpUrl.Builder
 * JD-Core Version:    0.7.0.1
 */