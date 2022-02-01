package me.weishu.epic.art.method;

import android.os.Build.VERSION;
import com.qq.android.dexposed.utility.Runtime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import me.weishu.epic.art.EpicNative;

class Offset
{
  static Offset a;
  static Offset b;
  static Offset c;
  private long d;
  private Offset.BitWidth e;
  
  static {}
  
  public static long a(long paramLong, Offset paramOffset)
  {
    byte[] arrayOfByte = EpicNative.b(paramLong + paramOffset.d, paramOffset.e.width);
    if (paramOffset.e == Offset.BitWidth.DWORD) {
      return ByteBuffer.wrap(arrayOfByte).order(ByteOrder.LITTLE_ENDIAN).getInt() & 0xFFFFFFFF;
    }
    return ByteBuffer.wrap(arrayOfByte).order(ByteOrder.LITTLE_ENDIAN).getLong();
  }
  
  private static void a()
  {
    a = new Offset();
    b = new Offset();
    c = new Offset();
    b.a(Offset.BitWidth.DWORD);
    int i = Build.VERSION.SDK_INT;
    if (i <= 27)
    {
      if (Runtime.a())
      {
        a.a(Offset.BitWidth.QWORD);
        c.a(Offset.BitWidth.QWORD);
        switch (i)
        {
        case 20: 
        default: 
          localStringBuilder = new StringBuilder("API LEVEL: ");
          localStringBuilder.append(i);
          localStringBuilder.append(" is not supported now : (");
          throw new RuntimeException(localStringBuilder.toString());
        case 26: 
        case 27: 
          a.a(40L);
          c.a(32L);
          b.a(4L);
          return;
        case 24: 
        case 25: 
          a.a(48L);
          c.a(40L);
          b.a(4L);
          return;
        case 23: 
          a.a(48L);
          c.a(40L);
          b.a(12L);
          return;
        case 22: 
          a.a(52L);
          c.a(44L);
          b.a(20L);
          return;
        case 21: 
          a.a(40L);
          a.a(Offset.BitWidth.QWORD);
          c.a(32L);
          c.a(Offset.BitWidth.QWORD);
          b.a(56L);
          return;
        }
        a.a(32L);
        b.a(28L);
        return;
      }
      a.a(Offset.BitWidth.DWORD);
      c.a(Offset.BitWidth.DWORD);
      switch (i)
      {
      case 20: 
      default: 
        localStringBuilder = new StringBuilder("API LEVEL: ");
        localStringBuilder.append(i);
        localStringBuilder.append(" is not supported now : (");
        throw new RuntimeException(localStringBuilder.toString());
      case 26: 
      case 27: 
        a.a(28L);
        c.a(24L);
        b.a(4L);
        return;
      case 24: 
      case 25: 
        a.a(32L);
        c.a(28L);
        b.a(4L);
        return;
      case 23: 
        a.a(36L);
        c.a(32L);
        b.a(12L);
        return;
      case 22: 
        a.a(44L);
        c.a(40L);
        b.a(20L);
        return;
      case 21: 
        a.a(40L);
        a.a(Offset.BitWidth.QWORD);
        c.a(32L);
        c.a(Offset.BitWidth.QWORD);
        b.a(56L);
        return;
      }
      a.a(32L);
      b.a(28L);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("API LEVEL: ");
    localStringBuilder.append(i);
    localStringBuilder.append(" is not supported now : (");
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(Offset.BitWidth paramBitWidth)
  {
    this.e = paramBitWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     me.weishu.epic.art.method.Offset
 * JD-Core Version:    0.7.0.1
 */