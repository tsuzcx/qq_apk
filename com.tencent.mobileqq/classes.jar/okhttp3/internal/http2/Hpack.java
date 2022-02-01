package okhttp3.internal.http2;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import okio.ByteString;

final class Hpack
{
  static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
  private static final int PREFIX_4_BITS = 15;
  private static final int PREFIX_5_BITS = 31;
  private static final int PREFIX_6_BITS = 63;
  private static final int PREFIX_7_BITS = 127;
  static final Header[] STATIC_HEADER_TABLE = { new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "") };
  
  static ByteString checkLowercase(ByteString paramByteString)
  {
    int j = paramByteString.size();
    int i = 0;
    while (i < j)
    {
      int k = paramByteString.getByte(i);
      if ((k >= 65) && (k <= 90))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PROTOCOL_ERROR response malformed: mixed case name: ");
        localStringBuilder.append(paramByteString.utf8());
        throw new IOException(localStringBuilder.toString());
      }
      i += 1;
    }
    return paramByteString;
  }
  
  private static Map<ByteString, Integer> nameToFirstIndex()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
    int i = 0;
    for (;;)
    {
      Header[] arrayOfHeader = STATIC_HEADER_TABLE;
      if (i >= arrayOfHeader.length) {
        break;
      }
      if (!localLinkedHashMap.containsKey(arrayOfHeader[i].name)) {
        localLinkedHashMap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
      }
      i += 1;
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.http2.Hpack
 * JD-Core Version:    0.7.0.1
 */