package com.tencent.qapmsdk.socket.hpack;

public class Http2Reader
{
  static int lengthWithoutPadding(int paramInt, byte paramByte, short paramShort)
  {
    short s = paramInt;
    if ((paramByte & 0x8) != 0) {
      s = paramInt - 1;
    }
    if (paramShort > s) {
      throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(s) });
    }
    return (short)(s - paramShort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.hpack.Http2Reader
 * JD-Core Version:    0.7.0.1
 */