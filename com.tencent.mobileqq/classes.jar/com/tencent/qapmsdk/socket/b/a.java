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
    int i = paramBufferedSource.readByte();
    int j = paramBufferedSource.readByte();
    return paramBufferedSource.readByte() & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  private List<b> a(int paramInt1, short paramShort, byte paramByte, int paramInt2)
  {
    a.a locala = this.b;
    locala.d = paramInt1;
    locala.a = paramInt1;
    locala.e = paramShort;
    locala.b = paramByte;
    locala.c = paramInt2;
    this.c.a();
    return this.c.b();
  }
  
  private void a(e.a parama, int paramInt)
  {
    int i = this.a.readInt();
    boolean bool;
    if ((0x80000000 & i) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    parama.a(paramInt, i & 0x7FFFFFFF, (this.a.readByte() & 0xFF) + 1, bool);
  }
  
  private void a(e.a parama, int paramInt1, byte paramByte, int paramInt2)
  {
    short s = 0;
    if (paramInt2 != 0)
    {
      boolean bool1;
      if ((paramByte & 0x1) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if ((paramByte & 0x4) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
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
    }
    throw d.a("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
  }
  
  private void b(e.a parama, int paramInt1, byte paramByte, int paramInt2)
  {
    short s = 0;
    if (paramInt2 != 0)
    {
      int i = 1;
      boolean bool;
      if ((paramByte & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      if ((paramByte & 0x20) == 0) {
        i = 0;
      }
      if (i == 0)
      {
        if ((paramByte & 0x8) != 0) {
          s = (short)(this.a.readByte() & 0xFF);
        }
        paramInt1 = e.a(paramInt1, paramByte, s);
        parama.a(bool, paramInt2, this.a, paramInt1);
        this.a.skip(s);
        return;
      }
      throw d.a("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    }
    throw d.a("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
  }
  
  private void c(e.a parama, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 == 5)
    {
      if (paramInt2 != 0)
      {
        a(parama, paramInt2);
        return;
      }
      throw d.a("TYPE_PRIORITY streamId == 0", new Object[0]);
    }
    throw d.a("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  public boolean a(e.a parama)
  {
    try
    {
      this.a.require(9L);
      int i = a(this.a);
      if ((i >= 0) && (i <= 16384))
      {
        byte b1 = (byte)(this.a.readByte() & 0xFF);
        byte b2 = (byte)(this.a.readByte() & 0xFF);
        int j = this.a.readInt() & 0x7FFFFFFF;
        Logger.INSTANCE.d(new String[] { "HTTP2Decode", d.a(true, j, i, b1, b2) });
        if (b1 != 0)
        {
          if (b1 != 1)
          {
            if (b1 != 2)
            {
              this.a.skip(i);
              return true;
            }
            c(parama, i, b2, j);
            return true;
          }
          a(parama, i, b2, j);
          return true;
        }
        b(parama, i, b2, j);
        return true;
      }
      throw d.a("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(i) });
    }
    catch (IOException parama) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.b.a
 * JD-Core Version:    0.7.0.1
 */