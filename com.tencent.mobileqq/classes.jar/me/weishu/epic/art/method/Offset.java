package me.weishu.epic.art.method;

import android.os.Build.VERSION;
import com.taobao.android.dexposed.utility.Logger;
import com.taobao.android.dexposed.utility.Runtime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import me.weishu.epic.art.EpicNative;

class Offset
{
  static Offset ART_ACCESS_FLAG_OFFSET;
  static Offset ART_JNI_ENTRY_OFFSET;
  static Offset ART_QUICK_CODE_OFFSET;
  private static final String TAG = "Offset";
  private Offset.BitWidth length;
  private long offset;
  
  static {}
  
  private static void initFields()
  {
    ART_QUICK_CODE_OFFSET = new Offset();
    ART_ACCESS_FLAG_OFFSET = new Offset();
    ART_JNI_ENTRY_OFFSET = new Offset();
    ART_ACCESS_FLAG_OFFSET.setLength(Offset.BitWidth.DWORD);
    int i = Build.VERSION.SDK_INT;
    if (Runtime.is64Bit())
    {
      ART_QUICK_CODE_OFFSET.setLength(Offset.BitWidth.QWORD);
      ART_JNI_ENTRY_OFFSET.setLength(Offset.BitWidth.QWORD);
      switch (i)
      {
      case 20: 
      default: 
        throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
      case 28: 
      case 29: 
        ART_QUICK_CODE_OFFSET.setOffset(32L);
        ART_JNI_ENTRY_OFFSET.setOffset(24L);
        ART_ACCESS_FLAG_OFFSET.setOffset(4L);
      }
    }
    for (;;)
    {
      Logger.i("Offset", "quick code offset: " + ART_QUICK_CODE_OFFSET.getOffset());
      Logger.i("Offset", "access flag offset: " + ART_ACCESS_FLAG_OFFSET.getOffset());
      Logger.i("Offset", "jni code offset: " + ART_JNI_ENTRY_OFFSET.getOffset());
      return;
      ART_QUICK_CODE_OFFSET.setOffset(40L);
      ART_JNI_ENTRY_OFFSET.setOffset(32L);
      ART_ACCESS_FLAG_OFFSET.setOffset(4L);
      continue;
      ART_QUICK_CODE_OFFSET.setOffset(48L);
      ART_JNI_ENTRY_OFFSET.setOffset(40L);
      ART_ACCESS_FLAG_OFFSET.setOffset(4L);
      continue;
      ART_QUICK_CODE_OFFSET.setOffset(48L);
      ART_JNI_ENTRY_OFFSET.setOffset(40L);
      ART_ACCESS_FLAG_OFFSET.setOffset(12L);
      continue;
      ART_QUICK_CODE_OFFSET.setOffset(52L);
      ART_JNI_ENTRY_OFFSET.setOffset(44L);
      ART_ACCESS_FLAG_OFFSET.setOffset(20L);
      continue;
      ART_QUICK_CODE_OFFSET.setOffset(40L);
      ART_QUICK_CODE_OFFSET.setLength(Offset.BitWidth.QWORD);
      ART_JNI_ENTRY_OFFSET.setOffset(32L);
      ART_JNI_ENTRY_OFFSET.setLength(Offset.BitWidth.QWORD);
      ART_ACCESS_FLAG_OFFSET.setOffset(56L);
      continue;
      ART_QUICK_CODE_OFFSET.setOffset(32L);
      ART_ACCESS_FLAG_OFFSET.setOffset(28L);
      continue;
      ART_QUICK_CODE_OFFSET.setLength(Offset.BitWidth.DWORD);
      ART_JNI_ENTRY_OFFSET.setLength(Offset.BitWidth.DWORD);
      switch (i)
      {
      case 20: 
      default: 
        throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
      case 28: 
      case 29: 
        ART_QUICK_CODE_OFFSET.setOffset(24L);
        ART_JNI_ENTRY_OFFSET.setOffset(20L);
        ART_ACCESS_FLAG_OFFSET.setOffset(4L);
        break;
      case 26: 
      case 27: 
        ART_QUICK_CODE_OFFSET.setOffset(28L);
        ART_JNI_ENTRY_OFFSET.setOffset(24L);
        ART_ACCESS_FLAG_OFFSET.setOffset(4L);
        break;
      case 24: 
      case 25: 
        ART_QUICK_CODE_OFFSET.setOffset(32L);
        ART_JNI_ENTRY_OFFSET.setOffset(28L);
        ART_ACCESS_FLAG_OFFSET.setOffset(4L);
        break;
      case 23: 
        ART_QUICK_CODE_OFFSET.setOffset(36L);
        ART_JNI_ENTRY_OFFSET.setOffset(32L);
        ART_ACCESS_FLAG_OFFSET.setOffset(12L);
        break;
      case 22: 
        ART_QUICK_CODE_OFFSET.setOffset(44L);
        ART_JNI_ENTRY_OFFSET.setOffset(40L);
        ART_ACCESS_FLAG_OFFSET.setOffset(20L);
        break;
      case 21: 
        ART_QUICK_CODE_OFFSET.setOffset(40L);
        ART_QUICK_CODE_OFFSET.setLength(Offset.BitWidth.QWORD);
        ART_JNI_ENTRY_OFFSET.setOffset(32L);
        ART_JNI_ENTRY_OFFSET.setLength(Offset.BitWidth.QWORD);
        ART_ACCESS_FLAG_OFFSET.setOffset(56L);
        break;
      case 19: 
        ART_QUICK_CODE_OFFSET.setOffset(32L);
        ART_ACCESS_FLAG_OFFSET.setOffset(28L);
      }
    }
  }
  
  public static long read(long paramLong, Offset paramOffset)
  {
    byte[] arrayOfByte = EpicNative.get(paramOffset.offset + paramLong, paramOffset.length.width);
    if (paramOffset.length == Offset.BitWidth.DWORD) {
      return ByteBuffer.wrap(arrayOfByte).order(ByteOrder.LITTLE_ENDIAN).getInt() & 0xFFFFFFFF;
    }
    return ByteBuffer.wrap(arrayOfByte).order(ByteOrder.LITTLE_ENDIAN).getLong();
  }
  
  public static void write(long paramLong1, Offset paramOffset, long paramLong2)
  {
    long l = paramOffset.offset;
    if (paramOffset.length == Offset.BitWidth.DWORD) {
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
  
  public Offset.BitWidth getLength()
  {
    return this.length;
  }
  
  public long getOffset()
  {
    return this.offset;
  }
  
  public void setLength(Offset.BitWidth paramBitWidth)
  {
    this.length = paramBitWidth;
  }
  
  public void setOffset(long paramLong)
  {
    this.offset = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.epic.art.method.Offset
 * JD-Core Version:    0.7.0.1
 */