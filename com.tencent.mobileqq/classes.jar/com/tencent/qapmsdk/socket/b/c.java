package com.tencent.qapmsdk.socket.b;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import okio.ByteString;

final class c
{
  static final b[] a = { new b(b.f, ""), new b(b.c, "GET"), new b(b.c, "POST"), new b(b.d, "/"), new b(b.d, "/index.html"), new b(b.e, "http"), new b(b.e, "https"), new b(b.b, "200"), new b(b.b, "204"), new b(b.b, "206"), new b(b.b, "304"), new b(b.b, "400"), new b(b.b, "404"), new b(b.b, "500"), new b("accept-charset", ""), new b("accept-encoding", "gzip, deflate"), new b("accept-language", ""), new b("accept-ranges", ""), new b("accept", ""), new b("access-control-allow-origin", ""), new b("age", ""), new b("allow", ""), new b("authorization", ""), new b("cache-control", ""), new b("content-disposition", ""), new b("content-encoding", ""), new b("content-language", ""), new b("content-length", ""), new b("content-location", ""), new b("content-range", ""), new b("content-type", ""), new b("cookie", ""), new b("date", ""), new b("etag", ""), new b("expect", ""), new b("expires", ""), new b("from", ""), new b("host", ""), new b("if-match", ""), new b("if-modified-since", ""), new b("if-none-match", ""), new b("if-range", ""), new b("if-unmodified-since", ""), new b("last-modified", ""), new b("link", ""), new b("location", ""), new b("max-forwards", ""), new b("proxy-authenticate", ""), new b("proxy-authorization", ""), new b("range", ""), new b("referer", ""), new b("refresh", ""), new b("retry-after", ""), new b("server", ""), new b("set-cookie", ""), new b("strict-transport-security", ""), new b("transfer-encoding", ""), new b("user-agent", ""), new b("vary", ""), new b("via", ""), new b("www-authenticate", "") };
  static final Map<ByteString, Integer> b = a();
  
  private static Map<ByteString, Integer> a()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(a.length);
    int i = 0;
    for (;;)
    {
      b[] arrayOfb = a;
      if (i >= arrayOfb.length) {
        break;
      }
      if (!localLinkedHashMap.containsKey(arrayOfb[i].g)) {
        localLinkedHashMap.put(a[i].g, Integer.valueOf(i));
      }
      i += 1;
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  static ByteString a(ByteString paramByteString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.b.c
 * JD-Core Version:    0.7.0.1
 */