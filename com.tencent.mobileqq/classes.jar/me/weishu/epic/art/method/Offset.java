package me.weishu.epic.art.method;

import android.os.Build.VERSION;
import com.qq.android.dexposed.utility.Runtime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import me.weishu.epic.art.EpicNative;

class Offset
{
  static Offset ART_ACCESS_FLAG_OFFSET;
  static Offset ART_JNI_ENTRY_OFFSET;
  static Offset ART_QUICK_CODE_OFFSET;
  private BitWidth length;
  private long offset;
  
  static {}
  
  private static void initFields()
  {
    ART_QUICK_CODE_OFFSET = new Offset();
    ART_ACCESS_FLAG_OFFSET = new Offset();
    ART_JNI_ENTRY_OFFSET = new Offset();
    ART_ACCESS_FLAG_OFFSET.setLength(BitWidth.DWORD);
    int i = Build.VERSION.SDK_INT;
    if (i > 27) {
      throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
    }
    if (Runtime.is64Bit())
    {
      ART_QUICK_CODE_OFFSET.setLength(BitWidth.QWORD);
      ART_JNI_ENTRY_OFFSET.setLength(BitWidth.QWORD);
      switch (i)
      {
      case 20: 
      default: 
        throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
      case 26: 
      case 27: 
        ART_QUICK_CODE_OFFSET.setOffset(40L);
        ART_JNI_ENTRY_OFFSET.setOffset(32L);
        ART_ACCESS_FLAG_OFFSET.setOffset(4L);
        return;
      case 24: 
      case 25: 
        ART_QUICK_CODE_OFFSET.setOffset(48L);
        ART_JNI_ENTRY_OFFSET.setOffset(40L);
        ART_ACCESS_FLAG_OFFSET.setOffset(4L);
        return;
      case 23: 
        ART_QUICK_CODE_OFFSET.setOffset(48L);
        ART_JNI_ENTRY_OFFSET.setOffset(40L);
        ART_ACCESS_FLAG_OFFSET.setOffset(12L);
        return;
      case 22: 
        ART_QUICK_CODE_OFFSET.setOffset(52L);
        ART_JNI_ENTRY_OFFSET.setOffset(44L);
        ART_ACCESS_FLAG_OFFSET.setOffset(20L);
        return;
      case 21: 
        ART_QUICK_CODE_OFFSET.setOffset(40L);
        ART_QUICK_CODE_OFFSET.setLength(BitWidth.QWORD);
        ART_JNI_ENTRY_OFFSET.setOffset(32L);
        ART_JNI_ENTRY_OFFSET.setLength(BitWidth.QWORD);
        ART_ACCESS_FLAG_OFFSET.setOffset(56L);
        return;
      }
      ART_QUICK_CODE_OFFSET.setOffset(32L);
      ART_ACCESS_FLAG_OFFSET.setOffset(28L);
      return;
    }
    ART_QUICK_CODE_OFFSET.setLength(BitWidth.DWORD);
    ART_JNI_ENTRY_OFFSET.setLength(BitWidth.DWORD);
    switch (i)
    {
    case 20: 
    default: 
      throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
    case 26: 
    case 27: 
      ART_QUICK_CODE_OFFSET.setOffset(28L);
      ART_JNI_ENTRY_OFFSET.setOffset(24L);
      ART_ACCESS_FLAG_OFFSET.setOffset(4L);
      return;
    case 24: 
    case 25: 
      ART_QUICK_CODE_OFFSET.setOffset(32L);
      ART_JNI_ENTRY_OFFSET.setOffset(28L);
      ART_ACCESS_FLAG_OFFSET.setOffset(4L);
      return;
    case 23: 
      ART_QUICK_CODE_OFFSET.setOffset(36L);
      ART_JNI_ENTRY_OFFSET.setOffset(32L);
      ART_ACCESS_FLAG_OFFSET.setOffset(12L);
      return;
    case 22: 
      ART_QUICK_CODE_OFFSET.setOffset(44L);
      ART_JNI_ENTRY_OFFSET.setOffset(40L);
      ART_ACCESS_FLAG_OFFSET.setOffset(20L);
      return;
    case 21: 
      ART_QUICK_CODE_OFFSET.setOffset(40L);
      ART_QUICK_CODE_OFFSET.setLength(BitWidth.QWORD);
      ART_JNI_ENTRY_OFFSET.setOffset(32L);
      ART_JNI_ENTRY_OFFSET.setLength(BitWidth.QWORD);
      ART_ACCESS_FLAG_OFFSET.setOffset(56L);
      return;
    }
    ART_QUICK_CODE_OFFSET.setOffset(32L);
    ART_ACCESS_FLAG_OFFSET.setOffset(28L);
  }
  
  public static long read(long paramLong, Offset paramOffset)
  {
    byte[] arrayOfByte = EpicNative.get(paramLong + paramOffset.offset, paramOffset.length.width);
    if (paramOffset.length == BitWidth.DWORD) {
      return ByteBuffer.wrap(arrayOfByte).order(ByteOrder.LITTLE_ENDIAN).getInt() & 0xFFFFFFFF;
    }
    return ByteBuffer.wrap(arrayOfByte).order(ByteOrder.LITTLE_ENDIAN).getLong();
  }
  
  public static void write(long paramLong1, Offset paramOffset, long paramLong2)
  {
    long l = paramOffset.offset;
    if (paramOffset.length == BitWidth.DWORD) {
      if (paramLong2 > 4294967295L) {
        throw new IllegalStateException("overflow may occur");
      }
    }
    for (paramOffset = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt((int)paramLong2).array();; paramOffset = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(paramLong2).array())
    {
      EpicNative.put(paramOffset, paramLong1 + l);
      return;
    }
  }
  
  public BitWidth getLength()
  {
    return this.length;
  }
  
  public long getOffset()
  {
    return this.offset;
  }
  
  public void setLength(BitWidth paramBitWidth)
  {
    this.length = paramBitWidth;
  }
  
  public void setOffset(long paramLong)
  {
    this.offset = paramLong;
  }
  
  private static enum BitWidth
  {
    DWORD(4),  QWORD(8);
    
    int width;
    
    private BitWidth(int paramInt)
    {
      this.width = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.weishu.epic.art.method.Offset
 * JD-Core Version:    0.7.0.1
 */