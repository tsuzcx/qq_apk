package okhttp3.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class Util
{
  public static final byte[] EMPTY_BYTE_ARRAY;
  public static final RequestBody EMPTY_REQUEST;
  public static final ResponseBody EMPTY_RESPONSE;
  public static final String[] EMPTY_STRING_ARRAY;
  public static final Charset ISO_8859_1;
  public static final Comparator<String> NATURAL_ORDER;
  public static final TimeZone UTC;
  private static final Charset UTF_16_BE;
  private static final ByteString UTF_16_BE_BOM;
  private static final Charset UTF_16_LE;
  private static final ByteString UTF_16_LE_BOM;
  private static final Charset UTF_32_BE;
  private static final ByteString UTF_32_BE_BOM;
  private static final Charset UTF_32_LE;
  private static final ByteString UTF_32_LE_BOM;
  public static final Charset UTF_8;
  private static final ByteString UTF_8_BOM;
  private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  private static final Method addSuppressedExceptionMethod;
  
  static
  {
    Object localObject = null;
    EMPTY_BYTE_ARRAY = new byte[0];
    EMPTY_STRING_ARRAY = new String[0];
    EMPTY_RESPONSE = ResponseBody.create(null, EMPTY_BYTE_ARRAY);
    EMPTY_REQUEST = RequestBody.create(null, EMPTY_BYTE_ARRAY);
    UTF_8_BOM = ByteString.decodeHex("efbbbf");
    UTF_16_BE_BOM = ByteString.decodeHex("feff");
    UTF_16_LE_BOM = ByteString.decodeHex("fffe");
    UTF_32_BE_BOM = ByteString.decodeHex("0000ffff");
    UTF_32_LE_BOM = ByteString.decodeHex("ffff0000");
    UTF_8 = Charset.forName("UTF-8");
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    UTF_16_BE = Charset.forName("UTF-16BE");
    UTF_16_LE = Charset.forName("UTF-16LE");
    UTF_32_BE = Charset.forName("UTF-32BE");
    UTF_32_LE = Charset.forName("UTF-32LE");
    UTC = TimeZone.getTimeZone("GMT");
    NATURAL_ORDER = new Util.1();
    try
    {
      Method localMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
      localObject = localMethod;
    }
    catch (Exception localException)
    {
      label160:
      break label160;
    }
    addSuppressedExceptionMethod = localObject;
  }
  
  public static void addSuppressedIfPossible(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if (addSuppressedExceptionMethod != null) {}
    try
    {
      addSuppressedExceptionMethod.invoke(paramThrowable1, new Object[] { paramThrowable2 });
      return;
    }
    catch (IllegalAccessException paramThrowable1) {}catch (InvocationTargetException paramThrowable1) {}
  }
  
  public static AssertionError assertionError(String paramString, Exception paramException)
  {
    paramString = new AssertionError(paramString);
    try
    {
      paramString.initCause(paramException);
      return paramString;
    }
    catch (IllegalStateException paramException) {}
    return paramString;
  }
  
  public static Charset bomAwareCharset(BufferedSource paramBufferedSource, Charset paramCharset)
  {
    if (paramBufferedSource.rangeEquals(0L, UTF_8_BOM))
    {
      paramBufferedSource.skip(UTF_8_BOM.size());
      paramCharset = UTF_8;
    }
    do
    {
      return paramCharset;
      if (paramBufferedSource.rangeEquals(0L, UTF_16_BE_BOM))
      {
        paramBufferedSource.skip(UTF_16_BE_BOM.size());
        return UTF_16_BE;
      }
      if (paramBufferedSource.rangeEquals(0L, UTF_16_LE_BOM))
      {
        paramBufferedSource.skip(UTF_16_LE_BOM.size());
        return UTF_16_LE;
      }
      if (paramBufferedSource.rangeEquals(0L, UTF_32_BE_BOM))
      {
        paramBufferedSource.skip(UTF_32_BE_BOM.size());
        return UTF_32_BE;
      }
    } while (!paramBufferedSource.rangeEquals(0L, UTF_32_LE_BOM));
    paramBufferedSource.skip(UTF_32_LE_BOM.size());
    return UTF_32_LE;
  }
  
  public static String canonicalizeHost(String paramString)
  {
    Object localObject;
    if (paramString.contains(":")) {
      if ((paramString.startsWith("[")) && (paramString.endsWith("]")))
      {
        localObject = decodeIpv6(paramString, 1, paramString.length() - 1);
        if (localObject != null) {
          break label58;
        }
      }
    }
    for (;;)
    {
      return null;
      localObject = decodeIpv6(paramString, 0, paramString.length());
      break;
      label58:
      localObject = ((InetAddress)localObject).getAddress();
      if (localObject.length == 16) {
        return inet6AddressToAscii((byte[])localObject);
      }
      throw new AssertionError("Invalid IPv6 address: '" + paramString + "'");
      try
      {
        paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
        if (!paramString.isEmpty())
        {
          boolean bool = containsInvalidHostnameAsciiCodes(paramString);
          if (!bool) {
            return paramString;
          }
        }
      }
      catch (IllegalArgumentException paramString) {}
    }
    return null;
  }
  
  public static int checkDuration(String paramString, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException(paramString + " < 0");
    }
    if (paramTimeUnit == null) {
      throw new NullPointerException("unit == null");
    }
    long l = paramTimeUnit.toMillis(paramLong);
    if (l > 2147483647L) {
      throw new IllegalArgumentException(paramString + " too large.");
    }
    if ((l == 0L) && (paramLong > 0L)) {
      throw new IllegalArgumentException(paramString + " too small.");
    }
    return (int)l;
  }
  
  public static void checkOffsetAndCount(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) < 0L) || (paramLong2 > paramLong1) || (paramLong1 - paramLong2 < paramLong3)) {
      throw new ArrayIndexOutOfBoundsException();
    }
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static void closeQuietly(ServerSocket paramServerSocket)
  {
    if (paramServerSocket != null) {}
    try
    {
      paramServerSocket.close();
      return;
    }
    catch (RuntimeException paramServerSocket)
    {
      throw paramServerSocket;
    }
    catch (Exception paramServerSocket) {}
  }
  
  public static void closeQuietly(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.close();
      return;
    }
    catch (AssertionError paramSocket)
    {
      while (isAndroidGetsocknameError(paramSocket)) {}
      throw paramSocket;
    }
    catch (RuntimeException paramSocket)
    {
      throw paramSocket;
    }
    catch (Exception paramSocket) {}
  }
  
  public static String[] concat(String[] paramArrayOfString, String paramString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    arrayOfString[(arrayOfString.length - 1)] = paramString;
    return arrayOfString;
  }
  
  private static boolean containsInvalidHostnameAsciiCodes(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      int j;
      if (i < paramString.length())
      {
        j = paramString.charAt(i);
        if ((j <= 31) || (j >= 127)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      if (" #%/:?@[\\]".indexOf(j) != -1) {
        return true;
      }
      i += 1;
    }
  }
  
  public static int decodeHexDigit(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    return -1;
  }
  
  private static boolean decodeIpv4Suffix(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    int j = paramInt3;
    int i = paramInt1;
    while (i < paramInt2)
    {
      if (j == paramArrayOfByte.length) {
        return false;
      }
      paramInt1 = i;
      if (j != paramInt3)
      {
        if (paramString.charAt(i) != '.') {
          return false;
        }
        paramInt1 = i + 1;
      }
      int k = 0;
      i = paramInt1;
      for (;;)
      {
        int m;
        if (i < paramInt2)
        {
          m = paramString.charAt(i);
          if ((m >= 48) && (m <= 57)) {}
        }
        else
        {
          if (i - paramInt1 != 0) {
            break;
          }
          return false;
        }
        if ((k == 0) && (paramInt1 != i)) {
          return false;
        }
        k = k * 10 + m - 48;
        if (k > 255) {
          return false;
        }
        i += 1;
      }
      paramArrayOfByte[j] = ((byte)k);
      j += 1;
    }
    return j == paramInt3 + 4;
  }
  
  @Nullable
  private static InetAddress decodeIpv6(String paramString, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[16];
    int i1 = -1;
    int j = -1;
    int i = 0;
    int k = paramInt1;
    int m = j;
    paramInt1 = i;
    if (k < paramInt2)
    {
      if (i == arrayOfByte.length) {
        return null;
      }
      if ((k + 2 <= paramInt2) && (paramString.regionMatches(k, "::", 0, 2)))
      {
        if (j != -1) {
          return null;
        }
        paramInt1 = k + 2;
        i += 2;
        if (paramInt1 != paramInt2) {
          break label354;
        }
        paramInt1 = i;
        m = i;
      }
    }
    else
    {
      if (paramInt1 == arrayOfByte.length) {
        break label337;
      }
      if (m != -1) {
        break label300;
      }
      return null;
    }
    paramInt1 = k;
    m = j;
    int n = i;
    if (i != 0)
    {
      if (!paramString.regionMatches(k, ":", 0, 1)) {
        break label185;
      }
      paramInt1 = k + 1;
      n = i;
    }
    for (m = j;; m = i)
    {
      j = 0;
      i = paramInt1;
      for (;;)
      {
        if (i < paramInt2)
        {
          k = decodeHexDigit(paramString.charAt(i));
          if (k != -1) {}
        }
        else
        {
          k = i - paramInt1;
          if ((k != 0) && (k <= 4)) {
            break label245;
          }
          return null;
          label185:
          if (paramString.regionMatches(k, ".", 0, 1))
          {
            if (!decodeIpv4Suffix(paramString, i1, paramInt2, arrayOfByte, i - 2)) {
              return null;
            }
            paramInt1 = i + 2;
            m = j;
            break;
          }
          return null;
        }
        j = (j << 4) + k;
        i += 1;
      }
      label245:
      k = n + 1;
      arrayOfByte[n] = ((byte)(j >>> 8 & 0xFF));
      n = k + 1;
      arrayOfByte[k] = ((byte)(j & 0xFF));
      k = i;
      j = m;
      i = n;
      i1 = paramInt1;
      break;
      label300:
      System.arraycopy(arrayOfByte, m, arrayOfByte, arrayOfByte.length - (paramInt1 - m), paramInt1 - m);
      Arrays.fill(arrayOfByte, m, arrayOfByte.length - paramInt1 + m, (byte)0);
      try
      {
        label337:
        paramString = InetAddress.getByAddress(arrayOfByte);
        return paramString;
      }
      catch (UnknownHostException paramString)
      {
        throw new AssertionError();
      }
      label354:
      n = i;
    }
  }
  
  public static int delimiterOffset(String paramString, int paramInt1, int paramInt2, char paramChar)
  {
    for (;;)
    {
      int i = paramInt2;
      if (paramInt1 < paramInt2)
      {
        if (paramString.charAt(paramInt1) == paramChar) {
          i = paramInt1;
        }
      }
      else {
        return i;
      }
      paramInt1 += 1;
    }
  }
  
  public static int delimiterOffset(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    for (;;)
    {
      int i = paramInt2;
      if (paramInt1 < paramInt2)
      {
        if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1) {
          i = paramInt1;
        }
      }
      else {
        return i;
      }
      paramInt1 += 1;
    }
  }
  
  public static boolean discard(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool = skipAll(paramSource, paramInt, paramTimeUnit);
      return bool;
    }
    catch (IOException paramSource) {}
    return false;
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static String format(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.US, paramString, paramVarArgs);
  }
  
  public static String hostHeader(HttpUrl paramHttpUrl, boolean paramBoolean)
  {
    if (paramHttpUrl.host().contains(":")) {}
    for (String str1 = "[" + paramHttpUrl.host() + "]";; str1 = paramHttpUrl.host())
    {
      String str2;
      if (!paramBoolean)
      {
        str2 = str1;
        if (paramHttpUrl.port() == HttpUrl.defaultPort(paramHttpUrl.scheme())) {}
      }
      else
      {
        str2 = str1 + ":" + paramHttpUrl.port();
      }
      return str2;
    }
  }
  
  public static <T> List<T> immutableList(List<T> paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public static <T> List<T> immutableList(T... paramVarArgs)
  {
    return Collections.unmodifiableList(Arrays.asList((Object[])paramVarArgs.clone()));
  }
  
  public static <K, V> Map<K, V> immutableMap(Map<K, V> paramMap)
  {
    if (paramMap.isEmpty()) {
      return Collections.emptyMap();
    }
    return Collections.unmodifiableMap(new LinkedHashMap(paramMap));
  }
  
  public static int indexOf(Comparator<String> paramComparator, String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    int j = paramArrayOfString.length;
    while (i < j)
    {
      if (paramComparator.compare(paramArrayOfString[i], paramString) == 0) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static int indexOfControlOrNonAscii(String paramString)
  {
    int i = 0;
    int j = paramString.length();
    while (i < j)
    {
      int k = paramString.charAt(i);
      if ((k <= 31) || (k >= 127)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private static String inet6AddressToAscii(byte[] paramArrayOfByte)
  {
    int i2 = 0;
    int k = 0;
    int j = -1;
    int i = 0;
    int m;
    while (i < paramArrayOfByte.length)
    {
      m = i;
      while ((m < 16) && (paramArrayOfByte[m] == 0) && (paramArrayOfByte[(m + 1)] == 0)) {
        m += 2;
      }
      int i3 = m - i;
      int i1 = k;
      int n = j;
      if (i3 > k)
      {
        i1 = k;
        n = j;
        if (i3 >= 4)
        {
          i1 = i3;
          n = i;
        }
      }
      i = m + 2;
      k = i1;
      j = n;
    }
    Buffer localBuffer = new Buffer();
    i = i2;
    while (i < paramArrayOfByte.length) {
      if (i == j)
      {
        localBuffer.writeByte(58);
        m = i + k;
        i = m;
        if (m == 16)
        {
          localBuffer.writeByte(58);
          i = m;
        }
      }
      else
      {
        if (i > 0) {
          localBuffer.writeByte(58);
        }
        localBuffer.writeHexadecimalUnsignedLong((paramArrayOfByte[i] & 0xFF) << 8 | paramArrayOfByte[(i + 1)] & 0xFF);
        i += 2;
      }
    }
    return localBuffer.readUtf8();
  }
  
  public static String[] intersect(Comparator<? super String> paramComparator, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfString1.length;
    int i = 0;
    if (i < k)
    {
      String str = paramArrayOfString1[i];
      int m = paramArrayOfString2.length;
      int j = 0;
      for (;;)
      {
        if (j < m)
        {
          if (paramComparator.compare(str, paramArrayOfString2[j]) == 0) {
            localArrayList.add(str);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static boolean isAndroidGetsocknameError(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static boolean nonEmptyIntersection(Comparator<String> paramComparator, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length == 0) || (paramArrayOfString2.length == 0)) {}
    for (;;)
    {
      return false;
      int k = paramArrayOfString1.length;
      int i = 0;
      while (i < k)
      {
        String str = paramArrayOfString1[i];
        int m = paramArrayOfString2.length;
        int j = 0;
        while (j < m)
        {
          if (paramComparator.compare(str, paramArrayOfString2[j]) == 0) {
            return true;
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  public static X509TrustManager platformTrustManager()
  {
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init((KeyStore)null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      if ((localObject.length != 1) || (!(localObject[0] instanceof X509TrustManager))) {
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString((Object[])localObject));
      }
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      throw assertionError("No System TLS", localGeneralSecurityException);
    }
    X509TrustManager localX509TrustManager = (X509TrustManager)localGeneralSecurityException[0];
    return localX509TrustManager;
  }
  
  public static boolean skipAll(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
  {
    long l2 = System.nanoTime();
    long l1;
    if (paramSource.timeout().hasDeadline()) {
      l1 = paramSource.timeout().deadlineNanoTime() - l2;
    }
    for (;;)
    {
      paramSource.timeout().deadlineNanoTime(Math.min(l1, paramTimeUnit.toNanos(paramInt)) + l2);
      try
      {
        paramTimeUnit = new Buffer();
        while (paramSource.read(paramTimeUnit, 8192L) != -1L) {
          paramTimeUnit.clear();
        }
      }
      catch (InterruptedIOException paramTimeUnit)
      {
        if (l1 == 9223372036854775807L) {
          paramSource.timeout().clearDeadline();
        }
        for (;;)
        {
          return false;
          l1 = 9223372036854775807L;
          break;
          if (l1 == 9223372036854775807L) {
            paramSource.timeout().clearDeadline();
          }
          for (;;)
          {
            return true;
            paramSource.timeout().deadlineNanoTime(l1 + l2);
          }
          paramSource.timeout().deadlineNanoTime(l1 + l2);
        }
      }
      finally
      {
        if (l1 != 9223372036854775807L) {
          break label188;
        }
      }
    }
    paramSource.timeout().clearDeadline();
    for (;;)
    {
      throw paramTimeUnit;
      label188:
      paramSource.timeout().deadlineNanoTime(l1 + l2);
    }
  }
  
  public static int skipLeadingAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i = paramInt2;
      if (paramInt1 < paramInt2) {}
      switch (paramString.charAt(paramInt1))
      {
      default: 
        i = paramInt1;
        return i;
      }
      paramInt1 += 1;
    }
  }
  
  public static int skipTrailingAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    for (;;)
    {
      int i = paramInt1;
      if (paramInt2 >= paramInt1) {}
      switch (paramString.charAt(paramInt2))
      {
      default: 
        i = paramInt2 + 1;
        return i;
      }
      paramInt2 -= 1;
    }
  }
  
  public static ThreadFactory threadFactory(String paramString, boolean paramBoolean)
  {
    return new Util.2(paramString, paramBoolean);
  }
  
  public static Headers toHeaders(List<Header> paramList)
  {
    Headers.Builder localBuilder = new Headers.Builder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Header localHeader = (Header)paramList.next();
      Internal.instance.addLenient(localBuilder, localHeader.name.utf8(), localHeader.value.utf8());
    }
    return localBuilder.build();
  }
  
  public static String trimSubstring(String paramString, int paramInt1, int paramInt2)
  {
    paramInt1 = skipLeadingAsciiWhitespace(paramString, paramInt1, paramInt2);
    return paramString.substring(paramInt1, skipTrailingAsciiWhitespace(paramString, paramInt1, paramInt2));
  }
  
  public static boolean verifyAsIpAddress(String paramString)
  {
    return VERIFY_AS_IP_ADDRESS.matcher(paramString).matches();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.Util
 * JD-Core Version:    0.7.0.1
 */