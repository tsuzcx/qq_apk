package okhttp3.internal.ws;

import okio.Buffer.UnsafeCursor;
import okio.ByteString;

public final class WebSocketProtocol
{
  static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
  static final int B0_FLAG_FIN = 128;
  static final int B0_FLAG_RSV1 = 64;
  static final int B0_FLAG_RSV2 = 32;
  static final int B0_FLAG_RSV3 = 16;
  static final int B0_MASK_OPCODE = 15;
  static final int B1_FLAG_MASK = 128;
  static final int B1_MASK_LENGTH = 127;
  static final int CLOSE_CLIENT_GOING_AWAY = 1001;
  static final long CLOSE_MESSAGE_MAX = 123L;
  static final int CLOSE_NO_STATUS_CODE = 1005;
  static final int OPCODE_BINARY = 2;
  static final int OPCODE_CONTINUATION = 0;
  static final int OPCODE_CONTROL_CLOSE = 8;
  static final int OPCODE_CONTROL_PING = 9;
  static final int OPCODE_CONTROL_PONG = 10;
  static final int OPCODE_FLAG_CONTROL = 8;
  static final int OPCODE_TEXT = 1;
  static final long PAYLOAD_BYTE_MAX = 125L;
  static final int PAYLOAD_LONG = 127;
  static final int PAYLOAD_SHORT = 126;
  static final long PAYLOAD_SHORT_MAX = 65535L;
  
  private WebSocketProtocol()
  {
    throw new AssertionError("No instances.");
  }
  
  public static String acceptHeader(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
    return ByteString.encodeUtf8(localStringBuilder.toString()).sha1().base64();
  }
  
  static String closeCodeExceptionMessage(int paramInt)
  {
    if ((paramInt >= 1000) && (paramInt < 5000))
    {
      if (((paramInt >= 1004) && (paramInt <= 1006)) || ((paramInt >= 1012) && (paramInt <= 2999)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Code ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" is reserved and may not be used.");
        return localStringBuilder.toString();
      }
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Code must be in range [1000,5000): ");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  static void toggleMask(Buffer.UnsafeCursor paramUnsafeCursor, byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    int j = 0;
    do
    {
      byte[] arrayOfByte = paramUnsafeCursor.data;
      int i = paramUnsafeCursor.start;
      int m = paramUnsafeCursor.end;
      while (i < m)
      {
        j %= k;
        arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ paramArrayOfByte[j]));
        i += 1;
        j += 1;
      }
    } while (paramUnsafeCursor.next() != -1);
  }
  
  static void validateCloseCode(int paramInt)
  {
    String str = closeCodeExceptionMessage(paramInt);
    if (str == null) {
      return;
    }
    throw new IllegalArgumentException(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.ws.WebSocketProtocol
 * JD-Core Version:    0.7.0.1
 */