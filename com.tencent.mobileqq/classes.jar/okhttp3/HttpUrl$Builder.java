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
    int j = Util.delimiterOffset(paramString, i, paramString.length(), "/\\");
    if (j < paramString.length()) {}
    for (boolean bool = true;; bool = false)
    {
      push(paramString, i, j, bool, paramBoolean);
      j += 1;
      i = j;
      if (j <= paramString.length()) {
        break;
      }
      return this;
    }
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
    if ((((String)this.encodedPathSegments.remove(this.encodedPathSegments.size() - 1)).isEmpty()) && (!this.encodedPathSegments.isEmpty()))
    {
      this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
      return;
    }
    this.encodedPathSegments.add("");
  }
  
  private static int portColonOffset(String paramString, int paramInt1, int paramInt2)
  {
    int i;
    int j;
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      j = paramInt1;
    }
    switch (paramString.charAt(paramInt1))
    {
    default: 
      i = paramInt1;
    case '[': 
      for (;;)
      {
        paramInt1 = i + 1;
        break;
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
      j = paramInt2;
    }
    return j;
  }
  
  private void push(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = HttpUrl.canonicalize(paramString, paramInt1, paramInt2, " \"<>^`{}|/\\?#", paramBoolean2, false, false, true, null);
    if (isDot(paramString)) {}
    for (;;)
    {
      return;
      if (isDotDot(paramString))
      {
        pop();
        return;
      }
      if (((String)this.encodedPathSegments.get(this.encodedPathSegments.size() - 1)).isEmpty()) {
        this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, paramString);
      }
      while (paramBoolean1)
      {
        this.encodedPathSegments.add("");
        return;
        this.encodedPathSegments.add(paramString);
      }
    }
  }
  
  private void removeAllCanonicalQueryParameters(String paramString)
  {
    int i = this.encodedQueryNamesAndValues.size() - 2;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramString.equals(this.encodedQueryNamesAndValues.get(i)))
        {
          this.encodedQueryNamesAndValues.remove(i + 1);
          this.encodedQueryNamesAndValues.remove(i);
          if (this.encodedQueryNamesAndValues.isEmpty()) {
            this.encodedQueryNamesAndValues = null;
          }
        }
      }
      else {
        return;
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
    if ((i == 47) || (i == 92))
    {
      this.encodedPathSegments.clear();
      this.encodedPathSegments.add("");
      paramInt1 += 1;
      label52:
      if (paramInt1 >= paramInt2) {
        break label127;
      }
      i = Util.delimiterOffset(paramString, paramInt1, paramInt2, "/\\");
      if (i >= paramInt2) {
        break label129;
      }
    }
    label129:
    for (boolean bool = true;; bool = false)
    {
      push(paramString, paramInt1, i, bool, true);
      paramInt1 = i;
      if (bool) {
        paramInt1 = i + 1;
      }
      break label52;
      this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
      break label52;
      label127:
      break;
    }
  }
  
  private static int schemeDelimiterOffset(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 - paramInt1 < 2) {}
    int i;
    label115:
    do
    {
      for (;;)
      {
        return -1;
        i = paramString.charAt(paramInt1);
        if (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)))
        {
          paramInt1 += 1;
          while (paramInt1 < paramInt2)
          {
            i = paramString.charAt(paramInt1);
            if (((i < 97) || (i > 122)) && ((i < 65) || (i > 90)) && ((i < 48) || (i > 57)) && (i != 43) && (i != 45) && (i != 46)) {
              break label115;
            }
            paramInt1 += 1;
          }
        }
      }
    } while (i != 58);
    return paramInt1;
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
    if (paramString == null) {
      throw new NullPointerException("encodedPathSegment == null");
    }
    push(paramString, 0, paramString.length(), false, true);
    return this;
  }
  
  public Builder addEncodedPathSegments(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("encodedPathSegments == null");
    }
    return addPathSegments(paramString, true);
  }
  
  public Builder addEncodedQueryParameter(String paramString1, @Nullable String paramString2)
  {
    if (paramString1 == null) {
      throw new NullPointerException("encodedName == null");
    }
    if (this.encodedQueryNamesAndValues == null) {
      this.encodedQueryNamesAndValues = new ArrayList();
    }
    this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(paramString1, " \"'<>#&=", true, false, true, true));
    List localList = this.encodedQueryNamesAndValues;
    if (paramString2 != null) {}
    for (paramString1 = HttpUrl.canonicalize(paramString2, " \"'<>#&=", true, false, true, true);; paramString1 = null)
    {
      localList.add(paramString1);
      return this;
    }
  }
  
  public Builder addPathSegment(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("pathSegment == null");
    }
    push(paramString, 0, paramString.length(), false, false);
    return this;
  }
  
  public Builder addPathSegments(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("pathSegments == null");
    }
    return addPathSegments(paramString, false);
  }
  
  public Builder addQueryParameter(String paramString1, @Nullable String paramString2)
  {
    if (paramString1 == null) {
      throw new NullPointerException("name == null");
    }
    if (this.encodedQueryNamesAndValues == null) {
      this.encodedQueryNamesAndValues = new ArrayList();
    }
    this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(paramString1, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
    List localList = this.encodedQueryNamesAndValues;
    if (paramString2 != null) {}
    for (paramString1 = HttpUrl.canonicalize(paramString2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true);; paramString1 = null)
    {
      localList.add(paramString1);
      return this;
    }
  }
  
  public HttpUrl build()
  {
    if (this.scheme == null) {
      throw new IllegalStateException("scheme == null");
    }
    if (this.host == null) {
      throw new IllegalStateException("host == null");
    }
    return new HttpUrl(this);
  }
  
  int effectivePort()
  {
    if (this.port != -1) {
      return this.port;
    }
    return HttpUrl.defaultPort(this.scheme);
  }
  
  public Builder encodedFragment(@Nullable String paramString)
  {
    if (paramString != null) {}
    for (paramString = HttpUrl.canonicalize(paramString, "", true, false, false, false);; paramString = null)
    {
      this.encodedFragment = paramString;
      return this;
    }
  }
  
  public Builder encodedPassword(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("encodedPassword == null");
    }
    this.encodedPassword = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
    return this;
  }
  
  public Builder encodedPath(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("encodedPath == null");
    }
    if (!paramString.startsWith("/")) {
      throw new IllegalArgumentException("unexpected encodedPath: " + paramString);
    }
    resolvePath(paramString, 0, paramString.length());
    return this;
  }
  
  public Builder encodedQuery(@Nullable String paramString)
  {
    if (paramString != null) {}
    for (paramString = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, " \"'<>#", true, false, true, true));; paramString = null)
    {
      this.encodedQueryNamesAndValues = paramString;
      return this;
    }
  }
  
  public Builder encodedUsername(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("encodedUsername == null");
    }
    this.encodedUsername = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
    return this;
  }
  
  public Builder fragment(@Nullable String paramString)
  {
    if (paramString != null) {}
    for (paramString = HttpUrl.canonicalize(paramString, "", false, false, false, false);; paramString = null)
    {
      this.encodedFragment = paramString;
      return this;
    }
  }
  
  public Builder host(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("host == null");
    }
    String str = canonicalizeHost(paramString, 0, paramString.length());
    if (str == null) {
      throw new IllegalArgumentException("unexpected host: " + paramString);
    }
    this.host = str;
    return this;
  }
  
  Builder parse(@Nullable HttpUrl paramHttpUrl, String paramString)
  {
    int i = Util.skipLeadingAsciiWhitespace(paramString, 0, paramString.length());
    int i1 = Util.skipTrailingAsciiWhitespace(paramString, i, paramString.length());
    int j = schemeDelimiterOffset(paramString, i, i1);
    label67:
    int k;
    label119:
    int n;
    if (j != -1) {
      if (paramString.regionMatches(true, i, "https:", 0, 6))
      {
        this.scheme = "https";
        i += "https:".length();
        m = slashCount(paramString, i, i1);
        if ((m < 2) && (paramHttpUrl != null) && (paramHttpUrl.scheme.equals(this.scheme))) {
          break label780;
        }
        k = 0;
        j = 0;
        m = i + m;
        i = k;
        k = m;
        n = Util.delimiterOffset(paramString, k, i1, "@/\\?#");
        if (n == i1) {
          break label330;
        }
      }
    }
    label330:
    for (int m = paramString.charAt(n);; m = -1) {
      switch (m)
      {
      default: 
        m = i;
        i = k;
        k = m;
        m = k;
        k = i;
        i = m;
        break label119;
        if (paramString.regionMatches(true, i, "http:", 0, 5))
        {
          this.scheme = "http";
          i += "http:".length();
          break label67;
        }
        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + paramString.substring(0, j) + "'");
        if (paramHttpUrl != null)
        {
          this.scheme = paramHttpUrl.scheme;
          break label67;
        }
        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
      }
    }
    if (i == 0)
    {
      m = Util.delimiterOffset(paramString, k, n, ':');
      String str = HttpUrl.canonicalize(paramString, k, m, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
      paramHttpUrl = str;
      if (j != 0) {
        paramHttpUrl = this.encodedUsername + "%40" + str;
      }
      this.encodedUsername = paramHttpUrl;
      if (m != n)
      {
        i = 1;
        this.encodedPassword = HttpUrl.canonicalize(paramString, m + 1, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
      }
      j = 1;
    }
    for (;;)
    {
      m = n + 1;
      k = i;
      i = m;
      break;
      this.encodedPassword = (this.encodedPassword + "%40" + HttpUrl.canonicalize(paramString, k, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
    }
    i = portColonOffset(paramString, k, n);
    if (i + 1 < n)
    {
      this.host = canonicalizeHost(paramString, k, i);
      this.port = parsePort(paramString, i + 1, n);
      if (this.port == -1) {
        throw new IllegalArgumentException("Invalid URL port: \"" + paramString.substring(i + 1, n) + '"');
      }
    }
    else
    {
      this.host = canonicalizeHost(paramString, k, i);
      this.port = HttpUrl.defaultPort(this.scheme);
    }
    if (this.host == null) {
      throw new IllegalArgumentException("Invalid URL host: \"" + paramString.substring(k, i) + '"');
    }
    j = n;
    i = Util.delimiterOffset(paramString, j, i1, "?#");
    resolvePath(paramString, j, i);
    if ((i < i1) && (paramString.charAt(i) == '?'))
    {
      j = Util.delimiterOffset(paramString, i, i1, '#');
      this.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, i + 1, j, " \"'<>#", true, false, true, true, null));
      i = j;
    }
    for (;;)
    {
      if ((i < i1) && (paramString.charAt(i) == '#')) {
        this.encodedFragment = HttpUrl.canonicalize(paramString, i + 1, i1, "", true, false, false, false, null);
      }
      return this;
      label780:
      this.encodedUsername = paramHttpUrl.encodedUsername();
      this.encodedPassword = paramHttpUrl.encodedPassword();
      this.host = paramHttpUrl.host;
      this.port = paramHttpUrl.port;
      this.encodedPathSegments.clear();
      this.encodedPathSegments.addAll(paramHttpUrl.encodedPathSegments());
      if (i != i1)
      {
        j = i;
        if (paramString.charAt(i) != '#') {
          break;
        }
      }
      encodedQuery(paramHttpUrl.encodedQuery());
      j = i;
      break;
    }
  }
  
  public Builder password(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("password == null");
    }
    this.encodedPassword = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
    return this;
  }
  
  public Builder port(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > 65535)) {
      throw new IllegalArgumentException("unexpected port: " + paramInt);
    }
    this.port = paramInt;
    return this;
  }
  
  public Builder query(@Nullable String paramString)
  {
    if (paramString != null) {}
    for (paramString = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, " \"'<>#", false, false, true, true));; paramString = null)
    {
      this.encodedQueryNamesAndValues = paramString;
      return this;
    }
  }
  
  Builder reencodeForUri()
  {
    int j = this.encodedPathSegments.size();
    int i = 0;
    String str;
    while (i < j)
    {
      str = (String)this.encodedPathSegments.get(i);
      this.encodedPathSegments.set(i, HttpUrl.canonicalize(str, "[]", true, true, false, true));
      i += 1;
    }
    if (this.encodedQueryNamesAndValues != null)
    {
      j = this.encodedQueryNamesAndValues.size();
      i = 0;
      while (i < j)
      {
        str = (String)this.encodedQueryNamesAndValues.get(i);
        if (str != null) {
          this.encodedQueryNamesAndValues.set(i, HttpUrl.canonicalize(str, "\\^`{|}", true, true, true, true));
        }
        i += 1;
      }
    }
    if (this.encodedFragment != null) {
      this.encodedFragment = HttpUrl.canonicalize(this.encodedFragment, " \"#<>\\^`{|}", true, true, false, false);
    }
    return this;
  }
  
  public Builder removeAllEncodedQueryParameters(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("encodedName == null");
    }
    if (this.encodedQueryNamesAndValues == null) {
      return this;
    }
    removeAllCanonicalQueryParameters(HttpUrl.canonicalize(paramString, " \"'<>#&=", true, false, true, true));
    return this;
  }
  
  public Builder removeAllQueryParameters(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("name == null");
    }
    if (this.encodedQueryNamesAndValues == null) {
      return this;
    }
    removeAllCanonicalQueryParameters(HttpUrl.canonicalize(paramString, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
    return this;
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
    if (paramString == null) {
      throw new NullPointerException("scheme == null");
    }
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
    throw new IllegalArgumentException("unexpected scheme: " + paramString);
  }
  
  public Builder setEncodedPathSegment(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("encodedPathSegment == null");
    }
    String str = HttpUrl.canonicalize(paramString, 0, paramString.length(), " \"<>^`{}|/\\?#", true, false, false, true, null);
    this.encodedPathSegments.set(paramInt, str);
    if ((isDot(str)) || (isDotDot(str))) {
      throw new IllegalArgumentException("unexpected path segment: " + paramString);
    }
    return this;
  }
  
  public Builder setEncodedQueryParameter(String paramString1, @Nullable String paramString2)
  {
    removeAllEncodedQueryParameters(paramString1);
    addEncodedQueryParameter(paramString1, paramString2);
    return this;
  }
  
  public Builder setPathSegment(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("pathSegment == null");
    }
    String str = HttpUrl.canonicalize(paramString, 0, paramString.length(), " \"<>^`{}|/\\?#", false, false, false, true, null);
    if ((isDot(str)) || (isDotDot(str))) {
      throw new IllegalArgumentException("unexpected path segment: " + paramString);
    }
    this.encodedPathSegments.set(paramInt, str);
    return this;
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
    if (this.scheme != null)
    {
      localStringBuilder.append(this.scheme);
      localStringBuilder.append("://");
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
      if (this.host != null)
      {
        if (this.host.indexOf(':') == -1) {
          break label257;
        }
        localStringBuilder.append('[');
        localStringBuilder.append(this.host);
        localStringBuilder.append(']');
      }
    }
    for (;;)
    {
      if ((this.port != -1) || (this.scheme != null))
      {
        int i = effectivePort();
        if ((this.scheme == null) || (i != HttpUrl.defaultPort(this.scheme)))
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
      localStringBuilder.append("//");
      break;
      label257:
      localStringBuilder.append(this.host);
    }
  }
  
  public Builder username(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("username == null");
    }
    this.encodedUsername = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.HttpUrl.Builder
 * JD-Core Version:    0.7.0.1
 */