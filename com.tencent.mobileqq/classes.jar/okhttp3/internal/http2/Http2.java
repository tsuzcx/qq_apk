package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.Util;
import okio.ByteString;

public final class Http2
{
  static final String[] BINARY;
  static final ByteString CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  static final String[] FLAGS;
  static final byte FLAG_ACK = 1;
  static final byte FLAG_COMPRESSED = 32;
  static final byte FLAG_END_HEADERS = 4;
  static final byte FLAG_END_PUSH_PROMISE = 4;
  static final byte FLAG_END_STREAM = 1;
  static final byte FLAG_NONE = 0;
  static final byte FLAG_PADDED = 8;
  static final byte FLAG_PRIORITY = 32;
  private static final String[] FRAME_NAMES;
  static final int INITIAL_MAX_FRAME_SIZE = 16384;
  static final byte TYPE_CONTINUATION = 9;
  static final byte TYPE_DATA = 0;
  static final byte TYPE_GOAWAY = 7;
  static final byte TYPE_HEADERS = 1;
  static final byte TYPE_PING = 6;
  static final byte TYPE_PRIORITY = 2;
  static final byte TYPE_PUSH_PROMISE = 5;
  static final byte TYPE_RST_STREAM = 3;
  static final byte TYPE_SETTINGS = 4;
  static final byte TYPE_WINDOW_UPDATE = 8;
  
  static
  {
    int k = 0;
    FRAME_NAMES = new String[] { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
    FLAGS = new String[64];
    BINARY = new String[256];
    int i = 0;
    for (;;)
    {
      localObject1 = BINARY;
      if (i >= localObject1.length) {
        break;
      }
      localObject1[i] = Util.format("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
      i += 1;
    }
    Object localObject2 = FLAGS;
    localObject2[0] = "";
    localObject2[1] = "END_STREAM";
    Object localObject1 = new int[1];
    localObject1[0] = 1;
    localObject2[8] = "PADDED";
    int j = localObject1.length;
    i = 0;
    Object localObject3;
    while (i < j)
    {
      m = localObject1[i];
      localObject2 = FLAGS;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(FLAGS[m]);
      ((StringBuilder)localObject3).append("|PADDED");
      localObject2[(m | 0x8)] = ((StringBuilder)localObject3).toString();
      i += 1;
    }
    localObject2 = FLAGS;
    localObject2[4] = "END_HEADERS";
    localObject2[32] = "PRIORITY";
    localObject2[36] = "END_HEADERS|PRIORITY";
    localObject2 = new int[3];
    Object tmp271_269 = localObject2;
    tmp271_269[0] = 4;
    Object tmp275_271 = tmp271_269;
    tmp275_271[1] = 32;
    Object tmp280_275 = tmp275_271;
    tmp280_275[2] = 36;
    tmp280_275;
    int m = localObject2.length;
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      int n = localObject2[i];
      int i1 = localObject1.length;
      j = 0;
      while (j < i1)
      {
        int i2 = localObject1[j];
        localObject3 = FLAGS;
        int i3 = i2 | n;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(FLAGS[i2]);
        localStringBuilder.append('|');
        localStringBuilder.append(FLAGS[n]);
        localObject3[i3] = localStringBuilder.toString();
        localObject3 = FLAGS;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(FLAGS[i2]);
        localStringBuilder.append('|');
        localStringBuilder.append(FLAGS[n]);
        localStringBuilder.append("|PADDED");
        localObject3[(i3 | 0x8)] = localStringBuilder.toString();
        j += 1;
      }
      i += 1;
    }
    for (;;)
    {
      localObject1 = FLAGS;
      if (j >= localObject1.length) {
        break;
      }
      if (localObject1[j] == null) {
        localObject1[j] = BINARY[j];
      }
      j += 1;
    }
  }
  
  static String formatFlags(byte paramByte1, byte paramByte2)
  {
    if (paramByte2 == 0) {
      return "";
    }
    if ((paramByte1 != 2) && (paramByte1 != 3)) {
      if ((paramByte1 != 4) && (paramByte1 != 6))
      {
        if ((paramByte1 != 7) && (paramByte1 != 8))
        {
          Object localObject = FLAGS;
          if (paramByte2 < localObject.length) {
            localObject = localObject[paramByte2];
          } else {
            localObject = BINARY[paramByte2];
          }
          if ((paramByte1 == 5) && ((paramByte2 & 0x4) != 0)) {
            return ((String)localObject).replace("HEADERS", "PUSH_PROMISE");
          }
          if ((paramByte1 == 0) && ((paramByte2 & 0x20) != 0)) {
            return ((String)localObject).replace("PRIORITY", "COMPRESSED");
          }
          return localObject;
        }
      }
      else
      {
        if (paramByte2 == 1) {
          return "ACK";
        }
        return BINARY[paramByte2];
      }
    }
    return BINARY[paramByte2];
  }
  
  static String frameLog(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    Object localObject = FRAME_NAMES;
    if (paramByte1 < localObject.length) {
      localObject = localObject[paramByte1];
    } else {
      localObject = Util.format("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
    }
    String str2 = formatFlags(paramByte1, paramByte2);
    String str1;
    if (paramBoolean) {
      str1 = "<<";
    } else {
      str1 = ">>";
    }
    return Util.format("%s 0x%08x %5d %-13s %s", new Object[] { str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject, str2 });
  }
  
  static IllegalArgumentException illegalArgument(String paramString, Object... paramVarArgs)
  {
    throw new IllegalArgumentException(Util.format(paramString, paramVarArgs));
  }
  
  static IOException ioException(String paramString, Object... paramVarArgs)
  {
    throw new IOException(Util.format(paramString, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.http2.Http2
 * JD-Core Version:    0.7.0.1
 */