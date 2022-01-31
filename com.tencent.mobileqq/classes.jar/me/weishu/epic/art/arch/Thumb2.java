package me.weishu.epic.art.arch;

import java.nio.ByteOrder;

public class Thumb2
  extends ShellCode
{
  public byte[] createBridgeJump(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    byte[] arrayOfByte = new byte[60];
    arrayOfByte[0] = -33;
    arrayOfByte[1] = -8;
    arrayOfByte[2] = 48;
    arrayOfByte[3] = -64;
    arrayOfByte[4] = 96;
    arrayOfByte[5] = 69;
    arrayOfByte[6] = 64;
    arrayOfByte[7] = -16;
    arrayOfByte[8] = 25;
    arrayOfByte[9] = -128;
    arrayOfByte[10] = 8;
    arrayOfByte[11] = 72;
    arrayOfByte[12] = -33;
    arrayOfByte[13] = -8;
    arrayOfByte[14] = 40;
    arrayOfByte[15] = -64;
    arrayOfByte[16] = -52;
    arrayOfByte[17] = -8;
    arrayOfByte[19] = -48;
    arrayOfByte[20] = -52;
    arrayOfByte[21] = -8;
    arrayOfByte[22] = 4;
    arrayOfByte[23] = 32;
    arrayOfByte[24] = -52;
    arrayOfByte[25] = -8;
    arrayOfByte[26] = 8;
    arrayOfByte[27] = 48;
    arrayOfByte[28] = 99;
    arrayOfByte[29] = 70;
    arrayOfByte[30] = 5;
    arrayOfByte[31] = 74;
    arrayOfByte[32] = -52;
    arrayOfByte[33] = -8;
    arrayOfByte[34] = 12;
    arrayOfByte[35] = 32;
    arrayOfByte[36] = 74;
    arrayOfByte[37] = 70;
    arrayOfByte[38] = 74;
    arrayOfByte[39] = 70;
    arrayOfByte[40] = -33;
    arrayOfByte[41] = -8;
    arrayOfByte[42] = 4;
    arrayOfByte[43] = -16;
    writeInt((int)paramLong1, ByteOrder.LITTLE_ENDIAN, arrayOfByte, arrayOfByte.length - 16);
    writeInt((int)paramLong2, ByteOrder.LITTLE_ENDIAN, arrayOfByte, arrayOfByte.length - 12);
    writeInt((int)paramLong3, ByteOrder.LITTLE_ENDIAN, arrayOfByte, arrayOfByte.length - 8);
    writeInt((int)paramLong4, ByteOrder.LITTLE_ENDIAN, arrayOfByte, arrayOfByte.length - 4);
    return arrayOfByte;
  }
  
  public byte[] createDirectJump(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = -33;
    arrayOfByte[1] = -8;
    arrayOfByte[3] = -16;
    writeInt((int)paramLong, ByteOrder.LITTLE_ENDIAN, arrayOfByte, arrayOfByte.length - 4);
    return arrayOfByte;
  }
  
  public String getName()
  {
    return "Thumb2";
  }
  
  public int sizeOfBridgeJump()
  {
    return 60;
  }
  
  public int sizeOfDirectJump()
  {
    return 8;
  }
  
  public long toMem(long paramLong)
  {
    return 0xFFFFFFFE & paramLong;
  }
  
  public long toPC(long paramLong)
  {
    return toMem(paramLong) + 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.weishu.epic.art.arch.Thumb2
 * JD-Core Version:    0.7.0.1
 */