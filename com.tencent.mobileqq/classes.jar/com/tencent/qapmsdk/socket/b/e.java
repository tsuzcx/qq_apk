package com.tencent.qapmsdk.socket.b;

public class e
{
  static int a(int paramInt, byte paramByte, short paramShort)
  {
    short s = paramInt;
    if ((paramByte & 0x8) != 0) {
      s = paramInt - 1;
    }
    if (paramShort <= s) {
      return (short)(s - paramShort);
    }
    throw d.a("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(s) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.b.e
 * JD-Core Version:    0.7.0.1
 */