package me.weishu.epic.art.arch;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class ShellCode
{
  static void writeInt(int paramInt1, ByteOrder paramByteOrder, byte[] paramArrayOfByte, int paramInt2)
  {
    System.arraycopy(ByteBuffer.allocate(4).order(paramByteOrder).putInt(paramInt1).array(), 0, paramArrayOfByte, paramInt2, 4);
  }
  
  static void writeLong(long paramLong, ByteOrder paramByteOrder, byte[] paramArrayOfByte, int paramInt)
  {
    System.arraycopy(ByteBuffer.allocate(8).order(paramByteOrder).putLong(paramLong).array(), 0, paramArrayOfByte, paramInt, 8);
  }
  
  public byte[] createBridgeJump(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    throw new RuntimeException("not impled");
  }
  
  public byte[] createCallOrigin(long paramLong, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[sizeOfCallOrigin()];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, sizeOfDirectJump());
    System.arraycopy(createDirectJump(toPC(sizeOfDirectJump() + paramLong)), 0, arrayOfByte, sizeOfDirectJump(), sizeOfDirectJump());
    return arrayOfByte;
  }
  
  public abstract byte[] createDirectJump(long paramLong);
  
  public abstract String getName();
  
  public abstract int sizeOfBridgeJump();
  
  public int sizeOfCallOrigin()
  {
    return sizeOfDirectJump() * 2;
  }
  
  public abstract int sizeOfDirectJump();
  
  public abstract long toMem(long paramLong);
  
  public abstract long toPC(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     me.weishu.epic.art.arch.ShellCode
 * JD-Core Version:    0.7.0.1
 */