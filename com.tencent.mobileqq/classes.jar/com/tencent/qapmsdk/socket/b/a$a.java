package com.tencent.qapmsdk.socket.b;

import com.tencent.qapmsdk.common.logger.Logger;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

final class a$a
  implements Source
{
  int a;
  byte b;
  int c;
  int d;
  short e;
  private final BufferedSource f;
  
  a$a(BufferedSource paramBufferedSource)
  {
    this.f = paramBufferedSource;
  }
  
  private void a()
  {
    int i = this.c;
    int j = a.a(this.f);
    this.d = j;
    this.a = j;
    byte b1 = (byte)(this.f.readByte() & 0xFF);
    this.b = ((byte)(this.f.readByte() & 0xFF));
    Logger.INSTANCE.d(new String[] { "HTTP2Decode", d.a(true, this.c, this.a, b1, this.b) });
    this.c = (this.f.readInt() & 0x7FFFFFFF);
    if (b1 != 9) {
      throw d.a("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b1) });
    }
    if (this.c != i) {
      throw d.a("TYPE_CONTINUATION streamId changed", new Object[0]);
    }
  }
  
  public void close() {}
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (this.d == 0)
    {
      this.f.skip(this.e);
      this.e = 0;
      if ((this.b & 0x4) == 0) {}
    }
    do
    {
      return -1L;
      a();
      break;
      paramLong = this.f.read(paramBuffer, Math.min(paramLong, this.d));
    } while (paramLong == -1L);
    this.d = ((int)(this.d - paramLong));
    return paramLong;
  }
  
  public Timeout timeout()
  {
    return this.f.timeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.b.a.a
 * JD-Core Version:    0.7.0.1
 */