package com.tencent.qapmsdk.socket.b;

import java.io.IOException;
import okio.ByteString;

public final class d
{
  static final ByteString a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  static final String[] b = new String[64];
  static final String[] c = new String[256];
  private static final String[] d;
  
  static
  {
    int k = 0;
    d = new String[] { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
    int i = 0;
    for (;;)
    {
      localObject1 = c;
      if (i >= localObject1.length) {
        break;
      }
      localObject1[i] = g.a("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
      i += 1;
    }
    Object localObject2 = b;
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
      localObject2 = b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(b[m]);
      ((StringBuilder)localObject3).append("|PADDED");
      localObject2[(m | 0x8)] = ((StringBuilder)localObject3).toString();
      i += 1;
    }
    localObject2 = b;
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
        localObject3 = b;
        int i3 = i2 | n;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(b[i2]);
        localStringBuilder.append('|');
        localStringBuilder.append(b[n]);
        localObject3[i3] = localStringBuilder.toString();
        localObject3 = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(b[i2]);
        localStringBuilder.append('|');
        localStringBuilder.append(b[n]);
        localStringBuilder.append("|PADDED");
        localObject3[(i3 | 0x8)] = localStringBuilder.toString();
        j += 1;
      }
      i += 1;
    }
    for (;;)
    {
      localObject1 = b;
      if (j >= localObject1.length) {
        break;
      }
      if (localObject1[j] == null) {
        localObject1[j] = c[j];
      }
      j += 1;
    }
  }
  
  static IOException a(String paramString, Object... paramVarArgs)
  {
    throw new IOException(g.a(paramString, paramVarArgs));
  }
  
  static String a(byte paramByte1, byte paramByte2)
  {
    if (paramByte2 == 0) {
      return "";
    }
    if ((paramByte1 != 2) && (paramByte1 != 3)) {
      if ((paramByte1 != 4) && (paramByte1 != 6))
      {
        if ((paramByte1 != 7) && (paramByte1 != 8))
        {
          Object localObject = b;
          if (paramByte2 < localObject.length) {
            localObject = localObject[paramByte2];
          } else {
            localObject = c[paramByte2];
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
        return c[paramByte2];
      }
    }
    return c[paramByte2];
  }
  
  static String a(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    Object localObject = d;
    if (paramByte1 < localObject.length) {
      localObject = localObject[paramByte1];
    } else {
      localObject = g.a("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
    }
    String str2 = a(paramByte1, paramByte2);
    String str1;
    if (paramBoolean) {
      str1 = "<<";
    } else {
      str1 = ">>";
    }
    return g.a("%s 0x%08x %5d %-13s %s", new Object[] { str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject, str2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.b.d
 * JD-Core Version:    0.7.0.1
 */