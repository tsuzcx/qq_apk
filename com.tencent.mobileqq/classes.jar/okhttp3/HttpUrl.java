package okhttp3;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;

public final class HttpUrl
{
  static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
  static final String FRAGMENT_ENCODE_SET = "";
  static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
  static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
  static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
  static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
  static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
  static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
  static final String QUERY_ENCODE_SET = " \"'<>#";
  static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
  @Nullable
  private final String fragment;
  final String host;
  private final String password;
  private final List<String> pathSegments;
  final int port;
  @Nullable
  private final List<String> queryNamesAndValues;
  final String scheme;
  private final String url;
  private final String username;
  
  HttpUrl(HttpUrl.Builder paramBuilder)
  {
    this.scheme = paramBuilder.scheme;
    this.username = percentDecode(paramBuilder.encodedUsername, false);
    this.password = percentDecode(paramBuilder.encodedPassword, false);
    this.host = paramBuilder.host;
    this.port = paramBuilder.effectivePort();
    this.pathSegments = percentDecode(paramBuilder.encodedPathSegments, false);
    Object localObject1 = paramBuilder.encodedQueryNamesAndValues;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = percentDecode(paramBuilder.encodedQueryNamesAndValues, true);
    } else {
      localObject1 = null;
    }
    this.queryNamesAndValues = ((List)localObject1);
    localObject1 = localObject2;
    if (paramBuilder.encodedFragment != null) {
      localObject1 = percentDecode(paramBuilder.encodedFragment, false);
    }
    this.fragment = ((String)localObject1);
    this.url = paramBuilder.toString();
  }
  
  static String canonicalize(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
  {
    int i = paramInt1;
    while (i < paramInt2)
    {
      int j = paramString1.codePointAt(i);
      if ((j >= 32) && (j != 127) && ((j < 128) || (!paramBoolean4)) && (paramString2.indexOf(j) == -1) && ((j != 37) || ((paramBoolean1) && ((!paramBoolean2) || (percentEncoded(paramString1, i, paramInt2))))) && ((j != 43) || (!paramBoolean3)))
      {
        i += Character.charCount(j);
      }
      else
      {
        Buffer localBuffer = new Buffer();
        localBuffer.writeUtf8(paramString1, paramInt1, i);
        canonicalize(localBuffer, paramString1, i, paramInt2, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramCharset);
        return localBuffer.readUtf8();
      }
    }
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String canonicalize(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    return canonicalize(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, null);
  }
  
  static String canonicalize(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
  {
    return canonicalize(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramCharset);
  }
  
  static void canonicalize(Buffer paramBuffer, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
  {
    Object localObject3;
    for (Object localObject1 = null; paramInt1 < paramInt2; localObject1 = localObject3)
    {
      int i = paramString1.codePointAt(paramInt1);
      if (paramBoolean1)
      {
        localObject3 = localObject1;
        if (i == 9) {
          break label318;
        }
        localObject3 = localObject1;
        if (i == 10) {
          break label318;
        }
        localObject3 = localObject1;
        if (i == 12) {
          break label318;
        }
        if (i == 13)
        {
          localObject3 = localObject1;
          break label318;
        }
      }
      Object localObject2;
      if ((i == 43) && (paramBoolean3))
      {
        if (paramBoolean1) {
          localObject2 = "+";
        } else {
          localObject2 = "%2B";
        }
        paramBuffer.writeUtf8((String)localObject2);
        localObject3 = localObject1;
      }
      else if ((i >= 32) && (i != 127) && ((i < 128) || (!paramBoolean4)) && (paramString2.indexOf(i) == -1) && ((i != 37) || ((paramBoolean1) && ((!paramBoolean2) || (percentEncoded(paramString1, paramInt1, paramInt2))))))
      {
        paramBuffer.writeUtf8CodePoint(i);
        localObject3 = localObject1;
      }
      else
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Buffer();
        }
        if ((paramCharset != null) && (!paramCharset.equals(Util.UTF_8))) {
          ((Buffer)localObject2).writeString(paramString1, paramInt1, Character.charCount(i) + paramInt1, paramCharset);
        } else {
          ((Buffer)localObject2).writeUtf8CodePoint(i);
        }
        for (;;)
        {
          localObject3 = localObject2;
          if (((Buffer)localObject2).exhausted()) {
            break;
          }
          int j = ((Buffer)localObject2).readByte() & 0xFF;
          paramBuffer.writeByte(37);
          paramBuffer.writeByte(HEX_DIGITS[(j >> 4 & 0xF)]);
          paramBuffer.writeByte(HEX_DIGITS[(j & 0xF)]);
        }
      }
      label318:
      paramInt1 += Character.charCount(i);
    }
  }
  
  public static int defaultPort(String paramString)
  {
    if (paramString.equals("http")) {
      return 80;
    }
    if (paramString.equals("https")) {
      return 443;
    }
    return -1;
  }
  
  public static HttpUrl get(String paramString)
  {
    return new HttpUrl.Builder().parse(null, paramString).build();
  }
  
  @Nullable
  public static HttpUrl get(URI paramURI)
  {
    return parse(paramURI.toString());
  }
  
  @Nullable
  public static HttpUrl get(URL paramURL)
  {
    return parse(paramURL.toString());
  }
  
  static void namesAndValuesToQueryString(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      String str1 = (String)paramList.get(i);
      String str2 = (String)paramList.get(i + 1);
      if (i > 0) {
        paramStringBuilder.append('&');
      }
      paramStringBuilder.append(str1);
      if (str2 != null)
      {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      }
      i += 2;
    }
  }
  
  @Nullable
  public static HttpUrl parse(String paramString)
  {
    try
    {
      paramString = get(paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  static void pathSegmentsToString(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append('/');
      paramStringBuilder.append((String)paramList.get(i));
      i += 1;
    }
  }
  
  static String percentDecode(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt1;
    while (i < paramInt2)
    {
      int j = paramString.charAt(i);
      if ((j != 37) && ((j != 43) || (!paramBoolean)))
      {
        i += 1;
      }
      else
      {
        Buffer localBuffer = new Buffer();
        localBuffer.writeUtf8(paramString, paramInt1, i);
        percentDecode(localBuffer, paramString, i, paramInt2, paramBoolean);
        return localBuffer.readUtf8();
      }
    }
    return paramString.substring(paramInt1, paramInt2);
  }
  
  static String percentDecode(String paramString, boolean paramBoolean)
  {
    return percentDecode(paramString, 0, paramString.length(), paramBoolean);
  }
  
  private List<String> percentDecode(List<String> paramList, boolean paramBoolean)
  {
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      String str = (String)paramList.get(i);
      if (str != null) {
        str = percentDecode(str, paramBoolean);
      } else {
        str = null;
      }
      localArrayList.add(str);
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  static void percentDecode(Buffer paramBuffer, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    while (paramInt1 < paramInt2)
    {
      int j = paramString.codePointAt(paramInt1);
      if (j == 37)
      {
        int i = paramInt1 + 2;
        if (i < paramInt2)
        {
          int k = Util.decodeHexDigit(paramString.charAt(paramInt1 + 1));
          int m = Util.decodeHexDigit(paramString.charAt(i));
          if ((k == -1) || (m == -1)) {
            break label105;
          }
          paramBuffer.writeByte((k << 4) + m);
          paramInt1 = i;
          break label112;
        }
      }
      if ((j == 43) && (paramBoolean)) {
        paramBuffer.writeByte(32);
      } else {
        label105:
        paramBuffer.writeUtf8CodePoint(j);
      }
      label112:
      paramInt1 += Character.charCount(j);
    }
  }
  
  static boolean percentEncoded(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + 2;
    return (i < paramInt2) && (paramString.charAt(paramInt1) == '%') && (Util.decodeHexDigit(paramString.charAt(paramInt1 + 1)) != -1) && (Util.decodeHexDigit(paramString.charAt(i)) != -1);
  }
  
  static List<String> queryStringToNamesAndValues(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int j;
    for (int i = 0; i <= paramString.length(); i = j + 1)
    {
      int k = paramString.indexOf('&', i);
      j = k;
      if (k == -1) {
        j = paramString.length();
      }
      k = paramString.indexOf('=', i);
      if ((k != -1) && (k <= j))
      {
        localArrayList.add(paramString.substring(i, k));
        localArrayList.add(paramString.substring(k + 1, j));
      }
      else
      {
        localArrayList.add(paramString.substring(i, j));
        localArrayList.add(null);
      }
    }
    return localArrayList;
  }
  
  @Nullable
  public String encodedFragment()
  {
    if (this.fragment == null) {
      return null;
    }
    int i = this.url.indexOf('#');
    return this.url.substring(i + 1);
  }
  
  public String encodedPassword()
  {
    if (this.password.isEmpty()) {
      return "";
    }
    int i = this.url.indexOf(':', this.scheme.length() + 3);
    int j = this.url.indexOf('@');
    return this.url.substring(i + 1, j);
  }
  
  public String encodedPath()
  {
    int i = this.url.indexOf('/', this.scheme.length() + 3);
    String str = this.url;
    int j = Util.delimiterOffset(str, i, str.length(), "?#");
    return this.url.substring(i, j);
  }
  
  public List<String> encodedPathSegments()
  {
    int i = this.url.indexOf('/', this.scheme.length() + 3);
    Object localObject = this.url;
    int j = Util.delimiterOffset((String)localObject, i, ((String)localObject).length(), "?#");
    localObject = new ArrayList();
    while (i < j)
    {
      int k = i + 1;
      i = Util.delimiterOffset(this.url, k, j, '/');
      ((List)localObject).add(this.url.substring(k, i));
    }
    return localObject;
  }
  
  @Nullable
  public String encodedQuery()
  {
    if (this.queryNamesAndValues == null) {
      return null;
    }
    int i = this.url.indexOf('?') + 1;
    String str = this.url;
    int j = Util.delimiterOffset(str, i, str.length(), '#');
    return this.url.substring(i, j);
  }
  
  public String encodedUsername()
  {
    if (this.username.isEmpty()) {
      return "";
    }
    int i = this.scheme.length() + 3;
    String str = this.url;
    int j = Util.delimiterOffset(str, i, str.length(), ":@");
    return this.url.substring(i, j);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof HttpUrl)) && (((HttpUrl)paramObject).url.equals(this.url));
  }
  
  @Nullable
  public String fragment()
  {
    return this.fragment;
  }
  
  public int hashCode()
  {
    return this.url.hashCode();
  }
  
  public String host()
  {
    return this.host;
  }
  
  public boolean isHttps()
  {
    return this.scheme.equals("https");
  }
  
  public HttpUrl.Builder newBuilder()
  {
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    localBuilder.scheme = this.scheme;
    localBuilder.encodedUsername = encodedUsername();
    localBuilder.encodedPassword = encodedPassword();
    localBuilder.host = this.host;
    int i;
    if (this.port != defaultPort(this.scheme)) {
      i = this.port;
    } else {
      i = -1;
    }
    localBuilder.port = i;
    localBuilder.encodedPathSegments.clear();
    localBuilder.encodedPathSegments.addAll(encodedPathSegments());
    localBuilder.encodedQuery(encodedQuery());
    localBuilder.encodedFragment = encodedFragment();
    return localBuilder;
  }
  
  @Nullable
  public HttpUrl.Builder newBuilder(String paramString)
  {
    try
    {
      paramString = new HttpUrl.Builder().parse(this, paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      label15:
      break label15;
    }
    return null;
  }
  
  public String password()
  {
    return this.password;
  }
  
  public List<String> pathSegments()
  {
    return this.pathSegments;
  }
  
  public int pathSize()
  {
    return this.pathSegments.size();
  }
  
  public int port()
  {
    return this.port;
  }
  
  @Nullable
  public String query()
  {
    if (this.queryNamesAndValues == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    namesAndValuesToQueryString(localStringBuilder, this.queryNamesAndValues);
    return localStringBuilder.toString();
  }
  
  @Nullable
  public String queryParameter(String paramString)
  {
    List localList = this.queryNamesAndValues;
    if (localList == null) {
      return null;
    }
    int i = 0;
    int j = localList.size();
    while (i < j)
    {
      if (paramString.equals(this.queryNamesAndValues.get(i))) {
        return (String)this.queryNamesAndValues.get(i + 1);
      }
      i += 2;
    }
    return null;
  }
  
  public String queryParameterName(int paramInt)
  {
    List localList = this.queryNamesAndValues;
    if (localList != null) {
      return (String)localList.get(paramInt * 2);
    }
    throw new IndexOutOfBoundsException();
  }
  
  public Set<String> queryParameterNames()
  {
    if (this.queryNamesAndValues == null) {
      return Collections.emptySet();
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    int i = 0;
    int j = this.queryNamesAndValues.size();
    while (i < j)
    {
      localLinkedHashSet.add(this.queryNamesAndValues.get(i));
      i += 2;
    }
    return Collections.unmodifiableSet(localLinkedHashSet);
  }
  
  public String queryParameterValue(int paramInt)
  {
    List localList = this.queryNamesAndValues;
    if (localList != null) {
      return (String)localList.get(paramInt * 2 + 1);
    }
    throw new IndexOutOfBoundsException();
  }
  
  public List<String> queryParameterValues(String paramString)
  {
    if (this.queryNamesAndValues == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = this.queryNamesAndValues.size();
    while (i < j)
    {
      if (paramString.equals(this.queryNamesAndValues.get(i))) {
        localArrayList.add(this.queryNamesAndValues.get(i + 1));
      }
      i += 2;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public int querySize()
  {
    List localList = this.queryNamesAndValues;
    if (localList != null) {
      return localList.size() / 2;
    }
    return 0;
  }
  
  public String redact()
  {
    return newBuilder("/...").username("").password("").build().toString();
  }
  
  @Nullable
  public HttpUrl resolve(String paramString)
  {
    paramString = newBuilder(paramString);
    if (paramString != null) {
      return paramString.build();
    }
    return null;
  }
  
  public String scheme()
  {
    return this.scheme;
  }
  
  public String toString()
  {
    return this.url;
  }
  
  @Nullable
  public String topPrivateDomain()
  {
    if (Util.verifyAsIpAddress(this.host)) {
      return null;
    }
    return PublicSuffixDatabase.get().getEffectiveTldPlusOne(this.host);
  }
  
  public URI uri()
  {
    Object localObject = newBuilder().reencodeForUri().toString();
    try
    {
      URI localURI = new URI((String)localObject);
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException) {}
    try
    {
      localObject = URI.create(((String)localObject).replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
      return localObject;
    }
    catch (Exception localException)
    {
      label38:
      break label38;
    }
    throw new RuntimeException(localURISyntaxException);
  }
  
  public URL url()
  {
    try
    {
      URL localURL = new URL(this.url);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new RuntimeException(localMalformedURLException);
    }
  }
  
  public String username()
  {
    return this.username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.HttpUrl
 * JD-Core Version:    0.7.0.1
 */