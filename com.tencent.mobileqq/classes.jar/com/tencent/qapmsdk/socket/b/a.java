package com.tencent.qapmsdk.socket.b;

import com.tencent.qapmsdk.common.logger.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import okio.BufferedSource;
import okio.Okio;

public class a
{
  private BufferedSource a;
  private a.a b;
  private c.a c;
  
  public a(InputStream paramInputStream)
  {
    this.a = Okio.buffer(Okio.source(paramInputStream));
    this.b = new a.a(this.a);
    this.c = new c.a(4096, this.b);
  }
  
  static int a(BufferedSource paramBufferedSource)
  {
    return (paramBufferedSource.readByte() & 0xFF) << 16 | (paramBufferedSource.readByte() & 0xFF) << 8 | paramBufferedSource.readByte() & 0xFF;
  }
  
  private List<b> a(int paramInt1, short paramShort, byte paramByte, int paramInt2)
  {
    a.a locala = this.b;
    this.b.d = paramInt1;
    locala.a = paramInt1;
    this.b.e = paramShort;
    this.b.b = paramByte;
    this.b.c = paramInt2;
    this.c.a();
    return this.c.b();
  }
  
  private void a(e.a parama, int paramInt)
  {
    int i = this.a.readInt();
    if ((0x80000000 & i) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      parama.a(paramInt, i & 0x7FFFFFFF, (this.a.readByte() & 0xFF) + 1, bool);
      return;
    }
  }
  
  private void a(e.a parama, int paramInt1, byte paramByte, int paramInt2)
  {
    boolean bool2 = true;
    short s = 0;
    if (paramInt2 == 0) {
      throw d.a("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }
    boolean bool1;
    if ((paramByte & 0x1) != 0)
    {
      bool1 = true;
      if ((paramByte & 0x4) == 0) {
        break label118;
      }
    }
    for (;;)
    {
      if ((paramByte & 0x8) != 0) {
        s = (short)(this.a.readByte() & 0xFF);
      }
      int i = paramInt1;
      if ((paramByte & 0x20) != 0)
      {
        a(parama, paramInt2);
        i = paramInt1 - 5;
      }
      parama.a(bool1, bool2, paramInt2, -1, a(e.a(i, paramByte, s), s, paramByte, paramInt2));
      return;
      bool1 = false;
      break;
      label118:
      bool2 = false;
    }
  }
  
  private void b(e.a parama, int paramInt1, byte paramByte, int paramInt2)
  {
    int i = 1;
    short s = 0;
    if (paramInt2 == 0) {
      throw d.a("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }
    boolean bool;
    if ((paramByte & 0x1) != 0)
    {
      bool = true;
      if ((paramByte & 0x20) == 0) {
        break label58;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label64;
      }
      throw d.a("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
      bool = false;
      break;
      label58:
      i = 0;
    }
    label64:
    if ((paramByte & 0x8) != 0) {
      s = (short)(this.a.readByte() & 0xFF);
    }
    paramInt1 = e.a(paramInt1, paramByte, s);
    parama.a(bool, paramInt2, this.a, paramInt1);
    this.a.skip(s);
  }
  
  private void c(e.a parama, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 != 5) {
      throw d.a("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 == 0) {
      throw d.a("TYPE_PRIORITY streamId == 0", new Object[0]);
    }
    a(parama, paramInt2);
  }
  
  public boolean a(e.a parama)
  {
    int i;
    try
    {
      this.a.require(9L);
      i = a(this.a);
      if ((i < 0) || (i > 16384)) {
        throw d.a("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    catch (IOException parama)
    {
      return false;
    }
    byte b1 = (byte)(this.a.readByte() & 0xFF);
    byte b2 = (byte)(this.a.readByte() & 0xFF);
    int j = this.a.readInt() & 0x7FFFFFFF;
    Logger.INSTANCE.d(new String[] { "HTTP2Decode", d.a(true, j, i, b1, b2) });
    switch (b1)
    {
    default: 
      this.a.skip(i);
      return true;
    case 0: 
      b(parama, i, b2, j);
      return true;
    case 1: 
      a(parama, i, b2, j);
      return true;
    }
    c(parama, i, b2, j);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.b.a
 * JD-Core Version:    0.7.0.1
 */